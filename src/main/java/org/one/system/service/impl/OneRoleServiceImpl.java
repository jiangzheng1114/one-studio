package org.one.system.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.one.system.entity.OneRole;
import org.one.system.entity.OneRoleMenu;
import org.one.system.mapper.OneRoleMapper;
import org.one.system.mapper.OneRoleMenuMapper;
import org.one.system.service.OneRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class OneRoleServiceImpl implements OneRoleService {
	
	@Autowired
	private OneRoleMapper oneRoleMapper;
	
	@Autowired
	private OneRoleMenuMapper oneRoleMenuMapper;

	@Override
	public Long addRole(OneRole oneRole) {
		oneRoleMapper.insertSelective(oneRole);
		Long roleid = oneRole.getId();
		if(StringUtils.isNotBlank(oneRole.getMenuids())) {
			String[] menuids = oneRole.getMenuids().split(",");
			for(String menuid : menuids) {
				OneRoleMenu oneRoleMenu = new OneRoleMenu(roleid, Long.parseLong(menuid));
				oneRoleMenuMapper.insertSelective(oneRoleMenu);
			}
		}
		return roleid;
	}

	@Override
	public PageInfo<OneRole> findRolesByPage(OneRole oneRole) {
		PageHelper.startPage(oneRole.getPage(), oneRole.getLimit());
		return new PageInfo<>(oneRoleMapper.findRolesByPage(oneRole));
	}

	@Override
	public List<OneRole> findRoleList(OneRole oneRole) {
		Page<OneRole> pages = oneRoleMapper.findRolesByPage(oneRole);
		return pages.getResult();
	}

	@Override
	public Integer checkExistByItem(String item, String itemValue, Long roleid) {
		return oneRoleMapper.countByItem(item, itemValue, roleid);
	}

	@Override
	public boolean deleteBySelections(String selections) {
		String[] ids = selections.split(",");
		for(String id: ids) {
			OneRole oneRole = new OneRole();
			oneRole.setId(Long.parseLong(id));
			oneRole.setStatus(OneRole.Status.Deleted.getCode());
			oneRoleMapper.updateByPrimaryKeySelective(oneRole);
		}
		return true;
	}

	@Override
	public boolean changeStatus(Long id) {
		OneRole newRole = new OneRole();
		newRole.setId(id);
		OneRole oneRole = oneRoleMapper.selectByPrimaryKey(id);
		if(OneRole.Status.Normal.getCode() == oneRole.getStatus()) {
			newRole.setStatus(OneRole.Status.Disabled.getCode());
		} else {
			newRole.setStatus(OneRole.Status.Normal.getCode());
		}
		oneRoleMapper.updateByPrimaryKeySelective(newRole);
		return true;
	}

	@Override
	public boolean editRole(OneRole oneRole) {
		//执行编辑
		oneRoleMapper.updateByPrimaryKeySelective(oneRole);
		Long roleid = oneRole.getId();
		//删除该角色对应的所有菜单
		oneRoleMenuMapper.deleteByRoleid(roleid);
		//插入菜单关系
		if(StringUtils.isNotBlank(oneRole.getMenuids())) {
			String[] menuids = oneRole.getMenuids().split(",");
			for(String menuid : menuids) {
				OneRoleMenu oneRoleMenu = new OneRoleMenu(roleid, Long.parseLong(menuid));
				oneRoleMenuMapper.insertSelective(oneRoleMenu);
			}
		}
		return true;
	}

	@Override
	public OneRole selectById(Long id) {
		return oneRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Long> selectMenusByRoleid(Long roleid) {
		return oneRoleMenuMapper.selectMenusByRoleid(roleid);
	}

}
