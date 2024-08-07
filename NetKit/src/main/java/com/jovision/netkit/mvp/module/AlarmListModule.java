package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.AlarmListModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.AlarmListContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class AlarmListModule {

    private AlarmListContract.View mView;

    public AlarmListModule(AlarmListContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public AlarmListContract.View provideView() {
        return mView;
    }

    @Provides
    public AlarmListContract.IAlarmListModel provideModel(ApiService apiService) {

        return new AlarmListModel(apiService);
    }
}
