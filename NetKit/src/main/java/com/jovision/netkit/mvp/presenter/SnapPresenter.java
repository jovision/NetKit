package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.OctTimingSnapBean;
import com.jovision.netkit.mvp.data.bean.response.ResultBean;
import com.jovision.netkit.mvp.data.bean.response.ResultBeanX;
import com.jovision.netkit.mvp.data.bean.response.SnapGetParamBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.SnapContract;

import java.util.List;

import javax.inject.Inject;


public class SnapPresenter extends BasePresenter<SnapContract.ISnapModel, SnapContract.View> {

    @Inject
    public SnapPresenter(SnapContract.ISnapModel iModel, SnapContract.View view) {
        super(iModel, view);
    }


    public void getTimingSnap(String deviceSn, int channelId) {
        mModel.getTimingSnap(deviceSn, channelId).compose(RxHttpReponseCompat.<OctTimingSnapBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctTimingSnapBean.ResultBean>(mContext, mView) {
                    @Override
                    public void onNext(OctTimingSnapBean.ResultBean resultBean) {
                        if (hasView()) {
                            mView.getTimingSnapSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getTimingSnapFailed(e);
                        }
                    }
                });
    }

    public void setTimingSnap(String deviceSn, int channelId, List<OctTimingSnapBean.ResultBean> resultBean) {
        mModel.setTimingSnap(deviceSn, channelId, resultBean).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean resultBean) {
                        if (hasView()) {
                            mView.setTimingSnapSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setTimingSnapFailed(e);
                        }
                    }
                });
    }

    public void getSnapFileDateList(String deviceSn, int channelId, int year, int month) {
        mModel.getSnapFileDateList(deviceSn, channelId, year, month).compose(RxHttpReponseCompat.<ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<ResultBean>(mContext, mView) {
                    @Override
                    public void onNext(ResultBean resultBean) {
                        if (hasView()) {
                            mView.getSnapFileDateListSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getSnapFileDateListFailed(e);
                        }
                    }
                });
    }

    public void getSnapFileList(String deviceSn, int channelId, int year, int month, int day, int page, int pageSize) {
        mModel.getSnapFileList(deviceSn, channelId, year, month, day, page, pageSize).compose(RxHttpReponseCompat.<ResultBeanX>compatResult())
                .subscribe(new ProgressSubcriber<ResultBeanX>(mContext, mView) {
                    @Override
                    public void onNext(ResultBeanX resultBean) {
                        if (hasView()) {
                            mView.getSnapFileListSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getSnapFileListFailed(e);
                        }
                    }
                });
    }

    public void getSnapFile(String deviceSn, int channelId, String filePath) {
        mModel.getSnapFile(deviceSn, channelId, filePath).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean resultBean) {
                        if (hasView()) {
                            mView.getSnapFileSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getSnapFileFailed(e);
                        }
                    }
                });
    }

    public void getSnapParam(String deviceSn, int channelId) {
        mModel.getSnapParam(deviceSn, channelId).compose(RxHttpReponseCompat.<SnapGetParamBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<SnapGetParamBean.ResultBean>(mContext, mView) {
                    @Override
                    public void onNext(SnapGetParamBean.ResultBean resultBean) {
                        if (hasView()) {
                            mView.getSnapParamSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getSnapParamFailed(e);
                        }
                    }
                });
    }

    public void setSnapParam(String deviceSn, int channelId, SnapGetParamBean.ResultBean resultBean) {
        mModel.setSnapParam(deviceSn, channelId, resultBean).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean resultBean) {
                        if (hasView()) {
                            mView.setSnapParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setSnapParamFailed(e);
                        }
                    }
                });
    }

}
