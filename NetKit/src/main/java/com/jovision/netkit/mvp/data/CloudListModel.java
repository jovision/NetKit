package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.CloudPayInfoBean;
import com.jovision.netkit.mvp.data.bean.CloudStorageGroupBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CloudListContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class CloudListModel implements CloudListContract.ICloudListModel {

    private ApiService mApiService;

    public CloudListModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<CloudStorageGroupBean>> getCloudList() {
        return mApiService.getCloudList();
    }

    @Override
    public Observable<BaseBean<CloudPayInfoBean>> getCloudPayInfo(String deviceSn, int channelId, String tenantStorageId, String amount, String paymentType) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("tenantStorageId", tenantStorageId);
        parma.put("amount", amount);
        parma.put("paymentType", paymentType);

        return mApiService.getCloudPayInfo(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<CloudPayInfoBean>> getCloudPaySignInfo(String deviceSn, int channelId, String tenantStorageId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("storageID", tenantStorageId);

        return mApiService.getCloudPaySignInfo(ParamUtil.getBody(parma));
    }
}
