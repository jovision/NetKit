package com.jovision.netkit.mvp.data.bean.request;

import java.util.List;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/12/9
 * 描述：
 */
public class AlarmMessageRequestBean {

    private List<String> alarmCategories;//报警消息分类列表（不传该参数，默认查询所有分类） 1-设备异常报警、2-移动侦测报警、3-人形检测报警、4-周界入侵报警、5-镜头遮挡报警
    private List<AlarmMessageDeviceBean> devices;
    private String alarmDate;//报警日期 yyyy-MM-dd
    private String pageStartAlarmTime;//分页起始报警时间（即上次分页的最后一条记录的报警时间） 格式：yyyy-MM-dd HH:mm:ss
    private int pageStartId;//分页起始id（即上次分页的最后一条消息的id）
    private int pageSize;//分页大小 默认10（最大100）
    private String pageStartAlarmUuid;//首页使用pageStartAlarmTime+pageStartId 推送和消息列表进入使用pageStartAlarmUuid

    public String getPageStartAlarmUuid() {
        return pageStartAlarmUuid;
    }

    public void setPageStartAlarmUuid(String pageStartAlarmUuid) {
        this.pageStartAlarmUuid = pageStartAlarmUuid;
    }

    public List<String> getAlarmCategories() {
        return alarmCategories;
    }

    public void setAlarmCategories(List<String> alarmCategories) {
        this.alarmCategories = alarmCategories;
    }

    public List<AlarmMessageDeviceBean> getDevices() {
        return devices;
    }

    public void setDevices(List<AlarmMessageDeviceBean> devices) {
        this.devices = devices;
    }

    public String getAlarmDate() {
        return alarmDate;
    }

    public void setAlarmDate(String alarmDate) {
        this.alarmDate = alarmDate;
    }

    public String getPageStartAlarmTime() {
        return pageStartAlarmTime;
    }

    public void setPageStartAlarmTime(String pageStartAlarmTime) {
        this.pageStartAlarmTime = pageStartAlarmTime;
    }

    public int getPageStartId() {
        return pageStartId;
    }

    public void setPageStartId(int pageStartId) {
        this.pageStartId = pageStartId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public  static class AlarmMessageDeviceBean{
        private String deviceSn;
        private int channelId;

        public String getDeviceSn() {
            return deviceSn;
        }

        public void setDeviceSn(String deviceSn) {
            this.deviceSn = deviceSn;
        }

        public int getChannelId() {
            return channelId;
        }

        public void setChannelId(int channelId) {
            this.channelId = channelId;
        }
    }


}
