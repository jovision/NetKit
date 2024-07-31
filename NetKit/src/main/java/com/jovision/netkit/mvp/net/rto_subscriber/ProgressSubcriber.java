package com.jovision.netkit.mvp.net.rto_subscriber;

import static android.content.Context.ACTIVITY_SERVICE;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;


import com.jovision.basekit.JsonUtils;
import com.jovision.basekit.LogUtil;
import com.jovision.languagekit.R.string;
import com.jovision.netkit.BuildConfig;
import com.jovision.netkit.mvp.bean.BaseBean;
import com.jovision.netkit.mvp.net.rto_exception.ApiException;
import com.jovision.netkit.mvp.net.rto_exception.BaseException;
import com.jovision.netkit.mvp.net.rto_exception.EmptyDataException;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.uikit.BaseView;
import com.jovision.uikit.util.ToastKit;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * Created by ZHP on 2017/6/25.
 */

public abstract class ProgressSubcriber<T> extends ErrorHandlerSubscriber<T> {

    private static final String TAG = "ProgressSubcriber";

    private boolean isNotShowProgress;
    private BaseView mView;
    private Context context;


    public ProgressSubcriber(Context context, BaseView view) {
        super(context);
        this.mView = view;
        this.context = context;
    }

    public ProgressSubcriber(Context context, BaseView view, boolean isNotShowProgress) {
        super(context);
        this.mView = view;
        this.isNotShowProgress = isNotShowProgress;
        this.context = context;

    }

    public boolean isShowProgress() {
        return !isNotShowProgress;
    }

    @Override
    public void onSubscribe(Disposable d) {
        super.onSubscribe(d);
        if (isShowProgress() && null != mView) {
            mView.showLoading();
        }
    }

    @Override
    public void onComplete() {
        if (isShowProgress() && null != mView) {
            mView.dismissLoading();
        }
    }

