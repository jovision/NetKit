package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.SetDeviceNameContract;

import javax.inject.Inject;

/**
 * Created by ZHP on 2017/7/19.
 */

public class SetDeviceNamePresenter extends BasePresenter<SetDeviceNameContract.ISetDeviceNameModel, SetDeviceNameContract.View> {

    @Inject
    public SetDeviceNamePresenter(SetDeviceNameContract.ISetDeviceNameModel iSetDeviceNameModel, SetDeviceNameContract.View view) {
        super(iSetDeviceNameModel, view);
    }


    public void setDeviceName(String deviceSn, String deviceName, String accessProtocol) {
        mModel.setDeviceName(deviceSn, deviceName, accessProtocol).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView,false) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setDeviceNameSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setDeviceNameError(e);
                        }
                    }
                });
    }
}
