package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.AlarmSoundBean;
import com.jovision.netkit.mvp.data.bean.AlarmSoundVolumeBean;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.ChannelBean;
import com.jovision.netkit.mvp.data.bean.DeviceBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.OctIvpVfBean;
import com.jovision.netkit.mvp.data.bean.RDLPRSystemGetParam;
import com.jovision.netkit.mvp.data.bean.request.SmartAppAlarmVoiceBean;
import com.jovision.netkit.mvp.data.bean.response.DefencePlanBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceAlarmBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceAlarmCryBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceAlarmLiGangBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceAlarmPetBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceAlarmZhanDaoBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceAlarmZhoujieBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceSmartTrackBean;
import com.jovision.netkit.mvp.data.bean.response.GtrackGetCalibrationBean;
import com.jovision.netkit.mvp.data.bean.response.HideAlarmBean;
import com.jovision.netkit.mvp.data.bean.response.IntelligenceAbilityBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmLinkGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmSoundListGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageDncutParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctIvpBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAbilityDetailBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAppAlarmVoiceResBean;
import com.jovision.uikit.BaseView;

import java.util.HashMap;

import io.reactivex.Observable;

public interface DeviceAlarmSettingContract {

    interface IDeviceAlarmSettingModel {
        Observable<BaseBean<DeviceAlarmBean>> sendCmdForAlarm(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<DeviceAlarmZhoujieBean>> getParamsForZhoujie(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<DeviceSmartTrackBean>> getSmartTrackParam(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> openDeviceSmartTracking(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> setMotionAndHumanParams(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> setZhoujieParams(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<DeviceAlarmZhanDaoBean>> getParamsForZhanDao(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> setZhanDaoParams(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<DeviceAlarmLiGangBean>> getParamsForLiGang(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> setLiGangParams(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<DeviceAlarmCryBean>> getCryAlarmParams(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> setCryAlarmParams(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<DeviceAlarmPetBean>> getPetAlarmParams(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> setPetAlarmParams(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<IntelligenceAbilityBean>> getIntelligenceAbility(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<OctIvpBean.ResultBean>> getIvpSupport(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<DefencePlanBean>> getDefencePlan(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> setDefencePlan(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<AlarmSoundBean>> getAlarmSound(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<OctAlarmSoundListGetBean.ResultBean>> getAlarmSoundList(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> devicePlayAlarmSound(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> addAlarmSound(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> deleteAlarmSound(String deviceSn, int channelId, HashMap<String, Object> body);


        Observable<BaseBean<EmptyBean>> setAlarmSound(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<AlarmSoundVolumeBean>> getAlarmSoundVolume(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> setAlarmSoundVolume(String deviceSn, int channelId, HashMap<String, Object> body);


        Observable<BaseBean<OctAlarmLinkGetBean.ResultBean>> getAlarmLink(String deviceSn, int channelId, int alarmLinkId);

        Observable<BaseBean<EmptyBean>> setAlarmLink(String deviceSn, int channelId, HashMap<String, Object> body);


        Observable<BaseBean<HideAlarmBean.ResultBean>> getHideAlarmParams(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> setHideAlarmParams(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<ChannelBean>> getChannelDetail(String deviceNo, int channelId);

        Observable<BaseBean<DeviceBean>> getDeviceAbility(String deviceNo);


        // 标定相关接口-1 获取标定状态
        public Observable<BaseBean<GtrackGetCalibrationBean.ResultBean>> getGtrackCalibration(String deviceSn, int channelId, HashMap<String, Object> body);


        //获取虚焦检测的参数
        Observable<BaseBean<OctIvpVfBean.ResultBean>> getParamsForVFS(String deviceSn, int channelId, HashMap<String, Object> body);

        //设置虚焦检测的参数
        Observable<BaseBean<EmptyBean>> setParamsForVFS(String deviceSn, int channelId, HashMap<String, Object> body);


        //获取设备日夜切换设置
        Observable<BaseBean<OctImageDncutParamBean.ResultBean>> getDayNightParam(String deviceSn, int channelId, HashMap<String, Object> body);

        //哭声宠物开启状态获取接口
        Observable<BaseBean<SmartAbilityDetailBean>> getCryPetDetail(String deviceSn, int channelId);


        //车牌识别参数获取接口
        Observable<BaseBean<RDLPRSystemGetParam>> getParamLPRSystem(String deviceSn, int channelId);

        //车牌识别参数设置接口
        Observable<BaseBean<EmptyBean>> setParamLPRSystem(String deviceSn, int channelId, RDLPRSystemGetParam.ResultBean resultBean);

        //新车牌识别
        Observable<BaseBean<EmptyBean>> setSmartAppAlarmVoice(String deviceSn, int channelId, SmartAppAlarmVoiceBean.Param param);

        Observable<BaseBean<SmartAppAlarmVoiceResBean>> getSmartAppAlarmVoice(String deviceSn, int channelId, SmartAppAlarmVoiceBean.Param param);
    }

    interface View extends BaseView {

        void sendCmdForAlarmSuccess(DeviceAlarmBean deviceAlarmBean);

        void sendCmdForAlarmError(Throwable e);

        void getParamsForZhoujieSuccess(DeviceAlarmZhoujieBean deviceAlarmBean);

        void getParamsForZhoujieError(Throwable e);

        void getSmartTrackParamSuccess(DeviceSmartTrackBean bean);

        void getSmartTrackParamError(Throwable e);

        void openDeviceSmartTrackingSuccess(EmptyBean bean);

        void openDeviceSmartTrackingError(Throwable e);

        void setMotionAndHumanParamsSuccess(EmptyBean bean);

        void setMotionAndHumanParamsError(Throwable e);

        void setZhoujieParamsSuccess(EmptyBean bean);

        void setZhoujieParamsError(Throwable e);

        void getParamsForZhanDaoSuccess(DeviceAlarmZhanDaoBean bean);

        void getParamsForZhanDaoError(Throwable e);

        void setZhanDaoParamsSuccess(EmptyBean bean);

        void setZhanDaoParamsError(Throwable e);

        void getParamsForLiGangSuccess(DeviceAlarmLiGangBean bean);

        void getParamsForLiGangError(Throwable e);

        void setLiGangParamsSuccess(EmptyBean bean);

        void setLiGangParamsError(Throwable e);

        void getCryAlarmParamsSuccess(DeviceAlarmCryBean bean);

        void getCryAlarmParamsError(Throwable e);

        void setCryAlarmParamsSuccess(EmptyBean bean);

        void setCryAlarmParamsError(Throwable e);

        void getPetAlarmParamsSuccess(DeviceAlarmPetBean bean);

        void getPetAlarmParamsError(Throwable e);

        void setPetAlarmParamsSuccess(EmptyBean bean);

        void setPetAlarmParamsError(Throwable e);

        void getIntelligenceAbilitySuccess(IntelligenceAbilityBean bean);

        void getIntelligenceAbilityError(Throwable e);

        void getIvpSupportSuccess(OctIvpBean.ResultBean bean);

        void getIvpSupportError(Throwable e);

        void getDefencePlanSuccess(DefencePlanBean bean);

        void getDefencePlanError(Throwable e);

        void setDefencePlanSuccess(EmptyBean bean);

        void setDefencePlanError(Throwable e);

        void getAlarmSoundSuccess(AlarmSoundBean bean);

        void getAlarmSoundError(Throwable e);

        void getAlarmSoundListSuccess(OctAlarmSoundListGetBean.ResultBean bean);

        void getAlarmSoundListError(Throwable e);

        void devicePlayAlarmSoundSuccess(EmptyBean bean);

        void devicePlayAlarmSoundError(Throwable e);

        void addAlarmSoundSuccess(EmptyBean bean);

        void addAlarmSoundError(Throwable e);


        void deleteAlarmSoundSuccess(EmptyBean bean);

        void deleteAlarmSoundError(Throwable e);

        void setAlarmSoundSuccess(EmptyBean bean);

        void setAlarmSoundError(Throwable e);

        void getAlarmSoundVolumeSuccess(AlarmSoundVolumeBean bean);

        void getAlarmSoundVolumeError(Throwable e);

        void setAlarmSoundVolumeSuccess(EmptyBean bean);

        void setAlarmSoundVolumeError(Throwable e);


        void getAlarmLinkSuccess(OctAlarmLinkGetBean.ResultBean resultBean);

        void getAlarmLinkError(Throwable e);

        void setAlarmLinkSuccess(EmptyBean bean);

        void setAlarmLinkError(Throwable e);


        void getHideAlarmParamsSuccess(HideAlarmBean.ResultBean bean);

        void getHideAlarmParamsError(Throwable e);

        void setHideAlarmParamsSuccess(EmptyBean bean);

        void setHideAlarmParamsError(Throwable e);


        void getChannelDetailSuccess(ChannelBean channelBean);

        void getChannelDetailError(Throwable throwable);

        void getDeviceAbilitySuccess(DeviceBean bean);


        void getGtrackCalibrationSuccess(GtrackGetCalibrationBean.ResultBean resultBean);

        void getGtrackCalibrationFailed(Throwable t);


        void getParamsForVFSSuccess(OctIvpVfBean.ResultBean resultBean);

        void getParamsForVFSFailed(Throwable t);

        void setParamsForVFSSuccess(EmptyBean bean);

        void setParamsForVFSFailed(Throwable t);

        void getDayNightParamSuccess(OctImageDncutParamBean.ResultBean octImageDncutResultBean);
        void getDayNightParamError(Throwable e);

        void getCryPetDetailSuccess(String deviceSn, int channelId, SmartAbilityDetailBean resultBean);

        void getCryPetDetailError(String deviceSn, int channelId, Throwable e);


        void getParamLPRSystemSuccess(RDLPRSystemGetParam rdlprSystemGetParam);

        void getParamLPRSystemFailed(Throwable t);


        void setParamLPRSystemSuccess(EmptyBean emptyBean);

        void setParamLPRSystemFailed(Throwable t);

        void setSmartAppAlarmVoiceSuccess(EmptyBean emptyBean);

        void setSetSmartAppAlarmVoiceFailed(Throwable t);

        void getSmartAppAlarmVoiceSuccess(SmartAppAlarmVoiceResBean bean);

        void getSetSmartAppAlarmVoiceFailed(Throwable t);
    }

}
