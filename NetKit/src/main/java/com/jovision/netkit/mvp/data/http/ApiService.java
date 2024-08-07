package com.jovision.netkit.mvp.data.http;

import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.GetScreenOverTurnBean;
import com.jovision.netkit.mvp.data.RefreshTokenDataBean;
import com.jovision.netkit.mvp.data.bean.AgreementBean;
import com.jovision.netkit.mvp.data.bean.AlarmSoundBean;
import com.jovision.netkit.mvp.data.bean.AppVersionResponseBean;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.CallUrlBean;
import com.jovision.netkit.mvp.data.bean.ChannelBean;
import com.jovision.netkit.mvp.data.bean.CloudPayInfoBean;
import com.jovision.netkit.mvp.data.bean.CloudStatusBean;
import com.jovision.netkit.mvp.data.bean.CloudStorageGroupBean;
import com.jovision.netkit.mvp.data.bean.ContractorInfoBean;
import com.jovision.netkit.mvp.data.bean.ControlTokenBean;
import com.jovision.netkit.mvp.data.bean.Device4GIccidBean;
import com.jovision.netkit.mvp.data.bean.DeviceBean;
import com.jovision.netkit.mvp.data.bean.DeviceCloudBean;
import com.jovision.netkit.mvp.data.bean.DeviceCloudStorageEnableBean;
import com.jovision.netkit.mvp.data.bean.DeviceConnectNetBean;
import com.jovision.netkit.mvp.data.bean.DeviceListResponseBean;
import com.jovision.netkit.mvp.data.bean.DeviceSceneBean;
import com.jovision.netkit.mvp.data.bean.DownloadUrlBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.FormatProgressBean;
import com.jovision.netkit.mvp.data.bean.MessageAlarmListBean;
import com.jovision.netkit.mvp.data.bean.MessageAlarmListDetailBean;
import com.jovision.netkit.mvp.data.bean.MessageBadgesBean;
import com.jovision.netkit.mvp.data.bean.MessageOperationTodoBean;
import com.jovision.netkit.mvp.data.bean.MessagePersonBean;
import com.jovision.netkit.mvp.data.bean.MessagePersonTodoBean;
import com.jovision.netkit.mvp.data.bean.MessagePushSwitchBean;
import com.jovision.netkit.mvp.data.bean.MessageSystemBean;
import com.jovision.netkit.mvp.data.bean.NativePaymentData;
import com.jovision.netkit.mvp.data.bean.PlayBackUrlForCloudBean;
import com.jovision.netkit.mvp.data.bean.PlayBackUrlForGunBallCloudBean;
import com.jovision.netkit.mvp.data.bean.PlayBackUrlForGunBallLocalBean;
import com.jovision.netkit.mvp.data.bean.PlayBackUrlForLocalBean;
import com.jovision.netkit.mvp.data.bean.PlayCallBackUrlBean;
import com.jovision.netkit.mvp.data.bean.PlayCallBackVideosBean;
import com.jovision.netkit.mvp.data.bean.PlayRecordDateBean;
import com.jovision.netkit.mvp.data.bean.PublicAlarmTypeBean;
import com.jovision.netkit.mvp.data.bean.SceneInfoBean;
import com.jovision.netkit.mvp.data.bean.ServiceListBean;
import com.jovision.netkit.mvp.data.bean.TerminalListBean;
import com.jovision.netkit.mvp.data.bean.UserInfoWithAgreementVersionBean;
import com.jovision.netkit.mvp.data.bean.WeatherBean;
import com.jovision.netkit.mvp.data.bean.request.ACLoginRequestBean;
import com.jovision.netkit.mvp.data.bean.request.ACOutBindOpenIdBean;
import com.jovision.netkit.mvp.data.bean.request.ACSendVerifyCodeBean;
import com.jovision.netkit.mvp.data.bean.request.CreateContractorRequestBean;
import com.jovision.netkit.mvp.data.bean.request.CreateSceneRequestBean;
import com.jovision.netkit.mvp.data.bean.request.DeleteDevicesBean;
import com.jovision.netkit.mvp.data.bean.request.OrderScenesRequestBean;
import com.jovision.netkit.mvp.data.bean.request.ShareCancelRequest;
import com.jovision.netkit.mvp.data.bean.request.UpdateSceneRequestBean;
import com.jovision.netkit.mvp.data.bean.request.UploadUserInfoBean;
import com.jovision.netkit.mvp.data.bean.response.ACAuthCodeBean;
import com.jovision.netkit.mvp.data.bean.response.ACAvatarUploadUrlBean;
import com.jovision.netkit.mvp.data.bean.response.ACGetOpenIDBindUserBean;
import com.jovision.netkit.mvp.data.bean.response.ACIsUserExistBean;
import com.jovision.netkit.mvp.data.bean.response.ACKeepAccountBean;
import com.jovision.netkit.mvp.data.bean.response.ACLoginResponseBean;
import com.jovision.netkit.mvp.data.bean.response.ACSaveLoginStatusBean;
import com.jovision.netkit.mvp.data.bean.response.ACUserInfoBean;
import com.jovision.netkit.mvp.data.bean.response.AddShareBean;
import com.jovision.netkit.mvp.data.bean.response.AlarmStatusBean;
import com.jovision.netkit.mvp.data.bean.response.ChannelBadgesBean;
import com.jovision.netkit.mvp.data.bean.response.CheckCancelResponseBean;
import com.jovision.netkit.mvp.data.bean.response.CrossShipmentReportBean;
import com.jovision.netkit.mvp.data.bean.response.CrossShipmentReportFileLimitBean;
import com.jovision.netkit.mvp.data.bean.response.CrossShipmentReportListBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceAlarmBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceAlarmZhoujieBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceProtocolBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceSmartTrackBean;
import com.jovision.netkit.mvp.data.bean.response.EnableBean;
import com.jovision.netkit.mvp.data.bean.response.FeedBackUploadBean;
import com.jovision.netkit.mvp.data.bean.response.FeedbackInfoBean;
import com.jovision.netkit.mvp.data.bean.response.FeedbackListResponseBean;
import com.jovision.netkit.mvp.data.bean.response.FeedbackTypeResponseBean;
import com.jovision.netkit.mvp.data.bean.response.FileUploadBean;
import com.jovision.netkit.mvp.data.bean.response.HasDeviceResponseBean;
import com.jovision.netkit.mvp.data.bean.response.HideAlarmBean;
import com.jovision.netkit.mvp.data.bean.response.HomeMenuBean;
import com.jovision.netkit.mvp.data.bean.response.IndicatorLedBean;
import com.jovision.netkit.mvp.data.bean.response.IsSharedResponseBean;
import com.jovision.netkit.mvp.data.bean.response.MultiBindBean;
import com.jovision.netkit.mvp.data.bean.response.MyOrdersBean;
import com.jovision.netkit.mvp.data.bean.response.MyShareDeviceBean;
import com.jovision.netkit.mvp.data.bean.response.OctWifiListAp;
import com.jovision.netkit.mvp.data.bean.response.OrderBean;
import com.jovision.netkit.mvp.data.bean.response.OrderPayBean;
import com.jovision.netkit.mvp.data.bean.response.PackageExpireBean;
import com.jovision.netkit.mvp.data.bean.response.PetNewDeviceBean;
import com.jovision.netkit.mvp.data.bean.response.PkgGiftRemindBean;
import com.jovision.netkit.mvp.data.bean.response.QuestionLinkBean;
import com.jovision.netkit.mvp.data.bean.response.RecordModeBean;
import com.jovision.netkit.mvp.data.bean.response.RemoteOpsBean;
import com.jovision.netkit.mvp.data.bean.response.RemoteOpsDeviceResponseBean;
import com.jovision.netkit.mvp.data.bean.response.ShareDetailBean;
import com.jovision.netkit.mvp.data.bean.response.ShareListBean;
import com.jovision.netkit.mvp.data.bean.response.ShareQrCodeBean;
import com.jovision.netkit.mvp.data.bean.response.ShareToMeBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAbilityDetailBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAppBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAppStatus;
import com.jovision.netkit.mvp.data.bean.response.SmartAppStatusBean;
import com.jovision.netkit.mvp.data.bean.response.SnapShotBean;
import com.jovision.netkit.mvp.data.bean.response.StorageBean;
import com.jovision.netkit.mvp.data.bean.response.ToDoOperationListBean;
import com.jovision.netkit.mvp.data.bean.response.ToDoTransferListBean;
import com.jovision.netkit.mvp.data.bean.response.UnreadCountBean;
import com.jovision.netkit.mvp.data.bean.response.UpgradeProgressBean;
import com.jovision.netkit.mvp.data.bean.response.UploadContractorFileBean;
import com.jovision.netkit.mvp.data.bean.response.UploadFilesResponseBean;
import com.jovision.netkit.mvp.data.bean.response.VersionBean;
import com.jovision.netkit.mvp.data.bean.response.VoiceCallGainBean;
import com.jovision.netkit.mvp.data.bean.response.WaitRemoteOpsDeviceResponseBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by ZHP on 2017/6/25.
 */

public interface ApiService {

//    //账号中心-获取服务应用凭证2022年3月3日 弃用
//    @POST("/v1/whale/api/realm/"+ Constant.realmID+"/client/token")
//    Observable<BaseBean<ACAccessTokenBean>> ACGetServiceToken(@Body RequestBody body);

    //账号中心-登录/v1/whale/api/realm/{realmID}/user/login
    @POST("/v1/whale/api/realm/"+ Constant.realmID+"/user/login")
    Observable<BaseBean<ACLoginResponseBean>> ACLogin(@Body ACLoginRequestBean body);

