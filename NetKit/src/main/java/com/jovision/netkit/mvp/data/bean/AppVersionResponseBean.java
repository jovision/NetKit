package com.jovision.netkit.mvp.data.bean;

/**
 * App最新版本:返回值
 *
 * @author juyang
 * @date 2020/12/10
 */
public class AppVersionResponseBean {

    private String upgradeLog;
    private String versionName;
    private String fileSize;
    private String downloadUrl = "";
    private String versionCode;
    private String isForcedUpdate;

    public String getUpgradeLog() {
        return upgradeLog;
    }

    public void setUpgradeLog(String upgradeLog) {
        this.upgradeLog = upgradeLog;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getIsForcedUpdate() {
        return isForcedUpdate;
    }

    public void setIsForcedUpdate(String isForcedUpdate) {
        this.isForcedUpdate = isForcedUpdate;
    }
}
