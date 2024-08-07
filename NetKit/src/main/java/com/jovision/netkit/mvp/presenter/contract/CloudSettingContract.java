package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.CloudStatusBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface CloudSettingContract {

    interface ICloudSettingModel {
        Observable<BaseBean<CloudStatusBean>> getCloudStatus(String deviceSn, int channelId);

        Observable<BaseBean<EmptyBean>> setCloudStatus(String deviceSn, int channelId, int status);
    }

    interface View extends BaseView {
        void getCloudStatusSuccess(CloudStatusBean cloudStatusBean);
        void getCloudStatusError(Throwable throwable);

        void setCloudStatusSuccess();
        void setCloudStatusError(Throwable throwable);

    }

}
