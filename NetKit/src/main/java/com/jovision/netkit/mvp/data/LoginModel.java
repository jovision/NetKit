package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.request.ACLoginRequestBean;
import com.jovision.netkit.mvp.data.bean.response.ACGetOpenIDBindUserBean;
import com.jovision.netkit.mvp.data.bean.response.ACLoginResponseBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.LoginContract;

import io.reactivex.Observable;
import okhttp3.RequestBody;

/**
 * @author liteng
 * @date 2020/10/29
 */
public class LoginModel implements LoginContract.ILoginModel {

    private ApiService mApiService;

    public LoginModel(ApiService apiService) {
        this.mApiService = apiService;
    }



//    @Override
//    public Observable<BaseBean<ACAccessTokenBean>> ACGetServiceToken() {
//        TreeMap<String, Object> param = ParamUtil.getParma();
//        param.put("clientID", Constant.clientID);
//        param.put("clientSecret", Constant.clientSecret);
//        return mApiService.ACGetServiceToken(ParamUtil.getBody(param));
//    }

    @Override
    public Observable<BaseBean<ACLoginResponseBean>> ACLogin(ACLoginRequestBean requestBean) {
        return mApiService.ACLogin(requestBean);
    }


    @Override
    public Observable<BaseBean<RefreshTokenDataBean>> ACRenewalAccessToken(RequestBody body) {
        return mApiService.ACRenewalAccessToken(body);
    }

    @Override
    public Observable<BaseBean<ACGetOpenIDBindUserBean>> ACUnLoginGetOpenidBindState(com.jovision.netkit.mvp.data.bean.request.ACGetOpenIDBindUserBean requestBean) {
        return mApiService.ACUnLoginGetOpenidBindState(requestBean);
    }



}
