package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.SetDeviceNameModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.SetDeviceNameContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class SetDeviceNameModule {

    private SetDeviceNameContract.View mView;

    public SetDeviceNameModule(SetDeviceNameContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public SetDeviceNameContract.View provideView() {
        return mView;
    }

    @Provides
    public SetDeviceNameContract.ISetDeviceNameModel provideModel(ApiService apiService) {

        return new SetDeviceNameModel(apiService);
    }
}
