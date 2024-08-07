package com.jovision.netkit.mvp.data.bean.response;

/**
 * @ProjectName: SAAS
 * @Package: com.jovision.saas.data.bean.response
 * @ClassName: SmartAppBean
 * @Description: java类作用描述
 * @CreateDate: 2024/3/20 14:36
 * @Version: 1.0
 */
public class SmartAppBean {
    //算法标识
    private String algorithmSign;
    //算法名称
    private String algorithmName;
    //平台应用id
    private int appId;
    //平台应用名称
    private String appName;
    //平台应用图片下载地址
    private String appVersion;
    private String imgAbsUrl;
    //平台应用下载地址
    private String appAbsUrl;

    private String appDesc;
//    0-正常智能算法 1-免费智能算法
    private int freeFlag;
    private SmartAppStatus.SmartAppStatusBean appStatus;

    public String getAlgorithmSign() {
        return algorithmSign;
    }

    public void setAlgorithmSign(String algorithmSign) {
        this.algorithmSign = algorithmSign;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getImgAbsUrl() {
        return imgAbsUrl;
    }

    public void setImgAbsUrl(String imgAbsUrl) {
        this.imgAbsUrl = imgAbsUrl;
    }

    public String getAppAbsUrl() {
        return appAbsUrl;
    }

    public void setAppAbsUrl(String appAbsUrl) {
        this.appAbsUrl = appAbsUrl;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }

    public int getFreeFlag() {
        return freeFlag;
    }

    public void setFreeFlag(int freeFlag) {
        this.freeFlag = freeFlag;
    }

    public SmartAppStatus.SmartAppStatusBean getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(SmartAppStatus.SmartAppStatusBean appStatus) {
        this.appStatus = appStatus;
    }
}
