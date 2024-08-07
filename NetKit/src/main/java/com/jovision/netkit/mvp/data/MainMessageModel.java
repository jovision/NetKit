package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.MessageBadgesBean;
import com.jovision.netkit.mvp.data.bean.response.UnreadCountBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.MainMessageContract;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class MainMessageModel implements MainMessageContract.IMainMessageModel {

    private ApiService mApiService;

    public MainMessageModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<MessageBadgesBean>> getMsgBadges() {
        return mApiService.getMsgBadges();
    }


    @Override
    public Observable<BaseBean<UnreadCountBean>> getUnreadStatus() {
        return mApiService.getUnreadStatus();
    }
}
