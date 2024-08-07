package com.jovision.netkit.mvp;
//adb shell "dumpsys window | grep mCurrentFocus"

import android.os.Environment;


import com.jovision.basekit.LogUtil;
import com.jovision.basekit.utilcode.Utils;

import java.io.File;

/**
 * Created by ZHP on 2017/6/24.
 */

public class Constant {

//    public static final String SERVER_PHONE_NUMBER = "400-608-9888";//中维客服电话
//    测试环境:https://tme-h5.test.vyiot.com/270404127274565749/{iccid}
//    生产环境:https://tme-h5.zmyiot.com/283722700600378019/{iccid}
//    https://tme-h5.test.vyiot.com/270404127274565749/{iccid}?token=xxxx&refreshToken=xxxxx
//    public static final String URL_4G_SERVER_TEST_ID = "270404127274565749";//测试环境商户id
//    public static final String URL_4G_SERVER_PRODUCT_ID = "283722700600378019";//生产环境商户id

    public static String currentAppLanguage = "zh-CN";
    //备案地址
    public static final String BEI_AN_URL = "https://beian.miit.gov.cn/";

    //中移动SDK信息
    public static final String WAP_APP_ID = "300012398071";
    public static final String WAP_APP_KEY = "DA8DD08D1D8D3997284113FF6479245D";


    //移动
    public static final String china_mobile_contract_url = "https://wap.cmpassport.com/uni-access/contactCm.html";

    //联通
    public static final String china_unicom_contract_url = "https://wap.cmpassport.com/uni-access/contactCu.html";

    //电信
    public static final String china_telecom_contract_url = "https://wap.cmpassport.com/uni-access/contactCt.html";



    public static final String SPLASH_AD_ID = "fa1798942ea175b2";
    public static final String SPLASH_HOT_AD_ID = "03284ca7388f001f";
    public static final String PLAY_BANNER_AD_ID = "26bad4ce292c7ccb";


    public static boolean IS_DEBUG = false;//调试模式

    public static boolean hasInitedLanSearch = false;//默认没有初始化

    public static final String APP_NAME = "CLOUDSEE";


    public static int hotSplashTimeInterval = 300;//热启动时间间隔，默认5分钟300s,单位秒


    public static boolean exitAdSwitch = false;//退出插屏广告开关  1：开启（true） 0：关闭（false）
    public static int exitAdInterval = 24;//退出插屏广告时间间隔，单位小时，默认24小时
    public static String exitAdId = "2b2a9b5f538746ec";//退出自渲染类型广告位ID

    public static String exitScreenAdsId = "6ef9d662803869ac";//退出插屏类型广告位ID
    public static int exitAdStyle = 2;//退出插屏广告样式，1:弹窗样式，2:插屏样式

    /**
     * 设备分享二维码的固定前缀
     */
    public static final String SHARE_DEVICE_TOKEN_PREFIX = "DEVICESHARE:";



    public static final String LOGIN_HEAD_PREFIX_6100 = "QRCODELOGIN_";//6100登陆二维码head

//    public static final String APP_LANGUAGE = "zh-CN";


    public static final String DATE_RFC3339 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    public static final String DATE_RFC333_1 = "yyyyMMddHHmmss";

//    public static HashMap<String,Double> callGainBeanMap = new HashMap<String,Double>();//对讲增益map

    //调取系统摄像头的请求码
    public static final int MY_ADD_CASE_CAMERA = 6;
    //打开相册的请求码
    public static final int MY_ADD_CASE_MY_ALBUM = 7;



////    收编app_k8s环境打包信息
////    saas地址：https://61.171.90.183:32000
////    账号中心地址：https://61.171.90.183:32000
////    租户id：beaa669b
////    realmID:214189344220210801160016
////    app客户端
////    clientID: 32265179420210807105522
//    /***********************************  收编app_k8s环境打包信息-s  ***********************************************/
//    private static final String ACCOUNT_CENTER_URL_TEST = "https://61.171.90.183:32000";//账号中心转测地址
//    private static final String SAAS_URL_RELEASE_TEST = "https://61.171.90.183:32000";//SAAS众测环境
//    public static final String SAAS_TRANSFER_TENANT_ID_DEV = "beaa669b";//SAAS开发环境 租户id
//
//    //账号中心常量
//    public static final String ACCOUNT_CENTER_URL = ACCOUNT_CENTER_URL_TEST;
//
//    public static final String realmID = "214189344220210801160016";
//    public static final String clientID = "32265179420210807105522";
//    public static final String clientSecret = "139356918720210807105628";//2022年3月3日开会去掉此字段
//    /***********************************  收编app_k8s环境打包信息-e  ************************************************/


