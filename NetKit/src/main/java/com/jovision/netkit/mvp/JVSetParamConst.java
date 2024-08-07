package com.jovision.netkit.mvp;

public class JVSetParamConst {

    public static final String FORMATTER_AP_WIFI_SET = "wifi_ssid=%s;wifi_pwd=%s;";
    /**
     * 日期formater
     **/
    public static final String FORMATTER_DATE_AND_TIME0 = "MM/dd/yyyy HH:mm:ss";
    public static final String FORMATTER_DATE_AND_TIME1 = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMATTER_DATE_AND_TIME2 = "dd/MM/yyyy HH:mm:ss";
    public static final String FORMATTER_DATE_AND_TIME3 = "M/d/yyyy HH:mm:ss";
    public static final String FORMATTER_DATE_AND_TIME4 = "yyyy-M-d HH:mm:ss";
    public static final String FORMATTER_DATE_AND_TIME5 = "d/M/yyyy HH:mm:ss";
    public static final String FORMATTER_DATE_AND_TIME0_NEW = "MM/dd/yyyy-HH:mm:ss";
    public static final String FORMATTER_DATE_AND_TIME1_NEW = "yyyy-MM-dd-HH:mm:ss";
    public static final String FORMATTER_DATE_AND_TIME2_NEW = "dd/MM/yyyy-HH:mm:ss";
    public static final String FORMATTER_DATE_AND_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMATTER_DATE_AND_TIME_BY_DIVIDER = "yyyy-MM-dd-HH-mm-ss";
    public static final String FORMATTER_DATE = "yyyy-MM-dd";
    public static final String FORMATTER_TIME = "HH-mm-ss";
    public static final String FORMATTER_HOUR_MIN_SECONDS = "%02d:%02d:%02d";
    // 远程回放查询播放列表时用的时间格式
    public static final String FORMATTER_REMOTE_CHECK_DATE = "%04d%02d%02d000000%04d%02d%02d000000";
    public static final String FORMATTER_REMOTE_DATE = "%04d-%02d-%02d";
    /******************************
     * 设备设置
     ********************************/
    public static final String TAG_MSG = "msg";
    public static final String TAG_FLAG = "flag";
    public static final String TAG_REMOTEVIDEO = "remotevideo";

    public static final String TAG_PACKET_TYPE = "packet_type";
    public static final String TAG_EXTEND_TYPE = "extend_type";
    public static final String TAG_EXTEND_MSG = "extend_msg";
    public static final String TAG_EXTEND_ARG1 = "extend_arg1";
    public static final String TAG_EXTEND_ARG2 = "extend_arg2";

