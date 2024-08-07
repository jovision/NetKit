package com.jovision.netkit.mvp.data.bean;

import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;

import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DeviceBean extends BaseExpandNode implements Serializable {

    private final String ONLINE = "ONLINE";

    private String deviceSn;
    private String deviceName = "";
    private String onlineState;//ONLINE：在线,OFFLINE：离线
    private List<String> ability;//设备能力集获取哭声检测babycryai, 宠物检测petai
    private int linkMode;//视频连接模式 0-云视通，1-ip端口 【新增】
    private String bindTime;//绑定时间【新增】
    private int channelNum;//通道数
    private String deviceIp;//云视通设备Ip
    private int devicePort;//云视通设备端口号
    private String deviceUser;//云视通设备用户名;
    private String devicePwd;//云视通设备密码
    private String weakPwd;//YES;是弱密码,NO：不是弱密码
    private String ownType;//OWNER：所有者,SHARE：被分享者
    private String deviceType;//IPC  NVR
    private String model;//设备具体型号，类似：JVS-T-X43S-4GZ(2.7-13.5mm),R1
    private String currentVersion;
    private String latestVersion;
    private int channelCnt;
    private String ct;
    private String accessProtocol;//PUBLICCLOUD:公有云设备,CLOUDSEE1:云视通1.0设备,CLOUDSEE2:云视通2.0设备
    private int isBulletDemoDevice = 0;//是否枪球设备1：是；0：不是；是否包含枪球设备 0-否 1-是
    private List<ChannelBean> channelList;

    private Permission permission;//被分享权限

    public DeviceBean() {
        setExpanded(false);
    }


    public int getLinkMode() {
        return linkMode;
    }

    public void setLinkMode(int linkMode) {
        this.linkMode = linkMode;
    }

    public String getBindTime() {
        return bindTime;
    }

    public void setBindTime(String bindTime) {
        this.bindTime = bindTime;
    }

    public int getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(int channelNum) {
        this.channelNum = channelNum;
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

    public String getWeakPwd() {
        return weakPwd;
    }

    public void setWeakPwd(String weakPwd) {
        this.weakPwd = weakPwd;
    }

    public String getOwnType() {
        return ownType;
    }

    public void setOwnType(String ownType) {
        this.ownType = ownType;
    }

    public String getOnlineState() {
        return onlineState;
    }

    public int getOnlineStateInt() {
        if (onlineState != null && onlineState.equals(ONLINE)) {
            return 1;
        }
        return 0;
    }

    public void setOnlineState(String onlineState) {
        this.onlineState = onlineState;
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

    public List<String> getAbility() {
        return ability;
    }

    public void setAbility(List<String> ability) {
        this.ability = ability;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public int getChannelCnt() {
        return channelCnt;
    }

    public void setChannelCnt(int channelCnt) {
        this.channelCnt = channelCnt;
    }

    public List<ChannelBean> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<ChannelBean> channelList) {
        this.channelList = channelList;
    }

    private boolean isSelected;
    private boolean enable = true;

    public boolean isOnline() {
        return onlineState != null && onlineState.equals(ONLINE);
    }

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

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return channelBeans;
    }

    private List<BaseNode> channelBeans = new ArrayList<>();

    public void setChannelsBeans() {
        this.channelBeans.clear();
        if (channelList != null) {
            this.channelBeans.addAll(channelList);
        }
        setExpanded(false);
    }

    private ChannelBean channelBean;

    public ChannelBean getChannelBean() {
        return channelBean;
    }

    public void setChannelBean(ChannelBean channelBean) {
        this.channelBean = channelBean;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int isBulletDemoDevice() {
        return isBulletDemoDevice;
    }

    public void setBulletDemoDevice(int bulletDemoDevice) {
        isBulletDemoDevice = bulletDemoDevice;
    }


    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }


    public class Permission implements Serializable {
        private boolean view = true;//视频预览
        private boolean cloudRecord = false;//云端录像回放，云视通设备没有该权限
        private boolean localRecord = false;//本地录像回放
        private boolean ptz = false;//云台控制
        private boolean voice = false;//语音对讲
        private boolean alarmMsg = false;//报警消息


        public boolean isView() {
            return view;
        }

        public void setView(boolean view) {
            this.view = view;
        }

        public boolean isCloudRecord() {
            return cloudRecord;
        }

        public void setCloudRecord(boolean cloudRecord) {
            this.cloudRecord = cloudRecord;
        }

        public boolean isLocalRecord() {
            return localRecord;
        }

        public void setLocalRecord(boolean localRecord) {
            this.localRecord = localRecord;
        }

        public boolean isPtz() {
            return ptz;
        }

        public void setPtz(boolean ptz) {
            this.ptz = ptz;
        }

        public boolean isVoice() {
            return voice;
        }

        public void setVoice(boolean voice) {
            this.voice = voice;
        }

        public boolean isAlarmMsg() {
            return alarmMsg;
        }

        public void setAlarmMsg(boolean alarmMsg) {
            this.alarmMsg = alarmMsg;
        }
    }
}