    //(16)4G充值默认URL
    public static String H5_4G_RECHARGE_URL = "http://m2mwechat.iot-sohan.cn/m2m-wechat/wechatPay/wx/index?key=bQMwqNQ7yxFf9bUbDKPPgK4avKW9Ng6K";



//    /***********************************  美丽-众测环境-s  ***********************************************/
//    public static final Boolean zhongce = true;
//
//    public static final String URL_4G_CARD = "https://tme-h5.vqiot.com/283722700600378019/";//4G充值正式环境url
////    public static final String URL_4G_CARD = "https://tme-h5.test.vyiot.com/270404127274565749/";//4G充值测试环境url
//
//    private static final String ACCOUNT_CENTER_URL_TEST = "https://multitenantzoo.cloudsee.com:9999";//账号中心转测地址
//    //private static final String ACCOUNT_CENTER_URL_TEST = "http://61.171.71.100:9999";//账号中心转测地址
//    //private static final String SAAS_URL_RELEASE_TEST = "http://61.171.42.220:9999";//SAAS众测环境
//    private static final String SAAS_URL_RELEASE_TEST = "https://multitenantsaas.cloudsee.com:9999";//SAAS众测环境
//    public static final String SAAS_TRANSFER_TENANT_ID_DEV = "beaa669b";//SAAS开发环境 租户id
//    //
////    //账号中心常量
//    public static final String ACCOUNT_CENTER_URL = ACCOUNT_CENTER_URL_TEST;
//
//    public static final String realmID = "214189344220210801160016";
//    public static final String clientID = "32265179420210807105522";
//    public static final String clientSecret = "139356918720210807105628";//2022年3月3日开会去掉此字段
//
//
//    //(1)公有云NVR设置URL  http://saasrelease.cloudsee.com:9095/nvrSet
//    public static String H5_NVR_SET_URL = "http://multitenantapph5.cloudsee.com:9095/nvrSet?token=";
//    //(2)普通云存储购买URL  http://saasrelease.cloudsee.com:9095/cloudStorage
//    public static String H5_CLOUD_STORAGE_URL = "http://multitenantapph5.cloudsee.com:9095/cloudStorage";
//
//    //云存储续费管理
//    public static String H5_CLOUD_STORAGE_URL_RENEW_MANAGER = "http://multitenantapph5.cloudsee.com:9095/cloudStorage/renewManage?token=";
//
//    //订单列表
//    public static String H5_ORDER_LIST_URL = "http://multitenantapph5.cloudsee.com:9095/AlarmStorage/orderList?token=";
//
//    //(3)哭声宠物云存购买URL  http://saasrelease.cloudsee.com:9095/cryPetCloud
//    public static String H5_CRY_PET_CLOUD_URL = "http://multitenantapph5.cloudsee.com:9095/cryPetCloud";
//    //(4)NVR异常报警详情URL  http://saasrelease.cloudsee.com:9095/nvrAbnormalAlarm
//    public static String H5_NVR_ABNORMAL_ALARM_URL = "http://multitenantapph5.cloudsee.com:9095/nvrAbnormalAlarm?token=";
//    //(5)图形验证码URL  http://saasrelease.cloudsee.com:9095/verifyCode
//    public static String H5_VERIFY_CODE_URL = "http://multitenantapph5.cloudsee.com:9095/verifyCode";
//    //(6)广告个性化推荐URL  http://saasrelease.cloudsee.com:9095/adSet
//    public static String H5_AD_SET_URL = "http://multitenantapph5.cloudsee.com:9095/adSet?token=";
//    //(7)应用权限使用说明URL  http://saasrelease.cloudsee.com:9095/application
//    public static String H5_APP_PERMISSION_URL = "http://multitenantapph5.cloudsee.com:9095/application";
//    //(8)第三方信息共享清单URL  http://saasrelease.cloudsee.com:9095/thirdlyInfo
//    public static String H5_THIRDLY_PERMISSION_URL = "http://multitenantapph5.cloudsee.com:9095/thirdlyInfo";
//    //(9)异常报警解决方案URL 众测地址：http://saasrelease.cloudsee.com:9095/alarmSolution?token=
//    public static String H5_NVR_METHOD_OF_ABNORMAL_ALARM_URL = "http://multitenantapph5.cloudsee.com:9095/alarmSolution?token=";
//
//    //(10)众测地址：隐私协议 http://saasrelease.cloudsee.com:9095/privacyPolicy
//    public static String H5_PRIVACY_POLICY_URL = "http://multitenantapph5.cloudsee.com:9095/privacyPolicy";
//    //(11)众测地址：个人信息收集 http://saasrelease.cloudsee.com:9095/infoCollect?token=
//    public static String H5_PERSONAL_INFO_COLLECT_URL = "http://multitenantapph5.cloudsee.com:9095/infoCollect?token=";
//
//    //(12)哭声设置URL  http://saasrelease.cloudsee.com:9095/crySet
//    public static String H5_CRY_SET_URL = "http://multitenantapph5.cloudsee.com:9095/crySet?token=";
//    //(13)宠物设置URL  http://saasrelease.cloudsee.com:9095/petSet
//    public static String H5_PET_SET_URL = "http://multitenantapph5.cloudsee.com:9095/petSet?token=";
//
//    //(14)哭声状态URL  http://saasrelease.cloudsee.com:9095/crySet
//    public static String H5_CRY_STATUS_URL = "http://multitenantapph5.cloudsee.com:9095/cryDetectStatus?token=";
//    //(15)宠物状态URL  http://saasrelease.cloudsee.com:9095/petSet
//    public static String H5_PET_STATUS_URL = "http://multitenantapph5.cloudsee.com:9095/petDetectStatus?token=";
//
//    //(16)/AlarmStorage/index?token= 我的-报警云存储
//    public static String H5_ALARM_STORAGE_INDEX_URL = "http://multitenantapph5.cloudsee.com:9095/AlarmStorage/index?token=";
//    //(17)/AlarmStorage/cloudInfo?token= 购买云存介绍页
//    public static String H5_ALARM_STORAGE_CLOUD_INFO_URL = "http://multitenantapph5.cloudsee.com:9095/AlarmStorage/cloudInfo?token=";
//    //套餐库存
//    public static String H5_PACKAGE_INVENTORY = "http://multitenantapph5.cloudsee.com:9095/AlarmStorage/packageInventory?token=";
//    /***********************************  美丽-众测环境-e  ************************************************/





//    /***********************************  众测环境-s  ***********************************************/
//    public static final Boolean zhongce = true;
//
//    public static final String URL_4G_CARD = "https://tme-h5.vqiot.com/283722700600378019/";//4G充值正式环境url
////    public static final String URL_4G_CARD = "https://tme-h5.test.vyiot.com/270404127274565749/";//4G充值测试环境url
//
//    private static final String ACCOUNT_CENTER_URL_TEST = "https://accountrelease.cloudsee.com:9999";//账号中心转测地址
//    //private static final String ACCOUNT_CENTER_URL_TEST = "http://61.171.71.100:9999";//账号中心转测地址
//    //private static final String SAAS_URL_RELEASE_TEST = "http://61.171.42.220:9999";//SAAS众测环境
//    private static final String SAAS_URL_RELEASE_TEST = "https://saasrelease.cloudsee.com:9999";//SAAS众测环境
//    public static final String SAAS_TRANSFER_TENANT_ID_DEV = "beaa669b";//SAAS开发环境 租户id
////
////    //账号中心常量
//    public static final String ACCOUNT_CENTER_URL = ACCOUNT_CENTER_URL_TEST;
//
//    public static final String realmID = "214189344220210801160016";
//    public static final String clientID = "32265179420210807105522";
//    public static final String clientSecret = "139356918720210807105628";//2022年3月3日开会去掉此字段
//
//
//    //(1)公有云NVR设置URL  http://saasrelease.cloudsee.com:9095/nvrSet
//    public static String H5_NVR_SET_URL = "http://saasrelease.cloudsee.com:9095/nvrSet?token=";
//    //(2)普通云存储购买URL  http://saasrelease.cloudsee.com:9095/cloudStorage
//    public static String H5_CLOUD_STORAGE_URL = "http://saasrelease.cloudsee.com:9095/cloudStorage";
//
//    //云存储续费管理
//    public static String H5_CLOUD_STORAGE_URL_RENEW_MANAGER = "http://saasrelease.cloudsee.com:9095/cloudStorage/renewManage?token=";
//
//    //订单列表
//    public static String H5_ORDER_LIST_URL = "http://saasrelease.cloudsee.com:9095/AlarmStorage/orderList?token=";
//
//    //(3)哭声宠物云存购买URL  http://saasrelease.cloudsee.com:9095/cryPetCloud
//    public static String H5_CRY_PET_CLOUD_URL = "http://saasrelease.cloudsee.com:9095/cryPetCloud";
//    //(4)NVR异常报警详情URL  http://saasrelease.cloudsee.com:9095/nvrAbnormalAlarm
//    public static String H5_NVR_ABNORMAL_ALARM_URL = "http://saasrelease.cloudsee.com:9095/nvrAbnormalAlarm?token=";
//    //(5)图形验证码URL  http://saasrelease.cloudsee.com:9095/verifyCode
//    public static String H5_VERIFY_CODE_URL = "http://saasrelease.cloudsee.com:9095/verifyCode";
//    //(6)广告个性化推荐URL  http://saasrelease.cloudsee.com:9095/adSet
//    public static String H5_AD_SET_URL = "http://saasrelease.cloudsee.com:9095/adSet?token=";
//    //(7)应用权限使用说明URL  http://saasrelease.cloudsee.com:9095/application
//    public static String H5_APP_PERMISSION_URL = "http://saasrelease.cloudsee.com:9095/application";
//    //(8)第三方信息共享清单URL  http://saasrelease.cloudsee.com:9095/thirdlyInfo
//    public static String H5_THIRDLY_PERMISSION_URL = "http://saasrelease.cloudsee.com:9095/thirdlyInfo";
//    //(9)异常报警解决方案URL 众测地址：http://saasrelease.cloudsee.com:9095/alarmSolution?token=
//    public static String H5_NVR_METHOD_OF_ABNORMAL_ALARM_URL = "http://saasrelease.cloudsee.com:9095/alarmSolution?token=";
//
//    //(10)众测地址：隐私协议 http://saasrelease.cloudsee.com:9095/privacyPolicy
//    public static String H5_PRIVACY_POLICY_URL = "http://saasrelease.cloudsee.com:9095/privacyPolicy";
//    //(11)众测地址：个人信息收集 http://saasrelease.cloudsee.com:9095/infoCollect?token=
//    public static String H5_PERSONAL_INFO_COLLECT_URL = "http://saasrelease.cloudsee.com:9095/infoCollect?token=";
//
//    //(12)哭声设置URL  http://saasrelease.cloudsee.com:9095/crySet
//    public static String H5_CRY_SET_URL = "http://saasrelease.cloudsee.com:9095/crySet?token=";
//    //(13)宠物设置URL  http://saasrelease.cloudsee.com:9095/petSet
//    public static String H5_PET_SET_URL = "http://saasrelease.cloudsee.com:9095/petSet?token=";
//
//    //(14)哭声状态URL  http://saasrelease.cloudsee.com:9095/crySet
//    public static String H5_CRY_STATUS_URL = "http://saasrelease.cloudsee.com:9095/cryDetectStatus?token=";
//    //(15)宠物状态URL  http://saasrelease.cloudsee.com:9095/petSet
//    public static String H5_PET_STATUS_URL = "http://saasrelease.cloudsee.com:9095/petDetectStatus?token=";
//
//    //(16)/AlarmStorage/index?token= 我的-报警云存储
//    public static String H5_ALARM_STORAGE_INDEX_URL = "http://saasrelease.cloudsee.com:9095/AlarmStorage/index?token=";
//    //(17)/AlarmStorage/cloudInfo?token= 购买云存介绍页
//    public static String H5_ALARM_STORAGE_CLOUD_INFO_URL = "http://saasrelease.cloudsee.com:9095/AlarmStorage/cloudInfo?token=";
//    //套餐库存
//    public static String H5_PACKAGE_INVENTORY = "http://saasrelease.cloudsee.com:9095/AlarmStorage/packageInventory?token=";
//    /***********************************  众测环境-e  ************************************************/




