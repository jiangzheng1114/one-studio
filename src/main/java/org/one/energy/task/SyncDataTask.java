package org.one.energy.task;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.one.energy.entity.*;
import org.one.energy.mapper.TCollectConfigMapper;
import org.one.energy.mapper.TEnergyDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.one.energy.common.HttpsEnergy;
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

	@Autowired
	private TCollectConfigMapper TCollectConfigMapper;

	@Autowired
	private TEnergyDataMapper TEnergyDataMapper;

	@Scheduled(fixedRate = 600000)
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
				tIrealdata.setSection(section);
				tIrealdata.setStatDate(item.getIupdatetime());
				insertEnergyData(tIrealdata);
			} else if (old != null) {
				JSONObject oldJson = (JSONObject) JSONObject.toJSON(old);
				if(oldJson.get("r"+section) == null) {
					logger.info("编辑"+dataDate +"##" + ikey + "##r"+section+":"+item.getIvalue());
					json.put("id", old.getId());
					json.put("r"+section, item.getIvalue());
					TIrealdata tIrealdata = JSON.toJavaObject(json, TIrealdata.class);
					TIrealdataMapper.updateByPrimaryKeySelective(tIrealdata);
					old = TIrealdataMapper.getByIkeyAndDatadate(ikey, dataDate);
					old.setSection(section);
					old.setStatDate(item.getIupdatetime());
					insertEnergyData(old);
				} else {
					logger.info("当前时段已采集数据，无需重复同步");
				}
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

	private void insertEnergyData(TIrealdata tIrealdata){
		try {
			JSONObject json = (JSONObject) JSONObject.toJSON(tIrealdata);
			String ikey = tIrealdata.getIkey();
			List<TCollectConfig> collectConfigs = TCollectConfigMapper.searchByIkey(ikey);
			if(collectConfigs == null) {
				return;
			}
			for(TCollectConfig item : collectConfigs) {
				String statType = item.getStatType();
				int section = tIrealdata.getSection();
				Double val = null;
				if("0".equals(statType)) {//实时
					if(section == 1) {//如果是第一条，则获取前一次统计
						String beforeDay = getBeforeDay(String.valueOf(json.get("dataDate")));
						TIrealdata beforeData = TIrealdataMapper.getByIkeyAndDatadate(ikey, beforeDay);
						if(beforeData != null) {
							double before = Double.parseDouble(String.valueOf(beforeData.getR1()));
							double after = Double.parseDouble(String.valueOf(tIrealdata.getR96()));
							val = after - before;
						}
					} else {//否则直接相减
						double before = Double.parseDouble(String.valueOf(json.get("r"+(section-1))));
						double after = Double.parseDouble(String.valueOf(json.get("r"+section)));
						val = after - before;
					}
					logger.info("实时插入"+val);
				} else if("1".equals(statType)) {//日
					String beforeDay = getBeforeDay(tIrealdata.getDataDate());
					TIrealdata beforeData = TIrealdataMapper.getByIkeyAndDatadate(ikey, beforeDay);
					if(beforeData != null) {
						double before = Double.parseDouble(String.valueOf(beforeData.getR1()));
						double after = Double.parseDouble(String.valueOf(tIrealdata.getR1()));
						val = after - before;
					}
					logger.info("日插入"+val);
				} else if("2".equals(statType)) {//月
					logger.info("月插入，待完善");
				} else if("3".equals(statType)) {//年
					logger.info("年插入，待完善");
				}
				if(val != null) {
					TEnergyData tEnergyData = new TEnergyData();
					tEnergyData.setId(UUID.randomUUID().toString().replaceAll("-", ""));
					tEnergyData.setItemId(item.getId());
					tEnergyData.setDataCode(item.getCode());
					String name = item.getName();
					int i = name.lastIndexOf("-");
					name = name.substring(0, i);
					tEnergyData.setDataName(name);
					tEnergyData.setDataValue(BigDecimal.valueOf(val));
					tEnergyData.setInputType(Integer.parseInt(item.getInputType()));
					tEnergyData.setStatType(Integer.parseInt(statType));
					tEnergyData.setStatDate(tIrealdata.getStatDate());
					tEnergyData.setScope(Integer.parseInt(item.getScope()));
					tEnergyData.setStatus(0);
					tEnergyData.setRecordType(2);
					tEnergyData.setUnit(item.getUnit());
					TEnergyDataMapper.insertSelective(tEnergyData);
				}
			}
		}catch (ParseException e) {

		}
	}

	private String getBeforeDay(String today) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date d = sdf.parse(today);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.DATE, -1);
		return sdf.format(calendar.getTime());
	}

}
