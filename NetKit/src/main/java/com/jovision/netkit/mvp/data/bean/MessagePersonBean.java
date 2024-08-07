package com.jovision.netkit.mvp.data.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhp on 2020/11/25
 * 设备分享里面的个人消息和远程运维里面的个人消息共用
 */
public class MessagePersonBean extends BaseEntity implements Serializable {


    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean extends BaseEntity implements Serializable {
        /**
         * id : 125
         * msgContent : ivs_176240 - 187****4650，取消了对您共享12421SSB6N87设备
         * readStatus : 0
         * createTime : 2020-12-02 15:02:04
         */

        private int id;
        private String msgContent;
        private int msgCategory;//3:转移，转移的消息不可以点击
        private String readStatus;
        private String createTime;
        private boolean isCheck;
        private String shareDetail;

        public String getShareDetail() {
            return shareDetail;
        }

        public void setShareDetail(String shareDetail) {
            this.shareDetail = shareDetail;
        }

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMsgContent() {
            return msgContent;
        }

        public void setMsgContent(String msgContent) {
            this.msgContent = msgContent;
        }

        public String getReadStatus() {
            return readStatus;
        }

        public void setReadStatus(String readStatus) {
            this.readStatus = readStatus;
        }

        public String getCreateTime() {
            return createTime;
        }

        // 返回  月/日 时：分：秒格式
        public String getFormatTime() {
            String formatTime = "";
            try {
                if (createTime.length() > 0) {
                    formatTime = createTime.substring(5, createTime.length()).replace("-", "/");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return formatTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getMsgCategory() {
            return msgCategory;
        }

        public void setMsgCategory(int msgCategory) {
            this.msgCategory = msgCategory;
        }
    }
}
