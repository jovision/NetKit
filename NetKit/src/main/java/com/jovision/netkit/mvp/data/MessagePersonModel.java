package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.MessageOperationTodoBean;
import com.jovision.netkit.mvp.data.bean.MessagePersonBean;
import com.jovision.netkit.mvp.data.bean.MessagePersonTodoBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.MessagePersonContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class MessagePersonModel implements MessagePersonContract.IMessagePersonModel {

    private ApiService mApiService;

    public MessagePersonModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<MessagePersonBean>> getMsgPersonList(int pageStartId, int pageSize) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        if (pageStartId != 0) {
            parma.put("pageStartId", pageStartId);
        }
        parma.put("pageSize", pageSize);
        return mApiService.getMsgPersonList(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> personMsgRead(List<Integer> msgIdList) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("msgIdList", msgIdList);
        return mApiService.personMsgRead(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> personMsgClean(List<Integer> msgIdList) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("msgIdList", msgIdList);
        return mApiService.personMsgClean(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<MessagePersonTodoBean>> getMsgPersonTodoList() {
        return mApiService.getMsgPersonTodoList();
    }

    @Override
    public Observable<BaseBean<EmptyBean>> readMsgFromPush(String msgId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("msgId", msgId);
        return mApiService.readMsgFromPush(ParamUtil.getBody(parma));
    }


    //[工程商服务]用户回应远程运维申请 -2023.7.19
    @Override
    public Observable<BaseBean<EmptyBean>> answerRemoteOperation(String deviceId,boolean accept) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceID", deviceId);
        param.put("status", accept?1:0);//状态，0-拒绝 1-同意
        return mApiService.answerRemoteOperation(ParamUtil.getBody(param));
    }


    //[工程商服务]查看远程运维待办事项 -2023.7.19
    @Override
    public Observable<BaseBean<MessageOperationTodoBean>> getRemoteOperationTodoList() {
        return mApiService.getRemoteOperationTodoList();
    }


    //[工程商服务]查看远程运维个人消息 -2023.7.19
    @Override
    public Observable<BaseBean<MessagePersonBean>> getRemoteOperationList(int pageStartId, int pageSize) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        if (pageStartId != 0) {
            param.put("pageStartId", pageStartId);
        }
        param.put("pageSize", pageSize);
        return mApiService.getRemoteOperationList(ParamUtil.getBody(param));
    }

}
