package com.jovision.netkit.mvp.presenter;


import com.jovision.netkit.mvp.presenter.contract.LogContract;

import javax.inject.Inject;

/**
 * Created by ZHP on 2017/7/19.
 */

public class LogPresenter extends BasePresenter<LogContract.ILogModel, LogContract.LogView> {

    @Inject
    public LogPresenter(LogContract.ILogModel iLoginModel, LogContract.LogView view) {
        super(iLoginModel, view);
    }

    public void addLog(String message) {
        /*mModel.addLog(message).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.logSuccess();
                        }
                    }
                });*/
    }
}
