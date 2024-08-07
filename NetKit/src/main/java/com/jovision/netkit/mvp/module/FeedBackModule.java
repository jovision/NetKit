package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.FeedBackModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.FeedBackContract;

import dagger.Module;
import dagger.Provides;

@Module
public class FeedBackModule {
    private FeedBackContract.View mView;

    public FeedBackModule(FeedBackContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public FeedBackContract.View provideView(){return mView;}
    @Provides
    public FeedBackContract.IFeedBackModel provideModel(ApiService apiService){
        return new FeedBackModel(apiService);
    }
}
