package org.one.system.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.one.common.base.code.ApplyCode;
import org.one.common.util.Pinyin4jUtil;
import org.one.system.entity.OneUser;
import org.one.system.entity.OneUserDept;
import org.one.system.entity.OneUserRole;
import org.one.system.mapper.OneUserDeptMapper;
import org.one.system.mapper.OneUserMapper;
import org.one.system.mapper.OneUserRoleMapper;
import org.one.system.service.OneUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class OneUserServiceImpl implements OneUserService {
	
	@Autowired
	private OneUserMapper oneUserMapper;
	
	@Autowired
	private OneUserDeptMapper oneUserDeptMapper;
	
	@Autowired
	private OneUserRoleMapper oneUserRoleMapper;

	@Override
	public Long addUser(OneUser oneUser) {
		//设置密码，初始密码为加密后的123456
		String salt = String.valueOf(System.currentTimeMillis());
		Object obj = new SimpleHash(ApplyCode.ALGORITHMNAME, ApplyCode.FIRSTPWD, ByteSource.Util.bytes(salt),
				ApplyCode.ITERATIONS);
		oneUser.setPassword(obj.toString());
		oneUser.setSalt(salt);
		//真实姓名转拼音
		if(StringUtils.isNotBlank(oneUser.getTruename())) {
			String truenamepinyin = Pinyin4jUtil.converterToSpell(oneUser.getTruename());
			oneUser.setTruenamepinyin(truenamepinyin);
		}
		//昵称转拼音
		if(StringUtils.isNotBlank(oneUser.getNickname())) {
			String nicknamepinyin = Pinyin4jUtil.converterToSpell(oneUser.getNickname());
			oneUser.setNicknamepinyin(nicknamepinyin);
		}
		//执行增加
		oneUserMapper.insertSelective(oneUser);
		Long userid = oneUser.getId();
		//插入部门关系
		if(oneUser.getDeptid() != null) {
			OneUserDept oneUserDept = new OneUserDept(userid, oneUser.getDeptid());
			oneUserDeptMapper.insertSelective(oneUserDept);
		}
		//插入角色关系
		if(StringUtils.isNoneBlank(oneUser.getRoleids())) {
			String[] roleids = oneUser.getRoleids().split(",");
			for(String roleid : roleids) {
				OneUserRole oneUserRole = new OneUserRole(userid, Long.parseLong(roleid));
				oneUserRoleMapper.insertSelective(oneUserRole);
			}
		}
		return userid;
	}

	@Override
	public Integer checkExistByItem(String item, String itemValue, Long userid) {
		return oneUserMapper.countByItem(item, itemValue, userid);
	}

	@Override
	public PageInfo<OneUser> findUsersByPage(OneUser oneUser) {
		PageHelper.startPage(oneUser.getPage(), oneUser.getLimit());
		return new PageInfo<>(oneUserMapper.findUsersByPage(oneUser));
	}

	@Override
	public List<OneUser> getAllUsers(OneUser oneUser) {
		return oneUserMapper.findUsersByPage(oneUser);
	}

	@Override
	public OneUser getUserInfoById(Long id) {
		return oneUserMapper.getUserInfoById(id);
	}

	@Override
	public void editPassword(OneUser oneUser) {
		oneUserMapper.updateByPrimaryKeySelective(oneUser);
	}

	@Override
	public List<Long> selectRolesByUserid(Long userid) {
		return oneUserRoleMapper.selectRolesByUserid(userid);
	}

	@Override
	public boolean editUser(OneUser oneUser) {
		//真实姓名转拼音
		if(StringUtils.isNotBlank(oneUser.getTruename())) {
			String truenamepinyin = Pinyin4jUtil.converterToSpell(oneUser.getTruename());
			oneUser.setTruenamepinyin(truenamepinyin);
		}
		//昵称转拼音
		if(StringUtils.isNotBlank(oneUser.getNickname())) {
			String nicknamepinyin = Pinyin4jUtil.converterToSpell(oneUser.getNickname());
			oneUser.setNicknamepinyin(nicknamepinyin);
		}
		//执行编辑
		oneUser.setUsername(null);
		oneUserMapper.updateByPrimaryKeySelective(oneUser);
		Long userid = oneUser.getId();
		//删除该用户角色关系
		oneUserRoleMapper.deleteByUserid(userid);
		//插入角色关系
		if(StringUtils.isNoneBlank(oneUser.getRoleids())) {
			String[] roleids = oneUser.getRoleids().split(",");
			for(String roleid : roleids) {
				OneUserRole oneUserRole = new OneUserRole(userid, Long.parseLong(roleid));
				oneUserRoleMapper.insertSelective(oneUserRole);
			}
		}
		return true;
	}

	@Override
	public boolean deleteBySelections(String selections) {
		String[] ids = selections.split(",");
		for(String id: ids) {
			OneUser oneUser = new OneUser();
			oneUser.setId(Long.parseLong(id));
			oneUser.setStatus(OneUser.Status.Deleted.getCode());
			oneUserMapper.updateByPrimaryKeySelective(oneUser);
		}
		return true;
	}

	@Override
	public boolean changeStatus(Long id) {
		OneUser newUser = new OneUser();
		newUser.setId(id);
		OneUser oneUser = oneUserMapper.selectByPrimaryKey(id);
		if(OneUser.Status.Normal.getCode() == oneUser.getStatus()) {
			newUser.setStatus(OneUser.Status.Disabled.getCode());
		} else {
			newUser.setStatus(OneUser.Status.Normal.getCode());
		}
		oneUserMapper.updateByPrimaryKeySelective(newUser);
		return true;
	}

}
