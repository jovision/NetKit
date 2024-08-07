package com.jovision.netkit.mvp.data.bean;

/**
 * Created by zhp on 2020/11/13
 */
public class PlayPowerBean {

    public static final int PLAY_POWER_TYPE_4G = 0;
    public static final int PLAY_POWER_TYPE_SIM_CARD = 10;
    public static final int PLAY_POWER_TYPE_CRY = 1;
    public static final int PLAY_POWER_TYPE_PET = 2;
    public static final int PLAY_POWER_TYPE_CLOUD_STORAGE = 3;
    public static final int PLAY_POWER_TYPE_WAVE_HAND_CALL = 4;
    public static final int PLAY_POWER_TYPE_SHARE = 5;
    public static final int PLAY_POWER_TYPE_VEHICLE = 6;//车牌

    private int powerType;
    private int powerImg;
    private String powerName;
    private String powerTip;
    private String cornerMarkState;

    public int getPowerType() {
        return powerType;
    }

    public void setPowerType(int powerType) {
        this.powerType = powerType;
    }

    public int getPowerImg() {
        return powerImg;
    }

    public void setPowerImg(int powerImg) {
        this.powerImg = powerImg;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getPowerTip() {
        return powerTip;
    }

    public void setPowerTip(String powerTip) {
        this.powerTip = powerTip;
    }

    public PlayPowerBean(int powerType, int powerImg, String powerName, String powerTip) {
        this.powerType = powerType;
        this.powerImg = powerImg;
        this.powerName = powerName;
        this.powerTip = powerTip;
    }

    public String getCornerMarkState() {
        return cornerMarkState;
    }

    public void setCornerMarkState(String cornerMarkState) {
        this.cornerMarkState = cornerMarkState;
    }
}
