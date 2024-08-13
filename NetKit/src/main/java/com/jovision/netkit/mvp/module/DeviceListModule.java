package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.DeviceListModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.DeviceListContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class DeviceListModule {

    private DeviceListContract.View mView;

    public DeviceListModule(DeviceListContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public DeviceListContract.View provideView(){
        return mView;
    }
    @Provides
    public DeviceListContract.IHomeModel provideModel(ApiService apiService){

        return new DeviceListModel(apiService);
    }
}
