package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceListResponseBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * @ProjectName: E-commerce
 * @Package: com.jovisionapp.jovision.presenter.contract
 * @ClassName: HomeContract
 * @Description: java类作用描述
 * @CreateDate: 2024/5/13 16:44
 * @Version: 1.0
 */
public class DeviceListContract {

    public interface IHomeModel{
        Observable<BaseBean<DeviceListResponseBean>> deviceList();
    }

    public interface View extends BaseView {
        void deviceListSuccess(DeviceListResponseBean deviceListResponseBean);
        void deviceListError(Throwable e);
    }
}
