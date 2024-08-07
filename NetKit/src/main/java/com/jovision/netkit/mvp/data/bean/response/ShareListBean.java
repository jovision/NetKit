package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

public class ShareListBean {
    private String deviceSn;
    private String deviceName;
//    private int channelId;
    private String channelName;
    private int freeMaxShareCount;//最大共享数量
    private int shareCount;//已共享数量
    private List<ShareInfoBean> sharedList;

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

//    public int getChannelId() {
//        return channelId;
//    }
//
//    public void setChannelId(int channelId) {
//        this.channelId = channelId;
//    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getFreeMaxShareCount() {
        return freeMaxShareCount;
    }

    public void setFreeMaxShareCount(int freeMaxShareCount) {
        this.freeMaxShareCount = freeMaxShareCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public List<ShareInfoBean> getSharedList() {
        return sharedList;
    }

    public void setSharedList(List<ShareInfoBean> sharedList) {
        this.sharedList = sharedList;
    }
}
