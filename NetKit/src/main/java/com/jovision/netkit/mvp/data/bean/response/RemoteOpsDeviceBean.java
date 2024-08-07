package com.jovision.netkit.mvp.data.bean.response;


import com.jovision.basekit.utilcode.StringUtils;

/**
 * 远程运维-设备
 *
 * @author liteng
 * @date 2022/6/17
 */
public class RemoteOpsDeviceBean {

    private String deviceId;
    private String deviceName;

    public String getDeviceId() {
        return StringUtils.null2Length0(deviceId);
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return StringUtils.null2Length0(deviceName);
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