    // 添加第三方报警设备
    public static final String TAG_ADD_THIRD_ALRAM_DEV = "addThirdAlarmDev";
    // 录像存储模式 0: 停止录像 1: 手动录像 2. 报警录像
    public static final String TAG_STORAGEMODE = "storageMode";
    public static final String FORMATTER_STORAGE_MODE_OLD = "storageMode=%d;";
    public static final String FORMATTER_STORAGE_MODE_NEW = "storageMode=%d;chFrameSec=%d;";
    public static final int STORAGEMODE_NULL = 0;// 停止录像
    public static final int STORAGEMODE_NORMAL = 1;// 手动录像
    public static final int STORAGEMODE_ALARM = 2;// 报警录像
    public static final int STORAGEMODE_CHFRAME = 3;// 抽帧录像
    // 视频方向(小维之前的老协议)
    public static final String FORMATTER_EFFECT = "effect_flag=%d;";
    public static final String TAG_EFFECT = "effect_flag";
    public static final int SCREEN_NORMAL = 0;// 0(正),4(反)
    public static final int SCREEN_OVERTURN = 4;// 0(正),4(反)
    public static final int SCREEN_MIRROR = 2;// 0(正),2(镜像)
    // 视频方向(小维之后的新协议)图像反转模式：0（未反转），1（90度反转），2（180度反转），3（270度反转）
    public static final String TAG_ROTATE = "rotate";
    public static final String FORMATTER_ROTATE = "rotate=%d;";
    public static final int TAG_ROTATE_0 = 0;
    public static final int TAG_ROTATE_90 = 1;
    public static final int TAG_ROTATE_180 = 2;
    public static final int TAG_ROTATE_270 = 3;
    // 网络校时 通用开关 0：未开启， 1：已开启
    public static final String TAG_BSNTP = "bSntp";
    public static final String FORMATTER_BSNTP = "bSntp=%d;";
    // 时间格式
    public static final String TAG_TIME_FORMAT = "nTimeFormat";
    public static final String FORMATTER_TIME_FORMAT = "nTimeFormat=%d";
    // MM/DD/YYYY
    public static final int TIME_TYPE_0 = 0;
    // YYYY-MM-DD
    public static final int TIME_TYPE_1 = 1;
    // DD/MM/YYYY
    public static final int TIME_TYPE_2 = 2;
    // 时区字段
    public static final String TIME_ZONE = "timezone";
    public static final String FORMAT_TIME_ZONE = "timezone=%d";
    public static final String TAG_NTIME_ZONE = "nTimeZone";
    public static final String FORMATTER_TIME_ZONE = "timezone=%d;bSntp=1";
    public static final String FORMATTER_TIME_ZONE_STREAM = "nTimeZone=%d";
    // 对讲模式：1（单向）2（双向）3（单双向）4（不支持对讲）
    public static final String TAG_CHATMODE = "chatMode";
    public static final int TAG_CHATMODE_S = 1;//单向
    public static final int TAG_CHATMODE_D = 2;//双向
    public static final int TAG_CHATMODE_SAD = 3;//单双向切换
    public static final int TAG_CHATMODE_UNSUPPORT = 4;//不支持对讲
    // 云台速度 云视通协议
    public static final String TAG_MOVESPEED = "moveSpeed";
    // 设置码流
    public static final int TYPE_SET_PARAM = 0x03;
    public static final String TAG_STREAM = "MobileQuality";
    public static final String FORMATTER_CHANGE_STREAM = "MobileQuality=%d;";
    // 设置主控发不发音频
    public static final String FORMATTER_CHANGE_AUDIO_STATE = "MoRecordOrMonitor=%d;";
    // 手动录像 bRecEnable
    public static final String TAG_BRECENABLE = "bRecEnable";
    // 报警录像 bRecAlarmEnable
    public static final String TAG_BRECALARMENABLE = "bRecAlarmEnable";


    //2016.4.27
    //抽帧录像功能开关
    public static final String TAG_BRECCHFRAMEENABLE = "bRecChFrameEnable";
    //抽帧录像时间间隔
    public static final String TAG_CHFRAMESEC = "chFrameSec";
//    //设置抽帧录像功能和时间间隔
//    public static final String FORMATTER_RECCHFRAME = "bRecChFrameEnable=%d;chFrameSec=%d;";

    // 老家用字段MobileCH 2：家用 其他非家用
    public static final String TAG_MOBILECH = "MobileCH";
    public static final int MOBILECH_HOME = 2;
    // ModeByMicStatus插耳机变双向对讲，拔掉耳机单向对讲（但是此逻辑不用了） 1是可以，0是不行
    public static final String TAG_MODEBYMICSTATUS = "ModeByMicStatus";
    // sd卡管理 1:有SD卡 0：没有SD卡
    public static final String TAG_NSTORAGE = "nStorage";
    public static final int NSTORAGE_HAS_SDCARD = 1;
    public static final int NSTORAGE_NO_SDCARD = 0;
    // SD卡总容量
    public static final String TAG_NTOTALSIZE = "nTotalSize";
    // SD卡剩余容量
    public static final String TAG_NUSEDSIZE = "nUsedSize";
    // SD卡状态 nStatus: 0:未发现SD卡 1：未格式化 2：存储卡已满 3：录像中... 4：准备就绪
    public static final String TAG_NSTATUS = "nStatus";
    // 移动侦测灵敏度
    public static final String TAG_NMDSENSITIVITY = "nMDSensitivity";
    public static final String FORMATTER_NMDSENSITIVITY = "nMDSensitivity=%d;";
    // 设置设备语言 0:中文 1：英文
    public static final String FORMATTER_SET_DEV_LANGUAGE = "nLanguage=%d;";
    // 设备安全防护状态
    public static final String TAG_SET_DEV_SAFE_STATE = "bAlarmEnable";
    // 设备安全防护状态 通用开关 0：关闭 1：打开
    public static final String FORMATTER_SET_DEV_SAFE_STATE = "bAlarmEnable=%d;";
    // 移动侦测开关
    public static final String TAG_SET_MDENABLE_STATE = "bMDEnable";
    // 区域侦测是否开启（只能在PC端设置）
    public static final String TAG_SET_IVPENABLE_STATE = "IVPEnable";
    // 移动跟踪是否可用
    public static final String TAG_SET_TRACK_SUPPORT= "bSupportMTrack";
    //夜间全彩是否可用
    public static final String TAG_SET_NIGHT_COLOR_SUPPORT= "bSupportRedWhiteCtrl";
    // 移动跟踪是否开启
    public static final String TAG_SET_TRACK_ENABLE = "bMoveTrackEn";

