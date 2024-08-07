package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.ACSendVerifyCodeBean;
import com.jovision.netkit.mvp.data.bean.response.ACIsUserExistBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * @author liteng
 * @date 2020/10/30
 */
public interface InputPhoneContract {

    interface IInputPhoneModel {
        Observable<BaseBean<ACIsUserExistBean>> ACIsUserExist(String account);
        Observable<BaseBean<EmptyBean>> sendVerifyCode(ACSendVerifyCodeBean body);

        //已登录用户绑定手机号
        Observable<BaseBean<EmptyBean>> ACBindMobileMail(String account,String verifyValue);
    }

    interface View extends BaseView {
        void ACIsUserExistSuccess(ACIsUserExistBean entity);
        void sendVerifyCodeSuccess();
        void sendVerifyCodeError(Throwable e);

        void ACBindMobileMailSuccess();
        void ACBindMobileMailError(Throwable e);
    }
}
