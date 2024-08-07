package com.jovision.netkit.mvp.data.bean;

import com.google.gson.annotations.SerializedName;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmTask;

import java.io.Serializable;
import java.util.List;

//虚焦检测的参数
public class OctIvpVfBean implements Serializable {

    //    {//获取虚焦检测的参数
//        "method": "ivp_vf_get_param",
//            "level":"Operator",
//            "param": {
//        "channelid": 0
//    },
//        "result": {
//        "bEnable": false,			//是否启用
//                "alarm_link_id":1,			//报警联动计划id
//                "alarm_defence_plan_id":1,	//布防时间计划id
//                "nSen": 0,					//灵敏度0~100
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


    private String method;
    private String level;
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

    public static class ParamBean implements Serializable{
        private int channelid;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }
    }

    public static class ResultBean implements Serializable{
        private int channelid;
        private boolean bEnable;
        private int alarm_link_id;
        private int alarm_defence_plan_id;
        private int nSen;
        private OctAlarmTask task;
        private boolean bOutClient;
        private boolean bOutEmail;
        private boolean bEnableRecord;
        private boolean bAlarmSoundEnable;
        @SerializedName("WhiteLight")
        private WhiteLightBean whiteLight;
        @SerializedName("AlarmLight")
        private AlarmLightBean alarmLight;
        private List<AlarmoutBean> alarmout;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }


        public boolean isBEnable() {
            return bEnable;
        }

        public void setBEnable(boolean bEnable) {
            this.bEnable = bEnable;
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

        public int getNSen() {
            return nSen;
        }

        public void setNSen(int nSen) {
            this.nSen = nSen;
        }

        public OctAlarmTask getTask() {
            return task;
        }

        public void setTask(OctAlarmTask task) {
            this.task = task;
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

        public boolean isBEnableRecord() {
            return bEnableRecord;
        }

        public void setBEnableRecord(boolean bEnableRecord) {
            this.bEnableRecord = bEnableRecord;
        }

        public boolean isBAlarmSoundEnable() {
            return bAlarmSoundEnable;
        }

        public void setBAlarmSoundEnable(boolean bAlarmSoundEnable) {
            this.bAlarmSoundEnable = bAlarmSoundEnable;
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

//        public static class TaskBean implements Serializable{
//            private boolean bsos;
//            private boolean bAllTime;
//            private int maxTime;
//            private List<TimeBean> time;
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
//            public List<TimeBean> getTime() {
//                return time;
//            }
//
//            public void setTime(List<TimeBean> time) {
//                this.time = time;
//            }
//
//            public static class TimeBean implements Serializable{
//                private String week;
//                private int begin_hour;
//                private int begin_min;
//                private int begin_sec;
//                private int end_hour;
//                private int end_min;
//                private int end_sec;
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
//                public int getBegin_sec() {
//                    return begin_sec;
//                }
//
//                public void setBegin_sec(int begin_sec) {
//                    this.begin_sec = begin_sec;
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
//
//                public int getEnd_sec() {
//                    return end_sec;
//                }
//
//                public void setEnd_sec(int end_sec) {
//                    this.end_sec = end_sec;
//                }
//            }
//        }

        public static class WhiteLightBean implements Serializable{
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

        public static class AlarmLightBean implements Serializable{
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

        public static class AlarmoutBean implements Serializable{
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
    }

    public static class ErrorBean implements Serializable{
        private int errorcode;

        public int getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(int errorcode) {
            this.errorcode = errorcode;
        }
    }







}
