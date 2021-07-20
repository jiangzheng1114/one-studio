package org.one.energy.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.one.common.base.BaseEntity;

import java.util.Date;

public class TPlatVersionResponse extends BaseEntity {
    private String id;

    private String responseCode;

    private String responseMessage;

    private String regVersionOld;

    private String dicVersionOld;

    private String regVersionNew;

    private String dicVersionNew;

    private Date operTime;

    private String operUserName;

    private String operType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode == null ? null : responseCode.trim();
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage == null ? null : responseMessage.trim();
    }

    public String getRegVersionOld() {
        return regVersionOld;
    }

    public void setRegVersionOld(String regVersionOld) {
        this.regVersionOld = regVersionOld == null ? null : regVersionOld.trim();
    }

    public String getDicVersionOld() {
        return dicVersionOld;
    }

    public void setDicVersionOld(String dicVersionOld) {
        this.dicVersionOld = dicVersionOld == null ? null : dicVersionOld.trim();
    }

    public String getRegVersionNew() {
        return regVersionNew;
    }

    public void setRegVersionNew(String regVersionNew) {
        this.regVersionNew = regVersionNew == null ? null : regVersionNew.trim();
    }

    public String getDicVersionNew() {
        return dicVersionNew;
    }

    public void setDicVersionNew(String dicVersionNew) {
        this.dicVersionNew = dicVersionNew == null ? null : dicVersionNew.trim();
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getOperUserName() {
        return operUserName;
    }

    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName == null ? null : operUserName.trim();
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }
}