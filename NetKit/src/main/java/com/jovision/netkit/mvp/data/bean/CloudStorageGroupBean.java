package com.jovision.netkit.mvp.data.bean;

import java.util.List;

public class CloudStorageGroupBean {

    private List<CloudStorageTypeBean> storageTypes;//云存储类型

    public List<CloudStorageTypeBean> getStorageTypes() {
        return storageTypes;
    }

    public void setStorageTypes(List<CloudStorageTypeBean> storageTypes) {
        this.storageTypes = storageTypes;
    }
}
