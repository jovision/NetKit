package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.OctChnosdParamGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctOsdGetAbilityBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.data.http.TransCmdHelper;
import com.jovision.netkit.mvp.presenter.contract.DeviceChnosdParamContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.HashMap;
import java.util.TreeMap;

import io.reactivex.Observable;

/**
 * 公有云协议: OSD设置
 *
 * @author liteng
 * @date 2022/11/28
 */
public class DeviceChnosdParamModel implements DeviceChnosdParamContract.IModel {

    private ApiService mApiService;

    public DeviceChnosdParamModel(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    @Override
    public Observable<BaseBean<OctChnosdParamGetBean.ResultBean>> getChnosdParam(String deviceSn,
                                                                                 int channelId,
                                                                                 HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance()
                .transCmd(mApiService, ParamUtil.getBody(parma), OctChnosdParamGetBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setChnosdParam(String deviceSn,
                                                          int channelId,
                                                          HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance()
                .transCmd(mApiService, ParamUtil.getBody(parma), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<OctOsdGetAbilityBean.ResultBean>> getOsdAbility(String deviceSn,
                                                                               int channelId,
                                                                               HashMap<String, Object> body) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("data", ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance()
                .transCmd(mApiService, ParamUtil.getBody(parma), OctOsdGetAbilityBean.ResultBean.class);
    }
}
