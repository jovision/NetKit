package com.jovision.netkit.mvp.data.bean;

import com.jovision.netkit.mvp.data.bean.response.Permission;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2021/5/20
 * 描述：
 */
public class ShareDetail {

//    枚举:
//    INIT ：初始分享 ,
//    IGNORE ：被分享人忽略分享 ,
//    SHARE_CANCEL ：分享人取消分享 ,
//    SHARED_CANCEL :被分享人取消分享 ,
//    AUTO_CANCEL :超时自动取消分享 ,
//    ACCEPT :被分享人接收分享

    public static final String INIT = "INIT";
    public static final String IGNORE = "IGNORE";
    public static final String SHARE_CANCEL = "SHARE_CANCEL";
    public static final String SHARED_CANCEL = "SHARED_CANCEL";
    public static final String AUTO_CANCEL = "AUTO_CANCEL";
    public static final String ACCEPT = "ACCEPT";




    /**
     * channelId : 0
     * channelName : 十一
     * channelType : IPC
     * deviceName : 十一
     * deviceSn : 12421SSKDVUQ
     * permission : 111111
     * shareStatus : 20
     * shareUserInfo : {"account":"13181747573","nickname":"十一"}
     * sharedUserInfo : {"account":"18764174650","headPictureUrl":"https://jvcloud-saas.obs.cn-north-4.myhuaweicloud.com:443/beaa669b/24985191620210311182112/3cab6a112371c837d56b903ce25788cb.jpg?AccessKeyId=ENQZB7VAYUTCYKDDHMA3&Expires=1621478341&Signature=B1Wzp7c5fQDSD8bh8Q28uprFqFc%3D","nickname":"ivs_249851","userId":"24985191620210311182112"}
     */

    private int channelId;
    private String channelName;
    private String channelType;
    private String deviceName;
    private String deviceSn;
    private Permission permission;
    private String shareStatus;//枚举: INIT ：初始分享 ,IGNORE ：被分享人忽略分享 ,SHARE_CANCEL ：分享人取消分享 ,SHARED_CANCEL :被分享人取消分享 ,AUTO_CANCEL :超时自动取消分享 ,ACCEPT :被分享人接收分享
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


    public String getShareStatus() {
        return shareStatus;
    }

    public void setShareStatus(String shareStatus) {
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

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public static class ShareUserInfoBean {
        /**
         * account : 13181747573
         * nickname : 十一
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
         * headPictureUrl : https://jvcloud-saas.obs.cn-north-4.myhuaweicloud.com:443/beaa669b/24985191620210311182112/3cab6a112371c837d56b903ce25788cb.jpg?AccessKeyId=ENQZB7VAYUTCYKDDHMA3&Expires=1621478341&Signature=B1Wzp7c5fQDSD8bh8Q28uprFqFc%3D
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