    /***********************************  正式使用环境（生产环境）-s  ***********************************************/
    public static final Boolean zhongce = false;
    public static final String URL_4G_CARD = "https://tme-h5.vqiot.com/283722700600378019/";//4G充值生产环境url

    private static final String ACCOUNT_CENTER_URL_TEST = "https://account.cloudsee.com";//账号中心转测地址

    private static final String SAAS_URL_RELEASE_TEST = "https://saas.cloudsee.com";//SAAS生产环境

    public static final String SAAS_TRANSFER_TENANT_ID_DEV = "beaa669b";//SAAS开发环境 租户id

    //账号中心常量
    public static final String ACCOUNT_CENTER_URL = ACCOUNT_CENTER_URL_TEST;

    public static final String realmID = "118904614920220427211708";
    public static final String clientID = "194624552520220427211756";
    public static final String clientSecret = "139356918720210807105628";//2022年3月3日开会去掉此字段

    //(1)公有云NVR设置URL
    public static String H5_NVR_SET_URL = "http://apph5.cloudsee.com:9095/nvrSet?token=";
    //(2)普通云存储购买URL
    public static String H5_CLOUD_STORAGE_URL = "http://apph5.cloudsee.com:9095/cloudStorage";

    //云存储续费管理
    public static String H5_CLOUD_STORAGE_URL_RENEW_MANAGER = "http://apph5.cloudsee.com:9095/cloudStorage/renewManage?token=";
    //订单列表
    public static String H5_ORDER_LIST_URL = "http://apph5.cloudsee.com:9095/AlarmStorage/orderList?token=";
    //(3)哭声宠物云存购买URL
    public static String H5_CRY_PET_CLOUD_URL = "http://apph5.cloudsee.com:9095/cryPetCloud";
    //(4)NVR异常报警详情URL
    public static String H5_NVR_ABNORMAL_ALARM_URL = "http://apph5.cloudsee.com:9095/nvrAbnormalAlarm?token=";
    //(5)图形验证码URL
    public static String H5_VERIFY_CODE_URL = "http://apph5.cloudsee.com:9095/verifyCode";
    //(6)广告个性化推荐URL
    public static String H5_AD_SET_URL = "http://apph5.cloudsee.com:9095/adSet?token=";
    //(7)应用权限使用说明URL  http://apph5.cloudsee.com:9095/application
    public static String H5_APP_PERMISSION_URL = "http://apph5.cloudsee.com:9095/application";
    //(8)第三方信息共享清单URL  http://apph5.cloudsee.com:9095/thirdlyInfo
    public static String H5_THIRDLY_PERMISSION_URL = "http://apph5.cloudsee.com:9095/thirdlyInfo";
    //(9)异常报警解决方案URL 生产地址：http://apph5.cloudsee.com:9095/alarmSolution?token=
    public static String H5_NVR_METHOD_OF_ABNORMAL_ALARM_URL = "http://apph5.cloudsee.com:9095/alarmSolution?token=";
    //(10)生产地址：隐私协议 http://apph5.cloudsee.com:9095/privacyPolicy
    public static String H5_PRIVACY_POLICY_URL = "http://apph5.cloudsee.com:9095/privacyPolicy";
    //(11)生产地址：个人信息收集 http://apph5.cloudsee.com:9095/infoCollect?token=
    public static String H5_PERSONAL_INFO_COLLECT_URL = "http://apph5.cloudsee.com:9095/infoCollect?token=";

    //(12)哭声设置URL  http://apph5.cloudsee.com:9095/crySet
    public static String H5_CRY_SET_URL = "http://apph5.cloudsee.com:9095/crySet?token=";
    //(13)宠物设置URL  http://apph5.cloudsee.com:9095/petSet
    public static String H5_PET_SET_URL = "http://apph5.cloudsee.com:9095/petSet?token=";

