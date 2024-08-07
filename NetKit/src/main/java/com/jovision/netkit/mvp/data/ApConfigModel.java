package com.jovision.netkit.mvp.data;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jovision.netkit.mvp.JVCloudConst;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.GetUserResponseDataBean;
import com.jovision.netkit.mvp.data.bean.response.ErrorBean2;
import com.jovision.netkit.mvp.data.bean.response.OctAccountModifyUserBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.ApConfigContract;
import com.jovision.netkit.mvp.util.ParamUtil;


import java.util.TreeMap;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class ApConfigModel implements ApConfigContract.IApConfigModel {

    private ApiService mApiService;

    public ApConfigModel(ApiService apiService) {
        this.mApiService = apiService;
    }


    @Override
    public Observable<BaseBean<ErrorBean2>> octApConfig(String deviceSn, String devUser, String devPwd, String wifiName, String wifiPwd) {

        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
        parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("name", wifiName);
        paramObj.put("passwd", wifiPwd);


        dataObj.put("method", "ifconfig_wifi_apconfig");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octApConfig(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<ErrorBean2>>() {
            @Override
            public BaseBean<ErrorBean2> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                ErrorBean2 errorBean2 = gson.fromJson(stringBaseBean.getData(), new TypeToken<ErrorBean2>() {
                }.getType());


                BaseBean<ErrorBean2> octErrorBean2 = new BaseBean<>();
                octErrorBean2.setCode(stringBaseBean.getCode());
                octErrorBean2.setMsg(stringBaseBean.getMsg());
                octErrorBean2.setData(errorBean2);

                return octErrorBean2;
            }
        });
    }




    @Override
    public Observable<BaseBean<GetUserResponseDataBean>> octAccountGetUser(String pwd) {

        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
        parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        parma.put("user", JVCloudConst.STR_ADMIN);
        parma.put("password", pwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        dataObj.put("method", "account_get_users");
        dataObj.put("level", "Administrator");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());

        return mApiService.octAccountGetUser(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<GetUserResponseDataBean>>() {
            @Override
            public BaseBean<GetUserResponseDataBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                GetUserResponseDataBean getUserResponseDataBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<GetUserResponseDataBean>() {
                }.getType());

                BaseBean<GetUserResponseDataBean> octResultBean = new BaseBean<>();
                octResultBean.setCode(stringBaseBean.getCode());
                octResultBean.setMsg(stringBaseBean.getMsg());
                octResultBean.setData(getUserResponseDataBean);

                return octResultBean;
            }
        });
    }




    //2 修改设备密码-云视通2.0
    @Override
    public Observable<BaseBean<OctAccountModifyUserBean>> octAccountModifyUser(String deviceSn, int channelId, String devUser, String devPwd, String newDevUser, String newDevPwd) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("ip", JVCloudConst.STR_AP_DEFAULT_IP);
        parma.put("port", JVCloudConst.STR_AP_DEFAULT_PORT);
        parma.put("user", devUser);
        parma.put("password", devPwd);
        parma.put("protocol", "CLOUDSEE2");


        JSONObject dataObj = new JSONObject();

        JSONObject paramObj = new JSONObject();
        paramObj.put("channelid", channelId);
        paramObj.put("name", devUser);
        paramObj.put("old_passwd", devPwd);
        paramObj.put("passwd", newDevPwd);
        paramObj.put("level", JVCloudConst.STR_ADMIN);
        paramObj.put("description", "This is Adiministrator");


        dataObj.put("method", "account_modify_user");
        dataObj.put("level", "Administrator");
        dataObj.put("param", paramObj);

        parma.put("data", dataObj.toJSONString());


        return mApiService.octAccountModifyUser(ParamUtil.getBody(parma)).map(new Function<BaseBean<String>, BaseBean<OctAccountModifyUserBean>>() {
            @Override
            public BaseBean<OctAccountModifyUserBean> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                OctAccountModifyUserBean octAccountModifyUserBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<OctAccountModifyUserBean>() {
                }.getType());

                BaseBean<OctAccountModifyUserBean> octAccountModifyUserBaseBean = new BaseBean<>();
                octAccountModifyUserBaseBean.setCode(stringBaseBean.getCode());
                octAccountModifyUserBaseBean.setMsg(stringBaseBean.getMsg());
                octAccountModifyUserBaseBean.setData(octAccountModifyUserBean);

                return octAccountModifyUserBaseBean;
            }
        });
    }

}
