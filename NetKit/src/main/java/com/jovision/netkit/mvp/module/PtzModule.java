package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.PtzModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.PtzContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class PtzModule {

    private PtzContract.View mView;

    public PtzModule(PtzContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public PtzContract.View provideView(){
        return mView;
    }
    @Provides
    public PtzContract.IPtzModel provideModel(ApiService apiService){

        return new PtzModel(apiService);
    }
}
