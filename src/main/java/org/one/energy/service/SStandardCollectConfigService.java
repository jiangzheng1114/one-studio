package org.one.energy.service;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.energy.entity.SStandardCollectConfigEntity;

import java.util.Map;

public interface SStandardCollectConfigService {
    RespEntity<Boolean> update(SStandardCollectConfigEntity record);

    RespEntity<Boolean> add(Map<String,Object> params);

    RespEntity<Boolean> delete(String id);
}
