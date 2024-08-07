package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.SceneListModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.SceneListContract;

import dagger.Module;
import dagger.Provides;

@Module
public class SceneListModule {
    private SceneListContract.View mView;

    public SceneListModule(SceneListContract.View mView) {
        this.mView = mView;
    }
    @Provides
    public SceneListContract.View provideView(){
        return mView;
    }

    @Provides
    public SceneListContract.ISceneListModel provideModel(ApiService apiService){
        return new SceneListModel(apiService);
    }

}
