package com.jovision.netkit.mvp.data.http;

import com.jovision.netkit.mvp.data.bean.BaseEntity;

import java.util.List;


/**
 * Created by zhp on 2020/11/5
 */
public class PlayUrlBean extends BaseEntity {


    private String jvmpUrl = "";
    private String deviceSn;
    private int channelId;
    private String code;
    private String msg;
    private UrlBean url;

    public String getJvmpUrl() {
        return jvmpUrl;
    }

    public void setJvmpUrl(String jvmpUrl) {
        this.jvmpUrl = jvmpUrl;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UrlBean getUrl() {
        return url;
    }

    public void setUrl(UrlBean url) {
        this.url = url;
    }

    private class UrlBean extends BaseEntity {
        private String token;
        private String[] addrs;
        private String deviceSn;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String[] getAddrs() {
            return addrs;
        }

        public void setAddrs(String[] addrs) {
            this.addrs = addrs;
        }

        public String getDeviceSn() {
            return deviceSn;
        }

        public void setDeviceSn(String deviceSn) {
            this.deviceSn = deviceSn;
        }
    }
}



//    /**
//     * url : {"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiIxMjQyMVNTOEpZQkYiLCJleHBpcmVfdGltZSI6MTYwNDUxOTg0OSwibGlua19rZXkiOiIxMjQyMVNTOEpZQkYxNjA0NTQ4NDY5MzUzMjM5NjQxdDRVVHg4eTAifQ.rnskJ36h9UHRtXKNYov4cpXuILrSJucS2I0qNnG0CxM","addrs":["p2p://172.18.3.221:7050/index=0/node_type=1/addr_type=2"],"deviceSn":"12421SS8JYBF"}
//     * jvmpUrl : jvmp://172.18.3.221:7070/live/12421SS8JYBF?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjaGFubmVsX2lkIjowLCJkZXZpY2VfaWQiOiIxMjQyMVNTOEpZQkYiLCJleHBpcmVfdGltZSI6MTYwNDUxOTg0OSwic3RyZWFtX3R5cGUiOjB9.5e-DFWo4GaWaU1LKq8rXdGwPV3Vx9MTINpx903LRr7Y
//     * error : {"code":1000,"msg":"Success"}
//     * device_id : 12421SS8JYBF
//     * channel_id : 0
//     */
//
////    private String jvpmUrl;
////    private String deviceSn;
////    private int channelId;
////    private int code;
////    private int msg;
////    private UrlBean url;
////
////    public String getJvpmUrl() {
////        return jvpmUrl;
////    }
////
////    public void setJvpmUrl(String jvpmUrl) {
////        this.jvpmUrl = jvpmUrl;
////    }
////
////    public String getDeviceSn() {
////        return deviceSn;
////    }
////
////    public void setDeviceSn(String deviceSn) {
////        this.deviceSn = deviceSn;
////    }
////
////    public int getChannelId() {
////        return channelId;
////    }
////
////    public void setChannelId(int channelId) {
////        this.channelId = channelId;
////    }
////
////    public int getCode() {
////        return code;
////    }
////
////    public void setCode(int code) {
////        this.code = code;
////    }
////
////    public int getMsg() {
////        return msg;
////    }
////
////    public void setMsg(int msg) {
////        this.msg = msg;
////    }
////
////    public UrlBean getUrl() {
////        return url;
////    }
////
////    public void setUrl(UrlBean url) {
////        this.url = url;
////    }
////
////    private class UrlBean extends BaseEntity {
////        private String token;
////        private String[] addrs;
////        private String deviceSn;
////
////        public String getToken() {
////            return token;
////        }
////
////        public void setToken(String token) {
////            this.token = token;
////        }
////
////        public String[] getAddrs() {
////            return addrs;
////        }
////
////        public void setAddrs(String[] addrs) {
////            this.addrs = addrs;
////        }
////
////        public String getDeviceSn() {
////            return deviceSn;
////        }
////
////        public void setDeviceSn(String deviceSn) {
////            this.deviceSn = deviceSn;
////        }
////    }
//
//    private UrlBean url;
//    private String jvmpUrl;
//    private ErrorBean error;
//    private String device_id;
//    private int channel_id;
//
//    public UrlBean getUrl() {
//        return url;
//    }
//
//    public void setUrl(UrlBean url) {
//        this.url = url;
//    }
//
//    public String getJvmpUrl() {
//        return jvmpUrl;
//    }
//
//    public void setJvmpUrl(String jvmpUrl) {
//        this.jvmpUrl = jvmpUrl;
//    }
//
//    public ErrorBean getError() {
//        return error;
//    }
//
//    public void setError(ErrorBean error) {
//        this.error = error;
//    }
//
//    public String getDevice_id() {
//        return device_id;
//    }
//
//    public void setDevice_id(String device_id) {
//        this.device_id = device_id;
//    }
//
//    public int getChannel_id() {
//        return channel_id;
//    }
//
//    public void setChannel_id(int channel_id) {
//        this.channel_id = channel_id;
//    }
//
//    public static class UrlBean {
//        /**
//         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiIxMjQyMVNTOEpZQkYiLCJleHBpcmVfdGltZSI6MTYwNDUxOTg0OSwibGlua19rZXkiOiIxMjQyMVNTOEpZQkYxNjA0NTQ4NDY5MzUzMjM5NjQxdDRVVHg4eTAifQ.rnskJ36h9UHRtXKNYov4cpXuILrSJucS2I0qNnG0CxM
//         * addrs : ["p2p://172.18.3.221:7050/index=0/node_type=1/addr_type=2"]
//         * deviceSn : 12421SS8JYBF
//         */
//
//        private String token;
//        private String deviceSn;
//        private List<String> addrs;
//
//        public String getToken() {
//            return token;
//        }
//
//        public void setToken(String token) {
//            this.token = token;
//        }
//
//        public String getDeviceSn() {
//            return deviceSn;
//        }
//
//        public void setDeviceSn(String deviceSn) {
//            this.deviceSn = deviceSn;
//        }
//
//        public List<String> getAddrs() {
//            return addrs;
//        }
//
//        public void setAddrs(List<String> addrs) {
//            this.addrs = addrs;
//        }
//    }
//
//    public static class ErrorBean {
//        /**
//         * code : 1000
//         * msg : Success
//         */
//
//        @SerializedName("code")
//        private int codeX;
//        @SerializedName("msg")
//        private String msgX;
//
//        public int getCodeX() {
//            return codeX;
//        }
//
//        public void setCodeX(int codeX) {
//            this.codeX = codeX;
//        }
//
//        public String getMsgX() {
//            return msgX;
//        }
//
//        public void setMsgX(String msgX) {
//            this.msgX = msgX;
//        }
//    }
//}
