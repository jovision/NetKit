package com.jovision.netkit.mvp.data.bean.response;


//挥手呼叫新增参数获取和设置接口
public class IntelligenceWaveHandCallParam {
//    {	//挥手呼叫参数获取
//        "method": "intelligence_wavehand_call_get_param",
//            "level":"Operator",
//            "param": {
//        "bdefault":false	// 是否获取默认参数
//    },
//        "result": {
//        "enable": false		//算法开关
//    },
//        "error": {
//        "errorcode": 0
//    }
//    }


//    {	//挥手呼叫参数配置
//        "method": "intelligence_wavehand_call_set_param",
//            "level":"Operator",
//            "param": {
//        "enable": false		//算法开关
//    },
//        "result": {},
//        "error": {
//        "errorcode": 0
//    }
//    }


    private String method;
    private String level;
    private ParamBean param;
    private ResultBean result;//算法开关
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
        private boolean bdefault;// 是否获取默认参数

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

        public int getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(int errorcode) {
            this.errorcode = errorcode;
        }
    }

}
