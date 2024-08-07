package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.CaptureModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CaptureContract;

import dagger.Module;
import dagger.Provides;

/**
 * @author liteng
 * @date 2022/4/2
 */
@Module
public class CaptureModule {

    private CaptureContract.IView mView;

    public CaptureModule(CaptureContract.IView view) {
        this.mView = view;
    }

    @Provides
    public CaptureContract.IView provideView() {
        return mView;
    }

    @Provides
    public CaptureContract.IModel provideModel(ApiService apiService) {
        return new CaptureModel(apiService);
    }
}
