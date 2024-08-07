package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.MessageSettingModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.MessageSettingContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class MessageSettingModule {

    private MessageSettingContract.View mView;

    public MessageSettingModule(MessageSettingContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public MessageSettingContract.View provideView() {
        return mView;
    }

    @Provides
    public MessageSettingContract.IMessageSettingModel provideModel(ApiService apiService) {

        return new MessageSettingModel(apiService);
    }
}
