package com.jovision.netkit.mvp.data;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jovision.basekit.LogUtil;
import com.jovision.netkit.mvp.JVCloudConst;
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
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.net.rto_exception.BaseException;
import com.jovision.netkit.mvp.presenter.contract.OctSetContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class OctSetModel implements OctSetContract.IOctSetModel {

    private ApiService mApiService;

    public OctSetModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    public static boolean isApMode = false;

//    public static void setIsApMode(Context context){
//        isApMode = NetWorkUtil.isApSignal(context);
//        LogUtil.v("OctSetModel-model","OctSetModel-isApMode="+isApMode);
//    }

    public static TreeMap<String, Object> setDeviceInfo(String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        if (isApMode) {
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }

        return parma;
    }


    //1 获取设备详情-云视通2.0
    @Override
    public Observable<BaseBean<OctDevInfoBean>> octGetDevHwinfo(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);

        dataObj.put("method", "dev_get_hwinfo");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        LogUtil.v("dev_get_hwinfo-octsetModel",parma.toString());

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


    //2 修改设备密码-云视通2.0
    @Override
    public Observable<BaseBean<OctAccountModifyUserBean>> octAccountModifyUser(String deviceSn, int channelId, String devUser, String devPwd, String newDevUser, String newDevPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
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

    //3 云视通2.0获取sd卡信息
    @Override
    public Observable<BaseBean<OctSDCardInfoBean>> octGetStorageInfo(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
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
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
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
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
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



    //6 云视通2.0获取IPC设备录像信息
    @Override
    public Observable<BaseBean<OctRecordGetInfoBean>> octGetRecordMode(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "record_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetRecordMode(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctRecordGetInfoBean>>() {
            @Override
            public BaseBean<OctRecordGetInfoBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctRecordGetInfoBean octRecordInfoBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctRecordGetInfoBean>() {}.getType());

                BaseBean<OctRecordGetInfoBean> octRecordInfoBaseBean = new BaseBean<>();
                octRecordInfoBaseBean.setCode(stringBaseBean.getCode());
                octRecordInfoBaseBean.setMsg(stringBaseBean.getMsg());
                octRecordInfoBaseBean.setData(octRecordInfoBean);

                return octRecordInfoBaseBean;
            }
        });

    }

    //7 云视通2.0设置IPC设备录像信息 String param = JSON.toJSONString(recordInfo.getResult());
    @Override
    public Observable<BaseBean<EmptyBean>> octSetRecordMode(String deviceSn, int channelId, String devUser, String devPwd,String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

//        JSONObject paramObj = new JSONObject();
        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "record_set");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octSetRecordMode(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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




    //8 云视通2.0获取网络配置-给ipc设置ip使用，获取设备当前wifi
    @Override
    public Observable<BaseBean<OctDevIPInfoBean>> octGetInetConfig(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "ifconfig_get_inet");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetInetConfig(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctDevIPInfoBean>>() {
            @Override
            public BaseBean<OctDevIPInfoBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctDevIPInfoBean octDevIPInfoBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctDevIPInfoBean>() {}.getType());

                BaseBean<OctDevIPInfoBean> octDevIPInfoBaseBean = new BaseBean<>();
                octDevIPInfoBaseBean.setCode(stringBaseBean.getCode());
                octDevIPInfoBaseBean.setMsg(stringBaseBean.getMsg());
                octDevIPInfoBaseBean.setData(octDevIPInfoBean);

                return octDevIPInfoBaseBean;
            }
        });

    }

    //8.1 云视通2.0获取设备端wifi列表-给ipc设置ip使用
    @Override
    public Observable<BaseBean<OctWifiListAp>> octGetDevWifiListAp(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("bResearch", true);

        dataObj.put("method", "ifconfig_wifi_list_ap");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetDevWifiListAp(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctWifiListAp>>() {
            @Override
            public BaseBean<OctWifiListAp> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctWifiListAp octWifiListAp = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctWifiListAp>() {}.getType());

                BaseBean<OctWifiListAp> octWifiListApBaseBean = new BaseBean<>();
                octWifiListApBaseBean.setCode(stringBaseBean.getCode());
                octWifiListApBaseBean.setMsg(stringBaseBean.getMsg());
                octWifiListApBaseBean.setData(octWifiListAp);

                return octWifiListApBaseBean;
            }
        });

    }


    //8.2 云视通2.0在线配网-给ipc设置ip使用
    @Override
    public Observable<BaseBean<EmptyBean>> octOnLineWifiConnect(String deviceSn, int channelId, String devUser, String devPwd,String wifiName,String wifiPassword) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("name", wifiName);
        paramObj.put("passwd", wifiPassword);
        paramObj.put("iestat", null);
        paramObj.put("mode", "sta");
        paramObj.put("bDHCP", true);
        paramObj.put("addr", null);
        paramObj.put("mask",null);
        paramObj.put("gateway", null);
        paramObj.put("dns", null);


        dataObj.put("method", "ifconfig_wifi_connect");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octOnLineWifiConnect(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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



    //9 云视通2.0设置网络配置-给ipc设置ip使用
    @Override
    public Observable<BaseBean<EmptyBean>> octSetInetConfig(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "ifconfig_eth_set");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetInetConfig(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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




    //10 云视通2.0获取支持的报警模式（获取支持的智能分析功能）
    @Override
    public Observable<BaseBean<OctIvpBean>> octGetIvpSupport(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "ivp_support_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetIvpSupport(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctIvpBean>>() {
            @Override
            public BaseBean<OctIvpBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctIvpBean octIvpBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctIvpBean>() {}.getType());

                BaseBean<OctIvpBean> octIvpBaseBean = new BaseBean<>();
                octIvpBaseBean.setCode(stringBaseBean.getCode());
                octIvpBaseBean.setMsg(stringBaseBean.getMsg());
                octIvpBaseBean.setData(octIvpBean);

                return octIvpBaseBean;
            }
        });

    }


    //11 云视通2.0获取移动侦测报警模式
    @Override
    public Observable<BaseBean<OctMotionDetectBean>> octGetMdetectParam(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "mdetect_get_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetMdetectParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctMotionDetectBean>>() {
            @Override
            public BaseBean<OctMotionDetectBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctMotionDetectBean octMotionDetectBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctMotionDetectBean>() {}.getType());

                BaseBean<OctMotionDetectBean> octMotionDetectBaseBean = new BaseBean<>();
                octMotionDetectBaseBean.setCode(stringBaseBean.getCode());
                octMotionDetectBaseBean.setMsg(stringBaseBean.getMsg());
                octMotionDetectBaseBean.setData(octMotionDetectBean);

                return octMotionDetectBaseBean;
            }
        });

    }


    //12 云视通2.0设置移动侦测报警模式
    @Override
    public Observable<BaseBean<EmptyBean>> octSetMdetectParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "mdetect_set_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetMdetectParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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


    //13 云视通2.0获取移动跟踪报警模式
    @Override
    public Observable<BaseBean<OctMotionTrackBean>> octGetMoveTrack(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "get_move_track");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetMoveTrack(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctMotionTrackBean>>() {
            @Override
            public BaseBean<OctMotionTrackBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctMotionTrackBean octMotionTrackBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctMotionTrackBean>() {}.getType());

                BaseBean<OctMotionTrackBean> octMotionTrackBaseBean = new BaseBean<>();
                octMotionTrackBaseBean.setCode(stringBaseBean.getCode());
                octMotionTrackBaseBean.setMsg(stringBaseBean.getMsg());
                octMotionTrackBaseBean.setData(octMotionTrackBean);

                return octMotionTrackBaseBean;
            }
        });

    }



    //14 云视通2.0设置移动跟踪报警模式
    @Override
    public Observable<BaseBean<EmptyBean>> octSetMoveTrack(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "set_move_track");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetMoveTrack(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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

    //15 云视通2.0获取绊线/区域入侵报警模式
    @Override
    public Observable<BaseBean<OctInvadeBean>> octGetIvpRlParam(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "ivp_rl_get_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetIvpRlParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctInvadeBean>>() {
            @Override
            public BaseBean<OctInvadeBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctInvadeBean octInvadeBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctInvadeBean>() {}.getType());

                BaseBean<OctInvadeBean> octInvadeBaseBean = new BaseBean<>();
                octInvadeBaseBean.setCode(stringBaseBean.getCode());
                octInvadeBaseBean.setMsg(stringBaseBean.getMsg());
                octInvadeBaseBean.setData(octInvadeBean);

                return octInvadeBaseBean;
            }
        });

    }



    //16 云视通2.0设置绊线/区域入侵报警模式
    @Override
    public Observable<BaseBean<EmptyBean>> octSetIvpRlParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "ivp_rl_set_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetIvpRlParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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



    //17 云视通2.0获取遮挡报警模式
    @Override
    public Observable<BaseBean<OctIvpHideBean>> octGetIvpHideParam(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "ivp_hide_get_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetIvpHideParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctIvpHideBean>>() {
            @Override
            public BaseBean<OctIvpHideBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctIvpHideBean octIvpHideBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctIvpHideBean>() {}.getType());

                BaseBean<OctIvpHideBean> octIvpHideBaseBean = new BaseBean<>();
                octIvpHideBaseBean.setCode(stringBaseBean.getCode());
                octIvpHideBaseBean.setMsg(stringBaseBean.getMsg());
                octIvpHideBaseBean.setData(octIvpHideBean);

                return octIvpHideBaseBean;
            }
        });

    }


    //18 云视通2.0设置遮挡报警模式
    @Override
    public Observable<BaseBean<EmptyBean>> octSetIvpHideParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "ivp_hide_set_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetIvpHideParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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


    //19 云视通2.0获取电动车报警模式
    @Override
    public Observable<BaseBean<OctIntelEbikeDetectionBean>> octGetIntelEbikeDetect(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "intelligence_ebike_detection_get_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetIntelEbikeDetect(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctIntelEbikeDetectionBean>>() {
            @Override
            public BaseBean<OctIntelEbikeDetectionBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctIntelEbikeDetectionBean octIntelEbikeDetectionBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctIntelEbikeDetectionBean>() {}.getType());

                BaseBean<OctIntelEbikeDetectionBean> octIntelEbikeDetectionBaseBean = new BaseBean<>();
                octIntelEbikeDetectionBaseBean.setCode(stringBaseBean.getCode());
                if (TextUtils.equals(octIntelEbikeDetectionBaseBean.getCode(), BaseException.SUCCEED)) {
                    if (!stringBaseBean.getData().contains("enable")) {
                        octIntelEbikeDetectionBaseBean.setCode(BaseException.PARAM_ERROR);
                    }
                }
                octIntelEbikeDetectionBaseBean.setMsg(stringBaseBean.getMsg());
                octIntelEbikeDetectionBaseBean.setData(octIntelEbikeDetectionBean);

                return octIntelEbikeDetectionBaseBean;
            }
        });

    }



    //20 云视通2.0设置电动车报警模式
    @Override
    public Observable<BaseBean<EmptyBean>> octSetIntelEbikeDetect(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "intelligence_ebike_detection_set_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetIntelEbikeDetect(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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



    //21 云视通2.0获取当前选中的报警音
    @Override
    public Observable<BaseBean<OctAlarmSoundGetBean>> octGetAlarmSound(String deviceSn, int channelId, String devUser, String devPwd, String fileName, boolean bGetData) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "alarm_sound_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetAlarmSound(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctAlarmSoundGetBean>>() {
            @Override
            public BaseBean<OctAlarmSoundGetBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctAlarmSoundGetBean octAlarmSoundGetBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctAlarmSoundGetBean>() {}.getType());

                BaseBean<OctAlarmSoundGetBean> octAlarmSoundGetBaseBean = new BaseBean<>();
                octAlarmSoundGetBaseBean.setCode(stringBaseBean.getCode());
                octAlarmSoundGetBaseBean.setMsg(stringBaseBean.getMsg());
                octAlarmSoundGetBaseBean.setData(octAlarmSoundGetBean);

                return octAlarmSoundGetBaseBean;
            }
        });

    }



    //22 云视通2.0设置报警音
    @Override
    public Observable<BaseBean<EmptyBean>> octSetAlarmSound(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "alarm_sound_set");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetAlarmSound(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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




    //25 云视通2.0是否支持报警音量设置
    @Override
    public Observable<BaseBean<OctAudioAbilityGetBean>> octGetAudioAbility(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "aduio_get_ability");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetAudioAbility(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctAudioAbilityGetBean>>() {
            @Override
            public BaseBean<OctAudioAbilityGetBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctAudioAbilityGetBean octAudioAbilityGetBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctAudioAbilityGetBean>() {}.getType());

                BaseBean<OctAudioAbilityGetBean> octAudioAbilityGetBaseBean = new BaseBean<>();
                octAudioAbilityGetBaseBean.setCode(stringBaseBean.getCode());
                octAudioAbilityGetBaseBean.setMsg(stringBaseBean.getMsg());
                octAudioAbilityGetBaseBean.setData(octAudioAbilityGetBean);

                return octAudioAbilityGetBaseBean;
            }
        });

    }



    //26 云视通2.0报警声音音量获取
    @Override
    public Observable<BaseBean<OctAudioAoGetParamBean>> octGetAoParam(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "ao_get_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetAoParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctAudioAoGetParamBean>>() {
            @Override
            public BaseBean<OctAudioAoGetParamBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctAudioAoGetParamBean octAudioAoGetParamBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctAudioAoGetParamBean>() {}.getType());

                BaseBean<OctAudioAoGetParamBean> octAudioAoGetParamBaseBean = new BaseBean<>();
                octAudioAoGetParamBaseBean.setCode(stringBaseBean.getCode());
                octAudioAoGetParamBaseBean.setMsg(stringBaseBean.getMsg());
                octAudioAoGetParamBaseBean.setData(octAudioAoGetParamBean);

                return octAudioAoGetParamBaseBean;
            }
        });

    }



    //27 云视通2.0报警声音音量设置
    @Override
    public Observable<BaseBean<EmptyBean>> octSetAoParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "ao_set_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetAoParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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



    //28 云视通2.0获取网络校时状态
    @Override
    public Observable<BaseBean<OctDevNtpBean>> octGetDevNtp(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "dev_ntp_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetDevNtp(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctDevNtpBean>>() {
            @Override
            public BaseBean<OctDevNtpBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctDevNtpBean octDevNtpBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctDevNtpBean>() {}.getType());

                BaseBean<OctDevNtpBean> octDevNtpBaseBean = new BaseBean<>();
                octDevNtpBaseBean.setCode(stringBaseBean.getCode());
                octDevNtpBaseBean.setMsg(stringBaseBean.getMsg());
                octDevNtpBaseBean.setData(octDevNtpBean);

                return octDevNtpBaseBean;
            }
        });

    }


    //29 云视通2.0设置网络校时状态
    @Override
    public Observable<BaseBean<EmptyBean>> octSetDevNtp(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "dev_ntp_set");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetDevNtp(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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



    //30 云视通2.0获取日期格式
    @Override
    public Observable<BaseBean<OctOsdParamBean>> octGetChnosdParam(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "chnosd_get_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetChnosdParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctOsdParamBean>>() {
            @Override
            public BaseBean<OctOsdParamBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctOsdParamBean octOsdParamBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctOsdParamBean>() {}.getType());

                BaseBean<OctOsdParamBean> octOsdParamBaseBean = new BaseBean<>();
                octOsdParamBaseBean.setCode(stringBaseBean.getCode());
                octOsdParamBaseBean.setMsg(stringBaseBean.getMsg());
                octOsdParamBaseBean.setData(octOsdParamBean);

                return octOsdParamBaseBean;
            }
        });

    }



    //31 云视通2.0设置日期格式
    @Override
    public Observable<BaseBean<EmptyBean>> octSetChnosdParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");

        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("attr", JSONObject.parseObject(param));//


        dataObj.put("method", "chnosd_set_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octSetChnosdParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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


    //32 云视通2.0获取设备时间
    @Override
    public Observable<BaseBean<OctTimeBean>> octGetDevTime(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "dev_gtime");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetDevTime(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctTimeBean>>() {
            @Override
            public BaseBean<OctTimeBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctTimeBean octTimeBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctTimeBean>() {}.getType());

                BaseBean<OctTimeBean> octTimeBaseBean = new BaseBean<>();
                octTimeBaseBean.setCode(stringBaseBean.getCode());
                octTimeBaseBean.setMsg(stringBaseBean.getMsg());
                octTimeBaseBean.setData(octTimeBean);

                return octTimeBaseBean;
            }
        });

    }


    //33 云视通2.0设置设备时间
    @Override
    public Observable<BaseBean<EmptyBean>> octSetDevTime(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "dev_stime");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetDevTime(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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



    //34 云视通2.0重启设备
    @Override
    public Observable<BaseBean<EmptyBean>> octRebootDev(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("delaymSec",1000);


        dataObj.put("method", "dev_reboot");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octRebootDev(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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


    //35 云视通2.0重置设备
    @Override
    public Observable<BaseBean<EmptyBean>> octResetDev(String deviceSn, int channelId, String devUser, String devPwd, boolean isSimple) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("bSimple", isSimple);
//        paramObj.put("bHard", true);


        dataObj.put("method", "dev_factory_default");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octResetDev(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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


    //36 云视通2.0检查设备是否需要升级
    @Override
    public Observable<BaseBean<OctDevUpdateCheckBean>> octCheckDevUpdate(String deviceSn, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("method", "http");
        paramObj.put("url", "wt");
        paramObj.put("port", 0);
        paramObj.put("type", "sctrl");


        dataObj.put("method", "dev_update_check");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octCheckDevUpdate(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctDevUpdateCheckBean>>() {
            @Override
            public BaseBean<OctDevUpdateCheckBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctDevUpdateCheckBean octDevUpdateCheckBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctDevUpdateCheckBean>() {}.getType());

                BaseBean<OctDevUpdateCheckBean> octDevUpdateCheckBaseBean = new BaseBean<>();
                octDevUpdateCheckBaseBean.setCode(stringBaseBean.getCode());
                octDevUpdateCheckBaseBean.setMsg(stringBaseBean.getMsg());
                octDevUpdateCheckBaseBean.setData(octDevUpdateCheckBean);

                return octDevUpdateCheckBaseBean;
            }
        });

    }

    //37 云视通2.0设备升级
    @Override
    public Observable<BaseBean<OctDevUpdateBean>> octDevUpdate(String deviceSn, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("method", "http");
        paramObj.put("url", "wt");
        paramObj.put("port", "1001");


        dataObj.put("method", "dev_update");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octDevUpdate(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctDevUpdateBean>>() {
            @Override
            public BaseBean<OctDevUpdateBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctDevUpdateBean octDevUpdateBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctDevUpdateBean>() {}.getType());

                BaseBean<OctDevUpdateBean> octDevUpdateBaseBean = new BaseBean<>();
                octDevUpdateBaseBean.setCode(stringBaseBean.getCode());
                octDevUpdateBaseBean.setMsg(stringBaseBean.getMsg());
                octDevUpdateBaseBean.setData(octDevUpdateBean);

                return octDevUpdateBaseBean;
            }
        });

    }

    //38 云视通2.0设备升级进度
    @Override
    public Observable<BaseBean<OctDevUpdateProgressBean>> octGetDevUpdateProgress(String deviceSn, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("type", "sctrl");


        dataObj.put("method", "dev_update_get_progress");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetDevUpdateProgress(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctDevUpdateProgressBean>>() {
            @Override
            public BaseBean<OctDevUpdateProgressBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctDevUpdateProgressBean octDevUpdateProgressBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctDevUpdateProgressBean>() {}.getType());

                BaseBean<OctDevUpdateProgressBean> octDevUpdateProgressBaseBean = new BaseBean<>();
                //TODO code 比较特殊
//                "errstr": "Latest Version, File Not Found",
//                        "errno": "GRPC_ERR_RESOURCE_NOT_EXIST, GRPC_ERR_RESOURCE_IS_LATEST_VER"

                octDevUpdateProgressBaseBean.setCode(stringBaseBean.getCode());
                octDevUpdateProgressBaseBean.setMsg(stringBaseBean.getMsg());
                octDevUpdateProgressBaseBean.setData(octDevUpdateProgressBean);

                return octDevUpdateProgressBaseBean;
            }
        });

    }




    //39 云视通2.0设置双光源灯光开关
    @Override
    public Observable<BaseBean<EmptyBean>> octManualSetAlarmLight(String deviceSn, String devUser, String devPwd, boolean bOpen) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("bOpen", bOpen);// true 开  false 关


        dataObj.put("method", "manual_set_alarmlight");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octManualSetAlarmLight(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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




    //40 云视通2.0获取图像能力
    @Override
    public Observable<BaseBean<OctImageAbilityGetBean>> octGetImageAbility(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
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


    //41 云视通2.0设置车牌模式是否开启
    @Override
    public Observable<BaseBean<EmptyBean>> octSetImageExpertSettingParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "image_set_expertsetting_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetImageExpertSettingParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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

    //42 云视通2.0获取车牌模式是否开启
    @Override
    public Observable<BaseBean<OctImageExpertBean>> octGetImageExpertSettingParam(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "image_get_expertsetting_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetImageExpertSettingParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctImageExpertBean>>() {
            @Override
            public BaseBean<OctImageExpertBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctImageExpertBean octImageExpertBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctImageExpertBean>() {}.getType());

                BaseBean<OctImageExpertBean> OctImageExpertBaseBean = new BaseBean<>();
                OctImageExpertBaseBean.setCode(stringBaseBean.getCode());
                OctImageExpertBaseBean.setMsg(stringBaseBean.getMsg());
                OctImageExpertBaseBean.setData(octImageExpertBean);

                return OctImageExpertBaseBean;
            }
        });

    }

    //43 云视通2.0获取图像参数
    @Override
    public Observable<BaseBean<OctImageParamBean>> octGetImageParam(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "image_get_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetImageParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctImageParamBean>>() {
            @Override
            public BaseBean<OctImageParamBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctImageParamBean octImageParamBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctImageParamBean>() {}.getType());

                BaseBean<OctImageParamBean> octImageParamBaseBean = new BaseBean<>();
                octImageParamBaseBean.setCode(stringBaseBean.getCode());
                octImageParamBaseBean.setMsg(stringBaseBean.getMsg());
                octImageParamBaseBean.setData(octImageParamBean);

                return octImageParamBaseBean;
            }
        });

    }



    //44 云视通2.0设置图像参数
    @Override
    public Observable<BaseBean<EmptyBean>> octSetImageParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "image_set_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetImageParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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



    //45 云视通2.0获取人脸识别的参数
    @Override
    public Observable<BaseBean<OctIvpFacercgParamBean>> octGetIvpFacercgParam(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "ivp_facercg_get_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetIvpFacercgParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctIvpFacercgParamBean>>() {
            @Override
            public BaseBean<OctIvpFacercgParamBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctIvpFacercgParamBean octIvpFacercgParamBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctIvpFacercgParamBean>() {}.getType());

                BaseBean<OctIvpFacercgParamBean> octIvpFacercgParamBaseBean = new BaseBean<>();
                octIvpFacercgParamBaseBean.setCode(stringBaseBean.getCode());
                octIvpFacercgParamBaseBean.setMsg(stringBaseBean.getMsg());
                octIvpFacercgParamBaseBean.setData(octIvpFacercgParamBean);

                return octIvpFacercgParamBaseBean;
            }
        });

    }

    //46 云视通2.0设置人脸识别的参数
    @Override
    public Observable<BaseBean<EmptyBean>> octSetIvpFacercgParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "ivp_facercg_set_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetIvpFacercgParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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




    //47 云视通2.0设置LED指示灯状态 mode自动:0 ,常开:1,常灭:2
    @Override
    public Observable<BaseBean<EmptyBean>> octSetIndicatorled(String deviceSn, int channelId, String devUser, String devPwd, int mode) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("mode", mode);//自动:0 ,常开:1,常灭:2


        dataObj.put("method", "dev_set_indicatorled");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetIndicatorled(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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



    //48 云视通2.0获取日夜切换配置
    @Override
    public Observable<BaseBean<OctImageDncutParamBean>> octGetImageDncutParam(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
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




    //49 云视通2.0设置日夜切换配置
    @Override
    public Observable<BaseBean<EmptyBean>> octSetImageDncutParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
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





    //50 云视通2.0NVR获取通道能力
    @Override
    public Observable<BaseBean<OctChannelAbilityBean>> octGetChannelsFeatures(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
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


    //51 云视通2.0定时抓拍参数获取
    @Override
    public Observable<BaseBean<OctTimingSnapBean>> octGetTimingSnap(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "timing_snap_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetTimingSnap(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctTimingSnapBean>>() {
            @Override
            public BaseBean<OctTimingSnapBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctTimingSnapBean octTimingSnapBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctTimingSnapBean>() {}.getType());

                BaseBean<OctTimingSnapBean> octTimingSnapBaseBean = new BaseBean<>();
                octTimingSnapBaseBean.setCode(stringBaseBean.getCode());
                octTimingSnapBaseBean.setMsg(stringBaseBean.getMsg());
                octTimingSnapBaseBean.setData(octTimingSnapBean);

                return octTimingSnapBaseBean;
            }
        });

    }


    //52 云视通2.0定时抓拍参数设置
    @Override
    public Observable<BaseBean<EmptyBean>> octSetTimingSnap(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "timing_snap_set");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetTimingSnap(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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

    //56 云视通2.0获取图像调节参数
    @Override
    public Observable<BaseBean<OctImageAdjustParamBean>> octGetImageAdjustParam(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
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
    public Observable<BaseBean<EmptyBean>> octSetImageAdjustParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
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



    //58 云视通2.0获取报警音列表
    @Override
    public Observable<BaseBean<OctAlarmSoundListGetBean>> octGetAlarmSoundList(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "alarm_soundlist_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octGetAlarmSoundList(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctAlarmSoundListGetBean>>() {
            @Override
            public BaseBean<OctAlarmSoundListGetBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctAlarmSoundListGetBean octAlarmSoundListGetBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctAlarmSoundListGetBean>() {}.getType());

                BaseBean<OctAlarmSoundListGetBean> octAlarmSoundListGetBaseBean = new BaseBean<>();
                octAlarmSoundListGetBaseBean.setCode(stringBaseBean.getCode());
                octAlarmSoundListGetBaseBean.setMsg(stringBaseBean.getMsg());
                octAlarmSoundListGetBaseBean.setData(octAlarmSoundListGetBean);

                return octAlarmSoundListGetBaseBean;
            }
        });

    }



    //59云视通2.0添加自定义报警音
    @Override
    public Observable<BaseBean<EmptyBean>> octAddAlarmSound(String deviceSn, int channelId, String devUser, String devPwd, String fileName,String fileData) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("file_name", fileName);
        paramObj.put("file_type", "aac");
        paramObj.put("file_data", fileData);


        dataObj.put("method", "alarm_sound_add");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octAddAlarmSound(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
            @Override
            public BaseBean<EmptyBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                EmptyBean emptyBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<EmptyBean>() {}.getType());

                BaseBean<EmptyBean> octEmptyBean = new BaseBean<>();
                octEmptyBean.setCode(stringBaseBean.getCode());
                octEmptyBean.setMsg(stringBaseBean.getMsg());
                octEmptyBean.setData(emptyBean);

                JSONObject jsonObject = JSON.parseObject(stringBaseBean.getData());
                JSONObject error = jsonObject.getJSONObject("error");
                int errorcode = error.getIntValue("errorcode");
                if (errorcode != 0) {
                    octEmptyBean.setCode(String.valueOf(errorcode));
                }

                return octEmptyBean;
            }
        });

    }



    //60 云视通2.0删除自定义报警音
    @Override
    public Observable<BaseBean<EmptyBean>> octDeleteAlarmSound(String deviceSn, int channelId, String devUser, String devPwd, String fileName) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("file_name", fileName);


        dataObj.put("method", "alarm_sound_del");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octDeleteAlarmSound(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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

    //61 云视通2.0报警声音播放（设备端播放）
    @Override
    public Observable<BaseBean<EmptyBean>> octAlarmSoundPlay(String deviceSn, int channelId, String devUser, String devPwd, String fileName) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("file_name", fileName);


        dataObj.put("level", "Operator");
        dataObj.put("method", "alarm_sound_play");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octAlarmSoundPlay(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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



    //云视通2.0报警联动id获取
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

    //62 云视通2.0报警联动获取
    @Override
    public Observable<BaseBean<OctAlarmLinkGetBean>> octAlarmLinkGet(String deviceSn, int channelId, String devUser, String devPwd, int linkId, boolean bDefault) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
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



    //63 云视通2.0报警联动配置
    @Override
    public Observable<BaseBean<EmptyBean>> octAlarmLinkSet(String deviceSn, int channelId, String devUser, String devPwd, JSONObject paramObj) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

//        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
//        paramObj.put("file_name", fileName);


        dataObj.put("level", "Operator");
        dataObj.put("method", "alarm_link_set");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octAlarmLinkSet(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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


//    //53 对讲模式切换-云视通2.0
//    @Override
//    public Observable<BaseBean<EmptyBean>> octChatSetParam(String deviceSn, int channelId, boolean singleCall,String devUser, String devPwd, String param) {
//        TreeMap<String, Object> parma = ParamUtil.getParma();
//        parma.put("sn", deviceSn);
//        parma.put("user", devUser);
//        parma.put("password", devPwd);
//        parma.put("protocol", "CLOUDSEE2");
//
//
//        JSONObject dataObj = new JSONObject();
//
//        JSONObject paramObj = JSONObject.parseObject(param);
//        paramObj.put("channelid", channelId);
//
//        JSONObject chatModeObject = new JSONObject();
//        if (singleCall) {
//            chatModeObject.put("chatMode", JVSetParamConst.VALUE_OCT_CHAT_SINGLE);
//        } else {
//            chatModeObject.put("chatMode", JVSetParamConst.VALUE_OCT_CHAT_DOUBLE);
//        }
//        paramObj.put("chartAttr", chatModeObject);
//
//        dataObj.put("method", "chat_set_param");
//        dataObj.put("param", paramObj);
//
//        parma.put("data", dataObj.toJSONString());
//
//
//        return mApiService.octChatSetParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
//            @Override
//            public BaseBean<EmptyBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();
//                EmptyBean emptyBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<EmptyBean>() {}.getType());
//
//                BaseBean<EmptyBean> octEmptyBean = new BaseBean<>();
//                octEmptyBean.setCode(stringBaseBean.getCode());
//                octEmptyBean.setMsg(stringBaseBean.getMsg());
//                octEmptyBean.setData(emptyBean);
//
//                return octEmptyBean;
//            }
//        });
//
//    }

    @Override
    public Observable<BaseBean<EmptyBean>> editDeviceYst(String deviceSn, String deviceName, String deviceUser, String newDevPwd) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);
        if (!TextUtils.isEmpty(deviceName)) {
            param.put("deviceName", deviceName);
        }
        if (!TextUtils.isEmpty(deviceUser)) {
            param.put("deviceUser", deviceUser);
        }
        param.put("devicePwd", newDevPwd);

        return mApiService.editDeviceYst(ParamUtil.getBody(param));
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
    public Observable<BaseBean<OnvifGetDiscoveryInfo>> octGetOnVifDiscoveryFlag(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "netservice_onvif_get_discoveryinfo");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octGetOnVifDiscoveryFlag(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OnvifGetDiscoveryInfo>>() {
            @Override
            public BaseBean<OnvifGetDiscoveryInfo> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OnvifGetDiscoveryInfo onvifGetDiscoveryInfo = gson.fromJson(stringBaseBean.getData(), new TypeToken<OnvifGetDiscoveryInfo>() {}.getType());

                BaseBean<OnvifGetDiscoveryInfo> onvifGetDiscoveryInfoBaseBean = new BaseBean<>();
                onvifGetDiscoveryInfoBaseBean.setCode(stringBaseBean.getCode());
                onvifGetDiscoveryInfoBaseBean.setMsg(stringBaseBean.getMsg());
                onvifGetDiscoveryInfoBaseBean.setData(onvifGetDiscoveryInfo);

                return onvifGetDiscoveryInfoBaseBean;
            }
        });

    }

    @Override
    public Observable<BaseBean<EmptyBean>> octSetOnVifDiscoveryFlag(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

//        JSONObject paramObj = new JSONObject();
//        paramObj.put("channelid", channelId);
//        paramObj.put("file_name", fileName);


        dataObj.put("level", "Operator");
        dataObj.put("method", "netservice_onvif_set_discoveryinfo");

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);

        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octSetOnVifDiscoveryFlag(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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
    public Observable<BaseBean<OctStreamGetAllAbility>> octGetStreamAllAbility(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "stream_get_all_ability");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octGetStreamAllAbility(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctStreamGetAllAbility>>() {
            @Override
            public BaseBean<OctStreamGetAllAbility> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctStreamGetAllAbility octStreamGetAllAbility = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctStreamGetAllAbility>() {}.getType());

                BaseBean<OctStreamGetAllAbility> octStreamGetAllAbilityBaseBean = new BaseBean<>();
                octStreamGetAllAbilityBaseBean.setCode(stringBaseBean.getCode());
                octStreamGetAllAbilityBaseBean.setMsg(stringBaseBean.getMsg());
                octStreamGetAllAbilityBaseBean.setData(octStreamGetAllAbility);

                return octStreamGetAllAbilityBaseBean;
            }
        });

    }

    @Override
    public Observable<BaseBean<OctStreamGetParams>> octGetStreamParams(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
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
                OctStreamGetParams octStreamGetParams = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctStreamGetParams>() {}.getType());

                BaseBean<OctStreamGetParams> octStreamGetParamsBaseBean = new BaseBean<>();
                octStreamGetParamsBaseBean.setCode(stringBaseBean.getCode());
                octStreamGetParamsBaseBean.setMsg(stringBaseBean.getMsg());
                octStreamGetParamsBaseBean.setData(octStreamGetParams);

                return octStreamGetParamsBaseBean;
            }
        });

    }

    @Override
    public Observable<BaseBean<EmptyBean>> octSetStreamParams(String deviceSn, int channelId,String devUser, String devPwd,  OctStreamGetParams.ResultBean octStreamGetParams) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        dataObj.put("level", "Operator");
        dataObj.put("method", "stream_set_params");

        dataObj.put("param", octStreamGetParams);

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

    @Override
    public Observable<BaseBean<EmptyBean>> octSetDefaultCfg(String deviceSn, int channelId,String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        dataObj.put("level", "Operator");
        dataObj.put("method", "dev_set_default_cfg");

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("module", "stream");
        JSONObject stramObj = new JSONObject();
        stramObj.put("bvdef", true);//恢复视频默认配置
        paramObj.put("stream", stramObj);

        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.setDefaultCfg(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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



    // 云视通2.0-获取虚焦检测的参数
    @Override
    public Observable<BaseBean<OctIvpVfBean>> octIvpVfGetParam(String deviceSn, int channelId, String devUser, String devPwd) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);


        dataObj.put("method", "ivp_vf_get_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octIvpVfGetParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctIvpVfBean>>() {
            @Override
            public BaseBean<OctIvpVfBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctIvpVfBean octIvpVfBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctIvpVfBean>() {}.getType());

                BaseBean<OctIvpVfBean> octIvpVfBaseBean = new BaseBean<>();
                octIvpVfBaseBean.setCode(stringBaseBean.getCode());
                octIvpVfBaseBean.setMsg(stringBaseBean.getMsg());
                octIvpVfBaseBean.setData(octIvpVfBean);

                return octIvpVfBaseBean;
            }
        });

    }





    // 云视通2.0-设置虚焦检测的参数
    @Override
    public Observable<BaseBean<EmptyBean>> octIvpVfSetParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        TreeMap<String, Object> parma = setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = JSONObject.parseObject(param);
        paramObj.put("channelid", channelId);


        dataObj.put("method", "ivp_vf_set_param");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        LogUtil.v("Sadfasdgsadgsdg","data="+dataObj.toJSONString());

        return mApiService.octIvpVfSetParam(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
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
}



