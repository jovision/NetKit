package com.jovision.netkit.mvp.data.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by zhp on 2020/11/25
 */
public class MessageAlarmListBean extends BaseEntity implements Serializable {

    public static final String CLOUD_STORAGE_TAG = "CLOUD_STORAGE";
    public static final String LOCAL_TAG = "LOCAL";

    /**
     * dayCount : {"2020-12-25":23}
     * items : [{"alarmCategory":2,"alarmTime":"2020-12-25 18:02:04","alarmType":201,"alarmUuid":"12421SSB6N87_0_motion_detection_20201225180202_9","channelId":0,"deviceName":"勿连N87测试111","deviceSn":"12421SSB6N87","id":118442,"isCheck":false,"readStatus":1},{"alarmCategory":2,"alarmTime":"2020-12-25 17:59:29","alarmType":201,"alarmUuid":"12421SSB6N87_0_motion_detection_20201225175928_8","channelId":0,"deviceName":"勿连N87测试111","deviceSn":"12421SSB6N87","id":118434,"isCheck":false,"readStatus":1},{"alarmCategory":2,"alarmTime":"2020-12-25 17:59:17","alarmType":201,"alarmUuid":"12421SSB6N87_0_motion_detection_20201225175916_7","channelId":0,"deviceName":"勿连N87测试111","deviceSn":"12421SSB6N87","id":118430,"isCheck":false,"readStatus":1},{"alarmCategory":2,"alarmTime":"2020-12-25 17:59:14","alarmType":201,"alarmUuid":"12421SSB6N87_0_motion_detection_20201225175912_6","channelId":0,"deviceName":"勿连N87测试111","deviceSn":"12421SSB6N87","id":118426,"isCheck":false,"readStatus":1},{"alarmCategory":2,"alarmTime":"2020-12-25 17:59:12","alarmType":201,"alarmUuid":"12421SSB6N87_0_motion_detection_20201225175909_5","channelId":0,"deviceName":"勿连N87测试111","deviceSn":"12421SSB6N87","id":118422,"isCheck":false,"readStatus":1},{"alarmCategory":2,"alarmTime":"2020-12-25 17:57:06","alarmType":201,"alarmUuid":"12421SSB6N87_0_motion_detection_20201225175704_4","channelId":0,"deviceName":"勿连N87测试111","deviceSn":"12421SSB6N87","id":118414,"isCheck":false,"readStatus":1},{"alarmCategory":2,"alarmTime":"2020-12-25 17:55:55","alarmType":201,"alarmUuid":"12421SSB6N87_0_motion_detection_20201225175553_3","channelId":0,"deviceName":"勿连N87测试111","deviceSn":"12421SSB6N87","id":118410,"isCheck":false,"readStatus":0},{"alarmCategory":2,"alarmTime":"2020-12-25 15:26:14","alarmType":201,"alarmUuid":"12421SSB6N87_0_motion_detection_20201225152612_137","channelId":0,"deviceName":"勿连N87测试111","deviceSn":"12421SSB6N87","id":118109,"isCheck":false,"readStatus":0},{"alarmCategory":2,"alarmTime":"2020-12-25 15:26:12","alarmType":201,"alarmUuid":"12421SSB6N87_0_motion_detection_20201225152610_136","channelId":0,"deviceName":"勿连N87测试111","deviceSn":"12421SSB6N87","id":118105,"isCheck":false,"readStatus":0},{"alarmCategory":2,"alarmTime":"2020-12-25 15:16:46","alarmType":201,"alarmUuid":"12421SSB6N87_0_motion_detection_20201225151644_135","channelId":0,"deviceName":"勿连N87测试111","deviceSn":"12421SSB6N87","id":118041,"isCheck":false,"readStatus":1}]
     */
    private List<ItemsBean> items;

    private Map<String,Integer> dayCount;

    public Map<String, Integer> getDayCount() {
        return dayCount;
    }

    public void setDayCount(Map<String, Integer> dayCount) {
        this.dayCount = dayCount;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }



    public static class ItemsBean implements Serializable {

