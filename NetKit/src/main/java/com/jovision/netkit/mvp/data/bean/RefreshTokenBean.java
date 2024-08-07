package com.jovision.netkit.mvp.data.bean;

import java.util.Map;

public class RefreshTokenBean {
    private String refreshToken;
    private Object attributes;

    public RefreshTokenBean(String refreshToken,Object attributes) {
        this.refreshToken = refreshToken;
        this.attributes = attributes;
    }
}
