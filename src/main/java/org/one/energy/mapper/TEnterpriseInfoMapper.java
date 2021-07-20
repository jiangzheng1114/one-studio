package org.one.energy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.one.energy.entity.Enterprise;
import org.one.energy.entity.TEnterpriseInfo;

import java.util.List;

/**
 * @Entity org.one.energy.entity.TEnterpriseInfo
 */
@Mapper
public interface TEnterpriseInfoMapper {

    int deleteByPrimaryKey(String code);

    int insert(TEnterpriseInfo record);

    int insertSelective(TEnterpriseInfo record);

    TEnterpriseInfo selectByPrimaryKey(String code);

    TEnterpriseInfo selectTEnterpriseInfo();

    int updateByPrimaryKeySelective(TEnterpriseInfo record);

    int updateByPrimaryKey(TEnterpriseInfo record);

    String selectEnterpriseCode();

    Enterprise selectCode(String enterpriseCode);

    void setUploadStatus(@Param("code") String code,@Param("uploadStatus") String uploadStatus);

    TEnterpriseInfo findByCode(String code);
}




