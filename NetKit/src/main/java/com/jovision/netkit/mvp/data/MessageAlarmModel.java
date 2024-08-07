package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.data.http.MessageCategoryBean;
import com.jovision.netkit.mvp.presenter.contract.MessageAlarmContract;
import com.jovision.netkit.mvp.util.ParamUtil;


import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class MessageAlarmModel implements MessageAlarmContract.IMessageAlarmModel {

    private ApiService mApiService;

    public MessageAlarmModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<MessageCategoryBean>> getMsgCategoryList() {
        return mApiService.getMsgCategoryList();
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



}
