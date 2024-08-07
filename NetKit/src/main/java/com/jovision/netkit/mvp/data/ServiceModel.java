package com.jovision.netkit.mvp.data;

import com.jovision.basekit.utilcode.AppUtils;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.ServiceListBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.ServiceContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;


public class ServiceModel implements ServiceContract.IServiceModel {

    private ApiService mApiService;

    public ServiceModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<ServiceListBean>> getServiceList(String appType) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("appType", appType);
        param.put("appVersion", AppUtils.getAppInfo().getVersionName());
        return mApiService.getServiceList(ParamUtil.getBody(param));
    }

    @Override
    public Observable<BaseBean<ServiceListBean>> getServiceListNew(String appType) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("appType", appType);
        return mApiService.getServiceListNew(ParamUtil.getBody(param));
    }
}
