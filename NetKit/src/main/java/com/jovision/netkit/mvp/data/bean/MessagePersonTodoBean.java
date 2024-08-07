package com.jovision.netkit.mvp.data.bean;

import java.util.List;

/**
 * Created by zhp on 2020/11/25
 */
public class MessagePersonTodoBean extends BaseEntity{


    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean extends BaseEntity{
        /**
         * content : ivs_211052 - 185****4234，向您发起设备 - 12421SS8KBQU的共享
         * createTime : 2020-12-02 11:44:19
         */

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
    }
}
