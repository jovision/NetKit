package com.jovision.netkit.mvp.presenter;

import com.jovision.basekit.LogUtil;
import com.jovision.netkit.mvp.data.bean.DeviceListResponseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.FeedBackUploadBean;
import com.jovision.netkit.mvp.data.bean.response.FeedbackInfoBean;
import com.jovision.netkit.mvp.data.bean.response.FeedbackListResponseBean;
import com.jovision.netkit.mvp.data.bean.response.FeedbackTypeResponseBean;
import com.jovision.netkit.mvp.data.bean.response.UnreadCountBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.FeedBackContract;

import java.net.UnknownHostException;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class FeedBackPresenter extends BasePresenter<FeedBackContract.IFeedBackModel,FeedBackContract.View> {
    @Inject
    public FeedBackPresenter(FeedBackContract.IFeedBackModel iFeedBackModel, FeedBackContract.View view) {
        super(iFeedBackModel, view);
    }
    public void getUploadFileUrl(String fileSuffix){

        mModel.getUploadFileUrl(fileSuffix).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<FeedBackUploadBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull FeedBackUploadBean feedBackUploadBean) {
                        if (hasView()){
                            mView.getUploadFileUrlSuccess(feedBackUploadBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getUploadFileUrlError(e);
                        }
                    }
                });
    }

    /**
     *
     * @param type  SUGGESTION :新功能建议,EXPERIENCE：体验问题,EXCEPTION：功能异常,OTHER：其他问题
     * @param problem
     * @param pictures
     * @param appType   ANDROID,IOS,PC,DINGTALKH5,IPAD,WEB
     * @param appName   CLOUDSEE：云视通,UNICOMAPP：维观,SOOVVI：小维
     * @param appVersion
     * @param contact
     */
    public void feedbackAdd(String type, String twoTypeId, String problem, String pictures, String appType, String appName, String appVersion, String contact, List<String> deviceIds, String frequency){
        mModel.feedbackAdd(type, twoTypeId,problem, pictures, appType, appName, appVersion, contact,deviceIds,frequency).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.feedbackAddSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            LogUtil.e("添加图片错误："+e.getMessage());
//                            if (e instanceof UnknownHostException) {
//                                mView.showError(UIUtil.getString(R.string.str_connect_exception));
//                            }else{
                                mView.feedbackAddError(e);
//                            }
                        }
                    }
                });
    }

    public void feedbackList(int pageStart,int pageSize){
        mModel.feedbackList(pageStart,pageSize).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<FeedbackListResponseBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull FeedbackListResponseBean feedbackListResponseBean) {
                        if (hasView()){
                            mView.feedbackListSuccess(feedbackListResponseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.feedbackListError(e);
                        }
                    }
                });
    }



    public void feedbackInfo(int feedbackId){
        mModel.feedbackInfo(feedbackId).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<FeedbackInfoBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull FeedbackInfoBean feedbackInfoBean) {
                        if (hasView()){
                            mView.feedbackInfoSuccess(feedbackInfoBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.feedbackInfoError(e);
                        }
                    }
                });
    }


    //获取未读状态（工程商、意见反馈）
    public void getUnreadStatus() {
        mModel.getUnreadStatus().compose(RxHttpReponseCompat.<UnreadCountBean>compatResult())
                .subscribe(new ProgressSubcriber<UnreadCountBean>(mContext, mView, true) {
                    @Override
                    public void onNext(UnreadCountBean unreadCountBean) {
                        if (hasView()) {
                            mView.getUnreadStatusSuccess(unreadCountBean);
                        }
                    }
                });
    }

    /**
     * 反馈类型
     */
    public void feedbackIssueTypeList(){
        mModel.feedbackIssueTypeList().compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<FeedbackTypeResponseBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull FeedbackTypeResponseBean feedbackListResponseBean) {
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.feedbackTypeListSuccess(feedbackListResponseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.feedbackTypeListError(e);
                        }
                    }
                });
    }


    public void requestDeviceList(){
        mModel.userDeviceList().compose(RxHttpReponseCompat.<DeviceListResponseBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceListResponseBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull DeviceListResponseBean deviceListResponseBean) {
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.deviceListSuccess(deviceListResponseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.deviceListError(e);
                        }
                    }
                });
    }



}
