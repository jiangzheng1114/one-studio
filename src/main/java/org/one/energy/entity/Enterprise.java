package org.one.energy.entity;

import java.util.Date;

public class Enterprise {

    /**
     * 统一社会信用代码(必填)
     */
    private String code;

    /**
     * 单位名称(必填)
     */
    private String name;

    /**
     * 单位类别编码(必填)
     */
    private String typeCode;

    /**
     * 单位类别名称(必填)
     */
    private String typeName;

    /**
     * 行业编码(必填)
     */
    private String industryCode;

    /**
     * 区域编码(必填 必填，6位到地区级别
     */
    private String regionCode;

    /**
     * 地区名称
     */
    private String regionName;

    /**
     * 是否央企(必填)
     */
    private String center;

    /**
     * 统一社会信用代码(必填) 和字段code一致
     */
    private String corporationCode;

    /**
     * 是否能源加工转换类企业(必填) true:false
     */
    private String jgzh;

    /**
     * 年综合能源消费总量级别（必填 必填，下拉框, 1:5000 吨以下, 2:10000 吨以上,3:1 万-10 万吨，4: 10 万-50 万吨，5:50 万-300 万吨，6:300 万吨以上
     */
    private Integer energyConsumeLevel;

    /**
     * 用能单位主要厂址中心纬度(必填)
     */
    private String latitude;

    /**
     * 用能单位主要厂址中心经度(必填)
     */
    private String longitude;

    /**
     * 企业联系电话(必填)
     */
    private String phone;

    /**
     * 传真
     */
    private String fax;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 用能单位网站地址URL
     */
    private String url;

    /**
     * 领域编码 领域编码，工业:100,交通运输、仓储和邮政业:200,住宿和 餐饮业：300，批发和零售业：400，教育：500，其他：600
     */
    private String fieldCode;

    /**
     * 领域名称
     */
    private String fieldName;

    /**
     * 法人代表
     */
    private String corporationName;

    /**
     * 注册日期
     */
    private Date registerDate;

    /**
     * 注册资金
     */
    private String registerPrincipal;

    /**
     * 能管机构名称
     */
    private String energyOffice;

    /**
     * 主管节能领导姓名
     */
    private String energyOfficial;

    /**
     * 主管节能领导职位
     */
    private String energyOfficialPosition;

    /**
     * 主管节能领导联系电话
     */
    private String energyOfficialPhone;

    /**
     * 是否通过能源管理体系认证 true:false
     */
    private String energyPass;

    /**
     * 能管负责人姓名
     */
    private String energyRespName;

    /**
     * 能管负责人电话
     */
    private String energyRespPhone;

    /**
     * 认证日期
     */
    private Date passDate;

    /**
     * 认证机构
     */
    private String passOrg;

    /**
     * 企业主要生产线名称
     */
    private String productionLine;

    /**
     * 企业主导产品
     */
    private String leadingProduct;

    /**
     * 备注
     */
    private String remark;

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

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getCorporationCode() {
        return corporationCode;
    }

    public void setCorporationCode(String corporationCode) {
        this.corporationCode = corporationCode;
    }

    public String getJgzh() {
        return jgzh;
    }

    public void setJgzh(String jgzh) {
        this.jgzh = jgzh;
    }

    public Integer getEnergyConsumeLevel() {
        return energyConsumeLevel;
    }

    public void setEnergyConsumeLevel(Integer energyConsumeLevel) {
        this.energyConsumeLevel = energyConsumeLevel;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getRegisterPrincipal() {
        return registerPrincipal;
    }

    public void setRegisterPrincipal(String registerPrincipal) {
        this.registerPrincipal = registerPrincipal;
    }

    public String getEnergyOffice() {
        return energyOffice;
    }

    public void setEnergyOffice(String energyOffice) {
        this.energyOffice = energyOffice;
    }

    public String getEnergyOfficial() {
        return energyOfficial;
    }

    public void setEnergyOfficial(String energyOfficial) {
        this.energyOfficial = energyOfficial;
    }

    public String getEnergyOfficialPosition() {
        return energyOfficialPosition;
    }

    public void setEnergyOfficialPosition(String energyOfficialPosition) {
        this.energyOfficialPosition = energyOfficialPosition;
    }

    public String getEnergyOfficialPhone() {
        return energyOfficialPhone;
    }

    public void setEnergyOfficialPhone(String energyOfficialPhone) {
        this.energyOfficialPhone = energyOfficialPhone;
    }

    public String getEnergyPass() {
        return energyPass;
    }

    public void setEnergyPass(String energyPass) {
        this.energyPass = energyPass;
    }

    public String getEnergyRespName() {
        return energyRespName;
    }

    public void setEnergyRespName(String energyRespName) {
        this.energyRespName = energyRespName;
    }

    public String getEnergyRespPhone() {
        return energyRespPhone;
    }

    public void setEnergyRespPhone(String energyRespPhone) {
        this.energyRespPhone = energyRespPhone;
    }

    public Date getPassDate() {
        return passDate;
    }

    public void setPassDate(Date passDate) {
        this.passDate = passDate;
    }

    public String getPassOrg() {
        return passOrg;
    }

    public void setPassOrg(String passOrg) {
        this.passOrg = passOrg;
    }

    public String getProductionLine() {
        return productionLine;
    }

    public void setProductionLine(String productionLine) {
        this.productionLine = productionLine;
    }

    public String getLeadingProduct() {
        return leadingProduct;
    }

    public void setLeadingProduct(String leadingProduct) {
        this.leadingProduct = leadingProduct;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
