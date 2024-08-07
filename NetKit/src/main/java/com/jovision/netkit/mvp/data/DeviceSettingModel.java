package com.jovision.netkit.mvp.data;

import com.alibaba.fastjson.JSONArray;
import com.jovision.netkit.mvp.Constant;
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
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.data.http.PlayUrlBean;
import com.jovision.netkit.mvp.data.http.TransCmdHelper;
import com.jovision.netkit.mvp.presenter.contract.DeviceSettingContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;

public class DeviceSettingModel implements DeviceSettingContract.IDeviceSettingModel {
    private ApiService mApiService;

    public DeviceSettingModel(ApiService mApiService) {
        this.mApiService = mApiService;
    }



    //    {	// 获取标定状态
//        "method": "gtrack_get_calibration",
//            "level":"Operator",
//            "param": {
//        "channel_id":-1		// 通道号
//    },
//        "result": {
//        "bcalibration": true
//    },
//        "error": {}
//    }

    // 标定相关接口-1 获取标定状态
    @Override
    public Observable<BaseBean<GtrackGetCalibrationBean.ResultBean>> getGtrackCalibration(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);
        param.put("channelId", channelId);
        param.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(param), GtrackGetCalibrationBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EnableBean>> getHideStatus(String deviceSn, int channelId) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("deviceSn", deviceSn);
        map.put("channelId", channelId);
        return mApiService.getHideStatus(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setHideStatus(String deviceSn, int channelId, boolean enable) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("deviceSn", deviceSn);
        map.put("channelId", channelId);
        map.put("enable", enable);
        return mApiService.setHideStatus(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<DeviceBean>> deviceDetail(String deviceSn, int channelId) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("deviceSn", deviceSn);
        map.put("channelId", channelId);
        return mApiService.getDeviceDetail(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> deleteDevices(DeleteDevicesBean devices) {

//        try{
//            if(null != devices && null != devices.getDevices()){
//                List<DeleteDeviceBean> deviceBeanList = devices.getDevices();
//                for(int i = 0 ; i < deviceBeanList.size() ; i++){
//                    //删除设备时移除小助手
//                    PlayUtil.deleteCloudSeePreConnect(deviceBeanList.get(i).getDeviceSn());
//                }
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }

        return mApiService.deleteDevices(devices);
    }

    @Override
    public Observable<BaseBean<SnapShotBean>> snapshot(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        return mApiService.snapShot(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<OctRecordGetInfoBean.ResultBean>> getRecordMode(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), OctRecordGetInfoBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setRecordMode(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> editDeviceName(String deviceSn, String deviceName,String accessProtocol) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("deviceName", deviceName);
        parma.put("accessProtocol", accessProtocol);
        return mApiService.editDeviceName(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> editDeviceChannelName(String deviceSn, int channelId, String channelName) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("channelName", channelName);
        return mApiService.editDeviceChannelName(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EnableBean>> getEncryptStatus(String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        return mApiService.getEncryptStatus(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setEncryptStatus(String deviceSn, boolean enable) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("enable", enable);
        return mApiService.setEncryptStatus(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EnableBean>> getAudioStatus(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        return mApiService.getAudioStatus(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setAudioStatus(String deviceSn, int channelId, boolean enable) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("enable", enable);
        return mApiService.setAudioStatus(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setLEDStatus(String deviceSn, int status) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("status", status);
        return mApiService.setLEDStatus(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<IndicatorLedBean>> getLEDStatus(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma),IndicatorLedBean.class);
//        return mApiService.getIndicatorled(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<IndicatorLedBean>>() {
//            @Override
//            public BaseBean<IndicatorLedBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                TransBaseBean<IndicatorLedBean> indicatorLedBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<TransBaseBean<IndicatorLedBean>>(){}.getType());
//                BaseBean<IndicatorLedBean> indicatorLedBeanBaseBean = new BaseBean<>();
//                indicatorLedBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(indicatorLedBean.getError().getErrorcode()));
//                indicatorLedBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                indicatorLedBeanBaseBean.setData(indicatorLedBean.getResult());
//                return indicatorLedBeanBaseBean;
//            }
//        });
    }


    @Override
    public Observable<BaseBean<List<StorageBean>>> getStorage(String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        return mApiService.getStorage(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setDefaultFactory(String deviceSn, int channelId, boolean isSimple) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("bSimple", isSimple);
        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "dev_factory_default");
        body.put("level", "Administrator");
        body.put("param", param);
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> rebootDevice(String deviceSn,int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        return mApiService.rebootDevice(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> rebootChannelDevice(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data",ParamUtil.getMapStr(body));
//        return mApiService.rebootChannelDevice(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(parma),EmptyBean.class);

    }

    @Override
    public Observable<BaseBean<EmptyBean>> formatSDCard(String deviceSn, int diskNum, String diskName, int curPart) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("diskNum", diskNum);
        parma.put("diskName", diskName);
        parma.put("curPart", curPart);
        return mApiService.formatSDCard(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<VersionBean>> getVersion(String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        return mApiService.getVersion(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> upgradeVersion(String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        return mApiService.upgradeVersion(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<UpgradeProgressBean>> getUpgradeStatus(String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        return mApiService.getUpgradeStatus(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> updateShareStatus(String shareNumber, String shareStatus) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("shareNumber", shareNumber);
        parma.put("shareStatus", shareStatus);
        return mApiService.updateShareStatus(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<GetScreenOverTurnBean>> getScreenOverturn(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        return mApiService.getScreenOverturn(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> controlScreenOverturn(String deviceSn, int channelId, boolean overTurn, boolean rotation) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("overTurn", overTurn);
        parma.put("rotation", rotation);
        return mApiService.controlScreenOverturn(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> editChannelName(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data",ParamUtil.getMapStr(body));
//        return mApiService.editChannelName(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(parma),EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<ChannelBean>> getChannelDetail(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        return mApiService.getChannelDetail(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<FormatProgressBean>> formatSDCardProgress(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data",ParamUtil.getMapStr(body));
//        return mApiService.formatSDCardProgress(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(parma),FormatProgressBean.class);

    }

    @Override
    public Observable<BaseBean<OctDevInfoBean.ResultBean>> getDeviceInfo(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data",ParamUtil.getMapStr(body));
//        return mApiService.getDeviceWifiInfo(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(parma), OctDevInfoBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<OctChannelAbilityBean.ResultBean>> getChannelsFeatures(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), OctChannelAbilityBean.ResultBean.class);
    }


    @Override
    public Observable<BaseBean<DeviceConnectNetBean>> getDeviceWifiInfo(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data",ParamUtil.getMapStr(body));
//        return mApiService.getDeviceWifiInfo(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(parma),DeviceConnectNetBean.class);
    }

    @Override
    public Observable<BaseBean<OctWifiListAp.ResultBean>> getDeviceApWifiList(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data",ParamUtil.getMapStr(body));
//        return mApiService.getDeviceApWifiList(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(parma), OctWifiListAp.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> deviceWifiConfig(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data",ParamUtil.getMapStr(body));
//        return mApiService.deviceWifiConfig(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(parma),EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<IsSharedResponseBean>> isShared(String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        return mApiService.isShared(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<List<PlayUrlBean>>> getPlayUrl(String deviceSn, int channelId) {

        JSONArray array = new JSONArray();
        com.alibaba.fastjson.JSONObject bean = new com.alibaba.fastjson.JSONObject();
        bean.put("deviceSn", deviceSn);
        bean.put("channelId", channelId);
        bean.put("streamId", Constant.streamId);
        array.add(bean);

        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceChannels", array);

        return mApiService.getPlayUrl(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<OctImageDncutParamBean.ResultBean>> getDayNightParam(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(parma), OctImageDncutParamBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setDayNightParam(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<OctImageAbilityGetBean.ResultBean>> getImageAbility(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(parma), OctImageAbilityGetBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<OctAlarmSoundListGetBean.ResultBean>> getAlarmSoundList(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(parma),OctAlarmSoundListGetBean.ResultBean.class);

    }

    @Override
    public Observable<BaseBean<DeviceHourlyChimeBean.ResultBean>> getHourlyChime(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(parma),DeviceHourlyChimeBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setHourlyChime(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<AlarmSoundPlanBean.ResultBean>> getAlarmSoundPlan(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), AlarmSoundPlanBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setAlarmSoundPlan(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }


    @Override
    public Observable<BaseBean<OnvifGetDiscoveryInfo.ResultBean>> getOnVifDiscoveryFlag(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), OnvifGetDiscoveryInfo.ResultBean.class);
    }


    @Override
    public Observable<BaseBean<EmptyBean>> setOnVifDiscoveryFlag(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<OctStreamGetAllAbility.ResultBean>> getStreamAllAbility(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), OctStreamGetAllAbility.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<OctStreamGetParams.ResultBean>> getStreamParams(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), OctStreamGetParams.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setStreamParams(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setDefaultCfg(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<IntelligenceWaveHandCallParam.ResultBean>> getWaveHandCallParam(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), IntelligenceWaveHandCallParam.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setWaveHandCallParam(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }


    @Override
    public Observable<BaseBean<DevGetLowPowerBean.ResultBean>> getDevGetLowPowerParam(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), DevGetLowPowerBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setDevGetLowPowerParam(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<AlarmLinkIdBean.ResultBean>> getAlarmLinkId(String deviceSn, int channelId, String module) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "alarm_get_link_id");

        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("module", module);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(treeMapParam), AlarmLinkIdBean.ResultBean.class);
    }


    @Override
    public Observable<BaseBean<SimCardListBean.ResultBean>> getSimCardList(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), SimCardListBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setSimCard(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    //查询4G卡厂商 -2023.7.20
    @Override
    public Observable<BaseBean<Device4GIccidBean>> get4GDeviceIccid(String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceId",deviceSn);
        return mApiService.get4GDeviceIccid(ParamUtil.getBody(parma));
    }
}
