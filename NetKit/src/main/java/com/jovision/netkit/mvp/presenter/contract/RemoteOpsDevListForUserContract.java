package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.RemoteOpsBean;
import com.jovision.netkit.mvp.data.bean.response.RemoteOpsDeviceBean;
import com.jovision.netkit.mvp.data.bean.response.RemoteOpsDeviceResponseBean;
import com.jovision.uikit.BaseView;

import java.util.List;

import io.reactivex.Observable;

/**
 * 远程运维-用户侧设备列表页对应Contract
 *
 * @author liteng
 * @date 2022/6/20
 */
public interface RemoteOpsDevListForUserContract {

    interface IModel {

        // 获取可远程运维设备列表
        Observable<BaseBean<RemoteOpsDeviceResponseBean>> getRemoteOpsDevListForUser();

        // 发起远程运维申请
        Observable<BaseBean<RemoteOpsBean>> applyRemoteOpsDev(List<RemoteOpsDeviceBean> deviceList);

    }

    interface IView extends BaseView {

        void getRemoteOpsDevListForUserSuccess(RemoteOpsDeviceResponseBean responseBean);

        void getRemoteOpsDevListForUserError(Throwable t);

        void applyRemoteOpsDevSuccess(RemoteOpsBean remoteOpsBean);

        void applyRemoteOpsDevError(Throwable t);
    }
}
