package com.jovision.netkit.mvp.data.bean.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 云视通2.0移动侦测报警bean类
 */
public class OctMotionDetectBean implements Serializable {


    //    {
//        "method": "mdetect_get_param",
//            "level":"Operator",
//            "comments": "The max number of rects is 4, 0 means full screen motion detect.\nParam nSensitivity ranges from 0 to 255.\nParam x,y,w,h is measured in pixels.",
//            "param": {
//        "channelid": 0						//通道号，从0开始。
//    },
//        "result": {
//        "bEnable": true,				//是否开启
//         "detNameList":[{
//             "type":"",//"object","body","vehicle"
//            "name":""//中文名称：object：物体检测 body：人形检测 vehicle：车辆检测
//             }],//新协议：检测名称列表
//                "detTypeList":["object","body","vehicle"],	// 旧协议：支持的检测类型：object：物体检测 body：人形检测 vehicle：车辆检测
//        "detType":["object","body","vehicle"],	// 检测类型：object：物体检测 body：人形检测 vehicle：车辆检测
//        "alarm_link_id":1,			//报警联动计划id
//                "alarm_defence_plan_id":1,	//布防时间计划id
//                "bEnableSMD": true,				//开启人形检测，注意开启人形的时候必须把bEnable和bEnableSMD都置为true
//                "detecttype": "object, body, face",			//类型: 移动检测,人形检测,人脸检测,ivp.json中的bFaceCapSupport为false，则nvr不能配置此字段
//                "bAlarming": true,				//是否正在触发
//                "bEnableRecord": false,			//录像
//                "sensitivity": 80,				//灵敏度，范围0～255
//                "delay": 10,					//持续时间
//                "videoChannel": 1,				//绑定的视频通道
//                "bSnapshot": false,				//抓图
//                "nPreset": 0,					//报警联动预置位，-1表示未关联
//                "bBuzzing": false,				//蜂鸣器
//                "bOutClient": false,			//发送到客户端软件
//                "bOutEmail": false,				//发送邮件
//                "bOutFTP": false,				//发送FTP
//                "bSendToAlmServer": false,		//发送报警服务器
//                "bAlarmSoundEnable": false,		//报警声音
//                "bMarkObject": false,			//标记检测目标
//                "bReportObject": false,			//上报检测目标
//                "bPtzAutoTraceObject": false,		//云台追踪目标
//                "WhiteLight":{					//白光灯设置
//            "bEnable":false,   			//闪烁使能
//                    "Strength":0     			//闪烁强度（0~100），0：弱 50：强 100：长亮
//        },
//        "AlarmLight":{					//报警灯设置
//            "bEnable":false,   			//闪烁使能
//                    "Strength":0     			//闪烁强度（0~100）
//        },
//        "alarmout":						//关联的开关量报警输出：一个报警输入可关联多路报警输出
//			[
//        {
//            "almout_id": 0,				//关联报警输出的id
//                "type":"unknown,door,pir,smoke,gas,curtain",	//报警输入类型：未知类型，门磁，红外，烟感，燃气探测，幕帘探测
//                "bNormallyClosed": false	//false正常情况下是断开的，报警的时候闭合
//        }
//			],
//        "bUseGrids": true,		//true使用网格设置区域；false使用矩形
//                "maxRect": 4,			//矩形最大个数
//                "maxRectW": 1000,		//矩形最大宽度
//                "maxRectH": 1000,		//矩形最大高度
//                "rects": [				//矩形数组
//        {
//            "x": 0,
//                "y": 0,
//                "w": 100,
//                "h": 100
//        }
//            ],
//        "grids": {
//            "cntRow": 22,			//网格行数
//                    "cntCol": 22,			//网格列数
//                    "strid": 6,				//跨度。每行使用的整型个数。
//                    "value":[12345, 12354]	//每个整型代表32个网格，bit0在左边。每strid个整型表示一行数据
//        },
//        "task":{						//报警预约
//            "bsos": false,				//是否配置为紧急报警，true表示7*24小时报警
//                    "bAllTime": true,            //全时段布防
//                    "maxTime": 8,				//每天布防时间段的最大数
//                    "time":
//                [
//            {
//                "week": "Mon,Tues,Wed,Thur,Fri,Sat,Sun,EveryDay",	//星期1~7,每天
//                    "begin_hour": 12,	//开始小时
//                    "begin_min": 20,	//开始分钟
//                    "begin_sec": 30,	//开始秒
//                    "end_hour": 12,		//结束小时
//                    "end_min": 30,		//结束分钟
//                    "end_sec": 40		//结束秒
//            }
//            	]
//        }
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "Failed to get motion detect parameters!"
//    }
//    }



