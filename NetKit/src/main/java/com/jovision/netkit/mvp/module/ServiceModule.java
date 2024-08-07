package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.ServiceModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.ServiceContract;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

    private ServiceContract.View mView;

    public ServiceModule(ServiceContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public ServiceContract.View provideView() {
        return mView;
    }

    @Provides
    public ServiceContract.IServiceModel provideModel(ApiService apiService) {

        return new ServiceModel(apiService);
    }
}
