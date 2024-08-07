package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.MessageOperationTodoBean;
import com.jovision.netkit.mvp.data.bean.MessagePersonBean;
import com.jovision.netkit.mvp.data.bean.MessagePersonTodoBean;
import com.jovision.uikit.BaseView;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface MessagePersonContract {

    interface IMessagePersonModel {
        Observable<BaseBean<MessagePersonBean>> getMsgPersonList(int pageStartId, int pageSize);

        Observable<BaseBean<EmptyBean>> personMsgRead(List<Integer> msgIdList);

        Observable<BaseBean<EmptyBean>> personMsgClean(List<Integer> msgIdList);

        Observable<BaseBean<MessagePersonTodoBean>> getMsgPersonTodoList();

        Observable<BaseBean<EmptyBean>> readMsgFromPush(String msgId);


        //[工程商服务]用户回应远程运维申请 -2023.7.19
        Observable<BaseBean<EmptyBean>> answerRemoteOperation(String deviceId,boolean accept);

        //[工程商服务]查看远程运维待办事项 -2023.7.19
        Observable<BaseBean<MessageOperationTodoBean>> getRemoteOperationTodoList();


        //[工程商服务]查看远程运维个人消息 -2023.7.19
        Observable<BaseBean<MessagePersonBean>> getRemoteOperationList(int pageStartId, int pageSize);
    }

    interface View extends BaseView {
        void getMsgPersonListSuccess(MessagePersonBean messagePersonBean);

        void getMsgPersonListError(Throwable e);

        void personMsgReadSuccess();

        void personMsgCleanSuccess();

        void getMsgPersonTodoListSuccess(MessagePersonTodoBean messagePersonTodoBean);

        void readMsgFromPushSuccess();


        //[工程商服务]用户回应远程运维申请 -2023.7.19
        void answerRemoteOperationSuccess(EmptyBean emptyBean);
        void answerRemoteOperationFailed(Throwable e);

        //[工程商服务]查看远程运维待办事项 -2023.7.19
        void getRemoteOperationTodoListSuccess(MessageOperationTodoBean messageOperationTodoBean);
        void getRemoteOperationTodoListFailed(Throwable e);

        //[工程商服务]查看远程运维个人消息 -2023.7.19
        void getRemoteOperationListSuccess(MessagePersonBean messagePersonBean);
        void getRemoteOperationListFailed(Throwable e);

    }

}
