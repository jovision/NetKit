package com.jovision.netkit.mvp.data;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jovision.basekit.LogUtil;
import com.jovision.basekit.deviceid.BASE64;
import com.jovision.netkit.mvp.JVCloudConst;
import com.jovision.netkit.mvp.JVSetParamConst;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.CallUrlBean;
import com.jovision.netkit.mvp.data.bean.ControlTokenBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.RDLPRSystemGetParam;
import com.jovision.netkit.mvp.data.bean.response.AlarmLinkIdBean;
import com.jovision.netkit.mvp.data.bean.response.AlarmStatusBean;
import com.jovision.netkit.mvp.data.bean.response.EnableBean;
import com.jovision.netkit.mvp.data.bean.response.ErrorBean;
import com.jovision.netkit.mvp.data.bean.response.GtrackGetCalibrationBean;
import com.jovision.netkit.mvp.data.bean.response.IntelligenceAbilityBean;
import com.jovision.netkit.mvp.data.bean.response.IntelligenceWaveHandCallParam;
import com.jovision.netkit.mvp.data.bean.response.OctAccountModifyUserBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmLinkDefenceBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmLinkGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctBaseResponseBean;
import com.jovision.netkit.mvp.data.bean.response.OctChannelAbilityBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevGetVC;
import com.jovision.netkit.mvp.data.bean.response.OctDevInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageAbilityGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageAdjustParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageDncutParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzAbilityBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzGuardGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzPatrolCreateBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzPatrolGetNodesBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzPatrolsGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzPresetsGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzSpeedBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzTimeTaskGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzTimeTaskListGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzTrailGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctSDCardFormatProBean;
import com.jovision.netkit.mvp.data.bean.response.OctSDCardInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctStreamGetParams;
import com.jovision.netkit.mvp.data.bean.response.ShareToMeBean;
import com.jovision.netkit.mvp.data.bean.response.SimCardListBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAbilityDetailBean;
import com.jovision.netkit.mvp.data.bean.response.SnapDateBean;
import com.jovision.netkit.mvp.data.bean.response.SnapFileListBean;
import com.jovision.netkit.mvp.data.bean.response.StorageBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.data.http.ConnectUrlBean;
import com.jovision.netkit.mvp.data.http.PlayUrlBean;
import com.jovision.netkit.mvp.data.http.TransCmdHelper;
import com.jovision.netkit.mvp.presenter.contract.PtzContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


/**
 * Created by ZHP on 2017/11/6.
 */

public class PtzModel implements PtzContract.IPtzModel {

    private ApiService mApiService;

    public PtzModel(ApiService apiService) {
        this.mApiService = apiService;
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


//    {	// 开始标定
//        "method": "gtrack_set_calibration",
//            "level":"Operator",
//            "param": {
//        "channel_id":-1,		// 通道号
//                "mode":"auto, manual"	// 自动和手动标定模式
//    },
//        "result": {},
//        "error": {}
//    }

    // 标定相关接口-2 开始标定
    @Override
    public Observable<BaseBean<EmptyBean>> setGtrackCalibration(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);
        param.put("channelId", channelId);
        param.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(param), EmptyBean.class);
    }



//    {	// 设置枪球联动标定位置
//        "method": "gtrack_add_mark_point",
//            "level":"Operator",
//            "param": {
//        "channelid": 0,		// 通道号
//                "x": 65535,			// x位置，范围0-65535
//                "y": 65535	 		// y位置，范围0-65535
//    },
//        "result": {},
//        "error": {}
//    }

    // 标定相关接口-3 设置枪球联动标定位置
    @Override
    public Observable<BaseBean<EmptyBean>> addGtrackMarkPoint(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);
        param.put("channelId", channelId);
        param.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(param), EmptyBean.class);
    }


//    { // 设置守望点
//        "method": "gtrack_set_guard",
//            "level":"Operator",
//            "param": {
//        "channelid":-1 // 通道号
//    },
//        "result": {},
//        "error": {}
//    }


    // 标定相关接口-4 设置守望点(设为跟踪初始位置)
    @Override
    public Observable<BaseBean<EmptyBean>> setGtrackGuard(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);
        param.put("channelId", channelId);
        param.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(param), EmptyBean.class);
    }

//    // 普通球机设为跟踪初始位置
//    @Override
//    public Observable<BaseBean<EmptyBean>> setTraceGuard(String deviceSn, int channelId, HashMap<String, Object> body) {
//        TreeMap<String, Object> param = ParamUtil.getParma();
//        param.put("deviceSn", deviceSn);
//        param.put("channelId", channelId);
//        param.put("data", ParamUtil.getMapStr(body));
//        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(param), EmptyBean.class);
//    }


    //    {	// 手动定位
//        "method": "gtrack_manual_position",
//            "level":"Operator",
//            "param": {
//        "channelid":-1,		// 通道号
//                "position": {		//(x, y, w, h) 圈定区域中心坐标及宽高,坐标范围 0-65535
//            "x": 0,
//                    "y": 0,
//                    "w": 0,
//                    "h": 0
//        }
//    },
//        "result": {},
//        "error": {}
//    }

    // 标定相关接口-5 手动定位
    @Override
    public Observable<BaseBean<EmptyBean>> manualGtrackPosition(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);
        param.put("channelId", channelId);
        param.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(param), EmptyBean.class);
    }


//    {    // 清空标定点
//        "method": "gtrack_clear_point",
//            "level":"Operator",
//            "param": {
//        "channelid":-1		// 通道号
//    },
//        "result": {},
//        "error": {}
//    }

    // 标定相关接口-6 清空标定点
    @Override
    public Observable<BaseBean<EmptyBean>> clearGtrackPoint(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);
        param.put("channelId", channelId);
        param.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(param), EmptyBean.class);
    }



    @Override
    public Observable<BaseBean<EmptyBean>> oneKeyCallPublic(String deviceSn, int channelId,String status) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "dev_set_active_call");
        HashMap<String, Object> param = new HashMap<>();
