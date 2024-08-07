package com.jovision.netkit.mvp.data.bean.response;

public class FeedBackUploadBean {
    private String fileName;//	文件名称
    private String url;//文件上传地址，上传url有效期10分钟

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
