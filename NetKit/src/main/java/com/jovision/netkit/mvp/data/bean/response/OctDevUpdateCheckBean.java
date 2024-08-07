package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;

//检查升级
public class OctDevUpdateCheckBean {

//    {	//检查升级
//        "method": "dev_update_check",
//            "param": {
//        "method": "usb,ftp,http,ip",		//升级方式：USB，FTP，HTTP，地址+端口
//                "url": "ftp://192.168.8.110/",		//地址，USB方式：没用到
//                //		ftp：ftp://192.168.8.110/
//                //		HTTP: wt（联通）、dx（电信1）、hw（电信2）
//                //		url: ip地址或域名
//                "port": 1001,						//端口。只针对地址+端口
//                "type": "sctrl,ptz",   			    //(USB文件升级时用到)类型:sctrl：主控软件升级文件、ptz：云台软件升级文件
//                "verdata": "data"					//(USB文件升级时用到)版本文件的内容
//    },
//        "result": {
//        "bNeedUpdate": true,
//                "version": "V2.2.4035 - 20151010     11:01:05",
//                "phase": "download,erase,write,free",
//                "progress": 10
//    },
//        "error": {
//        "errorcode": -1,
//              "message": "Failed to get OSD parameters!"
//    }
//   }



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
        private String verdata;

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

        public String getVerdata() {
            return verdata;
        }

        public void setVerdata(String verdata) {
            this.verdata = verdata;
        }
    }

    public static class ResultBean implements Serializable{
        private boolean bNeedUpdate;
        private String version;
        private String phase;
        private int progress;

        public boolean isBNeedUpdate() {
            return bNeedUpdate;
        }

        public void setBNeedUpdate(boolean bNeedUpdate) {
            this.bNeedUpdate = bNeedUpdate;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getPhase() {
            return phase;
        }

        public void setPhase(String phase) {
            this.phase = phase;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
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
