package com.jovision.netkit.mvp.net.rto_exception;

import android.content.Context;

/**
 * Created by ZHP on 2017/6/26.
 */

public class ErrorMessageFactory {

    public static String create(Context context, String code){

        String errorMsg = null ;

        /*switch (code){

            case BaseException.HTTP_ERROR:

                errorMsg =  context.getResources().getString(R.string.error_http);

                break;

            case BaseException.SOCKET_TIMEOUT_ERROR:

                errorMsg =  context.getResources().getString(R.string.error_socket_timeout);

                break;
            case BaseException.SOCKET_ERROR:

                errorMsg =  context.getResources().getString(R.string.error_socket_unreachable);

                break;


            case BaseException.ERROR_HTTP_400:

                errorMsg =  context.getResources().getString(R.string.error_http_400);

                break;


            case BaseException.ERROR_HTTP_404:

                errorMsg =  context.getResources().getString(R.string.error_http_404);

                break;

            case BaseException.ERROR_HTTP_500:

                errorMsg =  context.getResources().getString(R.string.error_http_500);

                break;

            case ApiException.ERROR_API_SYSTEM:
                errorMsg = context.getResources().getString(R.string.error_system);
                break;

            case ApiException.ERROR_API_ACCOUNT_FREEZE:
                errorMsg = context.getResources().getString(R.string.error_account_freeze);
                break;


            case ApiException.ERROR_API_NO_PERMISSION:
                errorMsg = context.getResources().getString(R.string.error_api_no_perission);
                break;

//            case ApiException.ERROR_API_LOGIN:
//                errorMsg = UIUtil.getString(R.string.error_login);
//                break;

            case ApiException.ERROR_TOKEN:
                errorMsg = context.getResources().getString(R.string.error_token);
                break;

            default:
                errorMsg=context.getResources().getString(R.string.error_unkown);
                break;


        }*/


        return  errorMsg;


    }
}
