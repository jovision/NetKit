package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.CloudStatusBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CloudSettingContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class CloudSettingModel implements CloudSettingContract.ICloudSettingModel {

    private ApiService mApiService;

    public CloudSettingModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<CloudStatusBean>> getCloudStatus(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        return mApiService.getCloudStatus(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setCloudStatus(String deviceSn, int channelId, int status) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("status", status == 1 ? Constant.OPEN : Constant.CLOSE);
        return mApiService.setCloudStatus(ParamUtil.getBody(parma));
    }
}
