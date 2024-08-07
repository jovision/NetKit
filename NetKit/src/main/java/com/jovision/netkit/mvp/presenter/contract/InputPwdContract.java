package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * @author liteng
 * @date 2020/10/31
 */
public interface InputPwdContract {
    interface IInputPwdModel {
        Observable<BaseBean<EmptyBean>> ACRegister(String account, String password, String verificationCode, String type, String openID, String phoneModel, String terminalId);

        Observable<BaseBean<EmptyBean>> ACForgetPwd(String account, String verificationCode, String password);

        Observable<BaseBean<EmptyBean>> ACModifyPwd(String newPassword, String password);

        Observable<BaseBean<EmptyBean>> ACSetPwd(String password);
    }

    interface View extends BaseView {
        void ACRegisterSuccess();
        void ACRegisterError(Throwable e);

        void ACForgetPwdSuccess();
        void ACForgetPwdError(Throwable e);

        void ACModifyPwdSuccess();
        void ACModifyPwdError(Throwable e);

        void ACSetPwdSuccess();
        void ACSetPwdError(Throwable e);
    }
}