    // 移动跟踪灵敏度 灵敏度  0—100    默认 60
    public static final String TAG_SET_TRACK_SENS = "mtrack_sens";

    // 移动跟踪时长 跟踪时长，单位秒，5s - 60s      默认 20s
    public static final String TAG_SET_TRACK_SECONDS = "mtrack_track_sec";

    // 移动跟踪录像是否开启 BOOL  0  1 默认打开的
    public static final String TAG_SET_TRACK_RECORD_ENABLE = "mtrack_record_en";

    // 移动侦测开关 通用开关 0：关闭 1：打开
    public static final String FORMATTER_SET_MDENABLE_STATE = "bMDEnable=%d;";
    // 移动跟踪开关 通用开关 0：关闭 1：打开
    public static final String FORMATTER_SET_MTRACK_STATE = "bMoveTrackEn=%d;";

    // 移动跟踪灵敏度 灵敏度  0—100    默认 60
    public static final String FORMATTER_SET_TRACK_SENS = "mtrack_sens=%d;";

    // 移动跟踪时长 跟踪时长，单位秒，5s - 60s      默认 20s
    public static final String FORMATTER_SET_TRACK_SECONDS = "mtrack_track_sec=%d;";

    // 移动跟踪录像是否开启 BOOL  0  1 默认打开的
    public static final String FORMATTER_SET_TRACK_RECORD_ENABLE = "mtrack_record_en=%d;";

    // 婴儿啼哭报警功能
    public static final String TAG_BBCENABLE = "bBCEnable";
    // 设备报警声音开关
    public static final String TAG_SET_ALARM_SOUND = "bAlarmSound";
    // 设备报警光效开关
    public static final String TAG_SET_ALARM_LIGHT = "bAlarmLight";
    // 夜间全彩模式开关
    public static final String TAG_SET_WHITE_CONTROL_ENABLE = "bRedWhiteCtrlEnabled";

    // 设备是否支持声光报警
    public static final String TAG_SUPPORT_ALARM_LIGHT = "bSupportAlarmLight";

