package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.InputVerifyCodeModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.InputVerifyCodeContract;

import dagger.Module;
import dagger.Provides;

/**
 * @author liteng
 * @date 2020/10/30
 */
@Module
public class InputVerifyCodeModule {

    private InputVerifyCodeContract.View mView;

    public InputVerifyCodeModule(InputVerifyCodeContract.View view) {
        this.mView = view;
    }

    @Provides
    public InputVerifyCodeContract.View provideView() {
        return mView;
    }

    @Provides
    public InputVerifyCodeContract.IInputVerifyCodeModel provideModel(ApiService apiService) {
        return new InputVerifyCodeModel(apiService);
    }
}
