package com.jovision.netkit.mvp.net.rto_exception;

/**
 * Created by ZHP on 2017/6/26.
 */

public class BaseException extends Exception {



    /************************************ 账号中心错误码 -start *************************************/

    //登录相关
    public static final int AC_USER_LOCK = 2227;//	user lock	账号被锁定
    public static final int AC_REALM_NOT_FOUND = 2001;//	realm not found	域不存在
    public static final int AC_USER_LOGIN_FAILED = 2202;//	user login failed	登录失败

    public static final int AC_USER_CAN_NOT_CANCEL = 2025;//	user can not cancel	用户不能注销

    public static final int AC_AUTH_CODE_ILLEGAL = 2208;//	auth code illegal	第三方授权码错误
    public static final int AC_SOCIAL_TYPE_ILLEGAL = 2224;//	social type illegal	错误的第三方登录类型
    public static final int AC_SOCIAL_TYPE_NOT_EXISTS_IN_REALM = 2004;//	social type not exists in realm	域未配置当前第三方登录方式
    public static final int AC_USER_NOT_EXIST = 2201;//	user not exist	用户不存在

    public static final String AC_STR_USER_NOT_EXIST = "2201";//	user not exist	用户不存在

    public static final String USER_SHARE_LOCK = "3052";// user share lock	用户分享锁定


    public static final int AC_TERMINAL_ERROR = 2229;//	user terminal error	终端异常
    public static final int AC_USER_NOT_BIND_SOCIAL_TYPE = 2207;//	user not bind social type	未绑定第三方
    public static final int AC_USER_IS_BLACK = 2230;//	user is black	黑名单用户
    public static final String STR_AC_USER_IS_BLACK = "2230";//	user is black	黑名单用户
    public static final int AC_ACCOUNT_ILLEGAL = 2225;//	account illegal	非法账号
    public static final int AC_PASSWORD_ILLEGAL = 2219;//	password illegal	密码格式错误
    public static final int AC_ACCOUNT_OR_PASSWORD_ERROR = 2231;//	account or password error	账户名货密码错误
    public static final int AC_VERIFY_CODE_INVALID = 2204;//	verify code invalid	验证码错误
    public static final int AC_AUTH_VALUE_INVALID = 2223;//	auth value invalid	授权码错误

    public static final int AC_BIND_PHONE_OR_MAIL = 2232;//	bind phone or mail该用户已绑定手机号或邮箱


    public static final int AC_PHONE_OR_MAIL_TO_BIND = 2233;//	phone or mail to bind手机号或邮箱已被绑定

    public static final int AC_THE_IP_LOCK = 2237;//	the ip lock  IP锁定

    public static final int AC_OPEN_ID_NOT_BIND_USER = 2240;//	openid 未绑定用户




    //发送验证码相关
    public static final int AC_REQUEST_ERROR = 1004;//Request Error	请求错误
    public static final int AC_INTERNAL_SERVER_ERROR = 500;//Internal server error	服务器异常
    public static final int AC_PARAM_FORMAT_ERROR = 1001;//Param Format Error	参数格式异常

    //注册相关
    public static final int AC_REGISTER_PASSwORD_ILLEGAL = 2219;//password illegal	密码格式错误
    public static final int AC_REGISTER_AUTH_VALUE_INVALID =2223;//auth value invalid	授权码错误
    public static final int AC_REGISTER_PHONE_EXIST = 2209;//phone exist	手机号已存在
    public static final int AC_REGISTER_MAIL_EXIST = 2210;//mail exist	邮箱已存在
    public static final int AC_REGISTER_SOCIAL_TYPE_NOT_EXISTS_IN_REALM = 2004;//social type not exists in realm	域未配置当前第三方登录方式
    public static final int AC_REGISTER_OPENID_HAS_BEEN_BOUND = 2222;//openid has been bound	openID已经被绑定


    public static final int AC_MODIFY_NEW_PASSWORD_SAME_TO_OLD = 2212;//new password same to old	新密码与旧密码相同

    public static final int AC_USER_ALREADY_BIND_THIS_SOCIAL_TYPE = 2234;//user already bind this socialtype	用户已绑定该第三方登录方式

