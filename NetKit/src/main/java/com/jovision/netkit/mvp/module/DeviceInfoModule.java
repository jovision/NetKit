package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.DeviceInfoModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.DeviceInfoContract;

import dagger.Module;
import dagger.Provides;

@Module
public class DeviceInfoModule {

    private DeviceInfoContract.View mView;

    public DeviceInfoModule(DeviceInfoContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public DeviceInfoContract.View provideView(){
        return mView;
    }
    @Provides
    public DeviceInfoContract.IDeviceInfoModel provideModel(ApiService apiService){

        return new DeviceInfoModel(apiService);
    }
}
