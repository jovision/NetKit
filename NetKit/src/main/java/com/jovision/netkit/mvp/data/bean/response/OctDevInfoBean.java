package com.jovision.netkit.mvp.data.bean.response;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *  云视通2.0获取设备详情返回对象
 */
public class OctDevInfoBean {



//    {	//获取硬件信息
//        "method": "dev_get_hwinfo",
//            "level":"Operator",
//            "param": {},
//        "result": {
//        "devType":"IPC,NVR,DVR",			//产品大类
//                "devModel":"JVS-N71-HD",			//产品型号（整机型号、对外型号）
//                "type": "IPC,NVR,DVR",				//产品大类[IPC旧版本填写错误，废弃，只用于兼容旧版本]
//                "hardware": "V1.0",					//硬件版本（填写硬件信息）
//                "sn": "112233",						//序列号
//                "firmware": "V1.0",					//固件版本
//                "uiVersion": "V1.0",				//界面版本
//                "temperVersion":"1.0.1",			//测温模块固件版本
//                "manufacture": "JOVISION",			//制造商
//                "model": "JVS-N71-HD",				//型号[IPC旧版本填写错误，废弃，只用于兼容旧版本]
//                "custom": "NULL, KUAIYU",			//客户定制需求，可扩展
//                "bHomeIPC": false,					//Home_Product，是否为消费类家用机（功能特性和渠道机存在差别）
//                "bPtzSupport": true,
//                "PtzFirmware": 375,					//云台软件版本号
//                "bAFSupport": false,				//是否支持自动聚焦
//                "bPTZPrivacySupport":false, 		//是否支持球机遮挡
//                "bOnlyDirPtzSupport": true,			//是否仅支持方向控制的云台
//                "baudiocodecSupport": true,			//硬件上是否支持音频codec功能，AUDIO IN
//                "bNVModifySupport": true,			//是否支持夜视优化
//                "bwdrsupport": true,				//是否支持宽动态
//                "bDemistSupport": true,				//是否支持去雾
//                "bStarSupport":true,				//是否支持星光级
//                "bLDCSupport": true,				//是否支持畸变校正功能
//                "brotateSupport": true,				//是否支持旋转
//                "bExpSupport": true,				//是否支持夜视亮度和夜视切换时刻滑块
//                "bFaceModeSupport": true,			//是否支持人脸模式
//                "bVlpnIrSupport": false,			//是否支持红外灯下看清车牌
//                "bWifiSupport": true,				//是否支持无线连接
//                "bDDNSSupport": true,				//是否支持DDNS
//                "bGB28181Support": true,			//是否支持GB28181
//                "bGB35114Support": true,			//是否支持GB35114
//                "bGA1400Support": true,				//是否支持GA1400
//                "bFTPSupport":true,					//是否支持FTP
//                "bNFSSupport":true,					//是否支持NFS
//                "bAlarmServiceSupport": false,		//是否支持迅卫士
//                "bRTMPSupport": false,				//是否支持rtmp
//                "bFishEye": false,					//是否是鱼眼
//                "bImageADSupport": true,			//是否支持图像高级设置
//                "bMultiOsdSupport": true,			//是否支持多行OSD
//                "bEightPrivacy": true,				//是否支持8个区域遮挡
//                "bMDGridSupport": true,				//是否支持MD网格
//                "bChatSupport":true,                //是否支持对讲
//                "bEnableOnlineSupport": true,		//是否支持手动配置上下线开关（启动云视通上线服务）
//                "channelCnt": 1,					//通道个数
//                "streamCnt": 3,						//每个通道的码流个数
//                "ystID": "A402153844",				//云视通号
//                "bRemoteDesk": true,  				//是否支持远程桌面
//                "bWebConfig": false,  				//是否支持web配置
//                "bDstConfigSupport": false,			//是否支持夏令时配置
//                "bMDRepelWithIVP": false,			//移动侦测与智能分析是否互斥
//                "bDualLightSupport": false,			//是否支持双光源
//                "bAlarmLightSupport": false,		//是否支持白光灯报警
//                "bAlarmLedSupport": false,			//是否支持LED灯报警
//                "bAlarmSoundSupport": false,		//是否支持报警声音
//                "AlarmSoundSampleRate": 8000,		//自定义报警声音采样率
//                "bModBusSupport": false,			//是否支持ModBus 485
//                "bSecurityViewSupport": false,		//是否支持安全管理页面
//                "bSnapTimingSupport": false,		//是否支持新版的图片抓拍和预览
//                "bPDSupport": false,				//是否支持人形检测
//                "bMDSupport": false,				//是否支持移动侦测
//                "b4GSupport": false,				//是否支持4G网络设备
//                "bPtzAutoTraceSupport": false,		//是否支持云台追踪目标
//                "bIntelligenceUpload": true,		//是否支持智能上报功能
//                "WebProtocol": "HTTP,HTTPS",        //WEB支持的网络协议 HTTP、HTTPS
//                "bSupport3DLocate": false,			//Home_Product ,摇头机是否支持3D touch
//                "bSupportMTrack": false,			//Home_Product,摇头机是否支持移动跟踪
//                "bSupportHomeCloud": false,			//Home_Product,摇头机是否支持,小维家用云存储
//                "bSupportTimePointPlay": false,		//Home_Product,摇头机是否支持时间轴精准回放
//                "RemoteChatAudioMode": "TWO_WAY",	//Home_Product,支持的对讲模式，单向：ONE_WAY 双向：TWO_WAY 单双向都支持：BOTH_MODE 不支持：NO_WAY
//                "defChatAudioMode": "ONE_WAY",      //设备默认对讲模式，单向：：ONE_WAY  双向：TWO_WAY
//                "MobileQuality": "HIGH",			//Home_Product,APP 画质：超清HIGH 、高清MIDDLE、流畅LOW
//                "IndicatorLedMode":0,				///HomeProduct，LED指示灯的工作模式,自动:0 ,常开:1,常灭:2
//                "alarm": {
//            "type": "buildin, alarmbox",	//报警类型：内置报警，报警盒
//                    "cntAlmGroup": 1,				//报警输入组个数
//                    "cntAlmin_perGroup": 1,			//每个组的报警输入个数
//                    "cntAlmout": 1					//报警输出个数
//        },
//        "audio": {
//            "cntAi": 1,					//音频输入个数
//                    "cntAo": 1					//音频输出个数
//        },
//        "bIspLibSupport": false,			//是否支持图像库
//                "ispVersion": "5678",				//图像库版本
//                "bSDSupport": false,				//是否支持SD卡
//                "bJVMPSupport": false,				//是否支持JVMP
//                "bRecordSupport":false,				//是否支持设备录像
//                "bIntelligenceSupport":false,		//是否是智能摄像机（支持深度学习算法的像摄像机）
//                "bAlarmCancelSupport":false,		//是否支持手动消警
//                "bAlarmSoundPlanSupport":false,	    // 是否支持报警音计划配置
//                "bHourlyChimeSupport":false,	    //是否整点报时
//                "bSimpleRecoverySupport":false,     //是否支持简单恢复
//                "ability":[ // 设备支持的能力集
//        "osd", // osd详细的能力集通过osd_get_ability获取
//                "simpleDefence", // 一键布防
//                "driveAway", // 一键驱离
//                "YSTOldCompatibility", // 兼容YST1.0
//                "alarmEvent" // 报警事件查询
//			]
//    },
//        "error": {}
//    }



