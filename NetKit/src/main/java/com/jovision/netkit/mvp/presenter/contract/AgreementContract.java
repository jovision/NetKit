package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.AgreementBean;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.QuestionLinkBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface AgreementContract {

    interface IAgreementModel {
        Observable<BaseBean<AgreementBean>> getEnableLink();
        Observable<BaseBean<QuestionLinkBean>> questionLink();
    }

    interface View extends BaseView {
        void getEnableLinkSuccess(AgreementBean agreementBean);
        void getEnableLinkError(Throwable e);
        void questionLinkSuccess(QuestionLinkBean questionLinkBean);
        void questionLinkError(Throwable e);
    }

}