    //设备报警声光状态
    public static final String TAG_SET_ALARM_LIGHT_STATUS = "alarmLightStatus";
    // 设备报警声音开关 通用开关 0：关闭 1：打开
    public static final String FORMATTER_SET_ALARM_SOUND = "bAlarmSound=%d;";//ex_alarm_refresh 获取
    // 设备报警光开关 通用开关 0：关闭 1：打开
    public static final String FORMATTER_SET_ALARM_LIGHT = "bAlarmLight=%d;";
    // 设备报警光临时开关 通用开关 0：关闭 1：打开
    public static final String FORMATTER_SET_ALARM_LIGHT_STATUS = "alarmLightStatus=%d;";
    // 设备夜间全彩模式开关 0 关闭，1 开启
    public static final String FORMATTER_SET_WHITE_CONTROL = "bRedWhiteCtrlEnabled=%d;";
    // 邮件报警开关
    public static final String TAG_SEND_ALARM_EMAIL = "nMDOutEMail";
    // 邮件报警参数设置(手机端自定义)
    public static final String TAG_PARAM_ALARM_EMAIL = "paramAlarmEMail";
    public static final String FORMATTER_ALARM_SEND_TEST_EMAIL = "acMailSender=%s;"// 邮件发送者
            + "acSMTPServer=%s;"// 邮件服务器地址
            + "acSMTPUser=%s;"// 用户名
            + "acSMTPPasswd=%s;"// 密码
            + "acSMTPort=%d;"// 发送邮件端口
            + "acSMTPCrypto=%s;"// 邮件加密方式（none/ssl/tls）
            + "acReceiver0=%s;"// 收件人1
            + "acReceiver1=%s;"// 收件人2
            + "acReceicer2=%s;"// 收件人3
            + "acReciever3=%s;";// 收件人4
    public static final String FORMATTER_ALARM_EMAIL_SET = "alarmTime1=%s;"// 报警时间段-%s
            + "nAlarmDelay=%d;"// 报警间隔
            + "bAlarmSound=%d;"// 报警声音开关
            + "acMailSender=%s;"// 邮件发送者
            + "acSMTPServer=%s;"// 邮件服务器地址
            + "acSMTPUser=%s;"// 用户名
            + "acSMTPPasswd=%s;"// 密码
            + "vmsServerIp=%s;"// vms服务器IP地址
            + "vmsServerPort=%d;"// vms服务器端口
            + "acSMTPort=%d;"// 发送邮件端口
            + "acSMTPCrypto=%s;"// 邮件加密方式（none/ssl/tls）
            + "acReceiver0=%s;"// 收件人1
            + "acReceiver1=%s;"// 收件人2
            + "acReceicer2=%s;"// 收件人3
            + "acReciever3=%s;";// 收件人4
    // 报警时间段
    public static final String TAG_ALARM_TIME = "alarmTime1";
    // 报警间隔
    public static final String TAG_ALARM_DELAY = "nAlarmDelay";
    // vms服务器IP地址
    public static final String TAG_VMS_SERVER_IP = "vmsServerIp";
    // vms服务器端口
    public static final String TAG_VMS_SERVER_PORT = "vmsServerPort";
    // 邮件发送者
    public static final String TAG_ACMAILSENDER = "acMailSender";
    // 邮件服务器地址
    public static final String TAG_ACSMTPSERVER = "acSMTPServer";
    // 用户名
    public static final String TAG_ACSMTPUSER = "acSMTPUser";
    // 密码
    public static final String TAG_ACSMTPPASSWD = "acSMTPPasswd";
    // 发送邮件端口
    public static final String TAG_ACSMTPORT = "acSMTPPort";
    // 邮件加密方式（none/ssl/tls）
    public static final String TAG_ACSMTPCRYPTO = "acSMTPCrypto";
    // 收件人0
    public static final String TAG_ACRECEIVER0 = "acReceiver0";
    // 收件人1
    public static final String TAG_ACRECEIVER1 = "acReceiver1";
    // 收件人2
    public static final String TAG_ACRECEIVER2 = "acReceicer2";
    // 收件人3
    public static final String TAG_ACRECEIVER3 = "acReciever3";
    // 设备邮件报警开关 通用开关 0：关闭 1：打开
    public static final String FORMATTER_SEND_MAIL = "nMDOutEMail=%d;";
    // 报警时间段字段
    public static final String TAG_SET_ALARM_TIME = "alarmTime0";
    // 报警时间段设置
    public static final String FORMATTER_SET_ALARM_TIME = "alarmTime0=%s;";
    // 全天报警
    public static final String ALARM_TIME_ALL_DAY = "00:00:00-23:59:59";
    // 全天报警1
    public static final String ALARM_TIME_ALL_DAY1 = "00:00-23:59";
    // 报警时间段时间格式化
    public static final String FORMATTER_ALARM_TIME = "%s:00-%s:00";

