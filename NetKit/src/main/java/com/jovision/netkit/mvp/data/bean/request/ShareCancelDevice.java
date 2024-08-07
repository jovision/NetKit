package com.jovision.netkit.mvp.data.bean.request;

public class ShareCancelDevice {
    private String deviceSn;
//    private int channelId;

    public ShareCancelDevice(String deviceSn) {//, int channelId
        this.deviceSn = deviceSn;
//        this.channelId = channelId;
    }

//    public ShareCancelDevice(String deviceSn) {
//        this.deviceSn = deviceSn;
//    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

//    public int getChannelId() {
//        return channelId;
//    }
//
//    public void setChannelId(int channelId) {
//        this.channelId = channelId;
//    }

    @Override
    public String toString() {
        return "ShareCancelDevice{" +
                "deviceSn='" + deviceSn + '\'' +
//                ", channelId=" + channelId +
                '}';
    }
}
