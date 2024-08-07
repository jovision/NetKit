package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.CrossShipmentReportDetailModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CrossShipmentReportDetailContract;

import dagger.Module;
import dagger.Provides;

@Module
public class CrossShipmentReportDetailModule {

    private CrossShipmentReportDetailContract.IView mView;

    public CrossShipmentReportDetailModule(CrossShipmentReportDetailContract.IView view) {
        this.mView = view;
    }

    @Provides
    public CrossShipmentReportDetailContract.IView provideView() {
        return mView;
    }

    @Provides
    public CrossShipmentReportDetailContract.IModel provideModel(ApiService apiService) {
        return new CrossShipmentReportDetailModel(apiService);
    }
}
