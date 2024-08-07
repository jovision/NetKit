package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.InputPwdContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * @author liteng
 * @date 2020/10/31
 */
public class InputPwdPresenter extends BasePresenter<InputPwdContract.IInputPwdModel, InputPwdContract.View> {

    @Inject
    public InputPwdPresenter(InputPwdContract.IInputPwdModel iInputPwdModel, InputPwdContract.View view) {
        super(iInputPwdModel, view);
    }

    public void register(String account, String password, String verificationCode, String type,String openID,String phoneModel,String terminalId) {
        mModel.ACRegister(account, password, verificationCode, type,openID,phoneModel,terminalId)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.ACRegisterSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.ACRegisterError(e);
                        }
                    }
                });
    }

    public void forgetPwd(String account, String verificationCode, String password) {
        mModel.ACForgetPwd(account, verificationCode, password)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.ACForgetPwdSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.ACForgetPwdError(e);
                        }
                    }
                });
    }

    public void modifyPwd(String newPassword, String password) {
        mModel.ACModifyPwd(newPassword, password)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.ACModifyPwdSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.ACModifyPwdError(e);
                        }
                    }
                });
    }

    public void setPwd(String password){
        mModel.ACSetPwd(password).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.ACSetPwdSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.ACSetPwdError(e);
                        }
                    }
                });
    }
}
