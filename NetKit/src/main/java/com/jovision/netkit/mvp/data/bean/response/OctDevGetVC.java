package com.jovision.netkit.mvp.data.bean.response;

//获取设备的VC值
public class OctDevGetVC {

//    {
//        "method": "dev_get_verification_code",
//            "level":"Operator",
//            "comments": "获取验证码",
//            "param": {},
//        "result": {
//        "verification_code": "123456789"
//    },
//        "error": {
//        "errorcode": 0
//    }
//    }

    private String method;
    private String level;
    private String comments;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
        private String verification_code;

        public String getVerification_code() {
            return verification_code;
        }

        public void setVerification_code(String verification_code) {
            this.verification_code = verification_code;
        }
    }

    public static class ErrorBean {
        private int errorcode;

        public int getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(int errorcode) {
            this.errorcode = errorcode;
        }
    }





}
