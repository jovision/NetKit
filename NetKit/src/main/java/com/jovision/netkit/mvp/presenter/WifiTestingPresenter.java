package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.DownloadUrlBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.WifiTestingContract;

import javax.inject.Inject;

public class WifiTestingPresenter extends BasePresenter<WifiTestingContract.IModel, WifiTestingContract.View> {

    @Inject
    public WifiTestingPresenter(WifiTestingContract.IModel iModel, WifiTestingContract.View view) {
        super(iModel, view);
    }

    public void getDownloadUrl() {
        mModel.getDownloadUrl()
                .compose(RxHttpReponseCompat.<DownloadUrlBean>compatResult())
                .subscribe(new ProgressSubcriber<DownloadUrlBean>(mContext, mView,true) {
                    @Override
                    public void onNext(DownloadUrlBean bean) {
                        if (hasView()) {
                            mView.getDownloadUrlSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getDownloadUrlError(e);
                        }
                    }
                });
    }

}
