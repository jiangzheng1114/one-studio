package org.one.system.entity;

import java.util.Date;

import org.one.common.base.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OneUser extends BaseEntity {

	private static final long serialVersionUID = 4291824610445511741L;

	private Long id;

	private String username;

	private String password;

	private String salt;

	private String truename;

	private String truenamepinyin;

	private String nickname;

	private String nicknamepinyin;

	private Integer sex;

	private String position;

	private String telphone;

	private String email;

	private String idcard;

	private String headimg;

	private Integer type;

	private Integer status;

	private Long createid;

	private Date createtime;

	private Long updateid;

	private Date updatetime;
	
	private Long deptid;
	
	private String deptname;
	
	private String roleids;
	
	private String rolenames;
	
	private String oldpwd;
	
	private String newpwd;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt == null ? null : salt.trim();
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename == null ? null : truename.trim();
	}

	public String getTruenamepinyin() {
		return truenamepinyin;
	}

	public void setTruenamepinyin(String truenamepinyin) {
		this.truenamepinyin = truenamepinyin == null ? null : truenamepinyin.trim();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	public String getNicknamepinyin() {
		return nicknamepinyin;
	}

	public void setNicknamepinyin(String nicknamepinyin) {
		this.nicknamepinyin = nicknamepinyin == null ? null : nicknamepinyin.trim();
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position == null ? null : position.trim();
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone == null ? null : telphone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard == null ? null : idcard.trim();
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg == null ? null : headimg.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public Long getDeptid() {
		return deptid;
	}

	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getRoleids() {
		return roleids;
	}

	public void setRoleids(String roleids) {
		this.roleids = roleids;
	}

	public String getRolenames() {
		return rolenames;
	}

	public void setRolenames(String rolenames) {
		this.rolenames = rolenames;
	}
	
	public String getOldpwd() {
		return oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
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

	public enum Type {

		SuperAdmin("超级管理员", 0), Admin("管理员", 1), Employee("普通员工", 2);

		private String name;
		private int code;

		private Type(String name, int code) {
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

	public enum Sex {

		Man("男", 1), Woman("女", 2);

		private String name;
		private int code;

		private Sex(String name, int code) {
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