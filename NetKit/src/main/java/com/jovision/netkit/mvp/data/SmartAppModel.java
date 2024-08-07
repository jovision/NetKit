package com.jovision.netkit.mvp.data;

import android.util.Log;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.PackageExpireBean;
import com.jovision.netkit.mvp.data.bean.response.PkgGiftRemindBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAppBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAppStatus;
import com.jovision.netkit.mvp.data.bean.response.SmartAppStatusBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.SmartAppContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;

/**
 * @ProjectName: SAAS
 * @Package: com.jovision.saas.data
 * @ClassName: SmartAppModel
 * @Description: java类作用描述
 * @CreateDate: 2024/3/20 14:40
 * @Version: 1.0
 */
public class SmartAppModel implements SmartAppContract.ISmartAppModel {

    private ApiService mApiService;

    public SmartAppModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<List<SmartAppBean>>> getSmartApp(String model, String type, String firmVer) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("model", model);
        parma.put("type", type);
        Log.d("get_app_list", "fireware :"+firmVer);
        parma.put("firmVer", firmVer);
        return mApiService.getSmartApp(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<List<SmartAppStatusBean>>> getSmartAppStatus(String deviceSn, int channelId, String[] algorithmSign) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("algorithmSigns", algorithmSign);
        return mApiService.getSmartAppStatus(ParamUtil.getBody(parma));
    }

    public Observable<BaseBean<PkgGiftRemindBean>> getGiftReminds(String deviceSn, int channelId, String[] pkgTypes) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceId", deviceSn);
        parma.put("channelId", channelId);
        parma.put("packageTypes", pkgTypes);
        return mApiService.getGiftReminds(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<SmartAppStatus>> getSmartStatus(String deviceSn, int channelId, String[] pkgTypes) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceId", deviceSn);
        parma.put("channelId", channelId);
        parma.put("packageTypes", pkgTypes);
        return mApiService.getSmartStatus(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<PackageExpireBean>> packageBind(String deviceId, String extend) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceId", deviceId);
        parma.put("extend", extend);
        return mApiService.packageBind(ParamUtil.getBody(parma));
    }
}
