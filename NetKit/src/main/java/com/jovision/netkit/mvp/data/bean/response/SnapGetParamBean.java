package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

//抓拍功能获取参数
public class SnapGetParamBean {


//    {	//抓拍功能获取参数
//        "method": "snap_get_param",
//            "level":"Operator",
//            "param": {
//        "channelid": 0  		// 通道
//    },
//        "result": {
//        "resolutions": [	//分辨率列表
//        {
//            "width": 1280,		//宽
//                "height": 720		//高
//        }
//            ],
//        "width": 1280,
//                "height": 720,
//                "quality": "high,middle,low"   //图片质量高 中 低
//    },
//        "error": {
//        "errorcode": 0
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

    public static class ParamBean implements Serializable {

        private int channelid;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }

    }

    public static class ResultBean implements Serializable {

        private int channelid;
        private List<ResolutionBean> snap_task;
        private int width;
        private int height;
        private String quality;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }

        public List<ResolutionBean> getSnap_task() {
            return snap_task;
        }

        public void setSnap_task(List<ResolutionBean> snap_task) {
            this.snap_task = snap_task;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public static class ResolutionBean implements Serializable {

            private int width;
            private int height;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }

    }

    public static class ErrorBean implements Serializable {

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
