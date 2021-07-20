package org.one.energy.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.BCollectItem;
import org.one.energy.entity.BEquipmentEntity;

import java.util.List;
import java.util.Map;

@Mapper
public interface BEquipmentMapper {

    int deleteByPrimaryKey(String id);

    int insertSelective(Map<String,Object> params);

    int updateByPrimaryKeySelective(Map<String,Object> params);

    Page<BEquipmentEntity> findByPage(BEquipmentEntity record);

    int findCount(BEquipmentEntity record);

    List<BEquipmentEntity> findAll();

    List<BEquipmentEntity> findByClassCode(Map<String, Object> param);
}
