package com.jovision.netkit.mvp.presenter;

import android.util.Log;

import com.jovision.netkit.mvp.data.bean.AppVersionResponseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.ACAvatarUploadUrlBean;
import com.jovision.netkit.mvp.data.bean.response.ACUserInfoBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.MyContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class MyPresenter extends BasePresenter<MyContract.IMyModel,MyContract.View>{

    @Inject
    public MyPresenter(MyContract.IMyModel iMyModel, MyContract.View view) {
        super(iMyModel, view);
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

    public void updateNickName(final String nickName){
        mModel.ACUpdateNickName(nickName).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.ACUpdateNickNameSuccess(nickName);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.ACUpdateNickNameError(e);
                        }
                    }
                });
    }

    public void uploadAvatarUrl(String fileName){
        mModel.ACUploadAvatarUrl(fileName).compose(RxHttpReponseCompat.<ACAvatarUploadUrlBean>compatResult())
                .subscribe(new ProgressSubcriber<ACAvatarUploadUrlBean>(mContext,mView){
                    @Override
                    public void onNext(@NonNull ACAvatarUploadUrlBean avatarUploadUrlBean) {
                        if (hasView()){
                            mView.ACUploadAvatarUrlSuccess(avatarUploadUrlBean.getUrl());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.ACUploadAvatarUrlError(e);
                        }
                    }
                });
    }

    public void updateAvatar(String fileName){
        mModel.ACUpdateAvatar(fileName).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.ACUpdateAvatarSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.ACUpdateAvatarError(e);
                        }
                    }
                });
    }


    public void getAppNewestVersion(){
        mModel.getAppNewestVersion().compose(RxHttpReponseCompat.<AppVersionResponseBean>compatResult())
                .subscribe(new ProgressSubcriber<AppVersionResponseBean>(mContext, mView,true) {
                    @Override
                    public void onNext(AppVersionResponseBean responseBean) {
                        if (hasView()) {
                            mView.getAppNewestVersionSuccess(responseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });


    }
}
