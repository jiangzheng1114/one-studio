package org.one.energy.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.common.HttpsEnergy;
import org.one.energy.common.HttpsUtil;
import org.one.energy.entity.TCollectConfig;
import org.one.energy.entity.TEnergyData;
import org.one.energy.entity.TEnterpriseInfo;
import org.one.energy.mapper.TCollectConfigMapper;
import org.one.energy.mapper.TEnterpriseInfoMapper;
import org.one.energy.service.TEnterpriseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TEnterpriseInfoServiceImpl implements TEnterpriseInfoService {

    private final static Logger logger = LoggerFactory.getLogger(TEnterpriseInfoServiceImpl.class);

    @Autowired
    private TEnterpriseInfoMapper TEnterpriseInfoMapper;

    @Autowired
    private TCollectConfigMapper TCollectConfigMapper;

    @Override
    public RespEntity<Boolean> add(TEnterpriseInfo record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            resp.setHttpCode(HttpCode.Success);
            resp.setData(TEnterpriseInfoMapper.insertSelective(record) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            logger.error("TEnterpriseInfoServiceImpl.add:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public RespEntity<Boolean> update(TEnterpriseInfo record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            TEnterpriseInfo info = TEnterpriseInfoMapper.selectByPrimaryKey(HttpsEnergy.enterpriseCode);
            if(info == null) {
                record.setCorporationCode(HttpsEnergy.enterpriseCode);
                resp.setData(TEnterpriseInfoMapper.insertSelective(record) > 0);
            } else {
                resp.setData(TEnterpriseInfoMapper.updateByPrimaryKeySelective(record) > 0);
            }
            resp.setHttpCode(HttpCode.Success);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            logger.error("TEnterpriseInfoServiceImpl.add:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public RespEntity<TEnterpriseInfo> getInfo() {
        RespEntity<TEnterpriseInfo> resp = new RespEntity<>();
        try {
            TEnterpriseInfo info = TEnterpriseInfoMapper.selectByPrimaryKey(HttpsEnergy.enterpriseCode);
            if(info == null) {
                info = new TEnterpriseInfo();
                info.setCode(HttpsEnergy.enterpriseCode);
                info.setRegionCode(HttpsEnergy.region);
            }
            resp.setHttpCode(HttpCode.Success);
            resp.setData(info);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            logger.error("TEnterpriseInfoServiceImpl.getInfo:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public RespEntity<JSONObject> upload() {
        RespEntity<JSONObject> resp = new RespEntity<>();
        try {
            TEnterpriseInfo record = TEnterpriseInfoMapper.selectByPrimaryKey(HttpsEnergy.enterpriseCode);
            if(record == null) {
                resp.setMessage("请先填写并保存用能单位基本信息");
                resp.setHttpCode(HttpCode.Warn);
            } else {
                Page<TCollectConfig> configs = TCollectConfigMapper.findByPage(null);
                if(configs.getResult().size() == 0) {
                    resp.setMessage("采集数据配置不可为空");
                    resp.setHttpCode(HttpCode.Warn);
                } else {
                    JSONObject info = HttpsEnergy.register();
                    logger.error("注册返回信息", JSON.toJSONString(info));
                    if("0".equals(info.get("responseCode"))) {
                        String deviceId = info.get("deviceId").toString();
                        JSONObject res = uploadConfigData(info.get("centerInfoURL").toString(),
                                deviceId, record, configs.getResult());
                        logger.info("上传返回信息", JSON.toJSONString(res));
                        String resCode = res.get("responseCode").toString();
                        if("0".equals(resCode)) {
                            record.setUploadStatus("2");
                            resp.setHttpCode(HttpCode.Success);
                            resp.setMessage("上传成功");
                            resp.setData(res);
                        } else{
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
            }
        } catch (Exception e) {
            logger.error("TEnterpriseInfoServiceImpl.getInfo:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    private JSONObject uploadConfigData(String url, String deviceId, TEnterpriseInfo enterprise, List<TCollectConfig> configs) throws Exception{
        HttpsUtil httpsUtil = new HttpsUtil();
        Map map = new HashMap<String, Object>();
        map.put("enterpriseCode", HttpsEnergy.enterpriseCode);// 企业的统一社会信用代码
        map.put("deviceId", deviceId);//设备id
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //采集数据项配置
        map.put("collectItemConfig", configs);
        //用能单位
        JSONObject json = (JSONObject) JSONObject.toJSON(enterprise);
        if(enterprise.getRegisterDate() != null) {
            json.put("registerDate", sdf.format(enterprise.getRegisterDate()));
        }
        map.put("enterprise", json);
        //集团
        String groupName = enterprise.getGroupName();
        if(StringUtils.isNoneBlank(groupName)) {
            Map group = new HashMap<String, Object>();
            group.put("name", groupName);
            group.put("address", enterprise.getGroupAddress());
            group.put("remark", enterprise.getGroupRemark());
            map.put("group", group);
        }
        String res = httpsUtil.post( url, new Gson().toJson(map));
        return JSON.parseObject(res);
    }

}
