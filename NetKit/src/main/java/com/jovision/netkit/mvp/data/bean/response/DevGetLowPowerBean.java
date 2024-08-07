package com.jovision.netkit.mvp.data.bean.response;

//低功耗模式对象
public class DevGetLowPowerBean {


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
        private boolean bdefault;

        public boolean isBdefault() {
            return bdefault;
        }

        public void setBdefault(boolean bdefault) {
            this.bdefault = bdefault;
        }
    }

    public static class ResultBean {
        private boolean enable;

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
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

    //    {	//获取低功耗模式
//        "method": "dev_get_low_power",
//            "level":"Operator",
//            "param": {
//        "bdefault":false	// 是否获取默认参数
//    },
//        "result": {
//        "enable": false		//功能开关
//    },
//        "error": {
//        "errorcode": 0
//                "message": "Failed to get image expertsetting parameters!"
//    }
//    }


    //    {	//设置低功耗模式
//        "method": "dev_set_low_power",
//            "level":"Operator",
//            "param": {
//        "enable": false		//功能开关
//    },
//        "result": {},
//        "error": {
//        "errorcode": 0
//                "message": "Failed to get image expertsetting parameters!"
//    }
//    }









}
