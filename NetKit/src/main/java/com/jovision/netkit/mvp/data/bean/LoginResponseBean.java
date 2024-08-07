package com.jovision.netkit.mvp.data.bean;

/**
 * 登录网络请求:返回值
 *
 * @author liteng
 * @date 2020/10/29
 */
public class LoginResponseBean {

    /**
     * token : reprehenderit nostrud non
     * tokenExpiresIn : -5.518789207890138E7
     * tiken : Lorem laborum id
     * tikenExpiresIn : 5840185.575177908
     */

    private String token;
    private double tokenValidPeriod;
    private String tiken;
    private double tikenValidPeriod;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public double getTokenValidPeriod() {
        return tokenValidPeriod;
    }

    public void setTokenValidPeriod(double tokenValidPeriod) {
        this.tokenValidPeriod = tokenValidPeriod;
    }

    public String getTiken() {
        return tiken;
    }

    public void setTiken(String tiken) {
        this.tiken = tiken;
    }

    public double getTikenValidPeriod() {
        return tikenValidPeriod;
    }

    public void setTikenValidPeriod(double tikenValidPeriod) {
        this.tikenValidPeriod = tikenValidPeriod;
    }
}
