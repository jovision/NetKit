package com.jovision.netkit.mvp.data.bean;

/**
 * Created by zhp on 2020/11/25
 */
public class MessageBadgesBean extends BaseEntity {


    /**
     * totalCount : 0
     * alarmCount : 83
     * personalCount : 0
     * systemCount : 0
     */

    private int totalCount;
    private int alarmCount;
    private int personalCount;
    private int systemMsgCount;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getAlarmCount() {
        return alarmCount;
    }

    public void setAlarmCount(int alarmCount) {
        this.alarmCount = alarmCount;
    }

    public int getPersonalCount() {
        return personalCount;
    }

    public void setPersonalCount(int personalCount) {
        this.personalCount = personalCount;
    }

    public int getSystemCount() {
        return systemMsgCount;
    }

    public void setSystemCount(int systemCount) {
        this.systemMsgCount = systemCount;
    }
}
