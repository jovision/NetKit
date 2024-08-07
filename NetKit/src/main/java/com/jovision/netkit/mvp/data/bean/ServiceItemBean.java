package com.jovision.netkit.mvp.data.bean;

import java.io.Serializable;

public class ServiceItemBean implements Serializable {

    /**
     * 类别编码-1:
     * <p>
     * 服务类型: 1.在线客服; 2.意见反馈; 3.设备密码重置; 4.设备自助解绑; 6.远程运维; 7.4G充值; 8.声波配置;
     * <p>
     * 类别编码-2:
     * <p>
     * 服务类型:1.无线检测; 2.设备激活; 3.录像计算; 4.宽带计算; 5.远程运维; 6.在线客服; 7.云网管; 8.串货举报;
     * 9.设备扫码入库; 10.合伙人入驻; 11.测试服务; 12.发现; 13.发现1; 14.产品说明书; 15.项目管理;
     */
    private int mode;

    /**
     * 类别名称
     */
    private String modeName;
    /**
     * 类别编码-1:
     * <p>
     * 服务类型: 1.在线客服; 2.意见反馈; 3.设备密码重置; 4.设备自助解绑; 6.远程运维; 7.4G充值; 8.声波配置;
     * <p>
     * 类别编码-2:
     * <p>
     * 服务类型: 1.无线检测; 2.设备激活; 3.录像计算; 4.宽带计算; 5.远程运维; 6.在线客服; 7.云网管; 8.串货举报;
     * 9.设备扫码入库; 10.合伙人入驻; 11.测试服务; 12.发现; 13.发现1; 14.产品说明书; 15.项目管理;
     */
    private int type;
    private String photoUrl;
    private String title;
    private int status;//是否启用：0:未启用1:启用
    private int serviceType;//服务类型：1：枚举类，2：动态url
    private String serviceUrl;//服务地址
    private int tokenType;//是否需要拼接token 0：不拼接 1：拼接
    private int scanType;//扫描类型 0：不扫码 1：二维码 2：条形码3：条形码或二维码

    private int resId;//手动增加字段，无网状态下的默认图标id


    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public int getTokenType() {
        return tokenType;
    }

    public void setTokenType(int tokenType) {
        this.tokenType = tokenType;
    }

    public int getScanType() {
        return scanType;
    }

    public void setScanType(int scanType) {
        this.scanType = scanType;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
