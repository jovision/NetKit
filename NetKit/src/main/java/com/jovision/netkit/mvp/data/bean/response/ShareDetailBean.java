package com.jovision.netkit.mvp.data.bean.response;

public class ShareDetailBean {
    private String deviceSn;
    private String deviceName;
//    private String channelType;
//    private String channelId;
//    private String channelName;
    private ShareUserInfoBean shareUserInfo;
    private SharedUserInfoBean sharedUserInfo;
    private String shareStatus;
    private Permission permission;




    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
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

//    public String getChannelType() {
//        return channelType;
//    }
//
//    public void setChannelType(String channelType) {
//        this.channelType = channelType;
//    }
//
//    public String getChannelId() {
//        return channelId;
//    }
//
//    public void setChannelId(String channelId) {
//        this.channelId = channelId;
//    }
//
//    public String getChannelName() {
//        return channelName;
//    }
//
//    public void setChannelName(String channelName) {
//        this.channelName = channelName;
//    }

    public ShareUserInfoBean getShareUserInfo() {
        return shareUserInfo;
    }

    public void setShareUserInfo(ShareUserInfoBean shareUserInfo) {
        this.shareUserInfo = shareUserInfo;
    }

    public SharedUserInfoBean getSharedUserInfo() {
        return sharedUserInfo;
    }

    public void setSharedUserInfo(SharedUserInfoBean sharedUserInfo) {
        this.sharedUserInfo = sharedUserInfo;
    }

    public String getShareStatus() {
        return shareStatus;
    }

    public void setShareStatus(String shareStatus) {
        this.shareStatus = shareStatus;
    }

//    public String getPermission() {
//        return permission;
//    }
//
//    public void setPermission(String permission) {
//        this.permission = permission;
//    }

    @Override
    public String toString() {
        return "ShareDetailBean{" +
                "deviceSn='" + deviceSn + '\'' +
                ", deviceName='" + deviceName + '\'' +
//                ", channelType='" + channelType + '\'' +
//                ", channelId='" + channelId + '\'' +
//                ", channelName='" + channelName + '\'' +
                ", shareUserInfo=" + shareUserInfo +
                ", sharedUserInfo=" + sharedUserInfo +
                ", shareStatus='" + shareStatus + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
