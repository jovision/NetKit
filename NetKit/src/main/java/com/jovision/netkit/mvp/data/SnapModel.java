package com.jovision.netkit.mvp.data;

import com.alibaba.fastjson.JSONObject;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.OctTimingSnapBean;
import com.jovision.netkit.mvp.data.bean.response.ResultBean;
import com.jovision.netkit.mvp.data.bean.response.ResultBeanX;
import com.jovision.netkit.mvp.data.bean.response.SnapGetParamBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.data.http.TransCmdHelper;
import com.jovision.netkit.mvp.presenter.contract.SnapContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;

public class SnapModel implements SnapContract.ISnapModel {

    private ApiService mApiService;

    public SnapModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<OctTimingSnapBean.ResultBean>> getTimingSnap(String deviceSn, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "timing_snap_get");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        body.put("param", param);

        parma.put("data", ParamUtil.getMapStr(body));

        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(parma), OctTimingSnapBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setTimingSnap(String deviceSn, int channelId, List<OctTimingSnapBean.ResultBean> resultBean) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "timing_snap_multi_set");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("timing_snaps", resultBean);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(treeMapParam), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<ResultBean>> getSnapFileDateList(String deviceSn, int channelId, int year, int month) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "snap_file_data_list_get");

        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("channelid", channelId);
        JSONObject startObj = new JSONObject();
        startObj.put("year", year);
        startObj.put("month", month);
        startObj.put("day", 1);
        startObj.put("hour", 0);
        startObj.put("min", 0);
        startObj.put("sec", 0);
        param.put("start_time", startObj);
        JSONObject endObj = new JSONObject();
        endObj.put("year", year);
        endObj.put("month", month);
        endObj.put("day", 31);
        endObj.put("hour", 23);
        endObj.put("min", 59);
        endObj.put("sec", 59);
        param.put("end_time", endObj);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(treeMapParam), ResultBean.class);
    }

    @Override
    public Observable<BaseBean<ResultBeanX>> getSnapFileList(String deviceSn, int channelId, int year, int month, int day, int page, int pageSize) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "snap_file_list_get");

        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("channelid", channelId);
        JSONObject startObj = new JSONObject();
        startObj.put("year", year);
        startObj.put("month", month);
        startObj.put("day", day);
        startObj.put("hour", 0);
        startObj.put("min", 0);
        startObj.put("sec", 0);
        param.put("start_time", startObj);
        JSONObject endObj = new JSONObject();
        endObj.put("year", year);
        endObj.put("month", month);
        endObj.put("day", day);
        endObj.put("hour", 23);
        endObj.put("min", 59);
        endObj.put("sec", 59);
        param.put("end_time", endObj);
        param.put("page", page);
        param.put("page_size", pageSize);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(treeMapParam), ResultBeanX.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> getSnapFile(String deviceSn, int channelId, String filePath) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "snap_file_get");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("channelid", channelId);
        param.put("path", filePath);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(treeMapParam), EmptyBean.class);
    }

    @Override
    public Observable<BaseBean<SnapGetParamBean.ResultBean>> getSnapParam(String deviceSn, int channelId) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "snap_get_param");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("channelid", channelId);
        body.put("param", param);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(treeMapParam), SnapGetParamBean.ResultBean.class);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setSnapParam(String deviceSn, int channelId, SnapGetParamBean.ResultBean resultBean) {
        TreeMap<String, Object> treeMapParam = ParamUtil.getParma();
        treeMapParam.put("deviceSn", deviceSn);
        treeMapParam.put("channelId", channelId);

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "snap_set_param");
        resultBean.setChannelid(channelId);
        body.put("param", resultBean);

        treeMapParam.put("data",ParamUtil.getMapStr(body));
        return TransCmdHelper.getInstance().transCmd(mApiService, ParamUtil.getBody(treeMapParam), EmptyBean.class);
    }

}