    //(14)哭声状态URL  http://apph5.cloudsee.com:9095/crySet
    public static String H5_CRY_STATUS_URL = "http://apph5.cloudsee.com:9095/cryDetectStatus?token=";
    //(15)宠物状态URL  http://apph5.cloudsee.com:9095/petSet
    public static String H5_PET_STATUS_URL = "http://apph5.cloudsee.com:9095/petDetectStatus?token=";

    //(16)/AlarmStorage/index?token= 我的-报警云存储
    public static String H5_ALARM_STORAGE_INDEX_URL = "http://apph5.cloudsee.com:9095/AlarmStorage/index?token=";
    //(17)/AlarmStorage/cloudInfo?token= 购买云存介绍页
    public static String H5_ALARM_STORAGE_CLOUD_INFO_URL = "http://apph5.cloudsee.com:9095/AlarmStorage/cloudInfo?token=";
    //套餐库存
    public static String H5_PACKAGE_INVENTORY = "http://apph5.cloudsee.com:9095/AlarmStorage/packageInventory?token=";
    /***********************************  正式使用环境（生产环境）-e  ************************************************/


    //SAAS常量
    public static final String SAAS_URL = SAAS_URL_RELEASE_TEST;

    //写死的用户组id
    public static final String tenantId = SAAS_TRANSFER_TENANT_ID_DEV;




    //2.0协议设置服务器地址
    public static String WEB_SERVICE_URL = "";
    public static String BASE_URL = ACCOUNT_CENTER_URL;


    //token 续约
    public static final String refresh_token = "/v1/auth/renewal_token";

    public static final String xor_key = "xlYzvF0OfZhs3NzYIY2B27N2vGQ1zOZRmrAIJQFEHsiaUoT4YAGQzd1spf75Jtqs";//(2018.08.08开始使用)

    //账号中心 token 续约
    public static final String ac_refresh_token = "/v1/whale/api/realm/" + Constant.realmID + "/user/renewal";

    /**
     * 手机号码正则验证
     * 粗粒度验证.验证首位为1;第二位为3,4,5,6,7,8,9;长度为11位
     */
    public static final String PHONE_NUM_REGEX = "^1(3|4|5|6|7|8|9)[0-9]\\d{8}$";
    public static final String MAIL_REGEX = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";


    /************************************* 账号中心常量-start ***************************************/
//    public static String AC_SERVICE_ACCESS_TOKEN = "";//服务端访问凭证

    public static final String AC_LOGIN_BY_PASSWORD = "PASSWORD";//密码
    public static final String AC_LOGIN_BY_VERIFY_CODE = "VERIFY_CODE";//验证码
    public static final String AC_LOGIN_BY_SOCIAL = "SOCIAL";//第三方登录
    public static final String AC_LOGIN_BY_EASY_LOGIN = "EASY_LOGIN";//一键登录


    public static final String AC_LOGIN_BY_SOCIAL_WX = "WX";//微信
    public static final String AC_LOGIN_BY_SOCIAL_QQ = "QQ";//QQ
    public static final String AC_LOGIN_BY_SOCIAL_IOS = "IOS";//苹果

    public static final String AC_SOCIAL_BIND = "BIND";//第三方绑定
    public static final String AC_SOCIAL_UNBIND = "UNBIND";//第三方解绑

    public static final String AC_SEND_BY_MAIL = "MAIL";//邮箱
    public static final String AC_SEND_BY_PHONE = "PHONE";//手机

//    验证码类型 LOGIN-用户注册或登录 RESET-重置密码 CANCEL-注销账号 CHANGE-修改手机号TRANSFER-设备转移 SOCIAL-第三方第三方绑定

    public static final String AC_VERIFY_CODE_LOGIN = "LOGIN";//LOGIN-用户注册或登录
    public static final String AC_VERIFY_CODE_RESET = "RESET";//RESET-重置密码
    public static final String AC_VERIFY_CODE_CANCEL = "CANCEL";//CANCEL-注销账号
    public static final String AC_VERIFY_CODE_CHANGE = "CHANGE";//CHANGE-修改手机号
    public static final String AC_VERIFY_CODE_TRANSFER = "TRANSFER";//TRANSFER-设备转移
    public static final String AC_VERIFY_CODE_SOCIAL = "SOCIAL";//SOCIAL-第三方第三方绑定

    /************************************** 账号中心常量-end ****************************************/


    /************************************** 设备相关常量-start **************************************/

    // 枚举: 激活状态
    public static final int ACTIVE_NOT_NEED = 0;//不需要激活，云视通1.0搜索、2.0老广播协议和2.0点对点搜索
    public static final int ACTIVED = 1;//已激活，云视通2.0新广播协议
    public static final int NOT_ACTIVED = 2;//未激活，云视通2.0新广播协议

    //枚举: ONLINE：在线,OFFLINE：离线,UNREGISTERED：未注册
    public static final String ONLINE = "ONLINE";
    public static final String OFFLINE = "OFFLINE";
    public static final String UNREGISTERED = "UNREGISTERED";

    public static final String INIT = "INIT";//初始分享(未分享)
    public static final String SHARING = "SHARING";//SHARING：分享中
    public static final String SHARED = "SHARED";//SHARED：被分享

    public static final String OPEN = "OPEN";//云存开启
    public static final String CLOSE = "CLOSE";//云存关闭


    //枚举: PUBLICCLOUD：公有云协议,GB：国标协议,CLOUDSEE1：云视通1.0,CLOUDSEE2：云视通2.0
    public static final String PUBLICCLOUD = "PUBLICCLOUD";
    public static final String GB = "GB";
    public static final String CLOUDSEE1 = "CLOUDSEE1";
    public static final String CLOUDSEE2 = "CLOUDSEE2";


    //枚举: IPC,NVR,IPDOME,DVR,HOME_IPC,JNVR,CARD
    public static final String IPC = "IPC";
    public static final String NVR = "NVR";
    public static final String IPDOME = "IPDOME";
    public static final String DVR = "DVR";
    public static final String HOME_IPC = "HOME_IPC";
    public static final String JNVR = "JNVR";
    public static final String CARD = "CARD";


    //人脸报警类型常量
    public static final String STR_FACE_DET = "FaceDet"; //	检测到人脸报警
    public static final String STR_MASK_DET = "MaskDet";        // 戴口罩报警
    public static final String STR_NO_MASK_DET = "NoMaskDet";            // 不戴口罩报警
    public static final String STR_NONE = "NONE"; //	不支持


    /************************************** 设备相关常量-start **************************************/


    //固定int值
    public static final int streamId = 1;//默认1标清,0高清
    public static final int requestCode = 1;
    public static final int resultCode = 1;

    //key值
    public static final String FINGER_ON = "FINGER_ON";//指纹开关
    public static final String FINGER_FIRST = "FINGER_FIRST";//第一次打开指纹
    public static final String FINGER_STATUS = "FINGER_STATUS";//指纹状态
    public static final String userParts = "userParts";//切换账号时，此缓存清除
    public static final String userCacheParts = "userCacheParts";//切换账号时，此缓存不清除
    public static final String contractorParts = "contractorParts";//工程商认证，切换账号时，清除缓存
    public static final String playParts = "playParts";
    public static final String isFirstOpen = "isFirstOpen";
    public static final String isFirstShowAgreement = "isFirstShowAgreement";//首次使用App显示隐私政策
    public static final String showAppUpdateDate = "showAppUpdateDate";//显示App升级的日期
    public static final String isFirstShowFingerTip = "isFirstShowFingerTip";//首次使用指纹开启提示
    public static final String IS_EASY_LOGIN = "isEasyLogin";//是否是一键登录


