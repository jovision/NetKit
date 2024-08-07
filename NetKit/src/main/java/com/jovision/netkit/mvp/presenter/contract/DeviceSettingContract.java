package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.GetScreenOverTurnBean;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.ChannelBean;
import com.jovision.netkit.mvp.data.bean.Device4GIccidBean;
import com.jovision.netkit.mvp.data.bean.DeviceBean;
import com.jovision.netkit.mvp.data.bean.DeviceConnectNetBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.FormatProgressBean;
import com.jovision.netkit.mvp.data.bean.request.DeleteDevicesBean;
import com.jovision.netkit.mvp.data.bean.response.AlarmLinkIdBean;
import com.jovision.netkit.mvp.data.bean.response.AlarmSoundPlanBean;
import com.jovision.netkit.mvp.data.bean.response.DevGetLowPowerBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceHourlyChimeBean;
import com.jovision.netkit.mvp.data.bean.response.EnableBean;
import com.jovision.netkit.mvp.data.bean.response.GtrackGetCalibrationBean;
import com.jovision.netkit.mvp.data.bean.response.IndicatorLedBean;
import com.jovision.netkit.mvp.data.bean.response.IntelligenceWaveHandCallParam;
import com.jovision.netkit.mvp.data.bean.response.IsSharedResponseBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmSoundListGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctChannelAbilityBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageAbilityGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageDncutParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctRecordGetInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctStreamGetAllAbility;
import com.jovision.netkit.mvp.data.bean.response.OctStreamGetParams;
import com.jovision.netkit.mvp.data.bean.response.OctWifiListAp;
import com.jovision.netkit.mvp.data.bean.response.OnvifGetDiscoveryInfo;
import com.jovision.netkit.mvp.data.bean.response.SimCardListBean;
import com.jovision.netkit.mvp.data.bean.response.SnapShotBean;
import com.jovision.netkit.mvp.data.bean.response.StorageBean;
import com.jovision.netkit.mvp.data.bean.response.UpgradeProgressBean;
import com.jovision.netkit.mvp.data.bean.response.VersionBean;
import com.jovision.netkit.mvp.data.http.PlayUrlBean;
import com.jovision.uikit.BaseView;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;

public interface DeviceSettingContract {

    interface IDeviceSettingModel {

        // 标定相关接口-1 获取标定状态
        public Observable<BaseBean<GtrackGetCalibrationBean.ResultBean>> getGtrackCalibration(String deviceSn, int channelId, HashMap<String, Object> body);


        //获取公有云设备当前的信息-jy
        Observable<BaseBean<OctDevInfoBean.ResultBean>> getDeviceInfo(String deviceSn, int channelId, HashMap<String, Object> body);

