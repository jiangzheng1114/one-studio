package org.one.energy.mapper2;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.Irealdata;

@Mapper
public interface IrealdataMapper {
    int deleteByPrimaryKey(String ikey);

    int insert(Irealdata record);

    int insertSelective(Irealdata record);

    Irealdata selectByPrimaryKey(String ikey);

    int updateByPrimaryKeySelective(Irealdata record);

    int updateByPrimaryKey(Irealdata record);
    
    List<Irealdata> loadAll();
}