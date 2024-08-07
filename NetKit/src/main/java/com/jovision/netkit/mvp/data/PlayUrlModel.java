package com.jovision.netkit.mvp.data;

import com.alibaba.fastjson.JSONArray;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.CallUrlBean;
import com.jovision.netkit.mvp.data.bean.response.PetNewDeviceBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.data.http.ConnectUrlBean;
import com.jovision.netkit.mvp.data.http.PlayUrlBean;
import com.jovision.netkit.mvp.presenter.contract.PlayUrlContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class PlayUrlModel implements PlayUrlContract.IPlayUrlModel {

    private ApiService mApiService;

    public PlayUrlModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<List<PlayUrlBean>>> getPlayUrl(String deviceSn, int channelId, int streamId) {

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
    public Observable<BaseBean<CallUrlBean>> getCallUrl(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);

        return mApiService.getCallUrl(ParamUtil.getBody(parma));
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
    public Observable<BaseBean<PetNewDeviceBean>> getSmartAbilityIsPetNewDevice(String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        return mApiService.getSmartAbilityIsPetNewDevice(ParamUtil.getBody(parma));
    }





}
