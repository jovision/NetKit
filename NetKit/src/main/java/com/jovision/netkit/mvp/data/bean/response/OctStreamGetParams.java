package com.jovision.netkit.mvp.data.bean.response;


import java.util.List;

//获取某个或所有通道的所有码流参数
public class OctStreamGetParams {


    //    { //获取某个或所有通道的所有码流参数
//        "method": "stream_get_params",
//            "level":"Operator",
//            "param": {
//        "channelid": 0 //-1: 所有通道 >=0 :某个通道
//    },
//        "result": {
//        "streams": [
//        {
//            "channelid": 0,
//                "streamid": 0,
//                "venctype": "h264,h265",
//                "width": 1280,
//                "height": 720,
//                "frameRate": 25,
//                "bitRate": 1024,
//                "gop": 50, //I帧间隔,以帧为单位10~400
//                "quality": 50,
//                "smooth": 50, //码流平滑1~100
//                "rcMode": "cbr,vbr,fixQP",cbr固定码率，vbr可变码率，fixQP这个没有
//                "smartencode": "open,close,autoopen",
//                "encryptEn": false
//        }
//            ]
//    },
//        "error": {
//        "errorcode": -32602,
//                "message": "Invalid Params"
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

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }
    }

    public static class ResultBean {
        private List<StreamsBean> streams;

        public List<StreamsBean> getStreams() {
            return streams;
        }

        public void setStreams(List<StreamsBean> streams) {
            this.streams = streams;
        }

        public static class StreamsBean {
            private int channelid;
            private int streamid;
            private String venctype;
            private int width;
            private int height;
            private int frameRate;
            private int bitRate;
            private int gop;
            private int quality;
            private int smooth;
            private String rcMode;
            private String smartencode;
            private boolean encryptEn;

            public int getChannelid() {
                return channelid;
            }

            public void setChannelid(int channelid) {
                this.channelid = channelid;
            }

            public int getStreamid() {
                return streamid;
            }

            public void setStreamid(int streamid) {
                this.streamid = streamid;
            }

            public String getVenctype() {
                return venctype;
            }

            public void setVenctype(String venctype) {
                this.venctype = venctype;
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

            public int getFrameRate() {
                return frameRate;
            }

            public void setFrameRate(int frameRate) {
                this.frameRate = frameRate;
            }

            public int getBitRate() {
                return bitRate;
            }

            public void setBitRate(int bitRate) {
                this.bitRate = bitRate;
            }

            public int getGop() {
                return gop;
            }

            public void setGop(int gop) {
                this.gop = gop;
            }

            public int getQuality() {
                return quality;
            }

            public void setQuality(int quality) {
                this.quality = quality;
            }

            public int getSmooth() {
                return smooth;
            }

            public void setSmooth(int smooth) {
                this.smooth = smooth;
            }

            public String getRcMode() {
                return rcMode;
            }

            public void setRcMode(String rcMode) {
                this.rcMode = rcMode;
            }

            public String getSmartencode() {
                return smartencode;
            }

            public void setSmartencode(String smartencode) {
                this.smartencode = smartencode;
            }

            public boolean isEncryptEn() {
                return encryptEn;
            }

            public void setEncryptEn(boolean encryptEn) {
                this.encryptEn = encryptEn;
            }
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


