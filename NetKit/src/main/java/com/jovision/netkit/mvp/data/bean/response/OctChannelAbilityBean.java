package com.jovision.netkit.mvp.data.bean.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// 获取通道能力
public class OctChannelAbilityBean {


    //    {    // 获取通道能力
//        "method":"channels_features_get",
//            "level":"Operator",
//            "param":{
//        "channelid":0 // -1：获取所有视频通道，>=0：获取某个视频通道
//    },
//        "result":{
//        "all": [{
//            "channelid":0,                 // 通道号
//                    "channelLabel":
//            "Wide angle",                    //通道标签:Wide angle(全景通道)/Close up(特写通道),当设备为中文时会传出对于的中文翻译
//                    "bPtzSupport":true,            // 是否支持云台
//                    "bAFSupport":false,            // 是否支持自动聚焦
//                    "baudiocodecSupport":true,     // 硬件上是否支持音频codec功能，AUDIO IN
//                    "bNVModifySupport":true,       // 是否支持夜视优化
//                    "bwdrsupport":true,            // 是否支持宽动态
//                    "bDemistSupport":true,         // 是否支持去雾
//                    "bStarSupport":true,           // 是否支持星光级
//                    "bLDCSupport":true,            // 是否支持畸变校正功能
//                    "brotateSupport":true,         // 是否支持旋转
//                    "bExpSupport":true,            // 是否支持夜视亮度和夜视切换时刻滑块
//                    "bFaceModeSupport":true,       // 是否支持人脸模式
//                    "bVlpnIrSupport":false,        // 是否支持红外灯下看清车牌
//                    "bWifiSupport":true,           // 是否支持无线连接
//                    "bDDNSSupport":true,           // 是否支持DDNS
//                    "bGB28181Support":true,        // 是否支持GB28181
//                    "bFTPSupport":true,            // 是否支持FTP
//                    "bNFSSupport":true,            // 是否支持NFS
//                    "bAlarmServiceSupport":false,  // 是否支持迅卫士
//                    "bFishEye":false,              // 是否是鱼眼
//                    "bImageADSupport":true,        // 是否支持图像高级设置
//                    "bMultiOsdSupport":true,       // 是否支持多行OSD
//                    "bEightPrivacy":true,          // 是否支持8个区域遮挡
//                    "bMDGridSupport":true,         // 是否支持MD网格
//                    "bChatSupport":true,           // 是否支持对讲
//                    "defChatAudioMode":"ONE_WAY",  //设备默认对讲模式，单向：：ONE_WAY  双向：TWO_WAY
//                    "bRemoteDesk":true,            // 是否支持远程桌面
//                    "bWebConfig":false,            // 是否支持web配置
//                    "bIspLibSupport":false,        // 是否支持图像库
//                    "bSDCardSupport":false,        // 是否支持SD卡存储
//                    "bDualLightSupport":false,     // 是否支持双光源
//                    "bAlarmLightSupport":false,    // 是否支持白光灯报警
//                    "bAlarmSoundSupport":false,    // 是否支持自定义语言报警
//                    "AlarmSoundSampleRate":8000,    // 自定义报警声音采样率
//                    "bAlarmCancelSupport":false,    // 是否支持消警
//                    "RemoteChatAudioMode":
//            "TWO_WAY",    //Home_Product,支持的对讲模式，单向：ONE_WAY 双向：TWO_WAY 单双向都支持：BOTH_MODE 不支持：NO_WAY
//                    "bAlarmSoundPlanSupport":false,        // 是否支持报警音计划配置
//                    "bSimpleRecoverySupport":false,     //是否支持简单恢复
//                    "ability":[ // 设备支持的能力集
//            "osd", // osd详细的能力集通过osd_get_ability获取
//                    "simpleDefence", // 一键布防
//                    "driveAway", // 一键驱离
//                    "YSTOldCompatibility", // 兼容YST1.0
//                    "AudioSet",            //支持音频配置
//                    "GunDomeLinkage"        // 支持枪球联动
//                ]
//        }]
//    },
//        "error":{
//        "errorcode":-1,
//                "message":"Failed to set timing snap cfg!"
//    }
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
        private int channelid;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }
    }

    public static class ResultBean {
        private List<AllBean> all;

        public List<AllBean> getAll() {
            return all;
        }

        public void setAll(List<AllBean> all) {
            this.all = all;
        }

        public static class AllBean {
            private int channelid;
            private String channelLabel;
            private boolean bPtzSupport;
            private boolean bAFSupport;
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
            private boolean bFTPSupport;
            private boolean bNFSSupport;
            private boolean bAlarmServiceSupport;
            private boolean bFishEye;
            private boolean bImageADSupport;
            private boolean bMultiOsdSupport;
            private boolean bEightPrivacy;
            private boolean bMDGridSupport;
            private boolean bChatSupport;
            private String defChatAudioMode;
            private boolean bRemoteDesk;
            private boolean bWebConfig;
            private boolean bIspLibSupport;
            private boolean bSDCardSupport;
            private boolean bDualLightSupport;
            private boolean bAlarmLightSupport;
            private boolean bAlarmSoundSupport;
            @SerializedName("AlarmSoundSampleRate")
            private int alarmSoundSampleRate;
            private boolean bAlarmCancelSupport;
            @SerializedName("RemoteChatAudioMode")
            private String remoteChatAudioMode;
            private boolean bAlarmSoundPlanSupport;
            private boolean bSimpleRecoverySupport;
            private List<String> ability;







            //获取osd详细的能力    集通过osd_get_ability获取
            public boolean getAbilityOsd() {
                return getAbility("osd");
            }

            //获取一键布防能力及
            public boolean getAbilitySimpleDefence() {
                return getAbility("simpleDefence");
            }

            //获取一键驱离能力及
            public boolean getAbilityDriveAway() {
                return getAbility("driveAway");
            }

            //获取一键驱离配置能力及
            public boolean getAbilityAdDriveAway(){
                return getAbility("AdDriveAway");
            }

            //获取兼容1.0模式
            public boolean getAbilityYSTOldCompatibility() {
                return getAbility("YSTOldCompatibility");
            }

            // 报警事件查询
            public boolean getAbilityAlarmEvent() {
                return getAbility("alarmEvent");
            }

            // 支持音频配置
            public boolean getAbilityAudioSet() {
                return getAbility("AudioSet");
            }


            // 枪球联动能力及获取
            public boolean getAbilityGunDomeLinkage() {
                return getAbility("GunDomeLinkage");
            }




            public boolean getAbility(String key) {
                boolean contains = false;

                if (null != ability && ability.size() > 0) {
                    for (int i = 0; i < ability.size(); i++) {
                        if (ability.get(i).equalsIgnoreCase(key)) {
                            contains = true;
                            break;
                        }
                    }
                }

                return contains;
            }

            public int getChannelid() {
                return channelid;
            }

            public void setChannelid(int channelid) {
                this.channelid = channelid;
            }

            public String getChannelLabel() {
                return channelLabel;
            }

            public void setChannelLabel(String channelLabel) {
                this.channelLabel = channelLabel;
            }

            public boolean isBPtzSupport() {
                return bPtzSupport;
            }

            public void setBPtzSupport(boolean bPtzSupport) {
                this.bPtzSupport = bPtzSupport;
            }

            public boolean isBAFSupport() {
                return bAFSupport;
            }

            public void setBAFSupport(boolean bAFSupport) {
                this.bAFSupport = bAFSupport;
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

            public String getDefChatAudioMode() {
                return defChatAudioMode;
            }

            public void setDefChatAudioMode(String defChatAudioMode) {
                this.defChatAudioMode = defChatAudioMode;
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

            public boolean isBIspLibSupport() {
                return bIspLibSupport;
            }

            public void setBIspLibSupport(boolean bIspLibSupport) {
                this.bIspLibSupport = bIspLibSupport;
            }

            public boolean isBSDCardSupport() {
                return bSDCardSupport;
            }

            public void setBSDCardSupport(boolean bSDCardSupport) {
                this.bSDCardSupport = bSDCardSupport;
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

            public boolean isBAlarmCancelSupport() {
                return bAlarmCancelSupport;
            }

            public void setBAlarmCancelSupport(boolean bAlarmCancelSupport) {
                this.bAlarmCancelSupport = bAlarmCancelSupport;
            }

            public String getRemoteChatAudioMode() {
                return remoteChatAudioMode;
            }

            public void setRemoteChatAudioMode(String remoteChatAudioMode) {
                this.remoteChatAudioMode = remoteChatAudioMode;
            }

            public boolean isBAlarmSoundPlanSupport() {
                return bAlarmSoundPlanSupport;
            }

            public void setBAlarmSoundPlanSupport(boolean bAlarmSoundPlanSupport) {
                this.bAlarmSoundPlanSupport = bAlarmSoundPlanSupport;
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

            public boolean isOsdSupport() {
                return isAbilityContain("osd");
            }

            private boolean isAbilityContain(String key) {
                boolean contains = false;
                int size = ability == null ? 0 : ability.size();
                for (int i = 0; i < size; i++) {
                    if (ability.get(i).equalsIgnoreCase(key)) {
                        contains = true;
                        break;
                    }
                }
                return contains;
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


















//
////    {	// 获取通道能力
////        "method": "channels_features_get",
////            "level":"Operator",
////            "param": {
////        "channelid": 0 // -1：获取所有视频通道，>=0：获取某个视频通道
////    },
////        "result": {
////        "all": [{
////            "channelid": 0,                 // 通道号
////                    "bPtzSupport": true,            // 是否支持云台
////                    "bAFSupport": false,            // 是否支持自动聚焦
////                    "baudiocodecSupport": true,     // 硬件上是否支持音频codec功能，AUDIO IN
////                    "bNVModifySupport": true,       // 是否支持夜视优化
////                    "bwdrsupport": true,            // 是否支持宽动态
////                    "bDemistSupport": true,         // 是否支持去雾
////                    "bStarSupport": true,           // 是否支持星光级
////                    "bLDCSupport": true,            // 是否支持畸变校正功能
////                    "brotateSupport": true,         // 是否支持旋转
////                    "bExpSupport": true,            // 是否支持夜视亮度和夜视切换时刻滑块
////                    "bFaceModeSupport": true,       // 是否支持人脸模式
////                    "bVlpnIrSupport": false,        // 是否支持红外灯下看清车牌
////                    "bWifiSupport": true,           // 是否支持无线连接
////                    "bDDNSSupport": true,           // 是否支持DDNS
////                    "bGB28181Support": true,        // 是否支持GB28181
////                    "bFTPSupport": true,            // 是否支持FTP
////                    "bNFSSupport": true,            // 是否支持NFS
////                    "bAlarmServiceSupport": false,  // 是否支持迅卫士
////                    "bFishEye": false,              // 是否是鱼眼
////                    "bImageADSupport": true,        // 是否支持图像高级设置
////                    "bMultiOsdSupport": true,       // 是否支持多行OSD
////                    "bEightPrivacy": true,          // 是否支持8个区域遮挡
////                    "bMDGridSupport": true,         // 是否支持MD网格
////                    "bChatSupport": true,           // 是否支持对讲
////                    "bRemoteDesk": true,            // 是否支持远程桌面
////                    "bWebConfig": false,            // 是否支持web配置
////                    "bIspLibSupport": false,        // 是否支持图像库
////                    "bSDCardSupport": false,        // 是否支持SD卡存储
////                    "bIvpSupport": false,           // 是否支持智能分析
////                    "bDualLightSupport": false,     // 是否支持双光源
////                    "bAlarmLightSupport": false,	// 是否支持白光灯报警
////                    "bAlarmSoundSupport": false,    // 是否支持自定义语言报警
////                    "AlarmSoundSampleRate": 8000,	// 自定义报警声音采样率
////                    "bAlarmCancelSupport": false,	// 是否支持消警
////                    "RemoteChatAudioMode": "TWO_WAY",	//Home_Product,支持的对讲模式，单向：ONE_WAY 双向：TWO_WAY 单双向都支持：BOTH_MODE 不支持：NO_WAY
////                    "ability":[ // 设备支持的能力集
////            "osd", // osd详细的能力集通过osd_get_ability获取
////                    "simpleDefence", // 一键布防
////                    "driveAway", // 一键驱离
////                    "YSTOldCompatibility", // 兼容YST1.0
////                    "alarmEvent" // 报警事件查询
////                ]
////        }]
////    },
////                "error":{
////        "errorcode":-1,
////                "message":"Failed to set timing snap cfg!"
////    }
////    }
//
//
//
//    private String method;
//    private String level;
//    private ParamBean param;
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
//    public String getLevel() {
//        return level;
//    }
//
//    public void setLevel(String level) {
//        this.level = level;
//    }
//
//    public ParamBean getParam() {
//        return param;
//    }
//
//    public void setParam(ParamBean param) {
//        this.param = param;
//    }
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
//    public static class ParamBean {
//        private int channelid;
//
//        public int getChannelid() {
//            return channelid;
//        }
//
//        public void setChannelid(int channelid) {
//            this.channelid = channelid;
//        }
//    }
//
//    public static class ResultBean implements Serializable {
//        private List<AllBean> all;
//
//        public List<AllBean> getAll() {
//            return all;
//        }
//
//        public void setAll(List<AllBean> all) {
//            this.all = all;
//        }
//
//        public static class AllBean implements Serializable {
//            private int channelid;
//            private boolean bPtzSupport;
//            private boolean bAFSupport;
//            private boolean baudiocodecSupport;
//            private boolean bNVModifySupport;
//            private boolean bwdrsupport;
//            private boolean bDemistSupport;
//            private boolean bStarSupport;
//            private boolean bLDCSupport;
//            private boolean brotateSupport;
//            private boolean bExpSupport;
//            private boolean bFaceModeSupport;
//            private boolean bVlpnIrSupport;
//            private boolean bWifiSupport;
//            private boolean bDDNSSupport;
//            private boolean bGB28181Support;
//            private boolean bFTPSupport;
//            private boolean bNFSSupport;
//            private boolean bAlarmServiceSupport;
//            private boolean bFishEye;
//            private boolean bImageADSupport;
//            private boolean bMultiOsdSupport;
//            private boolean bEightPrivacy;
//            private boolean bMDGridSupport;
//            private boolean bChatSupport;
//            private boolean bRemoteDesk;
//            private boolean bWebConfig;
//            private boolean bIspLibSupport;
//            private boolean bSDCardSupport;
//            private boolean bIvpSupport;
//            private boolean bDualLightSupport;
//            private boolean bAlarmLightSupport;
//            private boolean bAlarmSoundSupport;
//            private boolean bAlarmSoundPlanSupport;
//            private boolean bSimpleRecoverySupport;
//            @SerializedName("AlarmSoundSampleRate")
//            private int alarmSoundSampleRate;
//            private boolean bAlarmCancelSupport;
//            @SerializedName("RemoteChatAudioMode")
//            private String remoteChatAudioMode;
//            private String defChatAudioMode;//单双向对讲模式的设备，默认的对讲模式
//            private List<String> ability;
//
//            //获取osd详细的能力集通过osd_get_ability获取
//            public boolean getAbilityOsd(){
//                return getAbility("osd");
//            }
//
//            //获取一键布防能力及
//            public boolean getAbilitySimpleDefence(){
//                return getAbility("simpleDefence");
//            }
//
//            //获取一键布防能力及
//            public boolean getAbilityDriveAway(){
//                return getAbility("driveAway");
//            }
//
//            //获取一键布防能力及
//            public boolean getAbilityYSTOldCompatibility(){
//                return getAbility("YSTOldCompatibility");
//            }
//
//            // 报警事件查询
//            public boolean getAbilityAlarmEvent(){
//                return getAbility("alarmEvent");
//            }
//
//            public boolean getAbility(String key){
//                boolean contains = false;
//
//                if(null != ability && ability.size() > 0){
//                    for(int i = 0 ; i < ability.size() ;i++){
//                        if(ability.get(i).equalsIgnoreCase(key)){
//                            contains = true;
//                            break;
//                        }
//                    }
//                }
//
//                return contains;
//            }
//
//            public int getChannelid() {
//                return channelid;
//            }
//
//            public void setChannelid(int channelid) {
//                this.channelid = channelid;
//            }
//
//            public boolean isBPtzSupport() {
//                return bPtzSupport;
//            }
//
//            public void setBPtzSupport(boolean bPtzSupport) {
//                this.bPtzSupport = bPtzSupport;
//            }
//
//            public boolean isBAFSupport() {
//                return bAFSupport;
//            }
//
//            public void setBAFSupport(boolean bAFSupport) {
//                this.bAFSupport = bAFSupport;
//            }
//
//            public boolean isBaudiocodecSupport() {
//                return baudiocodecSupport;
//            }
//
//            public void setBaudiocodecSupport(boolean baudiocodecSupport) {
//                this.baudiocodecSupport = baudiocodecSupport;
//            }
//
//            public boolean isBNVModifySupport() {
//                return bNVModifySupport;
//            }
//
//            public void setBNVModifySupport(boolean bNVModifySupport) {
//                this.bNVModifySupport = bNVModifySupport;
//            }
//
//            public boolean isBwdrsupport() {
//                return bwdrsupport;
//            }
//
//            public void setBwdrsupport(boolean bwdrsupport) {
//                this.bwdrsupport = bwdrsupport;
//            }
//
//            public boolean isBDemistSupport() {
//                return bDemistSupport;
//            }
//
//            public void setBDemistSupport(boolean bDemistSupport) {
//                this.bDemistSupport = bDemistSupport;
//            }
//
//            public boolean isBStarSupport() {
//                return bStarSupport;
//            }
//
//            public void setBStarSupport(boolean bStarSupport) {
//                this.bStarSupport = bStarSupport;
//            }
//
//            public boolean isBLDCSupport() {
//                return bLDCSupport;
//            }
//
//            public void setBLDCSupport(boolean bLDCSupport) {
//                this.bLDCSupport = bLDCSupport;
//            }
//
//            public boolean isBrotateSupport() {
//                return brotateSupport;
//            }
//
//            public void setBrotateSupport(boolean brotateSupport) {
//                this.brotateSupport = brotateSupport;
//            }
//
//            public boolean isBExpSupport() {
//                return bExpSupport;
//            }
//
//            public void setBExpSupport(boolean bExpSupport) {
//                this.bExpSupport = bExpSupport;
//            }
//
//            public boolean isBFaceModeSupport() {
//                return bFaceModeSupport;
//            }
//
//            public void setBFaceModeSupport(boolean bFaceModeSupport) {
//                this.bFaceModeSupport = bFaceModeSupport;
//            }
//
//            public boolean isBVlpnIrSupport() {
//                return bVlpnIrSupport;
//            }
//
//            public void setBVlpnIrSupport(boolean bVlpnIrSupport) {
//                this.bVlpnIrSupport = bVlpnIrSupport;
//            }
//
//            public boolean isBWifiSupport() {
//                return bWifiSupport;
//            }
//
//            public void setBWifiSupport(boolean bWifiSupport) {
//                this.bWifiSupport = bWifiSupport;
//            }
//
//            public boolean isBDDNSSupport() {
//                return bDDNSSupport;
//            }
//
//            public void setBDDNSSupport(boolean bDDNSSupport) {
//                this.bDDNSSupport = bDDNSSupport;
//            }
//
//            public boolean isBGB28181Support() {
//                return bGB28181Support;
//            }
//
//            public void setBGB28181Support(boolean bGB28181Support) {
//                this.bGB28181Support = bGB28181Support;
//            }
//
//            public boolean isBFTPSupport() {
//                return bFTPSupport;
//            }
//
//            public void setBFTPSupport(boolean bFTPSupport) {
//                this.bFTPSupport = bFTPSupport;
//            }
//
//            public boolean isBNFSSupport() {
//                return bNFSSupport;
//            }
//
//            public void setBNFSSupport(boolean bNFSSupport) {
//                this.bNFSSupport = bNFSSupport;
//            }
//
//            public boolean isBAlarmServiceSupport() {
//                return bAlarmServiceSupport;
//            }
//
//            public void setBAlarmServiceSupport(boolean bAlarmServiceSupport) {
//                this.bAlarmServiceSupport = bAlarmServiceSupport;
//            }
//
//            public boolean isBFishEye() {
//                return bFishEye;
//            }
//
//            public void setBFishEye(boolean bFishEye) {
//                this.bFishEye = bFishEye;
//            }
//
//            public boolean isBImageADSupport() {
//                return bImageADSupport;
//            }
//
//            public void setBImageADSupport(boolean bImageADSupport) {
//                this.bImageADSupport = bImageADSupport;
//            }
//
//            public boolean isBMultiOsdSupport() {
//                return bMultiOsdSupport;
//            }
//
//            public void setBMultiOsdSupport(boolean bMultiOsdSupport) {
//                this.bMultiOsdSupport = bMultiOsdSupport;
//            }
//
//            public boolean isBEightPrivacy() {
//                return bEightPrivacy;
//            }
//
//            public void setBEightPrivacy(boolean bEightPrivacy) {
//                this.bEightPrivacy = bEightPrivacy;
//            }
//
//            public boolean isBMDGridSupport() {
//                return bMDGridSupport;
//            }
//
//            public void setBMDGridSupport(boolean bMDGridSupport) {
//                this.bMDGridSupport = bMDGridSupport;
//            }
//
//            public boolean isBChatSupport() {
//                return bChatSupport;
//            }
//
//            public void setBChatSupport(boolean bChatSupport) {
//                this.bChatSupport = bChatSupport;
//            }
//
//            public boolean isBRemoteDesk() {
//                return bRemoteDesk;
//            }
//
//            public void setBRemoteDesk(boolean bRemoteDesk) {
//                this.bRemoteDesk = bRemoteDesk;
//            }
//
//            public boolean isBWebConfig() {
//                return bWebConfig;
//            }
//
//            public void setBWebConfig(boolean bWebConfig) {
//                this.bWebConfig = bWebConfig;
//            }
//
//            public boolean isBIspLibSupport() {
//                return bIspLibSupport;
//            }
//
//            public void setBIspLibSupport(boolean bIspLibSupport) {
//                this.bIspLibSupport = bIspLibSupport;
//            }
//
//            public boolean isBSDCardSupport() {
//                return bSDCardSupport;
//            }
//
//            public void setBSDCardSupport(boolean bSDCardSupport) {
//                this.bSDCardSupport = bSDCardSupport;
//            }
//
//            public boolean isBIvpSupport() {
//                return bIvpSupport;
//            }
//
//            public void setBIvpSupport(boolean bIvpSupport) {
//                this.bIvpSupport = bIvpSupport;
//            }
//
//            public boolean isBDualLightSupport() {
//                return bDualLightSupport;
//            }
//
//            public void setBDualLightSupport(boolean bDualLightSupport) {
//                this.bDualLightSupport = bDualLightSupport;
//            }
//
//            public boolean isBAlarmLightSupport() {
//                return bAlarmLightSupport;
//            }
//
//            public void setBAlarmLightSupport(boolean bAlarmLightSupport) {
//                this.bAlarmLightSupport = bAlarmLightSupport;
//            }
//
//            public boolean isBAlarmSoundSupport() {
//                return bAlarmSoundSupport;
//            }
//
//            public void setBAlarmSoundSupport(boolean bAlarmSoundSupport) {
//                this.bAlarmSoundSupport = bAlarmSoundSupport;
//            }
//
//            public boolean isBAlarmSoundPlanSupport() {
//                return bAlarmSoundPlanSupport;
//            }
//
//            public void setBAlarmSoundPlanSupport(boolean bAlarmSoundPlanSupport) {
//                this.bAlarmSoundPlanSupport = bAlarmSoundPlanSupport;
//            }
//
//            public boolean isBSimpleRecoverySupport() {
//                return bSimpleRecoverySupport;
//            }
//
//            public void setBSimpleRecoverySupport(boolean bSimpleRecoverySupport) {
//                this.bSimpleRecoverySupport = bSimpleRecoverySupport;
//            }
//
//            public int getAlarmSoundSampleRate() {
//                return alarmSoundSampleRate;
//            }
//
//            public void setAlarmSoundSampleRate(int alarmSoundSampleRate) {
//                this.alarmSoundSampleRate = alarmSoundSampleRate;
//            }
//
//            public boolean isBAlarmCancelSupport() {
//                return bAlarmCancelSupport;
//            }
//
//            public void setBAlarmCancelSupport(boolean bAlarmCancelSupport) {
//                this.bAlarmCancelSupport = bAlarmCancelSupport;
//            }
//
//            public String getRemoteChatAudioMode() {
//                return remoteChatAudioMode;
//            }
//
//            public void setRemoteChatAudioMode(String remoteChatAudioMode) {
//                this.remoteChatAudioMode = remoteChatAudioMode;
//            }
//
//            public List<String> getAbility() {
//                return ability;
//            }
//
//            public void setAbility(List<String> ability) {
//                this.ability = ability;
//            }
//
//            public String getDefChatAudioMode() {
//                return defChatAudioMode;
//            }
//
//            public void setDefChatAudioMode(String defChatAudioMode) {
//                this.defChatAudioMode = defChatAudioMode;
//            }
//
//            public boolean isOsdSupport() {
//                return isAbilityContain("osd");
//            }
//
//            private boolean isAbilityContain(String key) {
//                boolean contains = false;
//                int size = ability == null ? 0 : ability.size();
//                for (int i = 0; i < size; i++) {
//                    if (ability.get(i).equalsIgnoreCase(key)) {
//                        contains = true;
//                        break;
//                    }
//                }
//                return contains;
//            }
//        }
//    }
//
//    public static class ErrorBean implements Serializable {
//        private int errorcode;
//        private String message;
//
//        public int getErrorcode() {
//            return errorcode;
//        }
//
//        public void setErrorcode(int errorcode) {
//            this.errorcode = errorcode;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }
//    }




}