        //获取公有云设备通道能力及-jy
        Observable<BaseBean<OctChannelAbilityBean.ResultBean>> getChannelsFeatures(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EnableBean>> getHideStatus(String deviceSn, int channelId);

        Observable<BaseBean<EmptyBean>> setHideStatus(String deviceSn, int channelId, boolean enable);

        Observable<BaseBean<DeviceBean>> deviceDetail(String deviceSn, int channelId);

        Observable<BaseBean<EmptyBean>> deleteDevices(DeleteDevicesBean devices);

        Observable<BaseBean<SnapShotBean>> snapshot(String deviceSn, int channelId);

        Observable<BaseBean<OctRecordGetInfoBean.ResultBean>> getRecordMode(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> setRecordMode(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> editDeviceName(String deviceSn, String deviceName,String accessProtocol);

        Observable<BaseBean<EmptyBean>> editDeviceChannelName(String deviceSn, int channelId,String channelName);

        Observable<BaseBean<EnableBean>> getEncryptStatus(String deviceSn);

        Observable<BaseBean<EmptyBean>> setEncryptStatus(String deviceSn, boolean enable);

        Observable<BaseBean<EnableBean>> getAudioStatus(String deviceSn, int channelId);

        Observable<BaseBean<EmptyBean>> setAudioStatus(String deviceSn, int channelId, boolean enable);

        Observable<BaseBean<EmptyBean>> setLEDStatus(String deviceSn, int status);

        Observable<BaseBean<IndicatorLedBean>> getLEDStatus(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<List<StorageBean>>> getStorage(String deviceSn);

        Observable<BaseBean<EmptyBean>> setDefaultFactory(String deviceSn, int channelId, boolean isSimple);

        Observable<BaseBean<EmptyBean>> rebootDevice(String deviceSn, int channelId);

        Observable<BaseBean<EmptyBean>> rebootChannelDevice(String deviceSn, int channelId, HashMap<String, Object> body);

        Observable<BaseBean<EmptyBean>> formatSDCard(String deviceSn, int diskNum, String diskName, int curPart);

        Observable<BaseBean<VersionBean>> getVersion(String deviceSn);

        Observable<BaseBean<EmptyBean>> upgradeVersion(String deviceSn);

        Observable<BaseBean<UpgradeProgressBean>> getUpgradeStatus(String deviceSn);
        //修改共享状态

        Observable<BaseBean<EmptyBean>> updateShareStatus(String shareNumber, String shareStatus);
        //画面翻转

        Observable<BaseBean<GetScreenOverTurnBean>> getScreenOverturn(String deviceSn, int channelId);

        Observable<BaseBean<EmptyBean>> controlScreenOverturn(String deviceSn, int channelId, boolean overTurn, boolean rotation);

        //修改通道名称
        Observable<BaseBean<EmptyBean>> editChannelName(String deviceSn, int channelId, HashMap<String, Object> body);

        //获取通道能力及
        Observable<BaseBean<ChannelBean>> getChannelDetail(String deviceSn, int channelId);

        //获取格式化进度
        Observable<BaseBean<FormatProgressBean>> formatSDCardProgress(String deviceSn, int channelId, HashMap<String, Object> body);

        //获取设备当前的WIFI信息-jy
        Observable<BaseBean<DeviceConnectNetBean>> getDeviceWifiInfo(String deviceSn, int channelId, HashMap<String, Object> body);

        //获取设备端搜索到的WIFI列表-jy
        Observable<BaseBean<OctWifiListAp.ResultBean>> getDeviceApWifiList(String deviceSn, int channelId, HashMap<String, Object> body);

        //设备在线的情况下配网-jy
        Observable<BaseBean<EmptyBean>> deviceWifiConfig(String deviceSn, int channelId, HashMap<String, Object> body);

        //设备是否存在分享
        Observable<BaseBean<IsSharedResponseBean>> isShared(String deviceSn);

        //获取设备的播放地址
        Observable<BaseBean<List<PlayUrlBean>>> getPlayUrl(String deviceSn, int channelId);

        //获取设备日夜切换设置
        Observable<BaseBean<OctImageDncutParamBean.ResultBean>> getDayNightParam(String deviceSn, int channelId, HashMap<String, Object> body);

        //设置设备日夜切换设置
        Observable<BaseBean<EmptyBean>> setDayNightParam(String deviceSn, int channelId, HashMap<String, Object> body);

        //获取设备图像能力
        Observable<BaseBean<OctImageAbilityGetBean.ResultBean>> getImageAbility(String deviceSn, int channelId, HashMap<String, Object> body);


        //获取设备报警音是否支持联动
        Observable<BaseBean<OctAlarmSoundListGetBean.ResultBean>> getAlarmSoundList(String deviceSn, int channelId, HashMap<String,Object> body);

        //获取设备整点报时设置
        Observable<BaseBean<DeviceHourlyChimeBean.ResultBean>> getHourlyChime(String deviceSn, int channelId, HashMap<String,Object> body);

        //设置设备整点报时设置
        Observable<BaseBean<EmptyBean>> setHourlyChime(String deviceSn, int channelId, HashMap<String,Object> body);

        //获取报警音计划配置
        Observable<BaseBean<AlarmSoundPlanBean.ResultBean>> getAlarmSoundPlan(String deviceSn, int channelId, HashMap<String,Object> body);

        //设置报警音计划配置
        Observable<BaseBean<EmptyBean>> setAlarmSoundPlan(String deviceSn, int channelId, HashMap<String,Object> body);


        //获取1.0兼容配置
        Observable<BaseBean<OnvifGetDiscoveryInfo.ResultBean>> getOnVifDiscoveryFlag(String deviceSn, int channelId, HashMap<String,Object> body);


        //设置1.0兼容设置
        Observable<BaseBean<EmptyBean>> setOnVifDiscoveryFlag(String deviceSn, int channelId, HashMap<String,Object> body);


        //获取某个或所有通道的所有码流能力集
        Observable<BaseBean<OctStreamGetAllAbility.ResultBean>> getStreamAllAbility(String deviceSn, int channelId, HashMap<String,Object> body);

        //获取某个或所有通道的所有码流参数
        Observable<BaseBean<OctStreamGetParams.ResultBean>> getStreamParams(String deviceSn, int channelId, HashMap<String,Object> body);

        //设置多个通道的多个码流参数
        Observable<BaseBean<EmptyBean>> setStreamParams(String deviceSn, int channelId, HashMap<String,Object> body);

        //恢复默认设置
        Observable<BaseBean<EmptyBean>> setDefaultCfg(String deviceSn, int channelId, HashMap<String,Object> body);


        //低功耗参数获取接口
        Observable<BaseBean<DevGetLowPowerBean.ResultBean>> getDevGetLowPowerParam(String deviceSn, int channelId, HashMap<String, Object> body);

        //低功耗参数设置接口
        Observable<BaseBean<EmptyBean>> setDevGetLowPowerParam(String deviceSn, int channelId, HashMap<String, Object> body);


        //挥手呼叫参数获取接口
        Observable<BaseBean<IntelligenceWaveHandCallParam.ResultBean>> getWaveHandCallParam(String deviceSn, int channelId, HashMap<String, Object> body);

        //挥手呼叫参数设置接口
        Observable<BaseBean<EmptyBean>> setWaveHandCallParam(String deviceSn, int channelId, HashMap<String, Object> body);

        //获取alarmlinkid接口
        Observable<BaseBean<AlarmLinkIdBean.ResultBean>> getAlarmLinkId(String deviceSn, int channelId, String module);

        //获取4G卡列表
        Observable<BaseBean<SimCardListBean.ResultBean>> getSimCardList(String deviceSn, int channelId, HashMap<String,Object> body);

        //设置要使用的sim卡
        Observable<BaseBean<EmptyBean>> setSimCard(String deviceSn, int channelId, HashMap<String,Object> body);

        //查询4G卡厂商 -2023.7.20
        Observable<BaseBean<Device4GIccidBean>> get4GDeviceIccid(String deviceSn);
    }

    interface View extends BaseView {
        void getGtrackCalibrationSuccess(GtrackGetCalibrationBean.ResultBean resultBean);

        void getGtrackCalibrationFailed(Throwable t);

        void getDeviceInfoSuccess(OctDevInfoBean.ResultBean octDevInfoBean);

        void getDeviceInfoError(Throwable e);


        void getChannelsFeaturesSuccess(OctChannelAbilityBean.ResultBean resultBean,String deviceSn, int channelId);

        void getChannelsFeaturesError(Throwable e,String deviceSn, int channelId);

        void getHideStatusSuccess(EnableBean enableBean);

        void getHideStatusError(Throwable e);

        void setHideStatusSuccess();

        void setHideStatusError(Throwable e);

        void deleteDevicesSuccess();

        void deleteDevicesError(Throwable e);

        void deviceDetailSuccess(DeviceBean deviceBean);

        void deviceDetailError(Throwable e);

        void snapshotSuccess(SnapShotBean snapShotBean);

        void snapshotError(Throwable e);

        void getRecordModeSuccess(OctRecordGetInfoBean.ResultBean recordModeBean);

        void getRecordModeError(Throwable e);

        void setRecordModeSuccess();

        void setRecordModeError(Throwable e);

        void editDeviceNameSuccess();

        void editDeviceNameError(Throwable e);

        void editDeviceChannelNameSuccess();

        void editDeviceChannelNameError(Throwable e);


        void getEncryptStatusSuccess(EnableBean enableBean);

        void getEncryptStatusError(Throwable e);

        void setEncryptStatusSuccess();

        void setEncryptStatusError(Throwable e);

        void getAudioStatusSuccess(EnableBean enableBean);

        void getAudioStatusError(Throwable e);

        void setAudioStatusSuccess();

        void setAudioStatusError(Throwable e);

        void setLEDStatusSuccess();

        void setLEDStatusError(Throwable e);

        void getLEDStatusSuccess(IndicatorLedBean indicatorLedBean);

        void getLEDStatusError(Throwable e);

        void getStorageSuccess(List<StorageBean> storageBeans);

        void getStorageError(Throwable e);

        void setDefaultFactorySuccess(boolean isSimple);

        void setDefaultFactoryError(Throwable e);

        void rebootDeviceSuccess();

        void rebootDeviceError(Throwable e);

        void rebootChannelDeviceSuccess();

        void rebootChannelDeviceError(Throwable e);

        void formatSDCardSuccess();

        void formatSDCardError(Throwable e);

        void getVersionSuccess(VersionBean versionBean);

        void getVersionError(Throwable e);

        void upgradeVersionSuccess();

        void upgradeVersionError(Throwable e);

        void getUpgradeStatusSuccess(UpgradeProgressBean upgradeProgressBean);

        void getUpgradeStatusError(Throwable e);

        void updateShareStatusSuccess();

        void updateShareStatusError(Throwable e);

        void getScreenOverturnSuccess(GetScreenOverTurnBean getScreenOverTurnBean);

        void getScreenOverturnError(Throwable e);

        void controlScreenOverturnSuccess();

        void controlScreenOverturnError(Throwable e);

        void editChannelNameSuccess();

        void editChannelNameError(Throwable e);

        void getChannelDetailSuccess(ChannelBean channelBean);

        void getChannelDetailError(Throwable throwable);

        void formatSDCardProgressSuccess(FormatProgressBean formatProgressBean);

        void formatSDCardProgressError(Throwable e);



        void getDeviceWifiInfoSuccess(DeviceConnectNetBean deviceConnectNetBean);

        void getDeviceWifiInfoError(Throwable e);


        void getDeviceApWifiListSuccess(OctWifiListAp.ResultBean deviceWifiListBean);

        void getDeviceApWifiListError(Throwable e);


        void deviceWifiConfigSuccess(EmptyBean emptyBean);

        void deviceWifiConfigError(Throwable e);

        void isSharedSuccess(IsSharedResponseBean isSharedResponseBean);

        void isSharedError(Throwable e);


        void getPlayUrlSuccess(PlayUrlBean playUrlBean);

        void getPlayUrlFailed(Throwable e);


        void getDayNightParamSuccess(OctImageDncutParamBean.ResultBean octImageDncutResultBean);
        void getDayNightParamError(Throwable e);

        void setDayNightParamSuccess(EmptyBean emptyBean);
        void setDayNightParamError(Throwable e);

        void getImageAbilitySuccess(OctImageAbilityGetBean.ResultBean octImageAbilityBean);
        void getImageAbilityError(Throwable e);

        void getAlarmSoundListSuccess(OctAlarmSoundListGetBean.ResultBean bean);
        void getAlarmSoundListError(Throwable e);

        void getHourlyChimeSuccess(DeviceHourlyChimeBean.ResultBean bean);
        void getHourlyChimeError(Throwable e);

        void setHourlyChimeSuccess(EmptyBean emptyBean);
        void setHourlyChimeError(Throwable e);

        void getAlarmSoundPlanSuccess(AlarmSoundPlanBean.ResultBean bean);
        void getAlarmSoundPlanError(Throwable e);

        void setAlarmSoundPlanSuccess(EmptyBean emptyBean);
        void setAlarmSoundPlanError(Throwable e);


        void getOnVifDiscoveryFlagSuccess(OnvifGetDiscoveryInfo.ResultBean resultBean);
        void getOnVifDiscoveryFlagError(Throwable e);


        void setOnVifDiscoveryFlagSuccess(EmptyBean emptyBean);
        void setOnVifDiscoveryFlagError(Throwable e);



        void getStreamAllAbilitySuccess(OctStreamGetAllAbility.ResultBean resultBean);
        void getStreamAllAbilityError(Throwable e);

        void getStreamParamsSuccess(OctStreamGetParams.ResultBean resultBean);
        void getStreamParamsError(Throwable e);

        void setStreamParamsSuccess(EmptyBean emptyBean);
        void setStreamParamsError(Throwable e);

        void setDefaultCfgSuccess(EmptyBean emptyBean);
        void setDefaultCfgError(Throwable e);

        //低功耗参数获取接口
        void getDevGetLowPowerParamSuccess(DevGetLowPowerBean.ResultBean resultBean);
        void getDevGetLowPowerParamError(Throwable e);

        //低功耗参数设置接口
        void setDevGetLowPowerParamSuccess(EmptyBean emptyBean);
        void setDevGetLowPowerParamError(Throwable e);

        //挥手呼叫参数获取接口
        void getWaveHandCallParamSuccess(IntelligenceWaveHandCallParam.ResultBean resultBean);
        void getWaveHandCallParamError(Throwable e);

        //挥手呼叫参数设置接口
        void setWaveHandCallParamSuccess(EmptyBean emptyBean);
        void setWaveHandCallParamError(Throwable e);

        void getAlarmLinkIdSuccess(AlarmLinkIdBean.ResultBean resultBean);
        void getAlarmLinkIdError(Throwable e);

        //获取4G卡列表
        void getSimCardListSuccess(SimCardListBean.ResultBean resultBean);
        void getSimCardListError(Throwable e);

        //设置要使用的sim卡
        void setSimCardSuccess(EmptyBean emptyBean);
        void setSimCardError(Throwable e);

        void get4GDeviceIccidSuccess(Device4GIccidBean device4GIccidBean,String iccid);
        void get4GDeviceIccidError(Throwable e,String iccid);

    }

}