    public static final String newUserAddDevGuid = "newUserAddDevGuid";//添加设备场景新手引导
    public static final String newUserServiceGuid = "newUserServiceGuid";//服务移动到我的新手引导
    public static final String newUserPlayDoubleClickGuid = "newUserPlayDoubleClickGuid";//播放界面双击变单屏新手引导
    public static final String newUserCallPtzGuid = "newUserCallPtzGuid";//播放界面功能按钮新手引导
    public static final String newUserPlayBackGuid = "newUserPlayBackGuid";//远程回放新手引导
    public static final String newUserJVPlayBackGuid = "newUserJVPlayBackGuid";//云视通设备回放新手引导
    public static final String newUserMyGuid = "newUserMyGuid";//我的页面新手引导
    public static final String newUserOsdDragGuid = "newUserOsdDragGuid";//OSD设置拖动操作新手引导
    public static final String newUserGunBallPlay = "newUserGunBallPlay";//枪球联动实时视频新手引导
    public static final String newUserGunBallPlayback = "newUserGunBallPlayback";//枪球联动回放新手引导
    public static final String newUserProductH5Guide = "newUserProductH5Guide";//定制H5页面新手引导
    public static final String newUserNetworkDisconnect = "newUserNetworkDisconnect";//是否断过网

    public static final String permission = "close";
    public static final String id = "id";
    public static final String accessProtocol = "accessProtocol";
    public static final String deviceCt = "deviceCt";
    public static final String deviceVc = "deviceVc";
    public static final String showDownQrImage = "showDownQrImage";
    public static final String deviceNickName = "deviceNickName";
    public static final String deviceName = "deviceName";
    public static final String channelName = "channelName";
    public static final String main = "page";
    public static final String web = "url";
    public static final String web_title = "web_title";
    public static final String firstIn = "first";
    public static final String needMoveData = "needMoveData";
    public static final String agreeConstract = "agreeConstract";
    public static final String msgSwitchNoWarn = "msgSwitchNoWarn";
    public static final String flowTips = "flowTips";
    public static final String userDefaultAvatar = "userDefaultAvatar";
    public static final String position = "position";
    public static final String type = "type";
    public static final String data = "data";
    public static final String from = "from";
    public static final String title = "title";
    public static final String object = "object";
    public static final String user = "user";
    public static final String phone = "phone";
    public static final String money = "money";
    public static final String userId = "userId";
    public static final String commodity = "commodity";
    public static final String url = "url";
    public static final String inviteUrl = "inviteUrl";
    public static final String inviteFrontName = "inviteFrontName";
    public static final String inviteBehindName = "inviteBehindName";
    public static final String courseName = "courseName";
    public static final String floatFlag = "open";
    public static final String floatStatus = "floatStatus";
    public static final String seek = "seek";
    public static final String service_data = "service_data";
    public static final String hideFloat = "hideFloat";
    public static final String notify = "notify";
    public static final String deviceSn = "deviceSn";
    public static final String channelId = "channelId";
    public static final String deviceType = "deviceType";
    public static final String push_token = "push_token";

    public static final String push_key = "message_key";

    public static final String messageType = "messageType";
    public static final String ability = "ability";
    public static final String isBulletDemoDevice = "isBulletDemoDevice";
    public static final String scenePathGun = "scenePathGun";
    public static final String scenePathBall = "scenePathBall";

    public static final String imageUrl = "imageUrl";
    public static final String changjing_imageUrl = "changjing_imageUrl";


    public static final String IS_DEVICE_REMOTE_MESSAGE = "mIsDeviceRemoteMessage";
    public static final String IS_DEVICE_SHARE_MESSAGE = "mIsDeviceShareMessage";

    //场景图开关
    public static final String FUNC_SCENE_SWITCH = "scene_switch";

    //回声抑制开关
    public static final String FUNC_ECHO_SWITCH = "echo_switch";

    //云台速度缓存
    public static final String FUNC_PTZ_SPEED = "play_ptz_speed_dev_";
    public static final String mobileNetTip = "mobileNetTip";//移动网络提醒
    //是否开启双击使用云台3D定位功能（不使用）
    public static final String FUNC_PTZ_3D_LOCATE = "func_ptz_3d_locate";


    public static final String PLAY_BEAN_LIST = "play_bean_list";
    public static final String PLAY_DEVICE = "play_device";
    public static final String SELECT_NO = "select_no";
    public static final String SPAN_COUNT = "span_count";
    public static final String DEVICE_LIST = "device_list";
    public static final String DEVICE_TYPE = "device_type";
    public static final String CHANNEL = "channel";
    public static final String PLAY_BACK_ITEM = "play_back_item";
    public static final String PHOTO = "photo";
    public static final String VIDEO = "video";
    public static final String DEVICE_SHARE = "shareNumber";
    public static final String DEVICE_SHARE_NAME = "device_share_name";
    public static final String DEVICE_SHARE_ACCOUNT = "device_share_account";
    public static final String DEVICE_SHARE_PERMISSION = "device_share_permission";
    public static final String DEVICE_SHARE_STATUS = "device_share_status";
    public static final String DEVICE_ONE_KEY_CONNECT = "device_one_key_connect";//预览全部通道

    /*推送通知设置*/
    public static final String PUSH_SETTINGS = "push_settings";
    public static final String IS_NOTICE_VOICE_OPEN = "is_notice_voice_open";//设置声音的开启
    public static final String IS_NOTICE_SHOCK_OPEN = "is_notice_shock_open";//设置震动的开启


    public static final String LOGIN_USERNAME = "login_user_name";//登录的用户名
    // 本地存储user列表key
    public static final String LOCAL_USER_LIST = "LOCAL_USER_LIST";

    /**
     * 广播
     **/
    public static final String CONNECTIVITY_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";

    /**
     * 媒体类型
     */
    public static final String IMAGE_PNG_KIND = ".png";// 图片类型
    public static final String IMAGE_JPG_KIND = ".jpg";// 图片类型
    public static final String VIDEO_MP4_KIND = ".mp4";// 视频类型
    public static final String VIDEO_M3U8_KIND = ".m3u8";// 视频类型


    /**
     * 程序中用到的路径
     */

    //用户不可见-应用专属外部存储空间
    public static String appSpecificExternalDir = "";

    //用户可见-应用卡存储空间
    public static String SD_CARD_PATH = Environment.getExternalStorageDirectory().getPath() + File.separator;


