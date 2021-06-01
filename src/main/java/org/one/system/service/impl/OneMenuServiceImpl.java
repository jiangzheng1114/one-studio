package org.one.system.service.impl;

import java.util.List;

import org.one.system.entity.OneMenu;
import org.one.system.mapper.OneMenuMapper;
import org.one.system.service.OneMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class OneMenuServiceImpl implements OneMenuService {
	
	@Autowired
	private OneMenuMapper oneMenuMapper;

	@Override
	public Long addMenu(OneMenu oneMenu) {
		oneMenuMapper.insertSelective(oneMenu);
		return oneMenu.getId();
	}

	@Override
	public PageInfo<OneMenu> findMenusByPage(OneMenu oneMenu) {
		PageHelper.startPage(oneMenu.getPage(), oneMenu.getLimit());
		return new PageInfo<>(oneMenuMapper.findMenusByPage(oneMenu));
	}

	@Override
	public List<OneMenu> findMenuList(OneMenu oneMenu) {
		Page<OneMenu> pages = oneMenuMapper.findMenusByPage(oneMenu);
		return pages.getResult();
	}

	@Override
	public OneMenu findMenuById(Long id) {
		return oneMenuMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<OneMenu> findMenusByUserid(Long userid) {
		return oneMenuMapper.findMenusByUserid(userid);
	}

	@Override
	public Integer checkExistByItem(String item, String itemValue, Long menuid) {
		return oneMenuMapper.countByItem(item, itemValue, menuid);
	}

	@Override
	public boolean editRole(OneMenu oneMenu) {
		return oneMenuMapper.updateByPrimaryKeySelective(oneMenu) > 0;
	}

}
