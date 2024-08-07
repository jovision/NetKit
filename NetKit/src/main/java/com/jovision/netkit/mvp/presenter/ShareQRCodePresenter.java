package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.response.Permission;
import com.jovision.netkit.mvp.data.bean.response.ShareQrCodeBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.ShareQRCodeContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * 共享设备二维码页对应Presenter
 *
 * @author liteng
 * @date 2022/4/2
 */
public class ShareQRCodePresenter
        extends BasePresenter<ShareQRCodeContract.IModel, ShareQRCodeContract.IView> {

    @Inject
    public ShareQRCodePresenter(ShareQRCodeContract.IModel model, ShareQRCodeContract.IView view) {
        super(model, view);
    }

    /**
     * 创建共享设备二维码
     *
     * @param deviceSn
     * @param permission
     */
    public void createQRCode(String deviceSn, Permission permission) {
        mModel.createQRCode(deviceSn, permission)
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<ShareQrCodeBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull ShareQrCodeBean qrCodeBean) {
                        if (hasView()) {
                            mView.createQRCodeSuccess(qrCodeBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.createQRCodeError(e);
                        }
                    }
                });
    }

}
