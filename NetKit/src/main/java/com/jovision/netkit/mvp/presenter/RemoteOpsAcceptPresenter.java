package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.RemoteOpsAcceptContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * @author liteng
 * @date 2022/6/20
 */
public class RemoteOpsAcceptPresenter
        extends BasePresenter<RemoteOpsAcceptContract.IModel, RemoteOpsAcceptContract.IView> {

    @Inject
    public RemoteOpsAcceptPresenter(RemoteOpsAcceptContract.IModel model,
                                    RemoteOpsAcceptContract.IView view) {
        super(model, view);
    }

    /**
     * 接受远程运维申请
     *
     * @param operationCode 运维识别码
     */
    public void acceptRemoteOpsDev(String operationCode) {
        mModel.acceptRemoteOpsDev(operationCode)
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean response) {
                        if (hasView()) {
                            mView.acceptRemoteOpsDevSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.acceptRemoteOpsDevError(e);
                        }
                    }
                });
    }
}
