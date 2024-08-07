package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.ApConfigModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.ApConfigContract;

import dagger.Module;
import dagger.Provides;

@Module
public class ApConfigModule {


    private ApConfigContract.View mView;

    public ApConfigModule(ApConfigContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public ApConfigContract.View provideView() {
        return mView;
    }

    @Provides
    public ApConfigContract.IApConfigModel providerModel(ApiService apiService) {
        return new ApConfigModel(apiService);
    }
}
