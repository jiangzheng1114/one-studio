package org.one.energy.entity;

import org.one.common.base.BaseEntity;

import java.io.Serializable;

/**
 * 采集数据项表
 * @TableName b_collect_item
 */
public class BCollectItem extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3000497732771132081L;

	/**
     * 采集数据项编码
     */
    private String code;

    /**
     * 采集数据项名称
     */
    private String name;

    /**
     * 上一级指标编码
     */
    private String pcode;

    /**
     * 分类 1 采集数据类型；2 分类编码；3 分类编码+分项编码
     */
    private String type;

    /**
     * 采集数据类型
     */
    private String pclass;

    /**
     * 行业编码
     */
    private String industryCode;

    /**
     * 单位
     */
    private String unit;

    /**
     * 采集数据项编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 采集数据项编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 采集数据项名称
     */
    public String getName() {
        return name;
    }

    /**
     * 采集数据项名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 上一级指标编码
     */
    public String getPcode() {
        return pcode;
    }

    /**
     * 上一级指标编码
     */
    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    /**
     * 分类 1 采集数据类型；2 分类编码；3 分类编码+分项编码
     */
    public String getType() {
        return type;
    }

    /**
     * 分类 1 采集数据类型；2 分类编码；3 分类编码+分项编码
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 采集数据类型
     */
    public String getPclass() {
        return pclass;
    }

    /**
     * 采集数据类型
     */
    public void setPclass(String pclass) {
        this.pclass = pclass;
    }

    /**
     * 行业编码
     */
    public String getIndustryCode() {
        return industryCode;
    }

    /**
     * 行业编码
     */
    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    /**
     * 单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
}