package com.jovision.netkit.mvp.data.bean;

import java.util.List;

public class CloudStorageTypeBean {

    private int storageDays;//云存储套餐时长
    private String storageTypesName;//云存储套餐类型名称
    private List<CloudStorageBean> cloudStorageList;//普通云存储套餐列表
    private List<CloudStorageBean> signCloudStorageList;//自动续费云存储套餐列表

    public int getStorageDays() {
        return storageDays;
    }

    public void setStorageDays(int storageDays) {
        this.storageDays = storageDays;
    }

    public String getStorageTypesName() {
        return storageTypesName;
    }

    public void setStorageTypesName(String storageTypesName) {
        this.storageTypesName = storageTypesName;
    }

    public List<CloudStorageBean> getCloudStorageList() {
        return cloudStorageList;
    }

    public void setCloudStorageList(List<CloudStorageBean> cloudStorageList) {
        this.cloudStorageList = cloudStorageList;
    }

    public List<CloudStorageBean> getSignCloudStorageList() {
        return signCloudStorageList;
    }

    public void setSignCloudStorageList(List<CloudStorageBean> signCloudStorageList) {
        this.signCloudStorageList = signCloudStorageList;
    }

}
