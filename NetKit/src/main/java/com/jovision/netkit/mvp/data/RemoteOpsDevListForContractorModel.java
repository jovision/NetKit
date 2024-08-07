package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.WaitRemoteOpsDeviceResponseBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.RemoteOpsDevListForContractorContract;

import io.reactivex.Observable;

/**
 * @author liteng
 * @date 2022/6/20
 */
public class RemoteOpsDevListForContractorModel implements RemoteOpsDevListForContractorContract.IModel {

    private ApiService mApiService;

    public RemoteOpsDevListForContractorModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<WaitRemoteOpsDeviceResponseBean>> getRemoteOpsDevListForContractor() {
        return mApiService.getRemoteOpsDevListForContractor();
    }
}
