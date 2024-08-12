package com.jovision.netkit.mvp.data;

import java.io.Serializable;

public class RefreshTokenDataBean implements Serializable {
    private String accessToken;
    private long accessTokenExpire;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getAccessTokenExpire() {
        return accessTokenExpire;
    }

    public void setAccessTokenExpire(long accessTokenExpire) {
        this.accessTokenExpire = accessTokenExpire;
    }
}
