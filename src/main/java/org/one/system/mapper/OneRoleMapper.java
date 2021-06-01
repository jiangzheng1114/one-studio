package org.one.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.one.system.entity.OneRole;

import com.github.pagehelper.Page;

@Mapper
public interface OneRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OneRole record);

    int insertSelective(OneRole record);

    OneRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OneRole record);

    int updateByPrimaryKey(OneRole record);
    
    Page<OneRole> findRolesByPage(OneRole record);
    
    int countByItem(@Param("item") String item, @Param("itemValue") String itemValue, @Param("roleid") Long roleid);

}