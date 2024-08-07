package com.jovision.netkit.mvp.data.bean.request;

public class CreateSceneChannelRequestBean {
    private String deviceSn;
    private int channelId;

    public CreateSceneChannelRequestBean() {
    }

    public CreateSceneChannelRequestBean(String deviceSn, int channelId) {
        this.deviceSn = deviceSn;
        this.channelId = channelId;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }
}
