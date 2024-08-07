package com.jovision.netkit.mvp.data.bean;

import com.jovision.netkit.mvp.data.RefreshTokenDataBean;

public class RefreshTokenResponseBean {
    private String code;
    private String msg;
    private RefreshTokenDataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RefreshTokenDataBean getData() {
        return data;
    }

    public void setData(RefreshTokenDataBean data) {
        this.data = data;
    }
}
