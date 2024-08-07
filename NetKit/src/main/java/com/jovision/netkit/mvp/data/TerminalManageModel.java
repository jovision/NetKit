package com.jovision.netkit.mvp.data;

import com.google.gson.Gson;
import com.jovision.basekit.LogUtil;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.TerminalListBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.TerminalManageContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;
/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/12/08
 * 描述：
 */
public class TerminalManageModel implements TerminalManageContract.ITerminalManageModel {

    private ApiService mApiService;

    public TerminalManageModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<TerminalListBean>> ACGetTerminalList() {
//        TreeMap<String, Object> param = ParamUtil.getParma();
        return mApiService.ACGetTerminalList();
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACEditTerminalName(String terminalName, String terminalId) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("terminalID",terminalId);
        param.put("terminalName",terminalName);
        return mApiService.ACEditTerminalName(ParamUtil.getBody(param));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> ACDeleteTerminal(String terminalId) {

        TreeMap<String,Object> map = new TreeMap<>();
        List<HashMap<String,Object>> terminals = new ArrayList<>();
        HashMap<String,Object> parma = new HashMap<>();
        parma.put("terminalID",terminalId);
        terminals.add(parma);
        map.put("terminalIDs",terminals);
        LogUtil.v("Okhttp","参数："+new Gson().toJson(map));
        return mApiService.ACDeleteTerminal(ParamUtil.getBody(map));

    }
}
