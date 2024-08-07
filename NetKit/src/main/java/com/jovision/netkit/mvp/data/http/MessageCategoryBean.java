package com.jovision.netkit.mvp.data.http;

import com.jovision.netkit.mvp.data.bean.BaseEntity;

import java.util.List;

/**
 * Created by zhp on 2020/11/25
 */
public class MessageCategoryBean extends BaseEntity {


    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean extends BaseEntity {
        /**
         * id : 2861
         * alarmUuid : 12421SS8KBQU_0_motion_detection_20201125112820_42
         * alarmCategory : 2
         * alarmType : 201
         * deviceSn : 12421SS8KBQU
         * channelId : 0
         * deviceName : 你大爷大爷
         * alarmTime : 2020-11-25 11:28:22
         * readStatus : 0
         */
        public static final String CATEGORY_DEVICE_ALARM_ALL = "ALL";
        public static final String CATEGORY_DEVICE_ALARM = "DEVICE_ALARM";
        public static final String CATEGORY_MOTION_DETECTION = "MOTION_DETECTION";
        public static final String CATEGORY_PD_ALARM = "PD_ALARM";
        public static final String CATEGORY_REGION_INVASION_ALARM = "REGION_INVASION_ALARM";
        public static final String CATEGORY_COVER_ALARM = "COVER_ALARM";
        public static final String CATEGORY_INTELLIGENCE = "INTELLIGENCE";
        public static final String CATEGORY_UNKNOWN_ALARM = "UNKNOWN_ALARM";
        public static final String CATEGORY_ACTIVE_CALL = "ACTIVE_CALL";
        public static final String CATEGORY_ROAD_OCCUPIED_DETECT = "ROAD_OCCUPIED_DETECT";//占道检测
        public static final String CATEGORY_PEOPLE_LEAVING = "PEOPLE_LEAVING";//人员离岗
        public static final String CATEGORY_VIRTUAL_FOCUS_DETECTION = "VIRTUAL_FOCUS_DETECTION";//虚焦检测报警


        public static final String CATEGORY_PET_DETECTION = "PET_DETECTION";//宠物检测
        public static final String CATEGORY_BABY_CRY_DETECTION = "BABY_CRY_DETECTION";//婴儿啼哭检测


        public static final String CATEGORY_FIRESMOKE_ALARM = "FIRESMOKE_ALARM";//烟火检测
        public static final String CATEGORY_EBIKE_DET = "EBIKE_DET";//电动车检测

        public static final String CATEGORY_DISK_FAILURE = "DISK_FAILURE";//存储卡异常报警
        public static final String CATEGORY_LICENSE_PLATE_ALARM = "LICENSE_PLATE_ALARM";//车牌识别
        //车牌小类
        public static final String CATEGORY_LITTLE_WHITE_LIST = "white_list_alarm";//白名单报警

        public static final String CATEGORY_LITTLE_NEW_ENERGY_ALARM = "new_energy_alarm";//新能源报警

        public static final String CATEGORY_LITTLE_PLATE_RECOGNITION = "plate_recognition";//识别车牌

        public static final String CATEGORY_LITTLE_PLATE_OTHER_ALARM = "plate_other_alarm";//其他报警

        //设备报警
        public static final String ALARM_TYPE_DEVICE_OFFLINE = "DEVICE_OFFLINE";
        public static final String ALARM_TYPE_DEVICE_STORAGE_EXCEPTION = "DEVICE_STORAGE_EXCEPTION";
        public static final String ALARM_TYPE_DEVICE_ONLINE = "DEVICE_ONLINE";
        public static final String ALARM_TYPE_POWER_OFF = "POWER_OFF";
        public static final String ALARM_TYPE_DISCONNECT = "DISCONNECT";
        public static final String ALARM_TYPE_DISK_ERROR = "DISK_ERROR";
        public static final String ALARM_TYPE_DISK_FULL = "DISK_FULL";
        public static final String ALARM_TYPE_DISK_MISS = "DISK_MISS";
        public static final String ALARM_TYPE_VIDEO_MISS = "VIDEO_MISS";
        public static final String ALARM_TYPE_EXTERNAL_ALARM = "EXTERNAL_ALARM";
        public static final String ALARM_TYPE_ALARM_INPUT = "ALARM_INPUT";
        public static final String ALARM_TYPE_MODBUS_ALARM = "MODBUS_ALARM";
        public static final String ALARM_TYPE_SECURITY_ALARM = "SECURITY_ALARM";
        public static final String ALARM_TYPE_ALARM_INPUT_BOX = "ALARM_INPUT_BOX";
        public static final String ALARM_TYPE_INTERNAL_ALARM = "INTERNAL_ALARM";
        public static final String ALARM_TYPE_MANUAL_ALARM = "MANUAL_ALARM";
        public static final String ALARM_TYPE_IPC_SWITCH_ALARM = "IPC_SWITCH_ALARM";

        //呼叫类型  start：设备发起呼叫 ；cancel：设备取消呼叫 ；timeout:超时未接听；refuse：拒接
        public static final String ALARM_TYPE_IPC_ACTIVE_CALL_START = "start";
        public static final String ALARM_TYPE_IPC_ACTIVE_CALL_CANCEL = "cancel";
        public static final String ALARM_TYPE_IPC_ACTIVE_CALL_TIMEOUT = "timeout";
        public static final String ALARM_TYPE_IPC_ACTIVE_CALL_REFUSE = "refuse";


//        //小类，类型用小写
//        public static final String CATEGORY_PET_DETECTION = "pet_detection";//宠物检测
//        public static final String CATEGORY_BABY_CRY_DETECTION = "baby_cry_detection";//婴儿啼哭检测




        //移动侦测
        public static final String ALARM_TYPE_MOTION_DETECTION = "MOTION_DETECTION";
        //人形检测报警
        public static final String ALARM_TYPE_PEOPLE_DETECTION = "PEOPLE_DETECTION";
        //周界入侵报警
        public static final String ALARM_TYPE_REGION_INVASION_ALARM = "REGION_INVASION_ALARM";
        public static final String ALARM_TYPE_TRIPWIRE_DETECTION= "TRIPWIRE_DETECTION";
        public static final String ALARM_TYPE_TRIPWIRE_AND_INVASION_ALARM = "TRIPWIRE_AND_INVASION_ALARM";
        //视频遮挡报警
        public static final String ALARM_TYPE_COVER_ALARM = "COVER_ALARM";
        //智能分析
        public static final String ALARM_TYPE_HIGH_ALTITUDE_PARABOLIC = "HIGH_ALTITUDE_PARABOLIC";
        public static final String ALARM_TYPE_TEMPERATURE_DETECTION = "TEMPERATURE_DETECTION";
        public static final String ALARM_TYPE_MATERIAL_TEMPERATURE_DETECTION = "MATERIAL_TEMPERATURE_DETECTION";
        public static final String ALARM_TYPE_PEOPLE_GATHERING = "PEOPLE_GATHERING";
        public static final String ALARM_TYPE_OVERCROWDING_DETECTION = "OVERCROWDING_DETECTION";
        public static final String ALARM_TYPE_WANDERING_DETECTION = "WANDERING_DETECTION";
        public static final String ALARM_TYPE_MOVE_QUICKLY = "MOVE_QUICKLY";
        public static final String ALARM_TYPE_PEOPLE_LEAVING = "PEOPLE_LEAVING";
        public static final String ALARM_TYPE_CROWD_DENSITY = "CROWD_DENSITY";
        public static final String ALARM_TYPE_PASSENGER_FLOW = "PASSENGER_FLOW";
        public static final String ALARM_TYPE_SCENE_CHANGE = "SCENE_CHANGE";
        public static final String ALARM_TYPE_OBJECT_MOVED = "OBJECT_MOVED";
        public static final String ALARM_TYPE_OBJECT_LEFT = "OBJECT_LEFT";
        public static final String ALARM_TYPE_SPACE_OCCUPANCY_DETECTION = "SPACE_OCCUPANCY_DETECTION";
        public static final String ALARM_TYPE_VIRTUAL_FOCUS = "VIRTUAL_FOCUS";
        public static final String ALARM_TYPE_FIREWORK_DETECTION = "FIREWORK_DETECTION";
        public static final String ALARM_TYPE_VOICE_DETECTION = "VOICE_DETECTION";
        public static final String ALARM_TYPE_VOICE_RISE_DETECTION = "VOICE_RISE_DETECTION";
        public static final String ALARM_TYPE_VOICE_DROP_DETECTION = "VOICE_DROP_DETECTION";
        public static final String ALARM_TYPE_SCREAM_DETECTION = "SCREAM_DETECTION";
        public static final String ALARM_TYPE_FACE_DECTECTION_ALARM = "FACE_DECTECTION_ALARM";
        public static final String ALARM_TYPE_FACE_RECOGNITION_ALARM = "FACE_RECOGNITION_ALARM";
        public static final String ALARM_TYPE_FACE_MASK_ALARM = "FACE_MASK_ALARM";
        public static final String ALARM_TYPE_FACE_NO_MASK_ALARM = "FACE_NO_MASK_ALARM";
        public static final String ALARM_TYPE_EBIKE_DETECTION_ALARM = "EBIKE_DETECTION_ALARM";
        public static final String ALARM_TYPE_TAKE_AND_LEAVE = "TAKE_AND_LEAVE";
        public static final String ALARM_TYPE_INTELLIGENCE = "INTELLIGENCE";
        public static final String ALARM_TYPE_MASK_DETECTION = "MASK_DETECTION";
        public static final String ALARM_TYPE_LEAVING_DETECTION = "LEAVING_DETECTION";
        //未知报警
        public static final String ALARM_TYPE_FACE_RECOGNITION_WHITELIST = "FACE_RECOGNITION_WHITELIST";
        public static final String ALARM_TYPE_FACE_RECOGNITION_BLACKLIST = "FACE_RECOGNITION_BLACKLIST";
        public static final String ALARM_TYPE_FACE_RECOGNITION_STRANGER = "FACE_RECOGNITION_STRANGER";
        public static final String ALARM_TYPE_HARD_DISK_ALARM = "HARD_DISK_ALARM";//硬盘异常
        public static final String ALARM_TYPE_NETWORK_ALARM = "NETWORK_ALARM";//网络异常
        public static final String ALARM_TYPE_HARDWARE_ALARM = "HARDWARE_ALARM";//硬件异常




        private int id;
        private String alarmUuid;
        private String alarmCategory;//DEVICE_ALARM：设备异常报警,MOTION_DETECTION： 移动侦测报警,PD_ALARM：人形检测报警,REGION_INVASION_ALARM：周界入侵报警,COVER_ALARM：视频遮挡报警,INTELLIGENCE：智能分析,UNKNOWN_ALARM：未知报警
        private String alarmType;
        private String deviceSn;
        private int channelId;
        private String deviceName;
        private String alarmTime;
        private String stopTime;
        private String readStatus;
        private String channelName;

        public String getStopTime() {
            return stopTime;
        }

        public void setStopTime(String stopTime) {
            this.stopTime = stopTime;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
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

        public String getAlarmTime() {
            return alarmTime;
        }


        // 返回  月/日 时：分：秒格式
        public String getFormatTime() {
            String formatTime = "";
            try {
                if (alarmTime.length() > 0) {
                    formatTime = alarmTime.substring(5, alarmTime.length()).replace("-", "/");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return formatTime;
        }


        // 返回  月/日 时：分
        public String getFormatTime2() {
            String formatTime = "";
            try {
                if (alarmTime.length() > 0) {
                    formatTime = alarmTime.substring(5, alarmTime.length()).replace("-", "/");
                    formatTime = formatTime.substring(0,formatTime.lastIndexOf(":"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return formatTime;
        }



        public void setAlarmTime(String alarmTime) {
            this.alarmTime = alarmTime;
        }

        public String getReadStatus() {
            return readStatus;
        }

        public void setReadStatus(String readStatus) {
            this.readStatus = readStatus;
        }
    }
}
