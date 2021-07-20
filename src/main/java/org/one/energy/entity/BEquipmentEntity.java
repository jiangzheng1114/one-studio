package org.one.energy.entity;

import org.one.common.base.BaseEntity;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "b_equipment", schema = "oecmc", catalog = "")
public class BEquipmentEntity extends BaseEntity {

    private String id;

    private String code;

    private String name;

    private String remark;

    private String classCode;

    @Transient
    private String procId;
    @Transient
    private String procName;
    @Transient
    private String procUnitId;
    @Transient
    private String procUnitName;
    @Transient
    private String equipmentClassId;
    @Transient
    private String equipmentClassName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getProcId() {
        return procId;
    }

    public void setProcId(String procId) {
        this.procId = procId;
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName;
    }

    public String getProcUnitId() {
        return procUnitId;
    }

    public void setProcUnitId(String procUnitId) {
        this.procUnitId = procUnitId;
    }

    public String getProcUnitName() {
        return procUnitName;
    }

    public void setProcUnitName(String procUnitName) {
        this.procUnitName = procUnitName;
    }

    public String getEquipmentClassId() {
        return equipmentClassId;
    }

    public void setEquipmentClassId(String equipmentClassId) {
        this.equipmentClassId = equipmentClassId;
    }

    public String getEquipmentClassName() {
        return equipmentClassName;
    }

    public void setEquipmentClassName(String equipmentClassName) {
        this.equipmentClassName = equipmentClassName;
    }
}
