package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.AgreementBean;
import com.jovision.netkit.mvp.data.bean.AppVersionResponseBean;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.UserInfoWithAgreementVersionBean;
import com.jovision.netkit.mvp.data.bean.request.UploadUserInfoBean;
import com.jovision.netkit.mvp.data.bean.response.ACUserInfoBean;
import com.jovision.netkit.mvp.data.bean.response.HomeMenuBean;
import com.jovision.netkit.mvp.data.bean.response.MultiBindBean;
import com.jovision.netkit.mvp.data.bean.response.ToDoOperationListBean;
import com.jovision.netkit.mvp.data.bean.response.ToDoTransferListBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * @author liteng
 * @date 2020/10/22
 */
public interface MainContract {
    interface IMainModel {
        /*Observable<BaseBean<UserAssetsBean>> getAppUserAssets();

        Observable<BaseBean<WithdrawInfoBean>> getWithdrawInfo();

        Observable<BaseBean<GoShareBean>> goShare();

        Observable<BaseBean<BankInfoBean>> getBankCardInfo();*/

        Observable<BaseBean<HomeMenuBean>> getMenuList();

        Observable<BaseBean<AppVersionResponseBean>> getAppNewestVersion();

        Observable<BaseBean<AgreementBean>> getEnableLink();

        Observable<BaseBean<EmptyBean>> agree();

        Observable<BaseBean<ACUserInfoBean>> ACGetUserInfo();

        Observable<BaseBean<UserInfoWithAgreementVersionBean>> getUserInfoWithAgreementVersion();

        Observable<BaseBean<EmptyBean>> uploadUserInfo(UploadUserInfoBean uploadUserInfoBean);

        Observable<BaseBean<MultiBindBean>> checkMultiBind();

        Observable<BaseBean<EmptyBean>> clearMultiBind();

        //[工程商服务]用户回应远程运维申请 -2023.7.19
        Observable<BaseBean<EmptyBean>> answerRemoteOperation(String deviceId,boolean accept);


        //设备转移提醒列表
        Observable<BaseBean<ToDoTransferListBean>> getDevTransferList();

        //远程运维消息提醒列表
        Observable<BaseBean<ToDoOperationListBean>> getDevOperationList();


        //清除设备转移提醒列表
        Observable<BaseBean<EmptyBean>> clearDeviceTransfer();


    }



    interface View extends BaseView {
        /*void getAppUserAssetsSuccess(UserAssetsBean userAssetsBean);

        void getWithdrawInfoSuccess(WithdrawInfoBean withdrawInfoBean);

        void goShareSuccess(GoShareBean goShareBean);

        void getBankCardInfoSuccess(BankInfoBean bankInfoBean);*/

        void getMenuListSuccess(HomeMenuBean responseBean);
        void getMenuListError(Throwable e);

        void getAppNewestVersionSuccess(AppVersionResponseBean responseBean);
        void getAppNewestVersionError(Throwable e);


        void getEnableLinkSuccess(AgreementBean agreementBean);
        void getEnableLinkError(Throwable e);

        void agreeSuccess(EmptyBean emptyBean);
        void agreeError(Throwable e);

        void ACGetUserInfoSuccess(ACUserInfoBean userInfoBean);
        void ACGetUserInfoError(Throwable e);

        void getUserInfoWithAgreementVersionSuccess( UserInfoWithAgreementVersionBean userInfoWithAgreementVersionBean);
        void getUserInfoWithAgreementVersionError(Throwable e);


        void uploadUserInfoSuccess();

        void uploadUserInfoError(Throwable e);

        void checkMultiBindSuccess(MultiBindBean multiBindBean);
        void checkMultiBindError(Throwable e);

        void clearMultiBindSuccess();
        void clearMultiBindError(Throwable e);


        //[工程商服务]用户回应远程运维申请 -2023.7.19
        void answerRemoteOperationSuccess(EmptyBean emptyBean);
        void answerRemoteOperationFailed(Throwable e);



        //设备转移提醒列表
        void getDevTransferListSuccess(ToDoTransferListBean toDoTransferListBean);
        void getDevTransferListFailed(Throwable e);

        //远程运维消息提醒列表
        void getDevOperationListSuccess(ToDoOperationListBean toDoOperationListBean);
        void getDevOperationListFailed(Throwable e);

        //清除设备转移提醒列表
        void clearDeviceTransferSuccess(EmptyBean emptyBean);
        void clearDeviceTransferFailed(Throwable e);


    }

}

