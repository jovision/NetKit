package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceBean;
import com.jovision.netkit.mvp.data.bean.response.SnapShotBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.DeviceAbilityContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class DeviceAbilityModel implements DeviceAbilityContract.IDeviceAbilityModel {

    private ApiService mApiService;

    public DeviceAbilityModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<DeviceBean>> deviceDetail(String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);

        return mApiService.getDeviceDetail(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<SnapShotBean>> snapshot(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);

        return mApiService.snapShot(ParamUtil.getBody(parma));
    }
}
