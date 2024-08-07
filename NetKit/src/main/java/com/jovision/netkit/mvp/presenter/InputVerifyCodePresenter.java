package com.jovision.netkit.mvp.presenter;

import android.util.Log;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.ACOutBindOpenIdBean;
import com.jovision.netkit.mvp.data.bean.request.ACSendVerifyCodeBean;
import com.jovision.netkit.mvp.data.bean.response.ACAuthCodeBean;
import com.jovision.netkit.mvp.data.bean.response.CheckCancelResponseBean;
import com.jovision.netkit.mvp.data.bean.response.HasDeviceResponseBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.InputVerifyCodeContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * @author liteng
 * @date 2020/10/30
 */
public class InputVerifyCodePresenter extends
        BasePresenter<InputVerifyCodeContract.IInputVerifyCodeModel, InputVerifyCodeContract.View> {

    @Inject
    public InputVerifyCodePresenter(InputVerifyCodeContract.IInputVerifyCodeModel iInputVerifyCodeModel,
                                    InputVerifyCodeContract.View view) {
        super(iInputVerifyCodeModel, view);
    }

    public void sendVerifyCode(ACSendVerifyCodeBean body) {
        mModel.ACSendVerifyCode(body)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.ACSendVerifyCodeSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.ACSendVerifyCodeError(e);
                        }
                    }
                });
    }

//    public void getModifyPhoneAuthCode(String account, String verificationCode) {
//        mModel.getModifyPhoneAuthCode(account, verificationCode)
//                .compose(RxHttpReponseCompat.<ACAuthCodeBean>compatResult())
//                .subscribe(new ProgressSubcriber<ACAuthCodeBean>(mContext, mView) {
//                    @Override
//                    public void onNext(ACAuthCodeBean modifyPhoneAuthCodeBean) {
//                        if (hasView()) {
//                            mView.getModifyPhoneAuthCodeSuccess(modifyPhoneAuthCodeBean);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        mView.ACSendVerifyCodeError(e);
//                    }
//                });
//    }

    public void modifyPhone(String type,String account, String verificationCode, String authCode) {
        mModel.ACModifyPhone(type,account, verificationCode, authCode)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.ACModifyPhoneSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ACModifyPhoneError(e);
                        }
                    }
                });
    }

    public void cancel(String verificationCode,String phone) {
        mModel.cancel(verificationCode,phone)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.cancelSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.cancelError(e);
                        }
                    }
                });
    }



    //未登录用户绑定微信
    public void unLoginUserBindOpenid(ACOutBindOpenIdBean requestBean){
        mModel.ACUnLoginUserBindOpenid(requestBean)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.ACUnLoginUserBindOpenidSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);

                            if (hasView()) {
                                mView.ACUnLoginUserBindOpenidError(e);
                            }


                    }
                });
    }

    public void verifycationCode(String sendBy,String account, String type,String verificationCode){
        mModel.ACVerificationCode(sendBy, account, type,verificationCode).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<ACAuthCodeBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull ACAuthCodeBean modifyPhoneAuthCodeBean) {
                        if (hasView()){
                            mView.ACVerificationCodeSuccess(modifyPhoneAuthCodeBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.ACVerificationCodeError(e);
                        }
                    }
                });
    }

    public void transferDevice(String deviceSn,String receiver,String verificationCode,boolean isTrans){
        mModel.transferDevice(deviceSn, receiver, verificationCode, isTrans).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.transferDeviceSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.transferDeviceError(e);
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


    public void hasDevice(){
        mModel.hasDevice().compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<HasDeviceResponseBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull HasDeviceResponseBean hasDeviceResponseBean) {
                        if (hasView()){
                            mView.hasDeviceSuccess(hasDeviceResponseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.hasDeviceError(e);
                        }
                    }
                });
    }



    public void cancelHasReason(String verificationCode,int cancelReason,String phone) {
        mModel.cancelHasReason(verificationCode,cancelReason,phone)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.cancelHasReasonSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.cancelHasReasonError(e);
                        }
                    }
                });
    }


    public void checkCancel(){
        mModel.checkCancel().compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<CheckCancelResponseBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull CheckCancelResponseBean checkCancelResponseBean) {
                        if (hasView()){
                            mView.checkCancelSuccess(checkCancelResponseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.checkCancelError(e);
                        }
                    }
                });
    }

}
