package org.one.system.entity;

import java.util.Date;

import org.one.common.base.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OneMenu extends BaseEntity{
	
	private static final long serialVersionUID = -7736806371233727298L;

	private Long id;

    private String name;

    private Integer openway;

    private Integer level;

    private Long icon;

    private Long parentid;

    private String path;

    private String remark;

    private Integer status;

    private Integer sort;

    private Integer deleteable;

    private Long createid;

    private Date createtime;

    private Long updateid;

    private Date updatetime;
    
    private String parentname;

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

    public Integer getOpenway() {
        return openway;
    }

    public void setOpenway(Integer openway) {
        this.openway = openway;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getIcon() {
        return icon;
    }

    public void setIcon(Long icon) {
        this.icon = icon;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getDeleteable() {
        return deleteable;
    }

    public void setDeleteable(Integer deleteable) {
        this.deleteable = deleteable;
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
    
    public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
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
    
    public enum Openway {

		InApp("应用内打开", 1), NewATab("新选项卡打开", 2);

		private String name;
		private int code;

		private Openway(String name, int code) {
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
    
    public enum Level {

		Frist("一级菜单", 1), Second("二级菜单", 2);

		private String name;
		private int code;

		private Level(String name, int code) {
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
    public enum Deleteable {

		NoDelete("不可删除", 0), YesDelete("可删除", 1);

		private String name;
		private int code;

		private Deleteable(String name, int code) {
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