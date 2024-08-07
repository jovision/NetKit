package com.jovision.netkit.mvp.data.bean.response;

//获取守望配置
public class OctPtzGuardGetBean {
    private ResultBean result;
    private ErrorBean error;

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

    public static class ResultBean {
        private int preset;
        private int stayseconds;
        private boolean bstart;

        public int getPreset() {
            return preset;
        }

        public void setPreset(int preset) {
            this.preset = preset;
        }

        public int getStayseconds() {
            return stayseconds;
        }

        public void setStayseconds(int stayseconds) {
            this.stayseconds = stayseconds;
        }

        public boolean isBstart() {
            return bstart;
        }

        public void setBstart(boolean bstart) {
            this.bstart = bstart;
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


//    {	//获取守望配置
//        "method": "ptz_guard_get",
//            "param": {
//        "channelid": 0
//    },
//        "result": {
//        "preset": 0, //预置点
//                "stayseconds": 5, //停留时间，单位秒
//                "bstart": false //是否已启动
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "No exist!"
//    }
//    }
}
