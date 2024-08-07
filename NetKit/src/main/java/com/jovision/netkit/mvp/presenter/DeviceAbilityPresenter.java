package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.DeviceBean;
import com.jovision.netkit.mvp.data.bean.response.SnapShotBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.DeviceAbilityContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created by ZHP on 2017/7/19.
 */

public class DeviceAbilityPresenter extends BasePresenter<DeviceAbilityContract.IDeviceAbilityModel, DeviceAbilityContract.View> {

    @Inject
    public DeviceAbilityPresenter(DeviceAbilityContract.IDeviceAbilityModel iDeviceAbilityModel, DeviceAbilityContract.View view) {
        super(iDeviceAbilityModel, view);
    }


    public void deviceDetail(String deviceSn) {
        mModel.deviceDetail(deviceSn).compose(RxHttpReponseCompat.<DeviceBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull DeviceBean deviceBean) {
                        if (hasView()) {
                            mView.deviceDetailSuccess(deviceBean);
                        }
                    }
                });
    }

    public void snapshot(String deviceSn, int channelId) {
        mModel.snapshot(deviceSn, channelId).compose(RxHttpReponseCompat.<SnapShotBean>compatResult())
                .subscribe(new ProgressSubcriber<SnapShotBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull SnapShotBean snapShotBean) {
                        if (hasView()) {
                            mView.snapshotSuccess(snapShotBean);
                        }
                    }
                });
    }

}
