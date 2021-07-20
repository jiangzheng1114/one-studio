package org.one.energy.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.common.HttpsUtil;
import org.one.energy.entity.TEnergyData;
import org.one.energy.entity.TEnterpriseInfo;
import org.one.energy.mapper.TEnergyDataMapper;
import org.one.energy.mapper.TEnterpriseInfoMapper;
import org.one.energy.service.TEnergyDataService;
import org.one.energy.service.TRegisterResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.icrab.common.model.Result;
import xyz.icrab.common.model.Status;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class TEnergyDataServiceImpl implements TEnergyDataService {

    private final static Logger logger = LoggerFactory.getLogger(TEnergyDataServiceImpl.class);

    @Autowired
    private TEnergyDataMapper tEnergyDataMapper;

    @Autowired
    private  TEnterpriseInfoMapper tEnterpriseInfoMapper;

    @Autowired
    private TRegisterResponseService tRegisterResponseService;

    @Override
    public PageInfo<TEnergyData> page(TEnergyData record) {
        PageHelper.startPage(record.getPage(), record.getLimit());
        PageInfo<TEnergyData> pageInfo = new PageInfo<>(tEnergyDataMapper.findByPage(record));
        pageInfo.setSize(tEnergyDataMapper.findCount(record));
        return pageInfo;
    }

    @Override
    public RespEntity<JSONObject> upload(List<TEnergyData> record) {
        RespEntity<JSONObject> resp = new RespEntity<>();
        try {
            if(record.size() <= 0) {
                resp.setMessage("所选数据不可为空");
                resp.setHttpCode(HttpCode.Warn);
            } else {
                if(tEnterpriseInfoMapper.selectEnterpriseCode() != null) {
                    String deviceId = tRegisterResponseService.selectDeviceId().getDeviceId();
                    JSONObject res = uploadEnergyData(tRegisterResponseService.selectDeviceId().getCenterDataUrl(),
                            deviceId, record);
                    logger.info("上传返回信息", JSON.toJSONString(res));
                    String resCode = res.get("responseCode").toString();
                    if("0".equals(resCode)) {
                        updateStatus(record, deviceId, 2);
                        resp.setHttpCode(HttpCode.Success);
                        resp.setMessage("上传成功");
                        resp.setData(res);
                    } else if("-1".equals(resCode)) {
                        resp.setMessage("所选数据全部为已上报数据，请重新选择");
                        resp.setHttpCode(HttpCode.Warn);
                    } else{
                        updateStatus(record, deviceId, 3);
                        resp.setMessage("上传失败");
                        resp.setData(res);
                        resp.setHttpCode(HttpCode.Warn);
                    }
                } else {
                    resp.setHttpCode(HttpCode.Warn);
                    resp.setMessage("请先填写企业注册信息");
                }
            }
        } catch (Exception e) {
            logger.error("TEnergyDataServiceImpl.upload:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public RespEntity<Boolean> update(TEnergyData record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            resp.setHttpCode(HttpCode.Success);
            resp.setData(tEnergyDataMapper.updateByPrimaryKey(record)>0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            logger.error("TEnergyDataServiceImpl.update:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public List<TEnergyData> findByTime(String beforeDay,String currDay) {
        return tEnergyDataMapper.findByTime(beforeDay,currDay);
    }

    @Override
    public TEnergyData selectByPrimaryKey(String id) {
        return tEnergyDataMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(TEnergyData item) {
        return tEnergyDataMapper.updateByPrimaryKey(item);
    }

    @Override
    public Result<?> insertSelf(Map<String,Object> params) {
        String msg;
        int i;
        TEnergyData tEnergyData = new TEnergyData();
        tEnergyData.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        tEnergyData.setItemId(String.valueOf(params.get("id")));
        tEnergyData.setDataCode(String.valueOf(params.get("configcode")));
        tEnergyData.setDataName(String.valueOf(params.get("configName")));
        tEnergyData.setDataValue(BigDecimal.valueOf(Double.parseDouble(String.valueOf(params.get("value")))));
        tEnergyData.setInputType(Integer.parseInt(String.valueOf(params.get("inputType"))));
        tEnergyData.setStatType(Integer.parseInt(String.valueOf(params.get("statType"))));
        tEnergyData.setStatDate(getNow());
        tEnergyData.setScope(Integer.parseInt(String.valueOf(params.get("scope"))));
        tEnergyData.setStatus(1);
        tEnergyData.setUploadDate(afterDay());
        tEnergyData.setRecordType(1);
        tEnergyData.setUnit(String.valueOf(params.get("unit")));
        tEnergyData.setDeviceId(tRegisterResponseService.selectDeviceId().getDeviceId());
        tEnergyData.setEnterpriseCode(tEnterpriseInfoMapper.selectEnterpriseCode());

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataDate = sdf.format(date);
        if("0".equals(String.valueOf(params.get("statType")))){
                 i = tEnergyDataMapper.insertSelf(tEnergyData);
        }else if("1".equals(String.valueOf(params.get("statType")))){
            params.put("dataDate",dataDate);
            int num=tEnergyDataMapper.findOnlyOne(params);
            if(num==0){
                 i = tEnergyDataMapper.insertSelf(tEnergyData);
                return Result.ok();
            }else {
                return Result.ok("已采集，请勿重复添加");
            }

        } else if("2".equals(String.valueOf(params.get("statType")))){
            params.put("dataDate",dataDate.substring(0,7));
            int num=tEnergyDataMapper.findOnlyOne(params);
            if(num==0){
                i = tEnergyDataMapper.insertSelf(tEnergyData);
            }else {
                return Result.ok("已采集，请勿重复添加");
            }

        } else if("3".equals(String.valueOf(params.get("statType")))){
            params.put("dataDate",dataDate.substring(0,4));
            int num=tEnergyDataMapper.findOnlyOne(params);
            if(num==0){
                i = tEnergyDataMapper.insertSelf(tEnergyData);
            }else {
                return Result.ok("已采集，请勿重复添加");
            }
        }

        return Result.ok();
    }


    @Override
    public String sumEnergyUse(List ikeys, String startTime, String endTime) {
        return tEnergyDataMapper.sumEnergyUse(ikeys,startTime,endTime);
    }

    /**
     * 更新数据上传状态
     * @param record
     * @param deviceId
     * @param status
     */
    private void updateStatus(List<TEnergyData> record, String deviceId, int status) {
        for(TEnergyData item : record) {
            item.setDeviceId(deviceId);
            item.setStatus(status);
            item.setUploadDate(new Date());
            tEnergyDataMapper.updateByPrimaryKey(item);
        }
    }

    /**
     * 上传采集数据
     * @param url
     * @param deviceId
     * @param list
     * @return
     * @throws Exception
     */
    private JSONObject uploadEnergyData(String url, String deviceId, List<TEnergyData> list) throws Exception {
        HttpsUtil httpsUtil = new HttpsUtil();
        Map map = new HashMap<String, Object>();
        map.put("enterpriseCode",tEnterpriseInfoMapper.selectEnterpriseCode());// 企业的统一社会信用代码
        map.put("deviceId", deviceId);//设备id
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<JSONObject> jsons = new ArrayList<>();
        for(TEnergyData item : list) {
            TEnergyData newItem = tEnergyDataMapper.selectByPrimaryKey(item.getId());
            if(newItem.getStatus() != 2) { //已上传成功
                JSONObject json = (JSONObject) JSONObject.toJSON(newItem);
                if(newItem.getStatDate() != null) {
                    json.put("statDate", sdf.format(newItem.getStatDate()));
                }
                json.put("uploadDate", sdf.format(new Date()));
                jsons.add(json);
            }
        }
        if(jsons.size() <= 0) {
            JSONObject error = new JSONObject();
            error.put("responseCode", "-1");
            return error;
        }
        map.put("data", jsons);
        String res = httpsUtil.post( url, new Gson().toJson(map));
        return JSON.parseObject(res);
    }


    /**
     * 获得明天时间
     * @return
     * @throws ParseException
     */
    private Date afterDay() {
        Calendar calendar=Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String day = String.valueOf(calendar.get(Calendar.DATE)+1);
        String afterDay=year+"-"+month+"-"+day+" 08:30:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(afterDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private Date getNow() {
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = null;
        try {
            now = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return now;
    }
}
