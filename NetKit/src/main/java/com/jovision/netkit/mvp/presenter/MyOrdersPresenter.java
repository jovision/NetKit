package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.response.MyOrdersBean;
import com.jovision.netkit.mvp.data.bean.response.OrderBean;
import com.jovision.netkit.mvp.data.bean.response.OrderPayBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.MyOrdersContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public class MyOrdersPresenter extends BasePresenter<MyOrdersContract.IMyOrdersModel,MyOrdersContract.View>{
    @Inject
    public MyOrdersPresenter(MyOrdersContract.IMyOrdersModel iMyOrdersModel, MyOrdersContract.View view) {
        super(iMyOrdersModel, view);
    }
    public void orderList(@Nullable Long pageStartId, int pageSize){
        mModel.orderList(pageStartId, pageSize).compose(RxHttpReponseCompat.<MyOrdersBean>compatResult())
                .subscribe(new ProgressSubcriber<MyOrdersBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull MyOrdersBean myOrdersBean) {
                        if (hasView()){
                            mView.orderListSuccess(myOrdersBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.orderListError(e);
                        }
                    }
                });
    }
    public void orderInfo(long orderNumber){
        mModel.orderInfo(orderNumber).compose(RxHttpReponseCompat.<OrderBean>compatResult())
                .subscribe(new ProgressSubcriber<OrderBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull OrderBean orderBean) {
                        if (hasView()){
                            mView.orderInfoSuccess(orderBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.orderInfoError(e);
                        }
                    }
                });
    }
    public void orderPay(long orderNumber, String paymentType){
        mModel.orderPay(orderNumber, paymentType).compose(RxHttpReponseCompat.<OrderPayBean>compatResult())
                .subscribe(new ProgressSubcriber<OrderPayBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull OrderPayBean orderPayBean) {
                        if (hasView()){
                            mView.orderPaySuccess(orderPayBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.orderPayError(e);
                        }
                    }
                });
    }
}
