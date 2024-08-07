package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.MessageOperationTodoBean;
import com.jovision.netkit.mvp.data.bean.MessagePersonBean;
import com.jovision.netkit.mvp.data.bean.MessagePersonTodoBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.MessagePersonContract;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ZHP on 2017/7/19.
 */

public class MessagePersonPresenter extends BasePresenter<MessagePersonContract.IMessagePersonModel, MessagePersonContract.View> {

    @Inject
    public MessagePersonPresenter(MessagePersonContract.IMessagePersonModel iMessagePersonModel, MessagePersonContract.View view) {
        super(iMessagePersonModel, view);
    }

    public void getMsgPersonList(int pageStartId, int pageSize) {
        mModel.getMsgPersonList(pageStartId, pageSize).compose(RxHttpReponseCompat.<MessagePersonBean>compatResult())
                .subscribe(new ProgressSubcriber<MessagePersonBean>(mContext, mView,true) {
                    @Override
                    public void onNext(MessagePersonBean messagePersonBean) {
                        if (hasView()) {
                            mView.getMsgPersonListSuccess(messagePersonBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);

                    }
                });
    }

    public void personMsgRead(List<Integer> msgIdList) {
        mModel.personMsgRead(msgIdList).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            //只要调取这个接口，就要更新首页的消息未读红点逻辑
//                            EventBus.getDefault().post(new MessageReadStateUpdateEvent());
                            mView.personMsgReadSuccess();
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);

                    }
                });
    }

    public void personMsgClean(List<Integer> msgIdList) {
        mModel.personMsgClean(msgIdList).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            //只要调取这个接口，就要更新首页的消息未读红点逻辑
//                            EventBus.getDefault().post(new MessageReadStateUpdateEvent());
                            mView.personMsgCleanSuccess();
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);

                    }
                });
    }

    public void getMsgPersonTodoList() {
        mModel.getMsgPersonTodoList().compose(RxHttpReponseCompat.<MessagePersonTodoBean>compatResult())
                .subscribe(new ProgressSubcriber<MessagePersonTodoBean>(mContext, mView,true) {
                    @Override
                    public void onNext(MessagePersonTodoBean messagePersonTodoBean) {
                        if (hasView()) {
                            mView.getMsgPersonTodoListSuccess(messagePersonTodoBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);

                    }
                });
    }

    public void readMsgFromPush(String msgId){
        mModel.readMsgFromPush(msgId).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView,true) {
                    @Override
                    public void onNext(EmptyBean bean) {
                        if (hasView()) {
                            mView.readMsgFromPushSuccess();
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);

                    }
                });
    }


    //[工程商服务]用户回应远程运维申请 -2023.7.19
    public void answerRemoteOperation(String deviceId, boolean accept){
        mModel.answerRemoteOperation(deviceId, accept).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView,false) {
                    @Override
                    public void onNext(EmptyBean bean) {
                        if (hasView()) {
                            mView.answerRemoteOperationSuccess(bean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.answerRemoteOperationFailed(e);
                        }
                    }
                });
    }


    //[工程商服务]查看远程运维待办事项 -2023.7.19
    public void getRemoteOperationTodoList(){
        mModel.getRemoteOperationTodoList().compose(RxHttpReponseCompat.<MessageOperationTodoBean>compatResult())
                .subscribe(new ProgressSubcriber<MessageOperationTodoBean>(mContext, mView,false) {
                    @Override
                    public void onNext(MessageOperationTodoBean messageOperationTodoBean) {
                        if (hasView()) {
                            mView.getRemoteOperationTodoListSuccess(messageOperationTodoBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getRemoteOperationTodoListFailed(e);
                        }
                    }
                });
    }


    //[工程商服务]查看远程运维个人消息 -2023.7.19
    public void getRemoteOperationList(int pageStartId, int pageSize){
        mModel.getRemoteOperationList(pageStartId,pageSize).compose(RxHttpReponseCompat.<MessagePersonBean>compatResult())
                .subscribe(new ProgressSubcriber<MessagePersonBean>(mContext, mView,false) {
                    @Override
                    public void onNext(MessagePersonBean messagePersonBean) {
                        if (hasView()) {
                            mView.getRemoteOperationListSuccess(messagePersonBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getRemoteOperationListFailed(e);
                        }
                    }
                });
    }



}
