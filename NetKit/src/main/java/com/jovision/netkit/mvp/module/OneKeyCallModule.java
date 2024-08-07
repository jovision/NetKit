package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.OneKeyCallModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.OneKeyCallContract;

import dagger.Module;
import dagger.Provides;

@Module
public class OneKeyCallModule {

    private OneKeyCallContract.View mView;

    public OneKeyCallModule(OneKeyCallContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public OneKeyCallContract.View provideView(){
        return mView;
    }

    @Provides
    public OneKeyCallContract.IOneKeyCallModel provideModel(ApiService apiService){
        return new OneKeyCallModel(apiService);
    }

}