    private String method;
    private String level;
    private String comments;
    private ParamBean param;
    private ResultBean result;
    private ErrorBean error;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ParamBean getParam() {
        return param;
    }

    public void setParam(ParamBean param) {
        this.param = param;
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

    public static class ParamBean implements Serializable {
        private int channelid;//通道号，从0开始。

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }
    }

    public static class ResultBean implements Serializable {
        private boolean bEnable;
        private List<DetNameBean> detNameList;//检测名称列表
        private List<String> detTypeList;// 支持的检测类型：object：物体检测 body：人形检测 vehicle：车辆检测
        private List<String> detType;// 检测类型：object：物体检测 body：人形检测 vehicle：车辆检测
        private int alarm_link_id;//报警联动计划id
        private int alarm_defence_plan_id;//布防时间计划id
        private boolean bEnableSMD;//开启人形检测，注意开启人形的时候必须把bEnable和bEnableSMD都置为true
        private String detecttype;
        private boolean bAlarming;
        private boolean bEnableRecord;
        private int sensitivity;
        private int delay;
        private int videoChannel;
        private boolean bSnapshot;
        private int nPreset;
        private boolean bBuzzing;
        private boolean bOutClient;
        private boolean bOutEmail;
        private boolean bOutFTP;
        private boolean bSendToAlmServer;
        private boolean bAlarmSoundEnable;
        private boolean bMarkObject;
        private boolean bReportObject;
        private boolean bPtzAutoTraceObject;
        @SerializedName("WhiteLight")
        private WhiteLightBean whiteLight;
        @SerializedName("AlarmLight")
        private AlarmLightBean alarmLight;
        private List<AlarmoutBean> alarmout;
        private boolean bUseGrids;
        private int maxRect;
        private int maxRectW;
        private int maxRectH;
        private List<RectsBean> rects;
        private GridsBean grids;
        private OctAlarmTask task;

        public boolean isBEnable() {
            return bEnable;
        }

        public void setBEnable(boolean bEnable) {
            this.bEnable = bEnable;
        }

        public List<String> getDetTypeList() {
            return detTypeList;
        }

        public void setDetTypeList(List<String> detTypeList) {
            this.detTypeList = detTypeList;
        }

        public List<String> getDetType() {
            return detType;
        }

        public void setDetType(List<String> detType) {
            this.detType = detType;
        }

        public int getAlarm_link_id() {
            return alarm_link_id;
        }

        public void setAlarm_link_id(int alarm_link_id) {
            this.alarm_link_id = alarm_link_id;
        }

        public int getAlarm_defence_plan_id() {
            return alarm_defence_plan_id;
        }

        public void setAlarm_defence_plan_id(int alarm_defence_plan_id) {
            this.alarm_defence_plan_id = alarm_defence_plan_id;
        }

        public boolean isBEnableSMD() {
            return bEnableSMD;
        }

        public void setBEnableSMD(boolean bEnableSMD) {
            this.bEnableSMD = bEnableSMD;
        }

        public String getDetecttype() {
            return detecttype;
        }

        public void setDetecttype(String detecttype) {
            this.detecttype = detecttype;
        }

        public boolean isBAlarming() {
            return bAlarming;
        }

        public void setBAlarming(boolean bAlarming) {
            this.bAlarming = bAlarming;
        }

        public boolean isBEnableRecord() {
            return bEnableRecord;
        }

        public void setBEnableRecord(boolean bEnableRecord) {
            this.bEnableRecord = bEnableRecord;
        }

        public int getSensitivity() {
            return sensitivity;
        }

        public void setSensitivity(int sensitivity) {
            this.sensitivity = sensitivity;
        }

