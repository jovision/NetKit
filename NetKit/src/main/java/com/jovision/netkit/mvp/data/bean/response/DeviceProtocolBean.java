package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;

/**
 * Copyright©中维世纪
 * 查询设备接入类型
 *
 * @author juyang
 * 创建日期：2021/08/24
 * 描述：
 */


public class DeviceProtocolBean implements Serializable {

    private String deviceSn;
    private String deviceState;//枚举: ONLINE：在线,OFFLINE：离线,UNREGISTERED：未注册
    private String accessProtocol;//枚举: PUBLICCLOUD：公有云协议,GB：国标协议,CLOUDSEE1：云视通1.0,CLOUDSEE2：云视通2.0
    private String deviceType;//枚举: IPC,NVR,IPDOME,DVR,HOME_IPC,JNVR,CARD
    private String channelCount;
    private String currentVersion;


    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public String getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(String deviceState) {
        this.deviceState = deviceState;
    }

    public String getAccessProtocol() {
        return accessProtocol;
    }

    public void setAccessProtocol(String accessProtocol) {
        this.accessProtocol = accessProtocol;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getChannelCount() {
        return channelCount;
    }

    public void setChannelCount(String channelCount) {
        this.channelCount = channelCount;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

}
