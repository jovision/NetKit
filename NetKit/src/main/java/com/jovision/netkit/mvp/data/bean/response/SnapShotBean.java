package com.jovision.netkit.mvp.data.bean.response;

public class SnapShotBean {
    private String url;
    private String encryptIv;//加密图片的初始向量
    private String workingKey;//加密图片的工作密钥

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEncryptIv() {
        return encryptIv;
    }

    public void setEncryptIv(String encryptIv) {
        this.encryptIv = encryptIv;
    }

    public String getWorkingKey() {
        return workingKey;
    }

    public void setWorkingKey(String workingKey) {
        this.workingKey = workingKey;
    }
}
