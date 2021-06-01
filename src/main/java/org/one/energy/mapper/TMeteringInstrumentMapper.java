package org.one.energy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.TMeteringInstrument;

/**
 * @Entity org.one.energy.entity.TMeteringInstrument
 */
@Mapper
public interface TMeteringInstrumentMapper {

    int deleteByPrimaryKey(String id);

    int insert(TMeteringInstrument record);

    int insertSelective(TMeteringInstrument record);

    TMeteringInstrument selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TMeteringInstrument record);

    int updateByPrimaryKey(TMeteringInstrument record);

}




