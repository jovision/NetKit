package com.jovision.netkit.mvp.presenter;


import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.bean.CloudPayInfoBean;
import com.jovision.netkit.mvp.data.bean.CloudStorageGroupBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.CloudListContract;

import javax.inject.Inject;

/**
 * Created by ZHP on 2017/7/19.
 */

public class CloudListPresenter extends BasePresenter<CloudListContract.ICloudListModel, CloudListContract.View> {

    @Inject
    public CloudListPresenter(CloudListContract.ICloudListModel iCloudListModel, CloudListContract.View view) {
        super(iCloudListModel, view);
    }


    public void getCloudList() {
        mModel.getCloudList().compose(RxHttpReponseCompat.<CloudStorageGroupBean>compatResult())
                .subscribe(new ProgressSubcriber<CloudStorageGroupBean>(mContext, mView) {
                    @Override
                    public void onNext(CloudStorageGroupBean cloudStorageBeans) {
                        if (hasView()) {
                            mView.getCloudListSuccess(cloudStorageBeans);
                        }
                    }
                });
    }

    public void getCloudPayInfo(String deviceSn, int channelId, String tenantStorageId, String amount, String paymentType) {
        mModel.getCloudPayInfo(deviceSn, channelId, tenantStorageId, amount, paymentType).compose(RxHttpReponseCompat.<CloudPayInfoBean>compatResult())
                .subscribe(new ProgressSubcriber<CloudPayInfoBean>(mContext, mView) {
                    @Override
                    public void onNext(CloudPayInfoBean cloudPayInfoBean) {
                        if (hasView()) {
                            if (null != cloudPayInfoBean) {
                                cloudPayInfoBean.setPaymentType(paymentType);
                            }
                            mView.getCloudPayInfoSuccess(cloudPayInfoBean);
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getCloudPayInfoError(throwable);
                        }
                    }
                });
    }

    public void getCloudPaySignInfo(String deviceSn, int channelId, String tenantStorageId) {
        mModel.getCloudPaySignInfo(deviceSn, channelId, tenantStorageId).compose(RxHttpReponseCompat.<CloudPayInfoBean>compatResult())
                .subscribe(new ProgressSubcriber<CloudPayInfoBean>(mContext, mView) {
                    @Override
                    public void onNext(CloudPayInfoBean cloudPayInfoBean) {
                        if (hasView()) {
                            if (null != cloudPayInfoBean) {
                                cloudPayInfoBean.setPaymentType(Constant.ALI_PAY);
                            }
                            mView.getCloudPayInfoSuccess(cloudPayInfoBean);
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getCloudPayInfoError(throwable);
                        }
                    }
                });
    }
}
