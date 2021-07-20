package org.one.energy.mapper;

import com.github.pagehelper.Page;
import org.one.energy.entity.TEnergyEquipment;

import java.util.List;

public interface TEnergyEquipmentMapper {

    int insert(TEnergyEquipment record);

    int insertSelective(TEnergyEquipment record);

    TEnergyEquipment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TEnergyEquipment record);

    int updateByPrimaryKey(TEnergyEquipment record);

    Page<TEnergyEquipment> findByPage(TEnergyEquipment record);

    int findCount(TEnergyEquipment record);

    List<TEnergyEquipment> selectAll();

    int delete(String id);
}