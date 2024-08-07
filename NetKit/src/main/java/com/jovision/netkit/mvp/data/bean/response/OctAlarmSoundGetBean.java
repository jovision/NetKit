package com.jovision.netkit.mvp.data.bean.response;

//自定义报警声音获取，老设备仅支持一个报警音的设备
public class OctAlarmSoundGetBean {


//    {	//自定义报警声音获取
//        "method": "alarm_sound_get",
//            "param": {
//        "channelid": 0,		//通道号
//                "bGetData": false   //是否获取文件数据
//    },
//        "result": {
//        "file_name": "name",				//文件名称
//                "file_type": "g711u,aac",			//音频编码格式
//                "file_data": "base64(audio_data)"	//base64编码的音频文件：音频文件最长10s，711编码大小为80KB
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

    public static class ParamBean {
        private int channelid;
        private boolean bGetData;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }

        public boolean isBGetData() {
            return bGetData;
        }

        public void setBGetData(boolean bGetData) {
            this.bGetData = bGetData;
        }
    }

    public static class ResultBean {
        private String file_name;
        private String file_type;
        private String file_data;

        public String getFile_name() {
            return file_name;
        }

        public void setFile_name(String file_name) {
            this.file_name = file_name;
        }

        public String getFile_type() {
            return file_type;
        }

        public void setFile_type(String file_type) {
            this.file_type = file_type;
        }

        public String getFile_data() {
            return file_data;
        }

        public void setFile_data(String file_data) {
            this.file_data = file_data;
        }
    }

    public static class ErrorBean {
        private int errorcode;

        public int getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(int errorcode) {
            this.errorcode = errorcode;
        }
    }




}
