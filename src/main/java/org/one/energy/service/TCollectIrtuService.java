package org.one.energy.service;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.energy.entity.TCollectIrtu;

import java.util.Map;

public interface TCollectIrtuService {
    RespEntity<Boolean> add(TCollectIrtu record);

    RespEntity<Boolean> update(TCollectIrtu record);

    RespEntity<Boolean> delete(String id);

    PageInfo<TCollectIrtu> page(Map<String,Object> params);
}
