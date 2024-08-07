package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.response.RemoteOpsBean;
import com.jovision.netkit.mvp.data.bean.response.RemoteOpsDeviceBean;
import com.jovision.netkit.mvp.data.bean.response.RemoteOpsDeviceResponseBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.RemoteOpsDevListForUserContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * 远程运维-用户侧设备列表页对应Presenter
 *
 * @author liteng
 * @date 2022/6/20
 */
public class RemoteOpsDevListForUserPresenter
        extends BasePresenter<RemoteOpsDevListForUserContract.IModel, RemoteOpsDevListForUserContract.IView> {

    @Inject
    public RemoteOpsDevListForUserPresenter(RemoteOpsDevListForUserContract.IModel model,
                                            RemoteOpsDevListForUserContract.IView view) {
        super(model, view);
    }

    /**
     * 获取可远程运维设备列表
     */
    public void getRemoteOpsDevListForUser() {
        mModel.getRemoteOpsDevListForUser()
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<RemoteOpsDeviceResponseBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull RemoteOpsDeviceResponseBean responseBean) {
                        if (hasView()) {
                            mView.getRemoteOpsDevListForUserSuccess(responseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getRemoteOpsDevListForUserError(e);
                        }
                    }
                });
    }

    /**
     * 发起远程运维申请
     *
     * @param deviceList 设备列表
     */
    public void applyRemoteOpsDev(List<RemoteOpsDeviceBean> deviceList) {
        mModel.applyRemoteOpsDev(deviceList)
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<RemoteOpsBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull RemoteOpsBean remoteOpsBean) {
                        if (hasView()) {
                            mView.applyRemoteOpsDevSuccess(remoteOpsBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.applyRemoteOpsDevError(e);
                        }
                    }
                });
    }
}
