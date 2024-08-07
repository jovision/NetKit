package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DownloadUrlBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.WifiTestingContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;


public class WifiTestingModel implements WifiTestingContract.IModel {

    private ApiService mApiService;

    public WifiTestingModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<DownloadUrlBean>> getDownloadUrl() {
        TreeMap<String, Object> param = ParamUtil.getParma();
        return mApiService.getDownloadUrl(ParamUtil.getBody(param));
    }
}