//        param.put("channelid", channelId);
        param.put("status",status);
        body.put("param", param);

        parma.put("data", ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<CallUrlBean>> getCallUrl(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);

        return mApiService.getCallUrl(ParamUtil.getBody(parma));
    }




    @Override
    public Observable<BaseBean<List<PlayUrlBean>>> getMultiPlayUrl(String deviceSn, ArrayList<Integer> channelList, int streamId) {//Constant.streamId

        JSONArray array = new JSONArray();
        if(null != channelList && channelList.size() > 0){
            for(int i = 0 ; i < channelList.size() ; i++){
                com.alibaba.fastjson.JSONObject bean = new com.alibaba.fastjson.JSONObject();
                bean.put("deviceSn", deviceSn);
                bean.put("channelId", channelList.get(i));
                bean.put("streamId", streamId);
                array.add(bean);
            }
        }


        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceChannels", array);

        return mApiService.getPlayUrl(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<List<PlayUrlBean>>> getPlayUrl(String deviceSn, int channelId, int streamId) {//Constant.streamId

        JSONArray array = new JSONArray();
        com.alibaba.fastjson.JSONObject bean = new com.alibaba.fastjson.JSONObject();
        bean.put("deviceSn", deviceSn);
        bean.put("channelId", channelId);
        bean.put("streamId", streamId);
        array.add(bean);

        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceChannels", array);

        return mApiService.getPlayUrl(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<List<PlayUrlBean>>> getOneKeyCallPlayUrl(String deviceSn, int channelId, int streamId) {
        JSONArray array = new JSONArray();
        com.alibaba.fastjson.JSONObject bean = new com.alibaba.fastjson.JSONObject();
        bean.put("deviceSn", deviceSn);
        bean.put("channelId", channelId);
        bean.put("streamId", streamId);
        array.add(bean);

        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceChannels", array);

        return mApiService.getOneKeyCallPlayUrl(ParamUtil.getBody(parma));
    }


    @Override
    public Observable<BaseBean<List<ConnectUrlBean>>> getYstPlayUrl(String deviceSn, int channelId, String deviceIp, int devicePort) {

        JSONArray array = new JSONArray();
        com.alibaba.fastjson.JSONObject bean = new com.alibaba.fastjson.JSONObject();
        bean.put("deviceSn", deviceSn);
        bean.put("channelId", channelId);
//        bean.put("streamId", Constant.streamId);

        if(!deviceIp.isEmpty() && null != deviceIp){
            bean.put("deviceIp", deviceIp);
            bean.put("devicePort", devicePort);
        }

        array.add(bean);

        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceChannels", array);

        return mApiService.getYstPlayUrl(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<OctDevInfoBean.ResultBean>> getPublicDeviceInfo(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
//        return mApiService.getDeviceWifiInfo(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), OctDevInfoBean.ResultBean.class);
    }


    @Override
    public Observable<BaseBean<OctChannelAbilityBean.ResultBean>> getChannelsFeatures(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), OctChannelAbilityBean.ResultBean.class);
    }



    //50 云视通2.0NVR获取通道能力
    @Override
    public Observable<BaseBean<OctChannelAbilityBean>> octGetChannelsFeatures(String deviceSn, int channelId, String devUser, String devPwd,boolean isAp) {

        TreeMap<String, Object> parma = ParamUtil.getParma();

        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }

        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "channels_features_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetChannelsFeatures(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctChannelAbilityBean>>() {
            @Override
            public BaseBean<OctChannelAbilityBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctChannelAbilityBean octChannelAbilityBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctChannelAbilityBean>() {}.getType());

                BaseBean<OctChannelAbilityBean> octChannelAbilityBaseBean = new BaseBean<>();
                octChannelAbilityBaseBean.setCode(stringBaseBean.getCode());
                octChannelAbilityBaseBean.setMsg(stringBaseBean.getMsg());
                octChannelAbilityBaseBean.setData(octChannelAbilityBean);

                return octChannelAbilityBaseBean;
            }
        });

    }

    @Override
    public Observable<BaseBean<ControlTokenBean>> getControlToken(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);

        return mApiService.getControlToken(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> releaseControlToken(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);

        return mApiService.releaseControlToken(ParamUtil.getBody(parma));
    }


    //1.云台控制-云台速度获取-公有云协议
    @Override
    public Observable<BaseBean<OctPtzSpeedBean.ResultBean>> ptzMoveStatGet(String deviceSn, int channelId, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_move_stat_get");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(treeMapParam),OctPtzSpeedBean.ResultBean.class);

    }

    //2.云台控制-控制移动-公有云协议（包含放大，缩小）
    @Override
    public Observable<BaseBean<EmptyBean>> ptzControl(String deviceSn, int channelId, String controlToken, int panLeft, int tiltUp, int zoomIn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("controlToken", controlToken);
        parma.put("panLeft", panLeft);
        parma.put("tiltUp", tiltUp);
        parma.put("zoomIn", zoomIn);

        return mApiService.ptzControl(ParamUtil.getBody(parma));
    }


    //3.云台控制-停止移动-公有云协议
    @Override
    public Observable<BaseBean<EmptyBean>> ptzControlStop(String deviceSn, int channelId, String controlToken) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("controlToken", controlToken);

        return mApiService.ptzControlStop(ParamUtil.getBody(parma));
    }


    //4.云台控制-聚焦和光圈-公有云协议
    @Override
    public Observable<BaseBean<EmptyBean>> ptzFiStart(String deviceSn, int channelId,int focusFar, int irisOpen, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_fi_start");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("focusFar", focusFar);
        param.put("irisOpen", irisOpen);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd(mApiService,ParamUtil.getBody(treeMapParam),EmptyBean.class);

    }


    //5.云台控制-停止聚焦和光圈-公有云协议
    @Override
    public Observable<BaseBean<EmptyBean>> ptzFiStop(String deviceSn, int channelId, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_fi_stop");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd(mApiService,ParamUtil.getBody(treeMapParam),EmptyBean.class);
    }


    //6.云台控制-云台自动旋转-公有云协议
    @Override
    public Observable<BaseBean<EmptyBean>> ptzAuto(String deviceSn, int channelId,int speed,String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_auto");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("speed", speed);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd(mApiService,ParamUtil.getBody(treeMapParam),EmptyBean.class);
    }





    //7.云台控制-获取云台能力--公有云协议
    @Override
    public Observable<BaseBean<OctPtzAbilityBean.ResultBean>> ptzAbilityGet(String deviceSn, int channelId, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_ability_get");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd(mApiService,ParamUtil.getBody(treeMapParam), OctPtzAbilityBean.ResultBean.class);
    }

    //7.1云台控制-获取云台能力--公有云协议，透传命令，不需要带token
    @Override
    public Observable<BaseBean<OctPtzAbilityBean.ResultBean>> ptzAbilityGetNoToken(String deviceSn, int channelId) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_ability_get");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(treeMapParam), OctPtzAbilityBean.ResultBean.class);
    }



    //8.云台控制-获取预置点-公有云协议
    @Override
    public Observable<BaseBean<OctPtzPresetsGetBean.ResultBean>> ptzPresetsGet(String deviceSn, int channelId, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_presets_get");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd(mApiService,ParamUtil.getBody(treeMapParam), OctPtzPresetsGetBean.ResultBean.class);
    }





    //9.云台控制-设置预置点-公有云协议
    @Override
    public Observable<BaseBean<ErrorBean>> ptzPresetSet(String deviceSn, int channelId, int presetNo, String name, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_preset_set");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("presetno", presetNo);
        param.put("name", name);

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }


    //10.云台控制-调用预置点-公有云协议
    @Override
    public Observable<BaseBean<ErrorBean>> ptzPresetLocate(String deviceSn, int channelId, int presetNo, int moveSpeed, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_preset_locate");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("presetno", presetNo);
        param.put("movespeed", moveSpeed);

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }

    //11.云台控制-删除预置点-公有云协议
    @Override
    public Observable<BaseBean<ErrorBean>> ptzPresetDelete(String deviceSn, int channelId, int presetNo, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_preset_delete");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("presetno", presetNo);

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }


    //12.云台控制-获取巡航-公有云协议
    @Override
    public Observable<BaseBean<OctPtzPatrolsGetBean.ResultBean>> ptzPatrolsGet(String deviceSn, int channelId, int patrolId, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_patrols_get");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("patrolid", patrolId);//从0开始, -1：获取全部巡航的信息

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd(mApiService,ParamUtil.getBody(treeMapParam), OctPtzPatrolsGetBean.ResultBean.class);
    }


    //13.云台控制-创建巡航-公有云协议
    @Override
    public Observable<BaseBean<OctPtzPatrolCreateBean.ResultBean>> ptzPatrolCreate(String deviceSn, int channelId, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_patrol_create");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd(mApiService,ParamUtil.getBody(treeMapParam), OctPtzPatrolCreateBean.ResultBean.class);
    }

    //14.云台控制-删除巡航-公有云协议
    @Override
    public Observable<BaseBean<ErrorBean>> ptzPatrolDelete(String deviceSn, int channelId, int patrolId, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_patrol_delete");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("patrolid", patrolId);

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }


    //15.云台控制-调用巡航-公有云协议
    @Override
    public Observable<BaseBean<ErrorBean>> ptzPatrolLocate(String deviceSn, int channelId, int patrolId, int speed,String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_patrol_locate");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("patrolid", patrolId);//从0开始
        param.put("speed",speed);//0：全速 1：1/2倍速 2：1/4倍速 3：1/8倍速 4：1/16倍速 5：1/32倍速

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }


    //16.云台控制-停止巡航-公有云协议
    @Override
    public Observable<BaseBean<ErrorBean>> ptzPatrolStop(String deviceSn, int channelId, int patrolId,String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_patrol_stop");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("patrolid", patrolId);//从0开始

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }

    //17.云台控制-获取巡航节点-公有云协议
    @Override
    public Observable<BaseBean<OctPtzPatrolGetNodesBean.ResultBean>> ptzPatrolGetNodes(String deviceSn, int channelId, int patrolId, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_patrol_get_nodes");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("patrolid", patrolId);//从0开始

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd(mApiService,ParamUtil.getBody(treeMapParam), OctPtzPatrolGetNodesBean.ResultBean.class);
    }


    //18.云台控制-添加巡航节点-公有云协议
    @Override
    public Observable<BaseBean<ErrorBean>> ptzPatrolAddNode(String deviceSn, int channelId, int patrolId,int presetNo,int staySeconds, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_patrol_add_node");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("patrolid", patrolId);//从0开始
        param.put("presetno", presetNo);
        param.put("staySeconds", staySeconds);//5~86400秒

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }

    //19.云台控制-删除巡航节点-公有云协议
    @Override
    public Observable<BaseBean<ErrorBean>> ptzPatrolDelNode(String deviceSn, int channelId, int patrolId, int presetIndex,String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_patrol_del_node");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("patrolid", patrolId);
        param.put("presetindex",presetIndex);

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }

    //20.云台控制-设置巡航速度-公有云协议
    @Override
    public Observable<BaseBean<ErrorBean>> ptzPatrolSetSpeed(String deviceSn, int channelId, int patrolId, int speed,String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_patrol_set_speed");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("patrolid", patrolId);//从0开始
        param.put("speed",speed);//0：全速 1：1/2倍速 2：1/4倍速 3：1/8倍速 4：1/16倍速 5：1/32倍速

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }


    //21.云台控制-设置巡航时间-公有云协议
    @Override
    public Observable<BaseBean<ErrorBean>> ptzPatrolSetStaySeconds(String deviceSn, int channelId, int patrolId, int staySeconds,String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_patrol_set_stay_seconds");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("patrolid", patrolId);//从0开始
        param.put("staySeconds",staySeconds);//单位秒

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }


    //22.云台控制-开始或者完成轨迹录制-公有云
    @Override
    public Observable<BaseBean<ErrorBean>> ptzTrailRec(String deviceSn, int channelId, int trailId, boolean bStart,String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_trail_rec");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("trailid", trailId);//轨迹id，从0开始
        param.put("bstart",bStart);//true：开始录制 false：完成录制

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }

    //23.云台控制-启动或者停止轨迹-公有云
    @Override
    public Observable<BaseBean<ErrorBean>> ptzTrailAction(String deviceSn, int channelId, int trailId, boolean bStart,String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_trail_action");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("trailid", trailId);//轨迹id，从0开始
        param.put("bstart",bStart);//true：启动 false：停止

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }


    //24.云台控制-获取轨迹-公有云
    @Override
    public Observable<BaseBean<OctPtzTrailGetBean.ResultBean>> ptzTrailGet(String deviceSn, int channelId, int trailId, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_trail_get");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("trailid", trailId);//轨迹id，从0开始

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd(mApiService,ParamUtil.getBody(treeMapParam), OctPtzTrailGetBean.ResultBean.class);
    }


    //25.云台控制-获取守望-公有云
    @Override
    public Observable<BaseBean<OctPtzGuardGetBean.ResultBean>> ptzGuardGet(String deviceSn, int channelId, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_guard_get");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd(mApiService,ParamUtil.getBody(treeMapParam), OctPtzGuardGetBean.ResultBean.class);
    }



    //26.云台控制-设置守望-公有云协议
    @Override
    public Observable<BaseBean<ErrorBean>> ptzGuardSet(String deviceSn, int channelId, int preset, int staySeconds,String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_guard_set");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("preset", preset);//预置点
        param.put("staySeconds",staySeconds);//停留时间，单位秒

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }


    //27.云台控制-启动或者停止守望-公有云协议
    @Override
    public Observable<BaseBean<ErrorBean>> ptzGuardAction(String deviceSn, int channelId, boolean bStart,String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_guard_action");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("bstart", bStart);//true：启动 false：停止

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }


    //28.云台控制-暂停或者复位守望-公有云协议
    @Override
    public Observable<BaseBean<ErrorBean>> ptzGuardPause(String deviceSn, int channelId, boolean bPause,String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_guard_pause");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("bpause", bPause);//true：暂停 false：复位

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }

    //29.云台控制-获取定时任务列表-公有云协议
    @Override
    public Observable<BaseBean<OctPtzTimeTaskListGetBean.ResultBean>> ptzTimeTaskListGet(String deviceSn, int channelId, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_time_task_list_get");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd(mApiService,ParamUtil.getBody(treeMapParam), OctPtzTimeTaskListGetBean.ResultBean.class);
    }


    //30.云台控制-获取定时任务-公有云协议
    @Override
    public Observable<BaseBean<OctPtzTimeTaskGetBean.ResultBean>> ptzTimeTaskGet(String deviceSn, int channelId, int taskId, String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_time_task_get");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("taskid", taskId);//定时任务编号，从0开始。-1，获取所有

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd(mApiService,ParamUtil.getBody(treeMapParam), OctPtzTimeTaskGetBean.ResultBean.class);
    }




    //31.云台控制-设置定时任务-公有云协议
    @Override
    public Observable<BaseBean<ErrorBean>> ptzTimeTaskSet(String deviceSn, int channelId,JSONArray taskArray,String controlToken) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);
        treeMapParam.put("controlToken", controlToken);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_time_task_set");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("task", taskArray);

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().sendPtzCmd2(mApiService,ParamUtil.getBody(treeMapParam), ErrorBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ptzCalibrate(String deviceSn, int channelId) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ptz_calibrate");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);

        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));

