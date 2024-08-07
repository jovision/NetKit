package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.FriendShareDetailModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.FriendShareDetailContract;

import dagger.Module;
import dagger.Provides;

/**
 * @author liteng
 * @date 2022/4/2
 */
@Module
public class FriendShareDetailModule {

    private FriendShareDetailContract.IView mView;

    public FriendShareDetailModule(FriendShareDetailContract.IView view) {
        this.mView = view;
    }

    @Provides
    public FriendShareDetailContract.IView provideView() {
        return mView;
    }

    @Provides
    public FriendShareDetailContract.IModel provideModel(ApiService apiService) {
        return new FriendShareDetailModel(apiService);
    }
}
