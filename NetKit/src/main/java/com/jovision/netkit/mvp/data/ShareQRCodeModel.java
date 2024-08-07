package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.Permission;
import com.jovision.netkit.mvp.data.bean.response.ShareQrCodeBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.ShareQRCodeContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

/**
 * 共享设备二维码页对应Model
 *
 * @author liteng
 * @date 2022/4/2
 */
public class ShareQRCodeModel implements ShareQRCodeContract.IModel {

    private ApiService mApiService;

    public ShareQRCodeModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<ShareQrCodeBean>> createQRCode(String deviceSn, Permission permission) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("permission", permission);
        return mApiService.createShareQRCode(ParamUtil.getBody(parma));
    }
}
