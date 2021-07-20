package org.one.energy.controller;


import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import org.assertj.core.util.Maps;
import org.json.JSONObject;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.common.HttpsUtil;
import org.one.energy.entity.TEnergyData;
import org.one.energy.entity.TEnterpriseInfo;
import org.one.energy.entity.TRegisterResponse;
import org.one.energy.service.*;
import org.one.energy.task.SyncDataTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import xyz.icrab.common.model.Result;
import xyz.icrab.common.web.annotation.PermissionMode;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final static Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private TRegisterResponseService tRegisterResponseService;

    @Autowired
    private TPlatVersionResponseService tPlatVersionResponseService;

    @Autowired
    private TEnterpriseInfoService tEnterpriseInfoService;

    @Autowired
    private TEnergyDataService tEnergyDataService;


    //省平台设备注册
    @RequestMapping("/submitDate")
    @PermissionMode(PermissionMode.Mode.White)
    public Result<?> submitDate(@RequestBody Map<String, Object> params) throws Exception {

        HttpsUtil httpsUtil = new HttpsUtil();
        Map map = new HashMap();

        // 注册
        map.put("enterpriseCode", params.get("enterpriseCode"));// 企业的统一社会信用代码
        map.put("region", params.get("region"));// 企业所在行政区域的行政区划代码
        String s = new Gson().toJson(map);
        String res = httpsUtil.post((String) params.get("url"), new Gson().toJson(map));
        JSONObject jsonObject = new JSONObject(res);

        TRegisterResponse tRegisterResponse = new TRegisterResponse();
        tRegisterResponse.setResponseCode(String.valueOf(jsonObject.get("responseCode")));
        tRegisterResponse.setResponseMessage(String.valueOf(jsonObject.get("responseMessage")));
        tRegisterResponse.setDeviceId(String.valueOf(jsonObject.get("deviceId")));
        tRegisterResponse.setLoadConfigUrl(String.valueOf(jsonObject.get("loadConfigURL")));
        tRegisterResponse.setLoadDicVersionUrl(String.valueOf(jsonObject.get("loadDicVersionURL")));
        tRegisterResponse.setCenterInfoUrl(String.valueOf(jsonObject.get("centerInfoURL")));
        tRegisterResponse.setCenterDataUrl(String.valueOf(jsonObject.get("centerDataURL")));
        tRegisterResponse.setCenterInfoDownloadUrl(String.valueOf(jsonObject.get("centerInfoDownloadURL")));
        tRegisterResponse.setCenterDataDownloadUrl(String.valueOf(jsonObject.get("centerDataDownloadURL")));
        tRegisterResponse.setUploadTime(String.valueOf(jsonObject.get("uploadTime")));

        tRegisterResponseService.insertSelective(tRegisterResponse);
        return Result.ok(res);
    }

    /*
    平台版本校验
    * */
    @RequestMapping("/versionCheck")
    @PermissionMode(PermissionMode.Mode.White)
    public Result<?> versionCheck(@RequestBody Map<String, Object> params) throws Exception {
        HttpsUtil httpsUtil=new HttpsUtil();
        Map<String,Object> map = new HashMap();
        // 注册
        map.put("deviceId", params.get("deviceId"));// guid
        params.get("loadDicVersionURL");
        String res = httpsUtil.post((String) params.get("loadDicVersionURL"), new Gson().toJson(map));
        JSONObject jsonObject = new JSONObject(res);
        Map<String, Object> param = new HashMap<>();
        param.put("responseCode", jsonObject.get("responseCode"));
        param.put("responseMessage", jsonObject.get("responseMessage"));
        param.put("regVersion", jsonObject.get("regVersion"));
        param.put("dicVersion", jsonObject.get("dicVersion"));

        tPlatVersionResponseService.insertSelective(param);
        return Result.ok(res);
    }

    /**
     * 提供上传基础数据
     * @return
     * @throws Exception
     */
    @RequestMapping("/configData")
    @PermissionMode(PermissionMode.Mode.White)
    public Result<?> configData() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("deviceId", tRegisterResponseService.selectDeviceId().getDeviceId());
        map.put("loadDicVersionURL", tRegisterResponseService.selectDeviceId().getLoadDicVersionUrl());
        map.put("centerInfoURL", tRegisterResponseService.selectDeviceId().getCenterInfoUrl());
        map.put("enterpriseCode", tEnterpriseInfoService.selectEnterpriseCode());
        return Result.ok(map);
    }

  /*  *//**
     * 每天早上八点半上传数据
     * @throws Exception
     *//*
    @Scheduled(cron = "0 30 8 ? * *")
    public void uploadEnergyDataTask() throws Exception {
        String currDay = currDay();
        String afterDay = afterDay();
        List<TEnergyData> energyList=tEnergyDataService.findByTime(currDay,afterDay);
        if (energyList.size()==0){
            return;
        }
        HttpsUtil httpsUtil=new HttpsUtil();
        Map<String,Object> map = new HashMap();
        map.put("deviceId", url().get("deviceId"));// guid
        map.put("enterpriseCode", url().get("enterpriseCode"));// 信用代码
        map.put("data", energyList);// 采集数据
        String res = httpsUtil.post((String) url().get("loadDicVersionURL"), new Gson().toJson(map));
        logger.info("数据已上传成功");
    }*/
    /**
     * 每天早上八点半上传数据
     * @throws Exception
     */
    @Scheduled(cron = "0 30 8 ? * *")
    public void uploadEnergyData() throws Exception {
        RespEntity<JSONObject> resp = new RespEntity<>();
        String currDay = currDay();
        String beforeDay = beforeDay();
        List<TEnergyData> list=new ArrayList<>();
        List<TEnergyData> record=tEnergyDataService.findByTime(beforeDay,currDay);
        if (record.size()==0){
            logger.info("采集数据为空");
        }else {
            if(tEnterpriseInfoService.selectEnterpriseCode() != null) {
                String deviceId = tRegisterResponseService.selectDeviceId().getDeviceId();


                HttpsUtil httpsUtil = new HttpsUtil();
                Map map = new HashMap<String, Object>();
                map.put("enterpriseCode",tEnterpriseInfoService.selectEnterpriseCode());// 企业的统一社会信用代码
                map.put("deviceId", deviceId);//设备id
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                List<com.alibaba.fastjson.JSONObject> jsons = new ArrayList<>();
                for(TEnergyData item : record) {
                    TEnergyData newItem = tEnergyDataService.selectByPrimaryKey(item.getId());
                    if(!newItem.getStatus().equals(2)) { //已上传成功

                        com.alibaba.fastjson.JSONObject json = (com.alibaba.fastjson.JSONObject) com.alibaba.fastjson.JSONObject.toJSON(newItem);
                        if(newItem.getStatDate() != null) {
                            json.put("statDate", sdf.format(newItem.getStatDate()));
                        }
                        list.add(newItem);
                        json.put("uploadDate", sdf.format(new Date()));
                        jsons.add(json);
                    }
                }
                if(jsons.size() <= 0) {
                    resp.setMessage("所选数据全部为已上报数据，请重新选择");
                    resp.setHttpCode(HttpCode.Warn);
                    return;
                }
                map.put("data", jsons);
                String res = httpsUtil.post( tRegisterResponseService.selectDeviceId().getCenterDataUrl(), new Gson().toJson(map));
                logger.info("上传返回信息", JSON.toJSONString(res));
                    JSONObject json = new JSONObject(res);
                    if("0".equals(String.valueOf(json.get("responseCode")))) {
                        updateStatus(record, deviceId, 2);
                        resp.setHttpCode(HttpCode.Success);
                        resp.setMessage("上传成功");
                        resp.setData(json);
                    } else{
                        updateStatus(list, deviceId, 3);
                        resp.setMessage("上传失败");
                        resp.setData(json);
                        resp.setHttpCode(HttpCode.Warn);
                    }
                }


            }

        HttpsUtil httpsUtil=new HttpsUtil();
        Map<String,Object> map = new HashMap();
        map.put("deviceId", url().get("deviceId"));// guid
        map.put("enterpriseCode", url().get("enterpriseCode"));// 信用代码
        map.put("data", record);// 采集数据
        String res = httpsUtil.post((String) url().get("loadDicVersionURL"), new Gson().toJson(map));
        logger.info("数据已上传成功");
    }



    private Map<String, Object> url(){
        Map<String, Object> map = new HashMap<>();
        map.put("deviceId", tRegisterResponseService.selectDeviceId().getDeviceId());
        map.put("loadDicVersionUrl", tRegisterResponseService.selectDeviceId().getLoadDicVersionUrl());
        map.put("centerInfoUrl", tRegisterResponseService.selectDeviceId().getCenterInfoUrl());
        map.put("enterpriseCode", tEnterpriseInfoService.selectEnterpriseCode());

        return map;
    }


    private String currDay(){
        Calendar calendar=Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String day = String.valueOf(calendar.get(Calendar.DATE));
        String currDay=year+"-"+month+"-"+day+" 00:00:00";
        return currDay;
    }

    private String beforeDay(){
        Calendar calendar=Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String day = String.valueOf(calendar.get(Calendar.DATE)-1);
        String beforeDay=year+"-"+month+"-"+day+" 00:00:00";
        return beforeDay;
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
            tEnergyDataService.updateByPrimaryKey(item);
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
       private String uploadEnergyData(String url, String deviceId, List<TEnergyData> list) throws Exception {
           HttpsUtil httpsUtil = new HttpsUtil();
           Map map = new HashMap<String, Object>();
           map.put("enterpriseCode",tEnterpriseInfoService.selectEnterpriseCode());// 企业的统一社会信用代码
           map.put("deviceId", deviceId);//设备id
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           List<com.alibaba.fastjson.JSONObject> jsons = new ArrayList<>();
           for(TEnergyData item : list) {
               TEnergyData newItem = tEnergyDataService.selectByPrimaryKey(item.getId());
               if(!newItem.getStatus().equals(2)) { //已上传成功
                   Integer status = newItem.getStatus();
                   boolean a=newItem.getStatus() != 2;
                   com.alibaba.fastjson.JSONObject json = (com.alibaba.fastjson.JSONObject) com.alibaba.fastjson.JSONObject.toJSON(newItem);
                   if(newItem.getStatDate() != null) {
                       json.put("statDate", sdf.format(newItem.getStatDate()));
                   }
                   json.put("uploadDate", sdf.format(new Date()));
                   jsons.add(json);
               }
           }
           if(jsons.size() <= 0) {
               return "-1";
           }
           map.put("data", jsons);
           String res = httpsUtil.post( url, new Gson().toJson(map));
           return res;
       }

}

