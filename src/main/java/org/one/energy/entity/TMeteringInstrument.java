package org.one.energy.entity;

import org.one.common.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 计量器具表
 * @TableName t_metering_instrument
 */
public class TMeteringInstrument extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4195016888715442758L;

	/**
     * 惟一主健
     */
    private String id;

    /**
     * 计量器具的简称
     */
    private String meteringName;

    /**
     * 计量器具类型
     */
    private String meteringType;

    /**
     * 器具等级，1：表示进出用能计量器具 2：表示主要次级用能计量器具 3：表示主要用能设备计量器具
     */
    private Integer meteringLevel;

    /**
     * 计量相关参数
     */
    private String meteringParameter;

    /**
     * 所属上报数据组合编码
     */
    private String dataCode;

    /**
     * 与上报数据组合编码算术关系
     */
    private Integer dataCodeCalculate;

    /**
     * 与上报数据组合编码算术系数，1 代表全部，2 代表该计量器具采集的数据跟所属的上报数据组合编码的数值有关
     */
    private Integer dataCodeRatio;

    /**
     * 生产厂家
     */
    private String manuFacturer;

    /**
     * 准确度等级
     */
    private String typeSpecification;

    /**
     * 准确度等级
     */
    private String accuracyLevel;

    /**
     * 测量范围
     */
    private String measureRange;

    /**
     * 管理编号
     */
    private String manageCode;

    /**
     * 检定/校准状态，填写“合格”或者“不合格”
     */
    private String calibrationState;

    /**
     * 
     */
    private String calibrationCycle;

    /**
     * 
     */
    private Date latelyCalibration;

    /**
     * 检验机构
     */
    private String inspectionOrganization;

    /**
     * 下一次检定/校准时间
     */
    private Date nextCalibration;

    /**
     * 未检定/校准原因
     */
    private String notCalibration;

    /**
     * 安装地点
     */
    private String installationSite;

    /**
     * 安装方,1：用能单位 2：能源供应公司 3：第三方公司（指合同能源管理等）
     */
    private Integer installOrg;

    /**
     * 
     */
    private Date installDate;

    /**
     * 接入系统，指该计量器具的监测数据与哪个系统连接。1：表示用能单位自身管理系统 2：表示能源供应公司系统
     */
    private Integer usrSystem;

    /**
     * 目前状态1：正常/2：故障/3：停用
     */
    private Integer measureState;

    /**
     * 状态发生时间
     */
    private Date measureStateDate;

    /**
     * 删除状态（01：未删除；02：已删除）
     */
    private String deleteStatus;

    /**
     * 上报状态（01：未上传；02：已上传; 03:上传失败）
     */
    private String uploadStatus;

    /**
     * 上传时间
     */
    private Date uploadTime;

    /**
     * 惟一主健
     */
    public String getId() {
        return id;
    }

    /**
     * 惟一主健
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 计量器具的简称
     */
    public String getMeteringName() {
        return meteringName;
    }

    /**
     * 计量器具的简称
     */
    public void setMeteringName(String meteringName) {
        this.meteringName = meteringName;
    }

    /**
     * 计量器具类型
     */
    public String getMeteringType() {
        return meteringType;
    }

    /**
     * 计量器具类型
     */
    public void setMeteringType(String meteringType) {
        this.meteringType = meteringType;
    }

    /**
     * 器具等级，1：表示进出用能计量器具 2：表示主要次级用能计量器具 3：表示主要用能设备计量器具
     */
    public Integer getMeteringLevel() {
        return meteringLevel;
    }

    /**
     * 器具等级，1：表示进出用能计量器具 2：表示主要次级用能计量器具 3：表示主要用能设备计量器具
     */
    public void setMeteringLevel(Integer meteringLevel) {
        this.meteringLevel = meteringLevel;
    }

    /**
     * 计量相关参数
     */
    public String getMeteringParameter() {
        return meteringParameter;
    }

    /**
     * 计量相关参数
     */
    public void setMeteringParameter(String meteringParameter) {
        this.meteringParameter = meteringParameter;
    }

    /**
     * 所属上报数据组合编码
     */
    public String getDataCode() {
        return dataCode;
    }

    /**
     * 所属上报数据组合编码
     */
    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    /**
     * 与上报数据组合编码算术关系
     */
    public Integer getDataCodeCalculate() {
        return dataCodeCalculate;
    }

    /**
     * 与上报数据组合编码算术关系
     */
    public void setDataCodeCalculate(Integer dataCodeCalculate) {
        this.dataCodeCalculate = dataCodeCalculate;
    }

    /**
     * 与上报数据组合编码算术系数，1 代表全部，2 代表该计量器具采集的数据跟所属的上报数据组合编码的数值有关
     */
    public Integer getDataCodeRatio() {
        return dataCodeRatio;
    }

    /**
     * 与上报数据组合编码算术系数，1 代表全部，2 代表该计量器具采集的数据跟所属的上报数据组合编码的数值有关
     */
    public void setDataCodeRatio(Integer dataCodeRatio) {
        this.dataCodeRatio = dataCodeRatio;
    }

    /**
     * 生产厂家
     */
    public String getManuFacturer() {
        return manuFacturer;
    }

    /**
     * 生产厂家
     */
    public void setManuFacturer(String manuFacturer) {
        this.manuFacturer = manuFacturer;
    }

    /**
     * 准确度等级
     */
    public String getTypeSpecification() {
        return typeSpecification;
    }

    /**
     * 准确度等级
     */
    public void setTypeSpecification(String typeSpecification) {
        this.typeSpecification = typeSpecification;
    }

    /**
     * 准确度等级
     */
    public String getAccuracyLevel() {
        return accuracyLevel;
    }

    /**
     * 准确度等级
     */
    public void setAccuracyLevel(String accuracyLevel) {
        this.accuracyLevel = accuracyLevel;
    }

    /**
     * 测量范围
     */
    public String getMeasureRange() {
        return measureRange;
    }

    /**
     * 测量范围
     */
    public void setMeasureRange(String measureRange) {
        this.measureRange = measureRange;
    }

    /**
     * 管理编号
     */
    public String getManageCode() {
        return manageCode;
    }

    /**
     * 管理编号
     */
    public void setManageCode(String manageCode) {
        this.manageCode = manageCode;
    }

    /**
     * 检定/校准状态，填写“合格”或者“不合格”
     */
    public String getCalibrationState() {
        return calibrationState;
    }

    /**
     * 检定/校准状态，填写“合格”或者“不合格”
     */
    public void setCalibrationState(String calibrationState) {
        this.calibrationState = calibrationState;
    }

    /**
     * 
     */
    public String getCalibrationCycle() {
        return calibrationCycle;
    }

    /**
     * 
     */
    public void setCalibrationCycle(String calibrationCycle) {
        this.calibrationCycle = calibrationCycle;
    }

    /**
     * 
     */
    public Date getLatelyCalibration() {
        return latelyCalibration;
    }

    /**
     * 
     */
    public void setLatelyCalibration(Date latelyCalibration) {
        this.latelyCalibration = latelyCalibration;
    }

    /**
     * 检验机构
     */
    public String getInspectionOrganization() {
        return inspectionOrganization;
    }

    /**
     * 检验机构
     */
    public void setInspectionOrganization(String inspectionOrganization) {
        this.inspectionOrganization = inspectionOrganization;
    }

    /**
     * 下一次检定/校准时间
     */
    public Date getNextCalibration() {
        return nextCalibration;
    }

    /**
     * 下一次检定/校准时间
     */
    public void setNextCalibration(Date nextCalibration) {
        this.nextCalibration = nextCalibration;
    }

    /**
     * 未检定/校准原因
     */
    public String getNotCalibration() {
        return notCalibration;
    }

    /**
     * 未检定/校准原因
     */
    public void setNotCalibration(String notCalibration) {
        this.notCalibration = notCalibration;
    }

    /**
     * 安装地点
     */
    public String getInstallationSite() {
        return installationSite;
    }

    /**
     * 安装地点
     */
    public void setInstallationSite(String installationSite) {
        this.installationSite = installationSite;
    }

    /**
     * 安装方,1：用能单位 2：能源供应公司 3：第三方公司（指合同能源管理等）
     */
    public Integer getInstallOrg() {
        return installOrg;
    }

    /**
     * 安装方,1：用能单位 2：能源供应公司 3：第三方公司（指合同能源管理等）
     */
    public void setInstallOrg(Integer installOrg) {
        this.installOrg = installOrg;
    }

    /**
     * 
     */
    public Date getInstallDate() {
        return installDate;
    }

    /**
     * 
     */
    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    /**
     * 接入系统，指该计量器具的监测数据与哪个系统连接。1：表示用能单位自身管理系统 2：表示能源供应公司系统
     */
    public Integer getUsrSystem() {
        return usrSystem;
    }

    /**
     * 接入系统，指该计量器具的监测数据与哪个系统连接。1：表示用能单位自身管理系统 2：表示能源供应公司系统
     */
    public void setUsrSystem(Integer usrSystem) {
        this.usrSystem = usrSystem;
    }

    /**
     * 目前状态1：正常/2：故障/3：停用
     */
    public Integer getMeasureState() {
        return measureState;
    }

    /**
     * 目前状态1：正常/2：故障/3：停用
     */
    public void setMeasureState(Integer measureState) {
        this.measureState = measureState;
    }

    /**
     * 状态发生时间
     */
    public Date getMeasureStateDate() {
        return measureStateDate;
    }

    /**
     * 状态发生时间
     */
    public void setMeasureStateDate(Date measureStateDate) {
        this.measureStateDate = measureStateDate;
    }

    /**
     * 删除状态（01：未删除；02：已删除）
     */
    public String getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 删除状态（01：未删除；02：已删除）
     */
    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 上报状态（01：未上传；02：已上传; 03:上传失败）
     */
    public String getUploadStatus() {
        return uploadStatus;
    }

    /**
     * 上报状态（01：未上传；02：已上传; 03:上传失败）
     */
    public void setUploadStatus(String uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    /**
     * 上传时间
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * 上传时间
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}