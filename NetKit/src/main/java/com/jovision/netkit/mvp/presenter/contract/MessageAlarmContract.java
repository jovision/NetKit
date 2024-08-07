package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.http.MessageCategoryBean;
import com.jovision.uikit.BaseView;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface MessageAlarmContract {

    interface IMessageAlarmModel {
        Observable<BaseBean<MessageCategoryBean>> getMsgCategoryList();

        Observable<BaseBean<EmptyBean>> alarmMsgRead(List<String> alarmCategories, List<Integer> msgIdList);

        Observable<BaseBean<EmptyBean>> alarmMsgClean(List<String> alarmCategories, List<Integer> msgIdList, String deviceSn);
    }

    interface View extends BaseView {

        void getMsgCategoryListSuccess(MessageCategoryBean messageCategoryBean);

        void alarmMsgReadSuccess();

        void alarmMsgCleanSuccess();
    }

}
