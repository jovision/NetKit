package com.jovision.netkit.mvp.data.bean;

import com.chad.library.adapter.base.entity.node.BaseNode;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BaseDeviceMoreOptionNode extends BaseNode {

    //公有云主NVR
    public static final int MORE_FUNCTION_CLOUD_STORAGE = 0;//云存储
    public static final int MORE_FUNCTION_DEVICE_SHARE = 1; //设备共享
    public static final int MORE_FUNCTION_RECORD = 2;       //录像回放
    public static final int MORE_FUNCTION_DEVICE_SETTING = 3;//设备设置
    public static final int MORE_FUNCTION_ALARM_MSG = 4;    //报警消息
    public static final int MORE_FUNCTION_PREVIEW_ALL = 5;  //预览全部通道
    public static final int MORE_FUNCTION_SHARE_DETAIL = 6; //共享详情
    public static final int MORE_FUNCTION_DEVICE_DETAIL = 7; //设备详情
    public static final int MORE_FUNCTION_LINK_SETTING = 8; //连接详情
    public static final int MORE_FUNCTION_PRIVATE = 9; //连接详情
    public static final int MORE_FUNCTION_SYNC_RECORD = 10; //同步回放
    public static final int MORE_FUNCTION_CHANNEL_SETTING = 11;//枪球通道设置



    private int optionType;
    private int imgResId;
    private int optionNameResId;
    private boolean hasDot;

    public BaseDeviceMoreOptionNode(int optionType) {
        this.optionType = optionType;
    }

    public BaseDeviceMoreOptionNode(int optionType, boolean hasDot) {
        this.optionType = optionType;
        this.hasDot = hasDot;
    }

    public boolean isHasDot() {
        return hasDot;
    }

    public void setHasDot(boolean hasDot) {
        this.hasDot = hasDot;
    }

    public int getOptionType() {
        return optionType;
    }

    public void setOptionType(int optionType) {
        this.optionType = optionType;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }

    public int getOptionNameResId() {
        return optionNameResId;
    }

    public void setOptionNameResId(int optionNameResId) {
        this.optionNameResId = optionNameResId;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return null;
    }
}
