package com.jovision.netkit.mvp.data;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jovision.basekit.LogUtil;
import com.jovision.netkit.mvp.JVCloudConst;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevInfoBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.DeviceInfoContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class DeviceInfoModel implements DeviceInfoContract.IDeviceInfoModel {

    private ApiService mApiService;

    public DeviceInfoModel(ApiService apiService) {
        this.mApiService = apiService;
    }


    @Override
    public Observable<BaseBean<OctDevInfoBean>> octGetDevHwinfo(String deviceSn, int channelId, String devUser, String devPwd, boolean isAp) {
        TreeMap<String, Object> parma = ParamUtil.getParma();

        if(isAp){
            parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
            parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        } else {
            parma.put("sn", deviceSn);
        }

        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");

        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);

        dataObj.put("method", "dev_get_hwinfo");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        LogUtil.v("dev_get_hwinfo-deviceInfoModel",parma.toString());
        return mApiService.octGetDevHwinfo(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctDevInfoBean>>() {
            @Override
            public BaseBean<OctDevInfoBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctDevInfoBean octDevInfoBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctDevInfoBean>(){}.getType());

                BaseBean<OctDevInfoBean> octDevInfoBeanBaseBean = new BaseBean<>();
                octDevInfoBeanBaseBean.setCode(stringBaseBean.getCode());
                octDevInfoBeanBaseBean.setMsg(stringBaseBean.getMsg());
                octDevInfoBeanBaseBean.setData(octDevInfoBean);

                return octDevInfoBeanBaseBean;
            }
        });

    }

}
