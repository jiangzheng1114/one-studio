package org.one.system.entity;

public class OneUserRole {
    private Long id;

    private Long userid;

    private Long roleid;
    
    public OneUserRole() {
		super();
	}

	public OneUserRole(Long userid, Long roleid) {
		super();
		this.userid = userid;
		this.roleid = roleid;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }
}