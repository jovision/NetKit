package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.InputPhoneModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.InputPhoneContract;

import dagger.Module;
import dagger.Provides;

/**
 * @author liteng
 * @date 2020/10/30
 */
@Module
public class InputPhoneModule {

    private InputPhoneContract.View mView;

    public InputPhoneModule(InputPhoneContract.View view) {
        this.mView = view;
    }

    @Provides
    public InputPhoneContract.View provideView() {
        return mView;
    }

    @Provides
    public InputPhoneContract.IInputPhoneModel provideModel(ApiService apiService) {
        return new InputPhoneModel(apiService);
    }
}
