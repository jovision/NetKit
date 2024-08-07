package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.CallUrlBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CallContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;
import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class CallModel implements CallContract.ICallModel {

    private ApiService mApiService;

    public CallModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<CallUrlBean>> getCallUrl(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);

        return mApiService.getCallUrl(ParamUtil.getBody(parma));
    }
}
