package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

//报警联动获取
public class OctAlarmLinkGetBean {


    //    {	//报警联动获取
//        "method": "alarm_link_get",
//            "level":"Operator",
//            "param": {
//        "link_id":1,
//                "bdefault":false				// 是否获取默认参数
//    },
//        "result": {
//        "enable": false,		// 是否开启
//                "client_en": true,		//是否发生到客户端
//                "email_en": false,			//发送邮件
//                "osd_flicker": false,			// OSD闪烁
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
//                "alarmout":[0,1]			//关联的开关量报警输出：一个报警输入可关联多路报警输出,
//    },
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
        private boolean bdefault;

        public int getLink_id() {
            return link_id;
        }

        public void setLink_id(int link_id) {
            this.link_id = link_id;
        }

        public boolean isBdefault() {
            return bdefault;
        }

        public void setBdefault(boolean bdefault) {
            this.bdefault = bdefault;
        }
    }

    public static class ResultBean implements Serializable {
        private int channelid;
        private int link_id;
        private boolean enable;
        private boolean client_en;
        private boolean email_en;
        private boolean ftp_en;
        private boolean http_en;
        private boolean osd_flicker;
        private SnapBean snap;
        private boolean record_enable;
        private int duration;
        private WhiteLightBean white_light;
        private RgbLightBean rgb_light;
        private AlarmsoundBean alarmsound;
        private int preset_id;
        private List<Integer> alarmout;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }

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

        public boolean isFtp_en() {
            return ftp_en;
        }

        public void setFtp_en(boolean ftp_en) {
            this.ftp_en = ftp_en;
        }

        public boolean isHttp_en() {
            return http_en;
        }

        public void setHttp_en(boolean http_en) {
            this.http_en = http_en;
        }

        public boolean isOsd_flicker() {
            return osd_flicker;
        }

        public void setOsd_flicker(boolean osd_flicker) {
            this.osd_flicker = osd_flicker;
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

        public WhiteLightBean getWhite_light() {
            return white_light;
        }

        public void setWhite_light(WhiteLightBean white_light) {
            this.white_light = white_light;
        }

        public RgbLightBean getRgb_light() {
            return rgb_light;
        }

        public void setRgb_light(RgbLightBean rgb_light) {
            this.rgb_light = rgb_light;
        }

        public AlarmsoundBean getAlarmsound() {
            return alarmsound;
        }

        public void setAlarmsound(AlarmsoundBean alarmsound) {
            this.alarmsound = alarmsound;
        }

        public int getPreset_id() {
            return preset_id;
        }

        public void setPreset_id(int preset_id) {
            this.preset_id = preset_id;
        }

        public List<Integer> getAlarmout() {
            return alarmout;
        }

        public void setAlarmout(List<Integer> alarmout) {
            this.alarmout = alarmout;
        }

        public static class SnapBean implements Serializable {
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

        public static class WhiteLightBean implements Serializable {
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

        public static class RgbLightBean implements Serializable {
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

        public static class AlarmsoundBean implements Serializable {
            private boolean enable;
            private String sound_name;
            private String play_mode; // loop循环播放，frequence次数播放
            private int play_count;// 次数播放时配置的次数

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public String getSound_name() {
                return sound_name;
            }

            public void setSound_name(String sound_name) {
                this.sound_name = sound_name;
            }

            public String getPlay_mode() {
                return play_mode;
            }

            public void setPlay_mode(String play_mode) {
                this.play_mode = play_mode;
            }

            public int getPlay_count() {
                return play_count;
            }

            public void setPlay_count(int play_count) {
                this.play_count = play_count;
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
