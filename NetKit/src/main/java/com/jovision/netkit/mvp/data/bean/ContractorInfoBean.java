package com.jovision.netkit.mvp.data.bean;

public class ContractorInfoBean {

    private String enterpriseId;//工程商ID
    private String enterpriseName;//工程商名称
    private String contacts;//联系人
    private String phone;//联系电话
    private String city;//主营城市
    private String enterpriseSite;//公司地址
    private String jovContacts;//中维联系人
    private int status;//审核状态1：已审批2：待审批3：已冻结4、已驳回
    private String businessLicenseUrl;//营业执照下载地址
    private String createTime;//	创建时间
    private String rejectReason;//	驳回理由

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEnterpriseSite() {
        return enterpriseSite;
    }

    public void setEnterpriseSite(String enterpriseSite) {
        this.enterpriseSite = enterpriseSite;
    }

    public String getJovContacts() {
        return jovContacts;
    }

    public void setJovContacts(String jovContacts) {
        this.jovContacts = jovContacts;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }
    @Override
    public String toString() {
        return "ContractorInfoBean{" +
                "enterpriseId='" + enterpriseId + '\'' +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", contacts='" + contacts + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", enterpriseSite='" + enterpriseSite + '\'' +
                ", jovContacts='" + jovContacts + '\'' +
                ", status=" + status +
                ", businessLicenseUrl='" + businessLicenseUrl + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
