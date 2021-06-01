package org.one.energy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.one.energy.entity.SStandardCode;

import java.util.List;

/**
 * @Entity org.one.energy.entuty.StandardCode
 */
@Mapper
public interface SStandardCodeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SStandardCode record);

    int insertSelective(SStandardCode record);

    SStandardCode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SStandardCode record);

    int updateByPrimaryKey(SStandardCode record);

    List<SStandardCode> search(SStandardCode record);

}




