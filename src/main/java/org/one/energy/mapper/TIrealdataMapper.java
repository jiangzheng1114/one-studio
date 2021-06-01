package org.one.energy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.one.energy.entity.TIrealdata;

@Mapper
public interface TIrealdataMapper {
    int deleteByPrimaryKey(String id);

    int insert(TIrealdata record);

    int insertSelective(TIrealdata record);

    TIrealdata selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TIrealdata record);

    int updateByPrimaryKey(TIrealdata record);
    
    TIrealdata getByIkeyAndDatadate(@Param("ikey") String ikey, @Param("datadate") String datadate);
}