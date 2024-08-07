package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;

//获取设备的升级进度
public class OctDevUpdateProgressBean {


//    {	//获取设备的升级进度
//        "method": "dev_update_get_progress",
//            "param": {
//        "devID": "1122",					//设备ID
//                "type": "sctrl,ptz"   			    //(USB文件升级时用到)类型:sctrl：主控软件升级文件、ptz：云台软件升级文件
//    },
//        "result": {
//        "finished": true,					//升级是否完成
//                "phase": "download,erase,write",	//阶段
//                "progress": 10						//当前阶段的进度，正常0~100，-1 设备忙，-2 获取版本文件失败， -3 获取升级文件失败，-4 升级文件出错，-5 启动升级失败，-6 文件校验失败，-7 烧写过程出错
//    },
//        "error": {
//        "errstr": "Latest Version, File Not Found",
//                "errno": "GRPC_ERR_RESOURCE_NOT_EXIST, GRPC_ERR_RESOURCE_IS_LATEST_VER"
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
        private String devID;
        private String type;

        public String getDevID() {
            return devID;
        }

        public void setDevID(String devID) {
            this.devID = devID;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class ResultBean implements Serializable{
        private boolean finished;
        private String phase;
        private int progress;

        public boolean isFinished() {
            return finished;
        }

        public void setFinished(boolean finished) {
            this.finished = finished;
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
        private String errstr;
        private String errno;

        public String getErrstr() {
            return errstr;
        }

        public void setErrstr(String errstr) {
            this.errstr = errstr;
        }

        public String getErrno() {
            return errno;
        }

        public void setErrno(String errno) {
            this.errno = errno;
        }
    }




}
