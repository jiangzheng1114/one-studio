package org.one.energy.entity;

import org.one.common.base.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 采集数据项配置表 采集数据项配置表，用能单位基础信息上传的采集数据项配置
 * @TableName t_collect_config
 */
public class TCollectConfig extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8550016974266219585L;

	/**]]
     * ID
     */
    private String id;

    /**
     * 采集数据项指标名称 拼接（规则）例乙烯装置-2 号单元-非能源类产品-乙烯-产出
     */
    private String name;

    /**
     * 采集数据项指标编码 拼接（规则）例：02-02-0000-040100-30
     */
    private String code;

    /**
     * 生产工序(必填) scope为1，此为00
     */
    private String processCode;

    /**
     * 生产工序名称process_code名称
     */
    private String processName;

    /**
     * 工序单元(必填) scope为1、2，此为00
     */
    private String processUnitCode;

    /**
     * 重点耗能设备类型(必填) scope为1、2、3，此为00
     */
    private String equipmentCode;

    /**
     * 重点耗能设备编号(必填) scope为1、2、3，此为00
     */
    private String equipmentUnitCode;

    /**
     * 采集对象类型(必填)
     */
    private String energyClassCode;

    /**
     * 能源分类 + 能源分项(必填)
     */
    private String energyTypeCode;

    /**
     * 能源品种(必选)
     */
    private String dataVarieties;

    /**
     * 能源用途(必填)
     */
    private String dataUsageCode;

    /**
     * 数据采集来源编码（必填，10个指标）(12)
     */
    private String inputType;

    /**
     * 数据最小值(非必填）
     */
    private BigDecimal dataValueMin;

    /**
     * 数据最大值(非必填)
     */
    private BigDecimal dataValueMax;

    /**
     * 采集频率（必填）(4)
     */
    private String statType;

    /**
     * 采集系统名称
     */
    private String collectSystemName;

    /**
     * 插入时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 数值单位
     */
    private String unit;

    /**
     * 范围 1：全厂，2：生产工序，3：生产工序单元，4：重点耗能设备  (5)
     */
    private String scope;

    /**
     * 备注
     */
    private String remark;

    /**
     * ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 采集数据项指标名称 拼接（规则）例乙烯装置-2 号单元-非能源类产品-乙烯-产出
     */
    public String getName() {
        return name;
    }

    /**
     * 采集数据项指标名称 拼接（规则）例乙烯装置-2 号单元-非能源类产品-乙烯-产出
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 采集数据项指标编码 拼接（规则）例：02-02-0000-040100-30
     */
    public String getCode() {
        return code;
    }

    /**
     * 采集数据项指标编码 拼接（规则）例：02-02-0000-040100-30
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 生产工序(必填) scope为1，此为00
     */
    public String getProcessCode() {
        return processCode;
    }

    /**
     * 生产工序(必填) scope为1，此为00
     */
    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    /**
     * 生产工序名称process_code名称
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * 生产工序名称process_code名称
     */
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    /**
     * 工序单元(必填) scope为1、2，此为00
     */
    public String getProcessUnitCode() {
        return processUnitCode;
    }

    /**
     * 工序单元(必填) scope为1、2，此为00
     */
    public void setProcessUnitCode(String processUnitCode) {
        this.processUnitCode = processUnitCode;
    }

    /**
     * 重点耗能设备类型(必填) scope为1、2、3，此为00
     */
    public String getEquipmentCode() {
        return equipmentCode;
    }

    /**
     * 重点耗能设备类型(必填) scope为1、2、3，此为00
     */
    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    /**
     * 重点耗能设备编号(必填) scope为1、2、3，此为00
     */
    public String getEquipmentUnitCode() {
        return equipmentUnitCode;
    }

    /**
     * 重点耗能设备编号(必填) scope为1、2、3，此为00
     */
    public void setEquipmentUnitCode(String equipmentUnitCode) {
        this.equipmentUnitCode = equipmentUnitCode;
    }

    /**
     * 采集对象类型(必填)
     */
    public String getEnergyClassCode() {
        return energyClassCode;
    }

    /**
     * 采集对象类型(必填)
     */
    public void setEnergyClassCode(String energyClassCode) {
        this.energyClassCode = energyClassCode;
    }

    /**
     * 能源分类 + 能源分项(必填)
     */
    public String getEnergyTypeCode() {
        return energyTypeCode;
    }

    /**
     * 能源分类 + 能源分项(必填)
     */
    public void setEnergyTypeCode(String energyTypeCode) {
        this.energyTypeCode = energyTypeCode;
    }

    /**
     * 能源品种(必选)
     */
    public String getDataVarieties() {
        return dataVarieties;
    }

    /**
     * 能源品种(必选)
     */
    public void setDataVarieties(String dataVarieties) {
        this.dataVarieties = dataVarieties;
    }

    /**
     * 能源用途(必填)
     */
    public String getDataUsageCode() {
        return dataUsageCode;
    }

    /**
     * 能源用途(必填)
     */
    public void setDataUsageCode(String dataUsageCode) {
        this.dataUsageCode = dataUsageCode;
    }

    /**
     * 数据采集来源编码（必填，10个指标）
     */
    public String getInputType() {
        return inputType;
    }

    /**
     * 数据采集来源编码（必填，10个指标）
     */
    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    /**
     * 数据最小值(非必填）
     */
    public BigDecimal getDataValueMin() {
        return dataValueMin;
    }

    /**
     * 数据最小值(非必填）
     */
    public void setDataValueMin(BigDecimal dataValueMin) {
        this.dataValueMin = dataValueMin;
    }

    /**
     * 数据最大值(非必填)
     */
    public BigDecimal getDataValueMax() {
        return dataValueMax;
    }

    /**
     * 数据最大值(非必填)
     */
    public void setDataValueMax(BigDecimal dataValueMax) {
        this.dataValueMax = dataValueMax;
    }

    /**
     * 采集频率（必填）
     */
    public String getStatType() {
        return statType;
    }

    /**
     * 采集频率（必填）
     */
    public void setStatType(String statType) {
        this.statType = statType;
    }

    /**
     * 采集系统名称
     */
    public String getCollectSystemName() {
        return collectSystemName;
    }

    /**
     * 采集系统名称
     */
    public void setCollectSystemName(String collectSystemName) {
        this.collectSystemName = collectSystemName;
    }

    /**
     * 插入时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 插入时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 数值单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 数值单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 范围 1：全厂，2：生产工序，3：生产工序单元，4：重点耗能设备
     */
    public String getScope() {
        return scope;
    }

    /**
     * 范围 1：全厂，2：生产工序，3：生产工序单元，4：重点耗能设备
     */
    public void setScope(String scope) {
        this.scope = scope;
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