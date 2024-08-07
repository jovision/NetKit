package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.Device4GIccidBean;
import com.jovision.netkit.mvp.data.bean.DeviceBean;
import com.jovision.netkit.mvp.data.bean.DeviceCloudStorageEnableBean;
import com.jovision.netkit.mvp.data.bean.PlayBackUrlForCloudBean;
import com.jovision.netkit.mvp.data.bean.PlayCallBackUrlBean;
import com.jovision.netkit.mvp.data.bean.PlayCallBackVideosBean;
import com.jovision.netkit.mvp.data.bean.PlayRecordDateBean;
import com.jovision.netkit.mvp.data.bean.PublicAlarmTypeBean;
import com.jovision.netkit.mvp.data.bean.response.ShareDetailBean;
import com.jovision.netkit.mvp.data.bean.response.StorageBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.RemotePlayBackContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by deli on 2020/11/6.
 */

public class RemotePlayBackModel implements RemotePlayBackContract.IRemotePlayBackModel {

    private ApiService mApiService;

    public RemotePlayBackModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<PlayCallBackUrlBean>> getPlayBackUrl(String deviceSn, int channelId, String startTime, String endTime) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("startTime", startTime);
        parma.put("endTime", endTime);

        return mApiService.getPlayBackUrl(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<PlayBackUrlForCloudBean>> getPlayBackUrlForCloud(String deviceSn, int channelId, String startTime, String endTime) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("startTime", startTime);
        parma.put("endTime", endTime);
        return mApiService.getPlayBackUrlForCloud(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<PlayCallBackVideosBean>> getVideoList(String url, String deviceSn, int channelId, int pageStart, int pageSize, String startTime, String endTime) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("pageStart", pageStart);
        parma.put("pageSize", pageSize);
        parma.put("startTime", startTime);
        parma.put("endTime", endTime);
        /*parma.put("sortByTime","desc");//降序*/
        return mApiService.getVideoList(url, ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<PlayRecordDateBean>> getVideoDateList(String deviceSn, int channelId, int year, int month) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("year", year);
        parma.put("month", month);
        return mApiService.getVideoDateList(ParamUtil.getBody(parma));
    }




    @Override
    public Observable<BaseBean<DeviceBean>> getDeviceAbility(String deviceNo) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceNo);
        return mApiService.getDeviceDetail(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<DeviceCloudStorageEnableBean>> getDeviceCloudStorageEnable(String deviceNo, int channelId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceNo);
        parma.put("channelId",channelId);
        return mApiService.getDeviceCloudStorageEnable(ParamUtil.getBody(parma));
    }


    @Override
    public Observable<BaseBean<List<StorageBean>>> getStorage(String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        return mApiService.getStorage(ParamUtil.getBody(parma));
    }

    @Override
    public  Observable<BaseBean<ShareDetailBean>> shareDetail(String shareNumber) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("shareNumber", shareNumber);
        return mApiService.shareDetail(ParamUtil.getBody(parma));
    }



    // 轻智能回放接口1,查询当天录像类型：查询一段时间内本地录像类型/v1/udms/device/media/get_alarm_types
    @Override
    public Observable<BaseBean<PublicAlarmTypeBean>> getLocalAlarmTypes(String deviceSn, int channelId, String startTime, String endTime) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("startTime", startTime);
        parma.put("endTime", endTime);
        return mApiService.getLocalAlarmTypes(ParamUtil.getBody(parma));
    }

    // 轻智能回放接口2：查询设备本地录像文件列表-可根据报警类型进行筛选/v1/udms/device/media/get_alarm_record_list
    @Override
    public Observable<BaseBean<PlayCallBackVideosBean>> getLocalAlarmRecordList(String deviceSn, int channelId, int pageStart, int pageSize, String startTime, String endTime, int mergeTimeEnable, String[] alarmTypes) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("pageStart", pageStart);
        parma.put("pageSize", pageSize);
        parma.put("startTime", startTime);
        parma.put("endTime", endTime);
        parma.put("mergeTimeEnable",mergeTimeEnable);
        parma.put("alarmTypes",alarmTypes);
        /*parma.put("sortByTime","desc");//降序*/
        return mApiService.getLocalAlarmRecordList(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<PlayRecordDateBean>> getLocalVideoDateList(String deviceSn, int channelId, int year, int month) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("year", year);
        parma.put("month", month);
        return mApiService.getLocalVideoDateList(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<PlayCallBackVideosBean>> getLocalVideoList(String deviceSn, int channelId, int pageStart, int pageSize, String startTime, String endTime) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("pageStart", pageStart);
        parma.put("pageSize", pageSize);
        parma.put("startTime", startTime);
        parma.put("endTime", endTime);
        /*parma.put("sortByTime","desc");//降序*/
        return mApiService.getLocalVideoList(ParamUtil.getBody(parma));
    }

    // 轻智能回放接口3,查询当天录像类型：查询云端录像类型/v1/udms/device/cloudstorage/get_alarm_types
    @Override
    public Observable<BaseBean<PublicAlarmTypeBean>> getCloudAlarmTypes(String deviceSn, int channelId, String startTime, String endTime) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("startTime", startTime);
        parma.put("endTime", endTime);
        return mApiService.getCloudAlarmTypes(ParamUtil.getBody(parma));
    }

    // 轻智能回放接口4：查询云端录像文件列表-可根据报警类型进行筛选/v1/udms/device/cloudstorage/get_alarm_record_list
    @Override
    public Observable<BaseBean<PlayCallBackVideosBean>> getCloudAlarmRecordList(String deviceSn, int channelId, int pageStart, int pageSize, String startTime, String endTime, String[] alarmTypes) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("pageStart", pageStart);
        parma.put("pageSize", pageSize);
        parma.put("startTime", startTime);
        parma.put("endTime", endTime);
        if(null != alarmTypes){
            parma.put("alarmTypes",alarmTypes);
        }
        /*parma.put("sortByTime","desc");//降序*/
        return mApiService.getCloudAlarmRecordList(ParamUtil.getBody(parma));
    }



    @Override
    public Observable<BaseBean<PlayRecordDateBean>> getCloudVideoDateList( String deviceSn, int channelId, int year, int month) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("year", year);
        parma.put("month", month);
        return mApiService.getCloudVideoDateList(ParamUtil.getBody(parma));
    }






    @Override
    public Observable<BaseBean<PlayCallBackVideosBean>> getCloudVideoList(String deviceSn, int channelId, int pageStart, int pageSize, String startTime, String endTime) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
        parma.put("channelId", channelId);
        parma.put("pageStart", pageStart);
        parma.put("pageSize", pageSize);
        parma.put("startTime", startTime);
        parma.put("endTime", endTime);
        /*parma.put("sortByTime","desc");//降序*/
        return mApiService.getCloudVideoList(ParamUtil.getBody(parma));
    }


    //查询4G卡厂商 -2023.7.20
    @Override
    public Observable<BaseBean<Device4GIccidBean>> get4GDeviceIccid(String deviceSn) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceId",deviceSn);
        return mApiService.get4GDeviceIccid(ParamUtil.getBody(parma));
    }

}
