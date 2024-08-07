package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;

//获取音频输出(解码)参数
public class OctAudioAoGetParamBean implements Serializable {

//    {	//获取音频输出(解码)参数
//        "method": "ao_get_param",
//            "param": {
//        "channelid": 0					//音频通道，从0开始。
//    },
//        "result": {
//        "bEnable": true,
//                "sampleRate": 8000,		//采样率
//                "bitWidth": 16,			//位宽
//                "cntChannel": 1,		//通道数
//                "encType": "none,pcm,g711a,g711u,g726,aac,adpcm",	//编码格式
//                "bitRate":128,			//AAC编码会用到，kbps
//                "aoGain": 0		//音频输入增益校准值，范围(0~100)
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
        private boolean bEnable;
        private int sampleRate;
        private int bitWidth;
        private int cntChannel;
        private String encType;
        private int bitRate;
        private int aoGain;

        public boolean isBEnable() {
            return bEnable;
        }

        public void setBEnable(boolean bEnable) {
            this.bEnable = bEnable;
        }

        public int getSampleRate() {
            return sampleRate;
        }

        public void setSampleRate(int sampleRate) {
            this.sampleRate = sampleRate;
        }

        public int getBitWidth() {
            return bitWidth;
        }

        public void setBitWidth(int bitWidth) {
            this.bitWidth = bitWidth;
        }

        public int getCntChannel() {
            return cntChannel;
        }

        public void setCntChannel(int cntChannel) {
            this.cntChannel = cntChannel;
        }

        public String getEncType() {
            return encType;
        }

        public void setEncType(String encType) {
            this.encType = encType;
        }

        public int getBitRate() {
            return bitRate;
        }

        public void setBitRate(int bitRate) {
            this.bitRate = bitRate;
        }

        public int getAoGain() {
            return aoGain;
        }

        public void setAoGain(int aoGain) {
            this.aoGain = aoGain;
        }
    }

    public static class ErrorBean implements Serializable{
        private int errorcode;

        public int getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(int errorcode) {
            this.errorcode = errorcode;
        }
    }





}
