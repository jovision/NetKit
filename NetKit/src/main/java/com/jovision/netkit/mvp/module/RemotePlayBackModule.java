package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.RemotePlayBackModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.RemotePlayBackContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class RemotePlayBackModule {

    private RemotePlayBackContract.View mView;

    public RemotePlayBackModule(RemotePlayBackContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public RemotePlayBackContract.View provideView(){
        return mView;
    }
    @Provides
    public RemotePlayBackContract.IRemotePlayBackModel provideModel(ApiService apiService){

        return new RemotePlayBackModel(apiService);
    }
}
