package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.InputPwdContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

/**
 * @author liteng
 * @date 2020/10/31
 */
public class InputPwdModel implements InputPwdContract.IInputPwdModel {

    private ApiService mApiService;

    public InputPwdModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACRegister(String account, String password, String verifyValue, String type, String openID, String phoneModel, String terminalID) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("account", account);
        map.put("password", password);
        map.put("verifyValue", verifyValue);
        map.put("terminalID", terminalID);
        map.put("phoneModel", phoneModel);


        if (type.equalsIgnoreCase(Constant.AC_LOGIN_BY_SOCIAL_QQ)
                || type.equalsIgnoreCase(Constant.AC_LOGIN_BY_SOCIAL_WX)) {
            TreeMap<String, Object> socialMap = ParamUtil.getParma();
            socialMap.put("type", type);
            //认证值，当type为WX时，此处使用微信API返回的code，当此处为QQ或IOS时，此处填写第三方提供的OpenID
            socialMap.put("openID", openID);

            TreeMap<String, Object>[] socialArray = new TreeMap[]{socialMap};
            map.put("social", socialArray);
        } else {
            TreeMap<String, Object>[] socialArray = new TreeMap[]{};
            map.put("social", socialArray);
        }


        return mApiService.ACRegister(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACForgetPwd(String account, String verifyValue, String newPassword) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("account", account);
        map.put("verifyValue", verifyValue);
        map.put("newPassword", newPassword);
        return mApiService.ACForgetPwd(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACModifyPwd(String newPassword, String password) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("newPassword", newPassword);
        map.put("password", password);
        return mApiService.ACModifyPwd(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACSetPwd(String password) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("password", password);
        return mApiService.ACSetPwd(ParamUtil.getBody(map));
    }


}
