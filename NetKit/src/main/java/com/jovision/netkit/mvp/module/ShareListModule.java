package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.ShareListModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.ShareListContract;

import dagger.Module;
import dagger.Provides;

@Module
public class ShareListModule {
    private ShareListContract.View mView;

    public ShareListModule(ShareListContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public ShareListContract.View provideView(){
        return mView;
    }

    @Provides
    public ShareListContract.IShareListModel provideModel(ApiService apiService){
        return new ShareListModel(apiService);
    }
}
