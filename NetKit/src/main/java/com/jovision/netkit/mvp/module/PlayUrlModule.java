package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.PlayUrlModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.PlayUrlContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class PlayUrlModule {

    private PlayUrlContract.View mView;

    public PlayUrlModule(PlayUrlContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public PlayUrlContract.View provideView() {
        return mView;
    }

    @Provides
    public PlayUrlContract.IPlayUrlModel provideModel(ApiService apiService) {

        return new PlayUrlModel(apiService);
    }
}