    //账号中心-AccessToken续约/v1/whale/api/realm/{realmID}/user/renewal
    @POST(Constant.ac_refresh_token)
    Observable<BaseBean<RefreshTokenDataBean>> ACRenewalAccessToken(@Body RequestBody body);

    //账号中心-登出
    @POST("/v1/whale/api/realm/"+ Constant.realmID+"/user/logout")
    Observable<BaseBean<EmptyBean>> ACLogout(@Body RequestBody body);

    //账号中心-是否保存登录账号
    @GET("/v1/whale/api/realm/"+ Constant.realmID+"/switch_status")
    Observable<BaseBean<ACSaveLoginStatusBean>> ACGetSaveLoginStatus();

    //账号中心-设置是否保存登录账号
    @POST("/v1/whale/api/realm/"+ Constant.realmID+"/switch_status")
    Observable<BaseBean<EmptyBean>> ACSetSaveLoginStatus(@Body RequestBody body);

    //账号中心-查询是否需要保留账号
    @GET("/v1/whale/api/realm/"+ Constant.realmID+"/account_keep")
    Observable<BaseBean<ACKeepAccountBean>> ACGetKeepAccountStatus(@Query("userID") String userID);

    //账号中心-获取用户信息
    @GET("/v1/whale/api/realm/"+ Constant.realmID+"/user/info")
    Observable<BaseBean<ACUserInfoBean>> ACGetUserInfo();

    //账号中心-修改用户昵称
    @PUT("/v1/whale/api/realm/"+Constant.realmID+"/user/nickname")
    Observable<BaseBean<EmptyBean>> ACUpdateNickName(@Body RequestBody body);

    //账号中心-获取修改头像头像上传地址
    @GET("/v1/whale/api/realm/"+Constant.realmID+"/user/icon")
    Observable<BaseBean<ACAvatarUploadUrlBean>> ACUploadAvatarUrl(@Query("fileName") String fileName);


    //账号中心-修改用户头像
    @PUT("/v1/whale/api/realm/"+Constant.realmID+"/user/icon")
    Observable<BaseBean<EmptyBean>> ACUpdateAvatar(@Body RequestBody body);

    //账号中心-账号是否存在
    @POST("/v1/whale/api/realm/"+Constant.realmID+"/user/account")
    Observable<BaseBean<ACIsUserExistBean>> ACIsUserExist(@Body RequestBody body);

//    //账号中心-发送验证码-本期开始不再使用V1
//    @POST("/v1/whale/api/realm/"+Constant.realmID+"/send_verify_code")
//    Observable<BaseBean<EmptyBean>> ACSendVerifyCode(@Body ACSendVerifyCodeBean body);

    //账号中心-发送验证码
    @POST("/v2/whale/api/realm/"+Constant.realmID+"/send_verify_code")
    Observable<BaseBean<EmptyBean>> ACSendVerifyCode(@Body ACSendVerifyCodeBean body);

    //账号中心-校验验证码
    @POST("/v1/whale/api/realm/"+Constant.realmID+"/check_verify_code")
    Observable<BaseBean<ACAuthCodeBean>> ACVerificationCode(@Body RequestBody body);


    //账号中心-变更手机号/邮箱
    @PUT("/v1/whale/api/realm/"+Constant.realmID+"/user/change/auth_info")
    Observable<BaseBean<EmptyBean>> ACModifyPhone(@Body RequestBody body);

    //账号中心-用户注册
    @POST("/v1/whale/api/realm/"+Constant.realmID+"/user/register")
    Observable<BaseBean<EmptyBean>> ACRegister(@Body RequestBody body);


    //账号中心-重置密码
    @POST("/v1/whale/api/realm/"+Constant.realmID+"/user/reset_pwd")
    Observable<BaseBean<EmptyBean>> ACForgetPwd(@Body RequestBody body);


    //账号中心-修改密码
    @POST("/v1/whale/api/realm/"+Constant.realmID+"/user/modify_pwd")
    Observable<BaseBean<EmptyBean>> ACModifyPwd(@Body RequestBody body);

    //账号中心-用户首次设置密码
    @POST("/v1/whale/api/realm/"+Constant.realmID+"/user/set_pwd")
    Observable<BaseBean<EmptyBean>> ACSetPwd(@Body RequestBody body);

    //账号中心-验证第三方登录方式是否被绑定（未登录时查询openID是否绑定用户）
    @POST("/v1/whale/api/realm/"+Constant.realmID+"/user/check_social_type")
    Observable<BaseBean<ACGetOpenIDBindUserBean>> ACUnLoginGetOpenidBindState(@Body com.jovision.netkit.mvp.data.bean.request.ACGetOpenIDBindUserBean body);


    //账号中心-未登录绑定第三方登录(未登录用户绑定微信)
    @POST("/v1/whale/api/realm/"+Constant.realmID+"/user/bind_social_type")
    Observable<BaseBean<EmptyBean>> ACUnLoginUserBindOpenid(@Body ACOutBindOpenIdBean body);


    //账号中心-绑定/解绑第三方登录（已登录用户绑定微信）
    @POST("/v1/whale/api/realm/"+Constant.realmID+"/user/social_type")
    Observable<BaseBean<EmptyBean>> ACSocialBindUnBind(@Body RequestBody body);


    //账号中心-获取终端列表
    @GET("/v1/whale/api/realm/"+Constant.realmID+"/user/terminals")
    Observable<BaseBean<TerminalListBean>> ACGetTerminalList();

    //账号中心-修改終端名称
    @PUT("/v1/whale/api/realm/"+Constant.realmID+"/user/terminal")
    Observable<BaseBean<EmptyBean>> ACEditTerminalName(@Body RequestBody body);

    //账号中心-刪除終端
//    @HTTP(method = "DELETE", path = "/v1/whale/api/realm/"+Constant.realmID+"/user/terminal", hasBody = true)
    @POST("/v1/whale/api/realm/"+Constant.realmID+"/user/terminal")
    Observable<BaseBean<EmptyBean>> ACDeleteTerminal(@Body RequestBody body);


    //账号中心-首次绑定手机号/邮箱
    @POST("/v1/whale/api/realm/"+Constant.realmID+"/user/bind/auth_info")
    Observable<BaseBean<EmptyBean>> ACBindMobileMail(@Body RequestBody body);



    //安卓app获取最新版本
    @POST("/v1/beetle/api/realm/"+Constant.realmID+"/app/check_update")
    Observable<BaseBean<AppVersionResponseBean>> getAppNewestVersion(@Body RequestBody body);




    //扫码登录（V2）
    @POST("/v2/whale/api/realm/"+ Constant.realmID+"/user/qr_login")
    Observable<BaseBean<EmptyBean>> qrLogin(@Body RequestBody body);


    //扫码后确认或取消登录（V2）
    @POST("/v2/whale/api/realm/"+ Constant.realmID+"/user/qr_confirm")
    Observable<BaseBean<EmptyBean>> qrLoginConform(@Body RequestBody body);



    //账号中心登录成功之后，上报用户信息
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/upload_userInfo")
    Observable<BaseBean<EmptyBean>> uploadUserInfo(@Body UploadUserInfoBean uploadUserInfoBean);



    //停止推送离线消息
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/mns/stop_push_msg")
    Observable<BaseBean<EmptyBean>> stopPushMsg(@Body RequestBody body);




    //SAAS端获取用户同意过的用户隐私政策版本
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/get_user_info")
    Observable<BaseBean<UserInfoWithAgreementVersionBean>> getUserInfoWithAgreementVersion();


//    //设备待办列表
//    @Headers("BaseUrlName:SAAS")
//    @POST("/v1/udms/device/to_do_list")
//    Observable<BaseBean<ToDoListBean>> getUserTodoList();


    //设备转移提醒列表
    @Headers("BaseUrlName:SAAS")
    @GET("/v1/udms/device/remind/device_transfer_list")
    Observable<BaseBean<ToDoTransferListBean>> getDevTransferList();

    //远程运维消息提醒列表
    @Headers("BaseUrlName:SAAS")
    @GET("/v1/udms/device/remind/remote_operation_list")
    Observable<BaseBean<ToDoOperationListBean>> getDevOperationList();

    //清除设备转移提醒列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/remind/clear_device_transfer_list")
    Observable<BaseBean<EmptyBean>> clearDeviceTransfer();



//
//    //已登录用户解绑微信
//    @POST("/v1/ums/unbind_openid")
//    Observable<BaseBean<EmptyBean>> loginUserUnBindOpenid();



//    //已登录用户查询是否绑定微信账号
//    @POST("/v1/ums/get_bind_status")
//    Observable<BaseBean<ACGetOpenIDBindUserBean>> loginUserGetBindStatus();



//    //登录接口
//    @POST("/v1/auth/login")
//    Observable<BaseBean<LoginResponseBean>> login(@Body LoginRequestBean body);

//    //登出接口
//    @POST("/v1/auth/logout")
//    Observable<BaseBean<EmptyBean>> logout();

//    //获取用户信息
//    @POST("/v1/ums/get_user_info")
//    Observable<BaseBean<UserInfoBean>> getUserInfo();

//    //修改用户昵称
//    @POST("/v1/ums/update_nickname")
//    Observable<BaseBean<EmptyBean>> updateNickName(@Body RequestBody body);

//    //获取修改头像头像上传地址
//    @POST("/v1/ums/upload_headerpicture_url")
//    Observable<BaseBean<AvatarUploadUrlBean>> uploadAvatarUrl(@Body RequestBody body);

//    //修改用户头像
//    @POST("/v1/ums/update_headpicture")
//    Observable<BaseBean<EmptyBean>> updateAvatar(@Body RequestBody body);

//    //账号是否存在
//    @POST("/v1/ums/is_user_exist")
//    Observable<BaseBean<IsUserExistEntity>> isUserExist(@Body RequestBody body);

//    //发送验证码
//    @POST("/v1/sms/verification_code")
//    Observable<BaseBean<EmptyBean>> sendVerifyCode(@Body SendVerifyCodeRequestBean body);

//    //获取修改手机号授权码
//    @POST("/v1/ums/get_modify_phone_auth_code")
//    Observable<BaseBean<ACAuthCodeBean>> getModifyPhoneAuthCode(@Body RequestBody body);



//    //修改手机号
//    @POST("/v1/ums/modify_phone")
//    Observable<BaseBean<EmptyBean>> modifyPhone(@Body RequestBody body);

