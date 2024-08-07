package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.RemoteOpsAcceptModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.RemoteOpsAcceptContract;

import dagger.Module;
import dagger.Provides;

/**
 * @author liteng
 * @date 2022/6/20
 */
@Module
public class RemoteOpsAcceptModule {

    private RemoteOpsAcceptContract.IView mView;

    public RemoteOpsAcceptModule(RemoteOpsAcceptContract.IView view) {
        this.mView = view;
    }

    @Provides
    public RemoteOpsAcceptContract.IView provideView() {
        return mView;
    }

    @Provides
    public RemoteOpsAcceptContract.IModel provideModel(ApiService apiService) {
        return new RemoteOpsAcceptModel(apiService);
    }
}
