package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.ACGetOpenIDBindUserBean;
import com.jovision.netkit.mvp.data.bean.response.ACKeepAccountBean;
import com.jovision.netkit.mvp.data.bean.response.ACSaveLoginStatusBean;
import com.jovision.netkit.mvp.data.bean.response.ACUserInfoBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * @author juyang
 * @date 2020/12/07
 */
public interface WechatContract {
    interface IWechatModel {


//        //未登录用户绑定微信
//        @POST("/v1/ums/out_bind_openid")
//        Observable<BaseBean<EmptyBean>> unLoginUserBindOpenid(@Body OutBindOpenIdRequestBean body);
//
//
//        //已登录用户解绑微信
//        @POST("/v1/ums/unbind_openid")
//        Observable<BaseBean<EmptyBean>> loginUserUnBindOpenid(@Body RequestBody body);
//
//        //已登录用户绑定微信
//        @POST("/v1/ums/in_bind_openid")
//        Observable<BaseBean<EmptyBean>> loginUserBindOpenid(@Body RequestBody body);
//
//
//        //已登录用户查询是否绑定微信账号
//        @POST("/v1/ums/get_bind_status")
//        Observable<BaseBean<EmptyBean>> loginUserGetBindStatus(@Body RequestBody body);

        //未登录时查询openID是否绑定用户
        Observable<BaseBean<ACGetOpenIDBindUserBean>> unLoginGetOpenidBindState(com.jovision.netkit.mvp.data.bean.request.ACGetOpenIDBindUserBean requestBean);

        Observable<BaseBean<ACUserInfoBean>> ACGetUserInfo();


        //已登录用户绑定手机号
        Observable<BaseBean<EmptyBean>> ACBindMobileMail(String account, String verifyValue);


//        //已登录用户查询是否绑定微信账号
//        Observable<BaseBean<ACGetOpenIDBindUserBean>> loginUserGetBindStatus();


//        //已登录用户解绑微信
//        Observable<BaseBean<EmptyBean>> loginUserUnBindOpenid();

        //已登录用户绑定微信
        Observable<BaseBean<EmptyBean>> ACSocialBindUnBind(String openId,String socialType,String type);



        Observable<BaseBean<EmptyBean>> ACLogout();

        Observable<BaseBean<ACSaveLoginStatusBean>> ACGetSaveLoginStatus();

        Observable<BaseBean<EmptyBean>> ACSetSaveLoginStatus(int accountKeep);

        Observable<BaseBean<ACKeepAccountBean>> ACGetKeepAccountStatus(String userID);

        Observable<BaseBean<EmptyBean>> stopPushMsg();


    }

    interface View extends BaseView {
        void unLoginGetOpenidBindStateSuccess(ACGetOpenIDBindUserBean responseBean);

//        void loginUserGetBindStatusSuccess(ACGetOpenIDBindUserBean responseBean);

//        void loginUserUnBindOpenidSuccess();
//
//        void loginUserUnBindOpenidFailed(Throwable e);


        void ACGetUserInfoSuccess(ACUserInfoBean userInfoBean);
        void ACGetUserInfoError(Throwable e);


        void ACBindMobileMailSuccess();
        void ACBindMobileMailError(Throwable e);


        void ACSocialBindUnBindSuccess();
        void ACSocialBindUnBindFailed(Throwable e);


        void ACLogoutSuccess();
        void ACLogoutError();

        void ACGetSaveLoginStatusSuccess(ACSaveLoginStatusBean bean);
        void ACGetSaveLoginStatusError();

        void ACSetSaveLoginStatusSuccess();
        void ACSetSaveLoginStatusError();

        void ACGetKeepAccountStatusSuccess(ACKeepAccountBean bean);
        void ACGetKeepAccountStatusError();

        void stopPushMsgSuccess();
        void stopPushMsgError();


    }


}