package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.MessagePushSwitchBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.MessageSettingContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class MessageSettingModel implements MessageSettingContract.IMessageSettingModel {

    private ApiService mApiService;

    public MessageSettingModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<MessagePushSwitchBean>> getPushSwitch() {
        return mApiService.getPushSwitch();
    }

    @Override
    public Observable<BaseBean<EmptyBean>> setPushSwitch(int alarmSwitch, int userSwitch, int noticeSwitch, int offlineSwitch) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("alarmSwitch", alarmSwitch);
        parma.put("userSwitch", userSwitch);
        parma.put("noticeSwitch", noticeSwitch);
        parma.put("offlineSwitch",offlineSwitch);
        return mApiService.setPushSwitch(ParamUtil.getBody(parma));
    }
}