        /**
         * id : 118626
         * alarmUuid : 12421SSB6N87_0_motion_detection_20201228142021_46
         * alarmCategory : 2
         * alarmType : 201
         * deviceSn : 12421SSB6N87
         * channelId : 0
         * deviceName : 勿连N87测试111
         * channelName : 勿连N87测试111
         * alarmTime : 2020-12-28 14:20:23
         * stopTime : null
         * readStatus : 1
         *
         * photoUrl : {"url":"https://dev-obs.obs.cn-north-1.myhuaweicloud.com:443/Alarm/12421SSB6N87_0_motion_detection_20201228142021_46?AWSAccessKeyId=X7VENGFBIHQBTNKK1QAO&Expires=1609210874&Signature=ggGu6B%2B1ppVB1EbPIL7WNGBRJnY%3D","encryptIv":"","workingKey":""}
         */

        private int id;
        private String alarmUuid;
        private String alarmCategory;
        private String alarmType;
        private String deviceSn;
        private int channelId;
        private String deviceName;
        private String channelName;
        private String alarmTime;
        private String  stopTime;
        private String readStatus;// UNREAD：未读,READ：已读
        private PhotoUrlBean photoUrl;
        private String accessProtocol;//PUBLICCLOUD：公有云设备,CLOUDSEE1：云视通1.0设备,CLOUDSEE2：云视通2.0设备,
        private String deviceType;
        private String alarmPicPath;//普通报警图片地址（枪机）
        private String videoPath;
        private String cloudAlarm;//"cloudAlarm":"CLOUD_STORAGE", "LOCAL"
        private boolean isCheck;
        private boolean isCurrent;
        private boolean isDownloaded;
        private String localUrl;//云存url缓存在本地的url
        private String sdImageData;//base64字符串
        private String activeCallStatus;//呼叫状态
        private int bulletDemoAlarm;//0:不是枪球   1:是枪球
        private String linkedAlarmPicPath;//联动报警图片地址（球机）

        public String getAccessProtocol() {
            return accessProtocol;
        }

        public void setAccessProtocol(String accessProtocol) {
            this.accessProtocol = accessProtocol;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public String getAlarmPicPath() {
            return alarmPicPath;
        }

        public void setAlarmPicPath(String alarmPicPath) {
            this.alarmPicPath = alarmPicPath;
        }

        public String getVideoPath() {
            return videoPath;
        }

        public void setVideoPath(String videoPath) {
            this.videoPath = videoPath;
        }

        public String getCloudAlarm() {
            return cloudAlarm;
        }

        public void setCloudAlarm(String cloudAlarm) {
            this.cloudAlarm = cloudAlarm;
        }

        public String getSdImageData() {
            return sdImageData;
        }

        public void setSdImageData(String sdImageData) {
            this.sdImageData = sdImageData;
        }

        public String getLocalUrl() {
            return localUrl;
        }

        public void setLocalUrl(String localUrl) {
            this.localUrl = localUrl;
        }

        public boolean isDownloaded() {
            return isDownloaded;
        }

        public void setDownloaded(boolean downloaded) {
            isDownloaded = downloaded;
        }

        public boolean isCurrent() {
            return isCurrent;
        }

        public void setCurrent(boolean current) {
            isCurrent = current;
        }

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }

