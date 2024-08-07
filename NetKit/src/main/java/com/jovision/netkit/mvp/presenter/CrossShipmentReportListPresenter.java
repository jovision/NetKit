package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.response.CrossShipmentReportListBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.CrossShipmentReportListContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class CrossShipmentReportListPresenter
        extends BasePresenter<CrossShipmentReportListContract.IModel,
        CrossShipmentReportListContract.IView> {

    @Inject
    public CrossShipmentReportListPresenter(CrossShipmentReportListContract.IModel model,
                                            CrossShipmentReportListContract.IView view) {
        super(model, view);
    }

    /**
     * 获取串货举报列表
     */
    public void getCrossShipmentReportList(int page, int size) {
        mModel.getCrossShipmentReportList(page, size)
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<CrossShipmentReportListBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull CrossShipmentReportListBean responseBean) {
                        if (hasView()) {
                            mView.getCrossShipmentReportListSuccess(responseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getCrossShipmentReportListError(e);
                        }
                    }
                });
    }
}
