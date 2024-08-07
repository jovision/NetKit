package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.RemoteOpsBean;
import com.jovision.netkit.mvp.data.bean.response.RemoteOpsDeviceBean;
import com.jovision.netkit.mvp.data.bean.response.RemoteOpsDeviceResponseBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.RemoteOpsDevListForUserContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;

/**
 * 远程运维-用户侧设备列表页对应Model
 *
 * @author liteng
 * @date 2022/6/20
 */
public class RemoteOpsDevListForUserModel implements RemoteOpsDevListForUserContract.IModel {

    private ApiService mApiService;

    public RemoteOpsDevListForUserModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<RemoteOpsDeviceResponseBean>> getRemoteOpsDevListForUser() {
        return mApiService.getRemoteOpsDevListForUser();
    }

    @Override
    public Observable<BaseBean<RemoteOpsBean>> applyRemoteOpsDev(List<RemoteOpsDeviceBean> deviceList) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceList", deviceList);

        return mApiService.applyRemoteOpsDev(ParamUtil.getBody(param));
    }
}
