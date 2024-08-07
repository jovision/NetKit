package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.LoginModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.LoginContract;

import dagger.Module;
import dagger.Provides;

/**
 * @author liteng
 * @date 2020/10/30
 */
@Module
public class LoginModule {

    private LoginContract.View mView;

    public LoginModule(LoginContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public LoginContract.View provideView() {
        return mView;
    }

    @Provides
    public LoginContract.ILoginModel provideModel(ApiService apiService) {
        return new LoginModel(apiService);
    }
}
