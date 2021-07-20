package org.one.energy.entity;

import org.one.common.base.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "t_collect_irtu", schema = "oecmc", catalog = "")
public class TCollectIrtu extends BaseEntity {
    private String id;

    private String itemId;

    private String ikey;

    private String collectUnit;

    private BigDecimal coefficient;

    private String instLoc;

    private Date insertDate;
    /**
     * 采集数据项指标编码 拼接（规则）例：02-02-0000-040100-30
     */
    @Transient
    private String configcode;
    /**
     * 采集数据项指标名称 拼接（规则）例乙烯装置-2 号单元-非能源类产品-乙烯-产出
     */
    @Transient
    private String configName;
    /**
     * 采集频率（必填）(4)
     */
    @Transient
    private String statType;
    /**
     * 数值单位
     */
    @Transient
    private String unit;/**
     * 仪表编号
     */
    @Transient
    private String irtuno;
    /**
     * 仪表名称
     */
    @Transient
    private String irtudesc;
    /**
     * 采集项名称
     */
    @Transient
    private String idesc;

    @Transient
    private String inputType;

    @Transient
    private String scope;

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getConfigcode() {
        return configcode;
    }

    public void setConfigcode(String configcode) {
        this.configcode = configcode;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getStatType() {
        return statType;
    }

    public void setStatType(String statType) {
        this.statType = statType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getIrtuno() {
        return irtuno;
    }

    public void setIrtuno(String irtuno) {
        this.irtuno = irtuno;
    }

    public String getIrtudesc() {
        return irtudesc;
    }

    public void setIrtudesc(String irtudesc) {
        this.irtudesc = irtudesc;
    }

    public String getIdesc() {
        return idesc;
    }

    public void setIdesc(String idesc) {
        this.idesc = idesc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getIkey() {
        return ikey;
    }

    public void setIkey(String ikey) {
        this.ikey = ikey == null ? null : ikey.trim();
    }

    public String getCollectUnit() {
        return collectUnit;
    }

    public void setCollectUnit(String collectUnit) {
        this.collectUnit = collectUnit == null ? null : collectUnit.trim();
    }

    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    public String getInstLoc() {
        return instLoc;
    }

    public void setInstLoc(String instLoc) {
        this.instLoc = instLoc == null ? null : instLoc.trim();
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }
}