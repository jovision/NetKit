package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * @author liteng
 * @date 2022/4/2
 */
public interface FriendShareDetailContract {

    interface IModel {
        // 修改共享状态
        Observable<BaseBean<EmptyBean>> updateShareStatus(String shareNumber, String shareStatus);

        // 接收二维码分享
        Observable<BaseBean<EmptyBean>> receiveQRCodeShare(String shareToken);
    }

    interface IView extends BaseView {

        void updateShareStatusSuccess();

        void updateShareStatusError(Throwable e);

        void receiveQRCodeShareSuccess();

        void receiveQRCodeShareError(Throwable e);
    }
}
