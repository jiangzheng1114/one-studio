package org.one.energy.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.one.common.base.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 企业能耗指标信息 存储企业的能耗及能效信息
 * @TableName t_energy_data
 */
public class TEnergyData extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6121806165363195451L;

	/**
     * 主键 主键
     */
    private String id;

    /**
     * 采集数据项标识 采集数据项标识
     */
    private String itemId;

    /**
     * 采集数据项编码 采集数据项编码
     */
    private String dataCode;

    /**
     * 采集数据项名称 采集数据项名称
     */
    private String dataName;

    /**
     * 数值 数值
     */
    private BigDecimal dataValue;

    /**
     * 数据采集类型 1 管理信息系统； 2 生产监控管理系统； 3 分布式控制系统；4 现场仪表； 5 手工填报
     */
    private Integer inputType;

    /**
     * 数据采集频率 0 实时； 1 日； 2 月； 3 年
     */
    private Integer statType;

    /**
     * 数据统计时间 数据统计时间
     */
    private Date statDate;

    /**
     * 上传时间 上传时间
     */
    private Date uploadDate;

    /**
     * 数据范围 1 全厂； 2 生产工序； 3 生产工序单元； 4 重点耗能设备
     */
    private Integer scope;

    /**
     * 是否有效 是否有效
     */
    private Boolean valid;

    /**
     * 数据状态 1 未上报；2 已上报；3 上报失败
     */
    private Integer status;

    /**
     * 数据插入方式 数据插入方式 1 手动插入（包含补录）；2 定时任务
     */
    private Integer recordType;

    /**
     * 单位 数值单位
     */
    private String unit;

    /**
     * 记录插入时间 记录插入时间
     */
    private Date insertDate;

    /**
     * 记录更新时间 记录更新时间
     */
    private Date updateDate;

    /**
     * 端设备id 端设备id
     */
    private String deviceId;

    /**
     * 企业统一信用代码 企业统一信用代码
     */
    private String enterpriseCode;

    private Date beginStatDate;

    private Date endStatDate;

    /**
     * 主键 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 主键 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 采集数据项标识 采集数据项标识
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 采集数据项标识 采集数据项标识
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * 采集数据项编码 采集数据项编码
     */
    public String getDataCode() {
        return dataCode;
    }

    /**
     * 采集数据项编码 采集数据项编码
     */
    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    /**
     * 采集数据项名称 采集数据项名称
     */
    public String getDataName() {
        return dataName;
    }

    /**
     * 采集数据项名称 采集数据项名称
     */
    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    /**
     * 数值 数值
     */
    public BigDecimal getDataValue() {
        return dataValue;
    }

    /**
     * 数值 数值
     */
    public void setDataValue(BigDecimal dataValue) {
        this.dataValue = dataValue;
    }

    /**
     * 数据采集类型 1 管理信息系统； 2 生产监控管理系统； 3 分布式控制系统；4 现场仪表； 5 手工填报
     */
    public Integer getInputType() {
        return inputType;
    }

    /**
     * 数据采集类型 1 管理信息系统； 2 生产监控管理系统； 3 分布式控制系统；4 现场仪表； 5 手工填报
     */
    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    /**
     * 数据采集频率 0 实时； 1 日； 2 月； 3 年
     */
    public Integer getStatType() {
        return statType;
    }

    /**
     * 数据采集频率 0 实时； 1 日； 2 月； 3 年
     */
    public void setStatType(Integer statType) {
        this.statType = statType;
    }

    /**
     * 数据统计时间 数据统计时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getStatDate() {
        return statDate;
    }

    /**
     * 数据统计时间 数据统计时间
     */
    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getBeginStatDate() {
        return beginStatDate;
    }

    public void setBeginStatDate(Date beginStatDate) {
        this.beginStatDate = beginStatDate;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getEndStatDate() {
        return endStatDate;
    }

    public void setEndStatDate(Date endStatDate) {
        this.endStatDate = endStatDate;
    }

    /**
     * 上传时间 上传时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getUploadDate() {
        return uploadDate;
    }

    /**
     * 上传时间 上传时间
     */
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    /**
     * 数据范围 1 全厂； 2 生产工序； 3 生产工序单元； 4 重点耗能设备
     */
    public Integer getScope() {
        return scope;
    }

    /**
     * 数据范围 1 全厂； 2 生产工序； 3 生产工序单元； 4 重点耗能设备
     */
    public void setScope(Integer scope) {
        this.scope = scope;
    }

    /**
     * 是否有效 是否有效
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 是否有效 是否有效
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * 数据状态 1 未上报；2 已上报；3 上报失败
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 数据状态 1 未上报；2 已上报；3 上报失败
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 数据插入方式 数据插入方式 1 手动插入（包含补录）；2 定时任务
     */
    public Integer getRecordType() {
        return recordType;
    }

    /**
     * 数据插入方式 数据插入方式 1 手动插入（包含补录）；2 定时任务
     */
    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    /**
     * 单位 数值单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 单位 数值单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 记录插入时间 记录插入时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getInsertDate() {
        return insertDate;
    }

    /**
     * 记录插入时间 记录插入时间
     */
    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    /**
     * 记录更新时间 记录更新时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 记录更新时间 记录更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 端设备id 端设备id
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 端设备id 端设备id
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 企业统一信用代码 企业统一信用代码
     */
    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    /**
     * 企业统一信用代码 企业统一信用代码
     */
    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }
}