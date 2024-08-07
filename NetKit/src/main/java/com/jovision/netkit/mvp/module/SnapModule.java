package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.SnapModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.SnapContract;

import dagger.Module;
import dagger.Provides;

@Module
public class SnapModule {

    private SnapContract.View mView;

    public SnapModule(SnapContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public SnapContract.View provideView(){
        return mView;
    }
    @Provides
    public SnapContract.ISnapModel provideModel(ApiService apiService){

        return new SnapModel(apiService);
    }
}