    /******************************
     * 添加第三方报警设备
     ********************************/
    // 报警设备昵称设置,报警开关设置
    public static final String FORMATTER_SET_THIRD_ALARM_DEV = "type=%d;guid=%d;name=%s;enable=%d;";
    // 添加第三方报警设备
    public static final String FORMATTER_ADD_THIRD_ALARM_DEV = "type=%d;";
    // 删除第三方报警设备
    public static final String FORMATTER_DELETE_THIRD_ALARM_DEV = "type=%d;guid=%d;";
    /******************************
     * 账号库字段
     ********************************/
    public static final String KEY_ACCOUNT_MALL = "mall";
    public static final String KEY_ACCOUNT_BBS = "bbs";
    public static final String KEY_ACCOUNT_VIDEO = "video";// http://www.cloudsee.net/mobile/default.action
    public static final String KEY_NAME_ACCOUNT_MALL = "mallName";
    public static final String KEY_NAME_ACCOUNT_BBS = "bbsName";
    public static final String KEY_NAME_ACCOUNT_VIDEO = "videoName";// http://www.cloudsee.net/mobile/default.action
    public static final String KEY_ACCOUNT_JOVISION = "jovision";
    public static final String KEY_ACCOUNT_HELP = "help";
    public static final String KEY_ACCOUNT_CLOUDSTORAGE = "cloudstorage";
    public static final String KEY_ACCOUNT_REGISTER = "register";
    /******************
     * 猫眼相关
     **********************/
    //门铃按键灯开关
    public static final String TAG_BBELLLIGHT = "bBellLight";
    public static final String FORMATTER_BBELLLIGHT = "bBellLight=%d;";
    //休眠时间--流媒体协议
    public static final String TAG_NLCDSHOWTIME = "nLCDShowTime";
    public static final String FORMATTER_NLCDSHOWTIME = "nLCDShowTime=%d;";
    //休眠时间
    public static final String TAG_NSUSPENDTIME = "nSuspendTime";
    public static final String FORMATTER_NSUSPENDTIME = "nSuspendTime=%d;";
    //开机向导
    public static final String TAG_BSTARTGUIDE = "bStartGuide";
    public static final String FORMATTER_BSTARTGUIDE = "bStartGuide=%d;";

    //猫眼门铃是否点亮屏幕：0（不亮），1（亮）
    public static final String TAG_RINGANDLCD = "nRingAndLCD";
    public static final String FORMATTER_RINGANDLCD = "nRingAndLCD=%d;";

    //猫眼语言显示类型：0（中文），1（英文）
    public static final String TAG_LANGUAGE = "nLanguage";
    public static final String FORMATTER_LANGUAGE = "nLanguage=%d;";

    //猫眼宽动态：0（关闭），1（开启）
    public static final String TAG_WDR = "bEnableWdr";
    public static final String FORMATTER_WDR = "bEnableWdr=%d;";

    /****************************************
     * 流媒体门铃独有的，其他的和猫眼相同 start
     ****************************************/
    //门铃铃声：（0~4）
    public static final String TAG_NBELLRING = "nBellRing";
    public static final String FORMATTER_NBELLRING = "nBellRing=%d;";

    //门铃铃声音量：（0~100）
    public static final String TAG_NBELLVOLUME = "nBellVolume";
    public static final String FORMATTER_NBELLVOLUME = "nBellVolume=%d;";

    //门铃夜视模式：0（自动），1（日），2（夜）
    public static final String TAG_NDAYNIGHTMODE = "nDayNightMode";
    public static final String FORMATTER_NDAYNIGHTMODE = "nDayNightMode=%d;";

    //敲门推送门铃消息：0（关闭），1（开启）
    public static final String TAG_BKNOCKDOORNOTICE = "bKnockDoorNotice";
    public static final String FORMATTER_BKNOCKDOORNOTICE = "bKnockDoorNotice=%d;";

    //有人时才报警：0（关闭），1（开启）
    public static final String TAG_BSMDENABLE = "bSMDEnable";
    public static final String FORMATTER_BSMDENABLE = "bSMDEnable=%d;";

    //pir检测间隔时间，报警视频拍摄间隔：（0 ~ 60）
    public static final String TAG_NPIRINTERVAL = "nPirInterval";
    public static final String FORMATTER_NPIRINTERVAL = "nPirInterval=%s;";

