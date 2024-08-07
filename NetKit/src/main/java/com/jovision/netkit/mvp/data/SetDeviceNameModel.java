package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.SetDeviceNameContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class SetDeviceNameModel implements SetDeviceNameContract.ISetDeviceNameModel {

    private ApiService mApiService;

    public SetDeviceNameModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setDeviceName(String deviceSn, String deviceName, String accessProtocol) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);
        param.put("deviceName", deviceName);
        param.put("accessProtocol", accessProtocol);

        return mApiService.setDeviceName(ParamUtil.getBody(param));
    }
}
