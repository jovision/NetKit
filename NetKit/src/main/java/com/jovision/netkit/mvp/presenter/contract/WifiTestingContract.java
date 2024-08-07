package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DownloadUrlBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

public interface WifiTestingContract {

    interface IModel {
        Observable<BaseBean<DownloadUrlBean>> getDownloadUrl();
    }

    interface View extends BaseView {
        void getDownloadUrlSuccess(DownloadUrlBean data);
        void getDownloadUrlError(Throwable e);
    }

}