    //报警录像时长：（6 ~ 15）
    public static final String TAG_NRECTIME = "nRecTime";
    public static final String FORMATTER_NRECTIME = "nRecTime=%s;";

    //强拆报警：0（关闭），1（开启）
    public static final String TAG_BDISMANTLEALARMENABLE = "bDismantleAlarmEnable";
    public static final String FORMATTER_BDISMANTLEALARMENABLE = "bDismantleAlarmEnable=%d;";

    //省电模式：0（关闭），1（开启）
    public static final String TAG_BPOWERSAVING = "bPowerSaving";
    public static final String FORMATTER_BPOWERSAVING = "bPowerSaving=%d;";

    //剩余电量（3000mv及以上满电）
    public static final String TAG_NBATTERYVAL = "nBatteryVal";

    //ip
    public static final String TAG_IP = "IP";

    //网关
    public static final String TAG_GATEWAY = "GateWay";

    //网络质量
    public static final String TAG_NNETQUALITY = "nNetQuality";

    //存储分辨率
    public static final String TAG_CLOUDRECRESOLUTION = "CloudRecResolution";

    //自动更新：0（关闭），1（开启）
    public static final String TAG_BAUTOUPDATE = "bAutoUpdate";
    public static final String FORMATTER_BAUTOUPDATE = "bAutoUpdate=%d;";

    //快捷回复：0稍等稍等马上来；1这就给您开门，请稍等；2主人不在家，请给小维留言；3您好快递请放门口，谢谢
    public static final String TAG_NQUICKREPLY = "nQuickReply";
    public static final String FORMATTER_NQUICKREPLY = "nQuickReply=%d;";
    /****************************************
     * 流媒体门铃独有的，其他的和猫眼相同 end
     ****************************************/

    //报警文件类型：0（图片），1（视频）
    public static final String TAG_BALARMTYPE = "bAlarmType";
    public static final String FORMATTER_BALARMTYPE = "bAlarmType=%d;";
    //红外感应开关：0（关），1（开）
    public static final String TAG_BPIRENABLE = "bPirEnable";
    public static final String FORMATTER_BPIRENABLE = "bPirEnable=%d;";

    //红外感应时间：0-3s,1-10s,2-15s;
    public static final String TAG_BPIRTIME = "PirTime";
    public static final String FORMATTER_BPIRTIME = "PirTime=%d;";

    //门前报警音开关：0（关），1（开）
    public static final String TAG_BFRIENDALARMENABLE = "bFriendAlarmEnable";
    public static final String FORMATTER_BFRIENDALARMENABLE = "bFriendAlarmEnable=%d;";

    //门铃遮挡开关：0（关），1（开）
    public static final String TAG_BCOVERALARMENABLE = "bCoverEn";
    public static final String FORMATTER_BCOVERALARMENABLE = "bCoverEn=%d;";

    //重力感应开关：0（关），1（开）
    public static final String TAG_BGSENSORENABLE = "bGsensorEnable";
    public static final String FORMATTER_BGSENSORENABLE = "bGsensorEnable=%d;";
    //移动侦测开关：0（关），1（开）
    public static final String TAG_BMDETECT = "bMDetect";
    public static final String FORMATTER_BMDETECT = "bMDetect=%d;";
    //设备模式：0：高性能   1：普通   2：省电
    public static final String TAG_NSCENEMODE = "nSceneMode";
    public static final String FORMATTER_NSCENEMODE = "nSceneMode=%d;";
    //	存储分辨率	0：高清（1280x720） 1：标清（960x540） 2：普通（512x288）
    public static final String TAG_NSTORAGERESOLUTION = "nStorageResolution";
    public static final String FORMATTER_NSTORAGERESOLUTION = "nStorageResolution=%d;";
    //录像时长	3秒、6秒、9秒、12秒
    public static final String TAG_NRECORDTIME = "nRecordTime";
    public static final String FORMATTER_NRECORDTIME = "nRecordTime=%d;";
    //自动覆盖开关	0：关 1：开
    public static final String TAG_BAUTOSWITCH = "bAutoSwitch";
    public static final String FORMATTER_BAUTOSWITCH = "bAutoSwitch=%d;";

