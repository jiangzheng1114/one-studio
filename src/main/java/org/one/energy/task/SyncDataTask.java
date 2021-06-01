package org.one.energy.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.one.energy.common.HttpsEnergy;
import org.one.energy.entity.Irealdata;
import org.one.energy.entity.Irtu;
import org.one.energy.entity.TIrealdata;
import org.one.energy.mapper2.IrealdataMapper;
import org.one.energy.mapper2.IrtuMapper;
import org.one.energy.service.impl.TEnergyDataServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.one.energy.mapper.TIrealdataMapper;


@Component
public class SyncDataTask {
	
    private final static Logger logger = LoggerFactory.getLogger(SyncDataTask.class);

	@Autowired
	private IrealdataMapper IrealdataMapper;
	
	@Autowired
	private IrtuMapper IrtuMapper;
	
	@Autowired
	private TIrealdataMapper TIrealdataMapper;

	@Scheduled(fixedRate = 60000*10)
    public void testTasks() {
		List<Irealdata> list = IrealdataMapper.loadAll();
		for(Irealdata item : list) {
			String ikey = item.getIkey();
			Irtu irtu = IrtuMapper.selectByPrimaryKey(ikey.split("Pt")[0]);
			
			Date updatetime = item.getIupdatetime();
			int section = getSection(updatetime);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String dataDate = sdf.format(updatetime);
			
			//查看数据库是否有今天的数据，如没有则插入一条
			TIrealdata old = TIrealdataMapper.getByIkeyAndDatadate(ikey, dataDate);
			JSONObject json = new JSONObject();
			if(section == 1 && old == null) {
				logger.info("新增");
				json.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
				json.put("dataDate", dataDate);
				json.put("ikey", ikey);
				json.put("icode", item.getIcode());
				json.put("idesc", item.getIdesc());
				json.put("r"+section, item.getIvalue());
				json.put("irtuno", irtu.getIno());
				json.put("irtuname", irtu.getIcode());
				json.put("irtudesc", irtu.getIdesc());
				TIrealdata tIrealdata = JSON.toJavaObject(json, TIrealdata.class);
				TIrealdataMapper.insertSelective(tIrealdata);
			} else if (old != null) {
				logger.info("编辑"+dataDate +"##" + ikey + "##r"+section+":"+item.getIvalue());
				json.put("id", old.getId());
				json.put("r"+section, item.getIvalue());
				TIrealdata tIrealdata = JSON.toJavaObject(json, TIrealdata.class);
				TIrealdataMapper.updateByPrimaryKeySelective(tIrealdata);
			} else {
				logger.info("无数据");
			}
		}
	}
	
	private int getSection(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String[] timeArr = sdf.format(time).split(":");
        int total = Integer.parseInt(timeArr[0]) * 60 * 60 + Integer.parseInt(timeArr[1]) * 60 + Integer.parseInt(timeArr[2]);
        return total/15/60 + 1;
	}
	
}
