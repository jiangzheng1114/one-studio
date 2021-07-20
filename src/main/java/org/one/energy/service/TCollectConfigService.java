package org.one.energy.service;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.energy.entity.TCollectConfig;
import org.one.energy.entity.TEnterpriseInfo;

public interface TCollectConfigService {

    RespEntity<Boolean>
    add(TCollectConfig record);

    RespEntity<Boolean> update(TCollectConfig record);

    RespEntity<Boolean> delete(String id);

    PageInfo<TCollectConfig> page(TCollectConfig record);
}
