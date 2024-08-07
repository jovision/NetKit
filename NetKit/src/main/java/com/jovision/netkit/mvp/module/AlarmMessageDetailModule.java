package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.AlarmMessageDetailModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.AlarmMessageDetailContract;

import dagger.Module;
import dagger.Provides;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/12/08
 * 描述：
 */

@Module
public class AlarmMessageDetailModule {

    private AlarmMessageDetailContract.View mView;

    public AlarmMessageDetailModule(AlarmMessageDetailContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public AlarmMessageDetailContract.View provideView(){
        return mView;
    }
    @Provides
    public AlarmMessageDetailContract.IAlarmMessageDetailModel provideModel(ApiService apiService){

        return new AlarmMessageDetailModel(apiService);
    }
}
