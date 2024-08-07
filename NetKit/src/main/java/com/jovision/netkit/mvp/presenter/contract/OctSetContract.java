package com.jovision.netkit.mvp.presenter.contract;
import com.alibaba.fastjson.JSONObject;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.OctIvpVfBean;
import com.jovision.netkit.mvp.data.bean.request.DeleteDevicesBean;
import com.jovision.netkit.mvp.data.bean.response.AlarmLinkIdBean;
import com.jovision.netkit.mvp.data.bean.response.OctAccountModifyUserBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmLinkGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmSoundGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmSoundListGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctAudioAbilityGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctAudioAoGetParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctChannelAbilityBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevIPInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevNtpBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevUpdateBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevUpdateCheckBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevUpdateProgressBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageAbilityGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageAdjustParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageDncutParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageExpertBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctIntelEbikeDetectionBean;
import com.jovision.netkit.mvp.data.bean.response.OctInvadeBean;
import com.jovision.netkit.mvp.data.bean.response.OctIvpBean;
import com.jovision.netkit.mvp.data.bean.response.OctIvpFacercgParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctIvpHideBean;
import com.jovision.netkit.mvp.data.bean.response.OctMotionDetectBean;
import com.jovision.netkit.mvp.data.bean.response.OctMotionTrackBean;
import com.jovision.netkit.mvp.data.bean.response.OctOsdParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctRecordGetInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctSDCardFormatProBean;
import com.jovision.netkit.mvp.data.bean.response.OctSDCardInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctStreamGetAllAbility;
import com.jovision.netkit.mvp.data.bean.response.OctStreamGetParams;
import com.jovision.netkit.mvp.data.bean.response.OctTimeBean;
import com.jovision.netkit.mvp.data.bean.response.OctTimingSnapBean;
import com.jovision.netkit.mvp.data.bean.response.OctWifiListAp;
import com.jovision.netkit.mvp.data.bean.response.OnvifGetDiscoveryInfo;
import com.jovision.uikit.BaseView;


import io.reactivex.Observable;

public interface OctSetContract {

    interface IOctSetModel {

