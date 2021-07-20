package org.one.energy.service;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.energy.entity.TEnergyEquipment;
import java.util.List;

public interface TEnergyEquipmentService {

    PageInfo<TEnergyEquipment> page(TEnergyEquipment record);

    RespEntity<Boolean> update(TEnergyEquipment record);

    RespEntity<Boolean> add(TEnergyEquipment record);

    RespEntity<Boolean> delete(String id);

    List<TEnergyEquipment> selectAll();
}
