package com.jovision.netkit.mvp.data;

import android.os.Build;

import com.jovision.basekit.deviceid.DeviceFlagUtil;
import com.jovision.basekit.utilcode.AppUtils;
import com.jovision.basekit.utilcode.Utils;
import com.jovision.netkit.mvp.CodeConstant;
import com.jovision.netkit.mvp.data.bean.AppVersionResponseBean;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.ACAvatarUploadUrlBean;
import com.jovision.netkit.mvp.data.bean.response.ACUserInfoBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.MyContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

public class MyModel implements MyContract.IMyModel {

    private ApiService apiService;

    public MyModel(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<BaseBean<ACUserInfoBean>> ACGetUserInfo() {
        return apiService.ACGetUserInfo();
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACUpdateNickName(String nickName) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("nickname", nickName);
        return apiService.ACUpdateNickName(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<ACAvatarUploadUrlBean>> ACUploadAvatarUrl(String fileName) {
//        TreeMap<String, Object> map = ParamUtil.getParma();
//        map.put("fileName", fileName);
        return apiService.ACUploadAvatarUrl(fileName);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACUpdateAvatar(String fileName) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("fileName", fileName);
        return apiService.ACUpdateAvatar(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<AppVersionResponseBean>> getAppNewestVersion() {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("versionCode", AppUtils.getAppInfo().getVersionCode());
        map.put("terminalId", DeviceFlagUtil.getUniqueDeviceId(Utils.getApp()));
        map.put("osVersion", Build.VERSION.SDK_INT);
        map.put("osType", CodeConstant.LOGIN_APP_TYPE_ANDROID);
        return apiService.getAppNewestVersion(ParamUtil.getBody(map));

    }
}
