package com.jovision.netkit.mvp.data.bean.request;

import java.util.List;

public class DeleteDevicesBean {
    private List<DeleteDeviceBean> devices;

    public List<DeleteDeviceBean> getDevices() {
        return devices;
    }

    public void setDevices(List<DeleteDeviceBean> devices) {
        this.devices = devices;
    }
}