    //用户注销
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/cancel")
    Observable<BaseBean<EmptyBean>> cancel(@Body RequestBody body);

    //用户是否符合注销账号条件
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/has_device")
    Observable<BaseBean<HasDeviceResponseBean>> hasDevice();

    //新用户注销，带注销原因
    @Headers("BaseUrlName:SAAS")
    @POST("/v2/ums/cancel")
    Observable<BaseBean<EmptyBean>> cancelHasReason(@Body RequestBody body);

    //新接口用户是否符合注销账号条件
    @Headers("BaseUrlName:SAAS")
    @POST("/v2/ums/check_cancel")
    Observable<BaseBean<CheckCancelResponseBean>> checkCancel();



//    //用户注册
//    @POST("/v1/ums/register")
//    Observable<BaseBean<EmptyBean>> register(@Body RequestBody body);

//    //重置密码
//    @POST("/v1/ums/forget_pwd")
//    Observable<BaseBean<EmptyBean>> forgetPwd(@Body RequestBody body);

//    //修改密码
//    @POST("/v1/ums/modify_pwd")
//    Observable<BaseBean<EmptyBean>> modifyPwd(@Body RequestBody body);

//
//    //未登录时查询openID是否绑定用户
//    @POST("/v1/ums/get_openid_bind")
//    Observable<BaseBean<GetOpenIDBindUserResponseBean>> unLoginGetOpenidBindState(@Body GetOpenIDBindUserRequestBean body);


//    //未登录用户绑定微信
//    @POST("/v1/ums/out_bind_openid")
//    Observable<BaseBean<EmptyBean>> unLoginUserBindOpenid(@Body OutBindOpenIdRequestBean body);


//    //已登录用户解绑微信
//    @POST("/v1/ums/unbind_openid")
//    Observable<BaseBean<EmptyBean>> loginUserUnBindOpenid();

//    //已登录用户绑定微信
//    @POST("/v1/ums/in_bind_openid")
//    Observable<BaseBean<EmptyBean>> loginUserBindOpenid(@Body RequestBody body);


//    //已登录用户查询是否绑定微信账号
//    @POST("/v1/ums/get_bind_status")
//    Observable<BaseBean<ACGetOpenIDBindUserBean>> loginUserGetBindStatus();



//    //安卓app获取最新版本
//    @POST("/v1/ums/version")
//    Observable<BaseBean<AppVersionResponseBean>> getAppNewestVersion();


    @Headers("BaseUrlName:SAAS")
    @GET("/v1/ums/menu/list_by_version_code")
    Observable<BaseBean<HomeMenuBean>> getMenuList(@Query("appType") String appType, @Query("appVersion") String appVersion);

    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/safe/check_multi_bind")
    Observable<BaseBean<MultiBindBean>> checkMultiBind();

    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/safe/clear_multi_bind")
    Observable<BaseBean<EmptyBean>> clearMultiBind();


    //查询设备接入类型【云视通收编】/v1/udms/device/get_device_protocol
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/get_device_protocol")
    Observable<BaseBean<DeviceProtocolBean>> getDeviceProtocol(@Body RequestBody body);

    //批量查询设备接入类型
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/batch_query_device_protocol")
    Observable<BaseBean<List<DeviceProtocolBean>>> getBatchDeviceProtocol(@Body RequestBody body);

    //设备管理-绑定设备【云视通收编】/v1/udms/device/add
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/add")
    Observable<BaseBean<EmptyBean>> addDevice(@Body RequestBody body);


    //设备管理-修改设备名称【云视通收编】/v1/udms/device/edit_device_name
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/edit_device_name")
    Observable<BaseBean<EmptyBean>> setDeviceName(@Body RequestBody body);


    //获取场景列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/scene/list")
    Observable<BaseBean<List<SceneInfoBean>>> sceneList();

    //添加场景
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/scene/add")
    Observable<BaseBean<EmptyBean>> createScene(@Body CreateSceneRequestBean body);

    //删除场景
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/scene/delete")
    Observable<BaseBean<EmptyBean>> deleteScene(@Body RequestBody body);

    //场景列表排序
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/scene/order")
    Observable<BaseBean<EmptyBean>> orderScene(@Body OrderScenesRequestBean body);

    //场景下的通道列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v2/udms/scene/channel_list")
    Observable<BaseBean<DeviceListResponseBean>> sceneChannels(@Body RequestBody body);

    //更新场景及场景下设备
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/scene/update")
    Observable<BaseBean<EmptyBean>> updateScene(@Body UpdateSceneRequestBean body);

//    //添加设备
//    @POST("/v1/udms/device/add")
//    Observable<BaseBean<EmptyBean>> addDevice(@Body RequestBody body);

//    //修改设备名称
//    @POST("/v1/udms/device/edit_device_name")
//    Observable<BaseBean<EmptyBean>> setDeviceName(@Body RequestBody body);

    //获取设备列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/list")
    Observable<BaseBean<DeviceListResponseBean>> getDevices();

    //获取设备列表(不包含被分享的)
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/user_device_list")
    Observable<BaseBean<DeviceListResponseBean>> getUserDevices();

    //获取设备详情
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/details")
    Observable<BaseBean<DeviceBean>> getDeviceDetail(@Body RequestBody body);
    /*获取NVR单通道详情*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/channel_detail")
    Observable<BaseBean<ChannelBean>> getChannelDetail(@Body RequestBody body);

    //媒体操作-获取公有云实时预览播放地址
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/media/get_realtime_url")
    Observable<BaseBean<List<PlayUrlBean>>> getPlayUrl(@Body RequestBody body);


    //媒体操作-获取公有云实时预览播放地址
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/media/get_realtime_url_call")
    Observable<BaseBean<List<PlayUrlBean>>> getOneKeyCallPlayUrl(@Body RequestBody body);



    //媒体操作-获取实时预览播放地址
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/media/get_yst_realtime_url")
    Observable<BaseBean<List<ConnectUrlBean>>> getYstPlayUrl(@Body RequestBody body);




    //查询套餐是否赠送-2023.9.26新增
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/smart_ability/is_newDevice")
    Observable<BaseBean<PetNewDeviceBean>> getSmartAbilityIsPetNewDevice(@Body RequestBody body);


    //查询设备智能告警套餐开通详情-2023.9.26新增
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/smart_ability/detail")
    Observable<BaseBean<SmartAbilityDetailBean>> getSmartAbilityDetail(@Body RequestBody body);


    //开启/关闭设备智能告警功能-2023.9.26新增
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/smart_ability/enable")
    Observable<BaseBean<EmptyBean>> enableSmartAbility(@Body RequestBody body);






    //云台控制-获取云台控制权
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/ptz/get_control_token")
    Observable<BaseBean<ControlTokenBean>> getControlToken(@Body RequestBody body);

    //云台控制-释放云台控制权
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/ptz/release_control_token")
    Observable<BaseBean<EmptyBean>> releaseControlToken(@Body RequestBody body);

    //云台控制-控制移动-公有云
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/ptz/control_move_start")
    Observable<BaseBean<EmptyBean>> ptzControl(@Body RequestBody body);

    //云台控制-停止移动-公有云
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/ptz/control_move_stop")
    Observable<BaseBean<EmptyBean>> ptzControlStop(@Body RequestBody body);






    /**
     * 设备设置相关
     */
    //获取设备隐私状态
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/privacy_hide_get_param")
    Observable<BaseBean<EnableBean>> getHideStatus(@Body RequestBody body);

    //设置设备隐私状态
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/privacy_hide_set_param")
    Observable<BaseBean<EmptyBean>> setHideStatus(@Body RequestBody body);

    //指令抓图
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/control_stream_snapshot")
    Observable<BaseBean<SnapShotBean>> snapShot(@Body RequestBody body);

    //删除设备
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/del_devices")
    Observable<BaseBean<EmptyBean>> deleteDevices(@Body DeleteDevicesBean body);

    //获取设备录像模式
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/media/get_record_model")
    Observable<BaseBean<RecordModeBean>> getRecordMode(@Body RequestBody body);

    //设置设备录像模式
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/media/set_record_model")
    Observable<BaseBean<EmptyBean>> setRecordMode(@Body RecordModeBean bean);

    //修改设备名称
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/edit_device_name")
    Observable<BaseBean<EmptyBean>> editDeviceName(@Body RequestBody body);

    //修改设备通道名称
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/edit_yst_channel_name")
    Observable<BaseBean<EmptyBean>> editDeviceChannelName(@Body RequestBody body);

    //获取设备加密状态
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/encrypt_get_params")
    Observable<BaseBean<EnableBean>> getEncryptStatus(@Body RequestBody body);

    //设置设备加密开关
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/encrypt_set_params")
    Observable<BaseBean<EmptyBean>> setEncryptStatus(@Body RequestBody body);

