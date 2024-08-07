package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.MessagePersonModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.MessagePersonContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class MessagePersonModule {

    private MessagePersonContract.View mView;

    public MessagePersonModule(MessagePersonContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public MessagePersonContract.View provideView() {
        return mView;
    }

    @Provides
    public MessagePersonContract.IMessagePersonModel provideModel(ApiService apiService) {

        return new MessagePersonModel(apiService);
    }
}
