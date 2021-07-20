package org.one.energy.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.TCollectIrtu;

import java.util.List;
import java.util.Map;

@Mapper
public interface TCollectIrtuMapper {

    int deleteByPrimaryKey(String id);

    int insert(TCollectIrtu record);

    int insertSelective(TCollectIrtu record);

    TCollectIrtu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TCollectIrtu record);

    int updateByPrimaryKey(TCollectIrtu record);

    Page<TCollectIrtu> findByPage(Map<String,Object> params);

    int findCount(Map<String,Object> params);
}