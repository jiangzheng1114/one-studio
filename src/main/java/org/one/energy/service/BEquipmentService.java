package org.one.energy.service;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.energy.entity.BEquipmentClassEntity;
import org.one.energy.entity.BEquipmentEntity;

import java.util.List;
import java.util.Map;

public interface BEquipmentService {
    PageInfo<BEquipmentEntity> page(BEquipmentEntity record);

    RespEntity<Boolean> update(Map<String,Object> params);

    RespEntity<Boolean> add(Map<String,Object> params);

    RespEntity<Boolean> delete(String id);

    List<BEquipmentEntity> findAll();

    List<BEquipmentEntity> findByClassCode(Map<String, Object> param);
}
