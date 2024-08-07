package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.ContractorMainModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.ContractorMainContract;

import dagger.Module;
import dagger.Provides;

@Module
public class ContractorMainModule {

    private ContractorMainContract.IView mView;

    public ContractorMainModule(ContractorMainContract.IView view) {
        this.mView = view;
    }

    @Provides
    public ContractorMainContract.IView provideView() {
        return mView;
    }

    @Provides
    public ContractorMainContract.IModel provideModel(ApiService apiService) {
        return new ContractorMainModel(apiService);
    }
}
