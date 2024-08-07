package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.presenter.contract.CloudServiceContract;

import javax.inject.Inject;

public class CloudServicePresenter extends BasePresenter<CloudServiceContract.ICloudServiceModel,CloudServiceContract.View>{

    @Inject
    public CloudServicePresenter(CloudServiceContract.ICloudServiceModel iCloudServiceModel, CloudServiceContract.View view) {
        super(iCloudServiceModel, view);
    }

    public void getCloudServiceUrl(){

    }

}