    //用户实际使用的存储位置，11以下还是存储卡位置，11以上是Android系统文件夹
    public static String USER_FILE_SAVE_PATH = Environment.getExternalStorageDirectory().getPath() + File.separator;


//    public static String LOG_PATH_DISMISS = USER_FILE_SAVE_PATH + APP_NAME
//            + File.separator + ".log" + File.separator;
//    public static String LOG_CLOUD_PATH_DISMISS = USER_FILE_SAVE_PATH + APP_NAME
//            + File.separator + ".logcloud" + File.separator;
//    public static String LOG_PUSH_PATH_DISMISS = USER_FILE_SAVE_PATH + APP_NAME
//            + File.separator + ".logpush" + File.separator;
//    public static String LOG_PATH_SHOW = USER_FILE_SAVE_PATH + APP_NAME
//            + File.separator + "log" + File.separator;
//    public static String LOG_CLOUD_PATH_SHOW = USER_FILE_SAVE_PATH + APP_NAME
//            + File.separator + "logcloud" + File.separator;
//    public static String LOG_PUSH_PATH_SHOW = USER_FILE_SAVE_PATH + APP_NAME
//            + File.separator + "logpush" + File.separator;

    public static String APP_SOUND_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator;

    public static String APP_LOG_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "logapp" + File.separator;

    public static String LOG_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "log" + File.separator;
    public static String LOG_CLOUD_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "logcloud" + File.separator;
    public static String LOG_PUSH_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "logpush" + File.separator;
    //JNA推送log路径
    public static String JNA_PATH_LOG = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "logjna" + File.separator;

    public static String AP_CA_PATH = USER_FILE_SAVE_PATH + APP_NAME + File.separator + "ca";

    // 发现h5页面下载路径
    public static String DISCOVER_DOWNLOAD_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "discover" + File.separator;
    // 发现h5页面下载图片路径
    public static String DISCOVER_IMAGE_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "discoverimage" + File.separator;
    // 发现h5页面下载视频路径
    public static String DISCOVER_VIDEO_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "discovervideo" + File.separator;
    // app升级app下载路径
    public static String APP_DOWNLOAD_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "appversion" + File.separator;
    // 加密图片下载后保存的路径
    public static String IMAGE_ENCRYPT_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "encrypt" + File.separator;
    // 解密图片下载后保存的路径
    public static String IMAGE_DECRYPT_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "decrypt" + File.separator;
    //告警消息从设备上取到图片放在本地的缓存路径
    public static String IMAGE_DEVICE_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "device" + File.separator;
    //产品页面
    public static String PRODUCT_DOWNLOAD_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "product" + File.separator;
    // 发现h5页面下载图片路径
    public static String PRODUCT_IMAGE_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "productimage" + File.separator;
    // 发现h5页面下载视频路径
    public static String PRODUCT_VIDEO_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "productvideo" + File.separator;

    // 小维不用此路径
    public static String AD_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "ad" + File.separator;

    /**
     * 图片移动到相册专用目录
     * 外部目录，非系统目录
     * 允许相册访问到
     */
//    public static String CAPTURE_ALBUM_PATH = USER_FILE_SAVE_PATH + APP_NAME
//            + File.separator + "album" + File.separator;

    public static String CAPTURE_ALBUM_VIDEO_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "video" + File.separator;

    public static String CAPTURE_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "capture" + File.separator;


    /*所有的录像文件放在此目录下 文件命名规则 video_yyyy-MM-dd-HH-mm-ss_yyyy-MM-dd-HH-mm-ss.mp4*/
    public static String VIDEO_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "video" + File.separator;




    public static String OLD_DOWNLOAD_CAPTURE_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "downcapture" + File.separator;
    public static String OLD_DOWNLOAD_VIDEO_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "downvideo" + File.separator;






    //存储下载录像文件专用，请谨慎使用 文件命名规则 playback_yyyy-MM-dd-HH-mm-ss_yyyy-MM-dd-HH-mm-ss.mp4
    public static String DOWNLOAD_VIDEO_PATH = USER_FILE_SAVE_PATH
            + APP_NAME + File.separator + "playback" + File.separator;

    public static String BEAUTY_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "beauty" + File.separator;

    public static String DOWNLOAD_IMAGE_PATH = USER_FILE_SAVE_PATH
            + APP_NAME + File.separator + "downimage" + File.separator;

    public static String HEAD_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "head" + File.separator;
    public static String WELCOME_IMG_PATH = USER_FILE_SAVE_PATH
            + APP_NAME + File.separator + "welcome" + File.separator;
    public static String SCENE_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "scene" + File.separator;
    public static String BBSIMG_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "bbsimage" + File.separator;
    public static String AVATAR_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "avatar" + File.separator;
    public static String CERTIFICATE_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "certificate" + File.separator;

    // 云存储边下载边播放ts,m3u8文件路径
    public static String CLOUD_VIDEO_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "cloudvideo" + File.separator;
    // 云存储报警图片路径
    public static String CLOUD_IMAGE_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "cloudimage" + File.separator;


    public static String VOICE_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "voice" + File.separator;
    public static String SNAP_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "snap" + File.separator;

    public static String ALARM_SOUND = USER_FILE_SAVE_PATH + "alarmsound" + File.separator;
    public static String ALARMING_SOUND = USER_FILE_SAVE_PATH + "alarmingsound" + File.separator;

    // 共享设备-二维码图片保存路径
    public static String QR_CODE_SHARE_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "qrcodeshare" + File.separator;

    // 远程运维识别码图片保存路径
    public static String REMOTE_OPS_CODE_SHARE_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "remoteOpsCodeshare" + File.separator;

    // 设置OSD配置时抓取的场景图保存路径. 场景图文件夹下的osd文件夹
    public static String SCENE_OSD_PATH = SCENE_PATH + "osd" + File.separator;

    /************************  云视通2.0 人脸识别用-start *******************************************/
    public static String DOWNLOAD_CAPTURE_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "downcapture" +
            File.separator;
    //远程回放图片回放下载缓存地址
    public static String DOWNLOAD_CAPTURE_CACHE_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "downcapturecache" +
            File.separator;
    //人脸识别图片缓存地址
    public static String DOWNLOAD_FACERCG_CACHE_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "facercgcache" +
            File.separator;
    // 自定义报警音路径
    public static String ALARMING_SOUND_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "alarmingsound" + File.separator;

    //    智能算法
    public static String SMART_APP_PATH = USER_FILE_SAVE_PATH + APP_NAME
            + File.separator + "smartapp" + File.separator;
    /**************************  云视通2.0 人脸识别用-end *******************************************/


    //星期字符串
    public static final String MON = "MON";
    public static final String TUE = "TUE";
    public static final String WEN = "WEN";
    public static final String THU = "THU";
    public static final String FRI = "FRI";
    public static final String SAT = "SAT";
    public static final String SUN = "SUN";

