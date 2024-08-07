package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface SetDeviceNameContract {

    interface ISetDeviceNameModel {
        Observable<BaseBean<EmptyBean>> setDeviceName(String deviceSn, String deviceName, String accessProtocol);
    }

    interface View extends BaseView {
        void setDeviceNameSuccess();

        void setDeviceNameError(Throwable e);
    }

}
