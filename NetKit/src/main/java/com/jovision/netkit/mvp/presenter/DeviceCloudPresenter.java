package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.CloudPowerBean;
import com.jovision.netkit.mvp.data.bean.DeviceCloudBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.DeviceCloudContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created by ZHP on 2017/7/19.
 */

public class DeviceCloudPresenter extends BasePresenter<DeviceCloudContract.IDeviceCloudModel, DeviceCloudContract.View> {

    @Inject
    public DeviceCloudPresenter(DeviceCloudContract.IDeviceCloudModel iDeviceCloudModel, DeviceCloudContract.View view) {
        super(iDeviceCloudModel, view);
    }


    public void getDeviceCloudList(String deviceSn, int channelId) {
        mModel.getDeviceCloudList(deviceSn, channelId).compose(RxHttpReponseCompat.<DeviceCloudBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceCloudBean>(mContext, mView) {
                    @Override
                    public void onNext(DeviceCloudBean deviceCloudBean) {
                        if (hasView()) {
                            mView.getDeviceCloudListSuccess(deviceCloudBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getDeviceCloudListError(e);
                        }
                    }
                });
    }

    public void enableCloudStorage(String deviceSn, int channelId, int packageId) {
        mModel.enableCloudStorage(deviceSn, channelId, packageId).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.enableCloudStorageSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.enableCloudStorageError(e);
                        }
                    }
                });
    }

    public void unbindCloudStorage(String deviceSn, int channelId, int packageId){
        mModel.unbindCloudStorage(deviceSn, channelId, packageId).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.unbindCloudStorageSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.unbindCloudStorageError(e);
                        }
                    }
                });
    }

//    public List<CloudPowerBean> getCloudPowers() {
//        ArrayList<CloudPowerBean> cloudPowerBeans = new ArrayList<>();
//        cloudPowerBeans.add(new CloudPowerBean(UIUtil.getString(R.string.str_cloud_storage), R.drawable.icon_cloud_power_cloud));
//        cloudPowerBeans.add(new CloudPowerBean(UIUtil.getString(R.string.str_alarm_video), R.drawable.icon_cloud_power_alarm));
//        cloudPowerBeans.add(new CloudPowerBean(UIUtil.getString(R.string.str_record_download), R.drawable.icon_cloud_power_record));
//        cloudPowerBeans.add(new CloudPowerBean(UIUtil.getString(R.string.str_view_anytime), R.drawable.icon_cloud_power_view));
//        cloudPowerBeans.add(new CloudPowerBean(UIUtil.getString(R.string.str_security_certification), R.drawable.icon_cloud_power_safe));
//        cloudPowerBeans.add(new CloudPowerBean(UIUtil.getString(R.string.str_speed_playback), R.drawable.icon_cloud_power_speed));
//        cloudPowerBeans.add(new CloudPowerBean(UIUtil.getString(R.string.str_alltime_protection), R.drawable.icon_cloud_power_project));
//        cloudPowerBeans.add(new CloudPowerBean(UIUtil.getString(R.string.str_unlimited_space), R.drawable.icon_cloud_power_zoom));
//        return cloudPowerBeans;
//    }
}
