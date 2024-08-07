package com.jovision.netkit.mvp.data.bean.response;

//校验注销权限
public class CheckCancelResponseBean {

    private int isExistDevice;//是否存在设备 0-不存在 1-存在
    private int isExistPackage;//是否存在报警云存储 0-不存在 1-存在

    public int getIsExistDevice() {
        return isExistDevice;
    }

    public void setIsExistDevice(int isExistDevice) {
        this.isExistDevice = isExistDevice;
    }

    public int getIsExistPackage() {
        return isExistPackage;
    }

    public void setIsExistPackage(int isExistPackage) {
        this.isExistPackage = isExistPackage;
    }
}
