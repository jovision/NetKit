package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.Device4GIccidBean;
import com.jovision.netkit.mvp.data.bean.DeviceBean;
import com.jovision.netkit.mvp.data.bean.DeviceListResponseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.PlayRecordDateBean;
import com.jovision.netkit.mvp.data.bean.SceneInfoBean;
import com.jovision.netkit.mvp.data.bean.request.CreateSceneRequestBean;
import com.jovision.netkit.mvp.data.bean.request.OrderScenesRequestBean;
import com.jovision.netkit.mvp.data.bean.request.UpdateSceneRequestBean;
import com.jovision.netkit.mvp.data.bean.response.AlarmStatusBean;
import com.jovision.netkit.mvp.data.bean.response.ChannelBadgesBean;
import com.jovision.netkit.mvp.data.bean.response.EnableBean;
import com.jovision.netkit.mvp.data.bean.response.ShareToMeBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.SceneListContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;

public class SceneListModel implements SceneListContract.ISceneListModel {
    private ApiService mApiService;

    public SceneListModel(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    @Override
    public Observable<BaseBean<List<SceneInfoBean>>> sceneList() {
        return mApiService.sceneList();
    }

    @Override
    public Observable<BaseBean<DeviceListResponseBean>> deviceList() {

        return mApiService.getDevices();
    }

    @Override
    public Observable<BaseBean<DeviceBean>> getDeviceDetail(String deviceSn) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("deviceSn", deviceSn);
        return mApiService.getDeviceDetail(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> createScene(CreateSceneRequestBean createSceneRequestBean) {
        return mApiService.createScene(createSceneRequestBean);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> orderScene(OrderScenesRequestBean orderScenesRequestBean) {
        return mApiService.orderScene(orderScenesRequestBean);
    }

    @Override
    public Observable<BaseBean<EmptyBean>> deleteScene(String sceneId) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("sceneId", sceneId);
        return mApiService.deleteScene(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<DeviceListResponseBean>> sceneChannels(String sceneId) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("sceneId", sceneId);
        return mApiService.sceneChannels(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> updateScene(UpdateSceneRequestBean updateSceneRequestBean) {
        return mApiService.updateScene(updateSceneRequestBean);
    }

    @Override
    public Observable<BaseBean<List<ShareToMeBean>>> shareToMe(String deviceSn) {//,String channelId
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
//        parma.put("channelId", channelId);
        return mApiService.shareToMe(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> updateShareStatus(String shareNumber, String shareStatus) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("shareNumber", shareNumber);
        parma.put("shareStatus", shareStatus);
        return mApiService.updateShareStatus(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EnableBean>> getHideStatus(String deviceSn, int channelId) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("deviceSn", deviceSn);
        map.put("channelId", channelId);
        return mApiService.getHideStatus(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setHideStatus(String deviceSn, int channelId, boolean enable) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("deviceSn", deviceSn);
        map.put("channelId", channelId);
        map.put("enable", enable);
        return mApiService.setHideStatus(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<ChannelBadgesBean>> getChannelBadges(String deviceSn, int channelId) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("deviceSn", deviceSn);
        map.put("channelId", channelId);
        return mApiService.getChannelBadges(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<PlayRecordDateBean>> getCalendarMark(String deviceSn, String alarmCategories, String yearMonth) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn",deviceSn);
        parma.put("alarmCategories",alarmCategories);
        parma.put("yearMonth",yearMonth);
        return mApiService.getCalendarMark(ParamUtil.getBody(parma));
    }

    //查询4G卡厂商 -2023.7.20
    @Override
    public Observable<BaseBean<Device4GIccidBean>> get4GDeviceIccid(String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceId",deviceSn);
        return mApiService.get4GDeviceIccid(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<AlarmStatusBean>> getAlarmStatus(String deviceSn, int channelId) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("deviceId", deviceSn);
        map.put("channelId", channelId);
        return mApiService.getAlarmStatus(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> cancelAlarmStatus(String deviceSn, int channelId) {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("deviceId", deviceSn);
        map.put("channelId", channelId);
        return mApiService.cancelAlarmStatus(ParamUtil.getBody(map));
    }
}
