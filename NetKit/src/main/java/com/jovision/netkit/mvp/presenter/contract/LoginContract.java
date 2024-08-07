package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.RefreshTokenDataBean;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.request.ACLoginRequestBean;
import com.jovision.netkit.mvp.data.bean.response.ACGetOpenIDBindUserBean;
import com.jovision.netkit.mvp.data.bean.response.ACLoginResponseBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;
import okhttp3.RequestBody;

/**
 * @author liteng
 * @date 2020/10/29
 */
public interface LoginContract {
    interface ILoginModel {

//        Observable<BaseBean<ACAccessTokenBean>> ACGetServiceToken();
        Observable<BaseBean<ACLoginResponseBean>> ACLogin(ACLoginRequestBean requestBean);

        Observable<BaseBean<RefreshTokenDataBean>> ACRenewalAccessToken(RequestBody body);


        Observable<BaseBean<ACGetOpenIDBindUserBean>> ACUnLoginGetOpenidBindState(com.jovision.netkit.mvp.data.bean.request.ACGetOpenIDBindUserBean requestBean);

    }

    interface View extends BaseView {

//        void ACGetServiceTokenSuccess(ACAccessTokenBean responseBean);

        void ACLoginSuccess(ACLoginResponseBean responseBean);

        void ACLoginError(Throwable e);

        void ACRenewalAccessTokenSuccess(RefreshTokenDataBean responseBean);

        void ACRenewalAccessTokenError(Throwable e);


        void ACUnLoginGetOpenidBindStateSuccess(ACGetOpenIDBindUserBean responseBean);



    }


}