        // 返回  时：分：秒格式
        public String getFormatTime() {
            String formatTime = "";
            try {
                if (alarmTime.length() > 0) {
                    formatTime = alarmTime.substring(11, alarmTime.length()).replace("-", "/");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return formatTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAlarmUuid() {
            return alarmUuid;
        }

        public void setAlarmUuid(String alarmUuid) {
            this.alarmUuid = alarmUuid;
        }

        public String getAlarmCategory() {
            return alarmCategory;
        }

        public void setAlarmCategory(String alarmCategory) {
            this.alarmCategory = alarmCategory;
        }

        public String getAlarmType() {
            return alarmType;
        }

        public void setAlarmType(String alarmType) {
            this.alarmType = alarmType;
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

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public String getAlarmTime() {
            return alarmTime;
        }

        public void setAlarmTime(String alarmTime) {
            this.alarmTime = alarmTime;
        }

        public String getStopTime() {
            return stopTime;
        }

        public void setStopTime(String stopTime) {
            this.stopTime = stopTime;
        }

        public String getReadStatus() {
            return readStatus;
        }

        public void setReadStatus(String readStatus) {
            this.readStatus = readStatus;
        }

        public PhotoUrlBean getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(PhotoUrlBean photoUrl) {
            this.photoUrl = photoUrl;
        }

        public String getActiveCallStatus() {
            return activeCallStatus;
        }

        public void setActiveCallStatus(String activeCallStatus) {
            this.activeCallStatus = activeCallStatus;
        }

        public int getBulletDemoAlarm() {
            return bulletDemoAlarm;
        }

        public void setBulletDemoAlarm(int bulletDemoAlarm) {
            this.bulletDemoAlarm = bulletDemoAlarm;
        }

        public String getLinkedAlarmPicPath() {
            return linkedAlarmPicPath;
        }

        public void setLinkedAlarmPicPath(String linkedAlarmPicPath) {
            this.linkedAlarmPicPath = linkedAlarmPicPath;
        }

        public static class PhotoUrlBean implements Serializable {
            /**
             * url : https://dev-obs.obs.cn-north-1.myhuaweicloud.com:443/Alarm/12421SSB6N87_0_motion_detection_20201228142021_46?AWSAccessKeyId=X7VENGFBIHQBTNKK1QAO&Expires=1609210874&Signature=ggGu6B%2B1ppVB1EbPIL7WNGBRJnY%3D
             * encryptIv :
             * workingKey :
             */

            private String url;
            private String encryptIv;
            private String workingKey;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getEncryptIv() {
                return encryptIv;
            }

            public void setEncryptIv(String encryptIv) {
                this.encryptIv = encryptIv;
            }

            public String getWorkingKey() {
                return workingKey;
            }

            public void setWorkingKey(String workingKey) {
                this.workingKey = workingKey;
            }
        }
    }


  /*  private List<ItemsBean> items;
    private Map<String,Integer> dayCount;

    public Map<String, Integer> getDayCount() {
        return dayCount;
    }

    public void setDayCount(Map<String, Integer> dayCount) {
        this.dayCount = dayCount;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean extends BaseEntity implements Serializable {
        *//**
         * id : 3931
         * alarmUuid : 12421SS8KBQU_0_motion_detection_20201125180457_63
         * alarmCategory : 2
         * alarmType : 201
         * deviceSn : 12421SS8KBQU
         * channelId : 0
         * deviceName : 你大爷大爷
         * filePath : null
         * alarmTime : 2020-11-25 18:04:59
         * readStatus : 0
         *//*

        private int id;
        private String alarmUuid;
        private int alarmCategory;
        private int alarmType;
        private String deviceSn;
        private int channelId;
        private String deviceName;
        private String filePath;
        private String alarmTime;
        private int readStatus;
        private boolean isCheck;

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

        public String getAlarmUuid() {
            return alarmUuid;
        }

        public void setAlarmUuid(String alarmUuid) {
            this.alarmUuid = alarmUuid;
        }

        public int getAlarmCategory() {
            return alarmCategory;
        }

        public void setAlarmCategory(int alarmCategory) {
            this.alarmCategory = alarmCategory;
        }

        public int getAlarmType() {
            return alarmType;
        }

        public void setAlarmType(int alarmType) {
            this.alarmType = alarmType;
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

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getAlarmTime() {
            return alarmTime;
        }

        // 返回  时：分：秒格式
        public String getFormatTime() {
            String formatTime = "";
            try {
                if (alarmTime.length() > 0) {
                    formatTime = alarmTime.substring(11, alarmTime.length()).replace("-", "/");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return formatTime;
        }



        public void setAlarmTime(String alarmTime) {
            this.alarmTime = alarmTime;
        }

        public int getReadStatus() {
            return readStatus;
        }

        public void setReadStatus(int readStatus) {
            this.readStatus = readStatus;
        }
    }*/





}
