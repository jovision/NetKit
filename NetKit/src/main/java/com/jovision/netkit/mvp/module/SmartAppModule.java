package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.SmartAppModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.SmartAppContract;

import dagger.Module;
import dagger.Provides;

/**
 * @ProjectName: SAAS
 * @Package: com.jovision.saas.di.module
 * @ClassName: SmartAppModule
 * @Description: java类作用描述
 * @CreateDate: 2024/3/20 14:42
 * @Version: 1.0
 */
@Module
public class SmartAppModule {

    private SmartAppContract.View mView;

    public SmartAppModule(SmartAppContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public SmartAppContract.View provideView() {
        return mView;
    }

    @Provides
    public SmartAppContract.ISmartAppModel provideModel(ApiService apiService) {

        return new SmartAppModel(apiService);
    }
}
