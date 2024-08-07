package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.LogModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.LogContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class LogModule {

    private LogContract.LogView mView;

    public LogModule(LogContract.LogView mView) {
        this.mView = mView;
    }

    @Provides
    public LogContract.LogView provideView(){
        return mView;
    }
    @Provides
    public LogContract.ILogModel provideModel(ApiService apiService){

        return new LogModel(apiService);
    }
}
