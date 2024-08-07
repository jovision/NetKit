package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

public class OctWifiListAp {



//    {	//获取ap列表
//        "method": "ifconfig_wifi_list_ap",
//            "level":"Operator",
//            "comments": "The value of quality ranges from 0 to 100.",
//            "param": {
//        "bResearch": true
//    },
//        "result": {
//        "apList": [
//        {
//            "name": "jovision",
//                "passwd": "jovision12345",
//                "quality": 100,
//                "keystat": -1,
//                "iestat": "open,shared,wep,wpa,wpa2,plain"
//        }
//            ]
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "Failed to list APs!"
//    }
//    }





    private String method;
    private String level;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
        private boolean bResearch;

        public boolean isBResearch() {
            return bResearch;
        }

        public void setBResearch(boolean bResearch) {
            this.bResearch = bResearch;
        }
    }

    public static class ResultBean {
        private List<ApListBean> apList;

        public List<ApListBean> getApList() {
            return apList;
        }

        public void setApList(List<ApListBean> apList) {
            this.apList = apList;
        }

        public static class ApListBean {
            private String name;
            private String passwd;
            private int quality;
            private int keystat;
            private String iestat;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPasswd() {
                return passwd;
            }

            public void setPasswd(String passwd) {
                this.passwd = passwd;
            }

            public int getQuality() {
                return quality;
            }

            public void setQuality(int quality) {
                this.quality = quality;
            }

            public int getKeystat() {
                return keystat;
            }

            public void setKeystat(int keystat) {
                this.keystat = keystat;
            }

            public String getIestat() {
                return iestat;
            }

            public void setIestat(String iestat) {
                this.iestat = iestat;
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
