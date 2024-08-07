package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;


//0表示中维，1表示onvif 搜索标识用来兼容1.0NVR
public class OnvifGetDiscoveryInfo implements Serializable {


//    {
//        "method": "netservice_onvif_get_discoveryinfo",
//            "level":"Operator",
//            "param": {},
//        "result": {
//        "discoveryflag": 0  //0表示中维，1表示onvif 搜索标识用来兼容1.0NVR
//    },
//        "error":{
//        "errorcode":0,
//                "message":"Invalid Params"
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
    }

    public static class ResultBean {
        private boolean bdefault;
        private int discoveryflag;

        public int getDiscoveryflag() {
            return discoveryflag;
        }

        public void setDiscoveryflag(int discoveryflag) {
            this.discoveryflag = discoveryflag;
        }

        public boolean isBdefault() {
            return bdefault;
        }

        public void setBdefault(boolean bdefault) {
            this.bdefault = bdefault;
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
