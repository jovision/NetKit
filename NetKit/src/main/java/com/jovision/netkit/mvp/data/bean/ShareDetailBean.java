package com.jovision.netkit.mvp.data.bean;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2021/6/1
 * 描述：
 */
public class ShareDetailBean {


    /**
     * channelId : 0
     * channelName : 哈哈
     * channelType : IPC
     * deviceName : 哈哈
     * deviceSn : 12421SSKDVUQ
     * permission : 100000
     * shareStatus : 20
     * shareUserInfo : {"account":"13181747573","nickname":"1234567890"}
     * sharedUserInfo : {"account":"18764174650","headPictureUrl":"https://jvcloud-saas.obs.cn-north-4.myhuaweicloud.com:443/beaa669b/24985191620210311182112/3cab6a112371c837d56b903ce25788cb.jpg?AccessKeyId=ENQZB7VAYUTCYKDDHMA3&Expires=1622543391&Signature=hyBRR41PSn8SEYF2IZsYCuJvfB8=","nickname":"ivs_249851","userId":"24985191620210311182112"}
     */

    private int channelId;
    private String channelName;
    private String channelType;
    private String deviceName;
    private String deviceSn;
    private String permission;
    private int shareStatus;
    private ShareUserInfoBean shareUserInfo;
    private SharedUserInfoBean sharedUserInfo;

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getShareStatus() {
        return shareStatus;
    }

    public void setShareStatus(int shareStatus) {
        this.shareStatus = shareStatus;
    }

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

    public static class ShareUserInfoBean {
        /**
         * account : 13181747573
         * nickname : 1234567890
         */

        private String account;
        private String nickname;

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }

    public static class SharedUserInfoBean {
        /**
         * account : 18764174650
         * headPictureUrl : https://jvcloud-saas.obs.cn-north-4.myhuaweicloud.com:443/beaa669b/24985191620210311182112/3cab6a112371c837d56b903ce25788cb.jpg?AccessKeyId=ENQZB7VAYUTCYKDDHMA3&Expires=1622543391&Signature=hyBRR41PSn8SEYF2IZsYCuJvfB8=
         * nickname : ivs_249851
         * userId : 24985191620210311182112
         */

        private String account;
        private String headPictureUrl;
        private String nickname;
        private String userId;

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getHeadPictureUrl() {
            return headPictureUrl;
        }

        public void setHeadPictureUrl(String headPictureUrl) {
            this.headPictureUrl = headPictureUrl;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
