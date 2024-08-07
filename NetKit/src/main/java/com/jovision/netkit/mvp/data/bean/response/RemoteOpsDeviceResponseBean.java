package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

/**
 * 远程运维: 可远程运维的设备列表响应数据
 *
 * @author liteng
 * @date 2022/6/24
 */
public class RemoteOpsDeviceResponseBean {

    private List<RemoteOpsDeviceBean> deviceList;

    public List<RemoteOpsDeviceBean> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<RemoteOpsDeviceBean> deviceList) {
        this.deviceList = deviceList;
    }
}
