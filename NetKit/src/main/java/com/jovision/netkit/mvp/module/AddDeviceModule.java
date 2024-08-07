package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.AddDeviceModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.AddDeviceContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class AddDeviceModule {

    private AddDeviceContract.View mView;

    public AddDeviceModule(AddDeviceContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public AddDeviceContract.View provideView(){
        return mView;
    }
    @Provides
    public AddDeviceContract.IAddDeviceModel provideModel(ApiService apiService){

        return new AddDeviceModel(apiService);
    }
}
