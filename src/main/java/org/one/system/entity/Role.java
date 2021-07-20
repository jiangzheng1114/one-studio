package org.one.system.entity;


import org.one.common.base.BaseEntity;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色表
 */
@Table(name = "t_role")
public class Role extends BaseEntity {
    @Id
    private String id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 备注信息
     */
    private String remake;

    //    启用状态 1- 启用   2- 禁用
    private Integer state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
