package org.one.system.entity;

import org.one.common.base.BaseEntity;

public class OneRoleMenu extends BaseEntity {
	
	private static final long serialVersionUID = 5032859784761169600L;

	private Long id;

    private Long roleid;

    private Long menuid;
    
    public OneRoleMenu() {
		super();
	}

	public OneRoleMenu(Long roleid, Long menuid) {
		super();
		this.roleid = roleid;
		this.menuid = menuid;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }
}