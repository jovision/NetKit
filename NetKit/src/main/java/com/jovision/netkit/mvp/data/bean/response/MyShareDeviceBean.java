package com.jovision.netkit.mvp.data.bean.response;

import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyShareDeviceBean extends BaseExpandNode {
    private String deviceSn;
    private String deviceName;
    private String accessProtocol;//枚举: PUBLICCLOUD：公有云设备,CLOUDSEE1：云视通1.0设备,CLOUDSEE2：云视通2.0设备
    private String deviceType;
    private int shareCount;
    private int freeMaxShareCount;
    private List<MyShareChannelBean> channelList;

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

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
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

    public List<MyShareChannelBean> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<MyShareChannelBean> channelList) {
        this.channelList = channelList;
    }

    @Override
    public String toString() {
        return "MyShareDeviceBean{" +
                "deviceSn='" + deviceSn + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", shareCount=" + shareCount +
                ", freeMaxShareCount=" + freeMaxShareCount +
//                ", channelList=" + channelList +
                '}';
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        ArrayList<BaseNode> baseNodes = new ArrayList<>();
        baseNodes.addAll(channelList);
        return baseNodes;
    }

    public String getAccessProtocol() {
        return accessProtocol;
    }

    public void setAccessProtocol(String accessProtocol) {
        this.accessProtocol = accessProtocol;
    }
}
