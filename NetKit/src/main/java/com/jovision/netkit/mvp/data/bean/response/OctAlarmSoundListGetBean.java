package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;
//报警声音列表获取，新设备，支持多个报警音的设备
public class OctAlarmSoundListGetBean {


//    //报警声音获取
//		"method": "alarm_soundlist_get",
//                "level":"Operator",
//                "param": {
//        "channelid":0			//通道号，从0开始，-1表示本机
//    },
//            "result": {
//        "max_modify_cnt": 3,			// 当前设备支持可配置声音列表数量
//                "alarm_sound":[
//        {
//            "file_name": "alarmsound1",			//文件名称，不允许重复
//                "file_type": "pcm",					//编码格式，目前只支持pcm格式
//                "file_size": 50240,					//文件大小
//                "bModify": true						//是否可删除（true:可以删除；false:不可删除）
//        }
//			]
//    },
//            "error": {
//        "errorcode": 0,
//        "message": "Invalid Params"
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
        private int channelid;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }
    }

    public static class ResultBean implements Serializable {
        private int max_modify_cnt;
        private List<AlarmSoundBean> alarm_sound;

        public int getMax_modify_cnt() {
            return max_modify_cnt;
        }

        public void setMax_modify_cnt(int max_modify_cnt) {
            this.max_modify_cnt = max_modify_cnt;
        }

        public List<AlarmSoundBean> getAlarm_sound() {
            return alarm_sound;
        }

        public void setAlarm_sound(List<AlarmSoundBean> alarm_sound) {
            this.alarm_sound = alarm_sound;
        }

        public static class AlarmSoundBean implements Serializable {

            private String file_name;//英文名称，发命令使用
            private String file_intro;//中文名称，展示使用


            private String file_type;
            private int file_size;
            private boolean bModify;

            public String getFile_name() {
                return file_name;
            }

            public void setFile_name(String file_name) {
                this.file_name = file_name;
            }

            public String getFile_type() {
                return file_type;
            }

            public void setFile_type(String file_type) {
                this.file_type = file_type;
            }

            public int getFile_size() {
                return file_size;
            }

            public void setFile_size(int file_size) {
                this.file_size = file_size;
            }

            public boolean isBModify() {
                return bModify;
            }

            public void setBModify(boolean bModify) {
                this.bModify = bModify;
            }

            public String getFile_intro() {
                return file_intro;
            }

            public void setFile_intro(String file_intro) {
                this.file_intro = file_intro;
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
