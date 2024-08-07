package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.response.OctDevInfoBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.DeviceInfoContract;

import javax.inject.Inject;

public class DeviceInfoPresenter extends BasePresenter<DeviceInfoContract.IDeviceInfoModel, DeviceInfoContract.View> {

    @Inject
    public DeviceInfoPresenter(DeviceInfoContract.IDeviceInfoModel model, DeviceInfoContract.View view) {
        super(model, view);
    }


    public void octGetDevHwinfo(String deviceSn, int channelId, String devUser,String devPwd,boolean isAp) {
        mModel.octGetDevHwinfo(deviceSn, channelId, devUser, devPwd,isAp).compose(RxHttpReponseCompat.<OctDevInfoBean>compatResult())
                .subscribe(new ProgressSubcriber<OctDevInfoBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctDevInfoBean octDevInfoBean) {
                        if (hasView()) {
                            mView.octGetDevHwinfoSuccess(octDevInfoBean,deviceSn,channelId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octGetDevHwinfoFailed(e,deviceSn,channelId);
                        }
                    }
                });
    }

}
