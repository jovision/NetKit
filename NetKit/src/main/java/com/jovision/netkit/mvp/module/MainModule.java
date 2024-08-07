package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.MainModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * @author juyang
 * @date 2020/12/10
 */
@Module
public class MainModule {

    private MainContract.View mView;

    public MainModule(MainContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public MainContract.View provideView() {
        return mView;
    }

    @Provides
    public MainContract.IMainModel provideModel(ApiService apiService) {
        return new MainModel(apiService);
    }
}
