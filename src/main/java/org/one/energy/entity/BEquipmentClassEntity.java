package org.one.energy.entity;

import org.one.common.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "b_equipment_class", schema = "oecmc", catalog = "")
public class BEquipmentClassEntity extends BaseEntity {

    private String id;

    private String code;

    private String name;

    private String remark;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BEquipmentClassEntity that = (BEquipmentClassEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, remark);
    }
}
