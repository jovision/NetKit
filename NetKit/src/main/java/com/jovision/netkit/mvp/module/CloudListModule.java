package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.CloudListModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CloudListContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class CloudListModule {

    private CloudListContract.View mView;

    public CloudListModule(CloudListContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public CloudListContract.View provideView(){
        return mView;
    }
    @Provides
    public CloudListContract.ICloudListModel provideModel(ApiService apiService){

        return new CloudListModel(apiService);
    }
}
