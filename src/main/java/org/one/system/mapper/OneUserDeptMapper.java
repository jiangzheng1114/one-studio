package org.one.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.one.system.entity.OneUserDept;

@Mapper
public interface OneUserDeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OneUserDept record);

    int insertSelective(OneUserDept record);

    OneUserDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OneUserDept record);

    int updateByPrimaryKey(OneUserDept record);
    
    int countUserDept(OneUserDept record);
}