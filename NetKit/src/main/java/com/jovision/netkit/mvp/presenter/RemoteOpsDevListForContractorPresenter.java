package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.response.WaitRemoteOpsDeviceResponseBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.RemoteOpsDevListForContractorContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * @author liteng
 * @date 2022/6/20
 */
public class RemoteOpsDevListForContractorPresenter
        extends BasePresenter<RemoteOpsDevListForContractorContract.IModel, RemoteOpsDevListForContractorContract.IView> {

    @Inject
    public RemoteOpsDevListForContractorPresenter(RemoteOpsDevListForContractorContract.IModel model,
                                                  RemoteOpsDevListForContractorContract.IView view) {
        super(model, view);
    }

    /**
     * 获取待运维设备列表
     */
    public void getRemoteOpsDevListForContractor() {
        mModel.getRemoteOpsDevListForContractor()
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<WaitRemoteOpsDeviceResponseBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull WaitRemoteOpsDeviceResponseBean responseBean) {
                        if (hasView()) {
                            mView.getRemoteOpsDevListForContractorSuccess(responseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getRemoteOpsDevListForContractorError(e);
                        }
                    }
                });
    }
}
