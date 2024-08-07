package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.DeviceSceneSettingModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.DeviceSceneSettingContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class DeviceSceneSettingModule {

    private DeviceSceneSettingContract.View mView;

    public DeviceSceneSettingModule(DeviceSceneSettingContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public DeviceSceneSettingContract.View provideView() {
        return mView;
    }

    @Provides
    public DeviceSceneSettingContract.IDeviceSceneSettingModel provideModel(ApiService apiService) {

        return new DeviceSceneSettingModel(apiService);
    }
}
