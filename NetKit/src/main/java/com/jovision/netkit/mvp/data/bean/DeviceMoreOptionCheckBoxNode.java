package com.jovision.netkit.mvp.data.bean;

public class DeviceMoreOptionCheckBoxNode extends BaseDeviceMoreOptionNode{

    private boolean isChecked;

    public DeviceMoreOptionCheckBoxNode(int optionType, boolean isChecked) {
        super(optionType);
        this.isChecked = isChecked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
