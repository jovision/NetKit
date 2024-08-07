package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.FriendShareDetailContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

/**
 * @author liteng
 * @date 2022/4/2
 */
public class FriendShareDetailModel implements FriendShareDetailContract.IModel {

    private ApiService mApiService;

    public FriendShareDetailModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<EmptyBean>> updateShareStatus(String shareNumber, String shareStatus) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("shareNumber", shareNumber);
        parma.put("shareStatus", shareStatus);
        return mApiService.updateShareStatus(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> receiveQRCodeShare(String shareToken) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("shareToken", shareToken);
        return mApiService.receiveQRCodeShare(ParamUtil.getBody(parma));
    }
}