    //获取设备提示音开关状态
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/get_audio_param")
    Observable<BaseBean<EnableBean>> getAudioStatus(@Body RequestBody body);

    //设置设备提示音开关
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/set_audio_param")
    Observable<BaseBean<EmptyBean>> setAudioStatus(@Body RequestBody body);

    /*设备命令透传 获取设备指示灯状态*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<IndicatorLedBean>> getIndicatorled(@Body RequestBody body);
    /*透传设置镜头遮挡报警*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<EmptyBean>> setHideAlarmParams(@Body RequestBody body);
    /*获取当前WiFi信息*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<DeviceConnectNetBean>> getDeviceWifiInfo(@Body RequestBody body);
    /*获取设备端可用WiFi列表*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<OctWifiListAp.ResultBean>> getDeviceApWifiList(@Body RequestBody body);
    /*AP配网*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<EmptyBean>> deviceAPConfig(@Body RequestBody body);
    /*设备在线情况下配网*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<EmptyBean>> deviceWifiConfig(@Body RequestBody body);


    /*设备命令透传 云台校准*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<EmptyBean>> ptzCalibrate(@Body RequestBody body);


    /*修改通道名称*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<EmptyBean>> editChannelName(@Body RequestBody body);

    //设置设备指示灯开关
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/set_led_status")
    Observable<BaseBean<EmptyBean>> setLEDStatus(@Body RequestBody body);

    //获取设备存储卡容量
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/get_storage")
    Observable<BaseBean<List<StorageBean>>> getStorage(@Body RequestBody body);

    //恢复出厂设置
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/set_default_factory")
    Observable<BaseBean<EmptyBean>> setDefaultFactory(@Body RequestBody body);

    //重启设备
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/control_reboot")
    Observable<BaseBean<EmptyBean>> rebootDevice(@Body RequestBody body);

    //NVR通道设备重启需走透传接口
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<EmptyBean>> rebootChannelDevice(@Body RequestBody body);

    //格式化设备SD卡
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/control_sdcard_format")
    Observable<BaseBean<EmptyBean>> formatSDCard(@Body RequestBody body);

    //查询固件版本信息
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/firmware/get_version")
    Observable<BaseBean<VersionBean>> getVersion(@Body RequestBody body);

    //升级固件
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/firmware/upgrade_version")
    Observable<BaseBean<EmptyBean>> upgradeVersion(@Body RequestBody body);

    //查询设备升级进度
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/firmware/get_upgrade_status")
    Observable<BaseBean<UpgradeProgressBean>> getUpgradeStatus(@Body RequestBody body);

    //媒体操作-获取语音对讲链接地址
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/media/get_voice_url")
    Observable<BaseBean<CallUrlBean>> getCallUrl(@Body RequestBody body);

    //媒体操作-获取设备本地录像播放地址-按时间
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/media/get_playback_url_bytime")
    Observable<BaseBean<PlayCallBackUrlBean>> getPlayBackUrl(@Body RequestBody body);

    //媒体操作-查询设备本地录像文件列表或者云端录像文件
    @Headers("BaseUrlName:SAAS")
    @POST
    Observable<BaseBean<PlayCallBackVideosBean>> getVideoList(@Url String url, @Body RequestBody body);


    // 轻智能回放接口1,查询当天录像类型：查询一段时间内本地录像类型/v1/udms/device/media/get_alarm_types
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/media/get_alarm_types")
    Observable<BaseBean<PublicAlarmTypeBean>> getLocalAlarmTypes(@Body RequestBody body);


    // 轻智能回放接口2：查询设备本地录像文件列表-可根据报警类型进行筛选/v1/udms/device/media/get_alarm_record_list
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/media/get_alarm_record_list")
    Observable<BaseBean<PlayCallBackVideosBean>> getLocalAlarmRecordList(@Body RequestBody body);

    //媒体操作-查询设备本地录像录像日历掩码
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/media/get_record_mask")
    Observable<BaseBean<PlayRecordDateBean>> getLocalVideoDateList(@Body RequestBody body);

    //媒体操作-查询设备本地录像文件列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/media/get_record_list")
    Observable<BaseBean<PlayCallBackVideosBean>> getLocalVideoList(@Body RequestBody body);


    // 轻智能回放接口3,查询当天录像类型：查询云端录像类型/v1/udms/device/cloudstorage/get_alarm_types
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/cloudstorage/get_alarm_types")
    Observable<BaseBean<PublicAlarmTypeBean>> getCloudAlarmTypes(@Body RequestBody body);

    // 轻智能回放接口4：查询云端录像文件列表-可根据报警类型进行筛选/v1/udms/device/cloudstorage/get_alarm_record_list
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/cloudstorage/get_alarm_record_list")
    Observable<BaseBean<PlayCallBackVideosBean>> getCloudAlarmRecordList(@Body RequestBody body);

    //媒体操作-查询设备云端录像日历掩码
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/cloudstorage/get_record_mask")
    Observable<BaseBean<PlayRecordDateBean>> getCloudVideoDateList(@Body RequestBody body);

    //媒体操作-查询设备云端录像文件列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/cloudstorage/get_record_list")
    Observable<BaseBean<PlayCallBackVideosBean>> getCloudVideoList(@Body RequestBody body);


    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/cloudstorage/get_playback_url_bytime")
    Observable<BaseBean<PlayBackUrlForCloudBean>> getPlayBackUrlForCloud(@Body RequestBody body);

    //媒体操作-查询设备本地录像录像日历掩码或者云端录像日历掩码
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/media/linked/get_record_mask")
    Observable<BaseBean<PlayRecordDateBean>> getVideoDateList(@Body RequestBody body);



    //设备通道共享列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/share/list")
    Observable<BaseBean<ShareListBean>> getShareList(@Body RequestBody body);

    //修改共享人备注名
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/share/updateSharedNickName")
    Observable<BaseBean<EmptyBean>> updateSharedNickName(@Body RequestBody body);

    //修改共享权限
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/share/updatePermission")
    Observable<BaseBean<EmptyBean>> updatePermission(@Body RequestBody body);

    //共享详情
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/share/detail")
    Observable<BaseBean<ShareDetailBean>> shareDetail(@Body RequestBody body);

    //添加共享
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/share/add")
    Observable<BaseBean<AddShareBean>> addShare(@Body RequestBody body);

    //修改共享状态
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/share/updateShareStatus")
    Observable<BaseBean<EmptyBean>> updateShareStatus(@Body RequestBody body);//共享状态 10：被分享人忽略分享 20：分享人取消分享 30：被分享人取消分享 50：被分享人接收分享

    //分享人取消共享,要取消的设备，如果为空，则取消所有共享
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/share/cancel")
    Observable<BaseBean<EmptyBean>> cancelShare(@Body ShareCancelRequest body);

    //我的共享
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/share/myShare")
    Observable<BaseBean<List<MyShareDeviceBean>>> myShare(@Body RequestBody body);

    //共享给我的
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/share/shareToMe")
    Observable<BaseBean<List<ShareToMeBean>>> shareToMe(@Body RequestBody body);

    //创建二维码共享
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/share/create_qrcode")
    Observable<BaseBean<ShareQrCodeBean>> createShareQRCode(@Body RequestBody body);

    //查询二维码分享详情
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/share/qrcode_detail")
    Observable<BaseBean<ShareDetailBean>> getShareQRCodeDetail(@Body RequestBody body);

    //接收二维码分享
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/share/receive_qrcode")
    Observable<BaseBean<EmptyBean>> receiveQRCodeShare(@Body RequestBody body);

    //TODO 暂时未使用
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/alarm_msg/get_alarm_info")
    Observable<BaseBean<MessageAlarmListDetailBean>> getAlarmInfo(@Body RequestBody body);

    //消息角标（未读消息）
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/msg/badges")
    Observable<BaseBean<MessageBadgesBean>> getMsgBadges();

    //报警消息分类汇总列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/alarm_msg/category_list")
    Observable<BaseBean<MessageCategoryBean>> getMsgCategoryList();

    //报警消息更新（读取状态）
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/alarm_msg/update")
    Observable<BaseBean<EmptyBean>> alarmMsgRead(@Body RequestBody body);

    //报警消息清空
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/alarm_msg/delete")
    Observable<BaseBean<EmptyBean>> alarmMsgClean(@Body RequestBody body);

    //报警消息列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/alarm_msg/list")
    Observable<BaseBean<MessageAlarmListBean>> alarmMsgList(@Body RequestBody body);

    //个人消息列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/personal_msg/list")
    Observable<BaseBean<MessagePersonBean>> getMsgPersonList(@Body RequestBody body);

    //个人消息更新（读取状态）
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/personal_msg/update")
    Observable<BaseBean<EmptyBean>> personMsgRead(@Body RequestBody body);

    //个人消息清空
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/personal_msg/delete")
    Observable<BaseBean<EmptyBean>> personMsgClean(@Body RequestBody body);

    //个人待办列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/personal_todo/list")
    Observable<BaseBean<MessagePersonTodoBean>> getMsgPersonTodoList();

    //系统消息列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/sys_msg/list")
    Observable<BaseBean<MessageSystemBean>> getMsgSystemList(@Body RequestBody body);

    //查询设备当前报警状态
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/api/alarm_status/get")
    Observable<BaseBean<AlarmStatusBean>> getAlarmStatus(@Body RequestBody body);

    //设备消警
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/api/alarm_status/cancel")
    Observable<BaseBean<EmptyBean>> cancelAlarmStatus(@Body RequestBody body);


    @Headers("BaseUrlName:SAAS")
    @POST("/v1/vas/package/get_renewal_param")
    Observable<BaseBean<NativePaymentData>> getRenewalParamByMsg(@Body RequestBody body);


    //[工程商服务]用户回应远程运维申请 -2023.7.19
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/enterprise/answer/remote_operations")
    Observable<BaseBean<EmptyBean>> answerRemoteOperation(@Body RequestBody body);

    //[工程商服务]查看远程运维待办事项 -2023.7.19
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/enterprise/apply/list")
    Observable<BaseBean<MessageOperationTodoBean>> getRemoteOperationTodoList();

    //[工程商服务]查看远程运维个人消息 -2023.7.19
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/personal_msg/remote/list")
    Observable<BaseBean<MessagePersonBean>> getRemoteOperationList(@Body RequestBody body);



    //查询4G卡厂商 -2023.7.20
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/icc/info")
    Observable<BaseBean<Device4GIccidBean>> get4GDeviceIccid(@Body RequestBody body);






    /*设备告警命令透传 获取人形和移动侦测开关测参数*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<DeviceAlarmBean>> sendCmdForAlarm(@Body RequestBody body);

    /*设备告警命令透传 获取周界入侵的参数*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<DeviceAlarmZhoujieBean>> getParamsForZhoujie(@Body RequestBody body);

    /*设备告警命令透传 智能追踪的参数*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<DeviceSmartTrackBean>> getSmartTrackParam(@Body RequestBody body);

    /*设备告警命令透传 开启智能追踪*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<EmptyBean>> openDeviceSmartTracking(@Body RequestBody body);

    /*设备告警命令透传 设置移动侦测或者人形检测*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<EmptyBean>> setMotionAndHumanParams(@Body RequestBody body);

    /*设备告警命令透传 设置周界入侵参数*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<EmptyBean>> setZhoujieParams(@Body RequestBody body);

    /*设备告警命令透传 获取设置的报警音*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<AlarmSoundBean>> getAlarmSound(@Body RequestBody body);

    /*设备告警命令透传 设置报警音*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<EmptyBean>> setAlarmSound(@Body RequestBody body);

    /*设备告警命令透传 获取报警音 音量*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<String>> getAlarmSoundVolume(@Body RequestBody body);

    /*设备告警命令透传 设置报警音 音量*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<EmptyBean>> setAlarmSoundVolume(@Body RequestBody body);
    /*透传 获取遮挡报警的参数*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<HideAlarmBean>> getHideAlarmParams(@Body RequestBody body);

    //app上报推送平台token-（弃用）
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/mns/upload_token")
    Observable<BaseBean<EmptyBean>> upLoadToken(@Body RequestBody body);

    //获取报警推送开关
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/mns/get_switch")
    Observable<BaseBean<MessagePushSwitchBean>> getPushSwitch();

    //修改报警推送和设备上下线开关
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/mns/modify_switch")
    Observable<BaseBean<EmptyBean>> setPushSwitch(@Body RequestBody body);

    //云存套餐-查询设备云存套餐列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/cloud_storage_package/list")
    Observable<BaseBean<DeviceCloudBean>> getDeviceCloudList(@Body RequestBody body);

    //云存套餐-查询套餐列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/cloudstorage/groups")
    Observable<BaseBean<CloudStorageGroupBean>> getCloudList();

    //云存套餐-启用云存套餐
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/cloud_storage_package/enable")
    Observable<BaseBean<EmptyBean>> enableCloudStorage(@Body RequestBody body);

    //云存套餐-解绑云存套餐
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/cloud_storage_package/unbind_channel")
    Observable<BaseBean<EmptyBean>> unbindCloudStorage(@Body RequestBody body);

    //云存套餐-开通云存套餐
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/cloud_storage_package/purchase")
    Observable<BaseBean<CloudPayInfoBean>> getCloudPayInfo(@Body RequestBody body);

    //云存套餐-开通云存套餐-自动续费
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/cloud_storage_package/purchase_sign")
    Observable<BaseBean<CloudPayInfoBean>> getCloudPaySignInfo(@Body RequestBody body);

    //云存套餐-查询设备云存储状态
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/get_cloud_storage_status")
    Observable<BaseBean<CloudStatusBean>> getCloudStatus(@Body RequestBody body);

    //云存套餐-设置设备云存储状态
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/update_cloud_storage_status")
    Observable<BaseBean<EmptyBean>> setCloudStatus(@Body RequestBody body);
    //查询设备是否开启云存储
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/cloud_storage_package/get_enabled")
    Observable<BaseBean<DeviceCloudStorageEnableBean>> getDeviceCloudStorageEnable(@Body RequestBody body);
    //设备场景-根据设备查询场景列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/scene/device_list")
    Observable<BaseBean<List<DeviceSceneBean>>> getDeviceScene(@Body RequestBody body);

    //设备场景-修改设备至其他场景下（支持多个）
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/scene/add_device_scenes")
    Observable<BaseBean<EmptyBean>> changeScene(@Body RequestBody body);


	    //////////////////////////订单相关//////////////////////////////////////
    //订单列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/cloud_storage_package/order/list")
    Observable<BaseBean<MyOrdersBean>> orderList(@Body RequestBody body);

    //订单详情
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/cloud_storage_package/order/info")
    Observable<BaseBean<OrderBean>> orderInfo(@Body RequestBody body);

    //订单支付
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/cloud_storage_package/order/pay")
    Observable<BaseBean<OrderPayBean>> orderPay(@Body RequestBody body);

//    //获取终端列表
//    @POST("/v1/ums/terminal/list")
//    Observable<BaseBean<List<TerminalListBean>>> getTerminalList(@Body RequestBody body);

//    //修改終端名称
//    @POST("/v1/ums/terminal/edit_terminal_name")
//    Observable<BaseBean<EmptyBean>> editTerminalName(@Body RequestBody body);

//    //刪除終端
//    @POST("/v1/ums/terminal/del_terminals")
//    Observable<BaseBean<EmptyBean>> deleteTerminal(@Body RequestBody body);

    //天气
    @POST("/v1/ums/weather/get_by_district")
    Observable<BaseBean<WeatherBean>> getByDistrict(@Body RequestBody body);

    //获取设备画面翻转状态
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/get_screen_overturn")
    Observable<BaseBean<GetScreenOverTurnBean>> getScreenOverturn(@Body RequestBody body);

    //设置设备画面翻转
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/control_screen_overturn")
    Observable<BaseBean<EmptyBean>>controlScreenOverturn(@Body RequestBody body);

    /*获取报警消息的日历掩码*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/alarm_msg/date_mask")
    Observable<BaseBean<PlayRecordDateBean>> getCalendarMark(@Body RequestBody body);

    /*根据id获取云端报警url*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/cloudstorage/get_playback_url_by_alarm_uuid")
    Observable<BaseBean<PlayBackUrlForCloudBean>> getCloudPlayUrl(@Body RequestBody body);

    /*根据id获取本地报警url*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/media/get_playback_url_by_alarm_uuid")
    Observable<BaseBean<PlayBackUrlForLocalBean>> getLocalPlayUrl(@Body RequestBody body);


    /*根据id获取枪球本地报警url*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/media/linked/get_playback_url_by_alarm_uuid")
    Observable<BaseBean<PlayBackUrlForGunBallLocalBean>> getGunBallLocalPlayUrl(@Body RequestBody body);

    /*2024.4.11按消息ID获取枪球设备云端录像播放地址*/
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/cloudstorage/linked/get_playback_url_by_alarm_uuid")
    Observable<BaseBean<PlayBackUrlForGunBallCloudBean>> getGunBallCloudPlayUrl(@Body RequestBody body);

