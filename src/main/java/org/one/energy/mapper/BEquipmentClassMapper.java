package org.one.energy.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.one.common.base.RespEntity;
import org.one.energy.entity.BCollectItem;
import org.one.energy.entity.BEquipmentClassEntity;

import java.util.List;

@Mapper
public interface BEquipmentClassMapper {

    int deleteByPrimaryKey(String id);

    int insertSelective(BEquipmentClassEntity record);

    int updateByPrimaryKeySelective(BEquipmentClassEntity record);

    Page<BEquipmentClassEntity> findByPage(BEquipmentClassEntity record);

    int findCount(BEquipmentClassEntity record);

    List<BEquipmentClassEntity> findAll();
}
