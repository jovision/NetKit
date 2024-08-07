package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.MyOrdersBean;
import com.jovision.netkit.mvp.data.bean.response.OrderBean;
import com.jovision.netkit.mvp.data.bean.response.OrderPayBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.MyOrdersContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class MyOrdersModel implements MyOrdersContract.IMyOrdersModel {

    private ApiService mApiService;

    public MyOrdersModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<MyOrdersBean>> orderList(Long pageStartId, int pageSize) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("pageStartId", pageStartId);
        parma.put("pageSize", pageSize);
        return mApiService.orderList(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<OrderBean>> orderInfo(long orderNumber) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("orderNumber", orderNumber);
        return mApiService.orderInfo(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<OrderPayBean>> orderPay(long orderNumber, String paymentType) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("orderNumber", orderNumber);
        parma.put("paymentType", paymentType);
        return mApiService.orderPay(ParamUtil.getBody(parma));
    }
}
