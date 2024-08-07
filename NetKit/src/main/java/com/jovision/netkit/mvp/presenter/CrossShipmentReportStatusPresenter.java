package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.response.CrossShipmentReportBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.CrossShipmentReportStatusContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class CrossShipmentReportStatusPresenter
        extends BasePresenter<CrossShipmentReportStatusContract.IModel,
        CrossShipmentReportStatusContract.IView> {

    @Inject
    public CrossShipmentReportStatusPresenter(CrossShipmentReportStatusContract.IModel model,
                                              CrossShipmentReportStatusContract.IView view) {
        super(model, view);
    }

    /**
     * 获取串货举报详情
     */
    public void getCrossShipmentReport(String crossId) {
        mModel.getCrossShipmentReport(crossId)
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<CrossShipmentReportBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull CrossShipmentReportBean responseBean) {
                        if (hasView()) {
                            mView.getCrossShipmentReportSuccess(responseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getCrossShipmentReportError(e);
                        }
                    }
                });
    }
}