    /**
     * @param folderPathStr
     */
    public static void initFolders(String folderPathStr) {
        CAPTURE_PATH = folderPathStr + "capture" + File.separator;
//
//        LOG_PATH_DISMISS = folderPathStr + ".log" + File.separator;
//        LOG_CLOUD_PATH_DISMISS = folderPathStr + ".logcloud" + File.separator;
//        LOG_PUSH_PATH_DISMISS = folderPathStr + ".logpush" + File.separator;
//        LOG_PATH_SHOW = folderPathStr + "log" + File.separator;
//        LOG_CLOUD_PATH_SHOW = folderPathStr + "logcloud" + File.separator;
//        LOG_PUSH_PATH_SHOW = folderPathStr + "logpush" + File.separator;
        APP_LOG_PATH = folderPathStr + "logapp" + File.separator;

        LogUtil.init(APP_LOG_PATH);

        LOG_PATH = folderPathStr + "log" + File.separator;
        LOG_CLOUD_PATH = folderPathStr + "logcloud" + File.separator;
        LOG_PUSH_PATH = folderPathStr + "logpush" + File.separator;

        // 发现H5页面文件下载路径
        DISCOVER_DOWNLOAD_PATH = folderPathStr + "discover" + File.separator;
        // 发现H5页面文件下载路径
        DISCOVER_IMAGE_PATH = folderPathStr + "discoverimage" + File.separator;
        // 发现H5页面文件下载路径
        DISCOVER_VIDEO_PATH = folderPathStr + "discovervideo" + File.separator;
        // app升级app下载路径
        APP_DOWNLOAD_PATH = folderPathStr + "appversion" + File.separator;
        // 加密图片下载后保存的路径
        IMAGE_ENCRYPT_PATH = folderPathStr + "encrypt" + File.separator;
        // 解密图片下载后保存的路径
        IMAGE_DECRYPT_PATH = folderPathStr + "decrypt" + File.separator;
        //告警消息从设备上取到图片放在本地的缓存路径
        IMAGE_DEVICE_PATH = folderPathStr + "device" + File.separator;
        //产品H5
        PRODUCT_DOWNLOAD_PATH = folderPathStr + "product" + File.separator;
        // 发现H5页面文件下载路径
        PRODUCT_VIDEO_PATH = folderPathStr + "productvideo" + File.separator;
        // 发现H5页面文件下载路径
        PRODUCT_IMAGE_PATH = folderPathStr + "productimage" + File.separator;


        JNA_PATH_LOG = folderPathStr + "logjna" + File.separator;

        AP_CA_PATH = folderPathStr + "ca";

        // 小维不用此路径
        AD_PATH = folderPathStr + "ad" + File.separator;

        /**
         * 图片移动到相册专用目录
         * 外部目录，非系统目录
         * 允许相册访问到
         */
//        CAPTURE_ALBUM_PATH = folderPathStr + "album" + File.separator;

        CAPTURE_ALBUM_VIDEO_PATH = folderPathStr + "video" + File.separator;

        CAPTURE_PATH = folderPathStr + "capture" + File.separator;

        /*所有的录像文件放在此目录下 文件命名规则 video_yyyy-MM-dd-HH-mm-ss_yyyy-MM-dd-HH-mm-ss.mp4*/
        VIDEO_PATH = folderPathStr + "video" + File.separator;


        OLD_DOWNLOAD_CAPTURE_PATH = folderPathStr + "downcapture" + File.separator;
        OLD_DOWNLOAD_VIDEO_PATH = folderPathStr + "downvideo" + File.separator;



        //存储下载录像文件专用，请谨慎使用 文件命名规则 playback_yyyy-MM-dd-HH-mm-ss_yyyy-MM-dd-HH-mm-ss.mp4
        DOWNLOAD_VIDEO_PATH = folderPathStr + "playback" + File.separator;

        BEAUTY_PATH = folderPathStr + "beauty" + File.separator;

        DOWNLOAD_IMAGE_PATH = folderPathStr + "downimage" + File.separator;

        HEAD_PATH = folderPathStr + "head" + File.separator;
        WELCOME_IMG_PATH = folderPathStr + "welcome" + File.separator;
        SCENE_PATH = folderPathStr + "scene" + File.separator;
        BBSIMG_PATH = folderPathStr + "bbsimage" + File.separator;

//        AVATAR_PATH = folderPathStr + "avatar" + File.separator;
        File rootFile = new File(Utils.getApp().getExternalFilesDir(null).getPath());
        rootFile.mkdirs();
        //应用专属外部存储空间
        AVATAR_PATH = rootFile.getAbsolutePath() + File.separator + "avatar" + File.separator;

        CERTIFICATE_PATH = folderPathStr + "certificate" + File.separator;

        // 云存储边下载边播放ts,m3u8文件路径
        CLOUD_VIDEO_PATH = folderPathStr + "cloudvideo" + File.separator;
        // 云存储报警图片路径
        CLOUD_IMAGE_PATH = folderPathStr + "cloudimage" + File.separator;


        VOICE_PATH = folderPathStr + "voice" + File.separator;
        SNAP_PATH = folderPathStr + "snap" + File.separator;

        ALARM_SOUND = folderPathStr + "alarmsound" + File.separator;
        ALARMING_SOUND = folderPathStr + "alarmingsound" + File.separator;

        DOWNLOAD_CAPTURE_PATH = folderPathStr + "downcapture" +
                File.separator;
        DOWNLOAD_CAPTURE_CACHE_PATH = folderPathStr + "downcapturecache" +
                File.separator;
        // 共享设备-二维码图片保存路径
        QR_CODE_SHARE_PATH = folderPathStr + "qrcodeshare" + File.separator;
        // 远程运维识别码图片保存路径
        REMOTE_OPS_CODE_SHARE_PATH = folderPathStr + "remoteOpsCodeshare" + File.separator;
        // 设置OSD配置时抓取的场景图保存路径. 场景图文件夹下的osd文件夹
        SCENE_OSD_PATH = SCENE_PATH + "osd" + File.separator;
    }


    // 抓拍声音 文件存放位置 capture sound fileName
    public static final String CAPTURE_SOUND_FILE = "capture" + File.separator + "capture.wav";

    public static class Account {
        public static final String AccountInfo = "account_info";
    }

    public static int RECORD_VIDEO_MIN_LENGTH = 5000;//录制视频，最少5秒，单位是ms
    public static int SHARE_VIDEO_MAX_LENGTH = 300000;//最大支持分享5分钟视频，单位是ms
    public static int SHARE_VIDEO_MAX_SIZE = 25 * 1024 * 1024;//最大支持分享25M视频


    public static final String AP_HEAD_STR = "IPC-T-";
    public static final String AP_WIFI_PASSWORD = "12345678";


    //服务-售后服务-设备密码重置
    public static final String TAB_SERVICE_RESET_PWD_URL = "http://tmppwd.jovision.com/tmppwd/index";
    //服务-售后服务-设备自助解绑
    public static final String TAB_SERVICE_UNBIND_URL = "http://cunbind.jovetech.com:18018/#/";

