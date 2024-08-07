package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.ACGetOpenIDBindUserBean;
import com.jovision.netkit.mvp.data.bean.response.ACKeepAccountBean;
import com.jovision.netkit.mvp.data.bean.response.ACSaveLoginStatusBean;
import com.jovision.netkit.mvp.data.bean.response.ACUserInfoBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.WechatContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

/**
 * @author liteng
 * @date 2020/10/29
 */
public class WechatModel implements WechatContract.IWechatModel {

    private ApiService mApiService;

    public WechatModel(ApiService apiService) {
        this.mApiService = apiService;
    }


    @Override
    public Observable<BaseBean<ACGetOpenIDBindUserBean>> unLoginGetOpenidBindState(com.jovision.netkit.mvp.data.bean.request.ACGetOpenIDBindUserBean requestBean) {
        return mApiService.ACUnLoginGetOpenidBindState(requestBean);
    }



//    @Override
//    public Observable<BaseBean<ACGetOpenIDBindUserBean>> loginUserGetBindStatus() {
//        return mApiService.loginUserGetBindStatus();
//    }

//    @Override
//    public Observable<BaseBean<EmptyBean>> loginUserUnBindOpenid() {
//        return mApiService.loginUserUnBindOpenid();
//    }

    @Override
    public Observable<BaseBean<ACUserInfoBean>> ACGetUserInfo() {
        return mApiService.ACGetUserInfo();
    }


    @Override
    public Observable<BaseBean<EmptyBean>> ACSocialBindUnBind(String openID, String socialType, String type) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("socialType", socialType);
        map.put("type", type);
        map.put("openID", openID);
        return mApiService.ACSocialBindUnBind(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACLogout() {

        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("clientID", Constant.clientID);

        return mApiService.ACLogout((ParamUtil.getBody(param)));
    }

    @Override
    public Observable<BaseBean<ACSaveLoginStatusBean>> ACGetSaveLoginStatus() {

        return mApiService.ACGetSaveLoginStatus();
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACSetSaveLoginStatus(int accountKeep) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("accountKeep", accountKeep);
        return mApiService.ACSetSaveLoginStatus(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<ACKeepAccountBean>> ACGetKeepAccountStatus(String userID) {

        return mApiService.ACGetKeepAccountStatus(userID);
    }


    @Override
    public Observable<BaseBean<EmptyBean>> stopPushMsg() {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("appType", "APP");
        return mApiService.stopPushMsg(ParamUtil.getBody(param));
    }


    @Override
    public Observable<BaseBean<EmptyBean>> ACBindMobileMail(String account,String verifyValue) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("account", account);
        map.put("verifyValue", verifyValue);
        return mApiService.ACBindMobileMail(ParamUtil.getBody(map));
    }

}
