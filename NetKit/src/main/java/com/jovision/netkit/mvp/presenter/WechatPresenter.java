package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.ACGetOpenIDBindUserBean;
import com.jovision.netkit.mvp.data.bean.response.ACKeepAccountBean;
import com.jovision.netkit.mvp.data.bean.response.ACSaveLoginStatusBean;
import com.jovision.netkit.mvp.data.bean.response.ACUserInfoBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.WechatContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * @author juyang
 * @date 2020/12/07
 */
public class WechatPresenter extends BasePresenter<WechatContract.IWechatModel, WechatContract.View> {

    @Inject
    public WechatPresenter(WechatContract.IWechatModel iWechatModel, WechatContract.View view) {
        super(iWechatModel, view);
    }

    //未登录时查询openID是否绑定用户(未使用)
    public void unLoginGetOpenidBindState(com.jovision.netkit.mvp.data.bean.request.ACGetOpenIDBindUserBean requestBean) {
        mModel.unLoginGetOpenidBindState(requestBean).compose(RxHttpReponseCompat.<ACGetOpenIDBindUserBean>compatResult())
                .subscribe(new ProgressSubcriber<ACGetOpenIDBindUserBean>(mContext, mView) {
                    @Override
                    public void onNext(ACGetOpenIDBindUserBean responseBean) {
                        if (hasView()) {
                            mView.unLoginGetOpenidBindStateSuccess(responseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });

    }

    public void getUserInfo(){
        mModel.ACGetUserInfo().compose(RxHttpReponseCompat.<ACUserInfoBean>compatResult())
                .subscribe(new ProgressSubcriber<ACUserInfoBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull ACUserInfoBean userInfoBean) {
                        if (hasView()){
                            mView.ACGetUserInfoSuccess(userInfoBean);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.ACGetUserInfoError(e);
                        }
                    }
                });
    }



    //账号绑定手机号
    public void accountBindMobile(String account,String verifyValue){
        mModel.ACBindMobileMail(account,verifyValue).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.ACBindMobileMailSuccess();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.ACBindMobileMailError(e);
                        }
                    }
                });
    }

//    //已登录用户查询是否绑定微信账号
//    public void loginUserGetBindStatus(){
//        mModel.loginUserGetBindStatus().compose(RxHttpReponseCompat.<ACGetOpenIDBindUserBean>compatResult())
//                .subscribe(new ProgressSubcriber<ACGetOpenIDBindUserBean>(mContext, mView) {
//                    @Override
//                    public void onNext(ACGetOpenIDBindUserBean responseBean) {
//                        if (hasView()) {
//                            Log.e("loginUserGetBind","getIsBind="+responseBean.isExist());
//                            mView.loginUserGetBindStatusSuccess(responseBean);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                    }
//                });
//    }

//    //已登录用户解绑微信
//    public void loginUserUnBindOpenid(){
//        mModel.loginUserUnBindOpenid().compose(RxHttpReponseCompat.<EmptyBean>compatResult())
//                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
//                    @Override
//                    public void onNext(EmptyBean responseBean) {
//                        if (hasView()) {
//                            Log.e("loginUserUnBindOpenid","success");
//                            mView.loginUserUnBindOpenidSuccess();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        if (hasView()) {
//                            mView.loginUserUnBindOpenidFailed(e);
//                        }
//                    }
//                });
//    }

    //已登录用户绑定微信
    public void socialBindUnBind(String openId,String socialType,String type){
        mModel.ACSocialBindUnBind(openId,socialType,type).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean responseBean) {
                        if (hasView()) {
                            mView.ACSocialBindUnBindSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ACSocialBindUnBindFailed(e);
                        }
                    }
                });
    }


    public void logout(){
        mModel.ACLogout().compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {

                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.ACLogoutSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ACLogoutError();
                        }
                    }
                });
    }

    public void getSaveLoginStatus(){
        mModel.ACGetSaveLoginStatus().compose(RxHttpReponseCompat.<ACSaveLoginStatusBean>compatResult())
                .subscribe(new ProgressSubcriber<ACSaveLoginStatusBean>(mContext,mView) {

                    @Override
                    public void onNext(@NonNull ACSaveLoginStatusBean bean) {
                        if (hasView()){
                            mView.ACGetSaveLoginStatusSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ACGetSaveLoginStatusError();
                        }
                    }
                });
    }

    public void setSaveLoginStatus(int accountKeep) {
        mModel.ACSetSaveLoginStatus(accountKeep).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {

                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()){
                            mView.ACSetSaveLoginStatusSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ACSetSaveLoginStatusError();
                        }
                    }
                });
    }

    public void getKeepAccountStatus(String userID){
        mModel.ACGetKeepAccountStatus(userID).compose(RxHttpReponseCompat.<ACKeepAccountBean>compatResult())
                .subscribe(new ProgressSubcriber<ACKeepAccountBean>(mContext,mView) {

                    @Override
                    public void onNext(@NonNull ACKeepAccountBean bean) {
                        if (hasView()){
                            mView.ACGetKeepAccountStatusSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ACGetKeepAccountStatusError();
                        }
                    }
                });
    }

    public void stopPushMsg(){
        mModel.stopPushMsg().compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {

                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.stopPushMsgSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.stopPushMsgError();
                        }
                    }
                });
    }


}