package com.jovision.netkit.mvp.presenter;

import com.jovision.basekit.LogUtil;
import com.jovision.netkit.mvp.data.bean.DeviceBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.ShareCancelRequest;
import com.jovision.netkit.mvp.data.bean.response.AddShareBean;
import com.jovision.netkit.mvp.data.bean.response.MyShareDeviceBean;
import com.jovision.netkit.mvp.data.bean.response.Permission;
import com.jovision.netkit.mvp.data.bean.response.ShareDetailBean;
import com.jovision.netkit.mvp.data.bean.response.ShareListBean;
import com.jovision.netkit.mvp.data.bean.response.ShareToMeBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.ShareListContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class ShareListPresenter extends BasePresenter<ShareListContract.IShareListModel, ShareListContract.View> {

    @Inject
    public ShareListPresenter(ShareListContract.IShareListModel iShareListModel, ShareListContract.View view) {
        super(iShareListModel, view);
    }

    public void shareList(String deviceSn){//, int channelId) {
        mModel.shareList(deviceSn).compose(RxHttpReponseCompat.<ShareListBean>compatResult())
                .subscribe(new ProgressSubcriber<ShareListBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull ShareListBean shareListBean) {
                        if (hasView()) {
                            mView.shareListSuccess(shareListBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.shareListError(e);
                        }
                    }
                });
    }

    public void addShare(String deviceSn,  String account, Permission permission) {//int channelId,
        mModel.addShare(deviceSn, account, permission).compose(RxHttpReponseCompat.<AddShareBean>compatResult())
                .subscribe(new ProgressSubcriber<AddShareBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull AddShareBean addShareBean) {
                        if (hasView()) {
                            mView.addShareSuccess(addShareBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.addShareError(e);
                        }
                    }
                });
    }

    public void cancelShare(ShareCancelRequest shareCancelRequest) {
        mModel.cancelShare(shareCancelRequest).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.shareCancelSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.shareCancelError(e);
                        }
                    }
                });
    }

    public void shareDetail(String shareNumber) {
        mModel.shareDetail(shareNumber).compose(RxHttpReponseCompat.<ShareDetailBean>compatResult())
                .subscribe(new ProgressSubcriber<ShareDetailBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull ShareDetailBean shareDetailBean) {
                        if (hasView()) {
                            mView.shareDetailSuccess(shareDetailBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.shareDetailError(e);
                        }
                    }
                });
    }

    public void updateSharedNickName(String shareNumber, String nickname) {
        mModel.updateSharedNickName(shareNumber, nickname).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.updateSharedNickNameSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.updateSharedNickNameError(e);
                        }
                    }
                });
    }

    public void updatePermission(String shareNumber, Permission permission) {
        mModel.updatePermission(shareNumber, permission).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.updatePermissionSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.updatePermissionError(e);
                        }
                    }
                });
    }

    public void updateShareStatus(String shareNumber, String shareStatus) {
        mModel.updateShareStatus(shareNumber, shareStatus).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.updateShareStatusSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.updateShareStatusError(e);
                        }
                    }
                });
    }

    public void myShare(String deviceSn) {//, String channelId
        mModel.myShare(deviceSn).compose(RxHttpReponseCompat.<List<MyShareDeviceBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<MyShareDeviceBean>>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull List<MyShareDeviceBean> myShareDeviceBeans) {
                        if (hasView()) {
                            mView.myShareSuccess(myShareDeviceBeans);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.myShareError(e);
                        }
                    }
                });
    }

    public void shareToMe(String deviceSn) {//, String channelId
        LogUtil.e("shareToMe-tiaoshi","1-ShareListPresenter:shareToMe-enter");
        mModel.shareToMe(deviceSn).compose(RxHttpReponseCompat.<List<ShareToMeBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<ShareToMeBean>>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull List<ShareToMeBean> shareToMeBeanList) {
                        LogUtil.e("shareToMe-tiaoshi","1-ShareListPresenter:shareToMe-success");
                        if (hasView()) {
                            mView.shareToMeSuccess(shareToMeBeanList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("shareToMe-tiaoshi","1-ShareListPresenter:shareToMe-failed");
                        super.onError(e);
                        if (hasView()) {
                            mView.shareToMeError(e);
                        }
                    }
                });
    }


    public void getDeviceAbility(String deviceNo) {


        //获取设备的能力集
        mModel.getDeviceAbility(deviceNo).compose(RxHttpReponseCompat.<DeviceBean>compatResult()
        ).subscribe(new ProgressSubcriber<DeviceBean>(mContext, mView) {

            @Override
            public void onNext(DeviceBean bean) {
                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getDeviceAbilitySuccess(bean);
                }
            }
        });


    }


}
