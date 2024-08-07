package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CloudServiceContract;

public class CloudServiceModel implements CloudServiceContract.ICloudServiceModel {
    private ApiService mApiService;

    public CloudServiceModel(ApiService mApiService) {
        this.mApiService = mApiService;
    }
}
