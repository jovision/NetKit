package com.jovision.netkit.mvp.presenter.contract;


import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.CallUrlBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 * 废弃，因为库需要对讲使用实况地址
 */
public interface CallContract {

    interface ICallModel {
        Observable<BaseBean<CallUrlBean>> getCallUrl(String deviceSn, int channelId);
    }

    interface View extends BaseView {
        void getCallUrlSuccess(String callUrl);
        void getCallUrlFailed(Throwable t);
    }

}
