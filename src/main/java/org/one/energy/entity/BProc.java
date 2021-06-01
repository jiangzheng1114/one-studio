package org.one.energy.entity;

import org.one.common.base.BaseEntity;

import java.io.Serializable;

/**
 * 生产工序表 生产工序表，包括基础数据下载和自建的生产工序
 * @TableName b_proc
 */
public class BProc extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8709524348082288676L;

	/**
     * 惟一id
     */
    private String id;

    /**
     * 生产工序编号
     */
    private String code;

    /**
     * 生产工序名称
     */
    private String name;

    /**
     * 所属行业
     */
    private String industrycode;

    /**
     * 数据来源 1省平台下发、2手工录入
     */
    private String datasource;

    /**
     * 状态 1已上报、2未上报
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 选中状态 dataSource是2时，1选中。用于基础数据填报，生产工序（非必填）选择。
     */
    private String checkStatus;

    /**
     * 惟一id
     */
    public String getId() {
        return id;
    }

    /**
     * 惟一id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 生产工序编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 生产工序编号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 生产工序名称
     */
    public String getName() {
        return name;
    }

    /**
     * 生产工序名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 所属行业
     */
    public String getIndustrycode() {
        return industrycode;
    }

    /**
     * 所属行业
     */
    public void setIndustrycode(String industrycode) {
        this.industrycode = industrycode;
    }

    /**
     * 数据来源 1省平台下发、2手工录入
     */
    public String getDatasource() {
        return datasource;
    }

    /**
     * 数据来源 1省平台下发、2手工录入
     */
    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    /**
     * 状态 1已上报、2未上报
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态 1已上报、2未上报
     */
    public void setStatus(String status) {
        this.status = status;
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

    /**
     * 选中状态 dataSource是2时，1选中。用于基础数据填报，生产工序（非必填）选择。
     */
    public String getCheckStatus() {
        return checkStatus;
    }

    /**
     * 选中状态 dataSource是2时，1选中。用于基础数据填报，生产工序（非必填）选择。
     */
    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }
}