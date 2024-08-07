package com.jovision.netkit.mvp.data.bean;

/**
 * Created by deli on 52020--12-01.
 */

public class AlarmSoundVolumeBean{


    /**
     * bEnable : false
     * sampleRate : 8000
     * bitWidth : 16
     * cntChannel : 1
     * encType : g711a
     * bitRate : 64
     */

    private boolean bEnable;
    private int sampleRate;
    private int bitWidth;
    private int cntChannel;
    private String encType;
    private int bitRate;
    private int aoGain;



    public int getAoGain() {
        return aoGain;
    }

    public void setAoGain(int aoGain) {
        this.aoGain = aoGain;
    }

    public boolean isBEnable() {
        return bEnable;
    }

    public void setBEnable(boolean bEnable) {
        this.bEnable = bEnable;
    }

    public int getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
    }

    public int getBitWidth() {
        return bitWidth;
    }

    public void setBitWidth(int bitWidth) {
        this.bitWidth = bitWidth;
    }

    public int getCntChannel() {
        return cntChannel;
    }

    public void setCntChannel(int cntChannel) {
        this.cntChannel = cntChannel;
    }

    public String getEncType() {
        return encType;
    }

    public void setEncType(String encType) {
        this.encType = encType;
    }

    public int getBitRate() {
        return bitRate;
    }

    public void setBitRate(int bitRate) {
        this.bitRate = bitRate;
    }
}
