package org.one.system.service;

import java.util.List;

import org.one.system.entity.OneRole;

import com.github.pagehelper.PageInfo;

public interface OneRoleService {
	
	Long addRole(OneRole oneRole);
	
	PageInfo<OneRole> findRolesByPage(OneRole oneRole);
	
	List<OneRole> findRoleList(OneRole oneRole);
	
	Integer checkExistByItem(String item, String itemValue, Long roleid);
	
    boolean deleteBySelections(String selections);
    
    boolean changeStatus(Long id);
    
    boolean editRole(OneRole oneRole);
    
    OneRole selectById(Long id);
    
    List<Long> selectMenusByRoleid(Long roleid);

}
