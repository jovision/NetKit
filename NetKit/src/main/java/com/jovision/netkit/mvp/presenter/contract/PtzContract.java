package com.jovision.netkit.mvp.presenter.contract;

import com.alibaba.fastjson.JSONArray;
import com.jovision.netkit.mvp.data.GetScreenOverTurnBean;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.CallUrlBean;
import com.jovision.netkit.mvp.data.bean.ControlTokenBean;
import com.jovision.netkit.mvp.data.bean.DeviceCloudBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.RDLPRSystemGetParam;
import com.jovision.netkit.mvp.data.bean.response.AlarmLinkIdBean;
import com.jovision.netkit.mvp.data.bean.response.AlarmStatusBean;
import com.jovision.netkit.mvp.data.bean.response.EnableBean;
import com.jovision.netkit.mvp.data.bean.response.ErrorBean;
import com.jovision.netkit.mvp.data.bean.response.GtrackGetCalibrationBean;
import com.jovision.netkit.mvp.data.bean.response.IntelligenceAbilityBean;
import com.jovision.netkit.mvp.data.bean.response.IntelligenceWaveHandCallParam;
import com.jovision.netkit.mvp.data.bean.response.OctAccountModifyUserBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmLinkDefenceBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmLinkGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctChannelAbilityBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevGetVC;
import com.jovision.netkit.mvp.data.bean.response.OctDevInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageAbilityGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageAdjustParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageDncutParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzAbilityBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzGuardGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzPatrolCreateBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzPatrolGetNodesBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzPatrolsGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzPresetsGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzSpeedBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzTimeTaskGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzTimeTaskListGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzTrailGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctSDCardFormatProBean;
import com.jovision.netkit.mvp.data.bean.response.OctSDCardInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctStreamGetParams;
import com.jovision.netkit.mvp.data.bean.response.ShareToMeBean;
import com.jovision.netkit.mvp.data.bean.response.SimCardListBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAbilityDetailBean;
import com.jovision.netkit.mvp.data.bean.response.SnapDateBean;
import com.jovision.netkit.mvp.data.bean.response.SnapFileListBean;
import com.jovision.netkit.mvp.data.bean.response.StorageBean;
import com.jovision.netkit.mvp.data.http.ConnectUrlBean;
import com.jovision.netkit.mvp.data.http.PlayUrlBean;
import com.jovision.uikit.BaseView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface PtzContract {

    interface IPtzModel {


        // 标定相关接口-1 获取标定状态
        public Observable<BaseBean<GtrackGetCalibrationBean.ResultBean>> getGtrackCalibration(String deviceSn, int channelId, HashMap<String, Object> body);

        // 标定相关接口-2 开始标定
        public Observable<BaseBean<EmptyBean>> setGtrackCalibration(String deviceSn, int channelId, HashMap<String, Object> body);

        // 标定相关接口-3 设置枪球联动标定位置
        public Observable<BaseBean<EmptyBean>> addGtrackMarkPoint(String deviceSn, int channelId, HashMap<String, Object> body);

        // 标定相关接口-4 设置守望点(设为跟踪初始位置)
        public Observable<BaseBean<EmptyBean>> setGtrackGuard(String deviceSn, int channelId, HashMap<String, Object> body);

        // 标定相关接口-5 手动定位
        public Observable<BaseBean<EmptyBean>> manualGtrackPosition(String deviceSn, int channelId, HashMap<String, Object> body);


        // 标定相关接口-6 清空标定点
        public Observable<BaseBean<EmptyBean>> clearGtrackPoint(String deviceSn, int channelId, HashMap<String, Object> body);


        Observable<BaseBean<EmptyBean>> oneKeyCallPublic(String deviceSn, int channelId, String status);

        Observable<BaseBean<CallUrlBean>> getCallUrl(String deviceSn, int channelId);

        Observable<BaseBean<List<PlayUrlBean>>> getMultiPlayUrl(String deviceSn, ArrayList<Integer> channelList, int streamId);

        Observable<BaseBean<List<PlayUrlBean>>> getPlayUrl(String deviceSn, int channelId, int streamId);

        Observable<BaseBean<List<PlayUrlBean>>> getOneKeyCallPlayUrl(String deviceSn, int channelId, int streamId);

        Observable<BaseBean<List<ConnectUrlBean>>> getYstPlayUrl(String deviceSn, int channelId, String deviceIp, int devicePort);


        //获取公有云设备当前的信息-jy
        Observable<BaseBean<OctDevInfoBean.ResultBean>> getPublicDeviceInfo(String deviceSn, int channelId, HashMap<String, Object> body);

        //获取公有云设备通道能力及-jy
        Observable<BaseBean<OctChannelAbilityBean.ResultBean>> getChannelsFeatures(String deviceSn, int channelId, HashMap<String, Object> body);

        //获取2.0设备通道能力及-jy
        Observable<BaseBean<OctChannelAbilityBean>> octGetChannelsFeatures(String deviceSn, int channelId, String devUser, String devPwd, boolean isAp);

        Observable<BaseBean<ControlTokenBean>> getControlToken(String deviceSn, int channelId);

        Observable<BaseBean<EmptyBean>> releaseControlToken(String deviceSn, int channelId);


        //1.云台控制-云台速度获取-公有云协议
        Observable<BaseBean<OctPtzSpeedBean.ResultBean>> ptzMoveStatGet(String deviceSn, int channelId, String controlToken);

        //2.云台控制-控制移动-公有云协议（包含放大，缩小）
        Observable<BaseBean<EmptyBean>> ptzControl(String deviceSn, int channelId, String controlToken, int panLeft, int tiltUp, int zoomIn);

        //3.云台控制-停止移动-公有云协议
        Observable<BaseBean<EmptyBean>> ptzControlStop(String deviceSn, int channelId, String controlToken);

        //4.云台控制-聚焦和光圈-公有云协议
        Observable<BaseBean<EmptyBean>> ptzFiStart(String deviceSn, int channelId, int focusFar, int irisOpen, String controlToken);

        //5.云台控制-停止聚焦和光圈-公有云协议
        Observable<BaseBean<EmptyBean>> ptzFiStop(String deviceSn, int channelId, String controlToken);

        //6.云台控制-云台自动旋转-公有云协议
        Observable<BaseBean<EmptyBean>> ptzAuto(String deviceSn, int channelId, int speed, String controlToken);

        //7.云台控制-获取云台能力--公有云协议
        Observable<BaseBean<OctPtzAbilityBean.ResultBean>> ptzAbilityGet(String deviceSn, int channelId, String controlToken);

        //7.1云台控制-获取云台能力--公有云协议，透传命令，不需要带token
        Observable<BaseBean<OctPtzAbilityBean.ResultBean>> ptzAbilityGetNoToken(String deviceSn, int channelId);

        //8.云台控制-获取预置点-公有云协议
        Observable<BaseBean<OctPtzPresetsGetBean.ResultBean>> ptzPresetsGet(String deviceSn, int channelId, String controlToken);

        //9.云台控制-设置预置点-公有云协议
        Observable<BaseBean<ErrorBean>> ptzPresetSet(String deviceSn, int channelId, int presetNo, String name, String controlToken);

        //10.云台控制-调用预置点-公有云协议
        Observable<BaseBean<ErrorBean>> ptzPresetLocate(String deviceSn, int channelId, int presetNo, int moveSpeed, String controlToken);

        //11.云台控制-删除预置点-公有云协议
        Observable<BaseBean<ErrorBean>> ptzPresetDelete(String deviceSn, int channelId, int presetNo, String controlToken);

        //12.云台控制-获取巡航-公有云协议
        Observable<BaseBean<OctPtzPatrolsGetBean.ResultBean>> ptzPatrolsGet(String deviceSn, int channelId, int patrolId, String controlToken);

        //13.云台控制-创建巡航-公有云协议
        Observable<BaseBean<OctPtzPatrolCreateBean.ResultBean>> ptzPatrolCreate(String deviceSn, int channelId, String controlToken);

        //14.云台控制-删除巡航-公有云协议
        Observable<BaseBean<ErrorBean>> ptzPatrolDelete(String deviceSn, int channelId, int patrolId, String controlToken);

        //15.云台控制-调用巡航-公有云协议
        Observable<BaseBean<ErrorBean>> ptzPatrolLocate(String deviceSn, int channelId, int patrolId, int speed, String controlToken);

        //16.云台控制-停止巡航-公有云协议
        Observable<BaseBean<ErrorBean>> ptzPatrolStop(String deviceSn, int channelId, int patrolId, String controlToken);

        //17.云台控制-获取巡航节点-公有云协议
        Observable<BaseBean<OctPtzPatrolGetNodesBean.ResultBean>> ptzPatrolGetNodes(String deviceSn, int channelId, int patrolId, String controlToken);

        //18.云台控制-添加巡航节点-公有云协议
        Observable<BaseBean<ErrorBean>> ptzPatrolAddNode(String deviceSn, int channelId, int patrolId, int presetNo, int staySeconds, String controlToken);

        //19.云台控制-删除巡航节点-公有云协议
        Observable<BaseBean<ErrorBean>> ptzPatrolDelNode(String deviceSn, int channelId, int patrolId, int presetIndex, String controlToken);

        //20.云台控制-设置巡航速度-公有云协议
        Observable<BaseBean<ErrorBean>> ptzPatrolSetSpeed(String deviceSn, int channelId, int patrolId, int speed, String controlToken);

        //21.云台控制-设置巡航时间-公有云协议
        Observable<BaseBean<ErrorBean>> ptzPatrolSetStaySeconds(String deviceSn, int channelId, int patrolId, int staySeconds, String controlToken);

        //22.云台控制-开始或者完成轨迹录制-公有云
        Observable<BaseBean<ErrorBean>> ptzTrailRec(String deviceSn, int channelId, int trailId, boolean bStart, String controlToken);

        //23.云台控制-启动或者停止轨迹-公有云
        Observable<BaseBean<ErrorBean>> ptzTrailAction(String deviceSn, int channelId, int trailId, boolean bStart, String controlToken);

        //24.云台控制-获取轨迹-公有云
        Observable<BaseBean<OctPtzTrailGetBean.ResultBean>> ptzTrailGet(String deviceSn, int channelId, int trailId, String controlToken);

        //25.云台控制-获取守望-公有云
        Observable<BaseBean<OctPtzGuardGetBean.ResultBean>> ptzGuardGet(String deviceSn, int channelId, String controlToken);

        //26.云台控制-设置守望-公有云协议
        Observable<BaseBean<ErrorBean>> ptzGuardSet(String deviceSn, int channelId, int preset, int staySeconds, String controlToken);

        //27.云台控制-启动或者停止守望-公有云协议
        Observable<BaseBean<ErrorBean>> ptzGuardAction(String deviceSn, int channelId, boolean bStart, String controlToken);

        //28.云台控制-暂停或者复位守望-公有云协议
        Observable<BaseBean<ErrorBean>> ptzGuardPause(String deviceSn, int channelId, boolean bPause, String controlToken);

        //29.云台控制-获取定时任务列表-公有云协议
        public Observable<BaseBean<OctPtzTimeTaskListGetBean.ResultBean>> ptzTimeTaskListGet(String deviceSn, int channelId, String controlToken);

        //30.云台控制-获取定时任务-公有云协议
        Observable<BaseBean<OctPtzTimeTaskGetBean.ResultBean>> ptzTimeTaskGet(String deviceSn, int channelId, int taskId, String controlToken);

        //31.云台控制-设置定时任务-公有云协议
        Observable<BaseBean<ErrorBean>> ptzTimeTaskSet(String deviceSn, int channelId, JSONArray taskArray, String controlToken);

        //32.云台校准-公有云协议
        Observable<BaseBean<EmptyBean>> ptzCalibrate(String deviceSn, int channelId);

        //33.图像能力-公有云协议
        Observable<BaseBean<OctImageAbilityGetBean.ResultBean>> getImageAbility(String deviceSn, int channelId);

        //34.获取日夜切换设置-公有云协议
        Observable<BaseBean<OctImageDncutParamBean.ResultBean>> getImageDncutParam(String deviceSn, int channelId);

        //35.设置日夜切换-公有云协议
        Observable<BaseBean<EmptyBean>> setImageDncutParam(String deviceSn, int channelId, OctImageDncutParamBean.ResultBean resultBean);

        //36.获取报警联动总布防状态设置-公有云协议
        Observable<BaseBean<OctAlarmLinkDefenceBean.ResultBean>> getAlarmLinkDefenceParam(String deviceSn, int channelId);

        //37.设置报警联动总布防状态-公有云协议
        Observable<BaseBean<EmptyBean>> setAlarmLinkDefenceParam(String deviceSn, int channelId, OctAlarmLinkDefenceBean.ResultBean resultBean);

        //38.设置驱离-公有云协议
        Observable<BaseBean<EmptyBean>> setAlarmLinkTrigger(String deviceSn, int channelId, String status);

        //39.获取码流参数-公有云协议
        Observable<BaseBean<OctStreamGetParams.ResultBean>> getStreamParam(String deviceSn, int channelId);

        //40.设置码流参数-公有云协议
        Observable<BaseBean<EmptyBean>> setStreamParam(String deviceSn, int channelId, OctStreamGetParams.ResultBean resultBean);

        //41.获取智能能力集-公有云协议
        Observable<BaseBean<IntelligenceAbilityBean>> getIntelligenceAbility(String deviceSn, int channelId);

        //42.挥手呼叫参数获取接口-公有云协议
        Observable<BaseBean<IntelligenceWaveHandCallParam.ResultBean>> getWaveHandCallParam(String deviceSn, int channelId);

        //43.哭声宠物开启状态获取接口
        Observable<BaseBean<SmartAbilityDetailBean>> getCryPetDetail(String deviceSn, int channelId);

        Observable<BaseBean<List<StorageBean>>> getStorage(String deviceSn);

        Observable<BaseBean<EmptyBean>> formatSDCard(String deviceSn, int diskNum, String diskName, int curPart);

        //获取报警联动id
        Observable<BaseBean<AlarmLinkIdBean.ResultBean>> getAlarmLinkId(String deviceSn, int channelId, String module);

        //获取报警联动详情
        Observable<BaseBean<OctAlarmLinkGetBean.ResultBean>> getAlarmLink(String deviceSn, int channelId, int alarmLinkId);

        //1.云台控制-云台速度获取-云视通2.0
        Observable<BaseBean<OctPtzSpeedBean>> ptzOctMoveStatGet(String deviceSn, int channelId, String devUser, String devPwd);

        //2.云台控制-控制移动-云视通2.0（包含放大，缩小）
        Observable<BaseBean<EmptyBean>> ptzOctControl(int playerId, String deviceSn, int channelId, String controlToken, String devUser, String devPwd, int panLeft, int tiltUp, int zoomIn, boolean isAp);

        //3.云台控制-停止移动-云视通2.0
        Observable<BaseBean<EmptyBean>> ptzOctControlStop(int playerId, String deviceSn, int channelId, String controlToken, String devUser, String devPwd, boolean isAp);

        //4.云台控制-聚焦和光圈-云视通2.0
        Observable<BaseBean<EmptyBean>> ptzOctFiStart(int playerId, String deviceSn, int channelId, String devUser, String devPwd, int focusFar, int irisOpen, boolean isAp);

        //5.云台控制-停止聚焦和光圈-云视通2.0
        Observable<BaseBean<EmptyBean>> ptzOctFiStop(int playerId, String deviceSn, int channelId, String devUser, String devPwd, boolean isAp);

        //6.云台控制-云台自动旋转-云视通2.0
        Observable<BaseBean<EmptyBean>> ptzOctAuto(int playerId, String deviceSn, int channelId, String devUser, String devPwd, int speed, boolean isAp);

        //7.云台控制-获取云台能力-云视通2.0
        Observable<BaseBean<OctPtzAbilityBean>> ptzOctAbilityGet(String deviceSn, int channelId, String devUser, String devPwd, boolean isAp);

        //8.云台控制-获取预置点-云视通2.0
        Observable<BaseBean<OctPtzPresetsGetBean>> ptzOctPresetsGet(String deviceSn, int channelId, String devUser, String devPwd);

        //9.云台控制-设置预置点-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctPresetSet(String deviceSn, int channelId, String devUser, String devPwd, int presetNo, String name);

        //10.云台控制-调用预置点-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctPresetLocate(String deviceSn, int channelId, String devUser, String devPwd, int presetNo, int moveSpeed);

        //11.云台控制-删除预置点-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctPresetDelete(String deviceSn, int channelId, String devUser, String devPwd, int presetNo);

        //12.云台控制-获取巡航-云视通2.0
        Observable<BaseBean<OctPtzPatrolsGetBean>> ptzOctPatrolsGet(String deviceSn, int channelId, String devUser, String devPwd, int patrolId);

        //13.云台控制-创建巡航-云视通2.0
        Observable<BaseBean<OctPtzPatrolCreateBean>> ptzOctPatrolCreate(String deviceSn, int channelId, String devUser, String devPwd);

        //14.云台控制-删除巡航-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctPatrolDelete(String deviceSn, int channelId, String devUser, String devPwd, int patrolId);

        //15.云台控制-调用巡航-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctPatrolLocate(String deviceSn, int channelId, String devUser, String devPwd, int patrolId, int speed);

        //16.云台控制-停止巡航-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctPatrolStop(String deviceSn, int channelId, String devUser, String devPwd, int patrolId);

        //17.云台控制-获取巡航节点-云视通2.0
        Observable<BaseBean<OctPtzPatrolGetNodesBean>> ptzOctPatrolGetNodes(String deviceSn, int channelId, String devUser, String devPwd, int patrolId);

        //18.云台控制-添加巡航节点-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctPatrolAddNode(String deviceSn, int channelId, String devUser, String devPwd, int patrolId, int presetNo, int staySeconds);

        //19.云台控制-删除巡航节点-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctPatrolDelNode(String deviceSn, int channelId, String devUser, String devPwd, int patrolId, int presetIndex);

        //20.云台控制-设置巡航速度-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctPatrolSetSpeed(String deviceSn, int channelId, String devUser, String devPwd, int patrolId, int speed);

        //21.云台控制-设置巡航时间-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctPatrolSetStaySeconds(String deviceSn, int channelId, String devUser, String devPwd, int patrolId, int staySeconds);

        //22.云台控制-开始或者完成轨迹录制-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctTrailRec(String deviceSn, int channelId, String devUser, String devPwd, int trailId, boolean bStart);

        //23.云台控制-启动或者停止轨迹-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctTrailAction(String deviceSn, int channelId, String devUser, String devPwd, int trailId, boolean bStart);

        //24.云台控制-获取轨迹-云视通2.0
        Observable<BaseBean<OctPtzTrailGetBean>> ptzOctTrailGet(String deviceSn, int channelId, String devUser, String devPwd, int trailId);

        //25.云台控制-获取守望-云视通2.0
        Observable<BaseBean<OctPtzGuardGetBean>> ptzOctGuardGet(String deviceSn, int channelId, String devUser, String devPwd);

        //26.云台控制-设置守望-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctGuardSet(String deviceSn, int channelId, String devUser, String devPwd, int preset, int staySeconds);

        //27.云台控制-启动或者停止守望-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctGuardAction(String deviceSn, int channelId, String devUser, String devPwd, boolean bStart);

        //28.云台控制-暂停或者复位守望-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctGuardPause(String deviceSn, int channelId, String devUser, String devPwd, boolean bPause);

        //29.云台控制-获取定时任务列表-云视通2.0
        Observable<BaseBean<OctPtzTimeTaskListGetBean>> ptzOctTimeTaskListGet(String deviceSn, int channelId, String devUser, String devPwd);

        //30.云台控制-获取定时任务-云视通2.0
        Observable<BaseBean<OctPtzTimeTaskGetBean>> ptzOctTimeTaskGet(String deviceSn, int channelId, String devUser, String devPwd, int taskId);

        //31.云台控制-设置定时任务-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctTimeTaskSet(String deviceSn, int channelId, String devUser, String devPwd, JSONArray taskArray);

        //32.云台校准-云视通2.0
        Observable<BaseBean<ErrorBean>> ptzOctCalibrate(String deviceSn, int channelId, String devUser, String devPwd);

        //34.获取日夜切换设置-云视通2.0
        Observable<BaseBean<OctImageDncutParamBean>> octGetImageDncutParam(String deviceSn, int channelId, String devUser, String devPwd);

        //35.设置日夜切换-云视通2.0
        Observable<BaseBean<EmptyBean>> octSetImageDncutParam(String deviceSn, int channelId, String devUser, String devPwd, String param);

        //36.获取报警联动总布防状态设置-云视通2.0
        Observable<BaseBean<OctAlarmLinkDefenceBean>> octGetAlarmLinkDefenceParam(String deviceSn, int channelId, String devUser, String devPwd);

        //37.设置报警联动总布防状态-云视通2.0
        Observable<BaseBean<EmptyBean>> octSetAlarmLinkDefenceParam(String deviceSn, int channelId, String devUser, String devPwd, String param);

        //38.设置驱离-云视通2.0
        Observable<BaseBean<EmptyBean>> octSetAlarmLinkTrigger(String deviceSn, int channelId, String devUser, String devPwd, String status);

        //39.获取码流参数-云视通2.0
        Observable<BaseBean<OctStreamGetParams>> octGetStreamParam(String deviceSn, int channelId, String devUser, String devPwd);

        //40.设置码流参数-云视通2.0
        Observable<BaseBean<EmptyBean>> octSetStreamParam(String deviceSn, int channelId, String devUser, String devPwd, String param);

        Observable<BaseBean<OctSDCardInfoBean>> octGetStorageInfo(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octStorageFormat(String deviceSn, int channelId, String devUser, String devPwd);

        Observable<BaseBean<OctSDCardFormatProBean>> octGetStorageFormatProgress(String deviceSn, int channelId, String devUser, String devPwd, int diskNum, String diskName);

        Observable<BaseBean<AlarmLinkIdBean>> octGetAlarmLinkId(String deviceSn, int channelId, String devUser, String devPwd, String moudel);

        Observable<BaseBean<OctAlarmLinkGetBean>> octAlarmLinkGet(String deviceSn, int channelId, String devUser, String devPwd, int linkId, boolean bDefault);

        Observable<BaseBean<SnapDateBean>> getSnapFileDateList(String deviceSn, int channelId, int startYear, int startMonth, String devUser, String devPwd, boolean isAp);

        Observable<BaseBean<SnapFileListBean>> getSnapFileList(String deviceSn, int channelId, int startYear, int startMonth, int startDay, int page, int pageSize, String devUser, String devPwd, boolean isAp);


        Observable<BaseBean<EmptyBean>> publicChatSetParam(String deviceSn, int channelId, boolean singleCall, String devUser, String devPwd);

        Observable<BaseBean<EmptyBean>> octChatSetParam(String deviceSn, int channelId, boolean singleCall, String devUser, String devPwd, boolean isAp);


        Observable<BaseBean<EmptyBean>> editDeviceYst(String deviceSn, String newDevUser, String newDevPwd);

        Observable<BaseBean<OctDevInfoBean>> octGetDevHwinfo(String deviceSn, int channelId, String devUser, String devPwd, boolean isAp);

        //获取设备VC值
        Observable<BaseBean<OctDevGetVC>> octGetDevVerificationCode(String deviceSn, int channelId, String devUser, String devPwd, boolean isAp);


        Observable<BaseBean<OctAccountModifyUserBean>> octAccountModifyUser(String deviceSn, int channelId, String devUser, String devPwd, String newDevUser, String newDevPwd);


        //共享给我的
        Observable<BaseBean<List<ShareToMeBean>>> shareToMe(String deviceSn);//, String channelId


        Observable<BaseBean<EnableBean>> getHideStatus(String deviceSn, int channelId);

        Observable<BaseBean<EmptyBean>> setHideStatus(String deviceSn, int channelId, boolean enable);


        Observable<BaseBean<OctImageAbilityGetBean>> octGetImageAbility(String deviceSn, int channelId, String devUser, String devPwd, boolean isAp);

        Observable<BaseBean<OctImageAdjustParamBean>> octGetImageAdjustParam(String deviceSn, int channelId, String devUser, String devPwd, boolean isAp);

        Observable<BaseBean<EmptyBean>> octSetImageAdjustParam(String deviceSn, int channelId, String devUser, String devPwd, String param, boolean isAp);


        //画面翻转
        Observable<BaseBean<GetScreenOverTurnBean>> getScreenOverturn(String deviceSn, int channelId);

        Observable<BaseBean<EmptyBean>> controlScreenOverturn(String deviceSn, int channelId, boolean overTurn, boolean rotation);


        //车牌识别参数获取接口
        Observable<BaseBean<RDLPRSystemGetParam>> getParamLPRSystem(String deviceSn, int channelId);

        //车牌识别参数设置接口
        Observable<BaseBean<EmptyBean>> setParamLPRSystem(String deviceSn, int channelId, RDLPRSystemGetParam.ResultBean resultBean);

        //查询设备报警状态
        Observable<BaseBean<AlarmStatusBean>> getAlarmStatus(String deviceSn, int channelId);
        //手动消警后同步服务端状态
        Observable<BaseBean<EmptyBean>> cancelAlarmStatus(String deviceSn, int channelId);

        //手动消警
        Observable<BaseBean<EmptyBean>> cancelAlarmManual(String deviceSn, int channelId, String alarmType);
        Observable<BaseBean<EmptyBean>> octCancelAlarmManual(String deviceSn, int channelId, String devUser, String devPwd, String alarmType);

        //获取4G卡列表
        Observable<BaseBean<SimCardListBean.ResultBean>> get4GSimCardList(String deviceSn, int channelId, HashMap<String,Object> body);
    }

    interface View extends BaseView {
        void getGtrackCalibrationSuccess(GtrackGetCalibrationBean.ResultBean resultBean);

        void getGtrackCalibrationFailed(Throwable t);


        void setGtrackCalibrationSuccess(EmptyBean emptyBean);

        void setGtrackCalibrationFailed(Throwable t);


        void addGtrackMarkPointSuccess(EmptyBean emptyBean);

        void addGtrackMarkPointFailed(Throwable t);

        void setGtrackGuardSuccess(EmptyBean emptyBean);

        void setGtrackGuardFailed(Throwable t);


        void manualGtrackPositionSuccess(EmptyBean emptyBean);

        void manualGtrackPositionFailed(Throwable t);


//
//        void clearGtrackPointSuccess(EmptyBean emptyBean);
//
//        void clearGtrackPointFailed(Throwable t);


        void oneKeyCallPublicSuccess(EmptyBean emptyBean);

        void oneKeyCallPublicFailed(Throwable t);

        void getCallUrlSuccess(String callUrl);

        void getCallUrlFailed(Throwable t);

        void getPlayUrlSuccess(PlayUrlBean playUrlBean);

        void getPlayUrlFailed(Throwable t);


        void getMultiPlayUrlSuccess(List<PlayUrlBean> playUrlBeans);

        void getMultiPlayUrlFailed(Throwable t);


        void getYstPlayUrlSuccess(List<ConnectUrlBean> playUrlBean);

        void getYstPlayUrlFailed(Throwable t);

        void getPublicDeviceInfoSuccess(OctDevInfoBean.ResultBean octDevInfoBean, String deviceSn, int channelId);

        void getPublicDeviceInfoError(Throwable e, String deviceSn, int channelId);


        void getChannelsFeaturesSuccess(OctChannelAbilityBean.ResultBean resultBean, String deviceSn, int channelId);

        void getChannelsFeaturesError(Throwable e, String deviceSn, int channelId);


        void octGetChannelsFeaturesSuccess(OctChannelAbilityBean octChannelAbilityBean, String deviceSn, int channelId);

        void octGetChannelsFeaturesFailed(Throwable e, String deviceSn, int channelId);


        void getControlTokenSuccess(ControlTokenBean controlTokenBean);

        void getControlTokenFailed(Throwable e);

        void releaseControlTokenSuccess();

        void releaseControlTokenFailed();

        void ptzControlSuccess();

        void ptzControlFailed(Throwable e);

        void ptzControlStopSuccess();

        void ptzAutoSuccess();

        void ptzAutoFailed(Throwable e);

        void ptzAbilityGetSuccess(OctPtzAbilityBean.ResultBean resultBean, String deviceSn, int channelId);

        void ptzAbilityGetFailed(Throwable e);

        void ptzPresetsGetSuccess(OctPtzPresetsGetBean.ResultBean resultBean);

        void ptzPresetsGetFailed(Throwable e);

        void ptzPresetSetSuccess(ErrorBean errorBean);

        void ptzPresetSetFailed(Throwable e);

        void ptzPresetLocateSuccess(ErrorBean errorBean);

        void ptzPresetLocateFailed(Throwable e);

        void ptzPresetDeleteSuccess(ErrorBean errorBean);

        void ptzPresetDeleteFailed(Throwable e);

        void ptzPatrolsGetSuccess(OctPtzPatrolsGetBean.ResultBean resultBean);

        void ptzPatrolsGetFailed(Throwable e);

        void ptzPatrolCreateSuccess(OctPtzPatrolCreateBean.ResultBean resultBean);

        void ptzPatrolCreateFailed(Throwable e);

        void ptzPatrolDeleteSuccess(ErrorBean errorBean);

        void ptzPatrolDeleteFailed(Throwable e);

        void ptzPatrolLocateSuccess(ErrorBean errorBean);

        void ptzPatrolLocateFailed(Throwable e);

        void ptzPatrolStopSuccess(ErrorBean errorBean);

        void ptzPatrolStopFailed(Throwable e);

        void ptzPatrolGetNodesSuccess(OctPtzPatrolGetNodesBean.ResultBean resultBean);

        void ptzPatrolGetNodesFailed(Throwable e);

        void ptzPatrolAddNodeSuccess(ErrorBean errorBean);

        void ptzPatrolAddNodeFailed(Throwable e);

        void ptzPatrolDelNodeSuccess(ErrorBean errorBean);

        void ptzPatrolDelNodeFailed(Throwable e);

        void ptzPatrolSetSpeedSuccess(ErrorBean errorBean);

        void ptzPatrolSetSpeedFailed(Throwable e);

        void ptzPatrolSetStaySecondsSuccess(ErrorBean errorBean);

        void ptzPatrolSetStaySecondsFailed(Throwable e);

        void ptzTrailRecSuccess(ErrorBean errorBean);

        void ptzTrailRecFailed(Throwable e);

        void ptzTrailActionSuccess(ErrorBean errorBean);

        void ptzTrailActionFailed(Throwable e);

        void ptzTrailGetSuccess(OctPtzTrailGetBean.ResultBean resultBean);

        void ptzTrailGetFailed(Throwable e);

        void ptzGuardGetSuccess(OctPtzGuardGetBean.ResultBean resultBean);

        void ptzGuardGetFailed(Throwable e);

        void ptzGuardSetSuccess(ErrorBean errorBean);

        void ptzGuardSetFailed(Throwable e);


        void ptzGuardActionSuccess(ErrorBean errorBean);

        void ptzGuardActionFailed(Throwable e);

        void ptzGuardPauseSuccess(ErrorBean errorBean);

        void ptzGuardPauseFailed(Throwable e);

        void ptzTimeTaskListGetSuccess(OctPtzTimeTaskListGetBean.ResultBean resultBean);

        void ptzTimeTaskListGetFailed(Throwable e);

        void ptzTimeTaskGetSuccess(OctPtzTimeTaskGetBean.ResultBean resultBean);

        void ptzTimeTaskGetFailed(Throwable e);

        void ptzTimeTaskSetSuccess(ErrorBean errorBean);

        void ptzTimeTaskSetFailed(Throwable e);

        void ptzCalibrateSuccess(EmptyBean emptyBean);

        void ptzCalibrateFailed(Throwable e);


        void getStorageSuccess(List<StorageBean> storageBeans);

        void getStorageError(Throwable e);


        void formatSDCardSuccess();

        void formatSDCardError(Throwable e);


        void octGetDevHwinfoSuccess(OctDevInfoBean octDevInfoBean, String deviceSn, int channelId);

        void octGetDevHwinfoFailed(Throwable e, String deviceSn, int channelId);


        void octGetDevVerificationCodeSuccess(OctDevGetVC octDevGetVC);

        void octGetDevVerificationCodeFailed(Throwable e);


        void ptzMoveStatGetSuccess(OctPtzSpeedBean.ResultBean octPtzSpeedBean);

        void ptzMoveStatGetFailed(Throwable e);

        void ptzOctMoveStatGetSuccess(OctPtzSpeedBean octPtzSpeedBean);

        void ptzOctMoveStatGetFailed(Throwable e);

        void ptzOctControlSuccess();

        void ptzOctControlFailed(Throwable e);

        void ptzOctControlStopSuccess();

        void ptzOctFiStartSuccess();

        void ptzOctFiStartFailed(Throwable e);

        void ptzOctFiStopSuccess();

        void ptzOctFiStopFailed(Throwable e);

        void ptzOctAutoSuccess();

        void ptzOctAutoFailed(Throwable e);

        void ptzOctAbilityGetSuccess(OctPtzAbilityBean octPtzAbilityBean, String deviceSn, int channelId);

        void ptzOctAbilityGetFailed(Throwable e);

        void ptzOctPresetsGetSuccess(OctPtzPresetsGetBean octPtzPresetsGetBean);

        void ptzOctPresetsGetFailed(Throwable e);

        void ptzOctPresetSetSuccess(ErrorBean errorBean);

        void ptzOctPresetSetFailed(Throwable e);

        void ptzOctPresetLocateSuccess(ErrorBean errorBean);

        void ptzOctPresetLocateFailed(Throwable e);

        void ptzOctPresetDeleteSuccess(ErrorBean errorBean);

        void ptzOctPresetDeleteFailed(Throwable e);

        void ptzOctPatrolsGetSuccess(OctPtzPatrolsGetBean octPtzPatrolsGetBean);

        void ptzOctPatrolsGetFailed(Throwable e);

        void ptzOctPatrolCreateSuccess(OctPtzPatrolCreateBean octPtzPatrolCreateBean);

        void ptzOctPatrolCreateFailed(Throwable e);

        void ptzOctPatrolDeleteSuccess(ErrorBean errorBean);

        void ptzOctPatrolDeleteFailed(Throwable e);

        void ptzOctPatrolLocateSuccess(ErrorBean errorBean);

        void ptzOctPatrolLocateFailed(Throwable e);

        void ptzOctPatrolStopSuccess(ErrorBean errorBean);

        void ptzOctPatrolStopFailed(Throwable e);

        void ptzOctPatrolGetNodesSuccess(OctPtzPatrolGetNodesBean octPtzPatrolGetNodesBean);

        void ptzOctPatrolGetNodesFailed(Throwable e);

        void ptzOctPatrolAddNodeSuccess(ErrorBean errorBean);

        void ptzOctPatrolAddNodeFailed(Throwable e);

        void ptzOctPatrolDelNodeSuccess(ErrorBean errorBean);

        void ptzOctPatrolDelNodeFailed(Throwable e);

        void ptzOctPatrolSetSpeedSuccess(ErrorBean errorBean);

        void ptzOctPatrolSetSpeedFailed(Throwable e);

        void ptzOctPatrolSetStaySecondsSuccess(ErrorBean errorBean);

        void ptzOctPatrolSetStaySecondsFailed(Throwable e);

        void ptzOctTrailRecSuccess(ErrorBean errorBean);

        void ptzOctTrailRecFailed(Throwable e);

        void ptzOctTrailActionSuccess(ErrorBean errorBean);

        void ptzOctTrailActionFailed(Throwable e);

        void ptzOctTrailGetSuccess(OctPtzTrailGetBean errorBean);

        void ptzOctTrailGetFailed(Throwable e);

        void ptzOctGuardGetSuccess(OctPtzGuardGetBean bean);

        void ptzOctGuardGetFailed(Throwable e);

        void ptzOctGuardSetSuccess(ErrorBean errorBean);

        void ptzOctGuardSetFailed(Throwable e);

        void ptzOctGuardActionSuccess(ErrorBean errorBean);

        void ptzOctGuardActionFailed(Throwable e);

        void ptzOctGuardPauseSuccess(ErrorBean errorBean);

        void ptzOctGuardPauseFailed(Throwable e);

        void ptzOctTimeTaskListGetSuccess(OctPtzTimeTaskListGetBean octPtzTimeTaskListGetBean);

        void ptzOctTimeTaskListGetFailed(Throwable e);

        void ptzOctTimeTaskGetSuccess(OctPtzTimeTaskGetBean octPtzTimeTaskGetBean);

        void ptzOctTimeTaskGetFailed(Throwable e);

        void ptzOctTimeTaskSetSuccess(ErrorBean errorBean);

        void ptzOctTimeTaskSetFailed(Throwable e);

        void ptzOctCalibrateSuccess(ErrorBean errorBean);

        void ptzOctCalibrateFailed(Throwable e);


        void octGetStorageInfoSuccess(OctSDCardInfoBean octSDCardInfoBean);

        void octGetStorageInfoFailed(Throwable e);


        void octStorageFormatSuccess();

        void octStorageFormatFailed(Throwable e);


        void octGetStorageFormatProgressSuccess(OctSDCardFormatProBean octSDCardFormatProBean);

        void octGetStorageFormatProgressFailed(Throwable e);


        void getSnapFileDateListSuccess(SnapDateBean snapDateBean);

        void getSnapFileDateListFailed(Throwable e);

        void getSnapFileListSuccess(SnapFileListBean snapFileListBean);

        void getSnapFileListFailed(Throwable e);

        void octAccountModifyUserSuccess(OctAccountModifyUserBean octAccountModifyUserBean);

        void octAccountModifyUserFailed(Throwable e);

        void publicChatSetParamSuccess();

        void publicChatSetParamFailed(Throwable e);

        void octChatSetParamSuccess();

        void octChatSetParamFailed(Throwable e);

        void editDeviceYstSuccess();

        void editDeviceYstFailed(Throwable e);

        void getDeviceCloudListSuccess(DeviceCloudBean deviceCloudBean);

        void getDeviceCloudListFailed(Throwable e);

        void shareToMeSuccess(List<ShareToMeBean> shareToMeBeanList);

        void shareToMeError(Throwable e);

        void getHideStatusSuccess(String deviceSn, int channelId, EnableBean enableBean);

        void getHideStatusError(Throwable e);

        void setHideStatusSuccess(boolean enable);

        void setHideStatusError(Throwable e);

        void octGetImageAbilitySuccess(OctImageAbilityGetBean octImageAbilityGetBean);

        void octGetImageAbilityFailed(Throwable e);

        void octGetImageAdjustParamSuccess(OctImageAdjustParamBean data);

        void octGetImageAdjustParamFailed(Throwable e);

        void octSetImageAdjustParamSuccess();

        void octSetImageAdjustParamFailed(Throwable e);

        void getScreenOverturnSuccess(GetScreenOverTurnBean getScreenOverTurnBean);

        void getScreenOverturnError(Throwable e);

        void controlScreenOverturnSuccess();

        void controlScreenOverturnError(Throwable e);

        void getImageDncutParamSuccess(OctImageDncutParamBean.ResultBean resultBean);

        void getImageDncutParamFailed(Throwable e);

        void setImageDncutParamSuccess();

        void setImageDncutParamFailed(Throwable e);

        void getAlarmLinkDefenceParamSuccess(OctAlarmLinkDefenceBean.ResultBean resultBean);

        void getAlarmLinkDefenceParamFailed(Throwable e);

        void setAlarmLinkDefenceParamSuccess();

        void setAlarmLinkDefenceParamFailed(Throwable e);

        void setAlarmLinkTriggerSuccess(String status);

        void setAlarmLinkTriggerFailed(String status, Throwable e);

        void getStreamParamSuccess(OctStreamGetParams.ResultBean resultBean);

        void getStreamParamFailed(Throwable e);

        void setStreamParamSuccess();

        void setStreamParamFailed(Throwable e);

        void getIntelligenceAbilitySuccess(String deviceSn, int channelId, IntelligenceAbilityBean bean);

        void getIntelligenceAbilityError(Throwable e);

        //挥手呼叫参数获取接口
        void getWaveHandCallParamSuccess(String deviceSn, int channelId, IntelligenceWaveHandCallParam.ResultBean resultBean);

        void getWaveHandCallParamError(String deviceSn, int channelId, Throwable e);

        //哭声宠物详情获取接口
        void getCryPetDetailSuccess(String deviceSn, int channelId, SmartAbilityDetailBean resultBean);

        void getCryPetDetailError(String deviceSn, int channelId, Throwable e);


        void getAlarmLinkIdSuccess(String deviceSn, int channelId, AlarmLinkIdBean.ResultBean resultBean);
        void getAlarmLinkIdFailed(String deviceSn, int channelId, Throwable e);

        void getAlarmLinkSuccess(String deviceSn, int channelId, OctAlarmLinkGetBean.ResultBean resultBean);
        void getAlarmLinkFailed(String deviceSn, int channelId, Throwable e);

        void getParamLPRSystemSuccess(String deviceSn, int channelId,RDLPRSystemGetParam rdlprSystemGetParam);
        void getParamLPRSystemFailed(String deviceSn, int channelId,Throwable t);

        void setParamLPRSystemSuccess(String deviceSn, int channelId,EmptyBean emptyBean);
        void setParamLPRSystemFailed(String deviceSn, int channelId,Throwable t);


        void getAlarmStatusSuccess(String deviceSn, int channelId, AlarmStatusBean alarmStatusBean);
        void getAlarmStatusError(Throwable e);
        void cancelAlarmStatusSuccess();
        void cancelAlarmStatusError(Throwable e);
        void cancelAlarmManualSuccess();
        void cancelAlarmManualError(Throwable e);


        //获取4G卡列表
        void get4GSimCardListSuccess(String deviceSn, int channelId, SimCardListBean.ResultBean resultBean);
        void get4GSimCardListError(String deviceSn, int channelId, Throwable e);
    }

}
