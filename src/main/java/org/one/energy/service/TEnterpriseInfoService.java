package org.one.energy.service;

import com.alibaba.fastjson.JSONObject;
import org.one.common.base.RespEntity;
import org.one.energy.entity.SStandardCode;
import org.one.energy.entity.TEnergyData;
import org.one.energy.entity.TEnterpriseInfo;

import java.util.List;

public interface TEnterpriseInfoService {

    RespEntity<Boolean> add(TEnterpriseInfo record);

    RespEntity<Boolean> update(TEnterpriseInfo record);

    RespEntity<TEnterpriseInfo> getInfo();

    public RespEntity<JSONObject> upload();

}
