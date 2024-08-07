package com.jovision.netkit.mvp.data.bean.response;

public class GtrackManualPositionBean {

//    {	// 手动定位
//        "method": "gtrack_manual_position",
//            "level":"Operator",
//            "param": {
//        "channelid":-1,		// 通道号
//                "position": {		//(x, y, w, h) 圈定区域中心坐标及宽高,坐标范围 0-65535
//            "x": 0,
//                    "y": 0,
//                    "w": 0,
//                    "h": 0
//        }
//    },
//        "result": {},
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
        private int channelid;
        private PositionBean position;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }

        public PositionBean getPosition() {
            return position;
        }

        public void setPosition(PositionBean position) {
            this.position = position;
        }

        public static class PositionBean {
            private int x;
            private int y;
            private int w;
            private int h;

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }

            public int getW() {
                return w;
            }

            public void setW(int w) {
                this.w = w;
            }

            public int getH() {
                return h;
            }

            public void setH(int h) {
                this.h = h;
            }
        }
    }

    public static class ResultBean {
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
