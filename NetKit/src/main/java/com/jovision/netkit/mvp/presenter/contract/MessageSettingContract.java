package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.MessagePushSwitchBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface MessageSettingContract {

    interface IMessageSettingModel {
        Observable<BaseBean<MessagePushSwitchBean>> getPushSwitch();

        Observable<BaseBean<EmptyBean>> setPushSwitch(int alarmSwitch, int userSwitch, int noticeSwitch, int offlineSwitch);

    }

    interface View extends BaseView {
        void getPushSwitchSuccess(MessagePushSwitchBean messagePushSwitchBean);

        void getPushSwitchFailed(Throwable t);

        void setPushSwitchSuccess();

        void setPushSwitchFailed(Throwable t);

    }

}
