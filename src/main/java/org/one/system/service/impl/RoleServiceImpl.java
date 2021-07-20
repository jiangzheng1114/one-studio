package org.one.system.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.one.system.entity.Role;
import org.one.system.mapper.RoleMapper;
import org.one.system.mapper.RoleMenuMapper;
import org.one.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;
    
    @Override
    public PageInfo<Role> getPage(Role role) {
        PageHelper.startPage(role.getPage(), role.getLimit());
        PageInfo<Role> pageInfo = new PageInfo<>(roleMapper.infoPage(role));
        pageInfo.setSize(roleMapper.findCount(role));
        return pageInfo;
    }

    @Override
    public Role getRoleByUserId(Map<String, Object> map1) {
        return roleMapper.getRoleByUserId(map1);
    }


    @Override
    public boolean deleteBySelections(String selections) {
        String[] ids = selections.split(",");
        for(String id: ids) {
            Role role = new Role();
            role.setId(id);
            role.setState(2);
            roleMenuMapper.deleteByRoleId(id);
//            roleMapper.updateByPrimaryKeySelective(role);
        }
        return true;
    }

    @Override
    public boolean editRole(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
        roleMenuMapper.deleteByRoleId(role.getId());
        return true;
    }

    @Override
    public List<Role> findByRoleName(Map<String, Object> map) {
        return roleMapper.findByRoleName(map);
    }

    @Override
    public void save(Role role) {
        roleMapper.save(role);
    }


}
