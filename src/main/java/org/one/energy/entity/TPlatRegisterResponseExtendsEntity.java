package org.one.energy.entity;

import org.one.common.base.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_plat_register_response_extends", schema = "oecmc", catalog = "")
public class TPlatRegisterResponseExtendsEntity extends BaseEntity {

    private String id;

    private String platUrl;

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

    private Timestamp operTime;

    private String operUserName;

    private String operType;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "plat_url")
    public String getPlatUrl() {
        return platUrl;
    }

    public void setPlatUrl(String platUrl) {
        this.platUrl = platUrl;
    }

    @Basic
    @Column(name = "response_code")
    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    @Basic
    @Column(name = "response_message")
    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Basic
    @Column(name = "device_id")
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "load_config_URL")
    public String getLoadConfigUrl() {
        return loadConfigUrl;
    }

    public void setLoadConfigUrl(String loadConfigUrl) {
        this.loadConfigUrl = loadConfigUrl;
    }

    @Basic
    @Column(name = "load_dic_version_URL")
    public String getLoadDicVersionUrl() {
        return loadDicVersionUrl;
    }

    public void setLoadDicVersionUrl(String loadDicVersionUrl) {
        this.loadDicVersionUrl = loadDicVersionUrl;
    }

    @Basic
    @Column(name = "center_info_URL")
    public String getCenterInfoUrl() {
        return centerInfoUrl;
    }

    public void setCenterInfoUrl(String centerInfoUrl) {
        this.centerInfoUrl = centerInfoUrl;
    }

    @Basic
    @Column(name = "center_data_URL")
    public String getCenterDataUrl() {
        return centerDataUrl;
    }

    public void setCenterDataUrl(String centerDataUrl) {
        this.centerDataUrl = centerDataUrl;
    }

    @Basic
    @Column(name = "center_info_download_URL")
    public String getCenterInfoDownloadUrl() {
        return centerInfoDownloadUrl;
    }

    public void setCenterInfoDownloadUrl(String centerInfoDownloadUrl) {
        this.centerInfoDownloadUrl = centerInfoDownloadUrl;
    }

    @Basic
    @Column(name = "center_data_download_URL")
    public String getCenterDataDownloadUrl() {
        return centerDataDownloadUrl;
    }

    public void setCenterDataDownloadUrl(String centerDataDownloadUrl) {
        this.centerDataDownloadUrl = centerDataDownloadUrl;
    }

    @Basic
    @Column(name = "upload_time")
    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Basic
    @Column(name = "oper_time")
    public Timestamp getOperTime() {
        return operTime;
    }

    public void setOperTime(Timestamp operTime) {
        this.operTime = operTime;
    }

    @Basic
    @Column(name = "oper_user_name")
    public String getOperUserName() {
        return operUserName;
    }

    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName;
    }

    @Basic
    @Column(name = "oper_type")
    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TPlatRegisterResponseExtendsEntity that = (TPlatRegisterResponseExtendsEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(platUrl, that.platUrl) &&
                Objects.equals(responseCode, that.responseCode) &&
                Objects.equals(responseMessage, that.responseMessage) &&
                Objects.equals(deviceId, that.deviceId) &&
                Objects.equals(loadConfigUrl, that.loadConfigUrl) &&
                Objects.equals(loadDicVersionUrl, that.loadDicVersionUrl) &&
                Objects.equals(centerInfoUrl, that.centerInfoUrl) &&
                Objects.equals(centerDataUrl, that.centerDataUrl) &&
                Objects.equals(centerInfoDownloadUrl, that.centerInfoDownloadUrl) &&
                Objects.equals(centerDataDownloadUrl, that.centerDataDownloadUrl) &&
                Objects.equals(uploadTime, that.uploadTime) &&
                Objects.equals(operTime, that.operTime) &&
                Objects.equals(operUserName, that.operUserName) &&
                Objects.equals(operType, that.operType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, platUrl, responseCode, responseMessage, deviceId, loadConfigUrl, loadDicVersionUrl, centerInfoUrl, centerDataUrl, centerInfoDownloadUrl, centerDataDownloadUrl, uploadTime, operTime, operUserName, operType);
    }
}
