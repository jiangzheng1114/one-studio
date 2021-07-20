package org.one.energy.entity;

import org.one.common.base.BaseEntity;

import javax.persistence.Id;

public class TEnergyEquipment extends BaseEntity {

    @Id
    private String id;

    private String energyType;

    private String equipmentKeys;

    private Double equivalentStandard;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnergyType() {
        return energyType;
    }

    public void setEnergyType(String energyType) {
        this.energyType = energyType == null ? null : energyType.trim();
    }

    public String getEquipmentKeys() {
        return equipmentKeys;
    }

    public Double getEquivalentStandard() {
        return equivalentStandard;
    }

    public void setEquivalentStandard(Double equivalentStandard) {
        this.equivalentStandard = equivalentStandard;
    }

    public void setEquipmentKeys(String equipmentKeys) {
        this.equipmentKeys = equipmentKeys == null ? null : equipmentKeys.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}