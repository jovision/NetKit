package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.UnreadCountBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

public interface ContractorMainContract {
    interface IModel {

        Observable<BaseBean<UnreadCountBean>> getCrossShipmentUnreadStatus();
    }

    interface IView extends BaseView {

        void getCrossShipmentUnreadStatusSuccess(UnreadCountBean response);

        void getCrossShipmentUnreadStatusError(Throwable t);
    }
}
