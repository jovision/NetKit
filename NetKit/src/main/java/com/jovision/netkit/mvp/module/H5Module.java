package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.H5Model;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.H5Contract;

import dagger.Module;
import dagger.Provides;

@Module
public class H5Module {

    private H5Contract.View mView;

    public H5Module(H5Contract.View mView) {
        this.mView = mView;
    }

    @Provides
    public H5Contract.View provideView() {
        return mView;
    }

    @Provides
    public H5Contract.IH5Model provideModel(ApiService apiService) {

        return new H5Model(apiService);
    }
}
