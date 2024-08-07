package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

//定时抓拍功能（新接口）
public class OctTimingSnapBean {


    //    {	//定时抓拍功能（新接口）
//        "method": "timing_snap_get",
//            "param": {
//        "channelid": 0		//通道号，从0开始。-1表示所有
//    },
//        "result": {
//        "bSave": true,					//保存到内存卡
//                "bOutEmail": false,				//发送邮件
//                "http_push":{					//HTTP推送
//            "bEnable":false,   		//推送使能
//                    "server":""     		//推送地址
//        },
//        "bOutFTP": false,				//发送到FTP
//                "bOutSFTP": false,				//发送到SFTP
//                "quality": 70,					//抓图质量 1~100
//                "snap_task": [
//        {
//            "bEnable": false,
//                "time_start":{					//开始时间
//            "hour": 18,
//                    "min": 47,
//                    "sec": 10
//        },
//            "time_end":{					//结束时间
//            "hour": 19,
//                    "min": 47,
//                    "sec": 10
//        },
//            "interval": 3600 				//抓拍间隔，精确到秒
//        }
//            ]
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "Failed to set timing snap cfg!"
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

    public static class ParamBean implements Serializable{
        private int channelid;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }
    }

    public static class ResultBean implements Serializable{
        private int channelid;
        private boolean bSave;
        private boolean bOutEmail;
        private HttpPushBean http_push;
        private boolean bOutFTP;
        private boolean bOutSFTP;
        private int quality;
        private List<SnapTaskBean> snap_task;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }

        public boolean isBSave() {
            return bSave;
        }

        public void setBSave(boolean bSave) {
            this.bSave = bSave;
        }

        public boolean isBOutEmail() {
            return bOutEmail;
        }

        public void setBOutEmail(boolean bOutEmail) {
            this.bOutEmail = bOutEmail;
        }

        public HttpPushBean getHttp_push() {
            return http_push;
        }

        public void setHttp_push(HttpPushBean http_push) {
            this.http_push = http_push;
        }

        public boolean isBOutFTP() {
            return bOutFTP;
        }

        public void setBOutFTP(boolean bOutFTP) {
            this.bOutFTP = bOutFTP;
        }

        public boolean isBOutSFTP() {
            return bOutSFTP;
        }

        public void setBOutSFTP(boolean bOutSFTP) {
            this.bOutSFTP = bOutSFTP;
        }

        public int getQuality() {
            return quality;
        }

        public void setQuality(int quality) {
            this.quality = quality;
        }

        public List<SnapTaskBean> getSnap_task() {
            return snap_task;
        }

        public void setSnap_task(List<SnapTaskBean> snap_task) {
            this.snap_task = snap_task;
        }

        public static class HttpPushBean implements Serializable{
            private boolean bEnable;
            private String server;

            public boolean isBEnable() {
                return bEnable;
            }

            public void setBEnable(boolean bEnable) {
                this.bEnable = bEnable;
            }

            public String getServer() {
                return server;
            }

            public void setServer(String server) {
                this.server = server;
            }
        }

        public static class SnapTaskBean implements Serializable{
            private boolean bEnable;
            private TimeStartBean time_start;
            private TimeEndBean time_end;
            private int interval;

            public boolean isBEnable() {
                return bEnable;
            }

            public void setBEnable(boolean bEnable) {
                this.bEnable = bEnable;
            }

            public TimeStartBean getTime_start() {
                return time_start;
            }

            public void setTime_start(TimeStartBean time_start) {
                this.time_start = time_start;
            }

            public TimeEndBean getTime_end() {
                return time_end;
            }

            public void setTime_end(TimeEndBean time_end) {
                this.time_end = time_end;
            }

            public int getInterval() {
                return interval;
            }

            public void setInterval(int interval) {
                this.interval = interval;
            }

            public static class TimeStartBean implements Serializable{
                private int hour;
                private int min;
                private int sec;

                public int getHour() {
                    return hour;
                }

                public void setHour(int hour) {
                    this.hour = hour;
                }

                public int getMin() {
                    return min;
                }

                public void setMin(int min) {
                    this.min = min;
                }

                public int getSec() {
                    return sec;
                }

                public void setSec(int sec) {
                    this.sec = sec;
                }
            }

            public static class TimeEndBean implements Serializable{
                private int hour;
                private int min;
                private int sec;

                public int getHour() {
                    return hour;
                }

                public void setHour(int hour) {
                    this.hour = hour;
                }

                public int getMin() {
                    return min;
                }

                public void setMin(int min) {
                    this.min = min;
                }

                public int getSec() {
                    return sec;
                }

                public void setSec(int sec) {
                    this.sec = sec;
                }
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
