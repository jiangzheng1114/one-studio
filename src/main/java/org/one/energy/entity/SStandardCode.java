package org.one.energy.entity;

import org.one.common.base.BaseEntity;

import java.io.Serializable;

/**
 * 标准代码字典信息表
 * @TableName s_standard_code
 */
public class SStandardCode extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8141951460012548466L;

	/**
     * 标识
     */
    private String id;

    /**
     * 所属标准代码分类id
     */
    private String codeTypeId;

    /**
     * 所属标准代码分类编码
     */
    private String codeTypeCode;

    /**
     * 代码值
     */
    private String codeValue;

    /**
     * 代码名称
     */
    private String codeName;

    /**
     * 排序
     */
    private Integer sn;

    /**
     * 备注
     */
    private String remark;

    /**
     * 标识
     */
    public String getId() {
        return id;
    }

    /**
     * 标识
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 所属标准代码分类id
     */
    public String getCodeTypeId() {
        return codeTypeId;
    }

    /**
     * 所属标准代码分类id
     */
    public void setCodeTypeId(String codeTypeId) {
        this.codeTypeId = codeTypeId;
    }

    /**
     * 所属标准代码分类编码
     */
    public String getCodeTypeCode() {
        return codeTypeCode;
    }

    /**
     * 所属标准代码分类编码
     */
    public void setCodeTypeCode(String codeTypeCode) {
        this.codeTypeCode = codeTypeCode;
    }

    /**
     * 代码值
     */
    public String getCodeValue() {
        return codeValue;
    }

    /**
     * 代码值
     */
    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    /**
     * 代码名称
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * 代码名称
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    /**
     * 排序
     */
    public Integer getSn() {
        return sn;
    }

    /**
     * 排序
     */
    public void setSn(Integer sn) {
        this.sn = sn;
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