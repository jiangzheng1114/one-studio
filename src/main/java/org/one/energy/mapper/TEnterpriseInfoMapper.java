package org.one.energy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.TEnterpriseInfo;

/**
 * @Entity org.one.energy.entity.TEnterpriseInfo
 */
@Mapper
public interface TEnterpriseInfoMapper {

    int deleteByPrimaryKey(String code);

    int insert(TEnterpriseInfo record);

    int insertSelective(TEnterpriseInfo record);

    TEnterpriseInfo selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(TEnterpriseInfo record);

    int updateByPrimaryKey(TEnterpriseInfo record);

}




