package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

//获取校时服务器
public class OctDevNtpBean {

    //    {	//获取校时服务器
//        "method": "dev_ntp_get",
//                "param": {},
//        "result": {
//            "bEnableNtp": true,
//                    "sntpInterval": 24,
//                    "servers": [
//            "ntp.fudan.edu.cn"
//            ]
//        },
//        "error": {
//                "errorcode": -32602,
//                "message": "Invalid Params"
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
    }

    public static class ResultBean {
        private boolean bEnableNtp;
        private int sntpInterval;
        private List<String> servers;

        public boolean isBEnableNtp() {
            return bEnableNtp;
        }

        public void setBEnableNtp(boolean bEnableNtp) {
            this.bEnableNtp = bEnableNtp;
        }

        public int getSntpInterval() {
            return sntpInterval;
        }

        public void setSntpInterval(int sntpInterval) {
            this.sntpInterval = sntpInterval;
        }

        public List<String> getServers() {
            return servers;
        }

        public void setServers(List<String> servers) {
            this.servers = servers;
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
