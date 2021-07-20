package org.one.energy.entity;

import org.one.common.base.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "b_proc_unit", schema = "oecmc", catalog = "")
public class BProcUnitEntity extends BaseEntity {

    private String id;

    private String code;

    private String processCode;

    private String procId;

    private String name;

    private Timestamp commDate;

    private String designedCapacity;

    private String remark;

    private String dataSource;

    private String status;

    private String checkStatus;

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
    @Column(name = "process_code")
    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    @Basic
    @Column(name = "proc_id")
    public String getProcId() {
        return procId;
    }

    public void setProcId(String procId) {
        this.procId = procId;
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
    @Column(name = "comm_date")
    public Timestamp getCommDate() {
        return commDate;
    }

    public void setCommDate(Timestamp commDate) {
        this.commDate = commDate;
    }

    @Basic
    @Column(name = "designed_capacity")
    public String getDesignedCapacity() {
        return designedCapacity;
    }

    public void setDesignedCapacity(String designedCapacity) {
        this.designedCapacity = designedCapacity;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "data_source")
    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "check_status")
    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BProcUnitEntity that = (BProcUnitEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(processCode, that.processCode) &&
                Objects.equals(procId, that.procId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(commDate, that.commDate) &&
                Objects.equals(designedCapacity, that.designedCapacity) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(dataSource, that.dataSource) &&
                Objects.equals(status, that.status) &&
                Objects.equals(checkStatus, that.checkStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, processCode, procId, name, commDate, designedCapacity, remark, dataSource, status, checkStatus);
    }
}
