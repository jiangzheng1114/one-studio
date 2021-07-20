package org.one.energy.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.one.common.base.RespEntity;
import org.one.energy.entity.TEnergyData;
import org.one.energy.entity.TEnterpriseInfo;
import xyz.icrab.common.model.Result;

import java.util.List;
import java.util.Map;

public interface TEnergyDataService {

    PageInfo<TEnergyData> page(TEnergyData record);

    RespEntity<JSONObject> upload(List<TEnergyData> record);

    RespEntity<Boolean> update(TEnergyData record);

    List<TEnergyData> findByTime(String beforeDay,String currDay);

    TEnergyData selectByPrimaryKey(String id);

    int updateByPrimaryKey(TEnergyData item);

    Result<?> insertSelf(Map<String,Object> params);

    String sumEnergyUse(List ikeys,String startTime,String endTime);
}
