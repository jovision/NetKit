package com.jovision.netkit.mvp.data.bean.response;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

//获取人脸识别的参数
public class OctIvpFacercgParamBean implements Serializable {

//    {//获取人脸识别的参数
//        "method": "ivp_facercg_get_param",
//            "param": {
//        "channelid": 0
//    },
//        "result": {
//        "bIVPFaceRCGEn": false,		//人脸识别使能
//                "bPedestrianCapEn": false,	//支持行人抓拍使能
//                "bMaskDetEn":false,			//是否检测口罩
//                "bAutoRefresh": false,		//是否自动刷新
//                "bFaceRcgDrawFace": false,	//是否显示人脸框
//                "faceRcgThreshold": 60,		//人脸相似度阈值
//                "minimalFace": 0,           //最小人脸尺寸，未使用
//                "maximalFace": 0,           //最大人脸尺寸，未使用
//                "facePitch": 0,           	//人脸俯仰角上下限[0,90]
//                "faceRoll": 0,           	//人脸翻滚叫上下限[0,180]
//                "faceYaw": 0,           	//人脸偏航角上下限[0,90]
//                "maxTrackingNum": 0,        //最多人脸跟踪数目，未使用
//                "maxRcgNum": 0,             //最多人脸识别数目，未使用
//                "detectionThreshold": 0,    //人脸检测阈值，范围：10-100，未使用
//                "clarityThreshold": 0,      //人脸清晰度阈值，范围：10-100，未使用
//                "shadeThreshold": 0,        //人脸遮挡阈值，未使用
//                "frontalThreshold": 50,     //正脸阈值，范围：10-100
//                "lightThreshold": 0,        //亮度阈值，未使用
//                "rcgInterval": 0,           //单个ID识别生命周期，单位：秒，范围：10-100，未使用
//                "rcgGap": 0,                //单个ID两次识别间隔，单位：秒，范围：10-100，未使用
//                "faceSnapMode": 0,			//人脸抓拍模式，0：识别时(有特征值)抓拍；1：间隔抓拍；2:最快抓拍；3：最优抓拍；4：最高温度抓拍；5：不抓拍；6：识别(比对成功)抓拍；7：最快+最优抓拍
//                "faceSnapInt": 3,			//人脸抓拍间隔，faceSnapMode为1时有效
//                "faceSnapMaxNum": 4,		// 最多人脸抓拍张数，间隔抓拍有效
//                "faceRcgServer": "",        //HTTP服务器地址
//                "faceRcgServerUser":"",			//HTTP服务器用户名
//                "faceRcgServerPasswd":"",		//HTTP服务器密码
//                "faceFtpServer": "",        //FTP服务器地址
//                "faceFtpPort": 21,          //FTP服务器端口
//                "faceFtpUser": "",
//                "faceFtpPasswd": "",
//                "maxRect":4,				//最大区域个数
//                "maxW":1920,				//最大区域宽度
//                "maxH":1080,				//最大区域高度
//                "stRect":					//人脸检测区域
//			[
//        {
//            "x": 0,
//                "y": 0,
//                "w": 1920,
//                "h": 1080
//        }
//			],
//        "task":
//        {							//报警预约
//            "bsos": false,			//是否配置为紧急报警，true表示7*24小时报警，false表示按时间段报警
//                "bAllTime": true,       //全时段布防
//                "maxTime": 4,			//每天布防时间段的最大数
//                "time":
//				[
//            {
//                "week": "Mon,Tues,Wed,Thur,Fri,Sat,Sun,EveryDay",	//星期1~7,每天
//                    "begin_hour": 12,	//开始小时
//                    "begin_min": 20,	//开始分钟
//                    "begin_sec": 30,	//开始秒
//                    "end_hour": 12,		//结束小时
//                    "end_min": 30,		//结束分钟
//                    "end_sec": 40		//结束秒
//            }
//				]
//        },
//        "alarmTypeList":				//报警类型列表，ipc传递，后期扩展或者删除 32 字节
//			[
//        "FaceDet",			//	检测到人脸报警
//                "MaskDet",			// 戴口罩报警
//                "NoMaskDet"			// 不戴口罩报警
//			],
//        "alarmType": "FaceDet",			//报警类型
//                "delay": 10,					//报警持续时间
//                "bOutClient": false,			//发送到客户端软件
//                "bOutEmail": false,				//发送邮件
//                "bReportObject":false,			//上报检测目标
//                "bAlarmSoundEnable": false,		//报警声音
//                "WhiteLight":{					//白光灯设置
//            "bEnable":false,   			//闪烁使能
//                    "Strength":0     			//闪烁强度（0~100），0：弱  50：强 100：长亮
//        },
//        "AlarmLight":{					//报警灯设置
//            "bEnable":false,   			//闪烁使能
//                    "Strength":0     			//闪烁强度（0~100）
//        },
//        "alarmout":						//关联的开关量报警输出：一个报警输入可关联多路报警输出
//			[
//        {
//            "almout_id": 0,				//关联报警输出的id
//                "bNormallyClosed": false	//false正常情况下是断开的，报警的时候闭合
//        }
//			]
//    },
//        "error": {
//        "errorcode": 0				//0：成功；else：失败
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
        private boolean bIVPFaceRCGEn;
        private boolean bPedestrianCapEn;
        private boolean bMaskDetEn;
        private boolean bAutoRefresh;
        private boolean bFaceRcgDrawFace;
        private int faceRcgThreshold;
        private int minimalFace;
        private int maximalFace;
        private int facePitch;
        private int faceRoll;
        private int faceYaw;
        private int maxTrackingNum;
        private int maxRcgNum;
        private int detectionThreshold;
        private int clarityThreshold;
        private int shadeThreshold;
        private int frontalThreshold;
        private int lightThreshold;
        private int rcgInterval;
        private int rcgGap;
        private int faceSnapMode;
        private int faceSnapInt;
        private int faceSnapMaxNum;
        private String faceRcgServer;
        private String faceRcgServerUser;
        private String faceRcgServerPasswd;
        private String faceFtpServer;
        private int faceFtpPort;
        private String faceFtpUser;
        private String faceFtpPasswd;
        private int maxRect;
        private int maxW;
        private int maxH;
        private List<StRectBean> stRect;
        private OctAlarmTask task;
        private List<String> alarmTypeList;
        private String alarmType;
        private int delay;
        private boolean bOutClient;
        private boolean bOutEmail;
        private boolean bReportObject;
        private boolean bAlarmSoundEnable;
        @SerializedName("WhiteLight")
        private WhiteLightBean whiteLight;
        @SerializedName("AlarmLight")
        private AlarmLightBean alarmLight;
        private List<AlarmoutBean> alarmout;
        private int alarm_link_id;//报警联动计划id
        private int alarm_defence_plan_id;//布防时间计划id

