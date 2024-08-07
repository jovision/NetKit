package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.WechatModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.WechatContract;

import dagger.Module;
import dagger.Provides;

/**
 * @author juyang
 * @date 2020/12/07
 */
@Module
public class WechatModule {

    private WechatContract.View mView;

    public WechatModule(WechatContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public WechatContract.View provideView() {
        return mView;
    }

    @Provides
    public WechatContract.IWechatModel provideModel(ApiService apiService) {
        return new WechatModel(apiService);
    }
}
