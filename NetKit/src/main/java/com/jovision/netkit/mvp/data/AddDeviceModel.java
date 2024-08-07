package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceConnectNetBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.UpdateSceneRequestBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceProtocolBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.data.http.TransCmdHelper;
import com.jovision.netkit.mvp.presenter.contract.AddDeviceContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.HashMap;
import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class AddDeviceModel implements AddDeviceContract.IAddDeviceModel {

    private ApiService mApiService;

    public AddDeviceModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<EmptyBean>> addDevice(String deviceSn, String validateCode, int ct,
                                                     String deviceUser, String devicePassword, String accessProtocol) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);


        if(accessProtocol.equalsIgnoreCase(Constant.PUBLICCLOUD)){
            if(ct >= 0){
                param.put("ct", ct);
            }

            if(validateCode.length() > 0){
                param.put("validateCode", validateCode);
            }

        }

        param.put("deviceUser", deviceUser);
        param.put("devicePassword", devicePassword);
        param.put("accessProtocol", accessProtocol);

        return mApiService.addDevice(ParamUtil.getBody(param));
    }

    @Override
    public Observable<BaseBean<DeviceProtocolBean>> getDeviceProtocol(String deviceSn, int type) {//1：轮训查询 0：其他查询
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);
        param.put("type",type);
        return mApiService.getDeviceProtocol(ParamUtil.getBody(param));
    }


    @Override
    public Observable<BaseBean<EmptyBean>> updateScene(UpdateSceneRequestBean updateSceneRequestBean) {
        return mApiService.updateScene(updateSceneRequestBean);
    }


    @Override
    public Observable<BaseBean<DeviceConnectNetBean>> getDeviceWifiInfo(String deviceSn, int channelId, HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data",ParamUtil.getMapStr(body));
//        return mApiService.getDeviceWifiInfo(ParamUtil.getBody(parma));
        return TransCmdHelper.getInstance().transCmd(mApiService,ParamUtil.getBody(parma),DeviceConnectNetBean.class);

    }

}
