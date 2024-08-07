package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.MyOrdersBean;
import com.jovision.netkit.mvp.data.bean.response.OrderBean;
import com.jovision.netkit.mvp.data.bean.response.OrderPayBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface MyOrdersContract {

    interface IMyOrdersModel {
        Observable<BaseBean<MyOrdersBean>> orderList(Long pageStartId, int pageSize);
        Observable<BaseBean<OrderBean>> orderInfo(long orderNumber);
        Observable<BaseBean<OrderPayBean>> orderPay(long orderNumber, String paymentType);
    }

    interface View extends BaseView {
        void orderListSuccess(MyOrdersBean myOrdersBean);
        void orderListError(Throwable e);
        void orderInfoSuccess(OrderBean orderBean);
        void orderInfoError(Throwable e);
        void orderPaySuccess(OrderPayBean orderPayBean);
        void orderPayError(Throwable e);
    }

}
