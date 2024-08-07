package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.MessageBadgesBean;
import com.jovision.netkit.mvp.data.bean.response.UnreadCountBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface MainMessageContract {

    interface IMainMessageModel {
        Observable<BaseBean<MessageBadgesBean>> getMsgBadges();
        Observable<BaseBean<UnreadCountBean>> getUnreadStatus();
    }

    interface View extends BaseView {
        void getMsgBadgesSuccess(MessageBadgesBean messageBadgesBean);

        void getUnreadStatusSuccess(UnreadCountBean unreadCountBean);

        void getUnreadStatusError(Throwable t);
    }

}
