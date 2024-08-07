package com.jovision.netkit.mvp.presenter.contract;
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
import com.jovision.uikit.BaseView;

import java.util.List;

import io.reactivex.Observable;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/11/12
 * 描述：
 */
public interface RemotePlayBackContract {


    interface IRemotePlayBackModel {
        Observable<BaseBean<PlayCallBackUrlBean>> getPlayBackUrl(String deviceSn, int channelId, String startTime, String endTime);
        Observable<BaseBean<PlayBackUrlForCloudBean>> getPlayBackUrlForCloud(String deviceSn, int channelId, String startTime, String endTime);

        Observable<BaseBean<PlayCallBackVideosBean>> getVideoList(String url, String deviceSn, int channelId, int pageStart, int pageSize, String startTime, String endTime);

        Observable<BaseBean<PlayRecordDateBean>> getVideoDateList(String deviceSn, int channelId, int year, int month);

        Observable<BaseBean<DeviceBean>> getDeviceAbility(String deviceNo);

        Observable<BaseBean<DeviceCloudStorageEnableBean>> getDeviceCloudStorageEnable(String deviceNo, int channelId);


        Observable<BaseBean<List<StorageBean>>> getStorage(String deviceSn);

        Observable<BaseBean<ShareDetailBean>>  shareDetail(String shareNumber);





        // 轻智能回放接口1,查询当天录像类型：查询一段时间内本地录像类型/v1/udms/device/media/get_alarm_types
        Observable<BaseBean<PublicAlarmTypeBean>> getLocalAlarmTypes(String deviceSn, int channelId, String startTime, String endTime);

        // 轻智能回放接口2：查询设备本地录像文件列表-可根据报警类型进行筛选/v1/udms/device/media/get_alarm_record_list
        Observable<BaseBean<PlayCallBackVideosBean>> getLocalAlarmRecordList(String deviceSn, int channelId, int pageStart, int pageSize, String startTime, String endTime,int mergeTimeEnable,String[] alarmTypes);

        Observable<BaseBean<PlayRecordDateBean>> getLocalVideoDateList(String deviceSn, int channelId, int year, int month);

        Observable<BaseBean<PlayCallBackVideosBean>> getLocalVideoList(String deviceSn, int channelId, int pageStart, int pageSize, String startTime, String endTime);

        // 轻智能回放接口3,查询当天录像类型：查询云端录像类型/v1/udms/device/cloudstorage/get_alarm_types
        Observable<BaseBean<PublicAlarmTypeBean>> getCloudAlarmTypes(String deviceSn, int channelId, String startTime, String endTime);

        // 轻智能回放接口4：查询云端录像文件列表-可根据报警类型进行筛选/v1/udms/device/cloudstorage/get_alarm_record_list
        Observable<BaseBean<PlayCallBackVideosBean>> getCloudAlarmRecordList(String deviceSn, int channelId, int pageStart, int pageSize, String startTime, String endTime,String[] alarmTypes);


        Observable<BaseBean<PlayRecordDateBean>> getCloudVideoDateList(String deviceSn, int channelId, int year, int month);

        Observable<BaseBean<PlayCallBackVideosBean>> getCloudVideoList(String deviceSn, int channelId, int pageStart, int pageSize, String startTime, String endTime);


        //查询4G卡厂商 -2023.7.20
        Observable<BaseBean<Device4GIccidBean>> get4GDeviceIccid(String deviceSn);

    }

    interface View extends BaseView {

        void getPlayBackUrlSuccess(String url, int channelId);
        void getPlayBackUrlError(Throwable throwable, int channelId);

        void getLocalDownloadUrlSuccess(String url, int channelId, String startTime, String endTime);
        void getLocalDownloadUrlError(Throwable throwable, int channelId, String startTime, String endTime);

        void getCloudDownloadUrlSuccess(String url, int channelId, String startTime, String endTime);
        void getCloudDownloadUrlError(Throwable throwable, int channelId, String startTime, String endTime);


        void getPlayBackUrlForCLoudSuccess(PlayBackUrlForCloudBean urlForCloudBean,int channelId);

        void getVideoListSuccess(PlayCallBackVideosBean bean,int channelId);
        void getVideoListError(Throwable e,int channelId);

        void getVideoDateListSuccess(PlayRecordDateBean bean, int channelId);
        void getVideoDateListError(Throwable e, int channelId);

        void getDeviceAbilitySuccess(DeviceBean bean);
        void getDeviceAbilityError(Throwable e);

        void getDeviceCloudStorageEnableSuccess(DeviceCloudStorageEnableBean bean);
        void getDeviceCloudStorageEnableError(Throwable throwable);


        void getStorageSuccess(List<StorageBean> storageBeans);
        void getStorageError(Throwable e);

        void shareDetailSuccess(ShareDetailBean shareDetailBean);

        void shareDetailError(Throwable e);


        void getLocalAlarmTypesSuccess(PublicAlarmTypeBean bean);
        void getLocalAlarmTypesError(Throwable e);

        void getLocalAlarmRecordListSuccess(PlayCallBackVideosBean bean);
        void getLocalAlarmRecordListError(Throwable e);

        void getCloudAlarmTypesSuccess(PublicAlarmTypeBean bean);
        void getCloudAlarmTypesError(Throwable e);

        void getCloudAlarmRecordListSuccess(PlayCallBackVideosBean bean);
        void getCloudAlarmRecordListError(Throwable e);

        void get4GDeviceIccidSuccess(Device4GIccidBean device4GIccidBean,String iccid);
        void get4GDeviceIccidError(Throwable e,String iccid);

    }

}
