package com.jovision.netkit.mvp.data.bean;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2021/3/6
 * 描述：
 */
public class MessageAlarmListDetailBean {


    /**
     * alarmUuid : 12421SSB6N87_0_region_invasion_alarm_20210306113143_72
     * alarmCategory : 4
     * alarmType : 401
     * deviceSn : 12421SSB6N87
     * channelId : 0
     * deviceName : deli的设12346797979799你也
     * channelName : deli的设12346797979799你也
     * startTime : 2021-03-06 11:31:43
     * stopTime : 2021-03-06 11:31:45
     * readStatus : 1
     */

    private String alarmUuid;
    private String alarmCategory;
    private String alarmType;
    private String deviceSn;
    private int channelId;
    private String deviceName;
    private String channelName;
    private String alarmTime;//报警时间 yyyy-MM-dd HH:mm:ss
    private String startTime;
    private String stopTime;
    private String readStatus;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getAlarmUuid() {
        return alarmUuid;
    }

    public void setAlarmUuid(String alarmUuid) {
        this.alarmUuid = alarmUuid;
    }

    public String getAlarmCategory() {
        return alarmCategory;
    }

    public void setAlarmCategory(String alarmCategory) {
        this.alarmCategory = alarmCategory;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public String getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime;
    }
}
