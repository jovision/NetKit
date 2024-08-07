package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.AddActivateDeviceModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.AddActivateDeviceContract;

import dagger.Module;
import dagger.Provides;

/**
 * 添加/激活设备页-module
 *
 * @author liteng
 * @date 2022/4/12
 */
@Module
public class AddActivateDeviceModule {

    private AddActivateDeviceContract.IView mView;

    public AddActivateDeviceModule(AddActivateDeviceContract.IView view) {
        this.mView = view;
    }

    @Provides
    public AddActivateDeviceContract.IView provideView() {
        return mView;
    }

    @Provides
    public AddActivateDeviceContract.IModel provideModel(ApiService apiService) {
        return new AddActivateDeviceModel(apiService);
    }
}
