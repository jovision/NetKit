package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.DeviceSettingModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.DeviceSettingContract;

import dagger.Module;
import dagger.Provides;

@Module
public class DeviceSettingModule {
    private DeviceSettingContract.View mView;

    public DeviceSettingModule(DeviceSettingContract.View mView) {
        this.mView = mView;
    }
    @Provides
    public DeviceSettingContract.View provideView(){return mView;}

    @Provides
    public DeviceSettingContract.IDeviceSettingModel provideModel(ApiService apiService){
        return new DeviceSettingModel(apiService);
    }
}
