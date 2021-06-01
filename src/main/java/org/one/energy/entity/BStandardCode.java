package org.one.energy.entity;

import org.one.common.base.BaseEntity;

import java.io.Serializable;

/**
 * 基础公共表
 * @TableName b_standard_code
 */
public class BStandardCode extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 589959498685658322L;

	/**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 分类 1:单位类别编码 2:采集系统分类（数据采集来源编码） 3:采集数据项数据用途（能源用途编码）
     */
    private String type;

    /**
     * 备注
     */
    private String remark;

    /**
     * 编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 分类 1:单位类别编码 2:采集系统分类（数据采集来源编码） 3:采集数据项数据用途（能源用途编码）
     */
    public String getType() {
        return type;
    }

    /**
     * 分类 1:单位类别编码 2:采集系统分类（数据采集来源编码） 3:采集数据项数据用途（能源用途编码）
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}