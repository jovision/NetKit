package com.jovision.netkit.mvp.data.http;

import android.text.TextUtils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jovision.basekit.LogUtil;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.TransBaseBean;
import com.jovision.netkit.mvp.data.bean.response.ErrorBean;
import com.jovision.netkit.mvp.util.ParamUtil;

import org.json.JSONObject;

import java.util.Base64;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import okhttp3.RequestBody;

public class TransCmdHelper {

    private static TransCmdHelper instance;

    private TransCmdHelper() {
    }

    public static TransCmdHelper getInstance() {
        if (instance != null)
            return instance;
        synchronized (TransCmdHelper.class) {
            if (instance != null)
                return instance;
            instance = new TransCmdHelper();
            return instance;
        }
    }


    //公有云透传命令
    public <T> Observable<BaseBean<T>> transCmd(ApiService mApiService, RequestBody body, Class<T> t) {
        return mApiService.transCmd(body).map(new Function<BaseBean<String>, BaseBean<T>>() {
            @Override
            public BaseBean<T> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
                Gson gson = new Gson();
                TransBaseBean<T> transBaseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<TransBaseBean<T>>() {
                }.getType());
                BaseBean<T> baseBean = new BaseBean<T>();
                baseBean.setCode(stringBaseBean.getCode());
                baseBean.setMsg(stringBaseBean.getMsg());

                if (transBaseBean != null) {
                    baseBean.setCode(ParamUtil.errorCode2baseCode(transBaseBean.getError().getErrorcode()));
                    String jsonString = gson.toJson(transBaseBean.getResult());
                    T bean = gson.fromJson(jsonString, t);
                    baseBean.setData(bean);

                    if (!TextUtils.equals(transBaseBean.getError().getErrorcode(), "0") && null == bean) {

                        ErrorBean errorBean = new ErrorBean();
                        errorBean.setErrorcode(Integer.parseInt(transBaseBean.getError().getErrorcode()));
                        errorBean.setMessage(stringBaseBean.getMsg());
                        baseBean.setData((T) errorBean);
                    } else if (TextUtils.equals(transBaseBean.getError().getErrorcode(), "0") && null == bean
                            && (transBaseBean.getMethod().equalsIgnoreCase("intelligence_get_ability")
                                    ||transBaseBean.getMethod().equalsIgnoreCase("alarm_soundlist_get")
                                    ||transBaseBean.getMethod().equalsIgnoreCase("alarm_sound_get"))) {//
                        //解决NVR崩溃问题
                        baseBean.setCode(ParamUtil.errorCode2baseCode("-32001"));
                        ErrorBean errorBean = new ErrorBean();
                        errorBean.setErrorcode(Integer.parseInt(transBaseBean.getError().getErrorcode()));
                        errorBean.setMessage(stringBaseBean.getMsg());
                        baseBean.setData((T) errorBean);
                    }
                }
                return baseBean;
            }
        });
    }





    public <T> Observable<BaseBean<T>> sendPtzCmd(ApiService mApiService, RequestBody body, Class<T> t) {
        return mApiService.sendPtzCmd(body).map(new Function<BaseBean<String>, BaseBean<T>>() {
            @Override
            public BaseBean<T> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {

//                BaseBean<T> baseBean = new BaseBean<T>();
//                try {
//                    Gson gson = new Gson();
//                    TransBaseBean<T> transBaseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<TransBaseBean<T>>() {
//                    }.getType());
//                    baseBean.setCode(ParamUtil.errorCode2baseCode(transBaseBean.getError().getErrorcode()));
//                    baseBean.setMsg(stringBaseBean.getMsg());
//                    LogUtil.v("sendPtzCmd", "code=" + transBaseBean.getError().getErrorcode() + ";msg=" + stringBaseBean.getMsg());
//
//                    String jsonString = gson.toJson(transBaseBean.getResult());
//                    T bean = gson.fromJson(jsonString, t);
//                    baseBean.setData(bean);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }


                BaseBean<T> baseBean = new BaseBean<T>();

                try {
                    Gson gson = new Gson();


                    //请求成功，解析data，成功后继续解析error对象中的错误码
                    if (stringBaseBean.getCode().equalsIgnoreCase("1000")) {
                        TransBaseBean<T> transBaseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<TransBaseBean<T>>() {
                        }.getType());
                        baseBean.setCode(ParamUtil.errorCode2baseCode(transBaseBean.getError().getErrorcode()));
                        baseBean.setMsg(stringBaseBean.getMsg());
                        LogUtil.v("sendPtzCmd", "code=" + transBaseBean.getError().getErrorcode() + ";msg=" + stringBaseBean.getMsg());

                        String jsonString = gson.toJson(transBaseBean.getResult());
                        T bean = gson.fromJson(jsonString, t);
                        baseBean.setData(bean);

                    } else {//请求失败，不解析data，直接把错误码返回
                        baseBean.setCode(stringBaseBean.getCode());
                        baseBean.setMsg(stringBaseBean.getMsg());

                        ErrorBean errorBean = new ErrorBean();
                        errorBean.setErrorcode(Integer.parseInt(stringBaseBean.getCode()));
                        errorBean.setMessage(stringBaseBean.getMsg());
                        baseBean.setData((T) errorBean);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

                return baseBean;
            }
        });
    }


    //云台带token
    public <T> Observable<BaseBean<T>> sendPtzCmd2(ApiService mApiService, RequestBody body, Class<T> t) {
        return mApiService.sendPtzCmd(body).map(new Function<BaseBean<String>, BaseBean<T>>() {
            @Override
            public BaseBean<T> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {


//
//                Gson gson = new Gson();
//                TransBaseBean<T> transBaseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<TransBaseBean<T>>() {
//                }.getType());
//                BaseBean<T> baseBean = new BaseBean<T>();
//                baseBean.setCode(ParamUtil.errorCode2baseCode(transBaseBean.getError().getErrorcode()));
//                baseBean.setMsg(stringBaseBean.getMsg());
//                String jsonString = gson.toJson(transBaseBean.getResult());
//                T bean = gson.fromJson(jsonString, t);
//                baseBean.setData(bean);

                BaseBean<T> baseBean = new BaseBean<T>();
                try {
                    Gson gson = new Gson();

                    //请求成功，解析data，成功后继续解析error对象中的错误码
                    if (stringBaseBean.getCode().equalsIgnoreCase("1000")) {
                        TransBaseBean<T> transBaseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<TransBaseBean<T>>() {
                        }.getType());
                        baseBean.setCode(ParamUtil.errorCode2baseCode(transBaseBean.getError().getErrorcode()));
                        baseBean.setMsg(stringBaseBean.getMsg());

                        ErrorBean errorBean = new ErrorBean();
                        errorBean.setErrorcode(Integer.parseInt(transBaseBean.getError().getErrorcode()));
                        errorBean.setMessage(stringBaseBean.getMsg());
                        baseBean.setData((T) errorBean);

                    } else {//请求失败，不解析data，直接把错误码返回
                        baseBean.setCode(stringBaseBean.getCode());
                        baseBean.setMsg(stringBaseBean.getMsg());

                        ErrorBean errorBean = new ErrorBean();
                        errorBean.setErrorcode(Integer.parseInt(stringBaseBean.getCode()));
                        errorBean.setMessage(stringBaseBean.getMsg());
                        baseBean.setData((T) errorBean);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

                return baseBean;
            }
        });
    }




    //公有云透传命令新架构，base64编码数据
    public <T> Observable<BaseBean<T>> transCmdJesBase64(ApiService mApiService, RequestBody body, Class<T> t) {
        return mApiService.transCmd(body).map(new Function<BaseBean<String>, BaseBean<T>>() {
            @Override
            public BaseBean<T> apply(@NonNull BaseBean<String> stringBaseBean) throws Exception {
//                Gson gson = new Gson();

                Gson gson = new GsonBuilder().disableHtmlEscaping().create();
                TransBaseBean<T> transBaseBean = gson.fromJson(stringBaseBean.getData(), new TypeToken<TransBaseBean<T>>() {
                }.getType());
                BaseBean<T> baseBean = new BaseBean<T>();
                baseBean.setCode(stringBaseBean.getCode());
                baseBean.setMsg(stringBaseBean.getMsg());

                if (transBaseBean != null) {
                    baseBean.setCode(ParamUtil.errorCode2baseCode(transBaseBean.getError().getErrorcode()));
                    String jsonString = gson.toJson(transBaseBean.getResult());

                    LogUtil.e("okhttp","transBaseBean.getResult()="+jsonString);

                    JSONObject jsonObject = new JSONObject(jsonString);
                    String respData = jsonObject.getString("resp_data");


                    byte[] decodeByte = new byte[0];
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        decodeByte = Base64.getDecoder().decode(respData);
                    }else{
                        // 解码Base64字符串
                        decodeByte = android.util.Base64.decode(respData, android.util.Base64.DEFAULT);
                    }
                    String decodeString = new String(decodeByte);

                    LogUtil.e("okhttp","1.decodeString="+decodeString);
//                    {"package":"LPRSystem","method":"get_param","result":{"enable":1,"plate_width":0,"confidence":50,"det_mode":"filter","OSD":{"enable":1,"content":["plate_type","vehicle_type","vehicle_color","vehicle_orientation"],"position":{"x":0,"y":0},"color":"blue"},"display_region":1,"regions":[{"points":[]}]},"error":{"errorcode":0}}

//                    decodeString = decodeString.replace("\"package\"","\"packagex\"");
//
//                    LogUtil.e("okhttp","2.decodeString="+decodeString);


                    T bean = gson.fromJson(decodeString, t);
                    baseBean.setData(bean);

//                    if (!TextUtils.equals(transBaseBean.getError().getErrorcode(), "0") && null == bean) {
//
//                        ErrorBean errorBean = new ErrorBean();
//                        errorBean.setErrorcode(Integer.parseInt(transBaseBean.getError().getErrorcode()));
//                        errorBean.setMessage(stringBaseBean.getMsg());
//
//                        LogUtil.e("okhttp","stringBaseBean.getMsg()="+stringBaseBean.getMsg());
//                        baseBean.setData((T) errorBean);
//                    }

                    if (!TextUtils.equals(transBaseBean.getError().getErrorcode(), "0") && null == bean) {

                        ErrorBean errorBean = new ErrorBean();
                        errorBean.setErrorcode(Integer.parseInt(transBaseBean.getError().getErrorcode()));
                        errorBean.setMessage(stringBaseBean.getMsg());
                        baseBean.setData((T) errorBean);
                    } else if (TextUtils.equals(transBaseBean.getError().getErrorcode(), "0") && null == bean
                            && (transBaseBean.getMethod().equalsIgnoreCase("dev_trans_userparam"))) {//
                        //解决NVR崩溃问题
                        baseBean.setCode(ParamUtil.errorCode2baseCode("-32001"));
                        ErrorBean errorBean = new ErrorBean();
                        errorBean.setErrorcode(Integer.parseInt(transBaseBean.getError().getErrorcode()));
                        errorBean.setMessage(stringBaseBean.getMsg());
                        baseBean.setData((T) errorBean);
                    }


                }
                return baseBean;
            }
        });
    }
}

//
//    byte[] decodeByte = new byte[0];
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//                        decodeByte = Base64.getDecoder().decode(stringBaseBean.getData());
//                        }
//                        String decodeString = new String(decodeByte);
//
//                        LogUtil.e("okhttp","decodeString="+decodeString);