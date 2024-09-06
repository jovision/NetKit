package com.jovision.netkit.mvp.presenter;


import android.util.Log;


import com.jovision.netkit.mvp.data.bean.response.PackageExpireBean;
import com.jovision.netkit.mvp.data.bean.response.PkgGiftRemindBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAppBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAppStatus;
import com.jovision.netkit.mvp.data.bean.response.SmartAppStatusBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.SmartAppContract;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ZHP on 2017/7/19.
 */

public class SmartAppPresenter extends BasePresenter<SmartAppContract.ISmartAppModel, SmartAppContract.View> {

    @Inject
    public SmartAppPresenter(SmartAppContract.ISmartAppModel model, SmartAppContract.View view) {
        super(model, view);
    }

    public void getSmartAppStatus(String deviceSn, int channelId, String[] algorithmSign) {
        mModel.getSmartAppStatus(deviceSn, channelId, algorithmSign)
                .compose(RxHttpReponseCompat.<List<SmartAppStatusBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<SmartAppStatusBean>>(mContext, mView, false) {
                    @Override
                    public void onNext(List<SmartAppStatusBean> list) {
                        if (hasView()) {
                            mView.getSmartAppStatusSuccess(list);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getSmartAppStatusFailed(e);
                        }
                    }
                });
    }
    public void getSmartApp(String model, String type, String firmVer) {
        mModel.getSmartApp(model, type, firmVer)
                .compose(RxHttpReponseCompat.<List<SmartAppBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<SmartAppBean>>(mContext, mView, false) {
                    @Override
                    public void onNext(List<SmartAppBean> list) {
                        if (hasView()) {
                            mView.getSmartAppSuccess(list);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getSmartAppFailed(e);
                        }
                    }
                });
    }

    public void getGiftRemind(String deviceSn, int channelId,String[] pkgs) {
        mModel.getGiftReminds(deviceSn, channelId, pkgs)
                .compose(RxHttpReponseCompat.<PkgGiftRemindBean>compatResult())
                .subscribe(new ProgressSubcriber<PkgGiftRemindBean>(mContext, mView, true) {
                    @Override
                    public void onNext(PkgGiftRemindBean bean) {
                        Log.d("getGiftRemindSucess", "1111");
                        if (hasView()) {
                            mView.getGiftRemindSucess(bean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        Log.d("getGiftRemindSucess", "2222");
                        if (hasView()) {
                            mView.getGiftRemindFailed(e);
                        }
                    }
                });
    }

    public void getSmartStatus(String deviceSn, int channelId,String[] pkgs) {
        mModel.getSmartStatus(deviceSn, channelId, pkgs)
                .compose(RxHttpReponseCompat.<SmartAppStatus>compatResult())
                .subscribe(new ProgressSubcriber<SmartAppStatus>(mContext, mView, true) {
                    @Override
                    public void onNext(SmartAppStatus items) {
                        if (hasView()) {
                            mView.getSmartStatusSuccess(items);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getSmartStatusFailed(e);
                        }
                    }
                });
    }

    public void packageBind(String deviceId, String extend) {
        mModel.packageBind(deviceId, extend)
                .compose(RxHttpReponseCompat.<PackageExpireBean>compatResult())
                .subscribe(new ProgressSubcriber<PackageExpireBean>(mContext, mView, false) {
                    @Override
                    public void onNext(PackageExpireBean bean) {
                        if (hasView()) {
                            mView.getPackageBindSuccess(bean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getPackageBindFailed(e);
                        }
                    }
                });
    }
}
