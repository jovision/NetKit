package com.jovision.netkit.mvp.presenter.contract;


import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.CloudPayInfoBean;
import com.jovision.netkit.mvp.data.bean.CloudStorageGroupBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface CloudListContract {

    interface ICloudListModel {
        Observable<BaseBean<CloudStorageGroupBean>> getCloudList();

        Observable<BaseBean<CloudPayInfoBean>> getCloudPayInfo(String deviceSn, int channelId, String tenantStorageId, String amount, String paymentType);

        Observable<BaseBean<CloudPayInfoBean>> getCloudPaySignInfo(String deviceSn, int channelId, String tenantStorageId);
    }

    interface View extends BaseView {
        void getCloudListSuccess(CloudStorageGroupBean cloudStorageGroupBean);

        void getCloudPayInfoSuccess(CloudPayInfoBean cloudPayInfoBean);
        void getCloudPayInfoError(Throwable throwable);

    }

}
