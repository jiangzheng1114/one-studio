package org.one.energy.service;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.energy.entity.BEquipmentClassEntity;

import java.util.List;

public interface BEquipmentClassService {
    PageInfo<BEquipmentClassEntity> page(BEquipmentClassEntity record);

    RespEntity<Boolean> update(BEquipmentClassEntity record);

    RespEntity<Boolean> add(BEquipmentClassEntity record);

    RespEntity<Boolean> delete(String id);

    List<BEquipmentClassEntity> findAll();
}
