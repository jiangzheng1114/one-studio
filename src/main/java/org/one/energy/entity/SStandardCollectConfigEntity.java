package org.one.energy.entity;

import org.one.common.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "s_standard_collect_config", schema = "oecmc", catalog = "")
public class SStandardCollectConfigEntity extends BaseEntity {

    private String id;

    private String industry;

    private String pClass;

    private String dataCodeName;

    private String dataCode;

    private String processCode;

    private String processUnitCode;

    private String equipmentCode;

    private String equipmentUnitCode;

    private String energyClassCode;

    private String energyTypeCode;

    private String dataUsageCode;

    private String inputType;

    private String statType;

    private String unit;

    private String scope;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "industry")
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Basic
    @Column(name = "p_class")
    public String getpClass() {
        return pClass;
    }

    public void setpClass(String pClass) {
        this.pClass = pClass;
    }

    @Basic
    @Column(name = "data_code_name")
    public String getDataCodeName() {
        return dataCodeName;
    }

    public void setDataCodeName(String dataCodeName) {
        this.dataCodeName = dataCodeName;
    }

    @Basic
    @Column(name = "data_code")
    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    @Basic
    @Column(name = "process_code")
    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    @Basic
    @Column(name = "process_unit_code")
    public String getProcessUnitCode() {
        return processUnitCode;
    }

    public void setProcessUnitCode(String processUnitCode) {
        this.processUnitCode = processUnitCode;
    }

    @Basic
    @Column(name = "equipment_code")
    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    @Basic
    @Column(name = "equipment_unit_code")
    public String getEquipmentUnitCode() {
        return equipmentUnitCode;
    }

    public void setEquipmentUnitCode(String equipmentUnitCode) {
        this.equipmentUnitCode = equipmentUnitCode;
    }

    @Basic
    @Column(name = "energy_class_code")
    public String getEnergyClassCode() {
        return energyClassCode;
    }

    public void setEnergyClassCode(String energyClassCode) {
        this.energyClassCode = energyClassCode;
    }

    @Basic
    @Column(name = "energy_type_code")
    public String getEnergyTypeCode() {
        return energyTypeCode;
    }

    public void setEnergyTypeCode(String energyTypeCode) {
        this.energyTypeCode = energyTypeCode;
    }

    @Basic
    @Column(name = "data_usage_code")
    public String getDataUsageCode() {
        return dataUsageCode;
    }

    public void setDataUsageCode(String dataUsageCode) {
        this.dataUsageCode = dataUsageCode;
    }

    @Basic
    @Column(name = "input_type")
    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    @Basic
    @Column(name = "stat_type")
    public String getStatType() {
        return statType;
    }

    public void setStatType(String statType) {
        this.statType = statType;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "scope")
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SStandardCollectConfigEntity that = (SStandardCollectConfigEntity) o;
        return id == that.id &&
                Objects.equals(industry, that.industry) &&
                Objects.equals(pClass, that.pClass) &&
                Objects.equals(dataCodeName, that.dataCodeName) &&
                Objects.equals(dataCode, that.dataCode) &&
                Objects.equals(processCode, that.processCode) &&
                Objects.equals(processUnitCode, that.processUnitCode) &&
                Objects.equals(equipmentCode, that.equipmentCode) &&
                Objects.equals(equipmentUnitCode, that.equipmentUnitCode) &&
                Objects.equals(energyClassCode, that.energyClassCode) &&
                Objects.equals(energyTypeCode, that.energyTypeCode) &&
                Objects.equals(dataUsageCode, that.dataUsageCode) &&
                Objects.equals(inputType, that.inputType) &&
                Objects.equals(statType, that.statType) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(scope, that.scope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, industry, pClass, dataCodeName, dataCode, processCode, processUnitCode, equipmentCode, equipmentUnitCode, energyClassCode, energyTypeCode, dataUsageCode, inputType, statType, unit, scope);
    }
}
