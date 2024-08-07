package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.InputPwdModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.InputPwdContract;

import dagger.Module;
import dagger.Provides;

/**
 * @author liteng
 * @date 2020/10/31
 */
@Module
public class InputPwdModule {

    private InputPwdContract.View mView;

    public InputPwdModule(InputPwdContract.View view) {
        this.mView = view;
    }

    @Provides
    public InputPwdContract.View provideView() {
        return mView;
    }

    @Provides
    public InputPwdContract.IInputPwdModel provideModel(ApiService apiService) {
        return new InputPwdModel(apiService);
    }
}
