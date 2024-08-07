package com.jovision.netkit.mvp.presenter.contract;


import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceMessageBean;
import com.jovision.netkit.mvp.data.bean.MessageAlarmListBean;
import com.jovision.uikit.BaseView;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface AlarmListContract {

    interface IAlarmListModel {
        Observable<BaseBean<MessageAlarmListBean>> alarmMsgList(List<String> alarmCategories, List<DeviceMessageBean> devices, String alarmDate, String pageStartAlarmTime, int pageStartId, int pageSize);
    }

    interface View extends BaseView {
        void alarmMsgListSuccess(MessageAlarmListBean messageAlarmListBean);
        void alarmMsgListError(Throwable e);
    }

}
