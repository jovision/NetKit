package com.jovision.netkit.mvp.data.bean.response;

//获取时间
public class OctTimeBean {



    //    {	//获取时间
//        "method": "dev_gtime",
//            "comments": "Param tmsec means the seconds elapsed since 1970.",
//            "param": {},
//        "result": {
//        "tmsec": 1387584000,			//1970年以来的秒数。用time(NULL)获取
//                "tminfo":{						//用这个，可以不受时区影响
//            "year": 2017,
//                    "month": 10,
//                    "day": 23,
//                    "hour": 19,
//                    "min": 10,
//                    "sec": 30
//        },
//        "tz": "+08:00",		//时区-12:00,-11:00,-10:00,-09:30,-09:00,-08:00,-07:00,-06:00,
//                //-05:00,-04:00,-03:30,-03:00,-02:00,-01:00,+00:00,+01:00,
//                //+02:00,+03:00,+03:30,+04:00,+04:30,+05:00,+05:30,+05:45,
//                //+06:00,+06:30,+07:00,+08:00,+08:30,+08:45,+09:00,+09:30,
//                //+10:00,+10:30,+11:00,+12:00,+12:45,+13:00,+14:00
//                "dstinfo": {			//夏令时配置
//            "dstEnable": false,				//是否支持夏令时
//                    "dstBegin":{					//夏令时开始时间
//                "month": 3,					//1-12
//                        "week": 2,					//1-5，第一个，第二个，第三个，第四个，最后一个
//                        "day": 0,					//0-6，对应星期日到星期六
//                        "hour": 2,					//0-24
//                        "minute": 0,				//0-59
//                        "second": 0					//0-59
//            },
//            "dstEnd":{						//夏令时结束时间
//                "month": 11,				//1-12
//                        "week": 1,					//1-5，第一个，第二个，第三个，第四个，最后一个
//                        "day": 0,					//0-6，对应星期日到星期六
//                        "hour": 2,					//0-24
//                        "minute": 0,				//0-59
//                        "second": 0					//0-59
//            },
//            "dstOffset": 3600				//偏移时间 1800，3600，5400，7200 单位：秒
//        }
//    },
//        "error": {}
//    }

    private String method;
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
        private int tmsec;
        private TminfoBean tminfo;
        private String tz;
        private DstinfoBean dstinfo;

        public int getTmsec() {
            return tmsec;
        }

        public void setTmsec(int tmsec) {
            this.tmsec = tmsec;
        }

        public TminfoBean getTminfo() {
            return tminfo;
        }

        public void setTminfo(TminfoBean tminfo) {
            this.tminfo = tminfo;
        }

        public String getTz() {
            return tz;
        }

        public void setTz(String tz) {
            this.tz = tz;
        }

        public DstinfoBean getDstinfo() {
            return dstinfo;
        }

        public void setDstinfo(DstinfoBean dstinfo) {
            this.dstinfo = dstinfo;
        }

        public static class TminfoBean {
            private int year;
            private int month;
            private int day;
            private int hour;
            private int min;
            private int sec;

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

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

        public static class DstinfoBean {
            private boolean dstEnable;
            private DstBeginBean dstBegin;
            private DstEndBean dstEnd;
            private int dstOffset;

            public boolean isDstEnable() {
                return dstEnable;
            }

            public void setDstEnable(boolean dstEnable) {
                this.dstEnable = dstEnable;
            }

            public DstBeginBean getDstBegin() {
                return dstBegin;
            }

            public void setDstBegin(DstBeginBean dstBegin) {
                this.dstBegin = dstBegin;
            }

            public DstEndBean getDstEnd() {
                return dstEnd;
            }

            public void setDstEnd(DstEndBean dstEnd) {
                this.dstEnd = dstEnd;
            }

            public int getDstOffset() {
                return dstOffset;
            }

            public void setDstOffset(int dstOffset) {
                this.dstOffset = dstOffset;
            }

            public static class DstBeginBean {
                private int month;
                private int week;
                private int day;
                private int hour;
                private int minute;
                private int second;

                public int getMonth() {
                    return month;
                }

                public void setMonth(int month) {
                    this.month = month;
                }

                public int getWeek() {
                    return week;
                }

                public void setWeek(int week) {
                    this.week = week;
                }

                public int getDay() {
                    return day;
                }

                public void setDay(int day) {
                    this.day = day;
                }

                public int getHour() {
                    return hour;
                }

                public void setHour(int hour) {
                    this.hour = hour;
                }

                public int getMinute() {
                    return minute;
                }

                public void setMinute(int minute) {
                    this.minute = minute;
                }

                public int getSecond() {
                    return second;
                }

                public void setSecond(int second) {
                    this.second = second;
                }
            }

            public static class DstEndBean {
                private int month;
                private int week;
                private int day;
                private int hour;
                private int minute;
                private int second;

                public int getMonth() {
                    return month;
                }

                public void setMonth(int month) {
                    this.month = month;
                }

                public int getWeek() {
                    return week;
                }

                public void setWeek(int week) {
                    this.week = week;
                }

                public int getDay() {
                    return day;
                }

                public void setDay(int day) {
                    this.day = day;
                }

                public int getHour() {
                    return hour;
                }

                public void setHour(int hour) {
                    this.hour = hour;
                }

                public int getMinute() {
                    return minute;
                }

                public void setMinute(int minute) {
                    this.minute = minute;
                }

                public int getSecond() {
                    return second;
                }

                public void setSecond(int second) {
                    this.second = second;
                }
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
