package com.jovision.netkit.mvp.presenter;


import com.jovision.basekit.DeviceUtils;
import com.jovision.basekit.MMKVUtil;
import com.jovision.basekit.deviceid.DeviceFlagUtil;
import com.jovision.basekit.utilcode.Utils;
import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.RefreshTokenDataBean;
import com.jovision.netkit.mvp.data.bean.request.ACLoginRequestBean;
import com.jovision.netkit.mvp.data.bean.response.ACGetOpenIDBindUserBean;
import com.jovision.netkit.mvp.data.bean.response.ACLoginResponseBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.LoginContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.HashMap;
import java.util.TreeMap;

import javax.inject.Inject;

/**
 * @author liteng
 * @date 2020/10/29
 */
public class LoginPresenter extends BasePresenter<LoginContract.ILoginModel, LoginContract.View> {

    @Inject
    public LoginPresenter(LoginContract.ILoginModel iLoginModel, LoginContract.View view) {
        super(iLoginModel, view);
    }


//    public void acGetServiceToken() {
//        mModel.ACGetServiceToken().compose(RxHttpReponseCompat.<ACAccessTokenBean>compatResult())
//                .subscribe(new ProgressSubcriber<ACAccessTokenBean>(mContext, mView) {
//                    @Override
//                    public void onNext(ACAccessTokenBean responseBean) {
//                        if (hasView()) {
//                            mView.ACGetServiceTokenSuccess(responseBean);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//
//                    }
//                });
//
//
//    }


    /**
     * 账号中心-登录
     * @param requestBean
     */
    public void acLogin(ACLoginRequestBean requestBean) {
        mModel.ACLogin(requestBean).compose(RxHttpReponseCompat.<ACLoginResponseBean>compatResult())
                .subscribe(new ProgressSubcriber<ACLoginResponseBean>(mContext, mView) {
                    @Override
                    public void onNext(ACLoginResponseBean responseBean) {
                        if (hasView()) {
//                            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpbklkIjoiZmI0ZWYwN2NhOTk0Yjg5YiIsImFwcFR5cGUiOiJBUFAiLCJ0ZW5hbnRJZCI6ImJlYWE2NjliIiwidXNlcklwIjoiMTkyLjE2OC4xLjEiLCJ1c2VySWQiOiIyMTEwNTIyNjE3MjAyMDExMDkwOTUyMTIiLCJpYXQiOjE2MDgxOTA5MjEsInN1YiI6IjIxMTA1MjI2MTcyMDIwMTEwOTA5NTIxMiJ9.yQd4yAlm4yS5dOqHNk8gL6wVS6NI1YXUprJUxstlQGM";
//                            SharePreferencesUtils.saveToken(token);
//                            SharePreferencesUtils.saveTiken(responseBean.getTiken(),responseBean.getTikenValidPeriod());
//                            SharePreferencesUtils.saveToken(responseBean.getToken(),responseBean.getTokenValidPeriod());


                            MMKVUtil.getInstance().saveToken(responseBean.getAccessToken(),responseBean.getAccessTokenExpire());
                            MMKVUtil.getInstance().saveTiken(responseBean.getRefreshToken(),responseBean.getRefreshTokenExpire());


                            mView.ACLoginSuccess(responseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ACLoginError(e);
                        }
                    }
                });


    }


    public void acRenewalAccessToken() {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("refreshToken", MMKVUtil.getInstance().getTiken());

        HashMap<String, String> attributes = new HashMap<>();
        attributes.put("tenantId", Constant.tenantId);

        map.put("attributes", attributes);
        
        map.put("phoneModel", DeviceUtils.getBuildBrand() + DeviceUtils.getModel());
        map.put("terminalID", DeviceFlagUtil.getUniqueDeviceId(Utils.getApp()));

        mModel.ACRenewalAccessToken(ParamUtil.getBody(map)).compose(RxHttpReponseCompat.<RefreshTokenDataBean>compatResult())
                .subscribe(new ProgressSubcriber<RefreshTokenDataBean>(mContext, mView) {
                    @Override
                    public void onNext(RefreshTokenDataBean responseBean) {
                        if (hasView()) {

                            mView.ACRenewalAccessTokenSuccess(responseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ACRenewalAccessTokenError(e);
                        }
                    }
                });


    }





    public void unLoginGetOpenidBindState(com.jovision.netkit.mvp.data.bean.request.ACGetOpenIDBindUserBean requestBean) {
        mModel.ACUnLoginGetOpenidBindState(requestBean).compose(RxHttpReponseCompat.<ACGetOpenIDBindUserBean>compatResult())
                .subscribe(new ProgressSubcriber<ACGetOpenIDBindUserBean>(mContext, mView) {
                    @Override
                    public void onNext(ACGetOpenIDBindUserBean responseBean) {
                        if (hasView()) {
//                            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpbklkIjoiN2ZkNTZlOTMxZjAzNWM3NCIsInRlbmFudElkIjoiYmVhYTY2OWIiLCJ1c2VySXAiOiIxOTIuMTY4LjEuMSIsInVzZXJJZCI6IjIxMTA1MjI2MTcyMDIwMTEwOTA5NTIxMiIsImlhdCI6MTYwNjQ1OTI1Niwic3ViIjoiMjExMDUyMjYxNzIwMjAxMTA5MDk1MjEyIn0.RPe1Xd0mrrbhdmeTAoi_Ul7SwJGw7eNTicN-U6GdFns";
//                            SharePreferencesUtils.saveToken(token);
//                            SharePreferencesUtils.saveToken(responseBean.getToken());
//                            SharePreferencesUtils.saveTiken(responseBean.getTiken());
//                            mView.loginSuccess(responseBean);
                            mView.ACUnLoginGetOpenidBindStateSuccess(responseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ACLoginError(e);
                        }
                    }
                });


    }


//    public void initAgreementPrivacyView(TextView textView) {
//        String service = mContext.getString(R.string.user_service_agreement);
//        String privacy = mContext.getString(R.string.user_privacy_policy);
//        SpannableString serviceSp = new SpannableString(service);
//        SpannableString privacySp = new SpannableString(privacy);
//
//        MyClickableSpan serviceClickSpan = new MyClickableSpan() {
//            @Override
//            public void onClick(View widget) {
//                ServiceOrPrivacyContractActivity.openActivity((Activity) mContext, ServiceOrPrivacyContractActivity.PAGE_TYPE_SERVICE);
//
//            }
//        };
//        serviceSp.setSpan(serviceClickSpan, 0, service.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        MyClickableSpan privacyClickSpan = new MyClickableSpan() {
//            @Override
//            public void onClick(View widget) {
//                ServiceOrPrivacyContractActivity.openActivity((Activity) mContext, ServiceOrPrivacyContractActivity.PAGE_TYPE_PRIVACY);
//            }
//        };
//        privacySp.setSpan(privacyClickSpan, 0, privacy.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//
//        textView.setText("");
//        textView.append(mContext.getString(R.string.str_i_has_read_and_agree));
//        textView.append(serviceSp);
//        textView.append(mContext.getString(R.string.and2));
//        textView.append(privacySp);
//
//        textView.setMovementMethod(LinkMovementMethod.getInstance());
//        textView.setHighlightColor(Color.TRANSPARENT);
//    }

}
