package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;

//获取图像能力
public class OctImageAbilityGetBean {

    //    {	//获取图像能力
//        "method": "image_get_ability",
//            "param": {
//        "channelid": 0
//    },
//        "result": {
//        "bMISup": false,				//是否支持镜像
//                "bSTSup": false,				//是否支持翻转
//                "bRotateSup": true,				//是否支持旋转
//                "bStyleSup": false,				//是否支持图像风格设置
//                "bExpModeSup": false,			//是否支持曝光模式设置
//                "bWBSup": false,				//是否支持白平衡
//                "bWDSup": true,					//是否支持宽动态
//                "bHardWDSup": false,			//是否支持硬件宽动态
//                "bASTimeSup": false,			//是否支持防抖时间设置
//                "bFluencySup": false,			//是否支持流畅度设置
//                "bDefinitionSup": false,		//是否支持清晰度设置
//                "bNoiseRdSup": false,			//是否支持降噪强度设置
//                "bSmearSup": false,				//是否支持拖影抑制设置
//                "bAutoLowFrameSup": true,		//是否支持夜视降帧
//                "b3DNoiseRdSup": false,			//是否支持3D降噪
//                "b3DNoiseRdValueSup": false,	//是否支持3D降噪强度设置
//                "bDefogSup": true,				//是否支持去雾
//                "bDefogValueSup": false,		//是否支持去雾强度设置
//                "bDistCorSup": false,			//是否支持畸变校正
//                "bDistCorValueSup": false,		//是否支持畸变校正强度设置
//                "bFaceModeSup": true,			//是否支持人脸模式
//                "bStarSup":true,				//是否支持星光级
//                "bVlpnIrSup": false,			//是否支持红外灯下看清车牌
//                "bSmartSensorSup": false,		//是否支持智能光敏
//                "bCPModeSup": false,			//是否支持车牌模式
//                "bWLValSetSup": false			//是否支持白光灯亮度设置
//    },
//        "error": {
//        "errorcode": -32602,
//                "message": "Failed to get image ability parameters!"
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
        private boolean bMISup;
        private boolean bSTSup;
        private boolean bRotateSup;
        private boolean bStyleSup;
        private boolean bExpModeSup;
        private boolean bWBSup;
        private boolean bWDSup;
        private boolean bHardWDSup;
        private boolean bASTimeSup;
        private boolean bFluencySup;
        private boolean bDefinitionSup;
        private boolean bNoiseRdSup;
        private boolean bSmearSup;
        private boolean bAutoLowFrameSup;
        private boolean b3DNoiseRdSup;
        private boolean b3DNoiseRdValueSup;
        private boolean bDefogSup;
        private boolean bDefogValueSup;
        private boolean bDistCorSup;
        private boolean bDistCorValueSup;
        private boolean bFaceModeSup;
        private boolean bStarSup;
        private boolean bVlpnIrSup;
        private boolean bSmartSensorSup;
        private boolean bCPModeSup;
        private boolean bWLValSetSup;
        private String[] LightModeList;//补光模式列表 AutoIR:自动红外, AutoWhite:自动白光, AlwaysClose:常闭模式, SmartLight:智能双光

        public boolean isBMISup() {
            return bMISup;
        }

        public void setBMISup(boolean bMISup) {
            this.bMISup = bMISup;
        }

        public boolean isBSTSup() {
            return bSTSup;
        }

        public void setBSTSup(boolean bSTSup) {
            this.bSTSup = bSTSup;
        }

        public boolean isBRotateSup() {
            return bRotateSup;
        }

        public void setBRotateSup(boolean bRotateSup) {
            this.bRotateSup = bRotateSup;
        }

        public boolean isBStyleSup() {
            return bStyleSup;
        }

        public void setBStyleSup(boolean bStyleSup) {
            this.bStyleSup = bStyleSup;
        }

        public boolean isBExpModeSup() {
            return bExpModeSup;
        }

        public void setBExpModeSup(boolean bExpModeSup) {
            this.bExpModeSup = bExpModeSup;
        }

        public boolean isBWBSup() {
            return bWBSup;
        }

        public void setBWBSup(boolean bWBSup) {
            this.bWBSup = bWBSup;
        }

        public boolean isBWDSup() {
            return bWDSup;
        }

