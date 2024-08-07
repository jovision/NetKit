package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.CrossShipmentReportListBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CrossShipmentReportListContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

public class CrossShipmentReportListModel implements CrossShipmentReportListContract.IModel {

    private ApiService mApiService;

    public CrossShipmentReportListModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<CrossShipmentReportListBean>> getCrossShipmentReportList(int page, int size) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("page", page);
        parma.put("size", size);
        return mApiService.getCrossShipmentReportList(ParamUtil.getBody(parma));
    }
}