    @Override
    public void onError(Throwable e) {

        LogUtil.e(TAG, "api-compatResult-failed-onError:");
        if (isShowProgress() && null != mView) {
            mView.dismissLoading();
        }
//        LogUtil.v("运行时错误", "e:" + e.toString());
        if (e instanceof ApiException) {
            ApiException a = (ApiException) e;
            LogUtil.v(TAG, "api-compatResult-failed-onError:" + a.getDisplayMessage() + "------" + a.getCode());
            if (a.getCode().equals(BaseException.ERROR_TOKEN)
                    || a.getCode().equals(BaseException.UNAUTHORIZED)
                    || a.getCode().equals(BaseException.ACCESS_TOKEN_INVALID)
                    || a.getCode().equals(BaseException.ACCESS_TOKEN_OVERDUE)
                    || a.getCode().equals(BaseException.ACCOUNT_KICKED_OUT)
                    || a.getCode().equals(BaseException.REFRESH_TOKEN_INVALID)) {
                try {
//                    showLoginPop();
                    if(BuildConfig.DEBUG){
                        ToastKit.showToastSafe(context,context.getString(com.jovision.languagekit.R.string.tips_login_overdue)+";code="+a.getCode());
                    }else {
                        ToastKit.showToastSafe(context,com.jovision.languagekit.R.string.tips_login_overdue);
                    }

//                    if (!isInLogin()){
//                        checkKeepAccount();
//                    }
                    //ssss退出到登陆界面
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else if (a.getCode().equals(String.valueOf(BaseException.AC_THE_IP_LOCK))) {
                try {
                    ToastKit.showToastSafe(context,com.jovision.languagekit.R.string.error_2237);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else if (a.getCode().equals(BaseException.ACCOUNT_FREEZE_ERROR)) {
                try {
//                    showLoginPop();
                    ToastKit.showToastSafe(context,string.tips_request_error);
//                    if (!isInLogin()){
//                        checkKeepAccount();
//                    }
                    //ssss退出到登陆界面
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else if (a.getCode().equals(BaseException.INTERNAL_SERVER_ERROR)) {
                try {
//                    ToastKit.showToastSafe(com.jovision.languagekit.R.string.error_500);//长时间登录不操作后刷新提示服务器异常，先注释掉。(#^.^#)
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }



            /*else if (a.getCode().equals(BaseException.ERROR_TOKEN_OVER)) {
                UserCacheUtil.loginOut();
                ActivityUtils.finishAllActivities();
                toLogin();
            }*/
            else {
                if (null != mView) {
//                    mView.showError(a.getDisplayMessage());//不吐司错误，View自己处理
                }
            }

        } else if (e instanceof HttpException) {
            ResponseBody body = ((HttpException) e).response().errorBody();
            try {
                if (body.string().contains("<head>")) {

                } else {
                    BaseBean baseBean = JsonUtils.fromJson(body.string(), BaseBean.class);
                    mView.showError(null != baseBean ? baseBean.getMsg() : "");
                }
            } catch (IOException IOe) {
                IOe.printStackTrace();
            }
        } else if (e instanceof SocketTimeoutException) {  //VPN open
            //errorMessage = "服务器响应超时";
//            if (null != mView) {
//                mView.showError("服务器响应超时");//设备离线，有部分设备相关接口会响应超时，暂时不提示
//            }
        } else if (e instanceof UnknownHostException) {
            LogUtil.v("运行时错误", "无网络-UnknownHostException:" + e.getMessage()+"  mView = "+mView);
            if (null != mView) {

//                com.jovision.saas.ui.activity.adddevice.SettingNetProgressActivity@70fe4a4
                String currentNotifyer = String.valueOf(context);
                if (currentNotifyer.contains("SettingNetProgressActivity")) {
                    //do nothing
                } else {
                    mView.showError(ToastKit.getString(context,com.jovision.languagekit.R.string.str_connect_exception));
                }

            }

        } else if (e instanceof ConnectException) {
            //errorMessage = "网络连接异常，请检查网络";
            LogUtil.v("运行时错误", "无网络-ConnectException:" + e.getMessage());
            if (null != mView) {

//                com.jovision.saas.ui.activity.adddevice.SettingNetProgressActivity@70fe4a4
                String currentNotifyer = String.valueOf(context);
                if (currentNotifyer.contains("SettingNetProgressActivity")) {
                    //do nothing
                } else {
                    mView.showError(ToastKit.getString(context,com.jovision.languagekit.R.string.str_connect_exception));
                }

            }
        } else if (e instanceof RuntimeException) {
            //errorMessage = "运行时错误";
            if (null != mView) {
                e.printStackTrace();

                LogUtil.v("运行时错误", "message:" + e.getMessage());
          /*  if (null != mView) {
                mView.showError("运行时错误");
            }*/
            } else if (e instanceof UnknownHostException) {
                //errorMessage = "无法解析主机，请检查网络连接";
                if (null != mView) {
                    mView.showError(ToastKit.getString(context,com.jovision.languagekit.R.string.tips_unknown_host_exception));
                }
            } else if (e instanceof UnknownServiceException) {
                // errorMessage = "未知的服务器错误";
                if (null != mView) {
                    mView.showError(ToastKit.getString(context,com.jovision.languagekit.R.string.tips_unknown_service_exception));
                }
            } else if (e instanceof IOException) {  //飞行模式等
//            errorMessage = "没有网络，请检查网络连接";
                if (null != mView) {
                    mView.showError(ToastKit.getString(context,com.jovision.languagekit.R.string.tips_io_exception));
                }
            } else if (e instanceof EmptyDataException) {
                if (null != mView) {
                    mView.showError(ToastKit.getString(context,com.jovision.languagekit.R.string.tips_empty_data_exception));
                }
            } else {
                ApiException exception = new ApiException("500", ToastKit.getString(context,com.jovision.languagekit.R.string.tips_service_inner_error));
                if (null != mView) {
                    mView.showError(exception.getDisplayMessage());
                }
            }
            if (isShowProgress()) {
                if (null != mView) {
                    mView.dismissLoading();
                }
            }

        }
    }


//    private void checkKeepAccount() {
//        CheckKeepAccountHelper.getInstance().checkKeepAccount(context, mView);
//    }
//
//
//    public boolean isInLogin() {
//        ActivityManager am = (ActivityManager) UIUtil.getContext().getSystemService(ACTIVITY_SERVICE);
//        List<ActivityManager.RunningTaskInfo> runningTasks = am.getRunningTasks(1);
//        if (runningTasks.size() == 0){
//            return false;
//        }
//        ComponentName topActivity = runningTasks.get(0).topActivity;
//        String className = topActivity.getClassName();
//        if (className.equalsIgnoreCase("com.jovision.saas.ui.activity.login.LoginActivity")) {
//            return true;
//        }
//        if (className.equalsIgnoreCase("com.jovision.saas.ui.activity.login.LoginLastAccountActivity")) {
//            return true;
//        }
//        return false;
//    }
//
//

//    public static class CheckKeepAccountHelper {
//
//
//        private static CheckKeepAccountHelper instance = null;
//
//        private CheckKeepAccountHelper() {
//        }
//
//        public static CheckKeepAccountHelper getInstance() {
//            if (instance == null) {
//                synchronized (CheckKeepAccountHelper.class) {
//                    if (instance == null) {
//                        instance = new CheckKeepAccountHelper();
//                    }
//                }
//            }
//            return instance;
//        }
//
//        private boolean isRequest = false;
//
//        private void checkKeepAccount(Context context, BaseView view) {
//            if (isRequest) {
//                return;
//            }
//            isRequest = true;
//            App.getApplication().getAppComponent()
//                    .getApiService()
//                    .ACGetKeepAccountStatus(SharePreferencesUtils.getUserId())
//                    .compose(RxHttpReponseCompat.<ACKeepAccountBean>compatResult())
//                    .subscribe(new ProgressSubcriber<ACKeepAccountBean>(context, view) {
//
//                        @Override
//                        public void onNext(@NonNull ACKeepAccountBean bean) {
//                            toLogin(bean.getSwitchStatus() == 1);
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//                            super.onError(e);
//                            toLogin(true);
//                        }
//                    });
//        }
//
//        private void toLogin(boolean keepAccount) {
//            Log.e(TAG, "account_keep: " + keepAccount );
//            UserCacheUtil.loginOut(keepAccount);
//            ActivityUtils.finishAllActivities();
//
//            if (keepAccount) {
//                Intent intent = new Intent(UIUtil.getContext(), LoginLastAccountActivity.class);
//                intent.putExtra("flag", "flag");
//                UIUtil.startActivity(intent);
//            } else {
//                UIUtil.startActivity(new Intent(UIUtil.getContext(), LoginWaySelectActivity.class));
//            }
//            isRequest = false;
//        }
//    }

}