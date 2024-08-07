package com.jovision.netkit.mvp.data.bean.response;

//检查设备多人绑定状态
public class MultiBindBean {

    private boolean isMultiUserBind; //是否多人绑定
    private int frequency; //提醒频率（1：表示1天1次；3：表示1天3次）

    public boolean isMultiUserBind() {
        return isMultiUserBind;
    }

    public void setMultiUserBind(boolean multiUserBind) {
        isMultiUserBind = multiUserBind;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
