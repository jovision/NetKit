package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.ServiceListBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.ServiceContract;

import javax.inject.Inject;

public class ServicePresenter extends BasePresenter<ServiceContract.IServiceModel, ServiceContract.View> {

    @Inject
    public ServicePresenter(ServiceContract.IServiceModel iModel, ServiceContract.View view) {
        super(iModel, view);
    }

    public void getServiceList(String appType) {
        mModel.getServiceList(appType)
                .compose(RxHttpReponseCompat.<ServiceListBean>compatResult())
                .subscribe(new ProgressSubcriber<ServiceListBean>(mContext, mView, true) {
                    @Override
                    public void onNext(ServiceListBean bean) {
                        if (hasView()) {
                            mView.getServiceListSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getServiceListError(e);
                        }
                    }
                });
    }

    public void getServiceListNew(String appType) {
        mModel.getServiceListNew(appType)
                .compose(RxHttpReponseCompat.<ServiceListBean>compatResult())
                .subscribe(new ProgressSubcriber<ServiceListBean>(mContext, mView, true) {
                    @Override
                    public void onNext(ServiceListBean bean) {
                        if (hasView()) {
                            mView.getServiceListNewSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getServiceListNewError(e);
                        }
                    }
                });
    }

}
