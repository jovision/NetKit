package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceListResponseBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.DeviceListContract;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class DeviceListModel implements DeviceListContract.IHomeModel {

    private ApiService mApiService;

    public DeviceListModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<DeviceListResponseBean>> deviceList() {

        return mApiService.getDevices();
    }

}
