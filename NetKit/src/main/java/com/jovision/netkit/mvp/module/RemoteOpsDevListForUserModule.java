package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.RemoteOpsDevListForUserModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.RemoteOpsDevListForUserContract;

import dagger.Module;
import dagger.Provides;

/**
 * 远程运维-用户侧设备列表页对应Module
 *
 * @author liteng
 * @date 2022/6/20
 */
@Module
public class RemoteOpsDevListForUserModule {

    private RemoteOpsDevListForUserContract.IView mView;

    public RemoteOpsDevListForUserModule(RemoteOpsDevListForUserContract.IView view) {
        this.mView = view;
    }

    @Provides
    public RemoteOpsDevListForUserContract.IView provideView() {
        return mView;
    }

    @Provides
    public RemoteOpsDevListForUserContract.IModel provideModel(ApiService apiService) {
        return new RemoteOpsDevListForUserModel(apiService);
    }
}
