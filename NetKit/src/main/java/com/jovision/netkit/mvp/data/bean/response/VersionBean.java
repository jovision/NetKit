package com.jovision.netkit.mvp.data.bean.response;

public class VersionBean {
    private String latestVersion;
    private String currentVersion;
    private int isNeedUpgrade;//是否需要升级（0：不需要；1：需要）

    public String getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public int getIsNeedUpgrade() {
        return isNeedUpgrade;
    }

    public void setIsNeedUpgrade(int isNeedUpgrade) {
        this.isNeedUpgrade = isNeedUpgrade;
    }
}
