package com.jovision.netkit.mvp.data.bean.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//获取日夜切换配置
public class OctImageDncutParamBean {

//    {	//获取日夜切换配置
//        "method": "image_get_dncut_param",
//            "param": {
//        "channelid":0			//通道号，从0开始。
//    },
//        "result": {
//        "daynightMode": "auto,alwaysDay,alwaysNight,timer",
//                "light": 4,  		//光照强度(对应界面上的日夜切换时刻)，范围：0~10，默认值4，自动模式时有效。
//                "antishaketime": 0, //切换防抖时间（0~120，单位秒），自动模式时有效。
//                "dayStart": {		//定时模式时有效
//            "hour": 0,
//                    "minute": 0
//        },
//        "dayEnd": {			//定时模式时有效
//            "hour": 0,
//                    "minute": 0
//        },
//        "LightMode": "AutoIR,AutoWhite,AlwaysClose",	//自动红外模式，自动白光模式，常闭模式
//                "bLightLinked": false,        //是否当前有报警启动并配置了联动灯光闪烁
//                "valueOfWL": 128		//白光灯亮度
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "Failed to get image day night cut parameters!"
//    }
//    }


    private String method;
    private ParamBean param;
    private ResultBean result;
    private ErrorBean error;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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

    public static class ParamBean {
        private int channelid;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }
    }

    public static class ResultBean implements Serializable {
        private int channelid;
        private String daynightMode;
        private int light;
        private int antishaketime;
        private DayStartBean dayStart;
        private DayEndBean dayEnd;
        @SerializedName("LightMode")
        private String lightMode;
        private boolean bLightLinked;
        private int valueOfWL;

        public String getDaynightMode() {
            return daynightMode;
        }

        public void setDaynightMode(String daynightMode) {
            this.daynightMode = daynightMode;
        }

        public int getLight() {
            return light;
        }

        public void setLight(int light) {
            this.light = light;
        }

        public int getAntishaketime() {
            return antishaketime;
        }

        public void setAntishaketime(int antishaketime) {
            this.antishaketime = antishaketime;
        }

        public DayStartBean getDayStart() {
            return dayStart;
        }

        public void setDayStart(DayStartBean dayStart) {
            this.dayStart = dayStart;
        }

        public DayEndBean getDayEnd() {
            return dayEnd;
        }

        public void setDayEnd(DayEndBean dayEnd) {
            this.dayEnd = dayEnd;
        }

        public String getLightMode() {
            return lightMode;
        }

        public void setLightMode(String lightMode) {
            this.lightMode = lightMode;
        }

        public boolean isBLightLinked() {
            return bLightLinked;
        }

        public void setBLightLinked(boolean bLightLinked) {
            this.bLightLinked = bLightLinked;
        }

        public int getValueOfWL() {
            return valueOfWL;
        }

        public void setValueOfWL(int valueOfWL) {
            this.valueOfWL = valueOfWL;
        }

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }

        public static class DayStartBean implements Serializable{
            private int hour;
            private int minute;

            public int getHour() {
                return hour;
            }

            public void setHour(int hour) {
                this.hour = hour;
            }

            public int getMinute() {
                return minute;
            }

            public void setMinute(int minute) {
                this.minute = minute;
            }
        }

        public static class DayEndBean {
            private int hour;
            private int minute;

            public int getHour() {
                return hour;
            }

            public void setHour(int hour) {
                this.hour = hour;
            }

            public int getMinute() {
                return minute;
            }

            public void setMinute(int minute) {
                this.minute = minute;
            }
        }
    }

    public static class ErrorBean {
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



}
