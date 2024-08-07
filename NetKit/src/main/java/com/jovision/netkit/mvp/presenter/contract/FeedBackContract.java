package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceListResponseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.FeedBackUploadBean;
import com.jovision.netkit.mvp.data.bean.response.FeedbackInfoBean;
import com.jovision.netkit.mvp.data.bean.response.FeedbackListResponseBean;
import com.jovision.netkit.mvp.data.bean.response.FeedbackTypeResponseBean;
import com.jovision.netkit.mvp.data.bean.response.UnreadCountBean;
import com.jovision.uikit.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface FeedBackContract {
    interface IFeedBackModel{
        Observable<BaseBean<FeedBackUploadBean>> getUploadFileUrl(String fileSuffix);//文件后缀 （"jpg", "jpeg", "png", "JPG", "PNG", "JPEG"）
        Observable<BaseBean<EmptyBean>> feedbackAdd(String type, String twoTypeId, String problem, String pictures, String appType, String appName, String appVersion, String contact, List<String> deviceIds, String frequency);//type:1:新功能建议;2:体验问题;3:功能异常;4:其他问题 pic:多张逗号隔开，最多三张图片
        Observable<BaseBean<FeedbackListResponseBean>> feedbackList(int pageStart, int pageSize);
        Observable<BaseBean<FeedbackTypeResponseBean>> feedbackIssueTypeList();
        Observable<BaseBean<FeedbackInfoBean>> feedbackInfo(int feedbackId);
        Observable<BaseBean<UnreadCountBean>> getUnreadStatus();

        Observable<BaseBean<DeviceListResponseBean>> deviceList();
        Observable<BaseBean<DeviceListResponseBean>> userDeviceList();


    }
    interface View extends BaseView {
        void getUploadFileUrlSuccess(FeedBackUploadBean feedBackUploadBean);
        void getUploadFileUrlError(Throwable e);
        void feedbackAddSuccess();
        void feedbackAddError(Throwable e);
        void feedbackListSuccess(FeedbackListResponseBean feedbackListResponseBean);
        void feedbackListError(Throwable e);
        void feedbackInfoSuccess(FeedbackInfoBean feedbackInfoBean);
        void feedbackInfoError(Throwable e);

        void feedbackTypeListSuccess(FeedbackTypeResponseBean feedbackListResponseBean);
        void feedbackTypeListError(Throwable e);

        void getUnreadStatusSuccess(UnreadCountBean unreadCountBean);

        void deviceListSuccess(DeviceListResponseBean deviceListResponseBean);
        void deviceListError(Throwable e);
    }
}
