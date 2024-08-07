package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.DeviceCloudModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.DeviceCloudContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class DeviceCloudModule {

    private DeviceCloudContract.View mView;

    public DeviceCloudModule(DeviceCloudContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public DeviceCloudContract.View provideView(){
        return mView;
    }
    @Provides
    public DeviceCloudContract.IDeviceCloudModel provideModel(ApiService apiService){

        return new DeviceCloudModel(apiService);
    }
}
