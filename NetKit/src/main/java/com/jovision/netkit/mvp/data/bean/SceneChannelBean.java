package com.jovision.netkit.mvp.data.bean;


import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.bean.request.CreateSceneChannelRequestBean;

import java.util.List;

import static com.jovision.netkit.mvp.Constant.ONLINE;

public class SceneChannelBean {
    private String deviceSn;
    private String deviceName;
    private String deviceType;
    private String shareType;//通道的分享状态--0:未分享 1：分享中 2：被分享 INIT:未分享 SHARING：分享中 SHARED：被分享
    private String channelName;
    private String channelState;//通道在线状态（ONLINE：在线；OFFLINE：离线） 1在线，0离线
    private String channelType;
    private int channelId;
    private List<String> channelAbility;
    private List<String> ability;
    private String offlineTime;
    private String cloudStorageStatus;//设备云存开启状态 0-关闭 1-开启 CLOSE-关闭 OPEN-开启
    private int lastStreamId;//最后一次的播放码流
    private String ct;
    private String accessProtocol;// PUBLICCLOUD:公有云设备,CLOUDSEE1:云视通1.0设备,CLOUDSEE2:云视通2.0设备

    private String deviceUser;//云视通设备用户名;
    private String devicePwd;//云视通设备密码
    private String model;//设备具体型号，类似：JVS-T-X43S-4GZ(2.7-13.5mm),R1

    private int onlineType;//设备上线类型 0-4G上线 1-网线上线
    private String iccId;//4G卡卡号
    private int status;//4G卡状态 0-已停用 1-使用中

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

    public String getShareType() {
//        if(Constant.IS_DEBUG && DebugActivity.isSuperManager){
//            shareType = "SHARING";
//        }
        return shareType;
    }

    public int getShareTypeInt(){
        int a = 0;
        switch (shareType){
            case Constant.INIT:
                a = 0;
                break;
            case Constant.SHARING:
                a = 1;
                break;
            case Constant.SHARED:
                a = 2;
                break;
            default:
                a = 0;
                break;
        }
        return a;
    }
    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public String getChannelState() {
        return channelState;
    }
    public int getChannelStateInt(){
        if (channelState != null && channelState.equals(ONLINE)){
            return 1;
        }
        return 0;
    }
    public void setChannelState(String channelState) {
        this.channelState = channelState;
    }

    public String getCloudStorageStatus() {
        return cloudStorageStatus;
    }

    public int getCloudStorageStatusInt(){
        if (cloudStorageStatus != null && cloudStorageStatus.equals(Constant.OPEN)){
            return 1;
        }
        return 0;
    }

    public void setCloudStorageStatus(String cloudStorageStatus) {
        this.cloudStorageStatus = cloudStorageStatus;
    }

    public int getLastStreamId() {
        return lastStreamId;
    }

    public void setLastStreamId(int lastStreamId) {
        this.lastStreamId = lastStreamId;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getAccessProtocol() {
        return accessProtocol;
    }

    public void setAccessProtocol(String accessProtocol) {
        this.accessProtocol = accessProtocol;
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

    public String getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(String offlineTime) {
        this.offlineTime = offlineTime;
    }

    public List<String> getAbility() {
        return ability;
    }

    public void setAbility(List<String> ability) {
        this.ability = ability;
    }

    public CreateSceneChannelRequestBean convertToCreateSceneChannelRequestBean(){
        CreateSceneChannelRequestBean createSceneChannelRequestBean = new CreateSceneChannelRequestBean();
        createSceneChannelRequestBean.setChannelId(channelId);
        createSceneChannelRequestBean.setDeviceSn(deviceSn);
        return createSceneChannelRequestBean;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getOnlineType() {
        return onlineType;
    }

    public void setOnlineType(int onlineType) {
        this.onlineType = onlineType;
    }

    public String getIccId() {
        return iccId;
    }

    public void setIccId(String iccId) {
        this.iccId = iccId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
