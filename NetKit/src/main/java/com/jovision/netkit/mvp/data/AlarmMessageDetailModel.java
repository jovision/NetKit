package com.jovision.netkit.mvp.data;

import android.text.TextUtils;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceCloudStorageEnableBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.MessageAlarmListBean;
import com.jovision.netkit.mvp.data.bean.MessageAlarmListDetailBean;
import com.jovision.netkit.mvp.data.bean.PlayBackUrlForCloudBean;
import com.jovision.netkit.mvp.data.bean.PlayBackUrlForGunBallCloudBean;
import com.jovision.netkit.mvp.data.bean.PlayBackUrlForGunBallLocalBean;
import com.jovision.netkit.mvp.data.bean.PlayBackUrlForLocalBean;
import com.jovision.netkit.mvp.data.bean.PlayRecordDateBean;
import com.jovision.netkit.mvp.data.bean.request.AlarmMessageRequestBean;
import com.jovision.netkit.mvp.data.bean.response.StorageBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.AlarmMessageDetailContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/12/9
 * 描述：
 */
public class AlarmMessageDetailModel implements AlarmMessageDetailContract.IAlarmMessageDetailModel {


    private ApiService mApiService;

    public AlarmMessageDetailModel(ApiService apiService) {
        this.mApiService = apiService;
    }


    @Override
    public Observable<BaseBean<MessageAlarmListBean>> getAlarmMsgList(AlarmMessageRequestBean bean) {

        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("alarmCategories",bean.getAlarmCategories());
        parma.put("devices",bean.getDevices());
        parma.put("alarmDate",bean.getAlarmDate());
        if(!TextUtils.isEmpty(bean.getPageStartAlarmTime())){
            parma.put("pageStartAlarmTime",bean.getPageStartAlarmTime());
        }
        if(bean.getPageStartId() != -1){
            parma.put("pageStartId",bean.getPageStartId());
        }

        parma.put("pageSize",bean.getPageSize());
        if(!TextUtils.isEmpty(bean.getPageStartAlarmUuid())){
            parma.put("pageStartAlarmUuid",bean.getPageStartAlarmUuid());
        }


        return mApiService.alarmMsgList(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<PlayRecordDateBean>> getCalendarMark(String deviceSn, String alarmCategories, String yearMonth) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn",deviceSn);
        parma.put("alarmCategories",alarmCategories);
        parma.put("yearMonth",yearMonth);
        return mApiService.getCalendarMark(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<PlayBackUrlForCloudBean>> getCloudPlayUrl(String deviceSn, int channelId, String videoId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn",deviceSn);
        parma.put("channelId",channelId);
        parma.put("alarmUuid",videoId);

        return mApiService.getCloudPlayUrl(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> alarmMsgClean(List<String> alarmCategories, List<Integer> msgIdList, String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        if (null != alarmCategories && alarmCategories.size() != 0) {
            parma.put("alarmCategories", alarmCategories);
        }
        if (null != msgIdList && msgIdList.size() != 0) {
            parma.put("msgIdList", msgIdList);
        }
//        if (!StringUtil.isEmpty(deviceSn)) {
//            parma.put("deviceSn", deviceSn);
//        }

        return mApiService.alarmMsgClean(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<DeviceCloudStorageEnableBean>> getDeviceCloudStorageEnable(String deviceNo, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn",deviceNo);
        parma.put("channelId",channelId);
        return mApiService.getDeviceCloudStorageEnable(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<PlayBackUrlForLocalBean>> getLocalPlayUrl(String deviceSn, int channelId, String videoId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn",deviceSn);
        parma.put("channelId",channelId);
        parma.put("alarmUuid",videoId);
        return mApiService.getLocalPlayUrl(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<PlayBackUrlForGunBallLocalBean>> getGunBallLocalPlayUrl(String deviceSn, int channelId, String videoId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn",deviceSn);
        parma.put("channelId",channelId);
        parma.put("alarmUuid",videoId);
        return mApiService.getGunBallLocalPlayUrl(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<PlayBackUrlForGunBallCloudBean>> getGunBallCloudPlayUrl(String deviceSn, int channelId, String videoId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn",deviceSn);
        parma.put("channelId",channelId);
        parma.put("alarmUuid",videoId);
        return mApiService.getGunBallCloudPlayUrl(ParamUtil.getBody(parma));
    }


    @Override
    public Observable<BaseBean<List<StorageBean>>> getStorage(String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        return mApiService.getStorage(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> alarmMsgRead(List<String> alarmCategories, List<Integer> msgIdList) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        if (null != alarmCategories && alarmCategories.size() != 0) {
            parma.put("alarmCategories", alarmCategories);
        }
        if (null != msgIdList && msgIdList.size() != 0) {
            parma.put("msgIdList", msgIdList);
        }
        return mApiService.alarmMsgRead(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<MessageAlarmListDetailBean>> getAlarmInfo(String alarmUuid) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("alarmUuid",alarmUuid);
        return mApiService.getAlarmInfo(ParamUtil.getBody(parma));
    }


}
