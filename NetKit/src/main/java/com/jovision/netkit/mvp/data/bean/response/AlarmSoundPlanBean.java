package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

//获取报警音计划配置
public class AlarmSoundPlanBean implements Serializable {


//    {	//获取报警音计划配置
//        "method": "alarm_sound_plan_get",
//            "level":"Operator",
//            "param": {
//        "channelid": 0,			//通道号，从0开始。
//                "bDefault": false		//是否获取默认参数传
//    },
//        "result": {
//        "enable": true,
//                "mode": "EVERYDAY,WORKDAY,RESTDAY,CUSTOMMODE",	//定时静音模式，每天:EVERYDAY 工作日:WORKDAY 休息日:RESTDAY 自定义:CUSTOMMODE
//                "plan_day":["Mon,Tues,Wed,Thur,Fri,Sat,Sun"],        //星期1~7，仅自定义模式有效
//        "plan_time":
//        {
//            "begin_hour": 12,		//开始小时
//            "begin_min": 12,		//开始分钟
//                "end_hour": 12			//结束小时
//                "end_min": 12			//结束分钟
//        }
//    },
//        "error": {
//        "errorcode": 0
//    }
//    }

//{	//设置报警音计划配置
//    "method": "alarm_sound_plan_set",
//        "level":"Operator",
//        "param": {
//    "channelid": 0,			//通道号，从0开始。
//            "enable": true,
//            "mode": "EVERYDAY,WORKDAY,RESTDAY,CUSTOMMODE",	//定时静音模式，每天:EVERYDAY 工作日:WORKDAY 休息日:RESTDAY 自定义:CUSTOMMODE
//            "plan_day":["Mon,Tues,Wed,Thur,Fri,Sat,Sun"],        //星期1~7，仅自定义模式有效
//    "plan_time":
//        {
//            "begin_hour": 12,		//开始小时
//            "begin_min": 12,		//开始分钟
//                "end_hour": 12			//结束小时
//                "end_min": 12			//结束分钟
//        }
//},
//    "result": {},
//    "error": {
//    "errorcode": 0
//}
//}
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
        private int channelid;
        private boolean bdefault;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }

        public boolean isbDefault() {
            return bdefault;
        }

        public void setbDefault(boolean bDefault) {
            this.bdefault = bDefault;
        }
    }

    public static class ResultBean implements Serializable {
        private int channelid;
        private boolean enable;
        private String mode;
        private List<String> plan_day;
        private TimeItemBean plan_time;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }

        public List<String> getPlan_day() {
            return plan_day;
        }

        public void setPlan_day(List<String> plan_day) {
            this.plan_day = plan_day;
        }

        public TimeItemBean getPlan_time() {
            return plan_time;
        }

        public void setPlan_time(TimeItemBean plan_time) {
            this.plan_time = plan_time;
        }
    }

    public static class TimeItemBean implements Serializable {
        private int begin_hour;
        private int begin_min;
        private int end_hour;
        private int end_min;

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
    }

    public static class ErrorBean implements Serializable {
        private int errorcode;

        public int getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(int errorcode) {
            this.errorcode = errorcode;
        }
    }

}
