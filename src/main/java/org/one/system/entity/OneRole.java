package org.one.system.entity;

import java.util.Date;

import org.one.common.base.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OneRole extends BaseEntity {

	private static final long serialVersionUID = 5029207601737073505L;

	private Long id;

    private String name;

    private String remark;

    private Integer status;

    private Long createid;

    private Date createtime;

    private Long updateid;

    private Date updatetime;
    
    private String menuids;
    
    private String menunames;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateid() {
        return createid;
    }

    public void setCreateid(Long createid) {
        this.createid = createid;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") 
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getUpdateid() {
        return updateid;
    }

    public void setUpdateid(Long updateid) {
        this.updateid = updateid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
    
    public String getMenuids() {
		return menuids;
	}

	public void setMenuids(String menuids) {
		this.menuids = menuids;
	}

	public String getMenunames() {
		return menunames;
	}

	public void setMenunames(String menunames) {
		this.menunames = menunames;
	}

	public enum Status {

		Deleted("删除", 0), Normal("正常", 1), Disabled("禁用", 2);

		private String name;
		private int code;

		private Status(String name, int code) {
			this.name = name;
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}
	}
}