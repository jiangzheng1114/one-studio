package org.one.system.entity;

import org.one.common.base.BaseEntity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * 角色菜单表
 */
@Table(name = "l_role_menu")
public class RoleMenu  extends BaseEntity {

    /**
     * id
     */
    @Id
    private String id;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 菜单id
     */
    private String menuId;

    /**
     * 全部菜单
     */
    @Transient
    private List<String> menuList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public List<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<String> menuList) {
        this.menuList = menuList;
    }
}
