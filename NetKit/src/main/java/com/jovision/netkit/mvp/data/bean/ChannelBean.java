package com.jovision.netkit.mvp.data.bean;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.jovision.netkit.mvp.Constant;

import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.List;

public class ChannelBean extends BaseNode implements Serializable {

    private final String ONLINE = "ONLINE";
    private final String OFFLINE = "OFFLINE";
    private final String UNREGISTERED = "UNREGISTERED";

    private DeviceBean deviceBean;
    private int channelId;
    private String channelName;
    private String channelState;//ONLINE：在线,OFFLINE：离线,UNREGISTERED:未注册
    private String channelType;
    private String shareType;//INIT:初始分享(未分享) ,SHARING：分享中,SHARED：被分享
    private List<String> channelAbility;
//    "ability":[ // 设备支持的能力集
//            "osd", // osd详细的能力集通过osd_get_ability获取
//            "simpleDefence", // 一键布防
//            "driveAway", // 一键驱离
//            "YSTOldCompatibility", // 兼容YST1.0
//            "AudioSet",            //支持音频配置
//            "GunDomeLinkage"		// 支持枪球联动
//            ]

    private String offlineTime;//设备离线时间 格式yyyy-MM-dd HH:mm:ss


    private int cloudStatus;//NVSEEPRO 新协议：设备套餐状态 0-已关闭,1-使用中,2-已到期 3-未开通


//    private String cloudStorageStatus;//设备云存开启状态 OPEN：开启,CLOSE：关闭
    private int lastStreamId;//最后一次的播放码流
    private String bindTime;//	绑定时间
    private String accessProtocol;//PUBLICCLOUD:公有云设备,CLOUDSEE1:云视通1.0设备,CLOUDSEE2:云视通2.0设备

    private int bulletDemoType = -1;//枪球机类型 0-枪机 1-球机 -1-不是枪球设备

    private int relationChannelId = -1;//枪球机相关联通道ID -1不是枪球设备

    private int onlineType;//设备上线类型 0-4G上线 1-网线上线
    private String iccId = "";//4G卡卡号
    private int status;//4G卡状态 0-已停用 1-使用中

    private String deviceIp;//云视通设备Ip
    private int devicePort;//云视通设备端口号
    private String deviceUser;//设备用户名。仅云视通设备有值
    private String devicePwd;//设备密码。仅云视通设备有值
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

    public String getAccessProtocol() {
        return accessProtocol;
    }

    public void setAccessProtocol(String accessProtocol) {
        this.accessProtocol = accessProtocol;
    }

    public int getLastStreamId() {
        return lastStreamId;
    }

    public void setLastStreamId(int lastStreamId) {
        this.lastStreamId = lastStreamId;
    }

    public String getBindTime() {
        return bindTime;
    }

    public void setBindTime(String bindTime) {
        this.bindTime = bindTime;
    }

    public String getChannelState() {
        return channelState;
    }
    public int getChannelStateInt(){
        if (channelState != null && channelState.equals(ONLINE)){
            return 1;//在线
        } else if (channelState != null && channelState.equals(UNREGISTERED)){
            return 2;//未注册
        }
        return 0;//离线
    }

    public void setChannelState(String channelState) {
        this.channelState = channelState;
    }

    public String getShareType() {

//        if(Constant.IS_DEBUG && DebugActivity.isSuperManager){
//            shareType = "SHARING";
//        }

        return shareType;
    }

    public int getShareTypeInt() {
        int a = 0;
//        if(Constant.IS_DEBUG && DebugActivity.isSuperManager){
//            a = 1;
//            return a;
//        }

        if(null == shareType){
            a = 1;
            return a;
        }
        switch (shareType) {
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
//        if(Constant.IS_DEBUG && DebugActivity.isSuperManager){
//            shareType = Constant.SHARING;
//        }
        this.shareType = shareType;
    }
//
//    public String getCloudStorageStatus() {
//        return cloudStorageStatus;
//    }
//
//    public int getCloudStorageStatusInt(){
//        if (cloudStorageStatus != null && cloudStorageStatus.equals(Constant.OPEN)){
//            return 1;
//        }
//        return 0;
//    }
//
//    public void setCloudStorageStatus(String cloudStorageStatus) {
//        this.cloudStorageStatus = cloudStorageStatus;
//    }

    public String getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(String offlineTime) {
        this.offlineTime = offlineTime;
    }

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


    public List<String> getChannelAbility() {
        return channelAbility;
    }

    public void setChannelAbility(List<String> channelAbility) {
        this.channelAbility = channelAbility;
    }

    public boolean isOnline() {
        return channelState!=null && channelState.equals(ONLINE);
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return null;
    }

    private boolean isSelected;
    private boolean enable = true;
    private String deviceSn;


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public DeviceBean getDeviceBean() {
        return deviceBean;
    }

    public void setDeviceBean(DeviceBean deviceBean) {
        this.deviceBean = deviceBean;
        this.weakPwd = deviceBean.getWeakPwd();
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

    public int getBulletDemoType() {
        return bulletDemoType;
    }

    public void setBulletDemoType(int bulletDemoType) {
        this.bulletDemoType = bulletDemoType;
    }

    public int getRelationChannelId() {
        return relationChannelId;
    }

    public void setRelationChannelId(int relationChannelId) {
        this.relationChannelId = relationChannelId;
    }


    public int getCloudStatus() {
        return cloudStatus;
    }

    public void setCloudStatus(int cloudStatus) {
        this.cloudStatus = cloudStatus;
    }
}
