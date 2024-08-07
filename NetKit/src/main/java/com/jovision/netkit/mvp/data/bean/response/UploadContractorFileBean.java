package com.jovision.netkit.mvp.data.bean.response;

public class UploadContractorFileBean {
    private String fileName;
    private String url;

    @Override
    public String toString() {
        return "UploadContractorFileBean{" +
                "fileName='" + fileName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

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
