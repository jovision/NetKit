package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.RemoteOpsDevListForContractorModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.RemoteOpsDevListForContractorContract;

import dagger.Module;
import dagger.Provides;

/**
 * @author liteng
 * @date 2022/6/20
 */
@Module
public class RemoteOpsDevListForContractorModule {

    private RemoteOpsDevListForContractorContract.IView mView;

    public RemoteOpsDevListForContractorModule(RemoteOpsDevListForContractorContract.IView view) {
        this.mView = view;
    }

    @Provides
    public RemoteOpsDevListForContractorContract.IView provideView() {
        return mView;
    }

    @Provides
    public RemoteOpsDevListForContractorContract.IModel provideModel(ApiService apiService) {
        return new RemoteOpsDevListForContractorModel(apiService);
    }
}