    //剩余电量
    public static final String TAG_BATTERYVAL = "BatteryVal";
    //猫眼版本
    public static final String TAG_VERSION = "Version";
    //客服电话
    public static final String TAG_CUSTOMERSERVICE = "CustomerService";
    //网站
    public static final String TAG_WEBSITE = "WebSite";





    //是否支持门磁联动
    public static final String TAG_BDOORAPRESET = "bDoorAPreset";

    //（支持时间轴回放，新增 2017.12.26弃用）
    public static final String TAG_BREPLAYBYTIME1 = "bReplayByTime";//（支持时间轴回放，新增）	0:不支持，1 ：支持


    //（支持时间轴回放，新增 2017.12.26日陈勇新增）
    public static final String TAG_BSUPPORTTIMEPOINTPLAY = "bSupportTimePointPlay";//（支持时间轴回放，新增）	0:不支持，1 ：支持


    //（支持红外灯控制，新增）
    public static final String TAG_BSUPPORTSETREDLED = "bSupportSetRedLed";//（支持红外灯控制，新增）	1:支持   0:不支持

    //（设置图像模式）红外等开关
    public static final String TAG_DAYNIGHTMODE = "daynightMode";//（设置图像模式）0：自动（红外灯开），1 ： 一直彩色（红外灯关），2： 一直黑白
    public static final String FORMATTER_DAYNIGHTMODE = "daynightMode=%d;";

    //设置LED指示灯开关（C5和C3A）
    public static final String LED_CONTROL = "LedControl";
    public static final String LED_CONTROL_SET = "LedControl=%d";//0智能，非夜视开，夜视关，1常开，2常关
    // 是否支持畸变校正
    public static final String TAG_BSUPPORTLDC = "bSupportLDC";// 是否支持畸变校正
    // 畸变校正使能开关
    public static final String TAG_BLDCENABLE = "bLDCEnable";// 畸变校正使能开关 0（关），1（开）
    // 畸变校正参数设置
    public static final String FORMATTER_BLDCENABLE = "bLDCEnable=%d;";
    // 是否支持云存储字段
    public static final String TAG_CLOUDSUPPORT = "CloudSupport";//1是支持，0是不支持
    //C5:LED指示灯开关状态
    public static final int LED_CONTROL_AUTO = 0;//智能 非夜视，开；夜视，关；
    public static final int LED_CONTROL_ON = 1;//常开
    public static final int LED_CONTROL_OFF = 2;//常关


    //云存储tag
    public static final String TAG_CLOUD_ALRAM = "cloudAlarm";


    /******************************************* 流媒体猫眼 ****************************************/

    // 猫眼流媒体 远程回放查询播放列表时用的时间格式
    public static final String FORMATTER_STREAM_CAT_REMOTE_CHECK_DATE = "TimeRange=%04d%02d%02d000000%04d%02d%02d000000";
    public static final String FORMATTER_STREAM_CAT_DOWNLOAD_PATH = "filePath=%s;";
    public static final String FORMATTER_STREAM_CAT_SEEKPOS = "nSeekPos=%d;";


    public static final String TAG_NPACKETTYPE = "nPacketType";//
    public static final String TAG_NCMD = "nCmd";//
    public static final String TAG_DATA = "data";//
    public static final String TAG_PARAM = "nParam";//
    public static final String TAG_RESULT = "result";//
    public static final String TAG_REASON = "reason";//

    // 对讲模式：1（单向）2（双向）3（单双向）
    public static final String TAG_STREAM_CAT_CHATMODE = "nChatMode";

    //是否支持云台
    public static final String TAG_PTZ_SUPPORT = "softptzsupport";
    //是否支持云台3D定位
    public static final String TAG_PTZ_3D_SUPPORT = "bSupport3DLocate";


    //是否180度鱼眼，并且支持增加定位点 2018.08.17 jy
    public static final String TAG_BISFISHEYE = "bIsFishEye";


    //猫眼是否支持传感器联动 2018.11.20 jy
    public static final String TAG_BSUPPORTGATEWAYLINK = "bSupportGatewayLink";


