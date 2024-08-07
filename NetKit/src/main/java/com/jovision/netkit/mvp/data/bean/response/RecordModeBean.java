package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

public class RecordModeBean {
    private String deviceSn;
    private int channelId;
    private String type;//录像类型 0-停止录像 1-全天录像 2-分时段录像 ==== 录像模式 STOP-停止录像，ALL_DAY-全天录像，DAY_PARTING-分时段录像
    private List<TimeSlot> time;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TimeSlot> getTime() {
        return time;
    }

    public void setTime(List<TimeSlot> time) {
        this.time = time;
    }
}
