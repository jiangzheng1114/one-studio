package org.one.system.service;

import com.github.pagehelper.PageInfo;
import org.one.system.entity.OneRole;
import org.one.system.entity.Role;
import org.one.system.entity.User;
import xyz.icrab.common.model.Pageable;
import xyz.icrab.common.model.Pagination;

import java.util.List;
import java.util.Map;

public interface RoleService {
    PageInfo<Role> getPage(Role role);

    Role getRoleByUserId(Map<String, Object> map1);

    boolean deleteBySelections(String selections);

    boolean editRole(Role role);

    List<Role> findByRoleName(Map<String, Object> map);

    void save(Role role);
}