//        return mApiService.ptzCalibrate(ParamUtil.getBody(treeMapParam));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(treeMapParam), EmptyBean.class);

    }

    @Override
    public Observable<BaseBean<OctImageAbilityGetBean.ResultBean>> getImageAbility(String deviceSn, int channelId) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "image_get_ability");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("channelId", channelId);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(treeMapParam), OctImageAbilityGetBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<OctImageDncutParamBean.ResultBean>> getImageDncutParam(String deviceSn, int channelId) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "image_get_dncut_param");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("channelId", channelId);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(treeMapParam), OctImageDncutParamBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setImageDncutParam(String deviceSn, int channelId, OctImageDncutParamBean.ResultBean resultBean) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "image_set_dncut_param");
        resultBean.setChannelid(channelId);
        body.put("param", resultBean);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(treeMapParam), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<OctAlarmLinkDefenceBean.ResultBean>> getAlarmLinkDefenceParam(String deviceSn, int channelId) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "alarm_link_defence_get");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("channelId", channelId);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(treeMapParam), OctAlarmLinkDefenceBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setAlarmLinkDefenceParam(String deviceSn, int channelId, OctAlarmLinkDefenceBean.ResultBean resultBean) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "alarm_link_defence_set");
        resultBean.setChannelid(channelId);
        body.put("param", resultBean);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(treeMapParam), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setAlarmLinkTrigger(String deviceSn, int channelId, String status) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "alarm_link_trigger");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("channelid", channelId);
        param.put("status", status);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(treeMapParam), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<OctStreamGetParams.ResultBean>> getStreamParam(String deviceSn, int channelId) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "stream_get_params");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("channelId", channelId);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(treeMapParam), OctStreamGetParams.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setStreamParam(String deviceSn, int channelId, OctStreamGetParams.ResultBean resultBean) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "stream_set_params");
        body.put("param", resultBean);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(treeMapParam), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<IntelligenceAbilityBean>> getIntelligenceAbility(String deviceSn, int channelId) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "intelligence_get_ability");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("channelId", channelId);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(treeMapParam), IntelligenceAbilityBean.class);
    }

    @Override
    public Observable<BaseBean<IntelligenceWaveHandCallParam.ResultBean>> getWaveHandCallParam(String deviceSn, int channelId) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "intelligence_wavehand_call_get_param");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("bdefault", false);//是否获取默认参数
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(treeMapParam), IntelligenceWaveHandCallParam.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<SmartAbilityDetailBean>> getCryPetDetail(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        return mApiService.getSmartAbilityDetail(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<List<StorageBean>>> getStorage(String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        return mApiService.getStorage(ParamUtil.getBody(parma));
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




    //1.云台控制-云台速度获取-云视通2.0
    @Override
    public Observable<BaseBean<OctPtzSpeedBean>> ptzOctMoveStatGet(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);

        dataObj.put("method", "ptz_move_stat_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctMoveStatGet(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctPtzSpeedBean>>() {
            @Override
            public BaseBean<OctPtzSpeedBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctPtzSpeedBean speedBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctPtzSpeedBean>() {
                }.getType());

                BaseBean<OctPtzSpeedBean> speedBeanBaseBean = new BaseBean<>();
                speedBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(speedBean.getError().getErrorcode())));
                speedBeanBaseBean.setMsg(stringBaseBean.getMsg());
                speedBeanBaseBean.setData(speedBean);
                return speedBeanBaseBean;
            }
        });
    }

    //2.云台控制-控制移动-云视通2.0（包含放大，缩小）
    @Override
    public Observable<BaseBean<EmptyBean>> ptzOctControl(int playerId,String deviceSn, int channelId, String controlToken, String devUser, String devPwd, int panLeft, int tiltUp, int zoomIn,boolean isAp) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }
        parma.put("player_id", playerId);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("panLeft", panLeft);
        paramObj.put("tiltUp", tiltUp);
        paramObj.put("zoomIn", zoomIn);

        dataObj.put("method", "ptz_move_start");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.ptzOctControl(ParamUtil.getBody(parma));
    }



    //3.云台控制-停止移动-云视通2.0
    @Override
    public Observable<BaseBean<EmptyBean>> ptzOctControlStop(int playerId,String deviceSn, int channelId, String controlToken, String devUser, String devPwd,boolean isAp) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }
        parma.put("player_id", playerId);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);

        dataObj.put("method", "ptz_move_stop");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctControlStop(ParamUtil.getBody(parma));
    }



    //4.云台控制-聚焦和光圈-云视通2.0
    @Override
    public Observable<BaseBean<EmptyBean>> ptzOctFiStart(int playerId,String deviceSn, int channelId, String devUser, String devPwd, int focusFar, int irisOpen,boolean isAp) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }
        parma.put("player_id", playerId);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("focusFar", focusFar);
        paramObj.put("irisOpen", irisOpen);

        dataObj.put("method", "ptz_fi_start");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctFiStart(ParamUtil.getBody(parma));
    }

    //5.云台控制-停止聚焦和光圈-云视通2.0
    @Override
    public Observable<BaseBean<EmptyBean>> ptzOctFiStop(int playerId,String deviceSn, int channelId, String devUser, String devPwd,boolean isAp) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }
        parma.put("player_id", playerId);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);

        dataObj.put("method", "ptz_fi_stop");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.ptzOctFiStop(ParamUtil.getBody(parma));
    }


    //6.云台控制-云台自动旋转-云视通2.0
    @Override
    public Observable<BaseBean<EmptyBean>> ptzOctAuto(int playerId,String deviceSn, int channelId, String devUser, String devPwd,int speed,boolean isAp) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }
        parma.put("player_id", playerId);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("speed",speed);

        dataObj.put("method", "ptz_auto");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.ptzOctAuto(ParamUtil.getBody(parma));
    }



    //7.云台控制-获取云台能力-云视通2.0
    @Override
    public Observable<BaseBean<OctPtzAbilityBean>> ptzOctAbilityGet(String deviceSn, int channelId, String devUser, String devPwd,boolean isAp) {
        TreeMap<String, Object> parma = ParamUtil.getParma();

        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }

        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);

        dataObj.put("method", "ptz_ability_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctAbilityGet(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctPtzAbilityBean>>() {
            @Override
            public BaseBean<OctPtzAbilityBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctPtzAbilityBean abilityBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctPtzAbilityBean>() {
                }.getType());

                BaseBean<OctPtzAbilityBean> abilityBeanBaseBean = new BaseBean<>();
                abilityBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(abilityBean.getError().getErrorcode())));
                abilityBeanBaseBean.setMsg(stringBaseBean.getMsg());
                abilityBeanBaseBean.setData(abilityBean);
                return abilityBeanBaseBean;
            }
        });
    }



    //8.云台控制-获取预置点-云视通2.0
    @Override
    public Observable<BaseBean<OctPtzPresetsGetBean>> ptzOctPresetsGet(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);

        dataObj.put("method", "ptz_presets_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctPresetsGet(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctPtzPresetsGetBean>>() {
            @Override
            public BaseBean<OctPtzPresetsGetBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctPtzPresetsGetBean ptzPresetsGetBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctPtzPresetsGetBean>() {
                }.getType());

                BaseBean<OctPtzPresetsGetBean> ptzPresetsGetBeanBaseBean = new BaseBean<>();
                ptzPresetsGetBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(ptzPresetsGetBean.getError().getErrorcode())));
                ptzPresetsGetBeanBaseBean.setMsg(stringBaseBean.getMsg());
                ptzPresetsGetBeanBaseBean.setData(ptzPresetsGetBean);
                return ptzPresetsGetBeanBaseBean;
            }
        });
    }


    //9.云台控制-设置预置点-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctPresetSet(String deviceSn, int channelId, String devUser, String devPwd,int presetNo,String name) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("presetno", presetNo);
        paramObj.put("name", name);


        dataObj.put("method", "ptz_preset_set");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctPresetSet(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }
                return errorBeanBaseBean;
            }
        });
    }

    //10.云台控制-调用预置点-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctPresetLocate(String deviceSn, int channelId, String devUser, String devPwd,int presetNo,int moveSpeed) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("presetno", presetNo);//预置点id
        paramObj.put("movespeed", moveSpeed);////调用预置点移动速度：0~254


        dataObj.put("method", "ptz_preset_locate");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctPresetLocate(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                ErrorBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
//                }.getType());
//
//                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
//                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
//                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                errorBeanBaseBean.setData(errorBean);

                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }
                return errorBeanBaseBean;
            }
        });
    }

    //11.云台控制-删除预置点-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctPresetDelete(String deviceSn, int channelId, String devUser, String devPwd,int presetNo) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("presetno", presetNo);//预置点id


        dataObj.put("method", "ptz_preset_delete");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctPresetDelete(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                ErrorBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
//                }.getType());
//
//                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
//                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
//                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                errorBeanBaseBean.setData(errorBean);
                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }

                return errorBeanBaseBean;
            }
        });
    }

    //12.云台控制-获取巡航-云视通2.0
    @Override
    public Observable<BaseBean<OctPtzPatrolsGetBean>> ptzOctPatrolsGet(String deviceSn, int channelId, String devUser, String devPwd,int patrolId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("patrolid",patrolId);

        dataObj.put("method", "ptz_patrols_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctPatrolsGet(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctPtzPatrolsGetBean>>() {
            @Override
            public BaseBean<OctPtzPatrolsGetBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctPtzPatrolsGetBean ptzPatrolsGetBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctPtzPatrolsGetBean>() {
                }.getType());

                BaseBean<OctPtzPatrolsGetBean> ptzPatrolsGetBeanBaseBean = new BaseBean<>();
                ptzPatrolsGetBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(ptzPatrolsGetBean.getError().getErrorcode())));
                ptzPatrolsGetBeanBaseBean.setMsg(stringBaseBean.getMsg());
                ptzPatrolsGetBeanBaseBean.setData(ptzPatrolsGetBean);
                return ptzPatrolsGetBeanBaseBean;
            }
        });
    }

    //13.云台控制-创建巡航-云视通2.0
    @Override
    public Observable<BaseBean<OctPtzPatrolCreateBean>> ptzOctPatrolCreate(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);

        dataObj.put("method", "ptz_patrol_create");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctPatrolCreate(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctPtzPatrolCreateBean>>() {
            @Override
            public BaseBean<OctPtzPatrolCreateBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctPtzPatrolCreateBean ptzPatrolCreateBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctPtzPatrolCreateBean>() {
                }.getType());

                BaseBean<OctPtzPatrolCreateBean> ptzPatrolCreateBeanBaseBean = new BaseBean<>();
                ptzPatrolCreateBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(ptzPatrolCreateBean.getError().getErrorcode())));
                ptzPatrolCreateBeanBaseBean.setMsg(stringBaseBean.getMsg());
                ptzPatrolCreateBeanBaseBean.setData(ptzPatrolCreateBean);
                return ptzPatrolCreateBeanBaseBean;
            }
        });
    }


    //14.云台控制-删除巡航-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctPatrolDelete(String deviceSn, int channelId, String devUser, String devPwd,int patrolId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("patrolid", patrolId);


        dataObj.put("method", "ptz_patrol_delete");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctPatrolDelete(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                ErrorBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
//                }.getType());
//
//                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
//                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
//                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                errorBeanBaseBean.setData(errorBean);
                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }
                return errorBeanBaseBean;
            }
        });
    }

    //15.云台控制-调用巡航-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctPatrolLocate(String deviceSn, int channelId, String devUser, String devPwd,int patrolId,int speed) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("patrolid", patrolId);//从0开始
        paramObj.put("speed", speed);//0：全速 1：1/2倍速 2：1/4倍速 3：1/8倍速 4：1/16倍速 5：1/32倍速


        dataObj.put("method", "ptz_patrol_locate");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctPatrolLocate(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                ErrorBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
//                }.getType());
//
//                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
//                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
//                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                errorBeanBaseBean.setData(errorBean);
                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }
                return errorBeanBaseBean;
            }
        });
    }


    //16.云台控制-停止巡航-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctPatrolStop(String deviceSn, int channelId, String devUser, String devPwd,int patrolId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("patrolid", patrolId);//从0开始

        dataObj.put("method", "ptz_patrol_stop");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctPatrolStop(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                ErrorBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
//                }.getType());
//
//                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
//                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
//                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                errorBeanBaseBean.setData(errorBean);

                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }
                return errorBeanBaseBean;
            }
        });
    }

    //17.云台控制-获取巡航节点-云视通2.0
    @Override
    public Observable<BaseBean<OctPtzPatrolGetNodesBean>> ptzOctPatrolGetNodes(String deviceSn, int channelId, String devUser, String devPwd,int patrolId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("patrolid", patrolId);//从0开始

        dataObj.put("method", "ptz_patrol_get_nodes");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctPatrolGetNodes(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctPtzPatrolGetNodesBean>>() {
            @Override
            public BaseBean<OctPtzPatrolGetNodesBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctPtzPatrolGetNodesBean ptzPatrolGetNodesBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctPtzPatrolGetNodesBean>() {
                }.getType());

                BaseBean<OctPtzPatrolGetNodesBean> ptzPatrolGetNodesBeanBaseBean = new BaseBean<>();
                ptzPatrolGetNodesBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(ptzPatrolGetNodesBean.getError().getErrorcode())));
                ptzPatrolGetNodesBeanBaseBean.setMsg(stringBaseBean.getMsg());
                ptzPatrolGetNodesBeanBaseBean.setData(ptzPatrolGetNodesBean);
                return ptzPatrolGetNodesBeanBaseBean;
            }
        });
    }

    //18.云台控制-添加巡航节点-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctPatrolAddNode(String deviceSn, int channelId, String devUser, String devPwd,int patrolId,int presetNo,int staySeconds) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("patrolid", patrolId);//从0开始
        paramObj.put("presetno", presetNo);
        paramObj.put("staySeconds", staySeconds);//5~86400秒

        dataObj.put("method", "ptz_patrol_add_node");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctPatrolAddNode(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                ErrorBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
//                }.getType());
//
//                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
//                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
//                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                errorBeanBaseBean.setData(errorBean);

                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }

                return errorBeanBaseBean;
            }
        });
    }

    //19.云台控制-删除巡航节点-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctPatrolDelNode(String deviceSn, int channelId, String devUser, String devPwd,int patrolId,int presetIndex) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("patrolid", patrolId);//从0开始
        paramObj.put("presetindex", presetIndex);

        dataObj.put("method", "ptz_patrol_del_node");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctPatrolDelNode(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                ErrorBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
//                }.getType());
//
//                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
//                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
//                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                errorBeanBaseBean.setData(errorBean);

                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }

                return errorBeanBaseBean;
            }
        });
    }

    //20.云台控制-设置巡航速度-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctPatrolSetSpeed(String deviceSn, int channelId, String devUser, String devPwd,int patrolId,int speed) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("patrolid", patrolId);//从0开始
        paramObj.put("speed", speed);//0：全速 1：1/2倍速 2：1/4倍速 3：1/8倍速 4：1/16倍速 5：1/32倍速

        dataObj.put("method", "ptz_patrol_set_speed");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctPatrolSetSpeed(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                ErrorBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
//                }.getType());
//
//                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
//                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
//                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                errorBeanBaseBean.setData(errorBean);

                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }

                return errorBeanBaseBean;
            }
        });
    }


    //21.云台控制-设置巡航时间-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctPatrolSetStaySeconds(String deviceSn, int channelId, String devUser, String devPwd,int patrolId,int staySeconds) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("patrolid", patrolId);//从0开始
        paramObj.put("staySeconds", staySeconds);//单位秒

        dataObj.put("method", "ptz_patrol_set_stay_seconds");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctPatrolSetStaySeconds(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                ErrorBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
//                }.getType());
//
//                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
//                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
//                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                errorBeanBaseBean.setData(errorBean);

                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }

                return errorBeanBaseBean;
            }
        });
    }


    //22.云台控制-开始或者完成轨迹录制-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctTrailRec(String deviceSn, int channelId, String devUser, String devPwd,int trailId,boolean bStart) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("trailid", trailId);//轨迹id，从0开始
        paramObj.put("bstart", bStart);//true：开始录制 false：完成录制

        dataObj.put("method", "ptz_trail_rec");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctTrailRec(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                ErrorBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
//                }.getType());
//
//                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
//                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
//                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                errorBeanBaseBean.setData(errorBean);

                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }

                return errorBeanBaseBean;
            }
        });
    }



    //23.云台控制-启动或者停止轨迹-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctTrailAction(String deviceSn, int channelId, String devUser, String devPwd,int trailId,boolean bStart) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("trailid", trailId);//轨迹id，从0开始
        paramObj.put("bstart", bStart);//true：启动 false：停止

        dataObj.put("method", "ptz_trail_action");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctTrailAction(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                ErrorBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
//                }.getType());
//
//                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
//                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
//                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                errorBeanBaseBean.setData(errorBean);

                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }

                return errorBeanBaseBean;
            }
        });
    }


    //24.云台控制-获取轨迹-云视通2.0
    @Override
    public Observable<BaseBean<OctPtzTrailGetBean>> ptzOctTrailGet(String deviceSn, int channelId, String devUser, String devPwd,int trailId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("trailid", trailId);//轨迹id，从0开始

        dataObj.put("method", "ptz_trail_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctTrailGet(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctPtzTrailGetBean>>() {
            @Override
            public BaseBean<OctPtzTrailGetBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctPtzTrailGetBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctPtzTrailGetBean>() {
                }.getType());

                BaseBean<OctPtzTrailGetBean> errorBeanBaseBean = new BaseBean<>();
                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getError().getErrorcode())));
                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                errorBeanBaseBean.setData(errorBean);
                return errorBeanBaseBean;
            }
        });
    }


    //25.云台控制-获取守望-云视通2.0
    @Override
    public Observable<BaseBean<OctPtzGuardGetBean>> ptzOctGuardGet(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。

        dataObj.put("method", "ptz_guard_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctGuardGet(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctPtzGuardGetBean>>() {
            @Override
            public BaseBean<OctPtzGuardGetBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctPtzGuardGetBean bean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctPtzGuardGetBean>() {
                }.getType());

                BaseBean<OctPtzGuardGetBean> baseBean = new BaseBean<>();
                baseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(bean.getError().getErrorcode())));
                baseBean.setMsg(stringBaseBean.getMsg());
                baseBean.setData(bean);
                return baseBean;
            }
        });
    }

    //26.云台控制-设置守望-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctGuardSet(String deviceSn, int channelId, String devUser, String devPwd,int preset,int staySeconds ) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("preset", preset);//预置点
        paramObj.put("stayseconds", staySeconds);//停留时间，单位秒

        dataObj.put("method", "ptz_guard_set");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctGuardSet(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                ErrorBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
//                }.getType());
//
//                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
//                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
//                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                errorBeanBaseBean.setData(errorBean);

                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }

                return errorBeanBaseBean;
            }
        });
    }

    //27.云台控制-启动或者停止守望-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctGuardAction(String deviceSn, int channelId, String devUser, String devPwd,boolean bStart) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("bstart", bStart);//true：启动 false：停止

        dataObj.put("method", "ptz_guard_action");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctGuardAction(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                ErrorBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
//                }.getType());
//
//                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
//                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
//                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                errorBeanBaseBean.setData(errorBean);

                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }

                return errorBeanBaseBean;
            }
        });
    }

    //28.云台控制-暂停或者复位守望-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctGuardPause(String deviceSn, int channelId, String devUser, String devPwd,boolean bPause) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("bpause", bPause);//true：暂停 false：复位

        dataObj.put("method", "ptz_guard_pause");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctGuardPause(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                ErrorBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
//                }.getType());
//
//                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
//                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
//                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                errorBeanBaseBean.setData(errorBean);

                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }

                return errorBeanBaseBean;
            }
        });
    }


    //29.云台控制-获取定时任务列表-云视通2.0
    @Override
    public Observable<BaseBean<OctPtzTimeTaskListGetBean>> ptzOctTimeTaskListGet(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。

        dataObj.put("method", "ptz_time_task_list_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctTimeTaskListGet(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctPtzTimeTaskListGetBean>>() {
            @Override
            public BaseBean<OctPtzTimeTaskListGetBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctPtzTimeTaskListGetBean ptzTimeTaskListGetBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctPtzTimeTaskListGetBean>() {
                }.getType());

                BaseBean<OctPtzTimeTaskListGetBean> ptzTimeTaskListGetBeanBaseBean = new BaseBean<>();
                ptzTimeTaskListGetBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(ptzTimeTaskListGetBean.getError().getErrorcode())));
                ptzTimeTaskListGetBeanBaseBean.setMsg(stringBaseBean.getMsg());
                ptzTimeTaskListGetBeanBaseBean.setData(ptzTimeTaskListGetBean);
                return ptzTimeTaskListGetBeanBaseBean;
            }
        });
    }


    //30.云台控制-获取定时任务-云视通2.0
    @Override
    public Observable<BaseBean<OctPtzTimeTaskGetBean>> ptzOctTimeTaskGet(String deviceSn, int channelId, String devUser, String devPwd,int taskId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("taskid", taskId);//定时任务编号，从0开始。-1，获取所有

        dataObj.put("method", "ptz_time_task_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctTimeTaskGet(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctPtzTimeTaskGetBean>>() {
            @Override
            public BaseBean<OctPtzTimeTaskGetBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctPtzTimeTaskGetBean ptzTimeTaskGetBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctPtzTimeTaskGetBean>() {
                }.getType());

                BaseBean<OctPtzTimeTaskGetBean> ptzTimeTaskGetBeanBaseBean = new BaseBean<>();
                ptzTimeTaskGetBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(ptzTimeTaskGetBean.getError().getErrorcode())));
                ptzTimeTaskGetBeanBaseBean.setMsg(stringBaseBean.getMsg());
                ptzTimeTaskGetBeanBaseBean.setData(ptzTimeTaskGetBean);
                return ptzTimeTaskGetBeanBaseBean;
            }
        });
    }



    //31.云台控制-设置定时任务-云视通2.0
    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctTimeTaskSet(String deviceSn, int channelId, String devUser, String devPwd,JSONArray taskArray) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。
        paramObj.put("task", taskArray);

        dataObj.put("method", "ptz_time_task_set");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctTimeTaskSet(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                ErrorBean errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
//                }.getType());
//
//                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
//                errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
//                errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
//                errorBeanBaseBean.setData(errorBean);

                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }

                return errorBeanBaseBean;
            }
        });
    }

    @Override
    public Observable<BaseBean<ErrorBean>> ptzOctCalibrate(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);//通道号，从0开始。

        dataObj.put("method", "ptz_calibrate");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.ptzOctCalibrate(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean>>() {
            @Override
            public BaseBean<ErrorBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                BaseBean<ErrorBean> errorBeanBaseBean = new BaseBean<>();
                try{
                    ErrorBean errorBean = new ErrorBean();
                    //请求成功,有可能调用失败
                    if(stringBaseBean.getCode().equalsIgnoreCase("1000")){
                        OctBaseResponseBean octBaseResponseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctBaseResponseBean>() {
                        }.getType());
                        errorBean = octBaseResponseBean.getError();
                    } else{
                        errorBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean>() {
                        }.getType());
                    }

                    errorBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(errorBean.getErrorcode())));
                    errorBeanBaseBean.setMsg(stringBaseBean.getMsg());
                    errorBeanBaseBean.setData(errorBean);
                } catch (Exception e){
                    e.printStackTrace();
                }

                return errorBeanBaseBean;
            }
        });
    }

    @Override
    public Observable<BaseBean<OctImageDncutParamBean>> octGetImageDncutParam(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "image_get_dncut_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetImageDncutParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctImageDncutParamBean>>() {
            @Override
            public BaseBean<OctImageDncutParamBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctImageDncutParamBean octImageDncutParamBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctImageDncutParamBean>() {}.getType());

                BaseBean<OctImageDncutParamBean> octImageDncutParamBaseBean = new BaseBean<>();
                octImageDncutParamBaseBean.setCode(stringBaseBean.getCode());
                octImageDncutParamBaseBean.setMsg(stringBaseBean.getMsg());
                octImageDncutParamBaseBean.setData(octImageDncutParamBean);

                return octImageDncutParamBaseBean;
            }
        });
    }

    @Override
    public Observable<BaseBean<EmptyBean>> octSetImageDncutParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "image_set_dncut_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetImageDncutParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
            @Override
            public BaseBean<EmptyBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                EmptyBean emptyBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<EmptyBean>() {}.getType());

                BaseBean<EmptyBean> octEmptyBean = new BaseBean<>();
                octEmptyBean.setCode(stringBaseBean.getCode());
                octEmptyBean.setMsg(stringBaseBean.getMsg());
                octEmptyBean.setData(emptyBean);

                return octEmptyBean;
            }
        });
    }

    @Override
    public Observable<BaseBean<OctAlarmLinkDefenceBean>> octGetAlarmLinkDefenceParam(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "alarm_link_defence_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetAlarmLinkDefenceParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctAlarmLinkDefenceBean>>() {
            @Override
            public BaseBean<OctAlarmLinkDefenceBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctAlarmLinkDefenceBean bean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctAlarmLinkDefenceBean>() {}.getType());

                BaseBean<OctAlarmLinkDefenceBean> baseBean = new BaseBean<>();
                baseBean.setCode(stringBaseBean.getCode());
                baseBean.setMsg(stringBaseBean.getMsg());
                baseBean.setData(bean);

                return baseBean;
            }
        });
    }

    @Override
    public Observable<BaseBean<EmptyBean>> octSetAlarmLinkDefenceParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "alarm_link_defence_set");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetAlarmLinkDefenceParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
            @Override
            public BaseBean<EmptyBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                EmptyBean emptyBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<EmptyBean>() {}.getType());

                BaseBean<EmptyBean> octEmptyBean = new BaseBean<>();
                octEmptyBean.setCode(stringBaseBean.getCode());
                octEmptyBean.setMsg(stringBaseBean.getMsg());
                octEmptyBean.setData(emptyBean);

                return octEmptyBean;
            }
        });
    }

    @Override
    public Observable<BaseBean<EmptyBean>> octSetAlarmLinkTrigger(String deviceSn, int channelId, String devUser, String devPwd, String status) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("status", status);


        dataObj.put("method", "alarm_link_trigger");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetAlarmLinkTrigger(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
            @Override
            public BaseBean<EmptyBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                EmptyBean emptyBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<EmptyBean>() {}.getType());

                BaseBean<EmptyBean> octEmptyBean = new BaseBean<>();
                octEmptyBean.setCode(stringBaseBean.getCode());
                octEmptyBean.setMsg(stringBaseBean.getMsg());
                octEmptyBean.setData(emptyBean);

                return octEmptyBean;
            }
        });
    }

    @Override
    public Observable<BaseBean<OctStreamGetParams>> octGetStreamParam(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "stream_get_params");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetStreamParams(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctStreamGetParams>>() {
            @Override
            public BaseBean<OctStreamGetParams> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctStreamGetParams bean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctStreamGetParams>() {}.getType());

                BaseBean<OctStreamGetParams> baseBean = new BaseBean<>();
                baseBean.setCode(stringBaseBean.getCode());
                baseBean.setMsg(stringBaseBean.getMsg());
                baseBean.setData(bean);

                return baseBean;
            }
        });
    }

    @Override
    public Observable<BaseBean<EmptyBean>> octSetStreamParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "stream_set_params");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetStreamParams(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
            @Override
            public BaseBean<EmptyBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                EmptyBean emptyBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<EmptyBean>() {}.getType());

                BaseBean<EmptyBean> octEmptyBean = new BaseBean<>();
                octEmptyBean.setCode(stringBaseBean.getCode());
                octEmptyBean.setMsg(stringBaseBean.getMsg());
                octEmptyBean.setData(emptyBean);

                return octEmptyBean;
            }
        });
    }

    //3 云视通2.0获取sd卡信息
    @Override
    public Observable<BaseBean<OctSDCardInfoBean>> octGetStorageInfo(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);

        dataObj.put("method", "storage_get_info");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetStorageInfo(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctSDCardInfoBean>>() {
            @Override
            public BaseBean<OctSDCardInfoBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctSDCardInfoBean octSDCardInfo = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctSDCardInfoBean>() {
                }.getType());

                BaseBean<OctSDCardInfoBean> octSDCardInfoBaseBean = new BaseBean<>();
                octSDCardInfoBaseBean.setCode(stringBaseBean.getCode());
                octSDCardInfoBaseBean.setMsg(stringBaseBean.getMsg());
                octSDCardInfoBaseBean.setData(octSDCardInfo);

                return octSDCardInfoBaseBean;
            }
        });

    }



    //4 云视通2.0格式化SD卡
    @Override
    public Observable<BaseBean<EmptyBean>> octStorageFormat(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);

        dataObj.put("method", "storage_format");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octStorageFormat(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
            @Override
            public BaseBean<EmptyBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                EmptyBean emptyBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<EmptyBean>() {}.getType());

                BaseBean<EmptyBean> octEmptyBean = new BaseBean<>();
                octEmptyBean.setCode(stringBaseBean.getCode());
                octEmptyBean.setMsg(stringBaseBean.getMsg());
                octEmptyBean.setData(emptyBean);

                return octEmptyBean;
            }
        });
    }



    //5 云视通2.0格式化SD卡进度获取
    @Override
    public Observable<BaseBean<OctSDCardFormatProBean>> octGetStorageFormatProgress(String deviceSn, int channelId, String devUser, String devPwd, int diskNum, String diskName) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("diskNum", diskNum);
        paramObj.put("diskName", diskName);


        dataObj.put("method", "storage_format_get_progress");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetStorageFormatProgress(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctSDCardFormatProBean>>() {
            @Override
            public BaseBean<OctSDCardFormatProBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctSDCardFormatProBean octSDCardFormatProBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctSDCardFormatProBean>() {}.getType());

                BaseBean<OctSDCardFormatProBean> octSDCardFormatProBaseBean = new BaseBean<>();
                octSDCardFormatProBaseBean.setCode(stringBaseBean.getCode());
                octSDCardFormatProBaseBean.setMsg(stringBaseBean.getMsg());
                octSDCardFormatProBaseBean.setData(octSDCardFormatProBean);

                return octSDCardFormatProBaseBean;
            }
        });

    }

    //云视通2.0报警联动获取
    @Override
    public Observable<BaseBean<AlarmLinkIdBean>> octGetAlarmLinkId(String deviceSn, int channelId, String devUser, String devPwd, String module) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("module", module);


        dataObj.put("level", "Operator");
        dataObj.put("method", "alarm_get_link_id");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octGetAlarmLinkId(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<AlarmLinkIdBean>>() {
            @Override
            public BaseBean<AlarmLinkIdBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                AlarmLinkIdBean octAlarmLinkGetBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<AlarmLinkIdBean>() {}.getType());

                BaseBean<AlarmLinkIdBean> octAlarmLinkGetBeanBaseBean = new BaseBean<>();
                octAlarmLinkGetBeanBaseBean.setCode(stringBaseBean.getCode());
                octAlarmLinkGetBeanBaseBean.setMsg(stringBaseBean.getMsg());
                octAlarmLinkGetBeanBaseBean.setData(octAlarmLinkGetBean);

                return octAlarmLinkGetBeanBaseBean;
            }
        });

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
        parma.put("data",ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(parma),OctAlarmLinkGetBean.ResultBean.class);

    }

    //62 云视通2.0报警联动获取
    @Override
    public Observable<BaseBean<OctAlarmLinkGetBean>> octAlarmLinkGet(String deviceSn, int channelId, String devUser, String devPwd, int linkId, boolean bDefault) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("link_id", linkId);
        paramObj.put("bdefault", bDefault);


        dataObj.put("level", "Operator");
        dataObj.put("method", "alarm_link_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octAlarmLinkGet(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctAlarmLinkGetBean>>() {
            @Override
            public BaseBean<OctAlarmLinkGetBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctAlarmLinkGetBean octAlarmLinkGetBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctAlarmLinkGetBean>() {}.getType());

                BaseBean<OctAlarmLinkGetBean> octAlarmLinkGetBeanBaseBean = new BaseBean<>();
                octAlarmLinkGetBeanBaseBean.setCode(stringBaseBean.getCode());
                octAlarmLinkGetBeanBaseBean.setMsg(stringBaseBean.getMsg());
                octAlarmLinkGetBeanBaseBean.setData(octAlarmLinkGetBean);

                return octAlarmLinkGetBeanBaseBean;
            }
        });

    }


    /***************************** 定时抓拍常量 -start **********************************/

    public static final String STR_METHOD_TIMING_SNAP_GET = "timing_snap_get";//1.定时抓拍参数获取
    public static final String STR_METHOD_TIMING_SNAP_SET = "timing_snap_set";//2.定时抓拍参数设置
    public static final String STR_METHOD_SNAP_FILE_DATA_LIST_GET = "snap_file_data_list_get";//3.获取定时抓拍有图片的日期
    public static final String STR_METHOD_SNAP_FILE_LIST_GET = "snap_file_list_get";//4.分页获取定时抓拍图片列表

    /***************************** 定时抓拍常量常量 -end **********************************/


    @Override
    public Observable<BaseBean<SnapDateBean>> getSnapFileDateList(String deviceSn, int channelId, int startYear, int startMonth, String devUser, String devPwd, boolean isAp) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");

        JSONObject dataObj = new JSONObject();


        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        JSONObject startObj = new JSONObject();
        startObj.put("year", startYear);
        startObj.put("month", startMonth);
        startObj.put("day", 1);
        startObj.put("hour", 0);
        startObj.put("min", 0);
        startObj.put("sec", 0);
        paramObj.put("start_time", startObj);

        JSONObject endObj = new JSONObject();
        endObj.put("year", startYear);
        endObj.put("month", startMonth);
        endObj.put("day", 31);
        endObj.put("hour", 23);
        endObj.put("min", 59);
        endObj.put("sec", 59);
        paramObj.put("end_time", endObj);


        dataObj.put("method", STR_METHOD_SNAP_FILE_DATA_LIST_GET);
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.getSnapFileDateList(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<SnapDateBean>>() {
            @Override
            public BaseBean<SnapDateBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                SnapDateBean snapDateBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<SnapDateBean>() {
                }.getType());

                BaseBean<SnapDateBean> snapDateBeanBaseBean = new BaseBean<>();
                snapDateBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(snapDateBean.getError().getErrorcode())));
                snapDateBeanBaseBean.setMsg(stringBaseBean.getMsg());
                snapDateBeanBaseBean.setData(snapDateBean);

                return snapDateBeanBaseBean;
            }
        });
    }


    @Override
    public Observable<BaseBean<SnapFileListBean>> getSnapFileList(String deviceSn, int channelId, int startYear, int startMonth, int startDay, int page, int pageSize, String devUser, String devPwd, boolean isAp) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");

        JSONObject dataObj = new JSONObject();


        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        JSONObject startObj = new JSONObject();
        startObj.put("year", startYear);
        startObj.put("month", startMonth);
        startObj.put("day", startDay);
        startObj.put("hour", 0);
        startObj.put("min", 0);
        startObj.put("sec", 0);
        paramObj.put("start_time", startObj);

        JSONObject endObj = new JSONObject();
        endObj.put("year", startYear);
        endObj.put("month", startMonth);
        endObj.put("day", startDay);
        endObj.put("hour", 23);
        endObj.put("min", 59);
        endObj.put("sec", 59);
        paramObj.put("end_time", endObj);

        paramObj.put("page", page);
        paramObj.put("page_size", pageSize);


        dataObj.put("method", STR_METHOD_SNAP_FILE_LIST_GET);
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.getSnapFileList(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<SnapFileListBean>>() {
            @Override
            public BaseBean<SnapFileListBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                SnapFileListBean snapFileListBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<SnapFileListBean>() {
                }.getType());

                BaseBean<SnapFileListBean> snapFileListBeanBaseBean = new BaseBean<>();
                snapFileListBeanBaseBean.setCode(ParamUtil.errorCode2baseCode(String.valueOf(snapFileListBean.getError().getErrorcode())));
                snapFileListBeanBaseBean.setMsg(stringBaseBean.getMsg());
                snapFileListBeanBaseBean.setData(snapFileListBean);

                return snapFileListBeanBaseBean;
            }
        });
    }


    @Override
    public Observable<BaseBean<OctDevInfoBean>> octGetDevHwinfo(String deviceSn, int channelId, String devUser, String devPwd,boolean isAp) {
        TreeMap<String, Object> parma = ParamUtil.getParma();

        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }


        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);

        dataObj.put("method", "dev_get_hwinfo");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        LogUtil.v("dev_get_hwinfo-ptzModel-1",parma.toString());

        return mApiService.octGetDevHwinfo(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctDevInfoBean>>() {
            @Override
            public BaseBean<OctDevInfoBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctDevInfoBean octDevInfoBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctDevInfoBean>() {
                }.getType());

                BaseBean<OctDevInfoBean> octDevInfoBeanBaseBean = new BaseBean<>();
                octDevInfoBeanBaseBean.setCode(stringBaseBean.getCode());
                octDevInfoBeanBaseBean.setMsg(stringBaseBean.getMsg());
                octDevInfoBeanBaseBean.setData(octDevInfoBean);


                return octDevInfoBeanBaseBean;
            }
        });

    }


    @Override
    public Observable<BaseBean<OctDevGetVC>> octGetDevVerificationCode(String deviceSn, int channelId, String devUser, String devPwd, boolean isAp) {
        TreeMap<String, Object> parma = ParamUtil.getParma();

        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }


        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
