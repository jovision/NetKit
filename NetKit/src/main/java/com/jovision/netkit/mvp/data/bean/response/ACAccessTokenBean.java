package com.jovision.netkit.mvp.data.bean.response;

public class ACAccessTokenBean {

    private String accessToken;//访问凭证
    private int accessTokenExpireIn;//访问凭证过期时间

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getAccessTokenExpireIn() {
        return accessTokenExpireIn;
    }

    public void setAccessTokenExpireIn(int accessTokenExpireIn) {
        this.accessTokenExpireIn = accessTokenExpireIn;
    }
}
