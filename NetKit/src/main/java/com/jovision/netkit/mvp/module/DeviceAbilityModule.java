package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.DeviceAbilityModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.DeviceAbilityContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class DeviceAbilityModule {

    private DeviceAbilityContract.View mView;

    public DeviceAbilityModule(DeviceAbilityContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public DeviceAbilityContract.View provideView() {
        return mView;
    }

    @Provides
    public DeviceAbilityContract.IDeviceAbilityModel provideModel(ApiService apiService) {

        return new DeviceAbilityModel(apiService);
    }
}
