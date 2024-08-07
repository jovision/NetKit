package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.FriendShareDetailContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * @author liteng
 * @date 2022/4/2
 */
public class FriendShareDetailPresenter
        extends BasePresenter<FriendShareDetailContract.IModel, FriendShareDetailContract.IView> {

    @Inject
    public FriendShareDetailPresenter(FriendShareDetailContract.IModel model, FriendShareDetailContract.IView view) {
        super(model, view);
    }

    public void updateShareStatus(String shareNumber, String shareStatus) {
        mModel.updateShareStatus(shareNumber, shareStatus).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.updateShareStatusSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.updateShareStatusError(e);
                        }
                    }
                });
    }

    /**
     * 接收二维码分享
     *
     * @param shareToken
     */
    public void receiveQRCodeShare(String shareToken) {
        mModel.receiveQRCodeShare(shareToken)
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.receiveQRCodeShareSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.receiveQRCodeShareError(e);
                        }
                    }
                });
    }
}
