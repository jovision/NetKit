package com.jovision.netkit.mvp.data;

import android.text.TextUtils;

import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.AddActivateDeviceContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import androidx.annotation.NonNull;


import java.util.TreeMap;

import io.reactivex.Observable;

/**
 * 添加/激活设备页对应Model
 *
 * @author liteng
 * @date 2022/4/12
 */
public class AddActivateDeviceModel implements AddActivateDeviceContract.IModel {

    private ApiService mApiService;

    public AddActivateDeviceModel(ApiService apiService) {
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
    public Observable<BaseBean<EmptyBean>> editDeviceYst(@NonNull String deviceSn,
                                                         String deviceName,
                                                         String deviceUser,
                                                         @NonNull String newDevPwd) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceSn", deviceSn);
        if (!TextUtils.isEmpty(deviceName)) {
            param.put("deviceName", deviceName);
        }
        if (!TextUtils.isEmpty(deviceUser)) {
            param.put("deviceUser", deviceUser);
        }
        param.put("devicePwd", newDevPwd);

        return mApiService.editDeviceYst(ParamUtil.getBody(param));
    }

}
