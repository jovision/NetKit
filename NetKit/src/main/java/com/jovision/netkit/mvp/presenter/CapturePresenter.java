package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceProtocolBean;
import com.jovision.netkit.mvp.data.bean.response.ShareDetailBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.CaptureContract;

import java.util.TreeMap;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

/**
 * @author liteng
 * @date 2022/4/2
 */
public class CapturePresenter extends BasePresenter<CaptureContract.IModel, CaptureContract.IView> {

    @Inject
    public CapturePresenter(CaptureContract.IModel model, CaptureContract.IView view) {
        super(model, view);
    }

    public void addDevice(String deviceSn, String validateCode, int ct, String deviceUser, String devicePassword, String accessProtocol) {
        mModel.addDevice(deviceSn, validateCode, ct, deviceUser, devicePassword, accessProtocol).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.addDeviceSuccess();
                        }
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();

                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.addDeviceError(e);
                        }
                    }
                });
    }

    //获取设备协议等信息
    public void getDeviceProtocol(String deviceSn) {
        mModel.getDeviceProtocol(deviceSn).compose(RxHttpReponseCompat.<DeviceProtocolBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceProtocolBean>(mContext, mView) {
                    @Override
                    public void onNext(DeviceProtocolBean deviceProtocolBean) {
                        if (hasView()) {
                            mView.getDeviceProtocolSuccess(deviceProtocolBean);
                        }
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();

                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);

                        if (hasView()) {
                            mView.getDeviceProtocolError(e);
                        }
//                        if (e instanceof ApiException) {
//                            ApiException a = (ApiException) e;
//                            if (hasView()) {
//                                mView.getDeviceProtocolError(a.getCode());
//                            }
//                        }
                    }
                });
    }


    //扫码登录（V2）
    public void qrLogin(String qrCode) {
        mModel.qrLogin(qrCode)
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.qrLoginSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.qrLoginError(e);
                        }
                    }
                });
    }


    //扫码后确认或取消登录（V2）
    public void qrLoginConform(String qrCode, boolean confirmed) {
        mModel.qrLoginConform(qrCode, confirmed)
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.qrLoginConformSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.qrLoginConformError(e);
                        }
                    }
                });
    }


    /**
     * 查询二维码分享详情
     *
     * @param shareToken
     */
    public void getShareQRCodeDetail(String shareToken) {
        mModel.getShareQRCodeDetail(shareToken)
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<ShareDetailBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull ShareDetailBean shareDetailBean) {
                        if (hasView()) {
                            mView.getShareQRCodeDetailSuccess(shareDetailBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getShareQRCodeDetailError(e);
                        }
                    }
                });
    }
}
