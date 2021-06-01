package org.one.energy.entity;

import org.one.common.base.BaseEntity;

import java.io.Serializable;

/**
 * 
 * @TableName b_admin_area
 */
public class BAdminArea extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8216063990275833917L;

	/**
     * 
     */
    private String code;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String pcode;

    /**
     * 
     */
    private Integer type;

    /**
     * 
     */
    private String fullname;

    /**
     * 
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public String getPcode() {
        return pcode;
    }

    /**
     * 
     */
    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    /**
     * 
     */
    public Integer getType() {
        return type;
    }

    /**
     * 
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * 
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}