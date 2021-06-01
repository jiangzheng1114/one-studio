package org.one.system.service;

import java.util.List;

import org.one.system.entity.OneUser;

import com.github.pagehelper.PageInfo;

public interface OneUserService {
	
	Long addUser(OneUser oneUser);

	Integer checkExistByItem(String item, String itemValue, Long userid);
	
	PageInfo<OneUser> findUsersByPage(OneUser oneUser);
	
	List<OneUser> getAllUsers(OneUser oneUser);
	
	OneUser getUserInfoById(Long id);
	
	void editPassword(OneUser oneUser);
	
    List<Long> selectRolesByUserid(Long userid);
    
    boolean editUser(OneUser oneUser);
    
    boolean deleteBySelections(String selections);
    
    boolean changeStatus(Long id);
	
}
