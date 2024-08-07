package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.ChangeAccountContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;


public class ChangeAccountModel implements ChangeAccountContract.IChangeAccountModel {

    private ApiService mApiService;

    public ChangeAccountModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<EmptyBean>> changeAccount(String switchType) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("switchType", switchType);
        return mApiService.changeAccount(ParamUtil.getBody(param));
    }
}
