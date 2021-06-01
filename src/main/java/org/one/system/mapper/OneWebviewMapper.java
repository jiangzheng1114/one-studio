package org.one.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.one.system.entity.OneWebview;

@Mapper
public interface OneWebviewMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OneWebview record);

    int insertSelective(OneWebview record);

    OneWebview selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OneWebview record);

    int updateByPrimaryKey(OneWebview record);
    
    List<OneWebview> findList(OneWebview record);
}