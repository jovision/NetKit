package com.jovision.netkit.mvp.presenter.contract;



import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceConnectNetBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.UpdateSceneRequestBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceProtocolBean;
import com.jovision.uikit.BaseView;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface AddDeviceContract {

    interface IAddDeviceModel {
        Observable<BaseBean<EmptyBean>> addDevice(String deviceSn, String validateCode, int ct, String deviceUser, String devicePassword, String accessProtocol);

        Observable<BaseBean<DeviceProtocolBean>> getDeviceProtocol(String deviceSn, int type);//1：轮训查询 0：其他查询

        Observable<BaseBean<EmptyBean>> updateScene(UpdateSceneRequestBean updateSceneRequestBean);
        //获取设备当前的WIFI信息-jy
        Observable<BaseBean<DeviceConnectNetBean>> getDeviceWifiInfo(String deviceSn, int channelId, HashMap<String, Object> body);
    }

    interface View extends BaseView {
        void addDeviceSuccess();
        void addDeviceError(Throwable e);


        void getDeviceProtocolSuccess(DeviceProtocolBean deviceProtocolBean);
        void getDeviceProtocolError(Throwable e);


        void updateSceneSuccess();
        void updateSceneError(Throwable e);

        void getDeviceWifiInfoSuccess(DeviceConnectNetBean deviceConnectNetBean);
        void getDeviceWifiInfoError(Throwable e);

    }

}
