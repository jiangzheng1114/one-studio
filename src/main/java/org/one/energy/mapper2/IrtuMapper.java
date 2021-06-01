package org.one.energy.mapper2;

import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.Irtu;

@Mapper
public interface IrtuMapper {
    int deleteByPrimaryKey(String ikey);

    int insert(Irtu record);

    int insertSelective(Irtu record);

    Irtu selectByPrimaryKey(String ikey);

    int updateByPrimaryKeySelective(Irtu record);

    int updateByPrimaryKey(Irtu record);
    
}