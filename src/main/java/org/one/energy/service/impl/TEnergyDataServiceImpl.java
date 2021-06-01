package org.one.energy.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.common.HttpsEnergy;
import org.one.energy.common.HttpsUtil;
import org.one.energy.entity.TEnergyData;
import org.one.energy.mapper.TEnergyDataMapper;
import org.one.energy.service.TEnergyDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class TEnergyDataServiceImpl implements TEnergyDataService {

    private final static Logger logger = LoggerFactory.getLogger(TEnergyDataServiceImpl.class);

    @Autowired
    private TEnergyDataMapper TEnergyDataMapper;

    @Override
    public RespEntity<PageInfo<TEnergyData>> page(TEnergyData record) {
        RespEntity<PageInfo<TEnergyData>> resp = new RespEntity<>();
        try {
            PageHelper.startPage(record.getPage(), record.getLimit());
            resp.setHttpCode(HttpCode.Success);
            resp.setData(new PageInfo<>(TEnergyDataMapper.findByPage(record)));
            resp.setMessage("请求成功");
        } catch (Exception e) {
            logger.error("TEnergyDataServiceImpl.page:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public RespEntity<JSONObject> upload(List<TEnergyData> record) {
        RespEntity<JSONObject> resp = new RespEntity<>();
        try {
            if(record.size() <= 0) {
                resp.setMessage("所选数据不可为空");
                resp.setHttpCode(HttpCode.Warn);
            } else {
                JSONObject info = HttpsEnergy.register();
                logger.error("注册返回信息", JSON.toJSONString(info));
                if("0".equals(info.get("responseCode"))) {
                    String deviceId = info.get("deviceId").toString();
                    JSONObject res = uploadEnergyData(info.get("centerDataURL").toString(),
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
                    resp.setData(info);
                    resp.setHttpCode(HttpCode.Warn);
                    resp.setMessage("注册失败");
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
            resp.setData(TEnergyDataMapper.updateByPrimaryKey(record)>0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            logger.error("TEnergyDataServiceImpl.update:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
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
            TEnergyDataMapper.updateByPrimaryKey(item);
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
        map.put("enterpriseCode", HttpsEnergy.enterpriseCode);// 企业的统一社会信用代码
        map.put("deviceId", deviceId);//设备id
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<JSONObject> jsons = new ArrayList<>();
        for(TEnergyData item : list) {
            TEnergyData newItem = TEnergyDataMapper.selectByPrimaryKey(item.getId());
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
}
