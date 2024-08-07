package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.TerminalListBean;
import com.jovision.uikit.BaseView;

import java.util.List;
import java.util.function.DoubleUnaryOperator;

import io.reactivex.Observable;
/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/12/08
 * 描述：
 */
public interface TerminalManageContract {

    interface ITerminalManageModel {
        Observable<BaseBean<TerminalListBean>> ACGetTerminalList();
        Observable<BaseBean<EmptyBean>>  ACEditTerminalName(String terminalId, String terminalName);
        Observable<BaseBean<EmptyBean>>  ACDeleteTerminal(String terminalId);
    }
    interface View extends BaseView {

       void ACGetTerminalListSuccess(TerminalListBean beans);
        void ACGetTerminalListError(Throwable throwable);


        void ACEditTerminalNameSuccess(EmptyBean bean);
        void ACEditTerminalNameError(Throwable throwable);

        void ACDeleteTerminalSuccess(EmptyBean bean);
        void ACDeleteTerminalError(Throwable throwable);
    }

}
