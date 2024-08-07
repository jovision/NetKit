package com.jovision.netkit.mvp.data.bean.response;

//查询套餐是否赠送
//http://172.18.3.246:3000/mock/382/v1/udms/device/smart_ability/is_newDevice
public class PetNewDeviceBean {
    private int newDevice = 0;//是否为新设备 0-否 1-是

    public int getNewDevice() {
        return newDevice;
    }

    public void setNewDevice(int newDevice) {
        this.newDevice = newDevice;
    }
}
