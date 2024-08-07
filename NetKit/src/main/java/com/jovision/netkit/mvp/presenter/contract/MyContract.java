package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.AppVersionResponseBean;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.ACAvatarUploadUrlBean;
import com.jovision.netkit.mvp.data.bean.response.ACUserInfoBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

public interface MyContract {
    interface IMyModel{
        Observable<BaseBean<ACUserInfoBean>> ACGetUserInfo();
        Observable<BaseBean<EmptyBean>> ACUpdateNickName(String nickName);
        Observable<BaseBean<ACAvatarUploadUrlBean>> ACUploadAvatarUrl(String fileName);
        Observable<BaseBean<EmptyBean>> ACUpdateAvatar(String fileName);
        Observable<BaseBean<AppVersionResponseBean>> getAppNewestVersion();
    }
    interface View extends BaseView {
        void ACGetUserInfoSuccess(ACUserInfoBean userInfoBean);
        void ACGetUserInfoError(Throwable e);
        void ACUpdateNickNameSuccess(String nickName);
        void ACUpdateNickNameError(Throwable e);
        void ACUploadAvatarUrlSuccess(String url);
        void ACUploadAvatarUrlError(Throwable e);
        void ACUpdateAvatarSuccess();
        void ACUpdateAvatarError(Throwable e);
        void getAppNewestVersionSuccess(AppVersionResponseBean responseBean);
    }
}
