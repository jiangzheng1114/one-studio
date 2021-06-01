package org.one.system.service;

import java.util.List;

import org.one.system.entity.OneMenu;

import com.github.pagehelper.PageInfo;

public interface OneMenuService {

	Long addMenu(OneMenu oneMenu);
	
	PageInfo<OneMenu> findMenusByPage(OneMenu oneMenu);
	
	List<OneMenu> findMenuList(OneMenu oneMenu);
	
	OneMenu findMenuById(Long id);
	
	List<OneMenu> findMenusByUserid(Long userid);
	
	Integer checkExistByItem(String item, String itemValue, Long menuid);
	
	boolean editRole(OneMenu oneMenu);
	
}
