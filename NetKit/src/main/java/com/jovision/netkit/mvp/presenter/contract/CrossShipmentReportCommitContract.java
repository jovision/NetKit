package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.CrossShipmentReportBean;
import com.jovision.netkit.mvp.data.bean.response.CrossShipmentReportFileLimitBean;
import com.jovision.netkit.mvp.data.bean.response.UnreadCountBean;
import com.jovision.netkit.mvp.data.bean.response.UploadFilesResponseBean;
import com.jovision.uikit.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface CrossShipmentReportCommitContract {
    interface IModel {

        Observable<BaseBean<UnreadCountBean>> getCrossShipmentUnreadStatus();

        Observable<BaseBean<CrossShipmentReportFileLimitBean>> getCrossShipmentReportFileLimit();

        Observable<BaseBean<UploadFilesResponseBean>> uploadFileList(List<String> files);

        Observable<BaseBean<EmptyBean>> commitCrossShipmentReport(CrossShipmentReportBean body);
    }

    interface IView extends BaseView {

        void getCrossShipmentUnreadStatusSuccess(UnreadCountBean response);

        void getCrossShipmentUnreadStatusError(Throwable t);

        void getCrossShipmentReportFileLimitSuccess(CrossShipmentReportFileLimitBean response);

        void getCrossShipmentReportFileLimitError(Throwable t);

        void uploadFileListSuccess(UploadFilesResponseBean response);

        void uploadFileListError(Throwable t);

        void commitCrossShipmentReportSuccess();

        void commitCrossShipmentReportError(Throwable t);
    }
}