//        paramObj.put("channelid", channelId);

        dataObj.put("method", "dev_get_verification_code");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetDevVerificationCode(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctDevGetVC>>() {
            @Override
            public BaseBean<OctDevGetVC> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctDevGetVC octDevGetVC = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctDevGetVC>() {
                }.getType());

                BaseBean<OctDevGetVC> octDevGetVCBaseBean = new BaseBean<>();
                octDevGetVCBaseBean.setCode(stringBaseBean.getCode());
                octDevGetVCBaseBean.setMsg(stringBaseBean.getMsg());
                octDevGetVCBaseBean.setData(octDevGetVC);

                return octDevGetVCBaseBean;
            }
        });

    }

    @Override
    public Observable<BaseBean<OctAccountModifyUserBean>> octAccountModifyUser(String deviceSn, int channelId, String devUser, String devPwd, String newDevUser, String newDevPwd) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("name", devUser);
        paramObj.put("old_passwd", devPwd);
        paramObj.put("passwd", newDevPwd);
        paramObj.put("level", JVCloudConst.STR_ADMIN);
        paramObj.put("description", "This is Adiministrator");


        dataObj.put("method", "account_modify_user");
        dataObj.put("level", "Administrator");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octAccountModifyUser(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctAccountModifyUserBean>>() {
            @Override
            public BaseBean<OctAccountModifyUserBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctAccountModifyUserBean octAccountModifyUserBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctAccountModifyUserBean>() {
                }.getType());

                BaseBean<OctAccountModifyUserBean> octAccountModifyUserBaseBean = new BaseBean<>();
                octAccountModifyUserBaseBean.setCode(stringBaseBean.getCode());
                octAccountModifyUserBaseBean.setMsg(stringBaseBean.getMsg());
                octAccountModifyUserBaseBean.setData(octAccountModifyUserBean);

                return octAccountModifyUserBaseBean;
            }
        });
    }


    //53 对讲模式切换-云视通2.0
    @Override
    public Observable<BaseBean<EmptyBean>> octChatSetParam(String deviceSn, int channelId, boolean singleCall, String devUser, String devPwd,boolean isAp) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);

        JSONObject chatModeObject = new JSONObject();
        if (singleCall) {
            chatModeObject.put("chatMode", JVSetParamConst.VALUE_OCT_CHAT_SINGLE);
        } else {
            chatModeObject.put("chatMode", JVSetParamConst.VALUE_OCT_CHAT_DOUBLE);
        }
        paramObj.put("chartAttr", chatModeObject);

        dataObj.put("method", "chat_set_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octChatSetParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
            @Override
            public BaseBean<EmptyBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                EmptyBean emptyBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<EmptyBean>() {
                }.getType());

                BaseBean<EmptyBean> octEmptyBean = new BaseBean<>();
                octEmptyBean.setCode(stringBaseBean.getCode());
                octEmptyBean.setMsg(stringBaseBean.getMsg());
                octEmptyBean.setData(emptyBean);

                return octEmptyBean;
            }
        });

    }


    @Override
    public Observable<BaseBean<EmptyBean>> publicChatSetParam(String deviceSn, int channelId, boolean singleCall, String devUser, String devPwd) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "chat_set_param");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("channelid", channelId);

        JSONObject chatModeObject = new JSONObject();
        if (singleCall) {
            chatModeObject.put("chatMode", JVSetParamConst.VALUE_OCT_CHAT_SINGLE);
        } else {
            chatModeObject.put("chatMode", JVSetParamConst.VALUE_OCT_CHAT_DOUBLE);
        }
        param.put("chartAttr", chatModeObject);
        body.put("param", param);

        parma.put("data",ParamUtil.getMapStr(body));



