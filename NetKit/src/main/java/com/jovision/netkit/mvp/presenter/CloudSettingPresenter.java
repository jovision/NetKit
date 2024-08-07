package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.CloudStatusBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.CloudSettingContract;

import javax.inject.Inject;

/**
 * Created by ZHP on 2017/7/19.
 */

public class CloudSettingPresenter extends BasePresenter<CloudSettingContract.ICloudSettingModel, CloudSettingContract.View> {

    @Inject
    public CloudSettingPresenter(CloudSettingContract.ICloudSettingModel iCloudSettingModel, CloudSettingContract.View view) {
        super(iCloudSettingModel, view);
    }


    public void getCloudStatus(String deviceSn, int channelId) {
        mModel.getCloudStatus(deviceSn, channelId).compose(RxHttpReponseCompat.<CloudStatusBean>compatResult())
                .subscribe(new ProgressSubcriber<CloudStatusBean>(mContext, mView) {
                    @Override
                    public void onNext(CloudStatusBean cloudStatusBean) {
                        if (hasView()) {
                            mView.getCloudStatusSuccess(cloudStatusBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getCloudStatusError(e);
                        }
                    }
                });
    }

    public void setCloudStatus(String deviceSn, int channelId, int status) {
        mModel.setCloudStatus(deviceSn, channelId, status).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setCloudStatusSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setCloudStatusError(e);
                        }
                    }
                });
    }
}
