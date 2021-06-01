package org.one.system.entity;

import org.one.common.base.BaseEntity;

public class OneUserDept extends BaseEntity{
     
	private static final long serialVersionUID = 7895861156975555994L;

	private Long id;

    private Long userid;

    private Long deptid;

    private Integer deleteable;
    
    public OneUserDept() {
		super();
	}

	public OneUserDept(Long userid, Long deptid) {
		super();
		this.userid = userid;
		this.deptid = deptid;
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

    public Long getDeptid() {
        return deptid;
    }

    public void setDeptid(Long deptid) {
        this.deptid = deptid;
    }

    public Integer getDeleteable() {
        return deleteable;
    }

    public void setDeleteable(Integer deleteable) {
        this.deleteable = deleteable;
    }
}