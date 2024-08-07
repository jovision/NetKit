package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;

/**
 * 2.0 卡格式化进度
 */
public class OctSDCardFormatProBean {


//    {
//        "method": "storage_format_get_progress",
//            "param": {
//        "diskNum": 0,
//                "diskName": "/dev/sda",
//                "partionNum": 0
//    },
//        "result": {
//        "finished": true,
//                "progress": 100,
//                "status": "normal,fail"
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "Failed to format SDCard"
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
        private int diskNum;
        private String diskName;
        private int partionNum;

        public int getDiskNum() {
            return diskNum;
        }

        public void setDiskNum(int diskNum) {
            this.diskNum = diskNum;
        }

        public String getDiskName() {
            return diskName;
        }

        public void setDiskName(String diskName) {
            this.diskName = diskName;
        }

        public int getPartionNum() {
            return partionNum;
        }

        public void setPartionNum(int partionNum) {
            this.partionNum = partionNum;
        }
    }

    public static class ResultBean implements Serializable{
        private boolean finished;
        private int progress;
        private String status;

        public boolean isFinished() {
            return finished;
        }

        public void setFinished(boolean finished) {
            this.finished = finished;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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
