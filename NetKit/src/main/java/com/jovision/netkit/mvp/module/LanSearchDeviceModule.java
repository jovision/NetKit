package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.LanSearchDeviceModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.LanSearchDeviceContract;

import dagger.Module;
import dagger.Provides;

/**
 * 局域网:开始搜索设备页-module
 *
 * @author liteng
 * @date 2022/4/12
 */
@Module
public class LanSearchDeviceModule {

    private LanSearchDeviceContract.IView mView;

    public LanSearchDeviceModule(LanSearchDeviceContract.IView view) {
        this.mView = view;
    }

    @Provides
    public LanSearchDeviceContract.IView provideView() {
        return mView;
    }

    @Provides
    public LanSearchDeviceContract.IModel provideModel(ApiService apiService) {
        return new LanSearchDeviceModel(apiService);
    }
}
