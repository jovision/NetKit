package com.jovision.netkit.mvp.module;


import com.jovision.netkit.mvp.data.CrossShipmentReportListModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CrossShipmentReportListContract;

import dagger.Module;
import dagger.Provides;

@Module
public class CrossShipmentReportListModule {

    private CrossShipmentReportListContract.IView mView;

    public CrossShipmentReportListModule(CrossShipmentReportListContract.IView view) {
        this.mView = view;
    }

    @Provides
    public CrossShipmentReportListContract.IView provideView() {
        return mView;
    }

    @Provides
    public CrossShipmentReportListContract.IModel provideModel(ApiService apiService) {
        return new CrossShipmentReportListModel(apiService);
    }
}
