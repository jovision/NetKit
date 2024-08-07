package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

/**
 * 获取录像信息
 */
public class OctRecordGetInfoBean {

//
//    {
//        "method": "record_get",
//            "param": {
//        "channelid": 0		//通道号，从0开始。-1表示所有
//    },
//        "result": {
//        "record_params": [
//        {
//            "channelid": 0,		//通道号，从0开始。
//                "streamid": 0,
//                "brecording": false,	//是否正在录像
//                "normal_record": false,
//                "time_record": false,
//                "disconnect_record": false,		//断开录像
//                "alarm_record": false,			//报警录像
//                "sd_prerecord":{
//            "bEnable": false,	//是否使能
//                    "Duration": 120	//录像缓存时长 s，预留
//        },
//            "extract_record": false,		//缩时录像
//                "extract_sec": 4,			//缩时录像抽帧间隔
//                "packettimelen_list":				//录像时长列表，ipc传递，后期扩展或者删除 int 类型
//					[
//            5,			//	5分钟
//                    10,			// 10分钟
//                    20,			// 20分钟
//                    30			//30分钟
//					],
//
//            "packettimelen": 10,		//打包时长，单位分钟
//                "bRecAudio": true,		//是否录制音频
//                "bOutFTP": false,				//发送到FTP
//                "task":{						//定时录像
//            "maxTime": 8,				//每天布防时间段的最大数
//                    "time":
//                        [
//            {
//                "week": "Mon,Tues,Wed,Thur,Fri,Sat,Sun,EveryDay",	//星期1~7,每天
//                    "begin_hour": 12,	//开始小时
//                    "begin_min": 20,	//开始分钟
//                    "begin_sec": 30,	//开始秒
//                    "end_hour": 12,		//结束小时
//                    "end_min": 30,		//结束分钟
//                    "end_sec": 40		//结束秒
//            }
//                    	]
//        }
//        }
//            ]
//    },
//        "error": {
//        "errorcode": 0
//    }
//    }

private String method;
        private UserBean user;
        private ResultBean result;
        private ErrorBean error;

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
        }

        public ErrorBean getError() {
            return error;
        }

        public void setError(ErrorBean error) {
            this.error = error;
        }

public static class UserBean implements Serializable{
    /**
     * name : admin
     * digest : d65248bada856c8e00a7f3536c9d2bc0
     */

    private String name;
    private String digest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }
}

public static class ResultBean implements Serializable{
    private List<RecordParamsBean> record_params;

    public List<RecordParamsBean> getRecord_params() {
        return record_params;
    }

    public void setRecord_params(List<RecordParamsBean> record_params) {
        this.record_params = record_params;
    }

    public static class RecordParamsBean implements Serializable{
        /**
         * channelid : 0
         * brecording : true
         * normal_record : true
         * time_record : false
         * disconnect_record : false
         * alarm_record : false
         * extract_record : false
         * extract_sec : 4
         * packettimelen : 10
         * bRecAudio : false
         * task : {"maxTime":1,"time":[{"week":"EveryDay","begin_hour":0,"begin_min":0,"begin_sec":0,"end_hour":0,"end_min":0,"end_sec":0}]}
         */

        private int channelid;
        private int streamid;
        private boolean brecording;
        private boolean normal_record;
        private boolean time_record;
        private boolean disconnect_record;
        private boolean alarm_record;
        private PrerecordBean sd_prerecord;
        private boolean extract_record;
        private int extract_sec;
        private int[] packettimelen_list;
        private int packettimelen;
        private boolean bRecAudio;
        private TaskBean task;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }

        public boolean isBrecording() {
            return brecording;
        }

        public void setBrecording(boolean brecording) {
            this.brecording = brecording;
        }

        public boolean isNormal_record() {
            return normal_record;
        }

        public void setNormal_record(boolean normal_record) {
            this.normal_record = normal_record;
        }

        public boolean isTime_record() {
            return time_record;
        }

        public void setTime_record(boolean time_record) {
            this.time_record = time_record;
        }

        public boolean isDisconnect_record() {
            return disconnect_record;
        }

