package com.jovision.netkit.mvp.data.bean.response;

public class ShareToMeBean {
    private String deviceSn;
    private String deviceName;
    private String channelType;
    private String channelName;
    private ShareUserInfoBean shareUserInfo;
    private String shareNumber;
    private String shareStatus;
    private String accessProtocol;//枚举: PUBLICCLOUD：公有云设备,CLOUDSEE1：云视通1.0设备,CLOUDSEE2：云视通2.0设备
    private long createTime;

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    private Permission permission;


    public String getShareStatus() {
        return shareStatus;
    }

    public void setShareStatus(String shareStatus) {
        this.shareStatus = shareStatus;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public ShareUserInfoBean getShareUserInfo() {
        return shareUserInfo;
    }

    public void setShareUserInfo(ShareUserInfoBean shareUserInfo) {
        this.shareUserInfo = shareUserInfo;
    }

    public String getShareNumber() {
        return shareNumber;
    }

    public void setShareNumber(String shareNumber) {
        this.shareNumber = shareNumber;
    }


    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }



    @Override
    public String toString() {
        return "ShareToMeBean{" +
                "deviceSn='" + deviceSn + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", channelType='" + channelType + '\'' +
                ", channelName='" + channelName + '\'' +
                ", shareUserInfo=" + shareUserInfo +
                ", shareNumber='" + shareNumber + '\'' +
                ", shareStatus=" + shareStatus +
                ", createTime=" + createTime +
                ", permission='" + permission + '\'' +
                '}';
    }

    public String getAccessProtocol() {
        return accessProtocol;
    }

    public void setAccessProtocol(String accessProtocol) {
        this.accessProtocol = accessProtocol;
    }
}
