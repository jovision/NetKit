package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.UnreadCountBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.ContractorMainContract;

import io.reactivex.Observable;

public class ContractorMainModel implements ContractorMainContract.IModel {

    private ApiService mApiService;

    public ContractorMainModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<UnreadCountBean>> getCrossShipmentUnreadStatus() {
        return mApiService.getCrossShipmentUnreadStatus();
    }
}
