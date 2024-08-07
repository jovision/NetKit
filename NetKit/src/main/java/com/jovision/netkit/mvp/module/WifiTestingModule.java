package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.WifiTestingModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.WifiTestingContract;

import dagger.Module;
import dagger.Provides;

@Module
public class WifiTestingModule {

    private WifiTestingContract.View mView;

    public WifiTestingModule(WifiTestingContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public WifiTestingContract.View provideView() {
        return mView;
    }

    @Provides
    public WifiTestingContract.IModel provideModel(ApiService apiService) {

        return new WifiTestingModel(apiService);
    }
}
