package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.MyModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.MyContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {
    private MyContract.View mView;

    public MyModule(MyContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public MyContract.View provideView(){return mView;}

    @Provides
    public MyContract.IMyModel provideModel(ApiService apiService){
        return new MyModel(apiService);
    }
}
