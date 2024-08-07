package com.jovision.netkit.mvp.data.bean;


import java.io.Serializable;
import java.util.List;

/**
 * Copyright@中维世纪
 *
 * @authore 彭强-24007
 * @time 2024-03-15 16:57
 * @description 系统消息列表
 */
public class MessageSystemBean extends BaseEntity implements Serializable {


    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean extends BaseEntity implements Serializable {

        public final static int TYPE_401 = 401;
        public final static int TYPE_402 = 402;
        public final static int TYPE_404 = 404;
        public final static int TYPE_405 = 405;
        public final static int TYPE_407 = 407;
        public final static int TYPE_403 = 403;
        public final static int TYPE_406 = 406;
        public final static int TYPE_408 = 408;
        public final static int TYPE_409 = 409;
        private int id;//消息id
        private String msgId;//意见反馈ID
        private String msgIcon;//消息图标地址
        private String msgTitle;//消息标题
        private String msgContent;//消息内容
        private String msgType;//消息类型 401-云存储服务开通到期 402-云存储服务到期提醒 403-宠物检测开通提醒 404- 宠物检测服务到期提醒 405-意见反馈回复
        private int msgCategory;//系统消息分类  4-系统消息
        private String readStatus;//读取状态	UNREAD:未读，READ:已读
        private String createTime;//发送时间
        private String deviceId;//设备id
        private String iccId;//4G卡号
        private String packageId;//云存储id
        private boolean isCheck;
        private String shareDetail;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMsgId() {
            return msgId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }

        public String getMsgIcon() {
            return msgIcon;
        }

        public void setMsgIcon(String msgIcon) {
            this.msgIcon = msgIcon;
        }

        public String getMsgTitle() {
            return msgTitle;
        }

        public void setMsgTitle(String msgTitle) {
            this.msgTitle = msgTitle;
        }

        public String getMsgContent() {
            return msgContent;
        }

        public void setMsgContent(String msgContent) {
            this.msgContent = msgContent;
        }

        public String getMsgType() {
            return msgType;
        }

        public void setMsgType(String msgType) {
            this.msgType = msgType;
        }

        public int getMsgCategory() {
            return msgCategory;
        }

        public void setMsgCategory(int msgCategory) {
            this.msgCategory = msgCategory;
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

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getIccId() {
            return iccId;
        }

        public void setIccId(String iccId) {
            this.iccId = iccId;
        }

        public String getPackageId() {
            return packageId;
        }

        public void setPackageId(String packageId) {
            this.packageId = packageId;
        }

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }

        public String getShareDetail() {
            return shareDetail;
        }

        public void setShareDetail(String shareDetail) {
            this.shareDetail = shareDetail;
        }

      /*  @Override
        public int getItemType() {
            return Integer.parseInt(msgType);
        }*/
    }
}