        public boolean isBIVPFaceRCGEn() {
            return bIVPFaceRCGEn;
        }

        public void setBIVPFaceRCGEn(boolean bIVPFaceRCGEn) {
            this.bIVPFaceRCGEn = bIVPFaceRCGEn;
        }

        public boolean isBPedestrianCapEn() {
            return bPedestrianCapEn;
        }

        public void setBPedestrianCapEn(boolean bPedestrianCapEn) {
            this.bPedestrianCapEn = bPedestrianCapEn;
        }

        public boolean isBMaskDetEn() {
            return bMaskDetEn;
        }

        public void setBMaskDetEn(boolean bMaskDetEn) {
            this.bMaskDetEn = bMaskDetEn;
        }

        public boolean isBAutoRefresh() {
            return bAutoRefresh;
        }

        public void setBAutoRefresh(boolean bAutoRefresh) {
            this.bAutoRefresh = bAutoRefresh;
        }

        public boolean isBFaceRcgDrawFace() {
            return bFaceRcgDrawFace;
        }

        public void setBFaceRcgDrawFace(boolean bFaceRcgDrawFace) {
            this.bFaceRcgDrawFace = bFaceRcgDrawFace;
        }

        public int getFaceRcgThreshold() {
            return faceRcgThreshold;
        }

        public void setFaceRcgThreshold(int faceRcgThreshold) {
            this.faceRcgThreshold = faceRcgThreshold;
        }

        public int getMinimalFace() {
            return minimalFace;
        }

        public void setMinimalFace(int minimalFace) {
            this.minimalFace = minimalFace;
        }

