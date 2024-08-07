package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceCloudBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.DeviceCloudContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class DeviceCloudModel implements DeviceCloudContract.IDeviceCloudModel {

    private ApiService mApiService;

    public DeviceCloudModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<DeviceCloudBean>> getDeviceCloudList(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);

        return mApiService.getDeviceCloudList(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> enableCloudStorage(String deviceSn, int channelId, int packageId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("packageId", packageId);

        return mApiService.enableCloudStorage(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> unbindCloudStorage(String deviceSn, int channelId, int packageId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("packageId", packageId);

        return mApiService.unbindCloudStorage(ParamUtil.getBody(parma));
    }
}
