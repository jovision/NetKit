package com.jovision.netkit.mvp.data.bean.response;

import com.google.gson.annotations.SerializedName;

/**
 * 获取支持的智能分析功能
 */
public class OctIvpBean {


//    {//获取支持的智能分析功能
//        "method": "ivp_support_get",
//            "param": {
//        "channelid": 0
//    },
//        "result": {
//        "IPCIVPVersion": "2.0",			//IPC智能分析版本
//                "bIVPSupport": false,			//总控，是否支持智能分析
//                "bRLSupport": false,			//是否支持区域绊线
//                "bCDESupport": false,			//是否支持人群密度
//                "bOCLSupport": false,			//是否支持超员检测
//                "bHideSupport": false,			//是否支持遮挡报警
//                "bSCSupport": false,			//是否支持场景变更
//                "bVFSupport": false,			//是否支持虚焦检测
//                "bFireSupport": false,			//是否支持烟火报警
//                "bHoverSupport": false,			//是否支持徘徊检测
//                "bFMSupport": false,			//是否支持快速移动
//                "bTLSupport": false,			//是否支持拿取遗留
//                "bCountSupport": false,			//是否支持客流量统计
//                "bVRSupport": false,			//是否支持占有率侦测
//                "bASDSupport": false,			//是否支持声音异常检测
//                "bHMSupport": false,            //是否支持热力图
//                "bFaceCapSupport": false,		//是否支持人脸抓拍
//                "bFaceEigenSupport": false,		//是否支持提取人脸特征值。
//                "bFaceRcgSupport": false,		//是否支持人脸识别
//                "bVehicleCapSupport": false,	//是否支持机动车抓拍
//                "bPedestrianCapSupport": false,	//是否支持行人抓拍
//                "bNonmotorCapSupport": false,	//是否支持非机动车抓拍
//                "bPtzAutoTraceSupport": false,	//是否支持自动跟踪功能
//                "bPDLeaveSupport": false,		//是否支持离岗检测
//                "bPlateRcgSupport": false,		//是否支持车牌识别
//                "bTemperatureSupport": false,	//是否支持温度检测
//                "bDCFaceSup": false				//是否支持人脸抓拍，考勤机使用
//    },
//        "error": {
//        "errorcode": -1
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

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }
    }

    public static class ResultBean {
        @SerializedName("IPCIVPVersion")
        private String iPCIVPVersion;
        private boolean bIVPSupport;
        private boolean bRLSupport;
        private boolean bCDESupport;
        private boolean bOCLSupport;
        private boolean bHideSupport;
        private boolean bSCSupport;
        private boolean bVFSupport;//是否支持虚焦检测
        private boolean bFireSupport;
        private boolean bHoverSupport;
        private boolean bFMSupport;
        private boolean bTLSupport;
        private boolean bCountSupport;
        private boolean bVRSupport;
        private boolean bASDSupport;
        private boolean bHMSupport;
        private boolean bFaceCapSupport;
        private boolean bFaceEigenSupport;
        private boolean bFaceRcgSupport;
        private boolean bVehicleCapSupport;
        private boolean bPedestrianCapSupport;
        private boolean bNonmotorCapSupport;
        private boolean bPtzAutoTraceSupport;
        private boolean bPDLeaveSupport;
        private boolean bPlateRcgSupport;
        private boolean bTemperatureSupport;
        private boolean bDCFaceSup;

        public String getIPCIVPVersion() {
            return iPCIVPVersion;
        }

        public void setIPCIVPVersion(String iPCIVPVersion) {
            this.iPCIVPVersion = iPCIVPVersion;
        }

        public boolean isBIVPSupport() {
            return bIVPSupport;
        }

        public void setBIVPSupport(boolean bIVPSupport) {
            this.bIVPSupport = bIVPSupport;
        }

        public boolean isBRLSupport() {
            return bRLSupport;
        }

        public void setBRLSupport(boolean bRLSupport) {
            this.bRLSupport = bRLSupport;
        }

        public boolean isBCDESupport() {
            return bCDESupport;
        }

        public void setBCDESupport(boolean bCDESupport) {
            this.bCDESupport = bCDESupport;
        }

        public boolean isBOCLSupport() {
            return bOCLSupport;
        }

        public void setBOCLSupport(boolean bOCLSupport) {
            this.bOCLSupport = bOCLSupport;
        }

        public boolean isBHideSupport() {
            return bHideSupport;
        }

        public void setBHideSupport(boolean bHideSupport) {
            this.bHideSupport = bHideSupport;
        }

        public boolean isBSCSupport() {
            return bSCSupport;
        }

        public void setBSCSupport(boolean bSCSupport) {
            this.bSCSupport = bSCSupport;
        }

        public boolean isBVFSupport() {
            return bVFSupport;
        }

        public void setBVFSupport(boolean bVFSupport) {
            this.bVFSupport = bVFSupport;
        }

        public boolean isBFireSupport() {
            return bFireSupport;
        }

        public void setBFireSupport(boolean bFireSupport) {
            this.bFireSupport = bFireSupport;
        }

        public boolean isBHoverSupport() {
            return bHoverSupport;
        }

        public void setBHoverSupport(boolean bHoverSupport) {
            this.bHoverSupport = bHoverSupport;
        }

        public boolean isBFMSupport() {
            return bFMSupport;
        }

        public void setBFMSupport(boolean bFMSupport) {
            this.bFMSupport = bFMSupport;
        }

        public boolean isBTLSupport() {
            return bTLSupport;
        }

        public void setBTLSupport(boolean bTLSupport) {
            this.bTLSupport = bTLSupport;
        }

        public boolean isBCountSupport() {
            return bCountSupport;
        }

        public void setBCountSupport(boolean bCountSupport) {
            this.bCountSupport = bCountSupport;
        }

        public boolean isBVRSupport() {
            return bVRSupport;
        }

        public void setBVRSupport(boolean bVRSupport) {
            this.bVRSupport = bVRSupport;
        }

        public boolean isBASDSupport() {
            return bASDSupport;
        }

        public void setBASDSupport(boolean bASDSupport) {
            this.bASDSupport = bASDSupport;
        }

        public boolean isBHMSupport() {
            return bHMSupport;
        }

        public void setBHMSupport(boolean bHMSupport) {
            this.bHMSupport = bHMSupport;
        }

        public boolean isBFaceCapSupport() {
            return bFaceCapSupport;
        }

        public void setBFaceCapSupport(boolean bFaceCapSupport) {
            this.bFaceCapSupport = bFaceCapSupport;
        }

        public boolean isBFaceEigenSupport() {
            return bFaceEigenSupport;
        }

        public void setBFaceEigenSupport(boolean bFaceEigenSupport) {
            this.bFaceEigenSupport = bFaceEigenSupport;
        }

        public boolean isBFaceRcgSupport() {
            return bFaceRcgSupport;
        }

        public void setBFaceRcgSupport(boolean bFaceRcgSupport) {
            this.bFaceRcgSupport = bFaceRcgSupport;
        }

        public boolean isBVehicleCapSupport() {
            return bVehicleCapSupport;
        }

        public void setBVehicleCapSupport(boolean bVehicleCapSupport) {
            this.bVehicleCapSupport = bVehicleCapSupport;
        }

        public boolean isBPedestrianCapSupport() {
            return bPedestrianCapSupport;
        }

        public void setBPedestrianCapSupport(boolean bPedestrianCapSupport) {
            this.bPedestrianCapSupport = bPedestrianCapSupport;
        }

        public boolean isBNonmotorCapSupport() {
            return bNonmotorCapSupport;
        }

        public void setBNonmotorCapSupport(boolean bNonmotorCapSupport) {
            this.bNonmotorCapSupport = bNonmotorCapSupport;
        }

        public boolean isBPtzAutoTraceSupport() {
            return bPtzAutoTraceSupport;
        }

        public void setBPtzAutoTraceSupport(boolean bPtzAutoTraceSupport) {
            this.bPtzAutoTraceSupport = bPtzAutoTraceSupport;
        }

        public boolean isBPDLeaveSupport() {
            return bPDLeaveSupport;
        }

        public void setBPDLeaveSupport(boolean bPDLeaveSupport) {
            this.bPDLeaveSupport = bPDLeaveSupport;
        }

        public boolean isBPlateRcgSupport() {
            return bPlateRcgSupport;
        }

        public void setBPlateRcgSupport(boolean bPlateRcgSupport) {
            this.bPlateRcgSupport = bPlateRcgSupport;
        }

        public boolean isBTemperatureSupport() {
            return bTemperatureSupport;
        }

        public void setBTemperatureSupport(boolean bTemperatureSupport) {
            this.bTemperatureSupport = bTemperatureSupport;
        }

        public boolean isBDCFaceSup() {
            return bDCFaceSup;
        }

        public void setBDCFaceSup(boolean bDCFaceSup) {
            this.bDCFaceSup = bDCFaceSup;
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
