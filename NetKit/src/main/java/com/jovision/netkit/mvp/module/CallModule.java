package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.CallModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CallContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class CallModule {

    private CallContract.View mView;

    public CallModule(CallContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public CallContract.View provideView(){
        return mView;
    }
    @Provides
    public CallContract.ICallModel provideModel(ApiService apiService){

        return new CallModel(apiService);
    }
}