    public static final int AC_SEND_VERIFY_FREQUENTLY = 2236;//send verify frequently	发送验证码频繁

    public static final int AC_APP_ALREADY_NEWEST = 2999;//	App已经是最新版本



    //AC ERRORCODE
    public static final String UNAUTHORIZED = "401";

    //账号中心token error code
    public static final String ACCESS_TOKEN_INVALID = "2301";
    public static final String ACCESS_TOKEN_OVERDUE = "2302";
    public static final String ACCOUNT_KICKED_OUT = "2206";//您的云视通账号已在其他地方登录，为保障账号安全，请重新登录

    //tiken失效
    public static final String REFRESH_TOKEN_INVALID = "2205";//已取消保存登录账号，请使用其他登录方式

//    public static final int AC_ACCESS_TOKEN_INVALID = 2301;//access token invalid  无效Access Token
//    public static final int AC_ACCESS_TOKEN_OVERDUE = 2302;//access token overdue  Access Token过期
//    public static final int AC_ACCESS_KICKED_OUT = 2206;//account kicked out  账号被踢退

//    public static final int AC_REGISTER_PASSwORD_ILLEGAL = 2219;//password illegal	密码格式错误
//    public static final int AC_REGISTER_AUTH_VALUE_INVALID =2223;//auth value invalid	授权码错误
//    public static final int AC_REGISTER_PHONE_EXIST = 2209;//phone exist	手机号已存在


    public static final int AC_MODIFY_PHONE_IS_EXIST = 2209;
    public static final int AC_MODIFY_MAIL_IS_EXIST = 2210;

    public static final int AC_OLD_PASSWORD_IS_WRONG = 2217;//	old password is wrong	原密码错误


    public static final int AC_OLD_AND_NEW_PASSWORDS_DIFFERENCE_LEAST2 = 2226;//	old and new passwords difference least 2	新老密码相差小于两个字符
    public static final int AC_PASSWORD_CAN_NOT_RELATION_TO_ACCOUNT = 2228;//	password can not relation to account	密码不能与账号或账号倒序相同


    /************************************ 账号中心错误码 -end ***************************************/








    public static final String ILLEGAL_REQUEST = "400";
    public static final String TOO_MANY_REQUEST = "429";
    public static final String INTERNAL_SERVER_ERROR = "500";
    public static final String PARAM_ERROR = "1001";
    public static final String OPEN_ID_EXISTS = "2016";//微信已被其他人绑定
    public static final String TERMINAL_NOT_EXISTS = "2017";//Terminal Not Exists	终端不存在(非安全终端)

    //Token Overdue,请求错误
    public static final String ERROR_TOKEN_OVER = "1004";

    //接口限制，验证码获取过于频繁Restricted call
    public static final String RESTRICTED_CALL = "1005";

    public static final String ERROR_TOKEN = "1006";
    //自己处理
    public static final String TOKEN_FAIL = "10010";

    public static final String SUCCEED = "1000";


    //二维码错误（原因：二维码状态不对，只有未扫描状态的二维码才可以扫描）
    public static final String INVALID_QRCODE = "2238";



    //设备已被自己绑定
    public static final String DEVICE_HAVE_BING = "3002";


    //设备已被他人绑定
    public static final String DEVICE_HAVE_BINED_BY_OTHER = "3048";


    //设备数量超过最大值
    public static final String DEVICE_OVER_MAX_COUNT = "3053";


    //分享二维码过期
    public static final String SHARE_QR_CODE_OVERDUE = "3054";


    //设备不存在
    public static final String DEVICE_NO_EXISTENCE = "3003";


    public static final String DEVICE_OUTLINE = "3004";//设备离线

    public static final String DEVICE_ID_ERROR = "3005";
    //设置相关
    public static final String DEVICE_NOT_BELONG_USER = "3007";//设备不属于该用户
    public static final String DEVICE_NOT_ABILITY = "3008";//设备能力不支持


