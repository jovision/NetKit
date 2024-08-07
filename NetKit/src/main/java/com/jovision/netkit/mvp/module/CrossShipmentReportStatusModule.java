package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.CrossShipmentReportStatusModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CrossShipmentReportStatusContract;

import dagger.Module;
import dagger.Provides;

@Module
public class CrossShipmentReportStatusModule {

    private CrossShipmentReportStatusContract.IView mView;

    public CrossShipmentReportStatusModule(CrossShipmentReportStatusContract.IView view) {
        this.mView = view;
    }

    @Provides
    public CrossShipmentReportStatusContract.IView provideView() {
        return mView;
    }

    @Provides
    public CrossShipmentReportStatusContract.IModel provideModel(ApiService apiService) {
        return new CrossShipmentReportStatusModel(apiService);
    }
}
