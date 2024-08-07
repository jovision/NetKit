package com.jovision.netkit.mvp.data.bean;

public class AdInfoBean {
    private boolean umengAdSwitch;
    private boolean xiaomiAdSwitch;
    private boolean oppoAdSwitch;
    private boolean huaweiAdSwitch;
    private boolean splashAdSwitch;
    private boolean bannerAdSwitch;
    private ScreenAdBean screenOnAd;
    private BottomBannerAdBean bottomBannerAd;

    public boolean isUmengAdSwitch() {
        return umengAdSwitch;
    }

    public void setUmengAdSwitch(boolean umengAdSwitch) {
        this.umengAdSwitch = umengAdSwitch;
    }

    public boolean isXiaomiAdSwitch() {
        return xiaomiAdSwitch;
    }

    public void setXiaomiAdSwitch(boolean xiaomiAdSwitch) {
        this.xiaomiAdSwitch = xiaomiAdSwitch;
    }

    public boolean isOppoAdSwitch() {
        return oppoAdSwitch;
    }

    public void setOppoAdSwitch(boolean oppoAdSwitch) {
        this.oppoAdSwitch = oppoAdSwitch;
    }

    public boolean isHuaweiAdSwitch() {
        return huaweiAdSwitch;
    }

    public void setHuaweiAdSwitch(boolean huaweiAdSwitch) {
        this.huaweiAdSwitch = huaweiAdSwitch;
    }

    public boolean isSplashAdSwitch() {
        return splashAdSwitch;
    }

    public void setSplashAdSwitch(boolean splashAdSwitch) {
        this.splashAdSwitch = splashAdSwitch;
    }

    public boolean isBannerAdSwitch() {
        return bannerAdSwitch;
    }

    public void setBannerAdSwitch(boolean bannerAdSwitch) {
        this.bannerAdSwitch = bannerAdSwitch;
    }

    public ScreenAdBean getScreenOnAd() {
        return screenOnAd;
    }

    public void setScreenOnAd(ScreenAdBean screenOnAd) {
        this.screenOnAd = screenOnAd;
    }

    public BottomBannerAdBean getBottomBannerAd() {
        return bottomBannerAd;
    }

    public void setBottomBannerAd(BottomBannerAdBean bottomBannerAd) {
        this.bottomBannerAd = bottomBannerAd;
    }
}
