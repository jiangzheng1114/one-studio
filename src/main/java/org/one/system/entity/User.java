package org.one.system.entity;

import org.one.common.base.BaseEntity;
import org.one.common.enums.UserType;
import xyz.icrab.common.model.enums.YesOrNo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * @author 周广
 * web 后端管理  用户
 * @since 2018/3/6 22:03
 */
@Table(name = "t_user")
public class User extends BaseEntity {

    @Id
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     * @JsonIgnore 代表不穿给前台
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 门店编码
     */
    private String dealerId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户类型 1 超级管理员 2 系统用户
     */
    private int type;

    /**
     * 启用状态 1-启用  2-禁用
     */
    private int state;
    /**
     * 角色名
     */
    @Transient
    private List<UserRole> userRoleList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }
}
