package com.jovision.netkit.mvp.data.bean;

public class AgreementBean extends BaseEntity {
    private String agreementLink;
    private String agreementVersion;
    private String agreementUpdateTime;
    private String privacyLink;
    private String privacyVersion;
    private String privacyUpdateTime;
    private String cloudStorageServiceAgreementLink;
    private String cloudStorageServiceAgreementVersion;
    private String cloudStorageServiceAgreementUpdateTime;

    public String getAgreementLink() {
        return agreementLink;
    }

    public void setAgreementLink(String agreementLink) {
        this.agreementLink = agreementLink;
    }

    public String getAgreementVersion() {
        return agreementVersion;
    }

    public void setAgreementVersion(String agreementVersion) {
        this.agreementVersion = agreementVersion;
    }

    public String getAgreementUpdateTime() {
        return agreementUpdateTime;
    }

    public void setAgreementUpdateTime(String agreementUpdateTime) {
        this.agreementUpdateTime = agreementUpdateTime;
    }

    public String getPrivacyLink() {
        return privacyLink;
    }

    public void setPrivacyLink(String privacyLink) {
        this.privacyLink = privacyLink;
    }

    public String getPrivacyVersion() {
        return privacyVersion;
    }

    public void setPrivacyVersion(String privacyVersion) {
        this.privacyVersion = privacyVersion;
    }

    public String getPrivacyUpdateTime() {
        return privacyUpdateTime;
    }

    public void setPrivacyUpdateTime(String privacyUpdateTime) {
        this.privacyUpdateTime = privacyUpdateTime;
    }

    public String getCloudStorageServiceAgreementLink() {
        return cloudStorageServiceAgreementLink;
    }

    public void setCloudStorageServiceAgreementLink(String cloudStorageServiceAgreementLink) {
        this.cloudStorageServiceAgreementLink = cloudStorageServiceAgreementLink;
    }

    public String getCloudStorageServiceAgreementVersion() {
        return cloudStorageServiceAgreementVersion;
    }

    public void setCloudStorageServiceAgreementVersion(String cloudStorageServiceAgreementVersion) {
        this.cloudStorageServiceAgreementVersion = cloudStorageServiceAgreementVersion;
    }

    public String getCloudStorageServiceAgreementUpdateTime() {
        return cloudStorageServiceAgreementUpdateTime;
    }

    public void setCloudStorageServiceAgreementUpdateTime(String cloudStorageServiceAgreementUpdateTime) {
        this.cloudStorageServiceAgreementUpdateTime = cloudStorageServiceAgreementUpdateTime;
    }
}
