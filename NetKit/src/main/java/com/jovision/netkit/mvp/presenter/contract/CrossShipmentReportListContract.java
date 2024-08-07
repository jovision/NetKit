package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.CrossShipmentReportListBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

public interface CrossShipmentReportListContract {
    interface IModel {

        Observable<BaseBean<CrossShipmentReportListBean>> getCrossShipmentReportList(int page, int size);
    }

    interface IView extends BaseView {

        void getCrossShipmentReportListSuccess(CrossShipmentReportListBean response);

        void getCrossShipmentReportListError(Throwable t);
    }
}
