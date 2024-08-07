package com.jovision.netkit.mvp.data.bean;

public class UserInfoWithAgreementVersionBean {
    private String userId;
    private String agreementVersion;
    private String privacyVersion;

    public UserInfoWithAgreementVersionBean(String userId, String agreementVersion, String privacyVersion) {
        this.userId = userId;
        this.agreementVersion = agreementVersion;
        this.privacyVersion = privacyVersion;
    }

    @Override
    public String toString() {
        return "UserInfoWithAgreementVersionBean{" +
                "userId='" + userId + '\'' +
                ", agreementVersion='" + agreementVersion + '\'' +
                ", privacyVersion='" + privacyVersion + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserid(String userId) {
        this.userId = userId;
    }

    public String getAgreementVersion() {
        return agreementVersion;
    }

    public void setAgreementVersion(String agreementVersion) {
        this.agreementVersion = agreementVersion;
    }

    public String getPrivacyVersion() {
        return privacyVersion;
    }

    public void setPrivacyVersion(String privacyVersion) {
        this.privacyVersion = privacyVersion;
    }
}
