package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.DeviceListResponseBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.DeviceListContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;


public class DeviceListPresenter extends BasePresenter<DeviceListContract.IHomeModel, DeviceListContract.View> {

    @Inject
    public DeviceListPresenter(DeviceListContract.IHomeModel iModel, DeviceListContract.View view) {
        super(iModel, view);
    }


    public void requestDeviceList(){
        mModel.deviceList().compose(RxHttpReponseCompat.<DeviceListResponseBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceListResponseBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull DeviceListResponseBean deviceListResponseBean) {
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.deviceListSuccess(deviceListResponseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.deviceListError(e);
                        }
                    }
                });
    }
}
