package com.jovision.netkit.mvp.data.bean.response;


public class AlarmLinkIdBean {

//    {	// 手动触发报警
//        "method": "alarm_get_link_id",
//            "level":"Operator",
//            "param": {
//        "channelid": 0, // 通道号
//                "module": "AdDriveAway" // 模块：AdDriveAway 一键驱离
//    },
//        "result": {
//        "link_id": 1 // 联动id
//    },
//        "error": {
//        "errorcode": 0
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
        private boolean bdefault;// 是否获取默认参数

        public boolean isBdefault() {
            return bdefault;
        }

        public void setBdefault(boolean bdefault) {
            this.bdefault = bdefault;
        }
    }

    public static class ResultBean {
        private int link_id;

        public int getLink_id() {
            return link_id;
        }

        public void setLink_id(int link_id) {
            this.link_id = link_id;
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
