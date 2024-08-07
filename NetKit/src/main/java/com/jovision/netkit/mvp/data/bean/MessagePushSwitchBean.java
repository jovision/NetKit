package com.jovision.netkit.mvp.data.bean;

/**
 * Created by zhp on 2020/12/1
 */
public class MessagePushSwitchBean {

    /**
     * alarmSwitch : 1
     * userSwitch : 1
     * noticeSwitch : 1
     */

    private int alarmSwitch;
    private int userSwitch;
    private int noticeSwitch;
    private int offlineSwitch;

    public int getAlarmSwitch() {
        return alarmSwitch;
    }

    public void setAlarmSwitch(int alarmSwitch) {
        this.alarmSwitch = alarmSwitch;
    }

    public int getUserSwitch() {
        return userSwitch;
    }

    public void setUserSwitch(int userSwitch) {
        this.userSwitch = userSwitch;
    }

    public int getNoticeSwitch() {
        return noticeSwitch;
    }

    public void setNoticeSwitch(int noticeSwitch) {
        this.noticeSwitch = noticeSwitch;
    }

    public int getOfflineSwitch() {
        return offlineSwitch;
    }

    public void setOfflineSwitch(int offlineSwitch) {
        this.offlineSwitch = offlineSwitch;
    }
}
