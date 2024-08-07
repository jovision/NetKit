package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceSceneBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.ScenesParmaBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.DeviceSceneSettingContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class DeviceSceneSettingModel implements DeviceSceneSettingContract.IDeviceSceneSettingModel {

    private ApiService mApiService;

    public DeviceSceneSettingModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<List<DeviceSceneBean>>> getDeviceScene(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);

        return mApiService.getDeviceScene(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> changeScene(ArrayList<ScenesParmaBean> scenes, String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("scenes", scenes);
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);

        return mApiService.changeScene(ParamUtil.getBody(parma));
    }
}
