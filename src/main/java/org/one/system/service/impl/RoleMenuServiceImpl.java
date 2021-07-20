package org.one.system.service.impl;


import org.one.system.mapper.RoleMapper;
import org.one.system.mapper.RoleMenuMapper;
import org.one.system.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleMenuServiceImpl  implements RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<String> getRoleMenu(Map<String, Object> param) {
        return roleMenuMapper.getRoleMenu(param);
    }
}
