package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.ChangeAccountModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.ChangeAccountContract;

import dagger.Module;
import dagger.Provides;

@Module
public class ChangeAccountModule {

    private ChangeAccountContract.View mView;

    public ChangeAccountModule(ChangeAccountContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public ChangeAccountContract.View provideView() {
        return mView;
    }

    @Provides
    public ChangeAccountContract.IChangeAccountModel provideModel(ApiService apiService) {

        return new ChangeAccountModel(apiService);
    }
}