    //云台相关
    public static final String PTZ_CONTROL_TOKEN_ERROR = "3012";//云台控制token过期或异常
    public static final String PTZ_MOVE_START_ERROR = "3013";//云台移动超时或异常
    public static final String DEVICE_USED_BY_OTHER = "3040";//设备已被别人占用

    //订单相关
    public static final String ORDER_NOT_EXISTS= "3042";//订单不存在
    public static final String ORDER_STATUS_ERROR= "3043";//订单状态错误
    public static final String CREATE_PAY_ORDER_FAILED= "3041";//生成支付单错误
    //云存相关
    public static final String CLOUD_STORAGE_PACKAGE_NOT_EXISTS= "3044";//订单不存在
    public static final String CLOUD_STORAGE_PACKAGE_NOT_BIND= "3051";//订单不存在

    //场景相关
    public static final String SCENE_QUANTITY_EXCEEDED= "3030";//用户的场景数量超限
    public static final String SCENE_NOT_BELONG_THIS_USER= "3029";//场景不属于该用户


    //共享相关
    public static final String MAX_FREE_SHARE_COUNT_LIMIT = "3031";
    public static final String CAN_NOT_SHARE_TO_SELF = "3038";


    public static final String SHARED_ACCOUNT_NOT_EXISTS = "3032";//2021.10.8此错误码不存在了，用账号中心的错误吗2021，被分享的用户不存在
    public static final String SHARE_EXISTS = "3033";
    public static final String SHARE_STATUS_ILLEGAL = "3034";
    public static final String CHANNELID_ERROR = "3009";
    public static final String PERMISSION_LIMITED = "3036";
    public static final String SHARE_NOT_EXISTS = "3037";
    public static final String SHARE_WAITING_TO_ACCEPT = "3056";

    // 远程运维相关
    public static final String REMOTE_OPERATION_CODE_ERROR = "3058";
    public static final String REMOTE_OPERATION_CODE_OVERDUE = "3059";
    public static final String REMOTE_OPERATION_CODE_ALREADY_OPERATION = "3073";
    public static final String REMOTE_OPERATION_CODE_APPLY_OVERDUE = "3074";
    public static final String REMOTE_OPERATION_CODE_APPLY_REPEAT = "3075";

    //设备转移
    public static final String DEVICE_TRANS_CODE_NOT_SELF = "3076";

    // 敏感词相关
    public static final String CONTAINS_SENSITIVE_WORDS = "3061";// 包含敏感词

    //用户相关errorcode
    public static final String ACCOUNT_EXISTS = "2001";
    public static final String PWD_INVALID = "2002";
    public static final String PWD_CAN_NOT_RELATION_TO_ACCOUNT = "2003";
    public static final String ACCOUNT_OR_PWD_IS_WRONG = "2004";
    public static final String ENCODE_PWD_ERROR = "2005";
    public static final String FAIL_TO_REGISTER_ACCOUNT = "2006";
    public static final String SAME_AS_OLD_OR_NEW_PWD = "2007";
    public static final String NEW_PWD_TOO_SAME = "2008";
    public static final String OLD_PWD_ERROR = "2009";
    public static final String ACCOUNT_NOT_EXISTS = "2010";
    public static final String ACCOUNT_INVALID = "2011";
    public static final String ACCOUNT_AUTH_CODE_ERROR = "2012";

    public static final String WEATHER_SERVICE_ERROR = "2022";

    //当用户登录、注册、或在登录中状态 使用APP中的功能时，调用服务检测到“租户已冻结”错误码，租户退至登录页面，并吐司提示：请求错误
    public static final String ACCOUNT_FREEZE_ERROR = "2029";

    public static final String ACCOUNT_IS_LOCKED = "4002";
    public static final String ACCOUNT_FROZEN = "4004";

    public static final String ACCOUNT_HAS_DEVICE_OR_SHARE = "2013";

    public static final String PHONE_BELONG_OTHER_ENTERPRISE = "2064";



    //sms
    public static final String VERIFICATION_CODE_ERROR = "6001";




    private String code;

    private String displayMessage;

    public BaseException() {
    }

    public BaseException(String code, String displayMessage) {
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public BaseException(String message, String code, String displayMessage) {
        super(message);
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}
