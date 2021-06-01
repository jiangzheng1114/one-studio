package org.one.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.one.system.entity.OneUserRole;

@Mapper
public interface OneUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OneUserRole record);

    int insertSelective(OneUserRole record);

    OneUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OneUserRole record);

    int updateByPrimaryKey(OneUserRole record);
    
    List<Long> selectRolesByUserid(Long userid);
    
    int deleteByUserid(Long userid);
}