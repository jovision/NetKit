package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.MainMessageModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.MainMessageContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class MainMessageModule {

    private MainMessageContract.View mView;

    public MainMessageModule(MainMessageContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public MainMessageContract.View provideView() {
        return mView;
    }

    @Provides
    public MainMessageContract.IMainMessageModel provideModel(ApiService apiService) {

        return new MainMessageModel(apiService);
    }
}
