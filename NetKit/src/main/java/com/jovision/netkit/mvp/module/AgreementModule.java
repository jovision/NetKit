package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.AgreementModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.AgreementContract;

import dagger.Module;
import dagger.Provides;

@Module
public class AgreementModule {
    private AgreementContract.View mView;

    public AgreementModule(AgreementContract.View mView) {
        this.mView = mView;
    }
    @Provides
    public AgreementContract.View provideView(){
        return mView;
    }
    @Provides
    public AgreementContract.IAgreementModel provideModel(ApiService apiService){
        return new AgreementModel(apiService);
    }
}
