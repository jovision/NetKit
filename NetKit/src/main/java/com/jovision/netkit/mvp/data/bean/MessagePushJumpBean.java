package com.jovision.netkit.mvp.data.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhp on 2020/12/2
 */
public class MessagePushJumpBean extends BaseEntity implements Serializable {


    /**
     * alarmTime : 2020-12-02 00:00:00
     * messageData : {"channelId":"01","content":"您共享的设备 - 12421SSKDT55，12312312312 - 135****7341 并未接收","deviceSn":"001","msgId":"0000001","targetUserIds":["1","2","3"]}
     * messageType : device_share_message
     */

    private String alarmTime;
    private MessageDataBean messageData;
    private String alarmUuid;
    private String messageType;

    public String getAlarmUuid() {
        return alarmUuid;
    }

    public void setAlarmUuid(String alarmUuid) {
        this.alarmUuid = alarmUuid;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime;
    }

    public MessageDataBean getMessageData() {
        return messageData;
    }

    public void setMessageData(MessageDataBean messageData) {
        this.messageData = messageData;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public static class MessageDataBean extends BaseEntity implements Serializable {
        /*  device_exception	    1	设备异常报警
            motion_detection	    2	移动侦测报警
            pd_alarm	            3	人形检测报警
            region_invasion_alarm	4	周界入侵报警
            video_occlusion	        5	镜头遮挡报警
        */
        /**
         * 设备告警
         * alarmStatus : start
         * alarmType : motion_detection
         * alarmTypeValue : 2
         * channelId : 0
         * deviceName : 测试设备
         * deviceSn : 12421SS8NR3F
         * filePath : /sd1
         */

        /**
         * 设备离线
         * alarmType : device_exception
         * alarmTypeValue : 1
         * deviceName : 测试设备
         * deviceSn : 12421SS8NR3F
         */

        /**
         * 设备分享
         * channelId : 01
         * content : 您共享的设备 - 12421SSKDT55，12312312312 - 135****7341 并未接收
         * deviceSn : 001
         * msgId : 0000001
         * msgType:1
         * targetUserIds : ["1","2","3"]
         */
        //公有云消息字段
        private String alarmCategory;
        private String alarmStatus;
        private int alarmTypeValue;
        private String deviceName;
        private String filePath;
        private int msgType;
        private String channelName;
        private String shareDetail;
        private int isBulletDemoDevice;//1:是枪球设备，0:不是枪球设备

        //公共字段
        private String alarmType;
        private int channelId;
        private String deviceSn;

        //云视通消息字段
        private String alarmVideoPath;
        private String deviceType;
        private String alarmStoreType;
        private String alarmMsgType;
        private String ystVersion;
        private String alarmMessage;
        private String alarmPicPath;

        public String getAlarmVideoPath() {
            return alarmVideoPath;
        }

        public void setAlarmVideoPath(String alarmVideoPath) {
            this.alarmVideoPath = alarmVideoPath;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public String getAlarmStoreType() {
            return alarmStoreType;
        }

        public void setAlarmStoreType(String alarmStoreType) {
            this.alarmStoreType = alarmStoreType;
        }

        public String getAlarmCategory() {
            return alarmCategory;
        }

        public void setAlarmCategory(String alarmCategory) {
            this.alarmCategory = alarmCategory;
        }

        public String getAlarmMsgType() {
            return alarmMsgType;
        }

        public void setAlarmMsgType(String alarmMsgType) {
            this.alarmMsgType = alarmMsgType;
        }

        public String getYstVersion() {
            return ystVersion;
        }

        public void setYstVersion(String ystVersion) {
            this.ystVersion = ystVersion;
        }

        public String getAlarmMessage() {
            return alarmMessage;
        }

        public void setAlarmMessage(String alarmMessage) {
            this.alarmMessage = alarmMessage;
        }

        public String getAlarmPicPath() {
            return alarmPicPath;
        }

        public void setAlarmPicPath(String alarmPicPath) {
            this.alarmPicPath = alarmPicPath;
        }

        public String getShareDetail() {
            return shareDetail;
        }

        public void setShareDetail(String shareDetail) {
            this.shareDetail = shareDetail;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public int getMsgType() {
            return msgType;
        }

        public void setMsgType(int msgType) {
            this.msgType = msgType;
        }

        public String getAlarmStatus() {
            return alarmStatus;
        }

        public void setAlarmStatus(String alarmStatus) {
            this.alarmStatus = alarmStatus;
        }

        public String getAlarmType() {
            return alarmType;
        }

        public void setAlarmType(String alarmType) {
            this.alarmType = alarmType;
        }

        public int getAlarmTypeValue() {
            return alarmTypeValue;
        }

        public void setAlarmTypeValue(int alarmTypeValue) {
            this.alarmTypeValue = alarmTypeValue;
        }

        public int getChannelId() {
            return channelId;
        }

        public void setChannelId(int channelId) {
            this.channelId = channelId;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }

        public String getDeviceSn() {
            return deviceSn;
        }

        public void setDeviceSn(String deviceSn) {
            this.deviceSn = deviceSn;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        private String content;
        private String msgId;
        private List<String> targetUserIds;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getMsgId() {
            return msgId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }

        public List<String> getTargetUserIds() {
            return targetUserIds;
        }

        public void setTargetUserIds(List<String> targetUserIds) {
            this.targetUserIds = targetUserIds;
        }

        public int getIsBulletDemoDevice() {
            return isBulletDemoDevice;
        }

        public void setIsBulletDemoDevice(int isBulletDemoDevice) {
            this.isBulletDemoDevice = isBulletDemoDevice;
        }
    }

    @Override
    public String toString() {
        return "MessagePushJumpBean{" +
                "alarmTime='" + alarmTime + '\'' +
                ", messageData=" + messageData +
                ", alarmUuid='" + alarmUuid + '\'' +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
