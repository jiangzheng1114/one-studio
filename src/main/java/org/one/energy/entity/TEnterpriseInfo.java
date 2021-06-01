package org.one.energy.entity;

import org.one.common.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 *  
 * @TableName t_enterprise_info
 */
public class TEnterpriseInfo extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4418383451003277943L;

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

    /**
     * 集团名称
     */
    private String groupName;

    /**
     * 集团地址
     */
    private String groupAddress;

    /**
     * 集团备注
     */
    private String groupRemark;

    /**
     * 上报状态
     */
    private String uploadStatus;

    /**
     * 统一社会信用代码(必填)
     */
    public String getCode() {
        return code;
    }

    /**
     * 统一社会信用代码(必填)
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 单位名称(必填)
     */
    public String getName() {
        return name;
    }

    /**
     * 单位名称(必填)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 单位类别编码(必填)
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * 单位类别编码(必填)
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * 单位类别名称(必填)
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 单位类别名称(必填)
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 行业编码(必填)
     */
    public String getIndustryCode() {
        return industryCode;
    }

    /**
     * 行业编码(必填)
     */
    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    /**
     * 区域编码(必填 必填，6位到地区级别
     */
    public String getRegionCode() {
        return regionCode;
    }

    /**
     * 区域编码(必填 必填，6位到地区级别
     */
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    /**
     * 地区名称
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * 地区名称
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /**
     * 是否央企(必填)
     */
    public String getCenter() {
        return center;
    }

    /**
     * 是否央企(必填)
     */
    public void setCenter(String center) {
        this.center = center;
    }

    /**
     * 统一社会信用代码(必填) 和字段code一致
     */
    public String getCorporationCode() {
        return corporationCode;
    }

    /**
     * 统一社会信用代码(必填) 和字段code一致
     */
    public void setCorporationCode(String corporationCode) {
        this.corporationCode = corporationCode;
    }

    /**
     * 是否能源加工转换类企业(必填) true:false
     */
    public String getJgzh() {
        return jgzh;
    }

    /**
     * 是否能源加工转换类企业(必填) true:false
     */
    public void setJgzh(String jgzh) {
        this.jgzh = jgzh;
    }

    /**
     * 年综合能源消费总量级别（必填 必填，下拉框, 1:5000 吨以下, 2:10000 吨以上,3:1 万-10 万吨，4: 10 万-50 万吨，5:50 万-300 万吨，6:300 万吨以上
     */
    public Integer getEnergyConsumeLevel() {
        return energyConsumeLevel;
    }

    /**
     * 年综合能源消费总量级别（必填 必填，下拉框, 1:5000 吨以下, 2:10000 吨以上,3:1 万-10 万吨，4: 10 万-50 万吨，5:50 万-300 万吨，6:300 万吨以上
     */
    public void setEnergyConsumeLevel(Integer energyConsumeLevel) {
        this.energyConsumeLevel = energyConsumeLevel;
    }

    /**
     * 用能单位主要厂址中心纬度(必填)
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 用能单位主要厂址中心纬度(必填)
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * 用能单位主要厂址中心经度(必填)
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 用能单位主要厂址中心经度(必填)
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * 企业联系电话(必填)
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 企业联系电话(必填)
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 传真
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 邮编
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 邮编
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 用能单位网站地址URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 用能单位网站地址URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 领域编码 领域编码，工业:100,交通运输、仓储和邮政业:200,住宿和 餐饮业：300，批发和零售业：400，教育：500，其他：600
     */
    public String getFieldCode() {
        return fieldCode;
    }

    /**
     * 领域编码 领域编码，工业:100,交通运输、仓储和邮政业:200,住宿和 餐饮业：300，批发和零售业：400，教育：500，其他：600
     */
    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    /**
     * 领域名称
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 领域名称
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * 法人代表
     */
    public String getCorporationName() {
        return corporationName;
    }

    /**
     * 法人代表
     */
    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    /**
     * 注册日期
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * 注册日期
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * 注册资金
     */
    public String getRegisterPrincipal() {
        return registerPrincipal;
    }

    /**
     * 注册资金
     */
    public void setRegisterPrincipal(String registerPrincipal) {
        this.registerPrincipal = registerPrincipal;
    }

    /**
     * 能管机构名称
     */
    public String getEnergyOffice() {
        return energyOffice;
    }

    /**
     * 能管机构名称
     */
    public void setEnergyOffice(String energyOffice) {
        this.energyOffice = energyOffice;
    }

    /**
     * 主管节能领导姓名
     */
    public String getEnergyOfficial() {
        return energyOfficial;
    }

    /**
     * 主管节能领导姓名
     */
    public void setEnergyOfficial(String energyOfficial) {
        this.energyOfficial = energyOfficial;
    }

    /**
     * 主管节能领导职位
     */
    public String getEnergyOfficialPosition() {
        return energyOfficialPosition;
    }

    /**
     * 主管节能领导职位
     */
    public void setEnergyOfficialPosition(String energyOfficialPosition) {
        this.energyOfficialPosition = energyOfficialPosition;
    }

    /**
     * 主管节能领导联系电话
     */
    public String getEnergyOfficialPhone() {
        return energyOfficialPhone;
    }

    /**
     * 主管节能领导联系电话
     */
    public void setEnergyOfficialPhone(String energyOfficialPhone) {
        this.energyOfficialPhone = energyOfficialPhone;
    }

    /**
     * 是否通过能源管理体系认证 true:false
     */
    public String getEnergyPass() {
        return energyPass;
    }

    /**
     * 是否通过能源管理体系认证 true:false
     */
    public void setEnergyPass(String energyPass) {
        this.energyPass = energyPass;
    }

    /**
     * 能管负责人姓名
     */
    public String getEnergyRespName() {
        return energyRespName;
    }

    /**
     * 能管负责人姓名
     */
    public void setEnergyRespName(String energyRespName) {
        this.energyRespName = energyRespName;
    }

    /**
     * 能管负责人电话
     */
    public String getEnergyRespPhone() {
        return energyRespPhone;
    }

    /**
     * 能管负责人电话
     */
    public void setEnergyRespPhone(String energyRespPhone) {
        this.energyRespPhone = energyRespPhone;
    }

    /**
     * 认证日期
     */
    public Date getPassDate() {
        return passDate;
    }

    /**
     * 认证日期
     */
    public void setPassDate(Date passDate) {
        this.passDate = passDate;
    }

    /**
     * 认证机构
     */
    public String getPassOrg() {
        return passOrg;
    }

    /**
     * 认证机构
     */
    public void setPassOrg(String passOrg) {
        this.passOrg = passOrg;
    }

    /**
     * 企业主要生产线名称
     */
    public String getProductionLine() {
        return productionLine;
    }

    /**
     * 企业主要生产线名称
     */
    public void setProductionLine(String productionLine) {
        this.productionLine = productionLine;
    }

    /**
     * 企业主导产品
     */
    public String getLeadingProduct() {
        return leadingProduct;
    }

    /**
     * 企业主导产品
     */
    public void setLeadingProduct(String leadingProduct) {
        this.leadingProduct = leadingProduct;
    }

    /**
     * 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 集团名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 集团名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 集团地址
     */
    public String getGroupAddress() {
        return groupAddress;
    }

    /**
     * 集团地址
     */
    public void setGroupAddress(String groupAddress) {
        this.groupAddress = groupAddress;
    }

    /**
     * 集团备注
     */
    public String getGroupRemark() {
        return groupRemark;
    }

    /**
     * 集团备注
     */
    public void setGroupRemark(String groupRemark) {
        this.groupRemark = groupRemark;
    }

    /**
     * 上报状态
     */
    public String getUploadStatus() {
        return uploadStatus;
    }

    /**
     * 上报状态
     */
    public void setUploadStatus(String uploadStatus) {
        this.uploadStatus = uploadStatus;
    }
}