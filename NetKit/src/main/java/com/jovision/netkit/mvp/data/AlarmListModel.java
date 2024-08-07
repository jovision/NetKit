package com.jovision.netkit.mvp.data;

import android.text.TextUtils;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceMessageBean;
import com.jovision.netkit.mvp.data.bean.MessageAlarmListBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.AlarmListContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class AlarmListModel implements AlarmListContract.IAlarmListModel {

    private ApiService mApiService;

    public AlarmListModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<MessageAlarmListBean>> alarmMsgList(List<String> alarmCategories, List<DeviceMessageBean> devices, String alarmDate, String pageStartAlarmTime, int pageStartId, int pageSize) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("alarmCategories", alarmCategories);
        if (null != devices && devices.size() > 0) {
            parma.put("devices", devices);
        }
//        parma.put("channelId", channelId);
        if (TextUtils.isEmpty(alarmDate)) {
            parma.put("alarmDate", alarmDate);
        }
        parma.put("pageStartAlarmTime", pageStartAlarmTime);
        if (pageStartId != 0) {
            parma.put("pageStartId", pageStartId);
        }
        parma.put("pageSize", pageSize);
        return mApiService.alarmMsgList(ParamUtil.getBody(parma));
    }
}
