package com.jovision.netkit.mvp.data.bean.request;

import java.util.List;

public class ShareCancelRequest {
    private List<ShareCancelDevice> deviceList;

    public List<ShareCancelDevice> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<ShareCancelDevice> deviceList) {
        this.deviceList = deviceList;
    }

    @Override
    public String toString() {
        return "ShareCancelRequest{" +
                "deviceList=" + deviceList +
                '}';
    }
}
