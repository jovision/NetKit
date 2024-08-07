package com.jovision.netkit.mvp.data.bean.response;

import com.jovision.netkit.mvp.data.bean.DeviceBean;

import java.util.List;

/**
 * 远程运维: 待远程运维的设备列表响应数据
 *
 * @author liteng
 * @date 2022/6/27
 */
public class WaitRemoteOpsDeviceResponseBean {

    private List<DeviceBean> deviceList;

    public List<DeviceBean> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<DeviceBean> deviceList) {
        this.deviceList = deviceList;
    }
}
