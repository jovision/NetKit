package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;

//升级
public class OctDevUpdateBean {

//    {	//升级
//        "method": "dev_update",
//            "param": {
//        "method": "usb,ftp,http,ip",		//升级方式：USB升级，FTP升级，HTTP升级，地址+端口
//                "url": "ftp://192.168.8.110/",		//地址，USB方式：没用到
//                //		ftp：ftp://192.168.8.110/
//                //		HTTP: wt（联通）、dx（电信1）、hw（电信2）
//                //		url: ip地址或域名
//                "port": 1001,						//端口。只针对地址+端口
//                "type": "sctrl,ptz"   			    //(USB文件升级时用到)类型:sctrl：主控软件升级文件、ptz：云台软件升级文件
//    },
//        "result": {
//        "devID": "1122"						//设备ID
//    },
//        "error": {}
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
        private String method;
        private String url;
        private int port;
        private String type;

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class ResultBean implements Serializable{
        private String devID;

        public String getDevID() {
            return devID;
        }

        public void setDevID(String devID) {
            this.devID = devID;
        }
    }

    public static class ErrorBean implements Serializable{
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
