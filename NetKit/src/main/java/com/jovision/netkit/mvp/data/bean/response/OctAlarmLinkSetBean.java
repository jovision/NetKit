package com.jovision.netkit.mvp.data.bean.response;

//报警联动配置
public class OctAlarmLinkSetBean {

    //    {	//报警联动配置
//        "method": "alarm_link_set",
//            "level":"Operator",
//            "param": {
//        "link_id":1,
//                "enable": false,		// 是否开启
//                "client_en": true,		//是否发生到客户端
//                "email_en": false,			//发送邮件
//                "snap":{
//            "enable":false,
//                    "interval":10,			//抓拍间隔，单位秒，0表示无间隔连续抓拍
//                    "count":10				//抓拍张数
//        },
//        "record_enable": false,		// 开启录像
//                "duration":10,				//持续时间，单位秒
//                "white_light":{				//白光灯设置
//            "enable":false,   		//闪烁使能
//                    "strength":0     		//闪烁强度1弱，2中，3强
//        },
//        "rgb_light":{				//报警灯设置
//            "enable":false,   		//闪烁使能
//                    "strength":0     		//闪烁强度1弱，2中，3强
//        },
//        "alarmsound":{				//报警声音
//            "enable":false,			//报警声音使能
//                    "sound_name":"default"	//报警声音名字
//        },
//        "preset_id": 1,				//联动预置位
//                "alarmout":[0,1]			//关联的开关量报警输出：一个报警输入可关联多路报警输出
//    },
//        "result": {},
//        "error": {
//        "errorcode": 0,
//        "message": "Invalid Params"
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

    public static class ParamBean {
        private int link_id;
        private boolean enable;
        private boolean client_en;
        private boolean email_en;
        private SnapBean snap;
        private boolean record_enable;
        private int duration;

        public int getLink_id() {
            return link_id;
        }

        public void setLink_id(int link_id) {
            this.link_id = link_id;
        }

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public boolean isClient_en() {
            return client_en;
        }

        public void setClient_en(boolean client_en) {
            this.client_en = client_en;
        }

        public boolean isEmail_en() {
            return email_en;
        }

        public void setEmail_en(boolean email_en) {
            this.email_en = email_en;
        }

        public SnapBean getSnap() {
            return snap;
        }

        public void setSnap(SnapBean snap) {
            this.snap = snap;
        }

        public boolean isRecord_enable() {
            return record_enable;
        }

        public void setRecord_enable(boolean record_enable) {
            this.record_enable = record_enable;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public static class SnapBean {
            private boolean enable;
            private int interval;
            private int count;

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public int getInterval() {
                return interval;
            }

            public void setInterval(int interval) {
                this.interval = interval;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }

        public static class WhiteLightBean {
            private boolean enable;
            private int strength;

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public int getStrength() {
                return strength;
            }

            public void setStrength(int strength) {
                this.strength = strength;
            }
        }

        public static class RgbLightBean {
            private boolean enable;
            private int strength;

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public int getStrength() {
                return strength;
            }

            public void setStrength(int strength) {
                this.strength = strength;
            }
        }

        public static class AlarmsoundBean {
        }
    }

    public static class ResultBean {
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
