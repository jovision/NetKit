package com.jovision.netkit.mvp.data.bean;


import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.jovision.netkit.mvp.Constant;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NvrNodeBean extends BaseExpandNode {

    private List<BaseNode> childNodeList;

    private String deviceSn;
    private String deviceName;
    private int onlineState;
    private int shareType;//0:未分享 1：分享中 2：被分享
    private List<String> ability;
    private String deviceType;
    private String model;//设备具体型号，类似：JVS-T-X43S-4GZ(2.7-13.5mm),R1
    private int channelCnt;
    private List<ChannelBean> channelList;
    private boolean isShow = true;
    private int cloudStorageStatus;
    private boolean selected = false;
    private String deviceIp;//云视通设备Ip
    private int devicePort;//云视通设备端口号
    private String deviceUser;//云视通设备用户名;
    private String devicePwd;//云视通设备密码
    private String accessProtocol;//接入协议

    public String getAccessProtocol() {
        return accessProtocol;
    }

    public void setAccessProtocol(String accessProtocol) {
        this.accessProtocol = accessProtocol;
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getCloudStorageStatus() {
        return cloudStorageStatus;
    }

    public void setCloudStorageStatus(int cloudStorageStatus) {
        this.cloudStorageStatus = cloudStorageStatus;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
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

    public NvrNodeBean(List<BaseNode> childNodeList) {
        this.childNodeList = childNodeList;
        setExpanded(false);
    }

    public int getShareType() {
//        if (Constant.IS_DEBUG && DebugActivity.isSuperManager) {
//            shareType = 1;
//            return 1;
//        }
        return shareType;
    }

    public void setShareType(int shareType) {

//        if (Constant.IS_DEBUG && DebugActivity.isSuperManager) {
//            shareType = 1;
//        }

        this.shareType = shareType;
    }


    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return childNodeList;
    }

/************************首页设备列表:使用于自定义的展示收起操作--begin********************************/

    /**
     * 保存子项的原始所有通道数据
     */
    private List<BaseNode> allChildNodeList = new ArrayList<>();

    /**
     * 子项展示模式
     * <p>
     * true:全部展示;false:缩略展示,只展示前几项
     */
    private boolean isAllChildMode = true;

    /**
     * 获取全部通道数据
     *
     * @return
     */
    public List<BaseNode> getAllChildNodeList() {
        return allChildNodeList;
    }

    public void setAllChildNodeList(List<BaseNode> allChildNodeList) {
        this.allChildNodeList.clear();
        if (allChildNodeList != null) {
            this.allChildNodeList.addAll(allChildNodeList);
        }
    }

    public void setAllChildMode(boolean allChildMode) {
        isAllChildMode = allChildMode;
    }

    public boolean isAllChildMode() {
        return isAllChildMode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

/************************首页设备列表:使用于自定义的展示收起操作--end********************************/
}
