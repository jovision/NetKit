package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.CrossShipmentReportBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

public interface CrossShipmentReportStatusContract {
    interface IModel {

        Observable<BaseBean<CrossShipmentReportBean>> getCrossShipmentReport(String crossId);
    }

    interface IView extends BaseView {

        void getCrossShipmentReportSuccess(CrossShipmentReportBean response);

        void getCrossShipmentReportError(Throwable t);
    }
}
