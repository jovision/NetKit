package com.jovision.netkit.mvp.presenter.contract;


import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevInfoBean;
import com.jovision.uikit.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface DeviceInfoContract {

    interface IDeviceInfoModel {
        Observable<BaseBean<OctDevInfoBean>> octGetDevHwinfo(String deviceSn, int channelId, String devUser, String devPwd, boolean isAp);
    }

    interface View extends BaseView {
        void octGetDevHwinfoSuccess(OctDevInfoBean octDevInfoBean,String deviceSn, int channelId);
        void octGetDevHwinfoFailed(Throwable e,String deviceSn, int channelId);
    }

}
