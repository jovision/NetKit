package com.jovision.netkit.mvp.data;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.OctChnosdParamGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctOsdGetAbilityBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.OctDeviceChnosdParamContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * 云视通2.0协议: OSD设置
 *
 * @author liteng
 * @date 2022/11/28
 */
public class OctDeviceChnosdParamModel implements OctDeviceChnosdParamContract.IModel {

    private ApiService mApiService;

    public OctDeviceChnosdParamModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<OctChnosdParamGetBean>> octGetChnosdParam(String deviceSn,
                                                                         int channelId,
                                                                         String devUser,
                                                                         String devPwd,
                                                                         boolean isDefault) {
        TreeMap<String, Object> parma = OctSetModel.setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("bdefault", isDefault);

        JSONObject dataObj = new JSONObject();
        dataObj.put("method", "chnosd_param_get");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octChnosdParamGet(ParamUtil.getBody(parma))
                .map(new Function<BaseBean<String>, BaseBean<OctChnosdParamGetBean>>() {
                    @Override
                    public BaseBean<OctChnosdParamGetBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                        Gson gson = new Gson();
                        OctChnosdParamGetBean bean = gson.fromJson(stringBaseBean.getData(),
                                new TypeToken<OctChnosdParamGetBean>() {
                                }.getType());

                        BaseBean<OctChnosdParamGetBean> baseBean = new BaseBean<>();
                        baseBean.setCode(stringBaseBean.getCode());
                        baseBean.setMsg(stringBaseBean.getMsg());
                        baseBean.setData(bean);

                        return baseBean;
                    }
                });
    }

    @Override
    public Observable<BaseBean<EmptyBean>> octSetChnosdParam(String deviceSn,
                                                             int channelId,
                                                             String devUser,
                                                             String devPwd,
                                                             OctChnosdParamGetBean.ResultBean paramBean) {
        TreeMap<String, Object> parma = OctSetModel.setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("attr", paramBean);

        JSONObject dataObj = new JSONObject();
        dataObj.put("method", "chnosd_param_set");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octChnosdParamSet(ParamUtil.getBody(parma))
                .map(new Function<BaseBean<String>, BaseBean<EmptyBean>>() {
                    @Override
                    public BaseBean<EmptyBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                        Gson gson = new Gson();
                        EmptyBean bean = gson.fromJson(stringBaseBean.getData(), new TypeToken<EmptyBean>() {
                        }.getType());

                        BaseBean<EmptyBean> baseBean = new BaseBean<>();
                        baseBean.setCode(stringBaseBean.getCode());
                        baseBean.setMsg(stringBaseBean.getMsg());
                        baseBean.setData(bean);

                        return baseBean;
                    }
                });
    }

    @Override
    public Observable<BaseBean<OctOsdGetAbilityBean>> octGetOsdAbility(String deviceSn,
                                                                       int channelId,
                                                                       String devUser,
                                                                       String devPwd) {
        TreeMap<String, Object> parma = OctSetModel.setDeviceInfo(deviceSn);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);

        JSONObject dataObj = new JSONObject();
        dataObj.put("method", "osd_get_ability");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octOsdGetAbility(ParamUtil.getBody(parma))
                .map(new Function<BaseBean<String>, BaseBean<OctOsdGetAbilityBean>>() {
                    @Override
                    public BaseBean<OctOsdGetAbilityBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                        Gson gson = new Gson();
                        OctOsdGetAbilityBean bean = gson.fromJson(stringBaseBean.getData(),
                                new TypeToken<OctOsdGetAbilityBean>() {
                                }.getType());

                        BaseBean<OctOsdGetAbilityBean> baseBean = new BaseBean<>();
                        baseBean.setCode(stringBaseBean.getCode());
                        baseBean.setMsg(stringBaseBean.getMsg());
                        baseBean.setData(bean);

                        return baseBean;
                    }
                });
    }
}