        public void setBWDSup(boolean bWDSup) {
            this.bWDSup = bWDSup;
        }

        public boolean isBHardWDSup() {
            return bHardWDSup;
        }

        public void setBHardWDSup(boolean bHardWDSup) {
            this.bHardWDSup = bHardWDSup;
        }

        public boolean isBASTimeSup() {
            return bASTimeSup;
        }

        public void setBASTimeSup(boolean bASTimeSup) {
            this.bASTimeSup = bASTimeSup;
        }

        public boolean isBFluencySup() {
            return bFluencySup;
        }

        public void setBFluencySup(boolean bFluencySup) {
            this.bFluencySup = bFluencySup;
        }

        public boolean isBDefinitionSup() {
            return bDefinitionSup;
        }

        public void setBDefinitionSup(boolean bDefinitionSup) {
            this.bDefinitionSup = bDefinitionSup;
        }

        public boolean isBNoiseRdSup() {
            return bNoiseRdSup;
        }

        public void setBNoiseRdSup(boolean bNoiseRdSup) {
            this.bNoiseRdSup = bNoiseRdSup;
        }

        public boolean isBSmearSup() {
            return bSmearSup;
        }

        public void setBSmearSup(boolean bSmearSup) {
            this.bSmearSup = bSmearSup;
        }

        public boolean isBAutoLowFrameSup() {
            return bAutoLowFrameSup;
        }

        public void setBAutoLowFrameSup(boolean bAutoLowFrameSup) {
            this.bAutoLowFrameSup = bAutoLowFrameSup;
        }

        public boolean isB3DNoiseRdSup() {
            return b3DNoiseRdSup;
        }

        public void setB3DNoiseRdSup(boolean b3DNoiseRdSup) {
            this.b3DNoiseRdSup = b3DNoiseRdSup;
        }

        public boolean isB3DNoiseRdValueSup() {
            return b3DNoiseRdValueSup;
        }

        public void setB3DNoiseRdValueSup(boolean b3DNoiseRdValueSup) {
            this.b3DNoiseRdValueSup = b3DNoiseRdValueSup;
        }

        public boolean isBDefogSup() {
            return bDefogSup;
        }

        public void setBDefogSup(boolean bDefogSup) {
            this.bDefogSup = bDefogSup;
        }

        public boolean isBDefogValueSup() {
            return bDefogValueSup;
        }

        public void setBDefogValueSup(boolean bDefogValueSup) {
            this.bDefogValueSup = bDefogValueSup;
        }

        public boolean isBDistCorSup() {
            return bDistCorSup;
        }

        public void setBDistCorSup(boolean bDistCorSup) {
            this.bDistCorSup = bDistCorSup;
        }

        public boolean isBDistCorValueSup() {
            return bDistCorValueSup;
        }

        public void setBDistCorValueSup(boolean bDistCorValueSup) {
            this.bDistCorValueSup = bDistCorValueSup;
        }

        public boolean isBFaceModeSup() {
            return bFaceModeSup;
        }

        public void setBFaceModeSup(boolean bFaceModeSup) {
            this.bFaceModeSup = bFaceModeSup;
        }

        public boolean isBStarSup() {
            return bStarSup;
        }

        public void setBStarSup(boolean bStarSup) {
            this.bStarSup = bStarSup;
        }

        public boolean isBVlpnIrSup() {
            return bVlpnIrSup;
        }

        public void setBVlpnIrSup(boolean bVlpnIrSup) {
            this.bVlpnIrSup = bVlpnIrSup;
        }

        public boolean isBSmartSensorSup() {
            return bSmartSensorSup;
        }

        public void setBSmartSensorSup(boolean bSmartSensorSup) {
            this.bSmartSensorSup = bSmartSensorSup;
        }

        public boolean isBCPModeSup() {
            return bCPModeSup;
        }

        public void setBCPModeSup(boolean bCPModeSup) {
            this.bCPModeSup = bCPModeSup;
        }

        public boolean isBWLValSetSup() {
            return bWLValSetSup;
        }

        public void setBWLValSetSup(boolean bWLValSetSup) {
            this.bWLValSetSup = bWLValSetSup;
        }

        public String[] getLightModeList() {
            return LightModeList;
        }

        public void setLightModeList(String[] lightModeList) {
            LightModeList = lightModeList;
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
