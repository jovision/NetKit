package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.OctDeviceChnosdParamModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.OctDeviceChnosdParamContract;

import dagger.Module;
import dagger.Provides;

/**
 * 云视通2.0协议: OSD设置
 *
 * @author liteng
 * @date 2022/11/28
 */
@Module
public class OctDeviceChnosdParamModule {
    private OctDeviceChnosdParamContract.IView mView;

    public OctDeviceChnosdParamModule(OctDeviceChnosdParamContract.IView view) {
        this.mView = view;
    }

    @Provides
    public OctDeviceChnosdParamContract.IView provideView() {
        return mView;
    }

    @Provides
    public OctDeviceChnosdParamContract.IModel provideModel(ApiService apiService) {
        return new OctDeviceChnosdParamModel(apiService);
    }
}
