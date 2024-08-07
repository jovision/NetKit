package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.AgreementBean;
import com.jovision.netkit.mvp.data.bean.AppVersionResponseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.UserInfoWithAgreementVersionBean;
import com.jovision.netkit.mvp.data.bean.request.UploadUserInfoBean;
import com.jovision.netkit.mvp.data.bean.response.ACUserInfoBean;
import com.jovision.netkit.mvp.data.bean.response.HomeMenuBean;
import com.jovision.netkit.mvp.data.bean.response.MultiBindBean;
import com.jovision.netkit.mvp.data.bean.response.ToDoOperationListBean;
import com.jovision.netkit.mvp.data.bean.response.ToDoTransferListBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.MainContract;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

/**
 * @author liteng
 * @date 2020/10/22
 */
public class MainPresenter extends BasePresenter<MainContract.IMainModel, MainContract.View> {

    @Inject
    public MainPresenter(MainContract.IMainModel iMainModel, MainContract.View view) {
        super(iMainModel, view);
    }


    
    public void getMenuList(){
        try {
            mModel.getMenuList().compose(RxHttpReponseCompat.<HomeMenuBean>compatResult())
                    .subscribe(new ProgressSubcriber<HomeMenuBean>(mContext, mView,true) {
                        @Override
                        public void onNext(HomeMenuBean responseBean) {
                            if (hasView()) {
                                mView.getMenuListSuccess(responseBean);
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            super.onError(e);
                            if (hasView()) {
                                mView.getMenuListError(e);
                            }
                        }
                    });

        } catch (Exception e){
            e.printStackTrace();
        }


    }

    public void getAppNewestVersion(){
        try {
            mModel.getAppNewestVersion().compose(RxHttpReponseCompat.<AppVersionResponseBean>compatResult())
                    .subscribe(new ProgressSubcriber<AppVersionResponseBean>(mContext, mView,true) {
                        @Override
                        public void onNext(AppVersionResponseBean responseBean) {
                            if (hasView()) {
                                mView.getAppNewestVersionSuccess(responseBean);
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            super.onError(e);
                            if (hasView()) {
                                mView.getAppNewestVersionError(e);
                            }
                        }
                    });

        } catch (Exception e){
            e.printStackTrace();
        }


    }


    public void getEnableLink(){
        mModel.getEnableLink().compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<AgreementBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull AgreementBean agreementBean) {
                        if (hasView()){
                            mView.getEnableLinkSuccess(agreementBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getEnableLinkError(e);
                        }
                    }
                });
    }


    public void getUserInfoWithAgreementVersion(){
        mModel.getUserInfoWithAgreementVersion().compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<UserInfoWithAgreementVersionBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull UserInfoWithAgreementVersionBean userInfoWithAgreementVersionBean) {
                        if (hasView()){
                            mView.getUserInfoWithAgreementVersionSuccess(userInfoWithAgreementVersionBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getUserInfoWithAgreementVersionError(e);
                        }
                    }
                });
    }



    public void agree(){
        mModel.agree().compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.agreeSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.agreeError(e);
                        }
                    }
                });
    }


    public void getUserInfo(){
        mModel.ACGetUserInfo().compose(RxHttpReponseCompat.<ACUserInfoBean>compatResult())
                .subscribe(new ProgressSubcriber<ACUserInfoBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull ACUserInfoBean userInfoBean) {
                        if (hasView()){
                            mView.ACGetUserInfoSuccess(userInfoBean);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.ACGetUserInfoError(e);
                        }
                    }
                });
    }


    public void uploadUserInfo(UploadUserInfoBean requestBean) {
        mModel.uploadUserInfo(requestBean).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView,true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.uploadUserInfoSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.uploadUserInfoError(e);
                        }
                    }
                });


    }

    public void checkMultiBind() {
        mModel.checkMultiBind().compose(RxHttpReponseCompat.<MultiBindBean>compatResult())
                .subscribe(new ProgressSubcriber<MultiBindBean>(mContext, mView,true) {
                    @Override
                    public void onNext(MultiBindBean multiBindBean) {
                        if (hasView()) {
                            mView.checkMultiBindSuccess(multiBindBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.checkMultiBindError(e);
                        }
                    }
                });

    }

    public void clearMultiBind() {
        mModel.clearMultiBind().compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.clearMultiBindSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.clearMultiBindError(e);
                        }
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




    //设备转移提醒列表
    public void getDevTransferList(){
        mModel.getDevTransferList().compose(RxHttpReponseCompat.<ToDoTransferListBean>compatResult())
                .subscribe(new ProgressSubcriber<ToDoTransferListBean>(mContext, mView,false) {
                    @Override
                    public void onNext(ToDoTransferListBean toDoTransferListBean) {
                        if (hasView()) {
                            mView.getDevTransferListSuccess(toDoTransferListBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getDevTransferListFailed(e);
                        }
                    }
                });
    }

    //远程运维消息提醒列表
    public void getDevOperationList(){
        mModel.getDevOperationList().compose(RxHttpReponseCompat.<ToDoOperationListBean>compatResult())
                .subscribe(new ProgressSubcriber<ToDoOperationListBean>(mContext, mView,false) {
                    @Override
                    public void onNext(ToDoOperationListBean toDoOperationListBean) {
                        if (hasView()) {
                            mView.getDevOperationListSuccess(toDoOperationListBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getDevOperationListFailed(e);
                        }
                    }
                });
    }

    //清除设备转移提醒列表
    public void clearDeviceTransfer(){
        mModel.clearDeviceTransfer().compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView,false) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.clearDeviceTransferSuccess(emptyBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.clearDeviceTransferFailed(e);
                        }
                    }
                });
    }



    /*public void getAppUserAssets() {
        mModel.getAppUserAssets().compose(RxHttpReponseCompat.<UserAssetsBean>compatResult())
                .subscribe(new ProgressSubcriber<UserAssetsBean>(mContext, mView) {
                    @Override
                    public void onNext(UserAssetsBean userAssetsBean) {
                        if (hasView()) {
                            mView.getAppUserAssetsSuccess(userAssetsBean);
                        }
                    }
                });
    }

    public void getWithdrawInfo() {
        mModel.getWithdrawInfo().compose(RxHttpReponseCompat.<WithdrawInfoBean>compatResult())
                .subscribe(new ProgressSubcriber<WithdrawInfoBean>(mContext, mView) {
                    @Override
                    public void onNext(WithdrawInfoBean withdrawInfoBean) {
                        if (hasView()) {
                            mView.getWithdrawInfoSuccess(withdrawInfoBean);
                        }
                    }
                });
    }

    public void goShare() {
        mModel.goShare().compose(RxHttpReponseCompat.<GoShareBean>compatResult())
                .subscribe(new ProgressSubcriber<GoShareBean>(mContext, mView) {
                    @Override
                    public void onNext(GoShareBean goShareBean) {
                        if (hasView()) {
                            mView.goShareSuccess(goShareBean);
                        }
                    }
                });
    }

    public void getBankCardInfo() {
        mModel.getBankCardInfo().compose(RxHttpReponseCompat.<BankInfoBean>compatResult())
                .subscribe(new ProgressSubcriber<BankInfoBean>(mContext, mView) {
                    @Override
                    public void onNext(BankInfoBean bankInfoBean) {
                        if (hasView()) {
                            mView.getBankCardInfoSuccess(bankInfoBean);
                        }
                    }
                });
    }*/
}
