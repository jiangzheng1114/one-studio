package org.one.energy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.BStandardCode;

import java.util.List;

/**
 * @Entity org.one.energy.entity.BStandardCode
 */
@Mapper
public interface BStandardCodeMapper {

    int deleteByPrimaryKey(String id);

    int insert(BStandardCode record);

    int insertSelective(BStandardCode record);

    BStandardCode selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BStandardCode record);

    int updateByPrimaryKey(BStandardCode record);

    List<BStandardCode> search(String type);
}




