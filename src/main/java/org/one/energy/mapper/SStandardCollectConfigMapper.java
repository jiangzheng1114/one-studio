package org.one.energy.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.BCollectItem;
import org.one.energy.entity.BProcUnitEntity;
import org.one.energy.entity.SStandardCollectConfigEntity;

import java.util.List;
import java.util.Map;

@Mapper
public interface SStandardCollectConfigMapper {
    int deleteByPrimaryKey(String id);

    int insert(Map<String,Object> params);

    int updateByPrimaryKeySelective(SStandardCollectConfigEntity record);
}
