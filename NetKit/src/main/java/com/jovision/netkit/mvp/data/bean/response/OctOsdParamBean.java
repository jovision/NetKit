package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;

//获取osd参数
public class OctOsdParamBean {
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
        private boolean bShowOSD;
        private String timeFormat;
        private String position;
        private String timePos;
        private String channelName;
        private boolean bOsdInvColEn;
        private boolean bLargeOSD;
        private boolean bEnableAlarmFlicker;

        public boolean isBShowOSD() {
            return bShowOSD;
        }

        public void setBShowOSD(boolean bShowOSD) {
            this.bShowOSD = bShowOSD;
        }

        public String getTimeFormat() {
            return timeFormat;
        }

        public void setTimeFormat(String timeFormat) {
            this.timeFormat = timeFormat;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getTimePos() {
            return timePos;
        }

        public void setTimePos(String timePos) {
            this.timePos = timePos;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public boolean isBOsdInvColEn() {
            return bOsdInvColEn;
        }

        public void setBOsdInvColEn(boolean bOsdInvColEn) {
            this.bOsdInvColEn = bOsdInvColEn;
        }

        public boolean isBLargeOSD() {
            return bLargeOSD;
        }

        public void setBLargeOSD(boolean bLargeOSD) {
            this.bLargeOSD = bLargeOSD;
        }

        public boolean isBEnableAlarmFlicker() {
            return bEnableAlarmFlicker;
        }

        public void setBEnableAlarmFlicker(boolean bEnableAlarmFlicker) {
            this.bEnableAlarmFlicker = bEnableAlarmFlicker;
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

//    {	//获取osd参数
//        "method": "chnosd_get_param",
//            "param": {
//        "channelid": 0
//    },
//        "result": {
//        "bShowOSD": true,
//                "timeFormat": "YYYY-MM-DD hh:mm:ss,MM/DD/YYYY hh:mm:ss,DD/MM/YYYY hh:mm:ss",
//                "position": "left_top,left_bottom,right_top,right_bottom,hide",
//                "timePos": "left_top,left_bottom,right_top,right_bottom,hide",
//                "channelName": "HD IPC",
//                "bOsdInvColEn": false,
//                "bLargeOSD": false,
//                "bEnableAlarmFlicker": false
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "Failed to get OSD parameters!"
//    }
//    }
//



}
