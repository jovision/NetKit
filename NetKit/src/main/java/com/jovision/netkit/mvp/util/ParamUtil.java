package com.jovision.netkit.mvp.util;

import com.google.gson.Gson;
import com.jovision.basekit.LogUtil;
import com.jovision.basekit.MMKVUtil;
import com.jovision.netkit.mvp.net.rto_exception.BaseException;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import okhttp3.RequestBody;

/**
 * Created by ZHP on 2017/7/18.
 */

public class ParamUtil {

    public static TreeMap<String, Object> getParma() {

        TreeMap<String, Object> map = new TreeMap<>();
        return map;
    }

    /**
     * 已在全局存放 暂时不用
     *
     * @return
     */
    public static StringBuilder getHeaders() {

        StringBuilder headers = new StringBuilder();
        headers.append("Bearer " + MMKVUtil.getInstance().getToken());

        return headers;
    }

    public static RequestBody getBody(TreeMap<String, Object> map) {

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));

        LogUtil.v("okhttp","参数："+new Gson().toJson(map));

        return body;
    }

    public static RequestBody getBody(List<HashMap<String, Object>> list) {

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(list));
        return body;
    }

    public static String getMapStr(HashMap<String, Object> map){
        String s = new Gson().toJson(map);
        return s;
    }

    public static String errorCode2baseCode(String errorCode){
        String baseCode = BaseException.SUCCEED;
        if (errorCode.equals("3208")){
            baseCode = BaseException.DEVICE_OUTLINE;
        }else if (errorCode.equals("32602")){
            baseCode = BaseException.PARAM_ERROR;
        }else if (errorCode.equals("-32002 ") || errorCode.equals("32603") || !errorCode.equals("0")){
            baseCode = BaseException.ERROR_TOKEN_OVER;
        }
        return baseCode;
    }
}
