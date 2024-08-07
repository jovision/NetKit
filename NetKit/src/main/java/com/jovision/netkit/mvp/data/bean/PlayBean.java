package com.jovision.netkit.mvp.data.bean;

import android.util.Log;

import java.util.List;

/**
 * Created by zhp on 2020/11/16
 */
public class PlayBean {

    public PlayBean(String deviceType,String model, String deviceId, int channelId,String channelNickname, List<String> device_ability,List<String> channel_ability,
                    int onlineStatus,int shareType,String deviceIp,int devicePort,String deviceUser,String devicePwd,String deviceProtocol,String weakPwd, String fireware) {

        try{
            this.deviceType = deviceType;
            this.model = model;
            this.deviceId = deviceId;
            this.channelId = channelId;
            this.channelNickName = channelNickname;
            this.device_ability = device_ability;
            this.channel_ability = channel_ability;
            this.onlineStatus = onlineStatus;
            this.deviceIp = deviceIp;
            this.devicePort = devicePort;
            this.deviceUser = deviceUser;
            this.devicePwd = devicePwd;
            this.deviceProtocol = deviceProtocol;
            this.weakPwd = weakPwd;
            this.fireware = fireware;

//            for (String ability : device_ability) {
//                Log.e("abilities---Device", "dev-ability=" + ability);
//            }
//
//            for (String ability : channel_ability) {
//                Log.e("abilities---Device-c", "channel-ability=" + ability);
//            }


//        private int shareType;//0:未分享 1：分享中 2：被分享
            if(shareType == 2){
                this.isShared = true;
            } else {
                this.isShared = false;
            }
        } catch (Exception e){
            e.printStackTrace();
        }





    }

    private String deviceType; // nvr ipc 通道
    private String model;//设备具体型号，类似：JVS-T-X43S-4GZ(2.7-13.5mm),R1
    private String fireware;//固件版本号
    private String deviceNickName;// 设备昵称
    private String deviceId;// 设备云视通号码
    private int channelId;
    private String mts;
    private String token;
    private String channelNickName;//通道昵称
    private List<String> device_ability;
    private List<String> channel_ability;
    private boolean isShared;//是否是被分享的设备
    private int onlineStatus;        //设备在线状态
    private String deviceIp;//云视通设备Ip
    private int devicePort;//云视通设备端口号
    private String deviceUser;//云视通设备用户名;
    private String devicePwd;//云视通设备密码
    private String deviceProtocol;//设备协议
    private String weakPwd;//YES;是弱密码,NO：不是弱密码

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

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getMts() {
        return mts;
    }

    public void setMts(String mts) {
        this.mts = mts;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public List<String> getDevice_ability() {
        return device_ability;
    }

    public void setDevice_ability(List<String> device_ability) {
        this.device_ability = device_ability;
    }

    public boolean isShared() {
        return isShared;
    }

    public void setShared(boolean shared) {
        isShared = shared;
    }

    public int getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(int onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public List<String> getChannel_ability() {
        return channel_ability;
    }

    public void setChannel_ability(List<String> channel_ability) {
        this.channel_ability = channel_ability;
    }

    public String getDeviceNickName() {
        return deviceNickName;
    }

    public void setDeviceNickName(String deviceNickName) {
        this.deviceNickName = deviceNickName;
    }

    public String getChannelNickName() {
        return channelNickName;
    }

    public void setChannelNickName(String channelNickName) {
        this.channelNickName = channelNickName;
    }

    public String getDeviceProtocol() {
        return deviceProtocol;
    }

    public void setDeviceProtocol(String deviceProtocol) {
        this.deviceProtocol = deviceProtocol;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFireware() {
        return fireware;
    }

    public void setFireware(String fireware) {
        this.fireware = fireware;
    }
}
