package org.one.system.entity;

import java.util.Date;

import org.one.common.base.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

public class OneDept extends BaseEntity {
	
	private static final long serialVersionUID = 3586215943935125746L;

	private Long id;

    private String name;

    private String code;

    private Long parentid;

    private Long leaderid;
    
    private String leadername;
    
    private Integer status;

    private String remark;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Long getLeaderid() {
		return leaderid;
	}

	public void setLeaderid(Long leaderid) {
		this.leaderid = leaderid;
	}

	public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getCreateid() {
        return createid;
    }

    public void setCreateid(Long createid) {
        this.createid = createid;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") 
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

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") 
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

	public String getLeadername() {
		return leadername;
	}

	public void setLeadername(String leadername) {
		this.leadername = leadername;
	}

	public enum Status{
		
    	Deleted("删除", 0),
    	Normal("正常", 1), 
		Disabled("禁用", 2);
		
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
    
    /**
	 * 顶级部门默认编码
	 * @author Administrator
	 *
	 */
	public enum DefaultCode {
		/**
		 * 顶级部门默认编码
		 */
		Default("00001", "默认编码"),
		/**
		 * 单级最大编码
		 */
		Max("99999", "最大编码");
		/**
		 * 编码
		 */
		private String code;
		/**
		 * 显示名称
		 */
		private String name;
		
		private DefaultCode(String code, String name) {
			this.code = code;
			this.name = name;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
}