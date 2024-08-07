package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

public class ShareInfoBean {
//    public static final int INIT = 0;//初始分享
//    public static final int IGNORE = 10;//被分享人忽略分享
//    public static final int SHARE_CANCEL = 20;//分享人取消分享
//    public static final int SHARED_CANCEL = 30;//被分享人取消分享
//    public static final int AUTO_CANCEL = 40;//超时自动取消分享
//    public static final int ACCEPT = 50;//被分享人接收分享

    public static final String INIT = "INIT";//初始分享
    public static final String IGNORE = "IGNORE";//被分享人忽略分享
    public static final String SHARE_CANCEL = "SHARE_CANCEL";//分享人取消分享
    public static final String SHARED_CANCEL = "SHARED_CANCEL";//被分享人取消分享
    public static final String AUTO_CANCEL = "AUTO_CANCEL";//超时自动取消分享
    public static final String ACCEPT = "ACCEPT";//被分享人接收分享

    private String shareNumber;
//    private int shareStatus;//INIT(0,"初始分享"),IGNORE(10,"被分享人忽略分享"),SHARE_CANCEL(20,"分享人取消分享"),SHARED_CANCEL(30,"被分享人取消分享"),AUTO_CANCEL(40,"超时自动取消分享"),ACCEPT(50,"被分享人接收分享"),
    private String shareStatus;//INIT(0,"初始分享"),IGNORE(10,"被分享人忽略分享"),SHARE_CANCEL(20,"分享人取消分享"),SHARED_CANCEL(30,"被分享人取消分享"),AUTO_CANCEL(40,"超时自动取消分享"),ACCEPT(50,"被分享人接收分享"),
    private Permission permission;//	权限字段 长度为6， 1代表有权限0代表没有权限 VIEW(0,"视频预览"),CLOUD_RECORD(1,"云端录像回放"),LOCAL_RECORD(2,"本地录像回放"),PTZ(3,"云台控制"),VOICE(4,"语音对讲"),ALARM_MSG(5,"报警消息")
    private SharedUserInfoBean sharedUserInfo;

    public String getShareNumber() {
        return shareNumber;
    }

    public void setShareNumber(String shareNumber) {
        this.shareNumber = shareNumber;
    }

    public String getShareStatus() {
        return shareStatus;
    }

    public void setShareStatus(String shareStatus) {
        this.shareStatus = shareStatus;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    //    public String getPermission() {
//        return permission;
//    }
//
//    public void setPermission(String permission) {
//        this.permission = permission;
//    }

    public SharedUserInfoBean getSharedUserInfo() {
        return sharedUserInfo;
    }

    public void setSharedUserInfo(SharedUserInfoBean sharedUserInfo) {
        this.sharedUserInfo = sharedUserInfo;
    }






    @Override
    public String toString() {
        return "ShareInfoBean{" +
                "shareNumber='" + shareNumber + '\'' +
                ", shareStatus=" + shareStatus +
                ", permission='" + permission + '\'' +
                ", sharedUserInfo=" + sharedUserInfo +
                '}';
    }
}
