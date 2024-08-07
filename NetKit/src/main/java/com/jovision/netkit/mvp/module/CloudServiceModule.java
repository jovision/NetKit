package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.CloudServiceModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CloudServiceContract;

import dagger.Module;
import dagger.Provides;

@Module
public class CloudServiceModule {

    private CloudServiceContract.View mView;

    public CloudServiceModule(CloudServiceContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public CloudServiceContract.View provideView(){
        return mView;
    }

    @Provides
    public CloudServiceContract.ICloudServiceModel provideModel(ApiService apiService){
        return new CloudServiceModel(apiService);
    }

}
