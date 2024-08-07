package com.jovision.netkit.mvp.data.bean.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/12/11
 * 描述：
 */
public class HideAlarmBean implements Serializable {
    private String method;
    private String level;
    private Param param;
    private ResultBean resultBean;
    private ErrorBean errorBean;

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

    public Param getParam() {
        return param;
    }

    public void setParam(Param param) {
        this.param = param;
    }

    public ResultBean getResultBean() {
        return resultBean;
    }

    public void setResultBean(ResultBean resultBean) {
        this.resultBean = resultBean;
    }

    public ErrorBean getErrorBean() {
        return errorBean;
    }

    public void setErrorBean(ErrorBean errorBean) {
        this.errorBean = errorBean;
    }

    public static class Param implements Serializable{
        private Integer channelid;

        public Integer getChannelid() {
            return channelid;
        }

        public void setChannelid(Integer channelid) {
            this.channelid = channelid;
        }
    }

    public static class ResultBean implements Serializable {
        private Integer channelid;
        private Boolean bEnable;
        private Integer alarm_link_id;
        private Integer alarm_defence_plan_id;
        private Integer nSen;
        private Integer maxRectW;
        private Integer maxRectH;
        private TaskBean taskBean;
        private Boolean bOutClient;
        private Boolean bOutEmail;
        private Boolean bEnableRecord;
        private Boolean bAlarmSoundEnable;
        @SerializedName("WhiteLight")
        private WhiteLight whiteLight;
        @SerializedName("AlarmLight")
        private AlarmLight alarmLight;
        private List<Alarmout> alarmout;

        public Integer getChannelid() {
            return channelid;
        }

        public void setChannelid(Integer channelid) {
            this.channelid = channelid;
        }

        public Boolean getBEnable() {
            return bEnable;
        }

        public void setBEnable(Boolean bEnable) {
            this.bEnable = bEnable;
        }

        public Integer getAlarm_link_id() {
            return alarm_link_id;
        }

        public void setAlarm_link_id(Integer alarm_link_id) {
            this.alarm_link_id = alarm_link_id;
        }

        public Integer getAlarm_defence_plan_id() {
            return alarm_defence_plan_id;
        }

        public void setAlarm_defence_plan_id(Integer alarm_defence_plan_id) {
            this.alarm_defence_plan_id = alarm_defence_plan_id;
        }

        public Integer getNSen() {
            return nSen;
        }

        public void setNSen(Integer nSen) {
            this.nSen = nSen;
        }

        public Integer getMaxRectW() {
            return maxRectW;
        }

        public void setMaxRectW(Integer maxRectW) {
            this.maxRectW = maxRectW;
        }

        public Integer getMaxRectH() {
            return maxRectH;
        }

        public void setMaxRectH(Integer maxRectH) {
            this.maxRectH = maxRectH;
        }

        public TaskBean getTaskBean() {
            return taskBean;
        }

        public void setTask(TaskBean taskBean) {
            this.taskBean = taskBean;
        }

        public Boolean getBOutClient() {
            return bOutClient;
        }

        public void setBOutClient(Boolean bOutClient) {
            this.bOutClient = bOutClient;
        }

        public Boolean getBOutEmail() {
            return bOutEmail;
        }

        public void setBOutEmail(Boolean bOutEmail) {
            this.bOutEmail = bOutEmail;
        }

        public Boolean getBEnableRecord() {
            return bEnableRecord;
        }

        public void setBEnableRecord(Boolean bEnableRecord) {
            this.bEnableRecord = bEnableRecord;
        }

        public Boolean getBAlarmSoundEnable() {
            return bAlarmSoundEnable;
        }

        public void setBAlarmSoundEnable(Boolean bAlarmSoundEnable) {
            this.bAlarmSoundEnable = bAlarmSoundEnable;
        }

        public WhiteLight getWhiteLight() {
            return whiteLight;
        }

        public void setWhiteLight(WhiteLight whiteLight) {
            this.whiteLight = whiteLight;
        }

        public AlarmLight getAlarmLight() {
            return alarmLight;
        }

        public void setAlarmLight(AlarmLight alarmLight) {
            this.alarmLight = alarmLight;
        }

        public List<Alarmout> getAlarmout() {
            return alarmout;
        }

        public void setAlarmout(List<Alarmout> alarmout) {
            this.alarmout = alarmout;
        }

        public static class TaskBean implements Serializable {
            private Boolean bsos;
            private Boolean bAllTime;
            private Integer maxTime;
            private List<TimeBean> timeBean;