        public int getDelay() {
            return delay;
        }

        public void setDelay(int delay) {
            this.delay = delay;
        }

        public int getVideoChannel() {
            return videoChannel;
        }

        public void setVideoChannel(int videoChannel) {
            this.videoChannel = videoChannel;
        }

        public boolean isBSnapshot() {
            return bSnapshot;
        }

        public void setBSnapshot(boolean bSnapshot) {
            this.bSnapshot = bSnapshot;
        }

        public int getNPreset() {
            return nPreset;
        }

        public void setNPreset(int nPreset) {
            this.nPreset = nPreset;
        }

        public boolean isBBuzzing() {
            return bBuzzing;
        }

        public void setBBuzzing(boolean bBuzzing) {
            this.bBuzzing = bBuzzing;
        }

        public boolean isBOutClient() {
            return bOutClient;
        }

        public void setBOutClient(boolean bOutClient) {
            this.bOutClient = bOutClient;
        }

        public boolean isBOutEmail() {
            return bOutEmail;
        }

        public void setBOutEmail(boolean bOutEmail) {
            this.bOutEmail = bOutEmail;
        }

        public boolean isBOutFTP() {
            return bOutFTP;
        }

        public void setBOutFTP(boolean bOutFTP) {
            this.bOutFTP = bOutFTP;
        }

        public boolean isBSendToAlmServer() {
            return bSendToAlmServer;
        }

        public void setBSendToAlmServer(boolean bSendToAlmServer) {
            this.bSendToAlmServer = bSendToAlmServer;
        }

        public boolean isBAlarmSoundEnable() {
            return bAlarmSoundEnable;
        }

        public void setBAlarmSoundEnable(boolean bAlarmSoundEnable) {
            this.bAlarmSoundEnable = bAlarmSoundEnable;
        }

        public boolean isBMarkObject() {
            return bMarkObject;
        }

        public void setBMarkObject(boolean bMarkObject) {
            this.bMarkObject = bMarkObject;
        }

        public boolean isBReportObject() {
            return bReportObject;
        }

        public void setBReportObject(boolean bReportObject) {
            this.bReportObject = bReportObject;
        }

        public boolean isBPtzAutoTraceObject() {
            return bPtzAutoTraceObject;
        }

        public void setBPtzAutoTraceObject(boolean bPtzAutoTraceObject) {
            this.bPtzAutoTraceObject = bPtzAutoTraceObject;
        }

        public WhiteLightBean getWhiteLight() {
            return whiteLight;
        }

        public void setWhiteLight(WhiteLightBean whiteLight) {
            this.whiteLight = whiteLight;
        }

        public AlarmLightBean getAlarmLight() {
            return alarmLight;
        }

        public void setAlarmLight(AlarmLightBean alarmLight) {
            this.alarmLight = alarmLight;
        }

        public List<AlarmoutBean> getAlarmout() {
            return alarmout;
        }

        public void setAlarmout(List<AlarmoutBean> alarmout) {
            this.alarmout = alarmout;
        }

        public boolean isBUseGrids() {
            return bUseGrids;
        }

        public void setBUseGrids(boolean bUseGrids) {
            this.bUseGrids = bUseGrids;
        }

        public int getMaxRect() {
            return maxRect;
        }

        public void setMaxRect(int maxRect) {
            this.maxRect = maxRect;
        }

        public int getMaxRectW() {
            return maxRectW;
        }

        public void setMaxRectW(int maxRectW) {
            this.maxRectW = maxRectW;
        }

        public int getMaxRectH() {
            return maxRectH;
        }

        public void setMaxRectH(int maxRectH) {
            this.maxRectH = maxRectH;
        }

        public List<RectsBean> getRects() {
            return rects;
        }

        public void setRects(List<RectsBean> rects) {
            this.rects = rects;
        }

        public GridsBean getGrids() {
            return grids;
        }

        public void setGrids(GridsBean grids) {
            this.grids = grids;
        }

        public OctAlarmTask getTask() {
            return task;
        }

        public void setTask(OctAlarmTask task) {
            this.task = task;
        }

        public List<DetNameBean> getDetNameList() {
            return detNameList;
        }

