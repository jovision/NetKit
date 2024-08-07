package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.CrossShipmentReportCommitModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CrossShipmentReportCommitContract;

import dagger.Module;
import dagger.Provides;

@Module
public class CrossShipmentReportCommitModule {

    private CrossShipmentReportCommitContract.IView mView;

    public CrossShipmentReportCommitModule(CrossShipmentReportCommitContract.IView view) {
        this.mView = view;
    }

    @Provides
    public CrossShipmentReportCommitContract.IView provideView() {
        return mView;
    }

    @Provides
    public CrossShipmentReportCommitContract.IModel provideModel(ApiService apiService) {
        return new CrossShipmentReportCommitModel(apiService);
    }
}
