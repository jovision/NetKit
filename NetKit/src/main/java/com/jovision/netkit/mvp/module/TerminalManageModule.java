package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.TerminalManageModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.TerminalManageContract;

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
public class TerminalManageModule {

    private TerminalManageContract.View mView;

    public TerminalManageModule(TerminalManageContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public TerminalManageContract.View provideView(){
        return mView;
    }
    @Provides
    public TerminalManageContract.ITerminalManageModel provideModel(ApiService apiService){

        return new TerminalManageModel(apiService);
    }
}
