package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.ACSendVerifyCodeBean;
import com.jovision.netkit.mvp.data.bean.response.ACIsUserExistBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.InputPhoneContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

/**
 * @author liteng
 * @date 2020/10/30
 */
public class InputPhoneModel implements InputPhoneContract.IInputPhoneModel {

    private ApiService mApiService;

    public InputPhoneModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<ACIsUserExistBean>> ACIsUserExist(String account) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("account", account);
        return mApiService.ACIsUserExist(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> sendVerifyCode(ACSendVerifyCodeBean body) {
        return mApiService.ACSendVerifyCode(body);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACBindMobileMail(String account,String verifyValue) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("account", account);
        map.put("verifyValue", verifyValue);
        return mApiService.ACBindMobileMail(ParamUtil.getBody(map));
    }
}
