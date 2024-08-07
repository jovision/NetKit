package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceProtocolBean;
import com.jovision.netkit.mvp.data.bean.response.ShareDetailBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CaptureContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

/**
 * @author liteng
 * @date 2022/4/2
 */
public class CaptureModel implements CaptureContract.IModel {

    private ApiService mApiService;

    public CaptureModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<EmptyBean>> addDevice(String deviceSn, String validateCode, int ct,
                                                     String deviceUser, String devicePassword, String accessProtocol) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);

        if (accessProtocol.equalsIgnoreCase(Constant.PUBLICCLOUD)) {
            if (ct >= 0) {
                param.put("ct", ct);
            }

            if (validateCode.length() > 0) {
                param.put("validateCode", validateCode);
            }

        }

        param.put("deviceUser", deviceUser);
        param.put("devicePassword", devicePassword);
        param.put("accessProtocol", accessProtocol);

        return mApiService.addDevice(ParamUtil.getBody(param));
    }

    @Override
    public Observable<BaseBean<DeviceProtocolBean>> getDeviceProtocol(String deviceSn) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);
        return mApiService.getDeviceProtocol(ParamUtil.getBody(param));
    }

    //扫码登录（V2）
    @Override
    public Observable<BaseBean<EmptyBean>> qrLogin(String qrCode) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("qrCode", qrCode);
        return mApiService.qrLogin(ParamUtil.getBody(param));
    }


    //扫码后确认或取消登录（V2）
    @Override
    public Observable<BaseBean<EmptyBean>> qrLoginConform(String qrCode,boolean confirmed) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("qrCode", qrCode);
        param.put("confirmed", confirmed);
        return mApiService.qrLoginConform(ParamUtil.getBody(param));
    }

    @Override
    public Observable<BaseBean<ShareDetailBean>> getShareQRCodeDetail(String shareToken) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("shareToken", shareToken);
        return mApiService.getShareQRCodeDetail(ParamUtil.getBody(param));
    }


}