            public Boolean getBsos() {
                return bsos;
            }

            public void setBsos(Boolean bsos) {
                this.bsos = bsos;
            }

            public Boolean getBAllTime() {
                return bAllTime;
            }

            public void setBAllTime(Boolean bAllTime) {
                this.bAllTime = bAllTime;
            }

            public Integer getMaxTime() {
                return maxTime;
            }

            public void setMaxTime(Integer maxTime) {
                this.maxTime = maxTime;
            }

            public List<TimeBean> getTimeBean() {
                return timeBean;
            }

            public void setTime(List<TimeBean> timeBean) {
                this.timeBean = timeBean;
            }

            public static class TimeBean implements Serializable {
                private String week;
                private Integer begin_hour;
                private Integer begin_min;
                private Integer begin_sec;
                private Integer end_hour;
                private Integer end_min;
                private Integer end_sec;

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public Integer getBegin_hour() {
                    return begin_hour;
                }

                public void setBegin_hour(Integer begin_hour) {
                    this.begin_hour = begin_hour;
                }

                public Integer getBegin_min() {
                    return begin_min;
                }

                public void setBegin_min(Integer begin_min) {
                    this.begin_min = begin_min;
                }

                public Integer getBegin_sec() {
                    return begin_sec;
                }

                public void setBegin_sec(Integer begin_sec) {
                    this.begin_sec = begin_sec;
                }

                public Integer getEnd_hour() {
                    return end_hour;
                }

                public void setEnd_hour(Integer end_hour) {
                    this.end_hour = end_hour;
                }

                public Integer getEnd_min() {
                    return end_min;
                }

                public void setEnd_min(Integer end_min) {
                    this.end_min = end_min;
                }

                public Integer getEnd_sec() {
                    return end_sec;
                }

                public void setEnd_sec(Integer end_sec) {
                    this.end_sec = end_sec;
                }
            }
        }

        public static class WhiteLight implements Serializable {
            private Boolean bEnable;
            @SerializedName("Strength")
            private Integer strength;

            public Boolean getBEnable() {
                return bEnable;
            }

            public void setBEnable(Boolean bEnable) {
                this.bEnable = bEnable;
            }

            public Integer getStrength() {
                return strength;
            }

            public void setStrength(Integer strength) {
                this.strength = strength;
            }
        }

        public static class AlarmLight implements Serializable {
            private Boolean bEnable;
            @SerializedName("Strength")
            private Integer strength;

            public Boolean getBEnable() {
                return bEnable;
            }

            public void setBEnable(Boolean bEnable) {
                this.bEnable = bEnable;
            }

            public Integer getStrength() {
                return strength;
            }

            public void setStrength(Integer strength) {
                this.strength = strength;
            }
        }

        public static class Alarmout implements Serializable {
            private Integer almout_id;
            private String type;
            private Boolean bNormallyClosed;

            public Integer getAlmout_id() {
                return almout_id;
            }

