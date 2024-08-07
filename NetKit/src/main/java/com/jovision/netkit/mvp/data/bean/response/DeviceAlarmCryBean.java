package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;

/**
 * 哭声检测
 */
public class DeviceAlarmCryBean implements Serializable {

    private int channelid;
    private boolean enable;
    private String sensitivity;//high,middle,low 高中低
    private int alarm_defence_plan_id;//布防时间计划id
    private int alarm_link_id;//报警联动计划id

    public int getChannelid() {
        return channelid;
    }

    public void setChannelid(int channelid) {
        this.channelid = channelid;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(String sensitivity) {
        this.sensitivity = sensitivity;
    }

    public int getAlarm_defence_plan_id() {
        return alarm_defence_plan_id;
    }

    public void setAlarm_defence_plan_id(int alarm_defence_plan_id) {
        this.alarm_defence_plan_id = alarm_defence_plan_id;
    }

    public int getAlarm_link_id() {
        return alarm_link_id;
    }

    public void setAlarm_link_id(int alarm_link_id) {
        this.alarm_link_id = alarm_link_id;
    }

}
