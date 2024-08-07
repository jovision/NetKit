package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.ServiceListBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

public interface ServiceContract {

    interface IServiceModel {
        Observable<BaseBean<ServiceListBean>> getServiceList(String appType);
        Observable<BaseBean<ServiceListBean>> getServiceListNew(String appType);
    }

    interface View extends BaseView {
        void getServiceListSuccess(ServiceListBean data);
        void getServiceListError(Throwable e);
        void getServiceListNewSuccess(ServiceListBean data);
        void getServiceListNewError(Throwable e);
    }

}
