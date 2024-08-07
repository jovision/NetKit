package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.DeviceAlarmSettingModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.DeviceAlarmSettingContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class DeviceAlarmSettingModule {

    private DeviceAlarmSettingContract.View mView;

    public DeviceAlarmSettingModule(DeviceAlarmSettingContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public DeviceAlarmSettingContract.View provideView(){
        return mView;
    }
    @Provides
    public DeviceAlarmSettingContract.IDeviceAlarmSettingModel provideModel(ApiService apiService){

        return new DeviceAlarmSettingModel(apiService);
    }
}
