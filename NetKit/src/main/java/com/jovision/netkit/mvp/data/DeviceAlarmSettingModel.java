package com.jovision.netkit.mvp.data;

import com.alibaba.fastjson.JSONObject;
import com.jovision.basekit.LogUtil;
import com.jovision.basekit.deviceid.BASE64;
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
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.data.http.TransCmdHelper;
import com.jovision.netkit.mvp.presenter.contract.DeviceAlarmSettingContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class DeviceAlarmSettingModel implements DeviceAlarmSettingContract.IDeviceAlarmSettingModel {

    private ApiService mApiService;

    public DeviceAlarmSettingModel(ApiService apiService) {
        this.mApiService = apiService;
    }


    @Override
    public Observable<BaseBean<DeviceAlarmBean>> sendCmdForAlarm(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
//        return mApiService.sendCmdForAlarm(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), DeviceAlarmBean.class);

    }

    @Override
    public Observable<BaseBean<DeviceAlarmZhoujieBean>> getParamsForZhoujie(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
//        return mApiService.getParamsForZhoujie(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), DeviceAlarmZhoujieBean.class);
    }

    @Override
    public Observable<BaseBean<DeviceSmartTrackBean>> getSmartTrackParam(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
//        return mApiService.getSmartTrackParam(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), DeviceSmartTrackBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> openDeviceSmartTracking(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
//        return mApiService.openDeviceSmartTracking(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setMotionAndHumanParams(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
//        return mApiService.setMotionAndHumanParams(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setZhoujieParams(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
//        return mApiService.setZhoujieParams(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);

    }

    @Override
    public Observable<BaseBean<DeviceAlarmZhanDaoBean>> getParamsForZhanDao(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), DeviceAlarmZhanDaoBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setZhanDaoParams(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<DeviceAlarmLiGangBean>> getParamsForLiGang(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), DeviceAlarmLiGangBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setLiGangParams(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<DeviceAlarmCryBean>> getCryAlarmParams(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), DeviceAlarmCryBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setCryAlarmParams(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<DeviceAlarmPetBean>> getPetAlarmParams(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), DeviceAlarmPetBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setPetAlarmParams(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<IntelligenceAbilityBean>> getIntelligenceAbility(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), IntelligenceAbilityBean.class);
    }

    @Override
    public Observable<BaseBean<OctIvpBean.ResultBean>> getIvpSupport(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), OctIvpBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<DefencePlanBean>> getDefencePlan(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), DefencePlanBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setDefencePlan(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<AlarmSoundBean>> getAlarmSound(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
//        return mApiService.getAlarmSound(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), AlarmSoundBean.class);

    }

    @Override
    public Observable<BaseBean<OctAlarmSoundListGetBean.ResultBean>> getAlarmSoundList(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), OctAlarmSoundListGetBean.ResultBean.class);

    }


    @Override
    public Observable<BaseBean<EmptyBean>> devicePlayAlarmSound(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);

    }

    @Override
    public Observable<BaseBean<EmptyBean>> addAlarmSound(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);

    }

    @Override
    public Observable<BaseBean<EmptyBean>> deleteAlarmSound(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);

    }


    @Override
    public Observable<BaseBean<EmptyBean>> setAlarmSound(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
//        return mApiService.setAlarmSound(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);

    }

    @Override
    public Observable<BaseBean<AlarmSoundVolumeBean>> getAlarmSoundVolume(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
//        return mApiService.getAlarmSoundVolume(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<AlarmSoundVolumeBean>>() {
//            @Override
//            public BaseBean<AlarmSoundVolumeBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                TransBaseBean<AlarmSoundVolumeBean> alarmSoundVolumeBeanTransBaseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<TransBaseBean<AlarmSoundVolumeBean>>() {}.getType());
//                BaseBean<AlarmSoundVolumeBean> alarmSoundVolumeBeanBaseBean = new BaseBean<>();
//                alarmSoundVolumeBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(alarmSoundVolumeBeanTransBaseBean.getError().getErrorcode()));
//                alarmSoundVolumeBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                alarmSoundVolumeBeanBaseBean.setData(alarmSoundVolumeBeanTransBaseBean.getResult());
//                return alarmSoundVolumeBeanBaseBean;
//            }
//        });
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), AlarmSoundVolumeBean.class);

    }

    @Override
    public Observable<BaseBean<EmptyBean>> setAlarmSoundVolume(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
//        return mApiService.setAlarmSoundVolume(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);

    }

    @Override
    public Observable<BaseBean<OctAlarmLinkGetBean.ResultBean>> getAlarmLink(String deviceSn, int channelId, int alarmLinkId) {
        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "alarm_link_get");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("link_id", alarmLinkId);
        param.put("bdefault", false);
        body.put("param", param);

        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), OctAlarmLinkGetBean.ResultBean.class);

    }


    @Override
    public Observable<BaseBean<EmptyBean>> setAlarmLink(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);

    }


    @Override
    public Observable<BaseBean<HideAlarmBean.ResultBean>> getHideAlarmParams(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
//        return mApiService.getHideAlarmParams(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), HideAlarmBean.ResultBean.class);

    }

    @Override
    public Observable<BaseBean<EmptyBean>> setHideAlarmParams(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
//        return mApiService.setHideAlarmParams(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<ChannelBean>> getChannelDetail(String deviceNo, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceNo);
        parma.put("channelId", channelId);
        return mApiService.getChannelDetail(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<DeviceBean>> getDeviceAbility(String deviceNo) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceNo);
        return mApiService.getDeviceDetail(ParamUtil.getBody(parma));
    }

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
    public Observable<BaseBean<OctIvpVfBean.ResultBean>> getParamsForVFS(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);
        param.put("channelId", channelId);
        param.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(param), OctIvpVfBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setParamsForVFS(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
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
    public Observable<BaseBean<SmartAbilityDetailBean>> getCryPetDetail(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        return mApiService.getSmartAbilityDetail(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<RDLPRSystemGetParam>> getParamLPRSystem(String deviceSn, int channelId) {

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "dev_trans_userparam");
        body.put("level", "Operator");

        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("owner", "Jovision");


        JSONObject reqDataObj = new JSONObject();
        reqDataObj.put("package", "LPRSystem");
        reqDataObj.put("method", "get_param");
        reqDataObj.put("param", new JSONObject());

//        new String(BASE64.encode(cipher.doFinal(encryptString.getBytes("UTF-8"))));
        try {
            param.put("req_data", new String(BASE64.encode((reqDataObj.toString()).getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        body.put("param", param);

        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));

        LogUtil.e("okhttp", "getParamLPRSystem.data=" + ParamUtil.getMapStr(body));


        return TransCmdHelper.getInstance().transCmdJesBase64(mApiService, ParamUtil.getBody(parma), RDLPRSystemGetParam.class);

    }

    @Override
    public Observable<BaseBean<EmptyBean>> setParamLPRSystem(String deviceSn, int channelId, RDLPRSystemGetParam.ResultBean resultBean) {


        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "dev_trans_userparam");
        body.put("level", "Operator");

        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("owner", "Jovision");


        JSONObject reqDataObj = new JSONObject();
        reqDataObj.put("package", "LPRSystem");
        reqDataObj.put("method", "set_param");
        reqDataObj.put("param", resultBean);

        LogUtil.e("okhttp", "setParamLPRSystem.setParam=" + reqDataObj.getString("param"));
        try {
            param.put("req_data", new String(BASE64.encode((reqDataObj.toString()).getBytes("UTF-8"))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        body.put("param", param);

        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));


        LogUtil.e("okhttp", "setParamLPRSystem.data=" + ParamUtil.getMapStr(body));

       
        return TransCmdHelper.getInstance().transCmdJesBase64(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setSmartAppAlarmVoice(String deviceSn, int channelId, SmartAppAlarmVoiceBean.Param reqParam) {
        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "dev_trans_userparam");
        body.put("level", "Operator");

        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("owner", "Jovision");

        JSONObject reqDataObj = new JSONObject();
        reqDataObj.put("package", "AlarmManager");
        reqDataObj.put("method", "set_linkage");
        reqDataObj.put("param", reqParam);
        LogUtil.e("okhttp", "setSmartAppAlarmVoice.setParam=" + reqDataObj.toString());
        try {
            param.put("req_data", new String(BASE64.encode((reqDataObj.toString()).getBytes("UTF-8"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        body.put("param", param);
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        LogUtil.e("okhttp", "setSmartAppAlarmVoice.data=" + ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmdJesBase64(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<SmartAppAlarmVoiceResBean>> getSmartAppAlarmVoice(String deviceSn, int channelId, SmartAppAlarmVoiceBean.Param reqParam) {
        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "dev_trans_userparam");
        body.put("level", "Operator");

        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("owner", "Jovision");

        JSONObject reqDataObj = new JSONObject();
        reqDataObj.put("package", "AlarmManager");
        reqDataObj.put("method", "get_linkage");
        reqDataObj.put("param", reqParam);
        LogUtil.e("okhttp", "getSmartAppAlarmVoice.Param=" + reqDataObj.toString());
        try {
            param.put("req_data", new String(BASE64.encode((reqDataObj.toString()).getBytes("UTF-8"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        body.put("param", param);
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        LogUtil.e("okhttp", "getSmartAppAlarmVoice.data=" + ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmdJesBase64(mApiService, ParamUtil.getBody(parma), SmartAppAlarmVoiceResBean.class);
    }
}
