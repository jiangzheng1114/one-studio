package org.one.energy.service;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.energy.entity.BProcUnitEntity;

import java.util.List;

public interface BProcUnitService {

    PageInfo<BProcUnitEntity> page(BProcUnitEntity record);

    RespEntity<Boolean> update(BProcUnitEntity record);

    RespEntity<Boolean> add(BProcUnitEntity record);

    RespEntity<Boolean> delete(String id);

    List<BProcUnitEntity> findByProcId(String procId);
}