        public void setDetNameList(List<DetNameBean> detNameList) {
            this.detNameList = detNameList;
        }

        public static class WhiteLightBean implements Serializable {
            private boolean bEnable;
            @SerializedName("Strength")
            private int strength;

            public boolean isBEnable() {
                return bEnable;
            }

            public void setBEnable(boolean bEnable) {
                this.bEnable = bEnable;
            }

            public int getStrength() {
                return strength;
            }

            public void setStrength(int strength) {
                this.strength = strength;
            }
        }


        public static class DetNameBean implements Serializable {

            private String type;//"object","body","vehicle"
            private String name;//中文名称：object：物体检测 body：人形检测 vehicle：车辆检测


            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }


        public static class AlarmLightBean implements Serializable {
            private boolean bEnable;
            @SerializedName("Strength")
            private int strength;

            public boolean isBEnable() {
                return bEnable;
            }

            public void setBEnable(boolean bEnable) {
                this.bEnable = bEnable;
            }

            public int getStrength() {
                return strength;
            }

            public void setStrength(int strength) {
                this.strength = strength;
            }
        }

        public static class GridsBean implements Serializable {
            private int cntRow;
            private int cntCol;
            private int strid;
            private List<Integer> value;

            public int getCntRow() {
                return cntRow;
            }

            public void setCntRow(int cntRow) {
                this.cntRow = cntRow;
            }

            public int getCntCol() {
                return cntCol;
            }

            public void setCntCol(int cntCol) {
                this.cntCol = cntCol;
            }

            public int getStrid() {
                return strid;
            }

            public void setStrid(int strid) {
                this.strid = strid;
            }

            public List<Integer> getValue() {
                return value;
            }

            public void setValue(List<Integer> value) {
                this.value = value;
            }
        }

        public static class TaskBean implements Serializable {
            private boolean bsos;
            private boolean bAllTime;
            private int maxTime;
            private List<TimeBean> time;

            public boolean isBsos() {
                return bsos;
            }

            public void setBsos(boolean bsos) {
                this.bsos = bsos;
            }

            public boolean isBAllTime() {
                return bAllTime;
            }

            public void setBAllTime(boolean bAllTime) {
                this.bAllTime = bAllTime;
            }

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

            public static class TimeBean implements Serializable {
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
        }

        public static class AlarmoutBean implements Serializable {
            private int almout_id;
            private String type;
            private boolean bNormallyClosed;

            public int getAlmout_id() {
                return almout_id;
            }

            public void setAlmout_id(int almout_id) {
                this.almout_id = almout_id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public boolean isBNormallyClosed() {
                return bNormallyClosed;
            }

            public void setBNormallyClosed(boolean bNormallyClosed) {
                this.bNormallyClosed = bNormallyClosed;
            }
        }

        public static class RectsBean implements Serializable {
            private int x;
            private int y;
            private int w;
            private int h;

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }

            public int getW() {
                return w;
            }

            public void setW(int w) {
                this.w = w;
            }

            public int getH() {
                return h;
            }

            public void setH(int h) {
                this.h = h;
            }
        }
    }

    public static class ErrorBean implements Serializable {
        private int errorcode;
        private String message;

