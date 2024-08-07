package com.jovision.netkit.mvp.data.bean;


import com.chad.library.adapter.base.entity.node.BaseNode;
import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.bean.request.CreateSceneChannelRequestBean;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DeviceNodeBean extends BaseNode {
    public static final int SHARE_TYPE_NO_SHARE = 0;
    public static final int SHARE_TYPE_SHAREING = 1;
    public static final int SHARE_TYPE_BE_SHARED = 2;

    private boolean isChecked;
    private boolean isChild;
    private String deviceSn;// 设备云视通号码
    private String deviceName;
    private String deviceType;
    private String model;//设备具体型号，类似：JVS-T-X43S-4GZ(2.7-13.5mm),R1
    private String channelName;
    private int shareType;//0:未分享 1：分享中 2：被分享
    private int channelState;//从通道读取的通道的在线状态 1;//在线；2;//未注册；0;//离线
//    public int getChannelStateInt(){
//        if (channelState != null && channelState.equals(ONLINE)){
//            return 1;//在线
//        } else if (channelState != null && channelState.equals(UNREGISTERED)){
//            return 2;//未注册
//        }
//        return 0;//离线
//    }
    private String channelType;
    private int channelId;
    private List<String> channelAbility;
    private int onlineState;
    private String offlineTime;
    private List<String> ability;
    private boolean hideStatus;

    private int cloudStorageStatus;//设备套餐状态 0-已关闭,1-使用中,2-已到期 3-未开通
    private boolean isShow = true;
    private String ct;//配网方式
    private String currentVersion;
    private String latestVersion;
    private String deviceIp;//云视通设备Ip
    private int devicePort;//云视通设备端口号
    private String deviceUser;//云视通设备用户名;
    private String devicePwd;//云视通设备密码
    private String deviceProtocol;//播放协议
    private String weakPwd;
    private List<ChannelBean> channelList;
    private int isBulletDemoDevice;//是否枪球设备1：是；0：不是；


    private DeviceBean.Permission permission;//被分享权限

    public int isBulletDemoDevice() {
        return isBulletDemoDevice;
    }

    public void setBulletDemoDevice(int bulletDemoDevice) {
        isBulletDemoDevice = bulletDemoDevice;
    }

//    //SceneChannelsBean 场景下的设备列表用这个属性
//    private int onlineType;//设备上线类型 0-4G上线 1-网线上线
//    private String iccId;//4G卡卡号
//    private int status;//4G卡状态 0-已停用 1-使用中

    public String getWeakPwd() {
        return weakPwd;
    }

    public void setWeakPwd(String weakPwd) {
        this.weakPwd = weakPwd;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public int getDevicePort() {
        return devicePort;
    }

    public void setDevicePort(int devicePort) {
        this.devicePort = devicePort;
    }

    public String getDeviceUser() {
        return deviceUser;
    }

    public void setDeviceUser(String deviceUser) {
        this.deviceUser = deviceUser;
    }

    public String getDevicePwd() {
        return devicePwd;
    }

    public void setDevicePwd(String devicePwd) {
        this.devicePwd = devicePwd;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public int getCloudStorageStatus() {
        return cloudStorageStatus;
    }

    public void setCloudStorageStatus(int cloudStorageStatus) {
        this.cloudStorageStatus = cloudStorageStatus;
    }

    public String getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(String offlineTime) {
        this.offlineTime = offlineTime;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
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

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getChannelState() {
        return channelState;
    }

    public void setChannelState(int channelState) {
        this.channelState = channelState;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public List<String> getChannelAbility() {
        return channelAbility;
    }

    public void setChannelAbility(List<String> channelAbility) {
        this.channelAbility = channelAbility;
    }

    public int getOnlineState() {
        return onlineState;
    }

    public void setOnlineState(int onlineState) {
        this.onlineState = onlineState;
    }

    public List<String> getAbility() {
        return ability;
    }

    public void setAbility(List<String> ability) {
        this.ability = ability;
    }

    public int getShareType() {
//        if (Constant.IS_DEBUG && DebugActivity.isSuperManager) {
//            shareType = 1;
//            return shareType;
//        }
        return shareType;
    }

    public void setShareType(int shareType) {
//        if (Constant.IS_DEBUG && DebugActivity.isSuperManager) {
//            shareType = 1;
//        }

        this.shareType = shareType;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setChild(boolean child) {
        isChild = child;
    }

    public boolean isHideStatus() {
        return hideStatus;
    }

    public void setHideStatus(boolean hideStatus) {
        this.hideStatus = hideStatus;
    }

    public DeviceNodeBean() {
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return null;
    }

    public CreateSceneChannelRequestBean convertToCreateSceneChannelRequestBean() {
        CreateSceneChannelRequestBean createSceneChannelRequestBean = new CreateSceneChannelRequestBean();
        createSceneChannelRequestBean.setChannelId(channelId);
        createSceneChannelRequestBean.setDeviceSn(deviceSn);
        return createSceneChannelRequestBean;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }

    public String getDeviceProtocol() {
        return deviceProtocol;
    }

    public void setDeviceProtocol(String deviceProtocol) {
        this.deviceProtocol = deviceProtocol;
    }

/************************首页设备列表:拼接背景的空白占位--begin********************************/

    /**
     * 是否为空白占位
     */
    private boolean isEmptyPlaceHolder = false;

    public boolean isEmptyPlaceHolder() {
        return isEmptyPlaceHolder;
    }

    public void setEmptyPlaceHolder(boolean emptyPlaceHolder) {
        isEmptyPlaceHolder = emptyPlaceHolder;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<ChannelBean> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<ChannelBean> channelList) {
        this.channelList = channelList;
    }

    public DeviceBean.Permission getPermission() {
        return permission;
    }

    public void setPermission(DeviceBean.Permission permission) {
        this.permission = permission;
    }

//    public int getOnlineType() {
//        return onlineType;
//    }
//
//    public void setOnlineType(int onlineType) {
//        this.onlineType = onlineType;
//    }
//
//    public String getIccId() {
//        return iccId;
//    }
//
//    public void setIccId(String iccId) {
//        this.iccId = iccId;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }

/************************首页设备列表:拼接背景的空白占位--end********************************/
}
