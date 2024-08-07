package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.OctSetModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.OctSetContract;

import dagger.Module;
import dagger.Provides;

@Module
public class OctSetModule {

    private OctSetContract.View mView;

    public OctSetModule(OctSetContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public OctSetContract.View provideView() {
        return mView;
    }

    @Provides
    public OctSetContract.IOctSetModel providerModel(ApiService apiService) {
        return new OctSetModel(apiService);
    }
}
