package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.TerminalListBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.TerminalManageContract;

import javax.inject.Inject;
/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/12/08
 * 描述：
 */

public class TerminalManagePresenter extends BasePresenter<TerminalManageContract.ITerminalManageModel, TerminalManageContract.View> {

    @Inject
    public TerminalManagePresenter(TerminalManageContract.ITerminalManageModel iTerminalManageModel, TerminalManageContract.View view) {
        super(iTerminalManageModel, view);
    }


    public void getTerminalList() {
        mModel.ACGetTerminalList().compose(RxHttpReponseCompat.<TerminalListBean>compatResult())
                .subscribe(new ProgressSubcriber<TerminalListBean>(mContext, mView) {
                    @Override
                    public void onNext(TerminalListBean bean) {

                        if (hasView()) {

                            mView.ACGetTerminalListSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ACGetTerminalListError(e);
                        }
                    }
                });
    }

    public void editTerminalName(String terminalId, String terminalName) {
        mModel.ACEditTerminalName(terminalId,terminalName).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean bean) {
                        if (hasView()) {
                            mView.ACEditTerminalNameSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ACEditTerminalNameError(e);
                        }
                    }
                });

    }

    public void deleteTerminal(String terminalId) {

        mModel.ACDeleteTerminal(terminalId).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean bean) {
                        if (hasView()) {
                            mView.ACDeleteTerminalSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ACDeleteTerminalError(e);
                        }
                    }
                });
    }
}