    private String method;
    private String level;
    private ParamBean param;
    private ResultBean result;
    private ErrorBean error;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
    }

    public static class ResultBean {
        private String devType;
        private String devModel;
        private String type;
        private String hardware;
        private String sn;
        private String firmware;
        private String uiVersion;
        private String temperVersion;
        private String manufacture;
        private String model;
        private String custom;
        private boolean bHomeIPC;
        private boolean bPtzSupport;
        @SerializedName("PtzFirmware")
        private int ptzFirmware;
        private boolean bAFSupport;
        private boolean bPTZPrivacySupport;
        private boolean bOnlyDirPtzSupport;
        private boolean baudiocodecSupport;
        private boolean bNVModifySupport;
        private boolean bwdrsupport;
        private boolean bDemistSupport;
        private boolean bStarSupport;
        private boolean bLDCSupport;
        private boolean brotateSupport;
        private boolean bExpSupport;
        private boolean bFaceModeSupport;
        private boolean bVlpnIrSupport;
        private boolean bWifiSupport;
        private boolean bDDNSSupport;
        private boolean bGB28181Support;
        private boolean bGB35114Support;
        private boolean bGA1400Support;
        private boolean bFTPSupport;
        private boolean bNFSSupport;
        private boolean bAlarmServiceSupport;
        private boolean bRTMPSupport;
        private boolean bFishEye;
        private boolean bImageADSupport;
        private boolean bMultiOsdSupport;
        private boolean bEightPrivacy;
        private boolean bMDGridSupport;
        private boolean bChatSupport;
        private boolean bEnableOnlineSupport;
        private int channelCnt;
        private int streamCnt;
        private String ystID;
        private boolean bRemoteDesk;
        private boolean bWebConfig;
        private boolean bDstConfigSupport;
        private boolean bMDRepelWithIVP;
        private boolean bDualLightSupport;
        private boolean bAlarmLightSupport;
        private boolean bAlarmLedSupport;
        private boolean bAlarmSoundSupport;
        @SerializedName("AlarmSoundSampleRate")
        private int alarmSoundSampleRate;
        private boolean bModBusSupport;
        private boolean bSecurityViewSupport;
        private boolean bSnapTimingSupport;
        private boolean bPDSupport;//2023.3.15 lihao 去除dev_get_hwinfo是否支持人形检测bPDSupport字段，使用bMDSupport判断是否支持移动侦测，人形检测作为移动侦测配置项的一个检测类型。
        private boolean bMDSupport;
        private boolean b4GSupport;
        private boolean bPtzAutoTraceSupport;
        private boolean bIntelligenceUpload;
        @SerializedName("WebProtocol")
        private String webProtocol;
        private boolean bSupport3DLocate;
        private boolean bSupportMTrack;
        private boolean bSupportHomeCloud;
        private boolean bSupportTimePointPlay;
        @SerializedName("RemoteChatAudioMode")
        private String remoteChatAudioMode;
        private String defChatAudioMode;
        @SerializedName("MobileQuality")
        private String mobileQuality;
        @SerializedName("IndicatorLedMode")
        private int indicatorLedMode;
        private AlarmBean alarm;
        private AudioBean audio;
        private boolean bIspLibSupport;
        private String ispVersion;
        private boolean bSDSupport;
        private boolean bJVMPSupport;
        private boolean bRecordSupport;
        private boolean bIntelligenceSupport;
        private boolean bAlarmCancelSupport;
        private boolean bAlarmSoundPlanSupport;
        private boolean bHourlyChimeSupport;
        private boolean bSimpleRecoverySupport;

//      设备支持的能力集
//      "osd", // osd详细的能力集通过osd_get_ability获取
//      "simpleDefence", // 一键布防
//      "driveAway", // 一键驱离
//      "YSTOldCompatibility" // 兼容YST1.0
//      "alarmEvent" // 报警事件查询
//      "lowPower"   //低功耗模式
//      "GunDomeLinkage"    //枪球设备能力及

        private List<String> ability;


        //获取osd详细的能力集通过osd_get_ability获取
        public boolean getAbilityOsd(){
            return getAbility("osd");
        }

        //获取一键布防能力及
        public boolean getAbilitySimpleDefence(){
            return getAbility("simpleDefence");
        }

        //获取一键驱离能力及
        public boolean getAbilityDriveAway(){
            return getAbility("driveAway");
        }

        //获取一键驱离配置能力及
        public boolean getAbilityAdDriveAway(){
            return getAbility("AdDriveAway");
        }

        //获取兼容YST1.0能力及
        public boolean getAbilityYSTOldCompatibility(){
            return getAbility("YSTOldCompatibility");
        }

        //获取低功耗模式能力及
        public boolean getAbilityLowPower(){
            return getAbility("lowPower");
        }

        //获取枪球设备能力及
        public boolean getAbilityGunDomeLinkage(){
            return getAbility("GunDomeLinkage");
        }


        public boolean getAbility(String key){
            boolean contains = false;

            if(null != ability && ability.size() > 0){
                for(int i = 0 ; i < ability.size() ;i++){
                    if(ability.get(i).equalsIgnoreCase(key)){
                        contains = true;
                        break;
                    }
                }
            }

            return contains;
        }

        public String getDevType() {
            return devType;
        }

        public void setDevType(String devType) {
            this.devType = devType;
        }

        public String getDevModel() {
            return devModel;
        }

        public void setDevModel(String devModel) {
            this.devModel = devModel;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getHardware() {
            return hardware;
        }

        public void setHardware(String hardware) {
            this.hardware = hardware;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public String getFirmware() {
            return firmware;
        }

        public void setFirmware(String firmware) {
            this.firmware = firmware;
        }

        public String getUiVersion() {
            return uiVersion;
        }

        public void setUiVersion(String uiVersion) {
            this.uiVersion = uiVersion;
        }

        public String getTemperVersion() {
            return temperVersion;
        }

        public void setTemperVersion(String temperVersion) {
            this.temperVersion = temperVersion;
        }

        public String getManufacture() {
            return manufacture;
        }

        public void setManufacture(String manufacture) {
            this.manufacture = manufacture;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getCustom() {
            return custom;
        }

        public void setCustom(String custom) {
            this.custom = custom;
        }

        public boolean isBHomeIPC() {
            return bHomeIPC;
        }

        public void setBHomeIPC(boolean bHomeIPC) {
            this.bHomeIPC = bHomeIPC;
        }

        public boolean isBPtzSupport() {
            return bPtzSupport;
        }

        public void setBPtzSupport(boolean bPtzSupport) {
            this.bPtzSupport = bPtzSupport;
        }

        public int getPtzFirmware() {
            return ptzFirmware;
        }

        public void setPtzFirmware(int ptzFirmware) {
            this.ptzFirmware = ptzFirmware;
        }

        public boolean isBAFSupport() {
            return bAFSupport;
        }

        public void setBAFSupport(boolean bAFSupport) {
            this.bAFSupport = bAFSupport;
        }

        public boolean isBPTZPrivacySupport() {
            return bPTZPrivacySupport;
        }

        public void setBPTZPrivacySupport(boolean bPTZPrivacySupport) {
            this.bPTZPrivacySupport = bPTZPrivacySupport;
        }

        public boolean isBOnlyDirPtzSupport() {
            return bOnlyDirPtzSupport;
        }

        public void setBOnlyDirPtzSupport(boolean bOnlyDirPtzSupport) {
            this.bOnlyDirPtzSupport = bOnlyDirPtzSupport;
        }

        public boolean isBaudiocodecSupport() {
            return baudiocodecSupport;
        }

        public void setBaudiocodecSupport(boolean baudiocodecSupport) {
            this.baudiocodecSupport = baudiocodecSupport;
        }

        public boolean isBNVModifySupport() {
            return bNVModifySupport;
        }

        public void setBNVModifySupport(boolean bNVModifySupport) {
            this.bNVModifySupport = bNVModifySupport;
        }

        public boolean isBwdrsupport() {
            return bwdrsupport;
        }

        public void setBwdrsupport(boolean bwdrsupport) {
            this.bwdrsupport = bwdrsupport;
        }

        public boolean isBDemistSupport() {
            return bDemistSupport;
        }

        public void setBDemistSupport(boolean bDemistSupport) {
            this.bDemistSupport = bDemistSupport;
        }

        public boolean isBStarSupport() {
            return bStarSupport;
        }

        public void setBStarSupport(boolean bStarSupport) {
            this.bStarSupport = bStarSupport;
        }

        public boolean isBLDCSupport() {
            return bLDCSupport;
        }

        public void setBLDCSupport(boolean bLDCSupport) {
            this.bLDCSupport = bLDCSupport;
        }

        public boolean isBrotateSupport() {
            return brotateSupport;
        }

        public void setBrotateSupport(boolean brotateSupport) {
            this.brotateSupport = brotateSupport;
        }

        public boolean isBExpSupport() {
            return bExpSupport;
        }

        public void setBExpSupport(boolean bExpSupport) {
            this.bExpSupport = bExpSupport;
        }

        public boolean isBFaceModeSupport() {
            return bFaceModeSupport;
        }

        public void setBFaceModeSupport(boolean bFaceModeSupport) {
            this.bFaceModeSupport = bFaceModeSupport;
        }

        public boolean isBVlpnIrSupport() {
            return bVlpnIrSupport;
        }

        public void setBVlpnIrSupport(boolean bVlpnIrSupport) {
            this.bVlpnIrSupport = bVlpnIrSupport;
        }

        public boolean isBWifiSupport() {
            return bWifiSupport;
        }

        public void setBWifiSupport(boolean bWifiSupport) {
            this.bWifiSupport = bWifiSupport;
        }

        public boolean isBDDNSSupport() {
            return bDDNSSupport;
        }

        public void setBDDNSSupport(boolean bDDNSSupport) {
            this.bDDNSSupport = bDDNSSupport;
        }

        public boolean isBGB28181Support() {
            return bGB28181Support;
        }

        public void setBGB28181Support(boolean bGB28181Support) {
            this.bGB28181Support = bGB28181Support;
        }

        public boolean isBGB35114Support() {
            return bGB35114Support;
        }

        public void setBGB35114Support(boolean bGB35114Support) {
            this.bGB35114Support = bGB35114Support;
        }

        public boolean isBGA1400Support() {
            return bGA1400Support;
        }

        public void setBGA1400Support(boolean bGA1400Support) {
            this.bGA1400Support = bGA1400Support;
        }

        public boolean isBFTPSupport() {
            return bFTPSupport;
        }

        public void setBFTPSupport(boolean bFTPSupport) {
            this.bFTPSupport = bFTPSupport;
        }

        public boolean isBNFSSupport() {
            return bNFSSupport;
        }

        public void setBNFSSupport(boolean bNFSSupport) {
            this.bNFSSupport = bNFSSupport;
        }

        public boolean isBAlarmServiceSupport() {
            return bAlarmServiceSupport;
        }

        public void setBAlarmServiceSupport(boolean bAlarmServiceSupport) {
            this.bAlarmServiceSupport = bAlarmServiceSupport;
        }

        public boolean isBRTMPSupport() {
            return bRTMPSupport;
        }

        public void setBRTMPSupport(boolean bRTMPSupport) {
            this.bRTMPSupport = bRTMPSupport;
        }

        public boolean isBFishEye() {
            return bFishEye;
        }

        public void setBFishEye(boolean bFishEye) {
            this.bFishEye = bFishEye;
        }

        public boolean isBImageADSupport() {
            return bImageADSupport;
        }

        public void setBImageADSupport(boolean bImageADSupport) {
            this.bImageADSupport = bImageADSupport;
        }

        public boolean isBMultiOsdSupport() {
            return bMultiOsdSupport;
        }

        public void setBMultiOsdSupport(boolean bMultiOsdSupport) {
            this.bMultiOsdSupport = bMultiOsdSupport;
        }

        public boolean isBEightPrivacy() {
            return bEightPrivacy;
        }

        public void setBEightPrivacy(boolean bEightPrivacy) {
            this.bEightPrivacy = bEightPrivacy;
        }

        public boolean isBMDGridSupport() {
            return bMDGridSupport;
        }

        public void setBMDGridSupport(boolean bMDGridSupport) {
            this.bMDGridSupport = bMDGridSupport;
        }

        public boolean isBChatSupport() {
            return bChatSupport;
        }

        public void setBChatSupport(boolean bChatSupport) {
            this.bChatSupport = bChatSupport;
        }

        public boolean isBEnableOnlineSupport() {
            return bEnableOnlineSupport;
        }

        public void setBEnableOnlineSupport(boolean bEnableOnlineSupport) {
            this.bEnableOnlineSupport = bEnableOnlineSupport;
        }

        public int getChannelCnt() {
            return channelCnt;
        }

        public void setChannelCnt(int channelCnt) {
            this.channelCnt = channelCnt;
        }

        public int getStreamCnt() {
            return streamCnt;
        }

        public void setStreamCnt(int streamCnt) {
            this.streamCnt = streamCnt;
        }

        public String getYstID() {
            return ystID;
        }

        public void setYstID(String ystID) {
            this.ystID = ystID;
        }

        public boolean isBRemoteDesk() {
            return bRemoteDesk;
        }

        public void setBRemoteDesk(boolean bRemoteDesk) {
            this.bRemoteDesk = bRemoteDesk;
        }

        public boolean isBWebConfig() {
            return bWebConfig;
        }

        public void setBWebConfig(boolean bWebConfig) {
            this.bWebConfig = bWebConfig;
        }

        public boolean isBDstConfigSupport() {
            return bDstConfigSupport;
        }

        public void setBDstConfigSupport(boolean bDstConfigSupport) {
            this.bDstConfigSupport = bDstConfigSupport;
        }

        public boolean isBMDRepelWithIVP() {
            return bMDRepelWithIVP;
        }

        public void setBMDRepelWithIVP(boolean bMDRepelWithIVP) {
            this.bMDRepelWithIVP = bMDRepelWithIVP;
        }

        public boolean isBDualLightSupport() {
            return bDualLightSupport;
        }

        public void setBDualLightSupport(boolean bDualLightSupport) {
            this.bDualLightSupport = bDualLightSupport;
        }

        public boolean isBAlarmLightSupport() {
            return bAlarmLightSupport;
        }

        public void setBAlarmLightSupport(boolean bAlarmLightSupport) {
            this.bAlarmLightSupport = bAlarmLightSupport;
        }

        public boolean isBAlarmLedSupport() {
            return bAlarmLedSupport;
        }

        public void setBAlarmLedSupport(boolean bAlarmLedSupport) {
            this.bAlarmLedSupport = bAlarmLedSupport;
        }

        public boolean isBAlarmSoundSupport() {
            return bAlarmSoundSupport;
        }

        public void setBAlarmSoundSupport(boolean bAlarmSoundSupport) {
            this.bAlarmSoundSupport = bAlarmSoundSupport;
        }

        public int getAlarmSoundSampleRate() {
            return alarmSoundSampleRate;
        }

        public void setAlarmSoundSampleRate(int alarmSoundSampleRate) {
            this.alarmSoundSampleRate = alarmSoundSampleRate;
        }

        public boolean isBModBusSupport() {
            return bModBusSupport;
        }

        public void setBModBusSupport(boolean bModBusSupport) {
            this.bModBusSupport = bModBusSupport;
        }

        public boolean isBSecurityViewSupport() {
            return bSecurityViewSupport;
        }

        public void setBSecurityViewSupport(boolean bSecurityViewSupport) {
            this.bSecurityViewSupport = bSecurityViewSupport;
        }

        public boolean isBSnapTimingSupport() {
            return bSnapTimingSupport;
        }

        public void setBSnapTimingSupport(boolean bSnapTimingSupport) {
            this.bSnapTimingSupport = bSnapTimingSupport;
        }

        public boolean isBPDSupport() {
            return bPDSupport;
        }

        public void setBPDSupport(boolean bPDSupport) {
            this.bPDSupport = bPDSupport;
        }

        public boolean isBMDSupport() {
            return bMDSupport;
        }

        public void setBMDSupport(boolean bMDSupport) {
            this.bMDSupport = bMDSupport;
        }

        public boolean isB4GSupport() {
            return b4GSupport;
        }

        public void setB4GSupport(boolean b4GSupport) {
            this.b4GSupport = b4GSupport;
        }

        public boolean isBPtzAutoTraceSupport() {
            return bPtzAutoTraceSupport;
        }

        public void setBPtzAutoTraceSupport(boolean bPtzAutoTraceSupport) {
            this.bPtzAutoTraceSupport = bPtzAutoTraceSupport;
        }

        public boolean isBIntelligenceUpload() {
            return bIntelligenceUpload;
        }

        public void setBIntelligenceUpload(boolean bIntelligenceUpload) {
            this.bIntelligenceUpload = bIntelligenceUpload;
        }

        public String getWebProtocol() {
            return webProtocol;
        }

        public void setWebProtocol(String webProtocol) {
            this.webProtocol = webProtocol;
        }

        public boolean isBSupport3DLocate() {
            return bSupport3DLocate;
        }

        public void setBSupport3DLocate(boolean bSupport3DLocate) {
            this.bSupport3DLocate = bSupport3DLocate;
        }

        public boolean isBSupportMTrack() {
            return bSupportMTrack;
        }

        public void setBSupportMTrack(boolean bSupportMTrack) {
            this.bSupportMTrack = bSupportMTrack;
        }

        public boolean isBSupportHomeCloud() {
            return bSupportHomeCloud;
        }

        public void setBSupportHomeCloud(boolean bSupportHomeCloud) {
            this.bSupportHomeCloud = bSupportHomeCloud;
        }

        public boolean isBSupportTimePointPlay() {
            return bSupportTimePointPlay;
        }

        public void setBSupportTimePointPlay(boolean bSupportTimePointPlay) {
            this.bSupportTimePointPlay = bSupportTimePointPlay;
        }

        public String getRemoteChatAudioMode() {
            return remoteChatAudioMode;
        }

        public void setRemoteChatAudioMode(String remoteChatAudioMode) {
            this.remoteChatAudioMode = remoteChatAudioMode;
        }

        public String getDefChatAudioMode() {
            return defChatAudioMode;
        }

        public void setDefChatAudioMode(String defChatAudioMode) {
            this.defChatAudioMode = defChatAudioMode;
        }

        public String getMobileQuality() {
            return mobileQuality;
        }

        public void setMobileQuality(String mobileQuality) {
            this.mobileQuality = mobileQuality;
        }

        public int getIndicatorLedMode() {
            return indicatorLedMode;
        }

        public void setIndicatorLedMode(int indicatorLedMode) {
            this.indicatorLedMode = indicatorLedMode;
        }

        public AlarmBean getAlarm() {
            return alarm;
        }

        public void setAlarm(AlarmBean alarm) {
            this.alarm = alarm;
        }

        public AudioBean getAudio() {
            return audio;
        }

        public void setAudio(AudioBean audio) {
            this.audio = audio;
        }

        public boolean isBIspLibSupport() {
            return bIspLibSupport;
        }

        public void setBIspLibSupport(boolean bIspLibSupport) {
            this.bIspLibSupport = bIspLibSupport;
        }

        public String getIspVersion() {
            return ispVersion;
        }

        public void setIspVersion(String ispVersion) {
            this.ispVersion = ispVersion;
        }

        public boolean isBSDSupport() {
            return bSDSupport;
        }

        public void setBSDSupport(boolean bSDSupport) {
            this.bSDSupport = bSDSupport;
        }

        public boolean isBJVMPSupport() {
            return bJVMPSupport;
        }

        public void setBJVMPSupport(boolean bJVMPSupport) {
            this.bJVMPSupport = bJVMPSupport;
        }

        public boolean isBRecordSupport() {
            return bRecordSupport;
        }

        public void setBRecordSupport(boolean bRecordSupport) {
            this.bRecordSupport = bRecordSupport;
        }

        public boolean isBIntelligenceSupport() {
            return bIntelligenceSupport;
        }

        public void setBIntelligenceSupport(boolean bIntelligenceSupport) {
            this.bIntelligenceSupport = bIntelligenceSupport;
        }

        public boolean isBAlarmCancelSupport() {
            return bAlarmCancelSupport;
        }

        public void setBAlarmCancelSupport(boolean bAlarmCancelSupport) {
            this.bAlarmCancelSupport = bAlarmCancelSupport;
        }

        public boolean isBAlarmSoundPlanSupport() {
            return bAlarmSoundPlanSupport;
        }

        public void setBAlarmSoundPlanSupport(boolean bAlarmSoundPlanSupport) {
            this.bAlarmSoundPlanSupport = bAlarmSoundPlanSupport;
        }

        public boolean isBHourlyChimeSupport() {
            return bHourlyChimeSupport;
        }

        public void setBHourlyChimeSupport(boolean bHourlyChimeSupport) {
            this.bHourlyChimeSupport = bHourlyChimeSupport;
        }

        public boolean isBSimpleRecoverySupport() {
            return bSimpleRecoverySupport;
        }

        public void setBSimpleRecoverySupport(boolean bSimpleRecoverySupport) {
            this.bSimpleRecoverySupport = bSimpleRecoverySupport;
        }

        public List<String> getAbility() {
            return ability;
        }

        public void setAbility(List<String> ability) {
            this.ability = ability;
        }

        public static class AlarmBean {
            private String type;
            private int cntAlmGroup;
            private int cntAlmin_perGroup;
            private int cntAlmout;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getCntAlmGroup() {
                return cntAlmGroup;
            }

            public void setCntAlmGroup(int cntAlmGroup) {
                this.cntAlmGroup = cntAlmGroup;
            }

            public int getCntAlmin_perGroup() {
                return cntAlmin_perGroup;
            }

            public void setCntAlmin_perGroup(int cntAlmin_perGroup) {
                this.cntAlmin_perGroup = cntAlmin_perGroup;
            }

            public int getCntAlmout() {
                return cntAlmout;
            }

            public void setCntAlmout(int cntAlmout) {
                this.cntAlmout = cntAlmout;
            }
        }

        public static class AudioBean {
            private int cntAi;
            private int cntAo;

            public int getCntAi() {
                return cntAi;
            }

            public void setCntAi(int cntAi) {
                this.cntAi = cntAi;
            }

            public int getCntAo() {
                return cntAo;
            }

            public void setCntAo(int cntAo) {
                this.cntAo = cntAo;
            }
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












//    /**
//     * method : dev_get_hwinfo
//     * user : {"name":"admin","digest":"1884d2bbc9488a395d0f1b8414e6f244"}
//     * result : {"type":"H6D-S-50","hardware":"NVT-HI3516DS-IVPQD-V20","sn":"14383","firmware":"V2.2.5847 - 20181025 15:33:19","uiVersion":"V2.0","manufacture":"JOVISION","model":"JOVISION-IPC","bPtzSupport":true,"bAFSupport":false,"baudiocodecSupport":false,"bNVModifySupport":false,"bwdrsupport":true,"bDemistSupport":false,"bStarSupport":false,"bLDCSupport":false,"brotateSupport":true,"bExpSupport":false,"bFaceModeSupport":true,"bVlpnIrSupport":false,"bWifiSupport":false,"bDDNSSupport":true,"bGB28181Support":true,"bFTPSupport":false,"bNFSSupport":false,"bAlarmServiceSupport":false,"bFishEye":false,"bImageADSupport":false,"bMultiOsdSupport":true,"bEightPrivacy":true,"bMDGridSupport":false,"bChatSupport":false,"bEnableOnlineSupport":false,"channelCnt":1,"streamCnt":3,"ystID":"12221SSSE1FF","bRemoteDesk":false,"bWebConfig":true,"bDstConfigSupport":false,"bMDRepelWithIVP":false,"bDualLightSupport":false,"bModBusSupport":false,"alarm":{"type":"buildin","cntAlmGroup":1,"cntAlmin_perGroup":0,"cntAlmout":0},"audio":{"cntAi":1,"cntAo":0},"bIspLibSupport":true,"ispVersion":"H6D-1.4.6097"}
//     * error : {"errorcode":0}
//     */
//
//    private String method;
////    private UserBean user;
//    private ResultBean result;
//    private ErrorBean error;
//
//    public String getMethod() {
//        return method;
//    }
//
//    public void setMethod(String method) {
//        this.method = method;
//    }
//
////    public UserBean getUser() {
////        return user;
////    }
////
////    public void setUser(UserBean user) {
////        this.user = user;
////    }
//
//    public ResultBean getResult() {
//        return result;
//    }
//
//    public void setResult(ResultBean result) {
//        this.result = result;
//    }
//
//    public ErrorBean getError() {
//        return error;
//    }
//
//    public void setError(ErrorBean error) {
//        this.error = error;
//    }
//
//    public static class UserBean {
//        /**
//         * name : admin
//         * digest : 1884d2bbc9488a395d0f1b8414e6f244
//         */
//
//        private String name;
//        private String digest;
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getDigest() {
//            return digest;
//        }
//
//        public void setDigest(String digest) {
//            this.digest = digest;
//        }
//    }
//
//    public static class ResultBean {
//        /**
//         * type : H6D-S-50
//         * hardware : NVT-HI3516DS-IVPQD-V20
//         * sn : 14383
//         * firmware : V2.2.5847 - 20181025 15:33:19
//         * uiVersion : V2.0
//         * manufacture : JOVISION
//         * model : JOVISION-IPC
//         * bPtzSupport : true
//         * bAFSupport : false
//         * baudiocodecSupport : false
//         * bNVModifySupport : false
//         * bwdrsupport : true
//         * bDemistSupport : false
//         * bStarSupport : false
//         * bLDCSupport : false
//         * brotateSupport : true
//         * bExpSupport : false
//         * bFaceModeSupport : true
//         * bVlpnIrSupport : false
//         * bWifiSupport : false
//         * bDDNSSupport : true
//         * bGB28181Support : true
//         * bFTPSupport : false
//         * bNFSSupport : false
//         * bAlarmServiceSupport : false
//         * bFishEye : false
//         * bImageADSupport : false
//         * bMultiOsdSupport : true
//         * bEightPrivacy : true
//         * bMDGridSupport : false
//         * bChatSupport : false
//         * bEnableOnlineSupport : false
//         * channelCnt : 1
//         * streamCnt : 3
//         * ystID : 12221SSSE1FF
//         * bRemoteDesk : false
//         * bWebConfig : true
//         * bDstConfigSupport : false
//         * bMDRepelWithIVP : false
//         * bDualLightSupport : false
//         * bModBusSupport : false
//         * alarm : {"type":"buildin","cntAlmGroup":1,"cntAlmin_perGroup":0,"cntAlmout":0}
//         * audio : {"cntAi":1,"cntAo":0}
//         * bIspLibSupport : true
//         * ispVersion : H6D-1.4.6097
//         */
//
//        private String type;
//        private String hardware;
//        private String sn;
//        private String firmware;
//        private String uiVersion;
//        private String manufacture;
//        private String model;
//        private boolean bPtzSupport;
//        private boolean bAFSupport;
//        private boolean baudiocodecSupport;
//        private boolean bNVModifySupport;
//        private boolean bwdrsupport;
//        private boolean bDemistSupport;
//        private boolean bStarSupport;
//        private boolean bLDCSupport;
//        private boolean brotateSupport;
//        private boolean bExpSupport;
//        private boolean bFaceModeSupport;
//        private boolean bVlpnIrSupport;
//        private boolean bWifiSupport;//2020.2.25 juyang 是否无线设备，true无线设备（不支持修改设备ip），false非无线设备（支持修改设备ip）
//        private boolean bDDNSSupport;
//        private boolean bGB28181Support;
//        private boolean bFTPSupport;
//        private boolean bNFSSupport;
//        private boolean bAlarmServiceSupport;
//        private boolean bFishEye;
//        private boolean bImageADSupport;
//        private boolean bMultiOsdSupport;
//        private boolean bEightPrivacy;
//        private boolean bMDGridSupport;
//        private boolean bChatSupport;
//        private boolean bEnableOnlineSupport;
//        private int channelCnt;
//        private int streamCnt;
//        private String ystID;
//        private boolean bRemoteDesk;
//        private boolean bWebConfig;
//        private boolean bDstConfigSupport;
//        private boolean bMDRepelWithIVP;
//        private boolean bDualLightSupport;
//        private boolean bHideLightMode;//true：隐藏夜间全彩 false：支持夜间全彩
//        private boolean bSupportPrivacyHide;//true：支持隐私遮蔽 false：不支持隐私遮蔽
//        private boolean bModBusSupport;
//        private boolean bSupportMTrack;//是否支持移动追踪
//        private boolean bSupportSmartMotionTrack;//是否支持人形跟踪
//        private boolean bSupport3DLocate;//是否3d Touch
//        private AlarmBean alarm;
//        private AudioBean audio;
//        private boolean bIspLibSupport;
//        private String ispVersion;
//        private int IndicatorLedMode;
//        private boolean bSupportHomeCloud;
//        private boolean bLedSupport;
//        private boolean bAlarmSoundSupport; // 是否支持选择自定义报警音，老设备没有
//        private boolean bAlarmWeekSupport; // 是否支持报警时间段星期设置，新版本时间段可以选择执行时间，为false的按老版本处理
//        private boolean bSupportSmartMotionDetection; // 是否支持人形检测
//        private boolean bSupportSetSoundfilelevel; // 是否支持设置音频文件音量
//        private boolean bSupportTimePointPlay; // 是否支持精准回放
//        private String RemoteChatAudioMode; // 对讲模式;支持的对讲模式，单向：ONE_WAY 双向：TWO_WAY 单双向都支持：BOTH_MODE 不支持：NO_WAY
//        private String defChatAudioMode;//单双向对讲模式的设备，默认的对讲模式
//        private int AlarmSoundSampleRate;//自定义报警音采样率,取不到用16k采样率
//        private boolean bSnapTimingSupport;//是否支持新版的图片抓拍和预览
//        private boolean bPtzAutoTraceSupport;//2019.12.7 juyang 增加是否支持人形目标跟踪
//        private boolean bAlarmLightSupport;//2019.8.21 wangjie bAlarmLightSupport 用于判断是否支持白光灯报警，手机端需要处理下这个字段，可以与bDualLightSupport 这个双光源字段一起判断，有一个支持就显示移动侦测里白光的的报警联动
//
//        private boolean bHourlyChimeSupport;//2022.11.1 用于判断是否支持整点报时
//        private boolean bAlarmSoundPlanSupport;//2022.11.1 用于判断是否支持报警音计划配置
//        private boolean bSimpleRecoverySupport;//2022.11.15 用于判断是否支持简单恢复
//
//
//
//        public boolean isB8KAacSampleRate() {
//            return b8KAacSampleRate;
//        }
//
//        public void setB8KAacSampleRate(boolean b8KAacSampleRate) {
//            this.b8KAacSampleRate = b8KAacSampleRate;
//        }
//
//        private boolean b8KAacSampleRate;//自定义报警言使用8K采样率（16EV200 使用16K采样率录像存在问题）
//
//
//        public boolean isBLedSupport() {
//            return bLedSupport;
//        }
//
//        public void setBLedSupport(boolean bLedSupport) {
//            this.bLedSupport = bLedSupport;
//        }
//
//        public boolean isBSupportHomeCloud() {
//            return bSupportHomeCloud;
//        }
//
//        public void setBSupportHomeCloud(boolean bSupportHomeCloud) {
//            this.bSupportHomeCloud = bSupportHomeCloud;
//        }
//
//
//        public int getIndicatorLedMode() {
//            return IndicatorLedMode;
//        }
//
//        public void setIndicatorLedMode(int indicatorLedMode) {
//            IndicatorLedMode = indicatorLedMode;
//        }
//
//        public String getType() {
//            return type;
//        }
//
//        public void setType(String type) {
//            this.type = type;
//        }
//
//        public String getHardware() {
//            return hardware;
//        }
//
//        public void setHardware(String hardware) {
//            this.hardware = hardware;
//        }
//
//        public String getSn() {
//            return sn;
//        }
//
//        public void setSn(String sn) {
//            this.sn = sn;
//        }
//
//        public String getFirmware() {
//            return firmware;
//        }
//
//        public void setFirmware(String firmware) {
//            this.firmware = firmware;
//        }
//
//        public String getUiVersion() {
//            return uiVersion;
//        }
//
//        public void setUiVersion(String uiVersion) {
//            this.uiVersion = uiVersion;
//        }
//
//        public String getManufacture() {
//            return manufacture;
//        }
//
//        public void setManufacture(String manufacture) {
//            this.manufacture = manufacture;
//        }
//
//        public String getModel() {
//            return model;
//        }
//
//        public void setModel(String model) {
//            this.model = model;
//        }
//
//        public boolean isBPtzSupport() {
//            return bPtzSupport;
//        }
//
//        public void setBPtzSupport(boolean bPtzSupport) {
//            this.bPtzSupport = bPtzSupport;
//        }
//
//        public boolean isBAFSupport() {
//            return bAFSupport;
//        }
//
//        public void setBAFSupport(boolean bAFSupport) {
//            this.bAFSupport = bAFSupport;
//        }
//
//        public boolean isBaudiocodecSupport() {
//            return baudiocodecSupport;
//        }
//
//        public void setBaudiocodecSupport(boolean baudiocodecSupport) {
//            this.baudiocodecSupport = baudiocodecSupport;
//        }
//
//        public boolean isBNVModifySupport() {
//            return bNVModifySupport;
//        }
//
//        public void setBNVModifySupport(boolean bNVModifySupport) {
//            this.bNVModifySupport = bNVModifySupport;
//        }
//
//        public boolean isBwdrsupport() {
//            return bwdrsupport;
//        }
//
//        public void setBwdrsupport(boolean bwdrsupport) {
//            this.bwdrsupport = bwdrsupport;
//        }
//
//        public boolean isBDemistSupport() {
//            return bDemistSupport;
//        }
//
//        public void setBDemistSupport(boolean bDemistSupport) {
//            this.bDemistSupport = bDemistSupport;
//        }
//
//        public boolean isBStarSupport() {
//            return bStarSupport;
//        }
//
//        public void setBStarSupport(boolean bStarSupport) {
//            this.bStarSupport = bStarSupport;
//        }
//
//        public boolean isBLDCSupport() {
//            return bLDCSupport;
//        }
//
//        public void setBLDCSupport(boolean bLDCSupport) {
//            this.bLDCSupport = bLDCSupport;
//        }
//
//        public boolean isBrotateSupport() {
//            return brotateSupport;
//        }
//
//        public void setBrotateSupport(boolean brotateSupport) {
//            this.brotateSupport = brotateSupport;
//        }
//
//        public boolean isBExpSupport() {
//            return bExpSupport;
//        }
//
//        public void setBExpSupport(boolean bExpSupport) {
//            this.bExpSupport = bExpSupport;
//        }
//
//        public boolean isBFaceModeSupport() {
//            return bFaceModeSupport;
//        }
//
//        public void setBFaceModeSupport(boolean bFaceModeSupport) {
//            this.bFaceModeSupport = bFaceModeSupport;
//        }
//
//        public boolean isBVlpnIrSupport() {
//            return bVlpnIrSupport;
//        }
//
//        public void setBVlpnIrSupport(boolean bVlpnIrSupport) {
//            this.bVlpnIrSupport = bVlpnIrSupport;
//        }
//
//        public boolean isBWifiSupport() {
//            return bWifiSupport;
//        }
//
//        public void setBWifiSupport(boolean bWifiSupport) {
//            this.bWifiSupport = bWifiSupport;
//        }
//
//        public boolean isBDDNSSupport() {
//            return bDDNSSupport;
//        }
//
//        public void setBDDNSSupport(boolean bDDNSSupport) {
//            this.bDDNSSupport = bDDNSSupport;
//        }
//
//        public boolean isBGB28181Support() {
//            return bGB28181Support;
//        }
//
//        public void setBGB28181Support(boolean bGB28181Support) {
//            this.bGB28181Support = bGB28181Support;
//        }
//
//        public boolean isBFTPSupport() {
//            return bFTPSupport;
//        }
//
//        public void setBFTPSupport(boolean bFTPSupport) {
//            this.bFTPSupport = bFTPSupport;
//        }
//
//        public boolean isBNFSSupport() {
//            return bNFSSupport;
//        }
//
//        public void setBNFSSupport(boolean bNFSSupport) {
//            this.bNFSSupport = bNFSSupport;
//        }
//
//        public boolean isBAlarmServiceSupport() {
//            return bAlarmServiceSupport;
//        }
//
//        public void setBAlarmServiceSupport(boolean bAlarmServiceSupport) {
//            this.bAlarmServiceSupport = bAlarmServiceSupport;
//        }
//
//        public boolean isBFishEye() {
//            return bFishEye;
//        }
//
//        public void setBFishEye(boolean bFishEye) {
//            this.bFishEye = bFishEye;
//        }
//
//        public boolean isBImageADSupport() {
//            return bImageADSupport;
//        }
//
//        public void setBImageADSupport(boolean bImageADSupport) {
//            this.bImageADSupport = bImageADSupport;
//        }
//
//        public boolean isBMultiOsdSupport() {
//            return bMultiOsdSupport;
//        }
//
//        public void setBMultiOsdSupport(boolean bMultiOsdSupport) {
//            this.bMultiOsdSupport = bMultiOsdSupport;
//        }
//
//        public boolean isBEightPrivacy() {
//            return bEightPrivacy;
//        }
//
//        public void setBEightPrivacy(boolean bEightPrivacy) {
//            this.bEightPrivacy = bEightPrivacy;
//        }
//
//        public boolean isBMDGridSupport() {
//            return bMDGridSupport;
//        }
//
//        public void setBMDGridSupport(boolean bMDGridSupport) {
//            this.bMDGridSupport = bMDGridSupport;
//        }
//
//        public boolean isBChatSupport() {
//            return bChatSupport;
//        }
//
//        public void setBChatSupport(boolean bChatSupport) {
//            this.bChatSupport = bChatSupport;
//        }
//
//        public boolean isBEnableOnlineSupport() {
//            return bEnableOnlineSupport;
//        }
//
//        public void setBEnableOnlineSupport(boolean bEnableOnlineSupport) {
//            this.bEnableOnlineSupport = bEnableOnlineSupport;
//        }
//
//        public int getChannelCnt() {
//            return channelCnt;
//        }
//
//        public void setChannelCnt(int channelCnt) {
//            this.channelCnt = channelCnt;
//        }
//
//        public int getStreamCnt() {
//            return streamCnt;
//        }
//
//        public void setStreamCnt(int streamCnt) {
//            this.streamCnt = streamCnt;
//        }
//
//        public String getYstID() {
//            return ystID;
//        }
//
//        public void setYstID(String ystID) {
//            this.ystID = ystID;
//        }
//
//        public boolean isBRemoteDesk() {
//            return bRemoteDesk;
//        }
//
//        public void setBRemoteDesk(boolean bRemoteDesk) {
//            this.bRemoteDesk = bRemoteDesk;
//        }
//
//        public boolean isBWebConfig() {
//            return bWebConfig;
//        }
//
//        public void setBWebConfig(boolean bWebConfig) {
//            this.bWebConfig = bWebConfig;
//        }
//
//        public boolean isBDstConfigSupport() {
//            return bDstConfigSupport;
//        }
//
//        public void setBDstConfigSupport(boolean bDstConfigSupport) {
//            this.bDstConfigSupport = bDstConfigSupport;
//        }
//
//        public boolean isBMDRepelWithIVP() {
//            return bMDRepelWithIVP;
//        }
//
//        public void setBMDRepelWithIVP(boolean bMDRepelWithIVP) {
//            this.bMDRepelWithIVP = bMDRepelWithIVP;
//        }
//
//        public boolean isBDualLightSupport() {
//            return bDualLightSupport;
//        }
//
//        public void setBDualLightSupport(boolean bDualLightSupport) {
//            this.bDualLightSupport = bDualLightSupport;
//        }
//
//        public boolean isBModBusSupport() {
//            return bModBusSupport;
//        }
//
//        public void setBModBusSupport(boolean bModBusSupport) {
//            this.bModBusSupport = bModBusSupport;
//        }
//
//        public AlarmBean getAlarm() {
//            return alarm;
//        }
//
//        public void setAlarm(AlarmBean alarm) {
//            this.alarm = alarm;
//        }
//
//        public AudioBean getAudio() {
//            return audio;
//        }
//
//        public void setAudio(AudioBean audio) {
//            this.audio = audio;
//        }
//
//        public boolean isBIspLibSupport() {
//            return bIspLibSupport;
//        }
//
//        public void setBIspLibSupport(boolean bIspLibSupport) {
//            this.bIspLibSupport = bIspLibSupport;
//        }
//
//        public String getIspVersion() {
//            return ispVersion;
//        }
//
//        public void setIspVersion(String ispVersion) {
//            this.ispVersion = ispVersion;
//        }
//
//        public boolean isbSupportMTrack() {
//            return bSupportMTrack;
//        }
//
//        public void setbSupportMTrack(boolean bSupportMTrack) {
//            this.bSupportMTrack = bSupportMTrack;
//        }
//
//        public boolean isbAlarmSoundSupport() {
//            return bAlarmSoundSupport;
//        }
//
//        public void setbAlarmSoundSupport(boolean bAlarmSoundSupport) {
//            this.bAlarmSoundSupport = bAlarmSoundSupport;
//        }
//
//        public boolean isbAlarmWeekSupport() {
//            return bAlarmWeekSupport;
//        }
//
//        public void setbAlarmWeekSupport(boolean bAlarmWeekSupport) {
//            this.bAlarmWeekSupport = bAlarmWeekSupport;
//        }
//
//        public boolean isbHideLightMode() {
//            return bHideLightMode;
//        }
//
//        public void setbHideLightMode(boolean bHideLightMode) {
//            this.bHideLightMode = bHideLightMode;
//        }
//
//        public boolean isbSupportPrivacyHide() {
//            return bSupportPrivacyHide;
//        }
//
//        public void setbSupportPrivacyHide(boolean bSupportPrivacyHide) {
//            this.bSupportPrivacyHide = bSupportPrivacyHide;
//        }
//
//        public boolean isbSupportSmartMotionDetection() {
//            return bSupportSmartMotionDetection;
//        }
//
//        public void setbSupportSmartMotionDetection(boolean bSupportSmartMotionDetection) {
//            this.bSupportSmartMotionDetection = bSupportSmartMotionDetection;
//        }
//
//        public boolean isbSupportSetSoundfilelevel() {
//            return bSupportSetSoundfilelevel;
//        }
//
//        public void setbSupportSetSoundfilelevel(boolean bSupportSetSoundfilelevel) {
//            this.bSupportSetSoundfilelevel = bSupportSetSoundfilelevel;
//        }
//
//        public boolean isbSupportSmartMotionTrack() {
//            return bSupportSmartMotionTrack;
//        }
//
//        public void setbSupportSmartMotionTrack(boolean bSupportSmartMotionTrack) {
//            this.bSupportSmartMotionTrack = bSupportSmartMotionTrack;
//        }
//
//        public boolean isbSupport3DLocate() {
//            return bSupport3DLocate;
//        }
//
//        public void setbSupport3DLocate(boolean bSupport3DLocate) {
//            this.bSupport3DLocate = bSupport3DLocate;
//        }
//
//        public boolean isbSupportTimePointPlay() {
//            return bSupportTimePointPlay;
//        }
//
//        public void setbSupportTimePointPlay(boolean bSupportTimePointPlay) {
//            this.bSupportTimePointPlay = bSupportTimePointPlay;
//        }
//
//        public String getRemoteChatAudioMode() {
//            return RemoteChatAudioMode;
//        }
//
//        public void setRemoteChatAudioMode(String remoteChatAudioMode) {
//            RemoteChatAudioMode = remoteChatAudioMode;
//        }
//
//        public int getAlarmSoundSampleRate() {
//            return AlarmSoundSampleRate;
//        }
//
//        public void setAlarmSoundSampleRate(int alarmSoundSampleRate) {
//            AlarmSoundSampleRate = alarmSoundSampleRate;
//        }
//
//        public boolean isbSnapTimingSupport() {
//            return bSnapTimingSupport;
//        }
//
//        public void setbSnapTimingSupport(boolean bSnapTimingSupport) {
//            this.bSnapTimingSupport = bSnapTimingSupport;
//        }
//
//        public boolean isbPtzAutoTraceSupport() {
//            return bPtzAutoTraceSupport;
//        }
//
//        public void setbPtzAutoTraceSupport(boolean bPtzAutoTraceSupport) {
//            this.bPtzAutoTraceSupport = bPtzAutoTraceSupport;
//        }
//
//        public boolean isbAlarmLightSupport() {
//            return bAlarmLightSupport;
//        }
//
//        public void setbAlarmLightSupport(boolean bAlarmLightSupport) {
//            this.bAlarmLightSupport = bAlarmLightSupport;
//        }
//
//        public boolean isbHourlyChimeSupport() {
//            return bHourlyChimeSupport;
//        }
//
//        public void setbHourlyChimeSupport(boolean bHourlyChimeSupport) {
//            this.bHourlyChimeSupport = bHourlyChimeSupport;
//        }
//
//        public boolean isbAlarmSoundPlanSupport() {
//            return bAlarmSoundPlanSupport;
//        }
//
//        public void setbAlarmSoundPlanSupport(boolean bAlarmSoundPlanSupport) {
//            this.bAlarmSoundPlanSupport = bAlarmSoundPlanSupport;
//        }
//
//        public boolean isbSimpleRecoverySupport() {
//            return bSimpleRecoverySupport;
//        }
//
//        public void setbSimpleRecoverySupport(boolean bSimpleRecoverySupport) {
//            this.bSimpleRecoverySupport = bSimpleRecoverySupport;
//        }
//
//        public String getDefChatAudioMode() {
//            return defChatAudioMode;
//        }
//
//        public void setDefChatAudioMode(String defChatAudioMode) {
//            this.defChatAudioMode = defChatAudioMode;
//        }
//
//        public static class AlarmBean {
//            /**
//             * type : buildin
//             * cntAlmGroup : 1
//             * cntAlmin_perGroup : 0
//             * cntAlmout : 0
//             */
//
//            private String type;
//            private int cntAlmGroup;
//            private int cntAlmin_perGroup;
//            private int cntAlmout;
//
//            public String getType() {
//                return type;
//            }
//
//            public void setType(String type) {
//                this.type = type;
//            }
//
//            public int getCntAlmGroup() {
//                return cntAlmGroup;
//            }
//
//            public void setCntAlmGroup(int cntAlmGroup) {
//                this.cntAlmGroup = cntAlmGroup;
//            }
//
//            public int getCntAlmin_perGroup() {
//                return cntAlmin_perGroup;
//            }
//
//            public void setCntAlmin_perGroup(int cntAlmin_perGroup) {
//                this.cntAlmin_perGroup = cntAlmin_perGroup;
//            }
//
//            public int getCntAlmout() {
//                return cntAlmout;
//            }
//
//            public void setCntAlmout(int cntAlmout) {
//                this.cntAlmout = cntAlmout;
//            }
//        }
//
//        public static class AudioBean {
//            /**
//             * cntAi : 1
//             * cntAo : 0
//             */
//
//            private int cntAi;
//            private int cntAo;
//
//            public int getCntAi() {
//                return cntAi;
//            }
//
//            public void setCntAi(int cntAi) {
//                this.cntAi = cntAi;
//            }
//
//            public int getCntAo() {
//                return cntAo;
//            }
//
//            public void setCntAo(int cntAo) {
//                this.cntAo = cntAo;
//            }
//        }
//    }
//
//    public static class ErrorBean {
//        /**
//         * errorcode : 0
//         */
//
//        private int errorcode;
//
//        public int getErrorcode() {
//            return errorcode;
//        }
//
//        public void setErrorcode(int errorcode) {
//            this.errorcode = errorcode;
//        }
//    }

}
