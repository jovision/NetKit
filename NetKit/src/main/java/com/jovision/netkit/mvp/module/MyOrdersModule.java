package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.MyOrdersModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.MyOrdersContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
@Module
public class MyOrdersModule {

    private MyOrdersContract.View mView;

    public MyOrdersModule(MyOrdersContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public MyOrdersContract.View provideView(){
        return mView;
    }
    @Provides
    public MyOrdersContract.IMyOrdersModel provideModel(ApiService apiService){

        return new MyOrdersModel(apiService);
    }
}
