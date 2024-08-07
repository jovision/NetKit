package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.CrossShipmentReportBean;
import com.jovision.netkit.mvp.data.bean.response.CrossShipmentReportFileLimitBean;
import com.jovision.netkit.mvp.data.bean.response.UnreadCountBean;
import com.jovision.netkit.mvp.data.bean.response.UploadFilesResponseBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.CrossShipmentReportCommitContract;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class CrossShipmentReportCommitPresenter
        extends BasePresenter<CrossShipmentReportCommitContract.IModel,
        CrossShipmentReportCommitContract.IView> {

    @Inject
    public CrossShipmentReportCommitPresenter(CrossShipmentReportCommitContract.IModel model,
                                              CrossShipmentReportCommitContract.IView view) {
        super(model, view);
    }

    /**
     * 获取未读状态
     */
    public void getCrossShipmentUnreadStatus() {
        mModel.getCrossShipmentUnreadStatus()
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<UnreadCountBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull UnreadCountBean responseBean) {
                        if (hasView()) {
                            mView.getCrossShipmentUnreadStatusSuccess(responseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getCrossShipmentUnreadStatusError(e);
                        }
                    }
                });
    }

    /**
     * 获取串货举报上报文件数量上限
     */
    public void getCrossShipmentReportFileLimit() {
        mModel.getCrossShipmentReportFileLimit()
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<CrossShipmentReportFileLimitBean>(mContext, mView) {
                    @Override
                    public void onNext(@NotNull CrossShipmentReportFileLimitBean responseBean) {
                        if (hasView()) {
                            mView.getCrossShipmentReportFileLimitSuccess(responseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getCrossShipmentReportFileLimitError(e);
                        }
                    }
                });
    }

    /**
     * 批量上传文件
     *
     * @param files
     */
    public void uploadFileList(List<String> files) {
        mModel.uploadFileList(files)
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<UploadFilesResponseBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NotNull UploadFilesResponseBean responseBean) {
                        if (hasView()) {
                            mView.uploadFileListSuccess(responseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.uploadFileListError(e);
                        }
                    }
                });
    }

    /**
     * 上传串货举报信息
     *
     * @param body
     */
    public void commitCrossShipmentReport(CrossShipmentReportBean body) {
        mModel.commitCrossShipmentReport(body)
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NotNull EmptyBean responseBean) {
                        if (hasView()) {
                            mView.commitCrossShipmentReportSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.commitCrossShipmentReportError(e);
                        }
                    }
                });
    }
}
