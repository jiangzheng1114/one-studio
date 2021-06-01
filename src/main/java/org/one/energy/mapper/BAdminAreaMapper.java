package org.one.energy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.BAdminArea;

import java.util.List;

/**
 * @Entity org.one.energy.entity.BAdminArea
 */
@Mapper
public interface BAdminAreaMapper {

    int deleteByPrimaryKey(String code);

    int insert(BAdminArea record);

    int insertSelective(BAdminArea record);

    BAdminArea selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(BAdminArea record);

    int updateByPrimaryKey(BAdminArea record);

    List<BAdminArea> load();

}




