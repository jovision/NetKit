package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.DeviceChnosdParamModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.DeviceChnosdParamContract;

import dagger.Module;
import dagger.Provides;

/**
 * 公有云协议: OSD设置
 *
 * @author liteng
 * @date 2022/11/28
 */
@Module
public class DeviceChnosdParamModule {
    private DeviceChnosdParamContract.IView mView;

    public DeviceChnosdParamModule(DeviceChnosdParamContract.IView view) {
        this.mView = view;
    }

    @Provides
    public DeviceChnosdParamContract.IView provideView() {
        return mView;
    }

    @Provides
    public DeviceChnosdParamContract.IModel provideModel(ApiService apiService) {
        return new DeviceChnosdParamModel(apiService);
    }
}
