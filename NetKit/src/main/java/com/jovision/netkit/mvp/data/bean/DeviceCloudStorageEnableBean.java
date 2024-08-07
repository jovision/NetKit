package com.jovision.netkit.mvp.data.bean;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/12/31
 * 描述：
 */
public class DeviceCloudStorageEnableBean {

//<string name="cloud_always_close">已关闭</string>
//<string name="cloud_using">使用中</string>
//<string name="cloud_time_end">已到期</string>
//<string name="cloud_not_open">未开通</string>

    public static final int CLOUD_ALWAYS_CLOSE = 0;//0-已关闭
    public static final int CLOUD_USING = 1;//1-使用中
    public static final int CLOUD_TIME_END = 2;//2-已到期
    public static final int CLOUD_NOT_OPEN = 3;//3-未开通
    private int cloudStatus;//NVSEEPRO 新协议：设备套餐状态 0-已关闭,1-使用中,2-已到期 3-未开通

    public int getCloudStatus() {
        return cloudStatus;
    }

    public void setCloudStatus(int cloudStatus) {
        this.cloudStatus = cloudStatus;
    }
//    private boolean enable;//老协议：true 已开启;false 未开启
//
//    public boolean isEnable() {
//        return enable;
//    }
//
//    public void setEnable(boolean enable) {
//        this.enable = enable;
//    }



}
