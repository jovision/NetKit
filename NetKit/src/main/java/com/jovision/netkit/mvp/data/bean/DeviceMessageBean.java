package com.jovision.netkit.mvp.data.bean;

/**
 * Created by zhp on 2020/12/2
 */
public class DeviceMessageBean extends BaseEntity {

    private String deviceSn;
    private int channelId;

    public DeviceMessageBean(String deviceSn, int channelId) {
        this.deviceSn = deviceSn;
        this.channelId = channelId;
    }
}
