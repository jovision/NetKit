package com.jovision.netkit.mvp.data.bean;

public class DeviceMoreOptionCornerNode extends BaseDeviceMoreOptionNode{


    private int cornerResId;
    private int cornerStrResId;

    public DeviceMoreOptionCornerNode(int optionType, int cornerResId, int cornerStrResId) {
        super(optionType);
        this.cornerResId = cornerResId;
        this.cornerStrResId = cornerStrResId;
    }

    public int getCornerResId() {
        return cornerResId;
    }

    public void setCornerResId(int cornerResId) {
        this.cornerResId = cornerResId;
    }

    public int getCornerStrResId() {
        return cornerStrResId;
    }

    public void setCornerStrResId(int cornerStrResId) {
        this.cornerStrResId = cornerStrResId;
    }
}