        Observable<BaseBean<OctDevInfoBean>> octGetDevHwinfo(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<OctAccountModifyUserBean>> octAccountModifyUser(String deviceSn, int channelId, String devUser, String devPwd, String newDevUser, String newDevPwd);

        Observable<BaseBean<OctSDCardInfoBean>> octGetStorageInfo(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octStorageFormat(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<OctSDCardFormatProBean>> octGetStorageFormatProgress(String deviceSn, int channelId, String devUser, String devPwd, int diskNum, String diskName);

        Observable<BaseBean<OctRecordGetInfoBean>> octGetRecordMode(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetRecordMode(String deviceSn, int channelId, String devUser, String devPwd,String param);

        Observable<BaseBean<OctDevIPInfoBean>> octGetInetConfig(String deviceSn, int channelId, String devUser, String devPwd);

        //8.1 云视通2.0获取设备端wifi列表-给ipc设置ip使用
        Observable<BaseBean<OctWifiListAp>> octGetDevWifiListAp(String deviceSn, int channelId, String devUser, String devPwd) ;

        //8.2 云视通2.0在线配网-给ipc设置ip使用
        Observable<BaseBean<EmptyBean>> octOnLineWifiConnect(String deviceSn, int channelId, String devUser, String devPwd,String wifiName,String wifiPassword) ;

        Observable<BaseBean<EmptyBean>> octSetInetConfig(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<OctIvpBean>> octGetIvpSupport(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<OctMotionDetectBean>> octGetMdetectParam(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetMdetectParam(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<OctMotionTrackBean>> octGetMoveTrack(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetMoveTrack(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<OctInvadeBean>> octGetIvpRlParam(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetIvpRlParam(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<OctIvpHideBean>> octGetIvpHideParam(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetIvpHideParam(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<OctIntelEbikeDetectionBean>> octGetIntelEbikeDetect(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetIntelEbikeDetect(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<OctAlarmSoundGetBean>> octGetAlarmSound(String deviceSn, int channelId, String devUser, String devPwd, String fileName, boolean bGetData);

        Observable<BaseBean<EmptyBean>> octSetAlarmSound(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<OctAudioAbilityGetBean>> octGetAudioAbility(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<OctAudioAoGetParamBean>> octGetAoParam(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetAoParam(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<OctDevNtpBean>> octGetDevNtp(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetDevNtp(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<OctOsdParamBean>> octGetChnosdParam(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetChnosdParam(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<OctTimeBean>> octGetDevTime(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetDevTime(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<EmptyBean>> octRebootDev(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octResetDev(String deviceSn, int channelId, String devUser, String devPwd, boolean isSimple);

        Observable<BaseBean<OctDevUpdateCheckBean>> octCheckDevUpdate(String deviceSn, String devUser, String devPwd);

        Observable<BaseBean<OctDevUpdateBean>> octDevUpdate(String deviceSn, String devUser, String devPwd);

        Observable<BaseBean<OctDevUpdateProgressBean>> octGetDevUpdateProgress(String deviceSn, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octManualSetAlarmLight(String deviceSn, String devUser, String devPwd, boolean bOpen);

        Observable<BaseBean<OctImageAbilityGetBean>> octGetImageAbility(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetImageExpertSettingParam(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<OctImageExpertBean>> octGetImageExpertSettingParam(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<OctImageParamBean>> octGetImageParam(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetImageParam(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<OctIvpFacercgParamBean>> octGetIvpFacercgParam(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetIvpFacercgParam(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<EmptyBean>> octSetIndicatorled(String deviceSn, int channelId, String devUser, String devPwd, int mode);

        Observable<BaseBean<OctImageDncutParamBean>> octGetImageDncutParam(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetImageDncutParam(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<OctChannelAbilityBean>> octGetChannelsFeatures(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<OctTimingSnapBean>> octGetTimingSnap(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetTimingSnap(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<OctImageAdjustParamBean>> octGetImageAdjustParam(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octSetImageAdjustParam(String deviceSn, int channelId, String devUser, String devPwd, String param);


        Observable<BaseBean<OctAlarmSoundListGetBean>> octGetAlarmSoundList(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octAddAlarmSound(String deviceSn, int channelId, String devUser, String devPwd, String fileName,String fileData);

        Observable<BaseBean<EmptyBean>> octDeleteAlarmSound(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<EmptyBean>> octAlarmSoundPlay(String deviceSn, int channelId, String devUser, String devPwd, String fileName);


        Observable<BaseBean<AlarmLinkIdBean>> octGetAlarmLinkId(String deviceSn, int channelId, String devUser, String devPwd, String moudel);

        Observable<BaseBean<OctAlarmLinkGetBean>> octAlarmLinkGet(String deviceSn, int channelId, String devUser, String devPwd, int linkId, boolean bDefault);

        Observable<BaseBean<EmptyBean>> octAlarmLinkSet(String deviceSn, int channelId, String devUser, String devPwd, JSONObject paramObj) ;


        Observable<BaseBean<EmptyBean>> editDeviceYst(String deviceSn, String deviceName, String deviceUser, String newDevPwd);

        Observable<BaseBean<EmptyBean>> deleteDevices(DeleteDevicesBean devices);


        //获取1.0兼容配置
        Observable<BaseBean<OnvifGetDiscoveryInfo>> octGetOnVifDiscoveryFlag(String deviceSn, int channelId, String devUser, String devPwd);


        //设置1.0兼容设置
        Observable<BaseBean<EmptyBean>> octSetOnVifDiscoveryFlag(String deviceSn, int channelId, String devUser, String devPwd, String param);


        //获取某个或所有通道的所有码流能力集
        Observable<BaseBean<OctStreamGetAllAbility>> octGetStreamAllAbility(String deviceSn, int channelId, String devUser, String devPwd);

        //获取某个或所有通道的所有码流参数
        Observable<BaseBean<OctStreamGetParams>> octGetStreamParams(String deviceSn, int channelId, String devUser, String devPwd);

        //设置多个通道的多个码流参数
        Observable<BaseBean<EmptyBean>> octSetStreamParams(String deviceSn, int channelId,String devUser, String devPwd, OctStreamGetParams.ResultBean octStreamGetParams);

        //恢复默认设置
        Observable<BaseBean<EmptyBean>> octSetDefaultCfg(String deviceSn, int channelId, String devUser, String devPwd);


        //云视通2.0-获取虚焦检测的参数
        Observable<BaseBean<OctIvpVfBean>> octIvpVfGetParam(String deviceSn, int channelId, String devUser, String devPwd);

        //云视通2.0-设置虚焦检测的参数
        Observable<BaseBean<EmptyBean>> octIvpVfSetParam(String deviceSn, int channelId, String devUser, String devPwd, String param);


    }

    interface View extends BaseView {

        void octGetDevHwinfoSuccess(OctDevInfoBean octDevInfoBean,String deviceSn, int channelId);
        void octGetDevHwinfoFailed(Throwable e,String deviceSn, int channelId);


        void octAccountModifyUserSuccess(OctAccountModifyUserBean octAccountModifyUserBean);
        void octAccountModifyUserFailed(Throwable e);


        void octGetStorageInfoSuccess(OctSDCardInfoBean octSDCardInfoBean);
        void octGetStorageInfoFailed(Throwable e);


        void octStorageFormatSuccess();
        void octStorageFormatFailed(Throwable e);


        void octGetStorageFormatProgressSuccess(OctSDCardFormatProBean octSDCardFormatProBean);
        void octGetStorageFormatProgressFailed(Throwable e);


        void octGetRecordModeSuccess(OctRecordGetInfoBean octRecordInfoBean);
        void octGetRecordModeFailed(Throwable e);


        void octSetRecordModeSuccess();
        void octSetRecordModeFailed(Throwable e);


        void octGetInetConfigSuccess(OctDevIPInfoBean octDevIPInfoBean);
        void octGetInetConfigFailed(Throwable e);


        void octGetDevWifiListApSuccess(OctWifiListAp octWifiListAp);
        void octGetDevWifiListApFailed(Throwable e);

        void octOnLineWifiConnectSuccess(EmptyBean emptyBean);
        void octOnLineWifiConnectFailed(Throwable e);





        void octSetInetConfigSuccess();
        void octSetInetConfigFailed(Throwable e);

        void octGetIvpSupportSuccess(OctIvpBean octIvpBean);
        void octGetIvpSupportFailed(Throwable e);

        void octGetMdetectParamSuccess(OctMotionDetectBean octMotionDetectBean);
        void octGetMdetectParamFailed(Throwable e);

        void octSetMdetectParamSuccess();
        void octSetMdetectParamFailed(Throwable e);

        void octGetMoveTrackSuccess(OctMotionTrackBean octMotionTrackBean);
        void octGetMoveTrackFailed(Throwable e);

        void octSetMoveTrackSuccess();
        void octSetMoveTrackFailed(Throwable e);

        void octGetIvpRlParamSuccess(OctInvadeBean octInvadeBean);
        void octGetIvpRlParamFailed(Throwable e);

        void octSetIvpRlParamSuccess();
        void octSetIvpRlParamFailed(Throwable e);

        void octGetIvpHideParamSuccess(OctIvpHideBean octIvpHideBean);
        void octGetIvpHideParamFailed(Throwable e);

        void octSetIvpHideParamSuccess();
        void octSetIvpHideParamFailed(Throwable e);

        void octGetIntelEbikeDetectSuccess(OctIntelEbikeDetectionBean octIntelEbikeDetectionBean);
        void octGetIntelEbikeDetectFailed(Throwable e);

        void octSetIntelEbikeDetectSuccess();
        void octSetIntelEbikeDetectFailed(Throwable e);

        void octGetAlarmSoundSuccess(OctAlarmSoundGetBean octAlarmSoundGetBean);
        void octGetAlarmSoundFailed(Throwable e);


        void octSetAlarmSoundSuccess();
        void octSetAlarmSoundFailed(Throwable e);

        void octGetAudioAbilitySuccess(OctAudioAbilityGetBean octAudioAbilityGetBean);
        void octGetAudioAbilityFailed(Throwable e);

        void octGetAoParamSuccess(OctAudioAoGetParamBean octAudioAoGetParamBean);
        void octGetAoParamFailed(Throwable e);

        void octSetAoParamSuccess();
        void octSetAoParamFailed(Throwable e);

        void octGetDevNtpSuccess(OctDevNtpBean octDevNtpBean);
        void octGetDevNtpFailed(Throwable e);

        void octSetDevNtpSuccess();
        void octSetDevNtpFailed(Throwable e);

        void octGetChnosdParamSuccess(OctOsdParamBean octOsdParamBean);
        void octGetChnosdParamFailed(Throwable e);

        void octSetChnosdParamSuccess();
        void octSetChnosdParamFailed(Throwable e);

        void octGetDevTimeSuccess(OctTimeBean octTimeBean);
        void octGetDevTimeFailed(Throwable e);

        void octSetDevTimeSuccess();
        void octSetDevTimeFailed(Throwable e);

        void octRebootDevSuccess();
        void octRebootDevFailed(Throwable e);

        void octResetDevSuccess(boolean isSimple);
        void octResetDevFailed(Throwable e);

        void octCheckDevUpdateSuccess(OctDevUpdateCheckBean octDevUpdateCheckBean);
        void octCheckDevUpdateFailed(Throwable e);

        void octDevUpdateSuccess(OctDevUpdateBean octDevUpdateBean);
        void octDevUpdateFailed(Throwable e);

        void octGetDevUpdateProgressSuccess(OctDevUpdateProgressBean octDevUpdateProgressBean);
        void octGetDevUpdateProgressFailed(Throwable e);

        void octManualSetAlarmLightSuccess();
        void octManualSetAlarmLightFailed(Throwable e);

        void octGetImageAbilitySuccess(OctImageAbilityGetBean octImageAbilityGetBean);
        void octGetImageAbilityFailed(Throwable e);

        void octSetImageExpertSettingParamSuccess();
        void octSetImageExpertSettingParamFailed(Throwable e);

        void octGetImageExpertSettingParamSuccess(OctImageExpertBean octImageExpertBean);
        void octGetImageExpertSettingParamFailed(Throwable e);

        void octGetImageParamSuccess(OctImageParamBean octImageParamBean);
        void octGetImageParamFailed(Throwable e);

        void octSetImageParamSuccess();
        void octSetImageParamFailed(Throwable e);

        void octGetIvpFacercgParamSuccess(OctIvpFacercgParamBean octIvpFacercgParamBean);
        void octGetIvpFacercgParamFailed(Throwable e);

        void octSetIvpFacercgParamSuccess();
        void octSetIvpFacercgParamFailed(Throwable e);


        void octSetIndicatorledSuccess();
        void octSetIndicatorledFailed(Throwable e);

        void octGetImageDncutParamSuccess(OctImageDncutParamBean octImageDncutParamBean);
        void octGetImageDncutParamFailed(Throwable e);

        void octSetImageDncutParamSuccess();
        void octSetImageDncutParamFailed(Throwable e);

        void octGetTimingSnapSuccess(OctTimingSnapBean octTimingSnapBean);
        void octGetTimingSnapFailed(Throwable e);

        void octSetTimingSnapSuccess();
        void octSetTimingSnapFailed(Throwable e);

        void octGetImageAdjustParamSuccess(OctImageAdjustParamBean data);
        void octGetImageAdjustParamFailed(Throwable e);

        void octSetImageAdjustParamSuccess();
        void octSetImageAdjustParamFailed(Throwable e);



        void octGetChannelsFeaturesSuccess(OctChannelAbilityBean octChannelAbilityBean,String deviceSn, int channelId);
        void octGetChannelsFeaturesFailed(Throwable e,String deviceSn, int channelId);


        void octGetAlarmSoundListSuccess(OctAlarmSoundListGetBean octAlarmSoundListGetBean);
        void octGetAlarmSoundListFailed(Throwable e);

        void octAddAlarmSoundSuccess();
        void octAddAlarmSoundFailed(Throwable e);

        void octDeleteAlarmSoundSuccess();
        void octDeleteAlarmSoundFailed(Throwable e);

        void getAlarmLinkIdSuccess(String deviceSn, int channelId, AlarmLinkIdBean.ResultBean resultBean);
        void getAlarmLinkIdFailed(String deviceSn, int channelId, Throwable e);

        void octAlarmLinkGetSuccess(OctAlarmLinkGetBean octAlarmLinkGetBean);
        void octAlarmLinkGetFailed(Throwable e);

        void octAlarmLinkSetSuccess();
        void octAlarmLinkSetFailed(Throwable e);


        void editDeviceYstSuccess();
        void editDeviceYstFailed(Throwable e);


        void deleteDevicesSuccess();
        void deleteDevicesError(Throwable e);


        void octGetOnVifDiscoveryFlagSuccess(OnvifGetDiscoveryInfo onvifGetDiscoveryInfo);
        void octGetOnVifDiscoveryFlagError(Throwable e);


        void octSetOnVifDiscoveryFlagSuccess();
        void octSetOnVifDiscoveryFlagError(Throwable e);


        void octGetStreamAllAbilitySuccess(OctStreamGetAllAbility resultBean);
        void octGetStreamAllAbilityError(Throwable e);

        void octGetStreamParamsSuccess(OctStreamGetParams resultBean);
        void octGetStreamParamsError(Throwable e);

        void octSetStreamParamsSuccess(EmptyBean emptyBean);
        void octSetStreamParamsError(Throwable e);

        void octSetDefaultCfgSuccess(EmptyBean emptyBean);
        void octSetDefaultCfgError(Throwable e);


        void octIvpVfGetParamSuccess(OctIvpVfBean octIvpVfBean);
        void octIvpVfGetParamError(Throwable e);

        void octIvpVfSetParamSuccess(EmptyBean emptyBean);
        void octIvpVfSetParamError(Throwable e);

    }
}