        public void setDisconnect_record(boolean disconnect_record) {
            this.disconnect_record = disconnect_record;
        }

        public boolean isAlarm_record() {
            return alarm_record;
        }

        public void setAlarm_record(boolean alarm_record) {
            this.alarm_record = alarm_record;
        }

        public PrerecordBean getSd_prerecord() {
            return sd_prerecord;
        }

        public void setSd_prerecord(PrerecordBean sd_prerecord) {
            this.sd_prerecord = sd_prerecord;
        }

        public boolean isExtract_record() {
            return extract_record;
        }

        public void setExtract_record(boolean extract_record) {
            this.extract_record = extract_record;
        }

        public int getExtract_sec() {
            return extract_sec;
        }

        public void setExtract_sec(int extract_sec) {
            this.extract_sec = extract_sec;
        }

        public int[] getPackettimelen_list() {
            return packettimelen_list;
        }

        public void setPackettimelen_list(int[] packettimelen_list) {
            this.packettimelen_list = packettimelen_list;
        }

        public int getPackettimelen() {
            return packettimelen;
        }

        public void setPackettimelen(int packettimelen) {
            this.packettimelen = packettimelen;
        }

        public boolean isBRecAudio() {
            return bRecAudio;
        }

        public void setBRecAudio(boolean bRecAudio) {
            this.bRecAudio = bRecAudio;
        }

        public TaskBean getTask() {
            return task;
        }

        public void setTask(TaskBean task) {
            this.task = task;
        }

        public int getStreamid() {
            return streamid;
        }

        public void setStreamid(int streamid) {
            this.streamid = streamid;
        }

        public static class PrerecordBean implements Serializable {

            private boolean bEnable;
            private int Duration;

            public boolean isbEnable() {
                return bEnable;
            }

            public void setbEnable(boolean bEnable) {
                this.bEnable = bEnable;
            }

            public int getDuration() {
                return Duration;
            }

            public void setDuration(int duration) {
                Duration = duration;
            }
        }
        public static class TaskBean implements Serializable{
            /**
             * maxTime : 1
             * time : [{"week":"EveryDay","begin_hour":0,"begin_min":0,"begin_sec":0,"end_hour":0,"end_min":0,"end_sec":0}]
             */

            private int maxTime;
            private List<TimeBean> time;

            public int getMaxTime() {
                return maxTime;
            }

            public void setMaxTime(int maxTime) {
                this.maxTime = maxTime;
            }

            public List<TimeBean> getTime() {
                return time;
            }

            public void setTime(List<TimeBean> time) {
                this.time = time;
            }


        }
    }
}

    public static class TimeBean implements Serializable{
        /**
         * week : EveryDay
         * begin_hour : 0
         * begin_min : 0
         * begin_sec : 0
         * end_hour : 0
         * end_min : 0
         * end_sec : 0
         */

        private String week;
        private int begin_hour;
        private int begin_min;
        private int begin_sec;
        private int end_hour;
        private int end_min;
        private int end_sec;

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public int getBegin_hour() {
            return begin_hour;
        }

        public void setBegin_hour(int begin_hour) {
            this.begin_hour = begin_hour;
        }

        public int getBegin_min() {
            return begin_min;
        }

        public void setBegin_min(int begin_min) {
            this.begin_min = begin_min;
        }

        public int getBegin_sec() {
            return begin_sec;
        }

        public void setBegin_sec(int begin_sec) {
            this.begin_sec = begin_sec;
        }

        public int getEnd_hour() {
            return end_hour;
        }

        public void setEnd_hour(int end_hour) {
            this.end_hour = end_hour;
        }

        public int getEnd_min() {
            return end_min;
        }

        public void setEnd_min(int end_min) {
            this.end_min = end_min;
        }

        public int getEnd_sec() {
            return end_sec;
        }

        public void setEnd_sec(int end_sec) {
            this.end_sec = end_sec;
        }
    }


public static class ErrorBean implements Serializable {
    /**
     * errorcode : 0
     */

    private int errorcode;

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }
}
}
