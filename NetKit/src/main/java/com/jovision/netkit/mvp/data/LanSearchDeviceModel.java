package com.jovision.netkit.mvp.data;


import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceProtocolBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.LanSearchDeviceContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * 局域网:开始搜索设备页对应Model
 *
 * @author liteng
 * @date 2022/4/12
 */
public class LanSearchDeviceModel implements LanSearchDeviceContract.IModel {

    private ApiService mApiService;

    public LanSearchDeviceModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<EmptyBean>> addDevice(String deviceSn, String validateCode, int ct,
                                                     String deviceUser, String devicePassword,
                                                     String accessProtocol) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);

        if (accessProtocol.equalsIgnoreCase(Constant.PUBLICCLOUD)) {
            if (ct >= 0) {
                param.put("ct", ct);
            }

            if (validateCode.length() > 0) {
                param.put("validateCode", validateCode);
            }

        }

        param.put("deviceUser", deviceUser);
        param.put("devicePassword", devicePassword);
        param.put("accessProtocol", accessProtocol);

        return mApiService.addDevice(ParamUtil.getBody(param));
    }

    @Override
    public Observable<BaseBean<List<DeviceProtocolBean>>> getBatchDeviceProtocol(String[] deviceSns) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSns", deviceSns);
        return mApiService.getBatchDeviceProtocol(ParamUtil.getBody(parma));
    }
}
