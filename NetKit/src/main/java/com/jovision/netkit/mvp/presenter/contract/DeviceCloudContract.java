package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceCloudBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface DeviceCloudContract {

    interface IDeviceCloudModel {
        Observable<BaseBean<DeviceCloudBean>> getDeviceCloudList(String deviceSn, int channelId);

        Observable<BaseBean<EmptyBean>> enableCloudStorage(String deviceSn, int channelId, int packageId);

        Observable<BaseBean<EmptyBean>> unbindCloudStorage(String deviceSn, int channelId, int packageId);


    }

    interface View extends BaseView {
        void getDeviceCloudListSuccess(DeviceCloudBean deviceCloudBean);
        void getDeviceCloudListError(Throwable e);

        void enableCloudStorageSuccess();
        void enableCloudStorageError(Throwable e);

        void unbindCloudStorageSuccess();
        void unbindCloudStorageError(Throwable e);
    }

}