    //获取协议有效链接
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/agreement/get_enable_link")
    Observable<BaseBean<AgreementBean>> getEnableLink(@Body RequestBody body);


    //同意隐私政策接口
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/agreement/agree")
    Observable<BaseBean<EmptyBean>> agree(@Body RequestBody body);



    //意见反馈-获取图像上传地址
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/get_upload_file_url")
    Observable<BaseBean<FeedBackUploadBean>> getUploadFileUrl(@Body RequestBody body);

    //意见反馈-提交反馈意见
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/feedback/add")
    Observable<BaseBean<EmptyBean>> feedbackAdd(@Body RequestBody body);

    //意见反馈-我的反馈列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/feedback/list")
    Observable<BaseBean<FeedbackListResponseBean>> feedbackList(@Body RequestBody body);

    //意见反馈-我的反馈详情
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/feedback/info")
    Observable<BaseBean<FeedbackInfoBean>> feedbackInfo(@Body RequestBody body);


    //意见反馈-问题类型列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/feedback_type/list")
    Observable<BaseBean<FeedbackTypeResponseBean>> feedbackIssueTypeList(@Body RequestBody body);




//    //校验验证码
//    @POST("/v1/ums/verification_code")
//    Observable<BaseBean<ModifyPhoneAuthCodeBean>> verifycationCode(@Body RequestBody body);

    //获取存储格式化进度
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<FormatProgressBean>> formatSDCardProgress(@Body RequestBody body);

    //获取常见问题链接
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/question/link")
    Observable<BaseBean<QuestionLinkBean>> questionLink(@Body RequestBody body);

    //获取未读消息数量接口
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/alarm_msg/badges")
    Observable<BaseBean<ChannelBadgesBean>> getChannelBadges(@Body RequestBody body);

    //获取sd卡存储的告警图片
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/alarm_msg/get_alarm_image")
    Observable<BaseBean<ChannelBadgesBean>> getSdAlarmImage(@Body RequestBody body);

    //转移设备
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/transfer_device")
    Observable<BaseBean<EmptyBean>> transferDevice(@Body RequestBody body);

