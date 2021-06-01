package org.one.system.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.one.common.base.LayPage;
import org.one.system.entity.OneDept;
import org.one.system.entity.OneUserDept;
import org.one.system.mapper.OneDeptMapper;
import org.one.system.mapper.OneUserDeptMapper;
import org.one.system.service.OneDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
@Transactional
public class OneDeptServiceImpl implements OneDeptService {

	@Autowired
	private OneDeptMapper oneDeptMapper;
	
	@Autowired
	private OneUserDeptMapper oneUserDeptMapper;

	@Override
	public LayPage<OneDept> findDeptsByPage(OneDept oneDept) {
		PageHelper.startPage(oneDept.getPage(), oneDept.getLimit());
		return new LayPage<>(oneDeptMapper.findDeptsByPage(oneDept));
	}

	/**
	 * 生成部门编码
	 * @Title: createCode
	 * @param parentId
	 * @return String
	 * @author wangyao
	 */
	public synchronized String createCode(Long parentId) {
		String code = "";
		String parentCode = "";
		if (parentId != null) {
			// 根据上级单位ID获取此单位编码
			parentCode = oneDeptMapper.selectByPrimaryKey(parentId).getCode();
		}
		// 顶级单位默认编码
		String defaultCode = OneDept.DefaultCode.Default.getCode();
		// 根据上级单位编码获取下一级最大的编码
		String maxCode = oneDeptMapper.getMaxCode(parentCode);
		if (StringUtils.isEmpty(maxCode)) {
			// 此上级单位没有下级单位
			code = parentCode + defaultCode;
		} else {
			code = maxCode.substring(0, maxCode.length() - 5)
					+ String.format("%05d", Integer.parseInt(maxCode.substring(maxCode.length() - 5)) + 1);
		}
		return code;
	}

	@Override
	public List<OneDept> getAllDepts() {
		Page<OneDept> pages = oneDeptMapper.findDeptsByPage(null);
		return pages.getResult();
	}

	@Override
	public Long addDept(OneDept oneDept) {
		//生成部门编码
		String code = createCode(oneDept.getParentid());
		oneDept.setCode(code);
		oneDeptMapper.insertSelective(oneDept);
		//获取领导ID，并查看是否有部门，没有的话将其关联
		Long leaderid = oneDept.getLeaderid();
		OneUserDept oneUserDept = new OneUserDept();
		oneUserDept.setUserid(leaderid);
		int count = oneUserDeptMapper.countUserDept(oneUserDept);
		if(count==0) {
			oneUserDept.setDeptid(oneDept.getId());
			oneUserDeptMapper.insertSelective(oneUserDept);
		}
		return oneDept.getId();
	}

}
