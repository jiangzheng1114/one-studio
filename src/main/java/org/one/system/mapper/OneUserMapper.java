package org.one.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.one.system.entity.OneUser;

import com.github.pagehelper.Page;

@Mapper
public interface OneUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OneUser record);

    int insertSelective(OneUser record);

    OneUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OneUser record);

    int updateByPrimaryKey(OneUser record);
    
    OneUser getByUsername(String username);
    
    Page<OneUser> findUsersByPage(OneUser oneUser);
    
    int countByItem(@Param("item") String item, @Param("itemValue") String itemValue, @Param("userid") Long userid);
    
    OneUser getUserInfoById(Long id);
    
}