package org.one.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.one.system.entity.OneDept;

import com.github.pagehelper.Page;

@Mapper
public interface OneDeptMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(OneDept record);

    int insertSelective(OneDept record);

    OneDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OneDept record);

    int updateByPrimaryKey(OneDept record);
    
    Page<OneDept> findDeptsByPage(OneDept oneDept);
    
    String getMaxCode(String parentCode);
    
}