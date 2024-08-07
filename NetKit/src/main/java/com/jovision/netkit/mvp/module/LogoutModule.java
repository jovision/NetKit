package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.LogoutModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.LogoutContract;

import dagger.Module;
import dagger.Provides;

@Module
public class LogoutModule {
    private LogoutContract.View mView;

    public LogoutModule(LogoutContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public LogoutContract.View provideView(){return mView;}

    @Provides
    public LogoutContract.ILogoutModel provideModel(ApiService apiService){
        return new LogoutModel(apiService);
    }

}
