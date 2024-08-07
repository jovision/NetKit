package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.data.http.TransCmdHelper;
import com.jovision.netkit.mvp.presenter.contract.OneKeyCallContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.HashMap;
import java.util.TreeMap;

import io.reactivex.Observable;

public class OneKeyCallModel implements OneKeyCallContract.IOneKeyCallModel {
    private ApiService mApiService;


    public OneKeyCallModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<EmptyBean>> oneKeyCallPublic(String deviceSn, int channelId, String status) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "dev_set_active_call");
        HashMap<String, Object> param = new HashMap<>();
//        param.put("channelid", channelId);
        param.put("status",status);
        body.put("param", param);

        parma.put("data", ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }
}

