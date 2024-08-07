package com.jovision.netkit.mvp.data.bean.response;


import com.chad.library.adapter.base.entity.node.BaseNode;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MyShareChannelBean extends BaseNode {
    private String deviceSn;
    private String deviceName;
    private String deviceProtocol;
    private int channelId;
    private String channelName;
    private String channelType;
    private int shareCount;
    private boolean isChild;
    private int freeMaxShareCount;

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

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getFreeMaxShareCount() {
        return freeMaxShareCount;
    }

    public void setFreeMaxShareCount(int freeMaxShareCount) {
        this.freeMaxShareCount = freeMaxShareCount;
    }

    @Override
    public String toString() {
        return "MyShareChannelBean{" +
                "channelId=" + channelId +
                ", channelName='" + channelName + '\'' +
                ", channelType='" + channelType + '\'' +
                ", shareCount=" + shareCount +
                '}';
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return null;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setChild(boolean child) {
        isChild = child;
    }


    public String getDeviceProtocol() {
        return deviceProtocol;
    }

    public void setDeviceProtocol(String deviceProtocol) {
        this.deviceProtocol = deviceProtocol;
    }
}
