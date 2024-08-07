package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.AddActivateDeviceContract;

import androidx.annotation.NonNull;


import javax.inject.Inject;

/**
 * 添加/激活设备页对应Presenter
 *
 * @author liteng
 * @date 2022/4/12
 */
public class AddActivateDevicePresenter
        extends BasePresenter<AddActivateDeviceContract.IModel, AddActivateDeviceContract.IView> {

    @Inject
    public AddActivateDevicePresenter(AddActivateDeviceContract.IModel model, AddActivateDeviceContract.IView view) {
        super(model, view);
    }

    /**
     * 绑定(添加)设备
     *
     * @param deviceSn
     * @param validateCode
     * @param ct
     * @param deviceUser
     * @param devicePassword
     * @param accessProtocol
     */
    public void addDevice(String deviceSn, String validateCode, int ct,
                          String deviceUser, String devicePassword, String accessProtocol) {

        mModel.addDevice(deviceSn, validateCode, ct, deviceUser, devicePassword, accessProtocol)
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.addDeviceSuccess();
                        }
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

    /**
     * 修改云视通设备信息
     *
     * @param deviceSn
     * @param deviceName
     * @param deviceUser
     * @param newDevPwd
     */
    public void editDeviceYst(@NonNull String deviceSn,
                              String deviceName,
                              String deviceUser,
                              @NonNull String newDevPwd) {
        mModel.editDeviceYst(deviceSn, deviceName, deviceUser, newDevPwd)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.editDeviceYstSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.editDeviceYstError(e);
                        }
                    }
                });
    }

}
