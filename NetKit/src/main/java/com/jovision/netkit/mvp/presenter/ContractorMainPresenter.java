package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.response.UnreadCountBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.ContractorMainContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class ContractorMainPresenter
        extends BasePresenter<ContractorMainContract.IModel,
        ContractorMainContract.IView> {

    @Inject
    public ContractorMainPresenter(ContractorMainContract.IModel model,
                                   ContractorMainContract.IView view) {
        super(model, view);
    }

    /**
     * 获取未读状态
     */
    public void getCrossShipmentUnreadStatus() {
        mModel.getCrossShipmentUnreadStatus()
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<UnreadCountBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull UnreadCountBean responseBean) {
                        if (hasView()) {
                            mView.getCrossShipmentUnreadStatusSuccess(responseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getCrossShipmentUnreadStatusError(e);
                        }
                    }
                });
    }
}
