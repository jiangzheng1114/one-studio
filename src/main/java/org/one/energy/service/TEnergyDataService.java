package org.one.energy.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.energy.entity.TEnergyData;

import java.util.List;

public interface TEnergyDataService {

    RespEntity<PageInfo<TEnergyData>> page(TEnergyData record);

    RespEntity<JSONObject> upload(List<TEnergyData> record);

    RespEntity<Boolean> update(TEnergyData record);

}