    /**
     * TODO Tab 页 2017/04/19
     */
    // 商城模块默认的地址
    public static final String TAB_SHOP_URL = "https://wap.koudaitong" +
            ".com/v2/feature/qrmaa229";
    //已通知有赞将client_id与原来的UA绑定，初始化使用老版本UA即可，登录使用更新的client_id;
    public static final String YOUZAN_CLIENT_UA = "e2fe945637069c4d441468294477630";//老版本唯一标识
    public static final String YOUZAN_CLIENT_ID = "5cd3a980894b0ead58";//新版本唯一标识
    public static final String YOUZAN_CLIENT_SECRET = "246a78227366b96b2c27b086395b2186";

    public static final String TAB_SHOP_UA = YOUZAN_CLIENT_ID;
    public static final String TAB_SHOP_LOGIN =
            "http://xwip.cloudsee.net/youzan/login?client_id="
                    + TAB_SHOP_UA
                    + "&client_secret="
                    + YOUZAN_CLIENT_SECRET
                    + "&open_user_id=%s";
    public static final String TAB_SHOP_LOGOUT =
            "http://xwip.cloudsee.net/youzan/logout?client_id="
                    + TAB_SHOP_UA
                    + "&client_secret="
                    + YOUZAN_CLIENT_SECRET
                    + "&open_user_id=%s";
    public static final String TAB_SHOP_INITTOKEN =
            "http://xwip.cloudsee.net/youzan/initToken?client_id="
                    + TAB_SHOP_UA
                    + "&client_secret="
                    + YOUZAN_CLIENT_SECRET
                    + "&open_user_id=%s";


    //广告
    // 腾讯广点通中应用的ID
    public static final String mQQId = "1105057785";
    // 腾讯广点通横幅广告ID
    public static final String mQQBannerId = "7041908973204074";
    // 腾讯广点通开屏广告ID
    public static final String mQQSplashId = "8001501121102851";

    // 穿山甲广告AppId
    public static final String mCSJAppId = "5046169";
    // 穿山甲插屏广告id
    public static final String mCSJChapingAdId = "947055707";
    // 穿山甲开屏广告id
    public static final String mCSJSplashAdId = "887474534";

    // 百度开屏广告id
    public static final String mBaiduSplashAdId = "7569372";

    // 美术广告AppId
    public static final String mMeishuAppId = "105215";
    // 美术开屏广告Id
    public static final String mMeishuSplashAdId = "1032638";

    // 早早广告AppId
    public static final String mZaozaoAppId = "A1001003";
    // 早早开屏广告id
    public static final String mZaozaoSplashAdId = "D1001011";

    // 倍孜广告AppId
    public static final String mBeiziAppId = "20688";
    // 倍孜开屏广告id
    public static final String mBeiziSplashAdId = "104565";

    //新增一键呼叫报警类型：active_call
//    public static final String ALARM_ACTIVE_CALL = "active_call";
    public static final String ALARM_ACTIVE_CALL = "MOTION_DETECTION";


    //整点报时模式-白天模式
    public static final String DAY_MODE = "DAYMODE";
    //整点报时模式-夜晚模式
    public static final String NIGHT_MODE = "NIGHTMODE";
    //整点报时模式-自定义模式
    public static final String CUSTOM_MODE = "CUSTOMMODE";

    //定时静音配置模式-全天模式
    public static final String ALARM_SOUND_MODE_EVERYDAY = "EVERYDAY";
    //定时静音配置模式-工作如模式
    public static final String ALARM_SOUND_MODE_WORKDAY = "WORKDAY";
    //定时静音配置模式-休息日模式
    public static final String ALARM_SOUND_MODE_WEEKEND = "RESTDAY";
    //定时静音配置模式-自定义模式
    public static final String ALARM_SOUND_MODE_CUSTOM = "CUSTOMMODE";




    //normal-正常 unformated-未格式化 formating-正在格式化, using-使用中，none-不存在，full-容量满，idle-空闲准备就绪
    public static final String STORAGE_STATUS_NORMAL = "normal";//正常
    public static final String STORAGE_STATUS_FORMATING = "formating";//格式化中
    public static final String STORAGE_STATUS_UNFORMATED = "unformated";//未格式化
    public static final String STORAGE_STATUS_DISK_FAILURE = "disk_failure";//卡不识别



    public static final String STORAGE_STATUS_TYPE_UNSUPPORTED = "type_unsupported";//SD卡类型不支持
    public static final String STORAGE_STATUS_BREAKDOWN = "breakdown";//未知错误
    public static final String STORAGE_STATUS_EX_OTHERDATA= "ex_otherdata";//存在其他文件
    public static final String STORAGE_STATUS_READ_ONLY= "readonly";//SD卡只读

    public static final String STORAGE_STATUS_USING = "using";
    public static final String STORAGE_STATUS_NONE = "none";
    public static final String STORAGE_STATUS_FULL = "full";
    public static final String STORAGE_STATUS_IDLE = "idle";


    public static final String ALI_PAY = "ALIPAY";
    public static final String WECHAT_PAY = "WXPAY";
    public static final String SMART = "SMART";
    public static final String PAYMENT_INFO = "PAYMENT_INFO";

    public static final String LPR_SEARCH_DATA = "LPR_SEARCH_DATA";

    public static final String ORDER_TYPE = "ORDER_TYPE";
    public static final Boolean localH5 = false;
    /**
     * 意见反馈-出现频率
     * always 一直出现
     * often 频繁出现
     * whiles 偶尔出现
     */
    public static final String FEED_BACK_FREQUENCY_ALWAYS = "always";
    public static final String FEED_BACK_FREQUENCY_OFTEN = "often";
    public static final String FEED_BACK_FREQUENCY_WHILES = "whiles";


    /**
     * 系统消息类型
     * 401-云存储服务开通到期
     * 402-云存储服务到期提醒
     * 403-宠物检测开通提醒
     * 404- 宠物检测服务到期提醒
     * 405-意见反馈回复
     */
    public static final String MESSAGE_TYPE_401 = "401";
    public static final String MESSAGE_TYPE_402 = "402";
    public static final String MESSAGE_TYPE_403 = "403";//云存储开通通知
    public static final String MESSAGE_TYPE_404 = "404";

    public static final String MESSAGE_TYPE_405 = "405";//流量卡流量用尽提醒
    public static final String MESSAGE_TYPE_406 = "406";//自动续费扣款通知
    public static final String MESSAGE_TYPE_407 = "407";//意见反馈回复
    public static final String MESSAGE_TYPE_408 = "408";//云存套餐三天到期通知
    public static final String MESSAGE_TYPE_409 = "409";//云存储到期提醒

    public static final String MESSAGE_TYPE_412 = "412";//套餐到期通知

    public static final String MESSAGE_TYPE_413 = "413";//智能套餐3天到期
    public static final String MESSAGE_TYPE_414 = "414";//智能套餐过期类型
    public static final String MESSAGE_TYPE_415 = "415";//智能套餐自动续费



    /**
     * 设备类型
     */
    public static final String DEVICE_TYPE_IPC = "IPC";
    public static final String DEVICE_TYPE_NVR = "NVR";
    public static final String DEVICE_TYPE_OTHER = "";


}
