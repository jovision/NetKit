package com.jovision.netkit.mvp.presenter.contract;


import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.AddLogoBean;
import com.jovision.netkit.mvp.data.bean.response.FileUploadBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

public interface H5Contract {

    interface IH5Model {

        Observable<BaseBean<FileUploadBean>> getFileUploadInfo(String filename);

        Observable<BaseBean<EmptyBean>> addLogo(String filepath);

    }

    interface View extends BaseView {

        void getFileUploadInfoSuccess(FileUploadBean bean);
        void getFileUploadInfoFailed(Throwable t);

        void addLogoSuccess(AddLogoBean bean);
        void addLogoFailed(Throwable t);

    }

}
