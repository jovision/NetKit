package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface LogContract {

    interface ILogModel {
        Observable<BaseBean<EmptyBean>> addLog(String msg);
    }

    interface LogView extends BaseView {
        void logSuccess();
    }

}