    //获取设备分享状态
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/share/is_shared")
    Observable<BaseBean<IsSharedResponseBean>> isShared(@Body RequestBody body);

    //从推送已读消息
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/uac/personal_msg/update_by_uuid")
    Observable<BaseBean<EmptyBean>> readMsgFromPush(@Body RequestBody body);




    //修改云视通设备信息-【云视通收编】
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/device/edit_device_yst")
    Observable<BaseBean<EmptyBean>> editDeviceYst(@Body RequestBody body);







    //透传接口统一入口
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/trans_cmd")
    Observable<BaseBean<String>> transCmd(@Body RequestBody body);


    //透传接口_v2_云台专用
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/send_ptz_cmd")
    Observable<BaseBean<String>> sendPtzCmd(@Body RequestBody body);


    /*********************************  2.0协议透传相关-start ***************************************/





//    /******************************** 公有云协议 云台高级设置 -start **********************************/
//
//    //云台控制-聚焦和光圈-公有云协议
//    @Headers("BaseUrlName:SAAS")
//    @POST("/v1/udms/trans_cmd")
//    Observable<BaseBean<EmptyBean>> ptzFiStart(@Body RequestBody body);
//
//    //云台控制-停止聚焦和光圈-公有云协议
//    @Headers("BaseUrlName:SAAS")
//    @POST("/v1/udms/trans_cmd")
//    Observable<BaseBean<EmptyBean>> ptzFiStop(@Body RequestBody body);
//
//
//
//
//    /********************************** 公有云协议 云台高级设置 -end **********************************/






    /***************************** 云视通2.0协议 云台高级设置 -start **********************************/

    public static final String STR_METHOD_PTZ_MOVE_STAT_GET = "ptz_move_stat_get";//云台速度获取
    //1.云台控制-云台速度获取-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_move_stat_get")
    Observable<BaseBean<String>> ptzOctMoveStatGet(@Body RequestBody body);

    //2.云台控制-控制移动-云视通2.0（包含放大，缩小）
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_move_start")
    Observable<BaseBean<EmptyBean>> ptzOctControl(@Body RequestBody body);

    //3.云台控制-停止移动-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_move_stop")
    Observable<BaseBean<EmptyBean>> ptzOctControlStop(@Body RequestBody body);


    //4.云台控制-聚焦和光圈-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_fi_start")
    Observable<BaseBean<EmptyBean>> ptzOctFiStart(@Body RequestBody body);

    //5.云台控制-停止聚焦和光圈-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_fi_stop")
    Observable<BaseBean<EmptyBean>> ptzOctFiStop(@Body RequestBody body);


    public static final String STR_METHOD_PTZ_AUTO = "ptz_auto";//云台自动旋转
    //6.云台控制-云台自动旋转-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_auto")
    Observable<BaseBean<EmptyBean>> ptzOctAuto(@Body RequestBody body);


    public static final String STR_METHOD_PTZ_ABILITY_GET = "ptz_ability_get";//获取云台能力
    //7.云台控制-获取云台能力-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_ability_get")
    Observable<BaseBean<String>> ptzOctAbilityGet(@Body RequestBody body);


    public static final String STR_METHOD_PTZ_PRESETS_GET = "ptz_presets_get";//获取预置点
    //8.云台控制-获取预置点-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_presets_get")
    Observable<BaseBean<String>> ptzOctPresetsGet(@Body RequestBody body);


    public static final String STR_METHOD_PTZ_PRESET_SET = "ptz_preset_set";//设置预置点
    //9.云台控制-设置预置点-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_preset_set")
    Observable<BaseBean<String>> ptzOctPresetSet(@Body RequestBody body);


