package com.jovision.netkit.mvp.data.bean.request;

public class CreateContractorRequestBean {
    private String enterpriseName;//工程商名称
    private String contacts;//联系人
    private String phone;//	联系电话
    private String city;//	主营城市
    private String enterpriseSite;//	公司地址
    private String jovContacts;//	中维联系人
    private String fileName;//	上传文件名称

    public CreateContractorRequestBean(String enterpriseName, String contacts, String phone, String city, String enterpriseSite, String jovContacts, String fileName) {
        this.enterpriseName = enterpriseName;
        this.contacts = contacts;
        this.phone = phone;
        this.city = city;
        this.enterpriseSite = enterpriseSite;
        this.jovContacts = jovContacts;
        this.fileName = fileName;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "CreateContractorRequestBean{" +
                "enterpriseName='" + enterpriseName + '\'' +
                ", contacts='" + contacts + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", enterpriseSite='" + enterpriseSite + '\'' +
                ", jovContacts='" + jovContacts + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
