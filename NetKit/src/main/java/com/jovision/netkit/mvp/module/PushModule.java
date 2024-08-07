package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.PushModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.PushContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class PushModule {

    private PushContract.View mView;

    public PushModule(PushContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public PushContract.View provideView() {
        return mView;
    }

    @Provides
    public PushContract.IPushModel provideModel(ApiService apiService) {

        return new PushModel(apiService);
    }
}
