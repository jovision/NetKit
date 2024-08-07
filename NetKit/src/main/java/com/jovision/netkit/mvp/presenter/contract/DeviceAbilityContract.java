package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceBean;
import com.jovision.netkit.mvp.data.bean.response.SnapShotBean;
import com.jovision.uikit.BaseView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface DeviceAbilityContract {

    interface IDeviceAbilityModel {

        Observable<BaseBean<DeviceBean>> deviceDetail(String deviceSn);

        Observable<BaseBean<SnapShotBean>> snapshot(String deviceSn, int channelId);

    }

    interface View extends BaseView {
        void deviceDetailSuccess(DeviceBean deviceBean);

        void snapshotSuccess(SnapShotBean snapShotBean);
    }

}
