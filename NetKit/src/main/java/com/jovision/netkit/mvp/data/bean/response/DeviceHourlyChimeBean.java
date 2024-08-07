package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

//获取整点报时参数
public class DeviceHourlyChimeBean implements Serializable {


//    {	//获取整点报时参数
//        "method": "hourly_chime_get_param",
//            "level":"Operator",
//            "param": {
//        "channelid": 0,			//通道号，从0开始。
//                "bDefault": false		//是否获取默认参数传
//    },
//        "result": {
//        "bEnable": true,
//                "reportMode": "DAYMODE,NIGHTMODE,CUSTOMMODE",	//报时模式，白天模式:DAYMODE 夜晚模式:NIGHTMODE 自定义:CUSTOMMODE
//                "week":["Mon,Tues,Wed,Thur,Fri,Sat,Sun"],        //星期1~7
//        "plan_times":
//        {
//            "begin_hour": 12,		//开始小时0~23
//                "end_hour": 12			//结束小时0~23
//        }
//    },
//        "error": {
//        "errorcode": 0
//    }
//    }

//{	//设置整点报时参数
//    "method": "hourly_chime_set_param",
//        "level":"Operator",
//        "param": {
//    "channelid": 0,			//通道号，从0开始。
//            "bEnable": true,
//            "reportMode": "DAYMODE,NIGHTMODE,CUSTOMMODE",	//报时模式，白天模式:DAYMODE 夜晚模式:NIGHTMODE 自定义:CUSTOMMODE
//            "week":["Mon,Tues,Wed,Thur,Fri,Sat,Sun"],        //星期1~7
//    "plan_times":
//    {
//        "begin_hour": 12,		//开始小时0~23
//            "end_hour": 12			//结束小时0~23
//    }
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
        private boolean bDefault;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }

        public boolean isbDefault() {
            return bDefault;
        }

        public void setbDefault(boolean bDefault) {
            this.bDefault = bDefault;
        }
    }

    public static class ResultBean implements Serializable {
        private int channelid;
        private boolean bEnable;
        private String reportMode;
        private List<String> week;
        private TimeItemBean plan_times;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }

        public boolean isbEnable() {
            return bEnable;
        }

        public void setbEnable(boolean bEnable) {
            this.bEnable = bEnable;
        }

        public String getReportMode() {
            return reportMode;
        }

        public void setReportMode(String reportMode) {
            this.reportMode = reportMode;
        }

        public List<String> getWeek() {
            return week;
        }

        public void setWeek(List<String> week) {
            this.week = week;
        }

        public TimeItemBean getPlan_times() {
            return plan_times;
        }

        public void setPlan_times(TimeItemBean plan_times) {
            this.plan_times = plan_times;
        }
    }

    public static class TimeItemBean implements Serializable {
        private int begin_hour;
        private int end_hour;

        public int getBegin_hour() {
            return begin_hour;
        }

        public void setBegin_hour(int begin_hour) {
            this.begin_hour = begin_hour;
        }

        public int getEnd_hour() {
            return end_hour;
        }

        public void setEnd_hour(int end_hour) {
            this.end_hour = end_hour;
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