    //云台灵敏度 流媒体协议
    public static final String TAG_PTZ_SPEED = "PtzSpeed";
    public static final String FORMAT_PTZ_SPEED = "PtzSpeed=%d";

    // 码流 1:高清 2:标清 3:流畅
    public static final String TAG_STREAM_CAT_MOBILEQUALITY = "nMobileQuality";

    public static final String FORMATTER_STREAM_CAT_CHANGE_STREAM = "nMobileQuality=%d;";

    public static final String TAG_STREAM_BSUPPORTTHUMBNAIL = "bSupportThumbnail";

    //猫眼流媒体下支持不支持SD卡格式化
    public static final String TAG_STREAM_BSUPPORTSTORAGEFORMAT = "bSupportStorageFormat";
    //外部应用打开QQ群连接 %sQQ群号
    public static final String URL_QQ_GROUP = "mqqapi://card/show_pslcard?src_type=internal&version=1&uin=%s&card_type=group&source=external";

    // TODO 2017/03/03新增 V8 全转发协议下字段定义
    public static final String TAG_ALARM_ALARMTIME0SE = "alarmTime0SE";//防护时间段
    public static final String TAG_TIME_FORMATTER = "timeFormat";//时间格式
    public static final String FORMAT_ALARM_ALARMTIME0SE = "alarmTime0SE=%s";//防护时间段
    public static final String FORMAT_TIME_FORMAT = "timeFormat=%d";//设置时间格式

    // 录像存储模式 0: 停止录像 1: 手动录像 2. 报警录像 3.抽帧录像
    public static final String N_RECORD_TYPE = "nRecordType";
    public static final String FORMAT_STORAGETYPE = "nRecordType=%d";
    public static final String FORMAT_STORAGETYPE_FRAME = "nRecordType=%d;chFrameSec=%d;";

    public static final String TAG_NEFFECT_FLAG = "nEffectFlag";
    public static final String FORMAT_NEFFECT_FLAG = "nEffectFlag=%d";

    public static final String TAG_BSUPPORT_CLOUD = "bSupportXWCloud";

    /**修改管理员密码*/
    public static final String REMOTE_USER_INFO = "user_name=%s;user_pwd=%s;";//用户名、密码



    /********************************** 云视通2.0 配置参数字段 ***************************************/
    public static final String TAG_OCT_MOVESPEED = "movespeed";

    public static final String TAG_OCT_BPTZSUPPORT = "bPtzSupport";//是否支持云台字段

    public static final String TAG_OCT_BCHATSUPPORT = "bChatSupport";//是否支持对讲

    public static final String TAG_OCT_CHATMODE = "RemoteChatAudioMode";//对讲模式;支持的对讲模式，单向：ONE_WAY 双向：TWO_WAY 不支持：NO_WAY

    public static final String VALUE_OCT_CHAT_SINGLE = "ONE_WAY";//单向对讲

    public static final String VALUE_OCT_CHAT_DOUBLE = "TWO_WAY";//双向对讲

    public static final String VALUE_OCT_CHAT_BOTH_MODE = "BOTH_MODE";//单双向都支持

    public static final String VALUE_OCT_CHAT_NO_WAY = "NO_WAY";//不支持
    public static final String VALUE_OCT_CHAT_NONE = "NONE";

    public static final String TAG_OCT_BSUPPORTMTRACK = "bSupportMTrack";//是否支持移动追踪

    public static final String TAG_OCT_PTZ_3D_SUPPORT = "bSupport3DLocate";//是否支持云台3D定位

    public static final String TAG_OCT_BFISHEYE = "bFishEye";//是否鱼眼设备

    public static final String TAG_OCT_BSUPPORTTIMEPOINTPLAY = "bSupportTimePointPlay";//是否支持精准回放

    public static final String TAG_OCT_BDUALLIGHTSUPPORT = "bDualLightSupport";//是否支持双光源，是否支持光效报警

    public static final String TAG_OCT_BHIDELIGHTMODE = "bHideLightMode";//是否隐藏夜间全彩


}
