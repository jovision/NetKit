package com.jovision.netkit.mvp.data.bean.response;

// 获取标定状态
public class GtrackGetCalibrationBean {


    //    {	// 获取标定状态
//        "method": "gtrack_get_calibration",
//            "level":"Operator",
//            "param": {
//        "channelid":-1		// 通道号
//    },
//        "result": {
//        "status": "uncalibrated, calibrated, calibrating",  // 标定状态 uncalibrated 未标定, calibrated 已标定，calibrating 标定中
//                "progress": 100                         // 自动标定中的进度状态 0 - 100
//    },
//                "error":{
//        "errorcode":0,
//                "message":"Invalid Params"
//        }
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

    public static class ResultBean {
        private String status;// 标定状态 uncalibrated 未标定, calibrated 已标定，calibrating 标定中
        private int progress;// 自动标定中的进度状态 0 - 100

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
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
