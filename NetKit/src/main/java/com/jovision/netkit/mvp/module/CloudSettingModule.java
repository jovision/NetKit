package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.CloudSettingModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CloudSettingContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class CloudSettingModule {

    private CloudSettingContract.View mView;

    public CloudSettingModule(CloudSettingContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public CloudSettingContract.View provideView() {
        return mView;
    }

    @Provides
    public CloudSettingContract.ICloudSettingModel provideModel(ApiService apiService) {

        return new CloudSettingModel(apiService);
    }
}