//            String deviceSn, int channelId, HashMap<String, Object> body) {
//        TreeMap<String, Object> parma = ParamUtil.getParma();
//        parma.put("deviceSn", deviceSn);
//        parma.put("channelId", channelId);
//        parma.put("data",ParamUtil.getMapStr(body));
//        return mApiService.getDeviceWifiInfo(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }


    @Override
    public Observable<BaseBean<EmptyBean>> editDeviceYst(String deviceSn, String newDevUser,String newDevPwd) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);
        param.put("deviceUser", newDevUser);
        param.put("devicePwd", newDevPwd);

        return mApiService.editDeviceYst(ParamUtil.getBody(param));
    }


    @Override
    public Observable<BaseBean<List<ShareToMeBean>>> shareToMe(String deviceSn) {//, String channelId
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
//        parma.put("channelId", channelId);
        return mApiService.shareToMe(ParamUtil.getBody(parma));
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




    //40 云视通2.0获取图像能力
    @Override
    public Observable<BaseBean<OctImageAbilityGetBean>> octGetImageAbility(String deviceSn, int channelId, String devUser, String devPwd,boolean isAp) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "image_get_ability");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetImageAbility(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctImageAbilityGetBean>>() {
            @Override
            public BaseBean<OctImageAbilityGetBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctImageAbilityGetBean octImageAbilityGetBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctImageAbilityGetBean>() {}.getType());

                BaseBean<OctImageAbilityGetBean> octImageAbilityGetBaseBean = new BaseBean<>();
                octImageAbilityGetBaseBean.setCode(stringBaseBean.getCode());
                octImageAbilityGetBaseBean.setMsg(stringBaseBean.getMsg());
                octImageAbilityGetBaseBean.setData(octImageAbilityGetBean);

                return octImageAbilityGetBaseBean;
            }
        });

    }



    //56 云视通2.0获取图像调节参数
    @Override
    public Observable<BaseBean<OctImageAdjustParamBean>> octGetImageAdjustParam(String deviceSn, int channelId, String devUser, String devPwd, boolean isAp) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "image_get_adjust_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetImageAdjustParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctImageAdjustParamBean>>() {
            @Override
            public BaseBean<OctImageAdjustParamBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctImageAdjustParamBean bean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctImageAdjustParamBean>() {}.getType());

                BaseBean<OctImageAdjustParamBean> baseBean = new BaseBean<>();
                baseBean.setCode(stringBaseBean.getCode());
                baseBean.setMsg(stringBaseBean.getMsg());
                baseBean.setData(bean);

                return baseBean;
            }
        });
    }

    //57 云视通2.0设置图像调节参数
    @Override
    public Observable<BaseBean<EmptyBean>> octSetImageAdjustParam(String deviceSn, int channelId, String devUser, String devPwd, String param,boolean isAp) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "image_set_adjust_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetImageAdjustParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
            @Override
            public BaseBean<EmptyBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                EmptyBean emptyBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<EmptyBean>() {}.getType());

                BaseBean<EmptyBean> octEmptyBean = new BaseBean<>();
                octEmptyBean.setCode(stringBaseBean.getCode());
                octEmptyBean.setMsg(stringBaseBean.getMsg());
                octEmptyBean.setData(emptyBean);

                return octEmptyBean;
            }
        });
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
    public Observable<BaseBean<AlarmStatusBean>> getAlarmStatus(String deviceSn, int channelId) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("deviceId", deviceSn);
        map.put("channelId", channelId);
        return mApiService.getAlarmStatus(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> cancelAlarmStatus(String deviceSn, int channelId) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("deviceId", deviceSn);
        map.put("channelId", channelId);
        return mApiService.cancelAlarmStatus(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> cancelAlarmManual(String deviceSn, int channelId, String alarmType) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "alarm_manual_cancel");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("channelId", channelId);
        param.put("alarm_source", alarmType);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(treeMapParam), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> octCancelAlarmManual(String deviceSn, int channelId, String devUser, String devPwd, String alarmType) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("sn", deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("alarm_source", alarmType);


        dataObj.put("method", "alarm_manual_cancel");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octCancelAlarmManual(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
            @Override
            public BaseBean<EmptyBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                EmptyBean emptyBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<EmptyBean>() {}.getType());

                BaseBean<EmptyBean> octEmptyBean = new BaseBean<>();
                octEmptyBean.setCode(stringBaseBean.getCode());
                octEmptyBean.setMsg(stringBaseBean.getMsg());
                octEmptyBean.setData(emptyBean);

                return octEmptyBean;
            }
        });
    }

    @Override
    public Observable<BaseBean<SimCardListBean.ResultBean>> get4GSimCardList(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), SimCardListBean.ResultBean.class);
    }
}