    public static final String STR_METHOD_PTZ_PRESET_LOCATE = "ptz_preset_locate";//调用预置点
    //10.云台控制-调用预置点-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_preset_locate")
    Observable<BaseBean<String>> ptzOctPresetLocate(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_PRESET_DELETE = "ptz_preset_delete";//删除预置点
    //11.云台控制-删除预置点-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_preset_delete")
    Observable<BaseBean<String>> ptzOctPresetDelete(@Body RequestBody body);


    public static final String STR_METHOD_PTZ_PATROLS_GET = "ptz_patrols_get";//获取巡航
    //12.云台控制-获取巡航-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_patrols_get")
    Observable<BaseBean<String>> ptzOctPatrolsGet(@Body RequestBody body);


    public static final String STR_METHOD_PTZ_PATROL_CREATE = "ptz_patrol_create";//创建巡航
    //13.云台控制-创建巡航-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_patrol_create")
    Observable<BaseBean<String>> ptzOctPatrolCreate(@Body RequestBody body);


    public static final String STR_METHOD_PTZ_PATROL_DELETE = "ptz_patrol_delete";//删除巡航
    //14.云台控制-删除巡航-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_patrol_delete")
    Observable<BaseBean<String>> ptzOctPatrolDelete(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_PATROL_LOCATE = "ptz_patrol_locate";//调用巡航
    //15.云台控制-调用巡航-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_patrol_locate")
    Observable<BaseBean<String>> ptzOctPatrolLocate(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_PATROL_STOP = "ptz_patrol_stop";//停止巡航
    //16.云台控制-停止巡航-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_patrol_stop")
    Observable<BaseBean<String>> ptzOctPatrolStop(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_PATROL_GET_NODES = "ptz_patrol_get_nodes";//获取巡航节点
    //17.云台控制-获取巡航节点-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_patrol_get_nodes")
    Observable<BaseBean<String>> ptzOctPatrolGetNodes(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_PATROL_ADD_NODE = "ptz_patrol_add_node";//添加巡航节点
    //18.云台控制-添加巡航节点-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_patrol_add_node")
    Observable<BaseBean<String>> ptzOctPatrolAddNode(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_PATROL_DEL_NODE = "ptz_patrol_del_node";//删除巡航节点
    //19.云台控制-删除巡航节点-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_patrol_del_node")
    Observable<BaseBean<String>> ptzOctPatrolDelNode(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_PATROL_SET_SPEED = "ptz_patrol_set_speed";//设置巡航速度
    //20.云台控制-设置巡航速度-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_patrol_set_speed")
    Observable<BaseBean<String>> ptzOctPatrolSetSpeed(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_PATROL_SET_STAY_SECONDS = "ptz_patrol_set_stay_seconds";//设置巡航时间
    //21.云台控制-设置巡航时间-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_patrol_set_stay_seconds")
    Observable<BaseBean<String>> ptzOctPatrolSetStaySeconds(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_TRAIL_REC = "ptz_trail_rec";//开始或者完成轨迹录制
    //22.云台控制-开始或者完成轨迹录制-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_trail_rec")
    Observable<BaseBean<String>> ptzOctTrailRec(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_TRAIL_ACTION = "ptz_trail_action";//启动或者停止轨迹
    //23.云台控制-启动或者停止轨迹-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_trail_action")
    Observable<BaseBean<String>> ptzOctTrailAction(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_TRAIL_GET = "ptz_trail_get";//获取轨迹
    //24.云台控制-获取轨迹-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_trail_get")
    Observable<BaseBean<String>> ptzOctTrailGet(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_GUARD_GET = "ptz_guard_get";//获取守望
    //25.云台控制-获取守望-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_guard_get")
    Observable<BaseBean<String>> ptzOctGuardGet(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_GUARD_SET = "ptz_guard_set";//设置守望
    //26.云台控制-设置守望-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_guard_set")
    Observable<BaseBean<String>> ptzOctGuardSet(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_GUARD_ACTION = "ptz_guard_action";//启动或者停止守望
    //27.云台控制-启动或者停止守望-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_guard_action")
    Observable<BaseBean<String>> ptzOctGuardAction(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_GUARD_PAUSE = "ptz_guard_pause";//暂停或者复位守望
    //28.云台控制-暂停或者复位守望-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_guard_pause")
    Observable<BaseBean<String>> ptzOctGuardPause(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_TIME_TASK_LIST_GET = "ptz_time_task_list_get";//获取定时任务列表
    //29.云台控制-获取定时任务列表-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_time_task_list_get")
    Observable<BaseBean<String>> ptzOctTimeTaskListGet(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_TIME_TASK_GET = "ptz_time_task_get";//获取定时任务
    //30.云台控制-获取定时任务-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_time_task_get")
    Observable<BaseBean<String>> ptzOctTimeTaskGet(@Body RequestBody body);

    public static final String STR_METHOD_PTZ_TIME_TASK_SET = "ptz_time_task_set";//设置定时任务
    //31.云台控制-设置定时任务-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_time_task_set")
    Observable<BaseBean<String>> ptzOctTimeTaskSet(@Body RequestBody body);


    //32.云台校准-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/ptz/ptz_calibrate")
    Observable<BaseBean<String>> ptzOctCalibrate(@Body RequestBody body);



    /***************************** 云台常量 -end **********************************/














    //获取定时抓拍有图片的日期-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/snap_file_data_list_get")
    Observable<BaseBean<String>> getSnapFileDateList(@Body RequestBody body);


    //分页获取定时抓拍图片列表-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/v1/udms/snap_file_list_get")
    Observable<BaseBean<String>> getSnapFileList(@Body RequestBody body);




    //1 获取设备详情-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/dev_get_hwinfo")
    Observable<BaseBean<String>> octGetDevHwinfo(@Body RequestBody body);

    //2 修改设备密码-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/account_modify_user")
    Observable<BaseBean<String>> octAccountModifyUser(@Body RequestBody body);


    //3 云视通2.0获取sd卡信息
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/storage_get_info")
    Observable<BaseBean<String>> octGetStorageInfo(@Body RequestBody body);


    //4 云视通2.0格式化SD卡
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/storage_format")
    Observable<BaseBean<String>> octStorageFormat(@Body RequestBody body);


    //5 云视通2.0格式化SD卡进度获取
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/storage_format_get_progress")
    Observable<BaseBean<String>> octGetStorageFormatProgress(@Body RequestBody body);


    //6 云视通2.0获取IPC设备录像信息
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/record_get")
    Observable<BaseBean<String>> octGetRecordMode(@Body RequestBody body);


    //7 云视通2.0设置IPC设备录像信息
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/record_set")
    Observable<BaseBean<String>> octSetRecordMode(@Body RequestBody body);


    //8 云视通2.0获取网络配置-给ipc设置ip使用
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ifconfig_get_inet")
    Observable<BaseBean<String>> octGetInetConfig(@Body RequestBody body);

    //8.1 云视通2.0获取设备端wifi列表-给ipc设置ip使用
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ifconfig_wifi_list_ap")
    Observable<BaseBean<String>> octGetDevWifiListAp(@Body RequestBody body);


    //8.2 云视通2.0在线配网-给ipc设置ip使用
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ifconfig_wifi_connect")
    Observable<BaseBean<String>> octOnLineWifiConnect(@Body RequestBody body);




    //9 云视通2.0设置网络配置-给ipc设置ip使用
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ifconfig_eth_set")
    Observable<BaseBean<String>> octSetInetConfig(@Body RequestBody body);





    /***************************** 报警设置常量 -start **********************************/

    //10 云视通2.0获取支持的报警模式
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ivp_support_get")
    Observable<BaseBean<String>> octGetIvpSupport(@Body RequestBody body);

    //11 云视通2.0获取移动侦测报警模式
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/mdetect_get_param")
    Observable<BaseBean<String>> octGetMdetectParam(@Body RequestBody body);

    //12 云视通2.0设置移动侦测报警模式
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/mdetect_set_param")
    Observable<BaseBean<String>> octSetMdetectParam(@Body RequestBody body);

    //13 云视通2.0获取移动跟踪报警模式
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/get_move_track")
    Observable<BaseBean<String>> octGetMoveTrack(@Body RequestBody body);

    //14 云视通2.0设置移动跟踪报警模式
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/set_move_track")
    Observable<BaseBean<String>> octSetMoveTrack(@Body RequestBody body);

    //15 云视通2.0获取绊线/区域入侵报警模式
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ivp_rl_get_param")
    Observable<BaseBean<String>> octGetIvpRlParam(@Body RequestBody body);

    //16 云视通2.0设置绊线/区域入侵报警模式
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ivp_rl_set_param")
    Observable<BaseBean<String>> octSetIvpRlParam(@Body RequestBody body);

    //17 云视通2.0获取遮挡报警模式
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ivp_hide_get_param")
    Observable<BaseBean<String>> octGetIvpHideParam(@Body RequestBody body);

    //18 云视通2.0设置遮挡报警模式
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ivp_hide_set_param")
    Observable<BaseBean<String>> octSetIvpHideParam(@Body RequestBody body);


    //19 云视通2.0获取电动车报警模式
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/intelligence_ebike_detection_get_param")
    Observable<BaseBean<String>> octGetIntelEbikeDetect(@Body RequestBody body);

    //20 云视通2.0设置电动车报警模式
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/intelligence_ebike_detection_set_param")
    Observable<BaseBean<String>> octSetIntelEbikeDetect(@Body RequestBody body);

    //21 云视通2.0获取当前选中的报警音
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/alarm_sound_get")
    Observable<BaseBean<String>> octGetAlarmSound(@Body RequestBody body);

    //22 云视通2.0设置报警音
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/alarm_sound_set")
    Observable<BaseBean<String>> octSetAlarmSound(@Body RequestBody body);

    //23 云视通2.0报警声音音量获取
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/soundfile_level_get")
    Observable<BaseBean<String>> octGetSoundLevel(@Body RequestBody body);

    //24 云视通2.0报警声音音量设置
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/soundfile_level_set")
    Observable<BaseBean<String>> octSetSoundLevel(@Body RequestBody body);

    //25 云视通2.0是否支持报警音量设置
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/aduio_get_ability")
    Observable<BaseBean<String>> octGetAudioAbility(@Body RequestBody body);

    //26 云视通2.0报警声音音量获取
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ao_get_param")
    Observable<BaseBean<String>> octGetAoParam(@Body RequestBody body);

    //27 云视通2.0报警声音音量设置
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ao_set_param")
    Observable<BaseBean<String>> octSetAoParam(@Body RequestBody body);


    /***************************** 报警设置常量 -end **********************************/




    /***************************** 时间设置常量 -start **********************************/

    //28 云视通2.0获取网络校时状态
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/dev_ntp_get")
    Observable<BaseBean<String>> octGetDevNtp(@Body RequestBody body);

    //29 云视通2.0设置网络校时状态
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/dev_ntp_set")
    Observable<BaseBean<String>> octSetDevNtp(@Body RequestBody body);

    //30 云视通2.0获取日期格式
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/chnosd_get_param")
    Observable<BaseBean<String>> octGetChnosdParam(@Body RequestBody body);

    //31 云视通2.0设置日期格式
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/chnosd_set_param")
    Observable<BaseBean<String>> octSetChnosdParam(@Body RequestBody body);

    //32 云视通2.0获取设备时间
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/dev_gtime")
    Observable<BaseBean<String>> octGetDevTime(@Body RequestBody body);

    //33 云视通2.0设置设备时间
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/dev_stime")
    Observable<BaseBean<String>> octSetDevTime(@Body RequestBody body);


    /***************************** 时间设置常量 -end **********************************/



    /***************************** 设备操作和设备详情常量 -start **********************************/
    //34 云视通2.0重启设备
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/dev_reboot")
    Observable<BaseBean<String>> octRebootDev(@Body RequestBody body);

    //35 云视通2.0重置设备
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/dev_factory_default")
    Observable<BaseBean<String>> octResetDev(@Body RequestBody body);

    //36 云视通2.0检查设备是否需要升级
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/dev_update_check")
    Observable<BaseBean<String>> octCheckDevUpdate(@Body RequestBody body);

    //37 云视通2.0设备升级
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/dev_update")
    Observable<BaseBean<String>> octDevUpdate(@Body RequestBody body);

    //38 云视通2.0设备升级进度
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/dev_update_get_progress")
    Observable<BaseBean<String>> octGetDevUpdateProgress(@Body RequestBody body);

    /***************************** 设备操作和设备详情常量 -end **********************************/


    /***************************** 设备智能设置和设备能力常量 -start **********************************/

    //39 云视通2.0设置双光源灯光开关
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/manual_set_alarmlight")
    Observable<BaseBean<String>> octManualSetAlarmLight(@Body RequestBody body);


    //40 云视通2.0获取图像能力
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/image_get_ability")
    Observable<BaseBean<String>> octGetImageAbility(@Body RequestBody body);

    //41 云视通2.0设置车牌模式是否开启
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/image_set_expertsetting_param")
    Observable<BaseBean<String>> octSetImageExpertSettingParam(@Body RequestBody body);

    //42 云视通2.0获取车牌模式是否开启
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/image_get_expertsetting_param")
    Observable<BaseBean<String>> octGetImageExpertSettingParam(@Body RequestBody body);

    //43 云视通2.0获取图像参数
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/image_get_param")
    Observable<BaseBean<String>> octGetImageParam(@Body RequestBody body);

    //44 云视通2.0设置图像参数
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/image_set_param")
    Observable<BaseBean<String>> octSetImageParam(@Body RequestBody body);


    //45 云视通2.0获取人脸识别的参数
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ivp_facercg_get_param")
    Observable<BaseBean<String>> octGetIvpFacercgParam(@Body RequestBody body);

    //46 云视通2.0设置人脸识别的参数
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ivp_facercg_set_param")
    Observable<BaseBean<String>> octSetIvpFacercgParam(@Body RequestBody body);

    //47 云视通2.0设置LED指示灯状态
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/dev_set_indicatorled")
    Observable<BaseBean<String>> octSetIndicatorled(@Body RequestBody body);

    //48 云视通2.0获取报警联动总布防状态
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/alarm_link_defence_get")
    Observable<BaseBean<String>> octGetAlarmLinkDefenceParam(@Body RequestBody body);

    //49 云视通2.0设置报警联动总布防状态
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/alarm_link_defence_set")
    Observable<BaseBean<String>> octSetAlarmLinkDefenceParam(@Body RequestBody body);

    // 云视通2.0设置驱离
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/alarm_link_trigger")
    Observable<BaseBean<String>> octSetAlarmLinkTrigger(@Body RequestBody body);

    // 云视通2.0获取码流参数
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/stream_get_params")
    Observable<BaseBean<String>> octGetStreamParam(@Body RequestBody body);

    // 云视通2.0设置码流参数
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/stream_set_params")
    Observable<BaseBean<String>> octSetStreamParam(@Body RequestBody body);

    // 云视通2.0获取日夜切换配置
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/image_get_dncut_param")
    Observable<BaseBean<String>> octGetImageDncutParam(@Body RequestBody body);

    // 云视通2.0设置日夜切换配置
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/image_set_dncut_param")
    Observable<BaseBean<String>> octSetImageDncutParam(@Body RequestBody body);

    //50 云视通2.0NVR获取通道能力
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/channels_features_get")
    Observable<BaseBean<String>> octGetChannelsFeatures(@Body RequestBody body);

    //56 云视通2.0获取图像调节参数
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/image_get_adjust_param")
    Observable<BaseBean<String>> octGetImageAdjustParam(@Body RequestBody body);

    //57 云视通2.0设置图像调节参数
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/image_set_adjust_param")
    Observable<BaseBean<String>> octSetImageAdjustParam(@Body RequestBody body);


    //58 云视通2.0获取报警音列表
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/alarm_soundlist_get")
    Observable<BaseBean<String>> octGetAlarmSoundList(@Body RequestBody body);

    //59 云视通2.0添加自定义报警音
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/alarm_sound_add")
    Observable<BaseBean<String>> octAddAlarmSound(@Body RequestBody body);


    //60 云视通2.0删除自定义报警音
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/alarm_sound_del")
    Observable<BaseBean<String>> octDeleteAlarmSound(@Body RequestBody body);


    //61 云视通2.0报警声音播放(设备端播放)
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/alarm_sound_play")
    Observable<BaseBean<String>> octAlarmSoundPlay(@Body RequestBody body);


    //62 云视通2.0报警联动获取
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/alarm_link_get")
    Observable<BaseBean<String>> octAlarmLinkGet(@Body RequestBody body);



    //63 云视通2.0报警联动配置
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/alarm_link_set")
    Observable<BaseBean<String>> octAlarmLinkSet(@Body RequestBody body);


    //64 云视通2.0协议 获取1.0兼容配置
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/netservice_onvif_get_discoveryinfo")
    Observable<BaseBean<String>> octGetOnVifDiscoveryFlag(@Body RequestBody body);


    //65 云视通2.0协议 设置1.0兼容设置
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/netservice_onvif_set_discoveryinfo")
    Observable<BaseBean<String>> octSetOnVifDiscoveryFlag(@Body RequestBody body);


    //66 云视通2.0协议 获取某个或所有通道的所有码流能力集
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/stream_get_all_ability")
    Observable<BaseBean<String>> octGetStreamAllAbility(@Body RequestBody body);


    //67 云视通2.0协议 获取某个或所有通道的所有码流参数
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/stream_get_params")
    Observable<BaseBean<String>> octGetStreamParams(@Body RequestBody body);


    //68 云视通2.0协议 设置多个通道的多个码流参数
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/stream_set_params")
    Observable<BaseBean<String>> octSetStreamParams(@Body RequestBody body);

    //69 云视通2.0协议 恢复默认设置
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/dev_set_default_cfg")
    Observable<BaseBean<String>> setDefaultCfg(@Body RequestBody body);

    //70 云视通2.0协议 获取联动id
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/alarm_get_link_id")
    Observable<BaseBean<String>> octGetAlarmLinkId(@Body RequestBody body);

    // 云视通2.0手动消警
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/alarm_manual_cancel")
    Observable<BaseBean<String>> octCancelAlarmManual(@Body RequestBody body);



    /***************************** 设备智能设置和设备能力常量 -end **********************************/


    /***************************** 定时抓拍常量 -start **********************************/

    //51 云视通2.0定时抓拍参数获取
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/timing_snap_get")
    Observable<BaseBean<String>> octGetTimingSnap(@Body RequestBody body);

    //52 云视通2.0定时抓拍参数设置
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/timing_snap_set")
    Observable<BaseBean<String>> octSetTimingSnap(@Body RequestBody body);


    /***************************** 定时抓拍常量常量 -end **********************************/


    //53 Ap配网-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ifconfig_wifi_apconfig")
    Observable<BaseBean<String>> octApConfig(@Body RequestBody body);

    // 云视通2.0-获取osd参数
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/chnosd_param_get")
    Observable<BaseBean<String>> octChnosdParamGet(@Body RequestBody body);

    // 云视通2.0-设置osd参数
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/chnosd_param_set")
    Observable<BaseBean<String>> octChnosdParamSet(@Body RequestBody body);

    // 云视通2.0-获取OSD能力
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/osd_get_ability")
    Observable<BaseBean<String>> octOsdGetAbility(@Body RequestBody body);

    // 云视通2.0-获取虚焦检测的参数
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ivp_vf_get_param")
    Observable<BaseBean<String>> octIvpVfGetParam(@Body RequestBody body);

    // 云视通2.0-设置虚焦检测的参数
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/ivp_vf_set_param")
    Observable<BaseBean<String>> octIvpVfSetParam(@Body RequestBody body);

    /***********************************  2.0协议透传相关-end ***************************************/


    //54 对讲模式切换-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/chat_set_param")
    Observable<BaseBean<String>> octChatSetParam(@Body RequestBody body);


    //55 获取用户信息-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/account_get_users")
    Observable<BaseBean<String>> octAccountGetUser(@Body RequestBody body);


    //56 获取设备VC值-云视通2.0
    @Headers("BaseUrlName:WEB_SERVICE_URL")
    @POST("/json/dev_get_verification_code")
    Observable<BaseBean<String>> octGetDevVerificationCode(@Body RequestBody body);



    /*********************************   工程商认证    **********************************************/
    //获取工程商认证详情信息
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/enterprise/get")
    Observable<BaseBean<ContractorInfoBean>> getContractorInfo(@Body RequestBody body);

    //新建工程商认证
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/enterprise/add")
    Observable<BaseBean<EmptyBean>> createContractor(@Body CreateContractorRequestBean body);

    //工程商文件上传——获取文件上传地址
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/get_upload_enterprise_file_url")
    Observable<BaseBean<UploadContractorFileBean>> getUploadContractorFileUrl(@Body RequestBody body);


    //首页获取服务列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v2/ums/service_centre/list")
    Observable<BaseBean<ServiceListBean>> getServiceList(@Body RequestBody body);

    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/service_centre/new_list")
    Observable<BaseBean<ServiceListBean>> getServiceListNew(@Body RequestBody body);

    //切换普通用户和工程商用户身份
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/engineer/switch")
    Observable<BaseBean<EmptyBean>> changeAccount(@Body RequestBody body);

    //获取测速下载文件url
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/enterprise/download_speed")
    Observable<BaseBean<DownloadUrlBean>> getDownloadUrl(@Body RequestBody body);

    /***************************** 远程运维 -begin **********************************/

    // 远程运维-终端用户-获取可远程设备列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/enterprise/support_remote_list")
    Observable<BaseBean<RemoteOpsDeviceResponseBean>> getRemoteOpsDevListForUser();

    // 远程运维-终端用户-发起远程运维
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/enterprise/request_remote_operations")
    Observable<BaseBean<RemoteOpsBean>> applyRemoteOpsDev(@Body RequestBody body);

    // 远程运维-工程商-获取待运维设备列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/enterprise/remote_operations_list")
    Observable<BaseBean<WaitRemoteOpsDeviceResponseBean>> getRemoteOpsDevListForContractor();

    // 远程运维-工程商-接受远程运维
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/enterprise/accept_remote_operations")
    Observable<BaseBean<EmptyBean>> acceptRemoteOpsDev(@Body RequestBody body);


    /***************************** 远程运维 -end ***********************************/

    /***************************** 串货举报 -begin **********************************/

    // 获取串货举报未读状态
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/cross_device/unread_status")
    Observable<BaseBean<UnreadCountBean>> getCrossShipmentUnreadStatus();

    // 获取串货举报上报文件数量上限
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/cross_device/get_file_limit")
    Observable<BaseBean<CrossShipmentReportFileLimitBean>> getCrossShipmentReportFileLimit();

    // 上传串货举报信息
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/cross_device/add")
    Observable<BaseBean<EmptyBean>> commitCrossShipmentReport(@Body CrossShipmentReportBean body);

    // 获取串货举报详情
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/cross_device/get")
    Observable<BaseBean<CrossShipmentReportBean>> getCrossShipmentReport(@Body RequestBody body);

    // 获取串货举报列表
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/cross_device/list")
    Observable<BaseBean<CrossShipmentReportListBean>> getCrossShipmentReportList(@Body RequestBody body);

    /***************************** 串货举报 -end **********************************/

    // 批量上传文件
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/upload_files")
    Observable<BaseBean<UploadFilesResponseBean>> uploadFileList(@Body RequestBody body);

    // 获取未读状态（工程商、意见反馈）
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/unread_status")
    Observable<BaseBean<UnreadCountBean>> getUnreadStatus();

    // 获取APP声音增益效果
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/ums/get_app_gain")
    Observable<BaseBean<VoiceCallGainBean>> getAppVoiceGain();

    // 获取文件上传地址
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/pos/customer/logo/file/upload")
    Observable<BaseBean<FileUploadBean>> getFileUploadInfo(@Body RequestBody body);

    // 添加logo
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/pos/customer/logo/add")
    Observable<BaseBean<EmptyBean>> addLogo(@Body RequestBody body);

    // 获取设备智能算法
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/aiot/get_app_list")
    Observable<BaseBean<List<SmartAppBean>>> getSmartApp(@Body RequestBody body);

    @Headers("BaseUrlName:SAAS")
    @POST("/v1/udms/aiot/get_algorithm_list")
    Observable<BaseBean<List<SmartAppStatusBean>>> getSmartAppStatus(@Body RequestBody body);

    // 获取免费套餐礼物提醒
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/vas/package/get_gift_reminds")
    Observable<BaseBean<PkgGiftRemindBean>> getGiftReminds(@Body RequestBody body);

    //获取智能算法状态
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/vas/package/get_package_status")
    Observable<BaseBean<SmartAppStatus>> getSmartStatus(@Body RequestBody body);

    //套餐绑定
    @Headers("BaseUrlName:SAAS")
    @POST("/v1/pps/package/bind")
    Observable<BaseBean<PackageExpireBean>> packageBind(@Body RequestBody body);

}
