package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.ContractorVerifyModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.ContractorVerifyContract;

import dagger.Module;
import dagger.Provides;

@Module
public class ContractorVerifyModule {
    private ContractorVerifyContract.View mView;

    public ContractorVerifyModule(ContractorVerifyContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public ContractorVerifyContract.View provideView(){return mView;}

    @Provides
    public ContractorVerifyContract.IContractorVerifyModel provideModel(ApiService apiService){
        return new ContractorVerifyModel(apiService);
    }
}
