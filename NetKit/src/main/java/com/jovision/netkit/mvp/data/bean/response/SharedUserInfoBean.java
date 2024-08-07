package com.jovision.netkit.mvp.data.bean.response;

public class SharedUserInfoBean {
    private String userId;
    private String nickname;
    private String account;
    private String headPictureUrl;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getHeadPictureUrl() {
        return headPictureUrl;
    }

    public void setHeadPictureUrl(String headPictureUrl) {
        this.headPictureUrl = headPictureUrl;
    }

    @Override
    public String toString() {
        return "SharedUserInfoBean{" +
                "userId='" + userId + '\'' +
                ", nickName='" + nickname + '\'' +
                ", account='" + account + '\'' +
                ", headPictureUrl='" + headPictureUrl + '\'' +
                '}';
    }
}
