package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceListResponseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.FeedBackUploadBean;
import com.jovision.netkit.mvp.data.bean.response.FeedbackInfoBean;
import com.jovision.netkit.mvp.data.bean.response.FeedbackListResponseBean;
import com.jovision.netkit.mvp.data.bean.response.FeedbackTypeResponseBean;
import com.jovision.netkit.mvp.data.bean.response.UnreadCountBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.FeedBackContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;

public class FeedBackModel implements FeedBackContract.IFeedBackModel {
    private ApiService mApiService;

    public FeedBackModel(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    @Override
    public Observable<BaseBean<FeedBackUploadBean>> getUploadFileUrl(String fileSuffix) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("fileSuffix", fileSuffix);
        return mApiService.getUploadFileUrl(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> feedbackAdd(String type, String twoTypeId, String problem, String pictures, String appType, String appName, String appVersion, String contact,
                                                       List<String> deviceIds, String frequency) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("type", type);
        parma.put("twoTypeId", twoTypeId);
        parma.put("problem", problem);
        parma.put("pictures", pictures);
        parma.put("appType", appType);
        parma.put("appName", appName);
        parma.put("appVersion", appVersion);
        parma.put("contact", contact);
        parma.put("frequency", frequency);
        parma.put("deviceIds", deviceIds);
        return mApiService.feedbackAdd(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<FeedbackListResponseBean>> feedbackList(int pageStart, int pageSize) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("pageStart", pageStart);
        parma.put("pageSize", pageSize);
        return mApiService.feedbackList(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<FeedbackInfoBean>> feedbackInfo(int feedbackId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("feedbackId", feedbackId);
        return mApiService.feedbackInfo(ParamUtil.getBody(parma));
    }


    @Override
    public Observable<BaseBean<UnreadCountBean>> getUnreadStatus() {
        return mApiService.getUnreadStatus();
    }

    @Override
    public Observable<BaseBean<DeviceListResponseBean>> deviceList() {
        return mApiService.getDevices();
    }

    @Override
    public Observable<BaseBean<DeviceListResponseBean>> userDeviceList() {
        return mApiService.getUserDevices();
    }



    @Override
    public Observable<BaseBean<FeedbackTypeResponseBean>> feedbackIssueTypeList() {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        return mApiService.feedbackIssueTypeList(ParamUtil.getBody(parma));
    }

}