        public int getMaximalFace() {
            return maximalFace;
        }

        public void setMaximalFace(int maximalFace) {
            this.maximalFace = maximalFace;
        }

        public int getFacePitch() {
            return facePitch;
        }

        public void setFacePitch(int facePitch) {
            this.facePitch = facePitch;
        }

        public int getFaceRoll() {
            return faceRoll;
        }

        public void setFaceRoll(int faceRoll) {
            this.faceRoll = faceRoll;
        }

        public int getFaceYaw() {
            return faceYaw;
        }

        public void setFaceYaw(int faceYaw) {
            this.faceYaw = faceYaw;
        }

        public int getMaxTrackingNum() {
            return maxTrackingNum;
        }

        public void setMaxTrackingNum(int maxTrackingNum) {
            this.maxTrackingNum = maxTrackingNum;
        }

        public int getMaxRcgNum() {
            return maxRcgNum;
        }

        public void setMaxRcgNum(int maxRcgNum) {
            this.maxRcgNum = maxRcgNum;
        }

        public int getDetectionThreshold() {
            return detectionThreshold;
        }

        public void setDetectionThreshold(int detectionThreshold) {
            this.detectionThreshold = detectionThreshold;
        }

        public int getClarityThreshold() {
            return clarityThreshold;
        }

        public void setClarityThreshold(int clarityThreshold) {
            this.clarityThreshold = clarityThreshold;
        }

        public int getShadeThreshold() {
            return shadeThreshold;
        }

        public void setShadeThreshold(int shadeThreshold) {
            this.shadeThreshold = shadeThreshold;
        }

        public int getFrontalThreshold() {
            return frontalThreshold;
        }

        public void setFrontalThreshold(int frontalThreshold) {
            this.frontalThreshold = frontalThreshold;
        }

        public int getLightThreshold() {
            return lightThreshold;
        }

        public void setLightThreshold(int lightThreshold) {
            this.lightThreshold = lightThreshold;
        }

        public int getRcgInterval() {
            return rcgInterval;
        }

        public void setRcgInterval(int rcgInterval) {
            this.rcgInterval = rcgInterval;
        }

        public int getRcgGap() {
            return rcgGap;
        }

        public void setRcgGap(int rcgGap) {
            this.rcgGap = rcgGap;
        }

        public int getFaceSnapMode() {
            return faceSnapMode;
        }

        public void setFaceSnapMode(int faceSnapMode) {
            this.faceSnapMode = faceSnapMode;
        }

        public int getFaceSnapInt() {
            return faceSnapInt;
        }

        public void setFaceSnapInt(int faceSnapInt) {
            this.faceSnapInt = faceSnapInt;
        }

        public int getFaceSnapMaxNum() {
            return faceSnapMaxNum;
        }

        public void setFaceSnapMaxNum(int faceSnapMaxNum) {
            this.faceSnapMaxNum = faceSnapMaxNum;
        }

        public String getFaceRcgServer() {
            return faceRcgServer;
        }

        public void setFaceRcgServer(String faceRcgServer) {
            this.faceRcgServer = faceRcgServer;
        }

        public String getFaceRcgServerUser() {
            return faceRcgServerUser;
        }

        public void setFaceRcgServerUser(String faceRcgServerUser) {
            this.faceRcgServerUser = faceRcgServerUser;
        }

        public String getFaceRcgServerPasswd() {
            return faceRcgServerPasswd;
        }

        public void setFaceRcgServerPasswd(String faceRcgServerPasswd) {
            this.faceRcgServerPasswd = faceRcgServerPasswd;
        }

        public String getFaceFtpServer() {
            return faceFtpServer;
        }

        public void setFaceFtpServer(String faceFtpServer) {
            this.faceFtpServer = faceFtpServer;
        }

        public int getFaceFtpPort() {
            return faceFtpPort;
        }

        public void setFaceFtpPort(int faceFtpPort) {
            this.faceFtpPort = faceFtpPort;
        }

        public String getFaceFtpUser() {
            return faceFtpUser;
        }

        public void setFaceFtpUser(String faceFtpUser) {
            this.faceFtpUser = faceFtpUser;
        }