            public void setAlmout_id(Integer almout_id) {
                this.almout_id = almout_id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Boolean getBNormallyClosed() {
                return bNormallyClosed;
            }

            public void setBNormallyClosed(Boolean bNormallyClosed) {
                this.bNormallyClosed = bNormallyClosed;
            }
        }
    }

}


//    {//获取视频遮挡的参数
//        "method": "ivp_hide_get_param",
//            "level":"Operator",
//            "param": {
//        "channelid": 0
//    },
//        "result": {
//        "bEnable": false,			//是否启用
//                "alarm_link_id":1,			//报警联动计划id
//                "alarm_defence_plan_id":1,	//布防时间计划id
//                "nSen": 0,					//灵敏度0~100
//                "maxRectW": 1000,			//视频输入最大宽度
//                "maxRectH": 1000,			//视频输入最大高度
//                "task":
//        {							//报警预约
//            "bsos": false,			//是否配置为紧急报警，true表示7*24小时报警，false表示按时间段报警
//                "bAllTime": true,       //全时段布防
//                "maxTime": 8,			//每天布防时间段的最大数
//                "time":
//				[
//            {
//                "week": "Mon,Tues,Wed,Thur,Fri,Sat,Sun,EveryDay",	//星期1~7,每天
//                    "begin_hour": 12,	//开始小时
//                    "begin_min": 20,	//开始分钟
//                    "begin_sec": 30,	//开始秒
//                    "end_hour": 12,		//结束小时
//                    "end_min": 30,		//结束分钟
//                    "end_sec": 40		//结束秒
//            }
//				]
//        },
//        "bOutClient": false,			//发送到客户端软件
//                "bOutEmail": false,				//发送邮件
//                "bEnableRecord": false,			//录像
//                "bAlarmSoundEnable": false,		//报警声音
//                "WhiteLight":{					//白光灯设置
//            "bEnable":false,   			//闪烁使能
//                    "Strength":0     			//闪烁强度（0~100），0：弱  50：强 100：长亮
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
//			]
//    },
//        "error": {
//        "errorcode": -1
//    }
//    }


//        /**
//         * bEnable : true
//         * nSen : 90
//         * nThreshold : 40
//         * nStayTime : 0
//         * bDrawFrame : false
//         * bFlushFrame : true
//         * bMarkObject : true
//         * bMarkAll : false
//         * maxRectW : 1920
//         * maxRectH : 1080
//         * maxRegion : 2
//         * task : {"bsos":false,"bAllTime":false,"maxTime":1}
//         * bOutClient : true
//         * bOutEmail : true
//         * bEnableRecord : true
//         * bAlarmSoundEnable : true
//         * WhiteLight : {"bEnable":false,"Strength":0}
//         */
//
//        private boolean bEnable;
//        private int nSen;
//        private int nThreshold;
//        private int nStayTime;
//        private boolean bDrawFrame;
//        private boolean bFlushFrame;
//        private boolean bMarkObject;
//        private boolean bMarkAll;
//        private int maxRectW;
//        private int maxRectH;
//        private int maxRegion;
//        private TaskBean task;
//        private boolean bOutClient;
//        private boolean bOutEmail;
//        private boolean bEnableRecord;
//        private boolean bAlarmSoundEnable;
//        private WhiteLightBean WhiteLight;
//        private int channelid;
//
//    public int getChannelid() {
//        return channelid;
//    }
//
//    public void setChannelid(int channelid) {
//        this.channelid = channelid;
//    }
//
//    public boolean isBEnable() {
//            return bEnable;
//        }
//
//        public void setBEnable(boolean bEnable) {
//            this.bEnable = bEnable;
//        }
//
//        public int getNSen() {
//            return nSen;
//        }
//
//        public void setNSen(int nSen) {
//            this.nSen = nSen;
//        }
//
//        public int getNThreshold() {
//            return nThreshold;
//        }
//
//        public void setNThreshold(int nThreshold) {
//            this.nThreshold = nThreshold;
//        }
//
//        public int getNStayTime() {
//            return nStayTime;
//        }
//
//        public void setNStayTime(int nStayTime) {
//            this.nStayTime = nStayTime;
//        }
//
//        public boolean isBDrawFrame() {
//            return bDrawFrame;
//        }
//
//        public void setBDrawFrame(boolean bDrawFrame) {
//            this.bDrawFrame = bDrawFrame;
//        }
//
//        public boolean isBFlushFrame() {
//            return bFlushFrame;
//        }
//
//        public void setBFlushFrame(boolean bFlushFrame) {
//            this.bFlushFrame = bFlushFrame;
//        }
//
//        public boolean isBMarkObject() {
//            return bMarkObject;
//        }
//
//        public void setBMarkObject(boolean bMarkObject) {
//            this.bMarkObject = bMarkObject;
//        }
//
//        public boolean isBMarkAll() {
//            return bMarkAll;
//        }
//
//        public void setBMarkAll(boolean bMarkAll) {
//            this.bMarkAll = bMarkAll;
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
//        public int getMaxRegion() {
//            return maxRegion;
//        }
//
//        public void setMaxRegion(int maxRegion) {
//            this.maxRegion = maxRegion;
//        }
//
//        public TaskBean getTask() {
//            return task;
//        }
//
//        public void setTask(TaskBean task) {
//            this.task = task;
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
//        public boolean isBEnableRecord() {
//            return bEnableRecord;
//        }
//
//        public void setBEnableRecord(boolean bEnableRecord) {
//            this.bEnableRecord = bEnableRecord;
//        }
//
//        public boolean isBAlarmSoundEnable() {
//            return bAlarmSoundEnable;
//        }
//
//        public void setBAlarmSoundEnable(boolean bAlarmSoundEnable) {
//            this.bAlarmSoundEnable = bAlarmSoundEnable;
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
//        public static class TaskBean {
//            /**
//             * bsos : false
//             * bAllTime : false
//             * maxTime : 1
//             */
//
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
//        }
//
//        public static class WhiteLightBean {
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
//    }

