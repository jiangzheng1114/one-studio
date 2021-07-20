package org.one.system.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Mapper;
import org.one.system.entity.Role;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper  {

    Page<Role> infoPage(Role role);

    Role getRoleByUserId(Map<String, Object> map1);

    void updateByPrimaryKeySelective(Role role);

    List<Role> findByRoleName(Map<String, Object> map);

    void save(Role role);

    int findCount(Role role);
}
