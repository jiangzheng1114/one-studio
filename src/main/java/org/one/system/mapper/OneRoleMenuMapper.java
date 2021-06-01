package org.one.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.one.system.entity.OneRoleMenu;

@Mapper
public interface OneRoleMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OneRoleMenu record);

    int insertSelective(OneRoleMenu record);

    OneRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OneRoleMenu record);

    int updateByPrimaryKey(OneRoleMenu record);
    
    int deleteByRoleid(Long roleid);
    
    List<Long> selectMenusByRoleid(Long roleid);
}