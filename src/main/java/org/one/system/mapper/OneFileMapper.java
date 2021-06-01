package org.one.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.one.system.entity.OneFile;

@Mapper
public interface OneFileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OneFile record);

    int insertSelective(OneFile record);

    OneFile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OneFile record);

    int updateByPrimaryKey(OneFile record);
    
    int insertFileTemp(OneFile record);
    
    List<OneFile> getFileTempByContext(String context);
}