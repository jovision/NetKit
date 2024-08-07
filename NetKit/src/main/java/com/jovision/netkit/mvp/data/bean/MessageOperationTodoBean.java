package com.jovision.netkit.mvp.data.bean;

import java.util.List;

//【工程商服务】查看远程运维待办事项
public class MessageOperationTodoBean {


    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean extends BaseEntity {
        /**
         * content : ivs_211052 - 185****4234，向您发起设备 - 12421SS8KBQU的共享
         * createTime : 2020-12-02 11:44:19
         */

        private String deviceID;
        private String content;
        private String createTime;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDeviceID() {
            return deviceID;
        }

        public void setDeviceID(String deviceID) {
            this.deviceID = deviceID;
        }
    }
}
