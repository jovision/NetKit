package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.ACSendVerifyCodeBean;
import com.jovision.netkit.mvp.data.bean.response.ACIsUserExistBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.InputPhoneContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * @author liteng
 * @date 2020/10/30
 */
public class InputPhonePresenter extends BasePresenter<InputPhoneContract.IInputPhoneModel,
        InputPhoneContract.View> {

    @Inject
    public InputPhonePresenter(InputPhoneContract.IInputPhoneModel iInputPhoneModel, InputPhoneContract.View view) {
        super(iInputPhoneModel, view);
    }

    public void isUserExist(String account) {
        mModel.ACIsUserExist(account).compose(RxHttpReponseCompat.<ACIsUserExistBean>compatResult())
                .subscribe(new ProgressSubcriber<ACIsUserExistBean>(mContext, mView) {
                    @Override
                    public void onNext(ACIsUserExistBean entity) {
                        if (hasView()) {
                            mView.ACIsUserExistSuccess(entity);
                        }
                    }
                });
    }
    public void sendVerifyCode(ACSendVerifyCodeBean body) {
        mModel.sendVerifyCode(body)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.sendVerifyCodeSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.sendVerifyCodeError(e);
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
}
