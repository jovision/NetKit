package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.ShareQRCodeModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.ShareQRCodeContract;

import dagger.Module;
import dagger.Provides;

/**
 * 共享设备二维码页-module
 *
 * @author liteng
 * @date 2022/4/2
 */
@Module
public class ShareQRCodeModule {

    private ShareQRCodeContract.IView mView;

    public ShareQRCodeModule(ShareQRCodeContract.IView view) {
        this.mView = view;
    }

    @Provides
    public ShareQRCodeContract.IView provideView() {
        return mView;
    }

    @Provides
    public ShareQRCodeContract.IModel provideModel(ApiService apiService) {
        return new ShareQRCodeModel(apiService);
    }
}
