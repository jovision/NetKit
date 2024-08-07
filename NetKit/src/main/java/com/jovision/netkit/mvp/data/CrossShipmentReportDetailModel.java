package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.CrossShipmentReportBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CrossShipmentReportDetailContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

public class CrossShipmentReportDetailModel implements CrossShipmentReportDetailContract.IModel {

    private ApiService mApiService;

    public CrossShipmentReportDetailModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<CrossShipmentReportBean>> getCrossShipmentReport(String crossId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("crossId", crossId);
        return mApiService.getCrossShipmentReport(ParamUtil.getBody(parma));
    }
}
