package com.jovision.netkit.mvp.data.bean;


//用于通过云视通和公有云协议进行的参数配置
//后续智能应用功能配置，采用透传接口 dev_trans_userparam
//owner 参数固定为 Jovision
//req_data 参数为具体功能协议数据，json格式字符串，格式为： {"package":"mrs","method":"set_param","param":{"param1":"1","param2":2}}
public class DevTransUserParam {

//    {	//透传数据
//        "method": "dev_trans_userparam",
//            "level":"Operator",
//            "param": {
//        "channelid":0,			//从0开始。-1表示本机
//                "owner":"SenseTime,Jovision",	//区分不同厂家,SenseTime商汤,Jovision中维
//                "req_data":""
//    },
//        "result": {
//        "owner":"SenseTime,Jovision",	//区分不同厂家,SenseTime商汤,Jovision中维
//                "resp_data":""
//    },
//        "error": {
//        "errorcode": -33002,
//                "message":""
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
        private int channelid;
        private String owner;
        private String req_data;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getReq_data() {
            return req_data;
        }

        public void setReq_data(String req_data) {
            this.req_data = req_data;
        }
    }

    public static class ResultBean {
        private String owner;
        private String resp_data;

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getResp_data() {
            return resp_data;
        }

        public void setResp_data(String resp_data) {
            this.resp_data = resp_data;
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
