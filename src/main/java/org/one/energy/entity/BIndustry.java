package org.one.energy.entity;

import org.one.common.base.BaseEntity;

import java.io.Serializable;

/**
 * 行业信息表
 * @TableName b_industry
 */
public class BIndustry extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1805027931226543719L;

	/**
     * 行业编码
     */
    private String code;

    /**
     * 行业全名
     */
    private String fullname;

    /**
     * 是否能源加工转换行业 是否true：false
     */
    private String jgzh;

    /**
     * 行业名称
     */
    private String name;

    /**
     * 上一级行业编码
     */
    private String pcode;

    /**
     * 行业编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 行业编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 行业全名
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * 行业全名
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * 是否能源加工转换行业 是否true：false
     */
    public String getJgzh() {
        return jgzh;
    }

    /**
     * 是否能源加工转换行业 是否true：false
     */
    public void setJgzh(String jgzh) {
        this.jgzh = jgzh;
    }

    /**
     * 行业名称
     */
    public String getName() {
        return name;
    }

    /**
     * 行业名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 上一级行业编码
     */
    public String getPcode() {
        return pcode;
    }

    /**
     * 上一级行业编码
     */
    public void setPcode(String pcode) {
        this.pcode = pcode;
    }
}