package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.UploadUserInfoBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface PushContract {

    interface IPushModel {
        Observable<BaseBean<EmptyBean>> upLoadToken(String token, int tokenType);

        Observable<BaseBean<EmptyBean>> uploadUserInfo(UploadUserInfoBean uploadUserInfoBean);
    }

    interface View extends BaseView {
        void upLoadTokenSuccess();

        void upLoadTokenError(Throwable throwable);


        void uploadUserInfoSuccess();

        void uploadUserInfoError(Throwable e);
    }

}
