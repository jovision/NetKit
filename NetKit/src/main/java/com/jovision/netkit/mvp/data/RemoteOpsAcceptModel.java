package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.RemoteOpsAcceptContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

/**
 * @author liteng
 * @date 2022/6/20
 */
public class RemoteOpsAcceptModel implements RemoteOpsAcceptContract.IModel {

    private ApiService mApiService;

    public RemoteOpsAcceptModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<EmptyBean>> acceptRemoteOpsDev(String operationCode) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("operationCode", operationCode);

        return mApiService.acceptRemoteOpsDev(ParamUtil.getBody(param));
    }
}