        public int getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(int errorcode) {
            this.errorcode = errorcode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
















////    {
////        "method": "mdetect_get_param",
////            "comments": "The max number of rects is 4, 0 means full screen motion detect.\nParam nSensitivity ranges from 0 to 255.\nParam x,y,w,h is measured in pixels.",
////            "param": {
////        "channelid": 0						//通道号，从0开始。
////    },
////        "result": {
////        "bEnable": true,				//是否开启
////                "bEnableSMD": true,				//开启人形检测，注意开启人形的时候必须把bEnable和bEnableSMD都置为true
////                "detecttype": "object, body, face",			//类型: 移动检测,人形检测,人脸检测,ivp.json中的bFaceCapSupport为false，则nvr不能配置此字段
////                "bAlarming": true,				//是否正在触发
////                "bEnableRecord": false,			//录像
////                "sensitivity": 80,				//灵敏度，范围0～255
////                "delay": 10,					//持续时间
////                "videoChannel": 1,				//绑定的视频通道
////                "bSnapshot": false,				//抓图
////                "nPreset": 0,					//报警联动预置位，-1表示未关联
////                "bBuzzing": false,				//蜂鸣器
////                "bOutClient": false,			//发送到客户端软件
////                "bOutEmail": false,				//发送邮件
////                "bOutFTP": false,				//发送FTP
////                "bSendToAlmServer": false,		//发送报警服务器
////                "bAlarmSoundEnable": false,		//报警声音
////                "bMarkObject": false,			//标记检测目标
////                "bReportObject": false,			//上报检测目标
////                "bPtzAutoTraceObject": false,		//云台追踪目标
////                "WhiteLight":{					//白光灯设置
////            "bEnable":false,   			//闪烁使能
////                    "Strength":0     			//闪烁强度（0~100），0：弱 50：强 100：长亮
////        },
////        "AlarmLight":{					//报警灯设置
////            "bEnable":false,   			//闪烁使能
////                    "Strength":0     			//闪烁强度（0~100）
////        },
////        "alarmout":						//关联的开关量报警输出：一个报警输入可关联多路报警输出
////			[
////        {
////            "almout_id": 0,				//关联报警输出的id
////                "type":"unknown,door,pir,smoke,gas,curtain",	//报警输入类型：未知类型，门磁，红外，烟感，燃气探测，幕帘探测
////                "bNormallyClosed": false	//false正常情况下是断开的，报警的时候闭合
////        }
////			],
////        "bUseGrids": true,		//true使用网格设置区域；false使用矩形
////                "maxRect": 4,			//矩形最大个数
////                "maxRectW": 1000,		//矩形最大宽度
////                "maxRectH": 1000,		//矩形最大高度
////                "rects": [				//矩形数组
////        {
////            "x": 0,
////                "y": 0,
////                "w": 100,
////                "h": 100
////        }
////            ],
////        "grids": {
////            "cntRow": 22,			//网格行数
////                    "cntCol": 22,			//网格列数
////                    "strid": 6,				//跨度。每行使用的整型个数。
////                    "value":[12345, 12354]	//每个整型代表32个网格，bit0在左边。每strid个整型表示一行数据
////        },
////        "task":{						//报警预约
////            "bsos": false,				//是否配置为紧急报警，true表示7*24小时报警
////                    "bAllTime": true,            //全时段布防
////                    "maxTime": 8,				//每天布防时间段的最大数
////                    "time":
////                [
////            {
////                "week": "Mon,Tues,Wed,Thur,Fri,Sat,Sun,EveryDay",	//星期1~7,每天
////                    "begin_hour": 12,	//开始小时
////                    "begin_min": 20,	//开始分钟
////                    "begin_sec": 30,	//开始秒
////                    "end_hour": 12,		//结束小时
////                    "end_min": 30,		//结束分钟
////                    "end_sec": 40		//结束秒
////            }
////            	]
////        }
////    },
////        "error": {
////        "errorcode": -1,
////                "message": "Failed to get motion detect parameters!"
////    }
////    }
//
//    /**
//     * method : mdetect_get_param
//     * comments : The max number of rects is 4, 0 means full screen motion detect.\nParam nSensitivity ranges from 0 to 255.\nParam x,y,w,h is measured in pixels.
//     * user : {"name":"admin","digest":"b6338504bf53ed7b18af6cf45546f345"}
//     * result : {"bEnable":true,"bAlarming":true,"bEnableRecord":false,"sensitivity":100,"delay":10,"videoChannel":0,"bSnapshot":true,"nPreset":0,"bBuzzing":false,"bOutClient":true,"bOutEmail":false,"bSendToAlmServer":false,"WhiteLight":{"bEnable":false,"Strength":0},"bUseGrids":false,"maxRect":4,"maxRectW":2044,"maxRectH":1520,"rects":[{"x":342,"y":244,"w":1405,"h":447},{"x":20,"y":13,"w":1992,"h":1479}],"grids":{"cntRow":0,"cntCol":0,"strid":0},"task":{"bsos":false,"bAllTime":true,"maxTime":4}}
//     * error : {"errorcode":0}
//     */
//
//    private String method;
//    private String comments;
//    private UserBean user;
//    private ResultBean result;
//    private ErrorBean error;
//
//    public String getMethod() {
//        return method;
//    }
//
//    public void setMethod(String method) {
//        this.method = method;
//    }
//
//    public String getComments() {
//        return comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
//
//    public UserBean getUser() {
//        return user;
//    }
//
//    public void setUser(UserBean user) {
//        this.user = user;
//    }
//
//    public ResultBean getResult() {
//        return result;
//    }
//
//    public void setResult(ResultBean result) {
//        this.result = result;
//    }
//
//    public ErrorBean getError() {
//        return error;
//    }
//
//    public void setError(ErrorBean error) {
//        this.error = error;
//    }
//
//    public static class UserBean implements Serializable {
//        /**
//         * name : admin
//         * digest : b6338504bf53ed7b18af6cf45546f345
//         */
//
//        private String name;
//        private String digest;
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getDigest() {
//            return digest;
//        }
//
//        public void setDigest(String digest) {
//            this.digest = digest;
//        }
//    }
//
//    public static class ResultBean implements Serializable {
//        /**
//         * bEnable : true
//         * bAlarming : true
//         * bEnableRecord : false
//         * sensitivity : 100
//         * delay : 10
//         * videoChannel : 0
//         * bSnapshot : true
//         * nPreset : 0
//         * bBuzzing : false
//         * bOutClient : true
//         * bOutEmail : false
//         * bSendToAlmServer : false
//         * WhiteLight : {"bEnable":false,"Strength":0}
//         * bUseGrids : false
//         * maxRect : 4
//         * maxRectW : 2044
//         * maxRectH : 1520
//         * rects : [{"x":342,"y":244,"w":1405,"h":447},{"x":20,"y":13,"w":1992,"h":1479}]
//         * grids : {"cntRow":0,"cntCol":0,"strid":0}
//         * task : {"bsos":false,"bAllTime":true,"maxTime":4}
//         */
//        private int channelid;
//        private boolean bEnable;
//        private boolean bEnableSMD;//是否开启人形检测
//        private boolean bAlarming;
//        private boolean bEnableRecord;
//        private int sensitivity;
//        private int delay;
//        private int videoChannel;
//        private boolean bSnapshot;
//        private int nPreset;
//        private boolean bBuzzing;
//        private boolean bOutClient;
//        private boolean bOutEmail;
//        private boolean bSendToAlmServer;
//        private WhiteLightBean WhiteLight;
//        private boolean bUseGrids;
//        private int maxRect;
//        private int maxRectW;
//        private int maxRectH;
//        private GridsBean grids;
//        private OctAlarmTask task;
//        private List<RectsBean> rects;
//        private boolean bAlarmSoundEnable;
//        private boolean bPtzAutoTraceObject;//2019.12.13 xns 人形目标跟踪开关
//
//        public boolean isBAlarmSoundEnable() {
//            return bAlarmSoundEnable;
//        }
//
//        public void setBAlarmSoundEnable(boolean bAlarmSoundEnable) {
//            this.bAlarmSoundEnable = bAlarmSoundEnable;
//        }
//
//        public int getChannelid() {
//            return channelid;
//        }
//
//        public void setChannelid(int channelid) {
//            this.channelid = channelid;
//        }
//
//        public boolean isBEnable() {
//            return bEnable;
//        }
//
//        public void setBEnable(boolean bEnable) {
//            this.bEnable = bEnable;
//        }
//
//        public boolean isBAlarming() {
//            return bAlarming;
//        }
//
//        public void setBAlarming(boolean bAlarming) {
//            this.bAlarming = bAlarming;
//        }
//
//        public boolean isBEnableRecord() {
//            return bEnableRecord;
//        }
//
//        public void setBEnableRecord(boolean bEnableRecord) {
//            this.bEnableRecord = bEnableRecord;
//        }
//
//        public int getSensitivity() {
//            return sensitivity;
//        }
//
//        public void setSensitivity(int sensitivity) {
//            this.sensitivity = sensitivity;
//        }
//
//        public int getDelay() {
//            return delay;
//        }
//
//        public void setDelay(int delay) {
//            this.delay = delay;
//        }
//
//        public int getVideoChannel() {
//            return videoChannel;
//        }
//
//        public void setVideoChannel(int videoChannel) {
//            this.videoChannel = videoChannel;
//        }
//
//        public boolean isBSnapshot() {
//            return bSnapshot;
//        }
//
//        public void setBSnapshot(boolean bSnapshot) {
//            this.bSnapshot = bSnapshot;
//        }
//
//        public int getNPreset() {
//            return nPreset;
//        }
//
//        public void setNPreset(int nPreset) {
//            this.nPreset = nPreset;
//        }
//
//        public boolean isBBuzzing() {
//            return bBuzzing;
//        }
//
//        public void setBBuzzing(boolean bBuzzing) {
//            this.bBuzzing = bBuzzing;
//        }
//
//        public boolean isBOutClient() {
//            return bOutClient;
//        }
//
//        public void setBOutClient(boolean bOutClient) {
//            this.bOutClient = bOutClient;
//        }
//
//        public boolean isBOutEmail() {
//            return bOutEmail;
//        }
//
//        public void setBOutEmail(boolean bOutEmail) {
//            this.bOutEmail = bOutEmail;
//        }
//
//        public boolean isBSendToAlmServer() {
//            return bSendToAlmServer;
//        }
//
//        public void setBSendToAlmServer(boolean bSendToAlmServer) {
//            this.bSendToAlmServer = bSendToAlmServer;
//        }
//
//        public WhiteLightBean getWhiteLight() {
//            return WhiteLight;
//        }
//
//        public void setWhiteLight(WhiteLightBean WhiteLight) {
//            this.WhiteLight = WhiteLight;
//        }
//
//        public boolean isBUseGrids() {
//            return bUseGrids;
//        }
//
//        public void setBUseGrids(boolean bUseGrids) {
//            this.bUseGrids = bUseGrids;
//        }
//
//        public int getMaxRect() {
//            return maxRect;
//        }
//
//        public void setMaxRect(int maxRect) {
//            this.maxRect = maxRect;
//        }
//
//        public int getMaxRectW() {
//            return maxRectW;
//        }
//
//        public void setMaxRectW(int maxRectW) {
//            this.maxRectW = maxRectW;
//        }
//
//        public int getMaxRectH() {
//            return maxRectH;
//        }
//
//        public void setMaxRectH(int maxRectH) {
//            this.maxRectH = maxRectH;
//        }
//
//        public GridsBean getGrids() {
//            return grids;
//        }
//
//        public void setGrids(GridsBean grids) {
//            this.grids = grids;
//        }
//
//        public OctAlarmTask getTask() {
//            return task;
//        }
//
//        public void setTask(OctAlarmTask task) {
//            this.task = task;
//        }
//
//        public List<RectsBean> getRects() {
//            return rects;
//        }
//
//        public void setRects(List<RectsBean> rects) {
//            this.rects = rects;
//        }
//
//        public boolean isBEnableSMD() {
//            return bEnableSMD;
//        }
//
//        public void setBEnableSMD(boolean bEnableSMD) {
//            this.bEnableSMD = bEnableSMD;
//        }
//
//        public boolean isBPtzAutoTraceObject() {
//            return bPtzAutoTraceObject;
//        }
//
//        public void setBPtzAutoTraceObject(boolean bPtzAutoTraceObject) {
//            this.bPtzAutoTraceObject = bPtzAutoTraceObject;
//        }
//
//        public static class WhiteLightBean implements Serializable {
//            /**
//             * bEnable : false
//             * Strength : 0
//             */
//
//            private boolean bEnable;
//            private int Strength;
//
//            public boolean isBEnable() {
//                return bEnable;
//            }
//
//            public void setBEnable(boolean bEnable) {
//                this.bEnable = bEnable;
//            }
//
//            public int getStrength() {
//                return Strength;
//            }
//
//            public void setStrength(int Strength) {
//                this.Strength = Strength;
//            }
//        }
//
//        public static class GridsBean implements Serializable {
//            /**
//             * cntRow : 0
//             * cntCol : 0
//             * strid : 0
//             */
//
//            private int cntRow;
//            private int cntCol;
//            private int strid;
//
//            public int getCntRow() {
//                return cntRow;
//            }
//
//            public void setCntRow(int cntRow) {
//                this.cntRow = cntRow;
//            }
//
//            public int getCntCol() {
//                return cntCol;
//            }
//
//            public void setCntCol(int cntCol) {
//                this.cntCol = cntCol;
//            }
//
//            public int getStrid() {
//                return strid;
//            }
//
//            public void setStrid(int strid) {
//                this.strid = strid;
//            }
//        }
//
//        public static class TaskBean implements Serializable {
//            /**
//             * bsos : false
//             * bAllTime : true
//             * maxTime : 4
//             */
//            private List<TimeBean> time;
//            private boolean bsos;
//            private boolean bAllTime;
//            private int maxTime;
//
//            public boolean isBsos() {
//                return bsos;
//            }
//
//            public void setBsos(boolean bsos) {
//                this.bsos = bsos;
//            }
//
//            public boolean isBAllTime() {
//                return bAllTime;
//            }
//
//            public void setBAllTime(boolean bAllTime) {
//                this.bAllTime = bAllTime;
//            }
//
//            public int getMaxTime() {
//                return maxTime;
//            }
//
//            public void setMaxTime(int maxTime) {
//                this.maxTime = maxTime;
//            }
//
//
//            public List<TimeBean> getTime() {
//                return time;
//            }
//
//            public void setTime(List<TimeBean> time) {
//                this.time = time;
//            }
//
//            public static class TimeBean implements Serializable {
//                /**
//                 * week : Sun
//                 * begin_hour : 12
//                 * begin_min : 0
//                 * end_hour : 14
//                 * end_min : 0
//                 */
//
//                private String week;
//                private int begin_hour;
//                private int begin_min;
//                private int end_hour;
//                private int end_min;
//
//                public String getWeek() {
//                    return week;
//                }
//
//                public void setWeek(String week) {
//                    this.week = week;
//                }
//
//                public int getBegin_hour() {
//                    return begin_hour;
//                }
//
//                public void setBegin_hour(int begin_hour) {
//                    this.begin_hour = begin_hour;
//                }
//
//                public int getBegin_min() {
//                    return begin_min;
//                }
//
//                public void setBegin_min(int begin_min) {
//                    this.begin_min = begin_min;
//                }
//
//                public int getEnd_hour() {
//                    return end_hour;
//                }
//
//                public void setEnd_hour(int end_hour) {
//                    this.end_hour = end_hour;
//                }
//
//                public int getEnd_min() {
//                    return end_min;
//                }
//
//                public void setEnd_min(int end_min) {
//                    this.end_min = end_min;
//                }
//                public String getStr(){
//                    return begin_hour+""+begin_min+""+end_hour+""+end_min;
//                }
//            }
//        }
//
//        public static class RectsBean implements Serializable {
//            /**
//             * x : 342
//             * y : 244
//             * w : 1405
//             * h : 447
//             */
//
//            private int x;
//            private int y;
//            private int w;
//            private int h;
//
//            public int getX() {
//                return x;
//            }
//
//            public void setX(int x) {
//                this.x = x;
//            }
//
//            public int getY() {
//                return y;
//            }
//
//            public void setY(int y) {
//                this.y = y;
//            }
//
//            public int getW() {
//                return w;
//            }
//
//            public void setW(int w) {
//                this.w = w;
//            }
//
//            public int getH() {
//                return h;
//            }
//
//            public void setH(int h) {
//                this.h = h;
//            }
//        }
//    }
//
//    public static class ErrorBean implements Serializable {
//        /**
//         * errorcode : 0
//         */
//
//        private int errorcode;
//
//        public int getErrorcode() {
//            return errorcode;
//        }
//
//        public void setErrorcode(int errorcode) {
//            this.errorcode = errorcode;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "OctMotionDetect{" +
//                "method='" + method + '\'' +
//                ", comments='" + comments + '\'' +
//                ", user=" + user +
//                ", result=" + result +
//                ", error=" + error +
//                '}';
//    }
}