package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.LogoutContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

public class LogoutModel implements LogoutContract.ILogoutModel {

    private ApiService apiService;

    public LogoutModel(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACLogout() {

        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("clientID", Constant.clientID);

        return apiService.ACLogout((ParamUtil.getBody(param)));
    }


    @Override
    public Observable<BaseBean<EmptyBean>> stopPushMsg() {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("appType", "APP");
        return apiService.stopPushMsg(ParamUtil.getBody(param));
    }
}
