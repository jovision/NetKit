package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;

//获取专家设置配置
public class OctImageExpertBean {

//    {	//获取专家设置配置
//        "method": "image_get_expertsetting_param",
//            "param": {
//        "channelid":0			//通道号，从0开始。
//    },
//        "result": {
//        "the3DNoiseReduct":{		//3D降噪
//            "bEnable":false,    //开启使能
//                    "strength":0     //降噪强度(0~255)
//        },
//        "fluency": 3,           //流畅度， 范围0~6
//                "definition": 3,        //清晰度， 范围0~6
//                "noisereduct": 3,       //降噪强度， 范围0~6
//                "smear": 3,             //拖影抑制， 范围0~6
//                "bAutoLowFrameEn": false,	//夜视自动降帧
//                "defog":{				//去雾设置
//            "bEnable":false,    //开启使能
//                    "strength":0     //去雾强度（0~255）
//        },
//        "distortionCorrection":{ //畸变校正
//            "bEnable":false,    //开启使能
//                    "strength":0     //校正强度(0~255)
//        },
//        "bEnableFaceMode":false, //是否开启人脸模式
//                "bEnableCPMode": false	//是否开启车牌模式
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "Failed to get image expertsetting parameters!"
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
        private int channelid;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }
    }

    public static class ResultBean implements Serializable{
        private The3DNoiseReductBean the3DNoiseReduct;
        private int fluency;
        private int definition;
        private int noisereduct;
        private int smear;
        private boolean bAutoLowFrameEn;
        private DefogBean defog;
        private DistortionCorrectionBean distortionCorrection;
        private boolean bEnableFaceMode;
        private boolean bEnableCPMode;

        public The3DNoiseReductBean getThe3DNoiseReduct() {
            return the3DNoiseReduct;
        }

        public void setThe3DNoiseReduct(The3DNoiseReductBean the3DNoiseReduct) {
            this.the3DNoiseReduct = the3DNoiseReduct;
        }

        public int getFluency() {
            return fluency;
        }

        public void setFluency(int fluency) {
            this.fluency = fluency;
        }

        public int getDefinition() {
            return definition;
        }

        public void setDefinition(int definition) {
            this.definition = definition;
        }

        public int getNoisereduct() {
            return noisereduct;
        }

        public void setNoisereduct(int noisereduct) {
            this.noisereduct = noisereduct;
        }

        public int getSmear() {
            return smear;
        }

        public void setSmear(int smear) {
            this.smear = smear;
        }

        public boolean isBAutoLowFrameEn() {
            return bAutoLowFrameEn;
        }

        public void setBAutoLowFrameEn(boolean bAutoLowFrameEn) {
            this.bAutoLowFrameEn = bAutoLowFrameEn;
        }

        public DefogBean getDefog() {
            return defog;
        }

        public void setDefog(DefogBean defog) {
            this.defog = defog;
        }

        public DistortionCorrectionBean getDistortionCorrection() {
            return distortionCorrection;
        }

        public void setDistortionCorrection(DistortionCorrectionBean distortionCorrection) {
            this.distortionCorrection = distortionCorrection;
        }

        public boolean isBEnableFaceMode() {
            return bEnableFaceMode;
        }

        public void setBEnableFaceMode(boolean bEnableFaceMode) {
            this.bEnableFaceMode = bEnableFaceMode;
        }

        public boolean isBEnableCPMode() {
            return bEnableCPMode;
        }

        public void setBEnableCPMode(boolean bEnableCPMode) {
            this.bEnableCPMode = bEnableCPMode;
        }

        public static class The3DNoiseReductBean implements Serializable{
            private boolean bEnable;
            private int strength;

            public boolean isBEnable() {
                return bEnable;
            }

            public void setBEnable(boolean bEnable) {
                this.bEnable = bEnable;
            }

            public int getStrength() {
                return strength;
            }

            public void setStrength(int strength) {
                this.strength = strength;
            }
        }

        public static class DefogBean implements Serializable{
            private boolean bEnable;
            private int strength;

            public boolean isBEnable() {
                return bEnable;
            }

            public void setBEnable(boolean bEnable) {
                this.bEnable = bEnable;
            }

            public int getStrength() {
                return strength;
            }

            public void setStrength(int strength) {
                this.strength = strength;
            }
        }

        public static class DistortionCorrectionBean implements Serializable{
            private boolean bEnable;
            private int strength;

            public boolean isBEnable() {
                return bEnable;
            }

            public void setBEnable(boolean bEnable) {
                this.bEnable = bEnable;
            }

            public int getStrength() {
                return strength;
            }

            public void setStrength(int strength) {
                this.strength = strength;
            }
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
