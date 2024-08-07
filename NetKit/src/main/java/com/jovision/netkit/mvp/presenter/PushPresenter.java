package com.jovision.netkit.mvp.presenter;

import com.jovision.basekit.LogUtil;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.UploadUserInfoBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.PushContract;

import javax.inject.Inject;

/**
 * Created by ZHP on 2017/7/19.
 */

public class PushPresenter extends BasePresenter<PushContract.IPushModel, PushContract.View> {

    @Inject
    public PushPresenter(PushContract.IPushModel iPushModel, PushContract.View view) {
        super(iPushModel, view);
    }


    public void upLoadToken(String token, int tokenType) {

        String type ="";
        switch (tokenType){
            case 2:
                type = "小米";
                break;
            case 3:
                type ="华为";
                break;
            case 4:
                type="oppo";
                break;
            case 5:
                type ="Vivo";
                break;

        }
        LogUtil.v("推送token上传","token:"+token+ " tokenType:"+type);

        mModel.upLoadToken(token, tokenType).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                               @Override
                               public void onNext(EmptyBean emptyBean) {
                                   if (hasView()) {
                                       mView.upLoadTokenSuccess();
                                   }
                               }

                               @Override
                               public void onError(Throwable e) {
                                   super.onError(e);
                                  if(hasView()){
                                      mView.dismissLoading();
                                      mView.upLoadTokenError(e);
                                  }
                               }
                           }
                );
    }




    public void uploadUserInfo(UploadUserInfoBean requestBean) {
        mModel.uploadUserInfo(requestBean).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.uploadUserInfoSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.uploadUserInfoError(e);
                    }
                });


    }


}
