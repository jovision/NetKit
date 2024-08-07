package com.jovision.netkit.mvp.data.bean.response;

public class UpgradeProgressBean {
    private int progress;//升级进度（0~100）
    private int status;//升级状态（0-升级未完成；1：升级完成）
    private int fileType;//正在升级的模块
    private String fileProcess;//模块进度

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public String getFileProcess() {
        return fileProcess;
    }

    public void setFileProcess(String fileProcess) {
        this.fileProcess = fileProcess;
    }
}
