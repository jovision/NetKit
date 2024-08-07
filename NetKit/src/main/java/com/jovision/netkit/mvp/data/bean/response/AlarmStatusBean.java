package com.jovision.netkit.mvp.data.bean.response;

public class AlarmStatusBean {

    private String status;//报警状态 枚举值OPEN-开启 CLOSE-关闭
    private String alarmType;//报警类型

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

}
