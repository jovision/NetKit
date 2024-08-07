package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.LogContract;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class LogModel implements LogContract.ILogModel {

    private ApiService mApiService;

    public LogModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<EmptyBean>> addLog(String msg) {

        /*TreeMap<String,String> map = new TreeMap<>();
        String encode = null;
        try {
            encode = URLEncoder.encode(msg.trim(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        map.put("msg",encode);
        Map<String, String> parma = ParamUtil.getParma(map);
        parma.put("msg",msg);*/

//        return mApiService.addLog(Constant.logInterface, parma);
        return null;
    }
}
