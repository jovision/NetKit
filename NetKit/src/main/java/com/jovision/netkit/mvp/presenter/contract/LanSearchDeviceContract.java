package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceProtocolBean;
import com.jovision.uikit.BaseView;

import java.util.List;

import io.reactivex.Observable;

/**
 * 局域网:开始搜索设备页对应Contract
 *
 * @author liteng
 * @date 2022/4/12
 */
public interface LanSearchDeviceContract {

    interface IModel {

        // 绑定(添加)设备
        Observable<BaseBean<EmptyBean>> addDevice(String deviceSn, String validateCode, int ct,
                                                  String deviceUser, String devicePassword,
                                                  String accessProtocol);

        // 批量查询设备接入类型
        Observable<BaseBean<List<DeviceProtocolBean>>> getBatchDeviceProtocol(String[] deviceSns);

    }

    interface IView extends BaseView {

        void addDeviceSuccess();

        void addDeviceError(Throwable t);

        void getBatchDeviceProtocolSuccess(List<DeviceProtocolBean> deviceProtocolBeanList);

        void getBatchDeviceProtocolError(Throwable t);
    }
}
