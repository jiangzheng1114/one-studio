package org.one.energy.service;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.energy.entity.TCollectConfig;
import org.one.energy.entity.TPlatVersionResponse;

import java.util.Map;

public interface TPlatVersionResponseService {

    RespEntity<Boolean> insertSelective(Map<String, Object> param);

    PageInfo<TPlatVersionResponse> page(TPlatVersionResponse record);
}
