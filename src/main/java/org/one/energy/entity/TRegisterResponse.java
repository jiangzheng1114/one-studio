package org.one.energy.entity;


import org.one.common.base.BaseEntity;

import java.util.Date;


public class TRegisterResponse extends BaseEntity {
    private String id;

    private String responseCode;

    private String responseMessage;

    private String deviceId;

    private String loadConfigUrl;

    private String loadDicVersionUrl;

    private String centerInfoUrl;

    private String centerDataUrl;

    private String centerInfoDownloadUrl;

    private String centerDataDownloadUrl;

    private String uploadTime;

    private Date operTime;

    private String operUserName;

    private String operType;

    private String centerMeteringDataUrl;

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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getLoadConfigUrl() {
        return loadConfigUrl;
    }

    public void setLoadConfigUrl(String loadConfigUrl) {
        this.loadConfigUrl = loadConfigUrl == null ? null : loadConfigUrl.trim();
    }

    public String getLoadDicVersionUrl() {
        return loadDicVersionUrl;
    }

    public void setLoadDicVersionUrl(String loadDicVersionUrl) {
        this.loadDicVersionUrl = loadDicVersionUrl == null ? null : loadDicVersionUrl.trim();
    }

    public String getCenterInfoUrl() {
        return centerInfoUrl;
    }

    public void setCenterInfoUrl(String centerInfoUrl) {
        this.centerInfoUrl = centerInfoUrl == null ? null : centerInfoUrl.trim();
    }

    public String getCenterDataUrl() {
        return centerDataUrl;
    }

    public void setCenterDataUrl(String centerDataUrl) {
        this.centerDataUrl = centerDataUrl == null ? null : centerDataUrl.trim();
    }

    public String getCenterInfoDownloadUrl() {
        return centerInfoDownloadUrl;
    }

    public void setCenterInfoDownloadUrl(String centerInfoDownloadUrl) {
        this.centerInfoDownloadUrl = centerInfoDownloadUrl == null ? null : centerInfoDownloadUrl.trim();
    }

    public String getCenterDataDownloadUrl() {
        return centerDataDownloadUrl;
    }

    public void setCenterDataDownloadUrl(String centerDataDownloadUrl) {
        this.centerDataDownloadUrl = centerDataDownloadUrl == null ? null : centerDataDownloadUrl.trim();
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime == null ? null : uploadTime.trim();
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

    public String getCenterMeteringDataUrl() {
        return centerMeteringDataUrl;
    }

    public void setCenterMeteringDataUrl(String centerMeteringDataUrl) {
        this.centerMeteringDataUrl = centerMeteringDataUrl == null ? null : centerMeteringDataUrl.trim();
    }
}