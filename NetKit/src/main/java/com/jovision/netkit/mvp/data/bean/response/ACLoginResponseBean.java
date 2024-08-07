package com.jovision.netkit.mvp.data.bean.response;

public class ACLoginResponseBean {

    private String accessToken;
    private int accessTokenExpire;
    private String refreshToken;
    private int refreshTokenExpire;
    private int currentErrorCount;
    private int remainAttemptCount;
    private int attemptTime;
    private int lockExpire;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getAccessTokenExpire() {
        return accessTokenExpire;
    }

    public void setAccessTokenExpire(int accessTokenExpire) {
        this.accessTokenExpire = accessTokenExpire;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public int getRefreshTokenExpire() {
        return refreshTokenExpire;
    }

    public void setRefreshTokenExpire(int refreshTokenExpire) {
        this.refreshTokenExpire = refreshTokenExpire;
    }

    public int getCurrentErrorCount() {
        return currentErrorCount;
    }

    public void setCurrentErrorCount(int currentErrorCount) {
        this.currentErrorCount = currentErrorCount;
    }

    public int getRemainAttemptCount() {
        return remainAttemptCount;
    }

    public void setRemainAttemptCount(int remainAttemptCount) {
        this.remainAttemptCount = remainAttemptCount;
    }

    public int getAttemptTime() {
        return attemptTime;
    }

    public void setAttemptTime(int attemptTime) {
        this.attemptTime = attemptTime;
    }

    public int getLockExpire() {
        return lockExpire;
    }

    public void setLockExpire(int lockExpire) {
        this.lockExpire = lockExpire;
    }
}
