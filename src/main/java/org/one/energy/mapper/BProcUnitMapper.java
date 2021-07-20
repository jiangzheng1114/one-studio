package org.one.energy.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.one.common.base.RespEntity;
import org.one.energy.entity.BCollectItem;
import org.one.energy.entity.BProcUnitEntity;

import java.util.List;

@Mapper
public interface BProcUnitMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(BProcUnitEntity record);

    int updateByPrimaryKeySelective(BProcUnitEntity record);

    Page<BProcUnitEntity> findByPage(BProcUnitEntity record);

    int findCount(BProcUnitEntity record);

    List<BProcUnitEntity> findAll(String procId);
}
