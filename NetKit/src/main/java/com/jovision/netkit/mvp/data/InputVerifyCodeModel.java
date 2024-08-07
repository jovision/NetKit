package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.ACOutBindOpenIdBean;
import com.jovision.netkit.mvp.data.bean.request.ACSendVerifyCodeBean;
import com.jovision.netkit.mvp.data.bean.response.ACAuthCodeBean;
import com.jovision.netkit.mvp.data.bean.response.CheckCancelResponseBean;
import com.jovision.netkit.mvp.data.bean.response.HasDeviceResponseBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.InputVerifyCodeContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

/**
 * @author liteng
 * @date 2020/10/30
 */
public class InputVerifyCodeModel implements InputVerifyCodeContract.IInputVerifyCodeModel {
    private ApiService mApiService;

    public InputVerifyCodeModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACSendVerifyCode(ACSendVerifyCodeBean body) {
        return mApiService.ACSendVerifyCode(body);
    }

//    @Override
//    public Observable<BaseBean<ACAuthCodeBean>> getModifyPhoneAuthCode(String account, String verificationCode) {
//        TreeMap<String, Object> map = ParamUtil.getParma();
//        map.put("account", account);
//        map.put("verificationCode", verificationCode);
//        return mApiService.getModifyPhoneAuthCode(ParamUtil.getBody(map));
//    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACModifyPhone(String type,String newAccount, String oldVerifyValue, String newVerifyValue) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("type", type);
        map.put("newAccount", newAccount);
        map.put("oldVerifyValue", oldVerifyValue);
        map.put("newVerifyValue", newVerifyValue);
        return mApiService.ACModifyPhone(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> cancel(String verificationCode, String phone) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("verifyCode", verificationCode);
        map.put("account", phone);
        return mApiService.cancel(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACUnLoginUserBindOpenid(ACOutBindOpenIdBean requestBean) {
        return mApiService.ACUnLoginUserBindOpenid(requestBean);
    }

    @Override
    public Observable<BaseBean<ACAuthCodeBean>> ACVerificationCode(String sendBy, String account, String type, String verificationCode) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("sendBy", sendBy);
        map.put("receiver", account);
        map.put("type", type);
        map.put("verifyValue", verificationCode);
        return mApiService.ACVerificationCode(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> transferDevice(String deviceSn, String receiver, String verificationCode, boolean isTrans) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("deviceSn", deviceSn);
        map.put("receiver", receiver);
        map.put("verificationCode", verificationCode);
        map.put("isTrans", isTrans);
        return mApiService.transferDevice(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACBindMobileMail(String account,String verifyValue) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("account", account);
        map.put("verifyValue", verifyValue);
        return mApiService.ACBindMobileMail(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<HasDeviceResponseBean>> hasDevice() {
        return mApiService.hasDevice();
    }


    @Override
    public Observable<BaseBean<EmptyBean>> cancelHasReason(String verificationCode,int cancelReason, String phone) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("verifyCode", verificationCode);
        map.put("cancelReason", cancelReason);
        map.put("account", phone);
        return mApiService.cancelHasReason(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<CheckCancelResponseBean>> checkCancel() {
        return mApiService.checkCancel();
    }


}
