package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;

public class Permission implements Serializable {
    private boolean view;
    private boolean cloudRecord;
    private boolean localRecord;
    private boolean ptz;
    private boolean voice;
    private boolean alarmMsg;

    public boolean isView() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    public boolean isCloudRecord() {
        return cloudRecord;
    }

    public void setCloudRecord(boolean cloudRecord) {
        this.cloudRecord = cloudRecord;
    }

    public boolean isLocalRecord() {
        return localRecord;
    }

    public void setLocalRecord(boolean localRecord) {
        this.localRecord = localRecord;
    }

    public boolean isPtz() {
        return ptz;
    }

    public void setPtz(boolean ptz) {
        this.ptz = ptz;
    }

    public boolean isVoice() {
        return voice;
    }

    public void setVoice(boolean voice) {
        this.voice = voice;
    }

    public boolean isAlarmMsg() {
        return alarmMsg;
    }

    public void setAlarmMsg(boolean alarmMsg) {
        this.alarmMsg = alarmMsg;
    }

}
