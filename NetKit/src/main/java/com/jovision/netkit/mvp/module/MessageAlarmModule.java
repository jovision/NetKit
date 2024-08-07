package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.MessageAlarmModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.MessageAlarmContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class MessageAlarmModule {

    private MessageAlarmContract.View mView;

    public MessageAlarmModule(MessageAlarmContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public MessageAlarmContract.View provideView() {
        return mView;
    }

    @Provides
    public MessageAlarmContract.IMessageAlarmModel provideModel(ApiService apiService) {

        return new MessageAlarmModel(apiService);
    }
}
