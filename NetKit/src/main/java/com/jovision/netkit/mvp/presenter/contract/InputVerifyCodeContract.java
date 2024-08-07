package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.ACOutBindOpenIdBean;
import com.jovision.netkit.mvp.data.bean.request.ACSendVerifyCodeBean;
import com.jovision.netkit.mvp.data.bean.response.ACAuthCodeBean;
import com.jovision.netkit.mvp.data.bean.response.CheckCancelResponseBean;
import com.jovision.netkit.mvp.data.bean.response.HasDeviceResponseBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * @author liteng
 * @date 2020/10/30
 */
public interface InputVerifyCodeContract {
    interface IInputVerifyCodeModel {
        Observable<BaseBean<EmptyBean>> ACSendVerifyCode(ACSendVerifyCodeBean body);

//        Observable<BaseBean<ACAuthCodeBean>> getModifyPhoneAuthCode(String account, String verificationCode);

        Observable<BaseBean<EmptyBean>> ACModifyPhone(String type,String account, String verificationCode, String authCode);

        Observable<BaseBean<EmptyBean>> cancel(String verificationCode, String phone);

        Observable<BaseBean<EmptyBean>> ACUnLoginUserBindOpenid(ACOutBindOpenIdBean requestBean);

        Observable<BaseBean<ACAuthCodeBean>> ACVerificationCode(String sendBy, String account, String type, String verificationCode);

        Observable<BaseBean<EmptyBean>> transferDevice(String deviceSn,String receiver,String verificationCode,boolean isTrans);


        //已登录用户绑定手机号
        Observable<BaseBean<EmptyBean>> ACBindMobileMail(String account,String verifyValue);

        //用户是否符合注销账号条件
        Observable<BaseBean<HasDeviceResponseBean>> hasDevice();


        //新接口带原因注销
        Observable<BaseBean<EmptyBean>> cancelHasReason(String verificationCode,int cancelReason, String phone);


        //新接口用户是否符合注销账号条件
        Observable<BaseBean<CheckCancelResponseBean>> checkCancel();

    }

    interface View extends BaseView {

        void ACSendVerifyCodeSuccess();
        void ACSendVerifyCodeError(Throwable e);


        void ACModifyPhoneSuccess();
        void ACModifyPhoneError(Throwable e);

        void cancelSuccess();
        void cancelError(Throwable e);



        void ACUnLoginUserBindOpenidSuccess();

        void ACUnLoginUserBindOpenidError(Throwable e);

        void ACVerificationCodeSuccess(ACAuthCodeBean bean);
        void ACVerificationCodeError(Throwable e);

        void transferDeviceSuccess();

        void transferDeviceError(Throwable e);


        void ACBindMobileMailSuccess();
        void ACBindMobileMailError(Throwable e);


        void hasDeviceSuccess(HasDeviceResponseBean hasDeviceResponseBean);
        void hasDeviceError(Throwable e);


        void cancelHasReasonSuccess();
        void cancelHasReasonError(Throwable e);


        void checkCancelSuccess(CheckCancelResponseBean checkCancelResponseBean);
        void checkCancelError(Throwable e);
    }
}
