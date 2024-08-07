package com.jovision.netkit.mvp.data.bean;

import android.text.TextUtils;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

/**
 * Created by zhp on 2020/12/7
 */
public class DeviceCloudBean extends BaseEntity {

    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean implements MultiItemEntity {


        public static final int USE = 1;
        public static final int UNUSE = 0;

        @Override
        public int getItemType() {
            if (!TextUtils.isEmpty(status) && TextUtils.equals(status, "USING")) {
                return USE;
            }
            return UNUSE;
        }

        /**
         * id : 29
         * orderNumber : 124159932764262400
         * tenantId : beaa669b
         * deviceSn : 12421SSB577V
         * channelId : 0
         * storageId : 8dc51c0a9c9440219dbcebc5576e3a50
         * storageType : 1
         * storageName : 7天包月动检云存储
         * storageDays : 7
         * expireDays : 30
         * status : 1
         * planEnableTime : 2020-12-08 14:47:47
         * enableTime : 2020-12-08 14:47:47
         * createTime : 2020-12-08 14:47:46
         * updateTime : 2020-12-08 14:47:46
         */

        private int id;
        private long orderNumber;
        private String tenantId;
        private String deviceSn;
        private int channelId;
        private String storageId;
        private String storageType;//套餐类型 DYNAMIC：动检 FULL：全量
        private String storageName;
        private int storageDays;
        private int expireDays;
        private int validDays;
        private String status;//套餐状态,STANDBY-待使用 USING-使用中 SUSPEND已停用 EXPIRED已过期
        private String planEnableTime;
        private String enableTime;
        private String createTime;
        private String updateTime;
        private String freeFlag;//免费标记：NO_FREE-购买 FREE-免费

        public String getFreeFlag() {
            return freeFlag;
        }

        public void setFreeFlag(String freeFlag) {
            this.freeFlag = freeFlag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(long orderNumber) {
            this.orderNumber = orderNumber;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getDeviceSn() {
            return deviceSn;
        }

        public void setDeviceSn(String deviceSn) {
            this.deviceSn = deviceSn;
        }

        public int getChannelId() {
            return channelId;
        }

        public void setChannelId(int channelId) {
            this.channelId = channelId;
        }

        public String getStorageId() {
            return storageId;
        }

        public void setStorageId(String storageId) {
            this.storageId = storageId;
        }

        public String getStorageType() {
            return storageType;
        }

        public void setStorageType(String storageType) {
            this.storageType = storageType;
        }

        public String getStorageName() {
            return storageName;
        }

        public void setStorageName(String storageName) {
            this.storageName = storageName;
        }

        public int getStorageDays() {
            return storageDays;
        }

        public void setStorageDays(int storageDays) {
            this.storageDays = storageDays;
        }

        public int getExpireDays() {
            return expireDays;
        }

        public void setExpireDays(int expireDays) {
            this.expireDays = expireDays;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPlanEnableTime() {
            return planEnableTime;
        }

        public void setPlanEnableTime(String planEnableTime) {
            this.planEnableTime = planEnableTime;
        }

        public String getEnableTime() {
            return enableTime;
        }

        public void setEnableTime(String enableTime) {
            this.enableTime = enableTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getStatusStr() {
            return status;
        }

        public int getValidDays() {
            return validDays;
        }

        public void setValidDays(int validDays) {
            this.validDays = validDays;
        }
    }
}