        public String getFaceFtpPasswd() {
            return faceFtpPasswd;
        }

        public void setFaceFtpPasswd(String faceFtpPasswd) {
            this.faceFtpPasswd = faceFtpPasswd;
        }

        public int getMaxRect() {
            return maxRect;
        }

        public void setMaxRect(int maxRect) {
            this.maxRect = maxRect;
        }

        public int getMaxW() {
            return maxW;
        }

        public void setMaxW(int maxW) {
            this.maxW = maxW;
        }

        public int getMaxH() {
            return maxH;
        }

        public void setMaxH(int maxH) {
            this.maxH = maxH;
        }

        public List<StRectBean> getStRect() {
            return stRect;
        }

        public void setStRect(List<StRectBean> stRect) {
            this.stRect = stRect;
        }

        public OctAlarmTask getTask() {
            return task;
        }

        public void setTask(OctAlarmTask task) {
            this.task = task;
        }

        public List<String> getAlarmTypeList() {
            return alarmTypeList;
        }

        public void setAlarmTypeList(List<String> alarmTypeList) {
            this.alarmTypeList = alarmTypeList;
        }

        public String getAlarmType() {
            return alarmType;
        }

        public void setAlarmType(String alarmType) {
            this.alarmType = alarmType;
        }

        public int getDelay() {
            return delay;
        }

        public void setDelay(int delay) {
            this.delay = delay;
        }

        public boolean isBOutClient() {
            return bOutClient;
        }

        public void setBOutClient(boolean bOutClient) {
            this.bOutClient = bOutClient;
        }

        public boolean isBOutEmail() {
            return bOutEmail;
        }

        public void setBOutEmail(boolean bOutEmail) {
            this.bOutEmail = bOutEmail;
        }

        public boolean isBReportObject() {
            return bReportObject;
        }

        public void setBReportObject(boolean bReportObject) {
            this.bReportObject = bReportObject;
        }

        public boolean isBAlarmSoundEnable() {
            return bAlarmSoundEnable;
        }

        public void setBAlarmSoundEnable(boolean bAlarmSoundEnable) {
            this.bAlarmSoundEnable = bAlarmSoundEnable;
        }

        public WhiteLightBean getWhiteLight() {
            return whiteLight;
        }

        public void setWhiteLight(WhiteLightBean whiteLight) {
            this.whiteLight = whiteLight;
        }

        public AlarmLightBean getAlarmLight() {
            return alarmLight;
        }

        public void setAlarmLight(AlarmLightBean alarmLight) {
            this.alarmLight = alarmLight;
        }

        public List<AlarmoutBean> getAlarmout() {
            return alarmout;
        }

        public void setAlarmout(List<AlarmoutBean> alarmout) {
            this.alarmout = alarmout;
        }

        public int getAlarm_link_id() {
            return alarm_link_id;
        }

        public void setAlarm_link_id(int alarm_link_id) {
            this.alarm_link_id = alarm_link_id;
        }

        public int getAlarm_defence_plan_id() {
            return alarm_defence_plan_id;
        }

        public void setAlarm_defence_plan_id(int alarm_defence_plan_id) {
            this.alarm_defence_plan_id = alarm_defence_plan_id;
        }

        public static class WhiteLightBean implements Serializable{
            private boolean bEnable;
            @SerializedName("Strength")
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

        public static class AlarmLightBean implements Serializable{
            private boolean bEnable;
            @SerializedName("Strength")
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

        public static class StRectBean implements Serializable{
            private int x;
            private int y;
            private int w;
            private int h;

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }

            public int getW() {
                return w;
            }

            public void setW(int w) {
                this.w = w;
            }

            public int getH() {
                return h;
            }

            public void setH(int h) {
                this.h = h;
            }
        }

        public static class AlarmoutBean implements Serializable{
            private int almout_id;
            private boolean bNormallyClosed;

            public int getAlmout_id() {
                return almout_id;
            }

            public void setAlmout_id(int almout_id) {
                this.almout_id = almout_id;
            }

            public boolean isBNormallyClosed() {
                return bNormallyClosed;
            }

            public void setBNormallyClosed(boolean bNormallyClosed) {
                this.bNormallyClosed = bNormallyClosed;
            }
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
