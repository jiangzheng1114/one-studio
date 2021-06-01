package org.one.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.one.system.entity.OneMenu;

import com.github.pagehelper.Page;

@Mapper
public interface OneMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OneMenu record);

    int insertSelective(OneMenu record);

    OneMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OneMenu record);

    int updateByPrimaryKey(OneMenu record);
    
    Page<OneMenu> findMenusByPage(OneMenu record);
    
    List<OneMenu> findMenusByUserid(Long userid);
    
    int countByItem(@Param("item") String item, @Param("itemValue") String itemValue, @Param("menuid") Long menuid);
}