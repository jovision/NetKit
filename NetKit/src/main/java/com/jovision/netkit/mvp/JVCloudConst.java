package com.jovision.netkit.mvp;

import java.util.HashMap;

public class JVCloudConst {


    /**********************************  云视通1.0 *************************************************/
    //实时视频what
    public static final int WHAT_CALL_CONNECT_CHANGE = 0xA1;//云视通视频连接回调
    public static final int WHAT_CALL_NORMAL_DATA = 0xA2;//O帧回调 device_type：设备类型  is_jfh：是否带帧头（回放使用）
    public static final int WHAT_CALL_CHAT_DATA = 0xA4;//对讲回调
    public static final int WHAT_CALL_TEXT_DATA = 0xA5;//文本聊天回调
    public static final int WHAT_CALL_NEW_PICTURE = 0xA9;//I帧
    public static final int WHAT_CALL_STAT_REPORT = 0xAA;//数据统计


    //回放视频what
    public static final int WHAT_CALL_CHECK_RESULT = 0xA3;//远程回放文件查询
    public static final int WHAT_CALL_DOWNLOAD = 0xA6;//回放文件下载
    public static final int WHAT_CALL_PLAY_DATA = 0xA7;//回放数据
    public static final int WHAT_CALL_CHECK_DATE_RESULT = 0xB9;//查询远程回放有录像的日期回调 2017.5.18

    //老设备的远程回放结束(04版本Opengel句柄为空，现在很少遇到这种设备 2017.5.15 jy)
    public static final int WHAT_CALL_PLAY_DOOMED = 0xAC;


    //广播回调what
    public static final int WHAT_CALL_LOCAL_LAN_DEVICE = 0xAE;// 云视通纯局域网广播回调
    public static final int WHAT_CALL_LAN_SEARCH_SERVER = 0xA8;// 云视通全网段广播回调


    //实时视频what=0xA1，连接结果 arg2
    public static final int ARG2_CONNECT_OK = 0x01;// 连接成功（全转发 云视通）
    public static final int ARG2_DISCONNECT_OK = 0x02;// 断开连接成功
    public static final int ARG2_NO_RECONNECT = 0x03;// 不必要重复连接
    public static final int ARG2_CONNECT_FAILED = 0x04;// 连接失败，具体错误原因，需解析 msg字段
    public static final int ARG2_NO_CONNECT = 0x05;// 没有连接
    public static final int ARG2_ABNORMAL_DISCONNECT = 0x06;// 连接异常断开（全转发 云视通 共用）
    public static final int ARG2_SERVICE_STOP = 0x07;// 服务停止连接，连接断开
    public static final int ARG2_DISCONNECT_FAILED = 0x08;// 断开连接失败
    public static final int ARG2_OHTER_ERROR = 0x09;// 其他错误
    public static final int ARG2_REAL_DISCONNECTED = -0x03;//视频连接线程断开



    public final static byte JVN_CMD_ONLYI = (byte) 0x61;// 该通道只发关键帧
    public final static byte JVN_CMD_FULL = (byte) 0x62;// 该通道恢复满帧

    //ARG2_CONNECT_FAILED=0x04，msg字段取值
    public static final String JVN_CCONNECTTYPE_ERR_IP_TIMEOUT = "connect ip timeout";//ip地址连接超时
    public static final String JVN_CCONNECTTYPE_ERR_INDEX = "Index not online";//检索不在线
    public static final String JVN_CCONNECTTYPE_ERR_RECHECK = "Recheck error";//预验证错误
    public static final String JVN_CCONNECTTYPE_ERR_VER = "Local Version too old";//主控版本太老，已不支持连接
    public static final String JVN_CCONNECTTYPE_ERR_PARTNER = "Request partner list failed";//请求伙伴列表错误（多播才会有）
    public static final String JVN_CCONNECTTYPE_ERR_NICK_TIME = "Nickname query timeout";//查询别名超时
    public static final String JVN_CCONNECTTYPE_ERR_CHANNEL = "Channel error[1,65535]";//通道号错误
    public static final String JVN_CCONNECTTYPE_ERR_IP = "IP error";//ip地址错误
    public static final String JVN_CCONNECTTYPE_ERR_YST = "YST Error";//云视通号码错误
    public static final String JVN_CCONNECTTYPE_ERR_NICK = "NickName error";//别名错误
    public static final String JVN_CCONNECTTYPE_ERR_PORT = "Port error";//端口错误
    public static final String JVN_CCONNECTTYPE_ERR_PARAM = "param error";//参数错误
    public static final String JVN_CCONNECTTYPE_ERR_QUICK = "connect failed. quick connect failed";//连接失败（助手失败）
    public static final String JVN_CCONNECTTYPE_ERR_NO_CHANNEL = "No Channel service";//无通道服务
    public static final String JVN_CCONNECTTYPE_ERR_LIMIT = "client count limit";//超过最大连接数
    public static final String JVN_CCONNECTTYPE_ERR_CONNECT_TYPE = "connect type invalid";//连接类型错误
    public static final String JVN_CCONNECTTYPE_ERR_TIMEOUT = "Connect Timeout";//连接超时
    public static final String JVN_CCONNECTTYPE_ERR_REQUEST = "Request video failed";//请求视频失败
    public static final String JVN_CCONNECTTYPE_ERR_THREAD = "Start work thread failed";//启动线程失败（内存不够）
    public static final String JVN_CCONNECTTYPE_ERR_PWD = "Passwords is wrong";//密码错误
    public static final String JVN_CCONNECTTYPE_ERR_PWD_TIME = "check Passwords timeout";//密码验证超时
    public static final String JVN_CCONNECTTYPE_ERR_OFFLINE = "YST is Offline";//设备离线
    public static final String JVN_CCONNECTTYPE_ERR_NOT_GET_SERVER_T = "not find turn server";//没有找到转发服务器地址
    public static final String JVN_CCONNECTTYPE_ERR_NOT_SERVER_T = "connect turn server timeout";//连接转发超时
    public static final String JVN_CCONNECTTYPE_ERR_MEMERY = "Memery error";//连接时，内存不足
    public static final String JVN_CCONNECTTYPE_ERR_FORBIDDEN = "connect forbidden";//禁止连接
    public static final String JVN_CCONNECTTYPE_ERR_NICK_NO = "NickName not exist";//别名不存在
    public static final String JVN_CCONNECTTYPE_ERR_UNKNOWN = "Unknown error";//未知错误
    public static final String JVN_CCONNECTTYPE_ERR_DEVICE_IS_BUSY = "Device is busy.";//猫眼 设备正忙，请稍后再连接。
    public static final String JVN_CCONNECTTYPE_ERR_CAMERRA_EXCEPTION = "Camera connect exception.";//猫眼 猫头链接异常,请重新链接。
    public static final HashMap<String, Integer> linkFailedMap = new HashMap<String, Integer>();


    //对讲what=0xA4，连接结果 arg2
    public final static byte ARG2_JVN_RSP_CHATDATA = (byte) 0x41;// 语音数据（IPC已经取消了此音频数据，对讲的音频从监听获取）
    public final static byte ARG2_JVN_RSP_CHATACCEPT = (byte) 0x42;// 同意语音请求
    public final static byte ARG2_JVN_CMD_CHATSTOP = (byte) 0x43;// 停止语音聊天


    //回放下载what = 0xA6，下载进度 arg2 (云视通  云视通2.0 共用)
    public final static byte ARG2_JVN_RSP_DOWNLOADDATA = (byte) 0x21;// 下载数据 length：文件总大小;size本次下载大小，进度需累加
    public final static byte ARG2_JVN_RSP_DOWNLOADOVER = (byte) 0x22;// 下载数据完成
    public final static byte ARG2_JVN_RSP_DOWNLOADE = (byte) 0x23;// 下载数据失败




    //文本聊天回调what= 0xA5,arg2
    public final static byte ARG2_JVN_RSP_TEXTACCEPT = (byte) 0x52;// 同意文本请求
    public final static byte ARG2_JVN_CMD_TEXTSTOP = (byte) 0x53;// 停止文本聊天
    public final static byte ARG2_JVN_RSP_TEXTDATA = (byte) 0x51;// 文本数据


    //文本聊天回调what= 0xA5,arg2=0x51,flag
    public static final byte FLAG_JVN_RC_GETPARAM = 80;// 获取配置信息全的回调
    public static final byte FLAG_JVN_DEVICE_UPDATE = 0;// 设备升级
    public static final byte FLAG_JVN_WIFI_IS_SETTING = 6;// 格式化成功回调
    public static final byte FLAG_JVN_DEVICE_SDCARD_STATE = 7;// 获取SD卡存储容量状态 2015.5.4
    public static final byte FLAG_JVN_GET_USERINFO = 20;// 获得用户名密码请求
    public static final byte FLAG_JVN_RC_EX_SENSOR = 8;// 视频翻转回调
    public final static byte FLAG_JVN_REMOTE_FILES = 1;// 远程回放一天的数据（我自己定义的）
    public final static byte FLAG_JVN_SENDETESTMAIL = 7;// 测试邮件回调
    public final static byte FLAG_JVN_AP_SET_CALLBACK = 11;// 11新wifi配置结果

    public static final int COUNT_JVN_RC_EX_ALARM = 0x07;//报警


    // 视频方向(小维之前的老协议)
    public static final String FORMATTER_EFFECT = "effect_flag=%d;";
    public static final String TAG_EFFECT = "effect_flag";
    public static final int SCREEN_NORMAL = 0;// 0(正),4(反)
    public static final int SCREEN_OVERTURN = 4;// 0(正),4(反)
    public static final int SCREEN_MIRROR = 2;// 0(正),2(镜像)


    // 扩展类型，用于指定哪个模块去处理,lck20120206
    public static final int RC_EX_FIRMUP = 0x01;
    public static final int RC_EX_NETWORK = 0x02;
    public static final int RC_EX_STORAGE = 0x03;
    public static final int RC_EX_ACCOUNT = 0x04;
    public static final int RC_EX_COVERRGN = 0x05;
    public static final int RC_EX_MDRGN = 0X06;
    public static final int EX_MDRGN_SUBMIT = 0x02;
    public static final int RC_EX_ALARM = 0x07;
    public static final int RC_EX_SENSOR = 0x08;
    public static final int RC_EX_PTZ = 0x09;
    public static final int RC_EX_AUDIO = 0x0a;
    public static final int RC_EX_ALARMIN = 0x0b;
    public static final int RC_EX_REGISTER = 0x0c;
    public static final int RC_EX_ROI = 0x0d;
    public static final int RC_EX_QRCODE = 0x0e;
    public static final int RC_EX_IVP = 0x0f;
    public static final int EX_IVP_ASD_SUBMIT = 0x22;


    //文本聊天回调what= 0xA5,arg2=0x51,flag=20，extend_type帐户管理指令
    public static final int EXTEND_TYPE_EX_ACCOUNT_OK = 0x01;
    public static final int EXTEND_TYPE_EX_ACCOUNT_ERR = 0x02;
    public static final int EXTEND_TYPE_EX_ACCOUNT_REFRESH = 0x03;//获取账号信息
    public static final int EXTEND_TYPE_EX_ACCOUNT_ADD = 0x04;
    public static final int EXTEND_TYPE_EX_ACCOUNT_DEL = 0x05;
    public static final int EXTEND_TYPE_EX_ACCOUNT_MODIFY = 0x06;//修改回调


    //文本聊天回调what= 0xA5,arg2=0x51,flag=0，extend_type系统升级指令
    public static final int EXTEND_TYPE_EX_UPLOAD_START = 0x01; //
    public static final int EXTEND_TYPE_EX_UPLOAD_CANCEL = 0x02;// 取消升级命令，升级之前需要先发送取消升级命令，防止其他端也在升级
    public static final int EXTEND_TYPE_EX_UPLOAD_OK = 0x03;// 下载完成回调，收到后发送烧写命令
    public static final int EXTEND_TYPE_EX_UPLOAD_DATA = 0x04;// 下载进度，extend_arg2是下载进度
    public static final int EXTEND_TYPE_EX_FIRMUP_START = 0x05;// 烧写命令回调，extend_arg2是总烧写进度
    public static final int EXTEND_TYPE_EX_FIRMUP_STEP = 0x06;// 烧写进度，extend_arg1是烧写进度
    public static final int EXTEND_TYPE_EX_FIRMUP_OK = 0x07;// 烧写完成回调
    public static final int EXTEND_TYPE_EX_FIRMUP_RET = 0x08;// 烧写结果回调，extend_arg1是烧写结果，1烧写成功，2烧写失败，3，已经是最新版本，其他直接提示错误信息
    public static final int EXTEND_TYPE_EX_FIRMUP_REBOOT = 0xA0;// 设备重启
    public static final int EXTEND_TYPE_EX_FIRMUP_RESTORE = 0xA1;// 设备重置

    //文本聊天回调what= 0xA5,arg2=0x51,flag=0，extend_type=0x08,extend_arg1是烧写结果
    public static final int EXTEND_ARG1_FIRMUP_SUCCESS = 0x01;// 烧写成功
    public static final int EXTEND_ARG1_FIRMUP_FAILED = 0x02;// 烧写失败
    public static final int EXTEND_ARG1_FIRMUP_LATEST = 0x03;// 已经是最新版本
    public final static int EXTEND_ARG1_FIRMUP_INVALID = 0x04;
    public final static int EXTEND_ARG1_FIRMUP_ERROR = 0x05;
    public final static int EXTEND_ARG1_FIRMUP_NOTFIT = 0x06;

    // 升级方法
    public static final int FIRMUP_HTTP = 0x00;
    public static final int FIRMUP_FILE = 0x01;
    public static final int FIRMUP_FTP = 0x02;// 已废弃


    /******************************** 云视通1.0 配置参数方法字段 *************************************/

    //常量字段定义
    public static final String STR_MSG = "msg";
    public static final String STR_FLAG = "flag";
    public static final String STR_PACKET_TYPE = "packet_type";
    public static final String STR_EXTEND_TYPE = "extend_type";
    public static final String STR_EXTEND_MSG = "extend_msg";
    public static final String STR_EXTEND_ARG1 = "extend_arg1";
    public static final String STR_EXTEND_ARG2 = "extend_arg2";


    // 添加第三方报警设备
    public static final String STR_ADD_THIRD_ALRAM_DEV = "addThirdAlarmDev";
    public static final int RC_GPIN_BIND_PTZ = 0x00; // 外设报警联动报警设置回调
    public static final int RC_GPIN_ADD = 0x10; // 外设报警添加
    public static final int RC_GPIN_SET = 0x11; // 外设报警设置
    public static final int RC_GPIN_SECLECT = 0x12; // 外设报警查询
    public static final int RC_GPIN_DEL = 0x13; // 外设报警查询
    public static final int RC_GPIN_SET_SWITCH = 0x14; // 外设报警设置开关(只内部使用)
    public static final int RC_GPIN_SET_SWITCH_TIMEOUT = 0x15; // 外设报警设置开关
    public static final int RC_GPIN_BIND_PTZPRE = 0X18; // 门磁关联预置点
    // 录像存储模式 0: 停止录像 1: 手动录像 2. 报警录像
    public static final String STR_STORAGEMODE = "storageMode";
    public static final String FORMATTER_STORAGE_MODE = "storageMode=%d;";
    public static final int INT_STORAGEMODE_NULL = 0;// 停止录像
    public static final int INT_STORAGEMODE_NORMAL = 1;// 手动录像
    public static final int INT_STORAGEMODE_ALARM = 2;// 报警录像
    public static final int INT_STORAGEMODE_CHFRAME = 3;// 抽帧录像
    // 视频方向(小维之前的老协议)
    public static final String FORMAT_EFFECT = "effect_flag=%d;";
    public static final String STR_EFFECT = "effect_flag";
    public static final int INT_SCREEN_NORMAL = 0;// 0(正),4(反)
    public static final int INT_SCREEN_OVERTURN = 4;// 0(正),4(反)
    public static final int INT_SCREEN_MIRROR = 2;// 0(正),2(镜像)
    // 视频方向(小维之后的新协议)图像反转模式：0（未反转），1（90度反转），2（180度反转），3（270度反转）
    public static final String STR_ROTATE = "rotate";
    public static final String FORMATTER_ROTATE = "rotate=%d;";
    public static final int INT_TAG_ROTATE_0 = 0;
    public static final int INT_TAG_ROTATE_90 = 1;
    public static final int INT_TAG_ROTATE_180 = 2;
    public static final int INT_TAG_ROTATE_270 = 3;
    // 网络校时 通用开关 0：未开启， 1：已开启
    public static final String STR_BSNTP = "bSntp";
    public static final String FORMATTER_BSNTP = "bSntp=%d;";
    // 时间格式
    public static final String STR_TIME_FORMAT = "nTimeFormat";
    // MM/DD/YYYY
    public static final int INT_TIME_TYPE_0 = 0;
    // YYYY-MM-DD
    public static final int INT_TIME_TYPE_1 = 1;
    // DD/MM/YYYY
    public static final int INT_TIME_TYPE_2 = 2;
    // 时区字段
    public static final String STR_TIME_ZONE = "timezone";
    public static final String FORMAT_TIME_ZONE = "timezone=%d;bSntp=1";
    // 对讲模式：1（单向）2（双向）3（单双向）
    public static final String STR_CHATMODE = "chatMode";
    public static final int STR_CHATMODE_S = 1;//单向
    public static final int STR_CHATMODE_D = 2;//双向
    public static final int STR_CHATMODE_SAD = 3;//单双向切换


    // 家用融合后,云台速度
    public static final String STR_MOVESPEED = "moveSpeed";//3-255

    // 家用融合前,云台速度
    public static final String STR_MOTORSPEED = "motorspeed";//3-255

    // 设置码流
    public static final int INT_GET_PARAM = 0x02;//获取码流
    public static final int INT_SET_PARAM = 0x03;
    public static final String STR_STREAM = "MobileQuality";

    //老版本切换码流
    public static final String STR_OLD_STREAM = "MainStreamQos";

    public static final String FORMAT_CHANGE_STREAM = "MobileQuality=%d;";
    // 设置主控发不发音频
    public static final String FORMAT_CHANGE_AUDIO_STATE = "MoRecordOrMonitor=%d;";
    // 手动录像 bRecEnable
    public static final String STR_BRECENABLE = "bRecEnable";

    // 手动录像 bRecEnable
    public static final String FORMAT_BRECENABLE = "bRecEnable=%d;";

    // 报警录像 bRecAlarmEnable
    public static final String STR_BRECALARMENABLE = "bRecAlarmEnable";
    // 老家用字段MobileCH 2：家用 其他非家用
    public static final String STR_MOBILECH = "MobileCH";
    public static final int INT_MOBILECH_HOME = 2;
    // 新家用字段HomeIPCFlag 1：家用 0:其他非家用
    public static final String STR_HOMEIPCFLAG = "HomeIPCFlag";

    // ModeByMicStatus插耳机变双向对讲，拔掉耳机单向对讲（但是此逻辑不用了） 1是可以，0是不行
    public static final String STR_MODEBYMICSTATUS = "ModeByMicStatus";
    // sd卡管理 1:有SD卡 0：没有SD卡
    public static final String STR_NSTORAGE = "nStorage";

    // new sd卡管理 1:有SD卡 0：没有SD卡
    public static final String STR_DISK = "disk_exist";

    public static final int INT_NSTORAGE_HAS_SDCARD = 1;
    public static final int INT_NSTORAGE_NO_SDCARD = 0;
    // SD卡总容量
    public static final String STR_NTOTALSIZE = "nTotalSize";
    // SD卡剩余容量
    public static final String STR_NUSEDSIZE = "nUsedSize";
    // SD卡状态 nStatus: 0:未发现SD卡 1：未格式化 2：存储卡已满 3：录像中... 4：准备就绪
    public static final String STR_NSTATUS = "nStatus";
    // 移动侦测灵敏度
    public static final String STR_NMDSENSITIVITY = "nMDSensitivity";
    public static final String FORMAT_NMDSENSITIVITY = "nMDSensitivity=%d;";

    // 设备安全防护状态
    public static final String STR_SET_DEV_SAFE_STATE = "bAlarmEnable";
    // 设备安全防护状态 通用开关 0：关闭 1：打开
    public static final String FORMAT_SET_DEV_SAFE_STATE = "bAlarmEnable=%d;";
    // 移动侦测开关
    public static final String STR_SET_MDENABLE_STATE = "bMDEnable";
    // 移动侦测开关 通用开关 0：关闭 1：打开
    public static final String FORMAT_SET_MDENABLE_STATE = "bMDEnable=%d;";
    // 设备报警声音开关
    public static final String STR_SET_ALARM_SOUND = "bAlarmSound";


    // 邮件报警开关
    public static final String STR_SEND_ALARM_EMAIL = "nMDOutEMail";
    // 邮件报警参数设置(手机端自定义)
    public static final String STR_PARAM_ALARM_EMAIL = "paramAlarmEMail";
    public static final String FORMAT_ALARM_SEND_TEST_EMAIL = "acMailSender=%s;"// 邮件发送者
            + "acSMTPServer=%s;"// 邮件服务器地址
            + "acSMTPUser=%s;"// 用户名
            + "acSMTPPasswd=%s;"// 密码
            + "acSMTPort=%d;"// 发送邮件端口
            + "acSMTPCrypto=%s;"// 邮件加密方式（none/ssl/tls）
            + "acReceiver0=%s;"// 收件人1
            + "acReceiver1=%s;"// 收件人2
            + "acReceicer2=%s;"// 收件人3
            + "acReciever3=%s;";// 收件人4
    public static final String FORMAT_ALARM_EMAIL_SET = "alarmTime1=%s;"// 报警时间段-%s
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
    public static final String STR_ALARM_TIME = "alarmTime1";
    // 报警间隔
    public static final String STR_ALARM_DELAY = "nAlarmDelay";
    // vms服务器IP地址
    public static final String STR_VMS_SERVER_IP = "vmsServerIp";
    // vms服务器端口
    public static final String STR_VMS_SERVER_PORT = "vmsServerPort";
    // 邮件发送者
    public static final String STR_ACMAILSENDER = "acMailSender";
    // 邮件服务器地址
    public static final String STR_ACSMTPSERVER = "acSMTPServer";
    // 用户名
    public static final String STR_ACSMTPUSER = "acSMTPUser";
    // 密码
    public static final String STR_ACSMTPPASSWD = "acSMTPPasswd";
    // 发送邮件端口
    public static final String STR_ACSMTPORT = "acSMTPPort";
    // 邮件加密方式（none/ssl/tls）
    public static final String STR_ACSMTPCRYPTO = "acSMTPCrypto";
    // 收件人0
    public static final String STR_ACRECEIVER0 = "acReceiver0";
    // 收件人1
    public static final String STR_ACRECEIVER1 = "acReceiver1";
    // 收件人2
    public static final String STR_ACRECEIVER2 = "acReceicer2";
    // 收件人3
    public static final String STR_ACRECEIVER3 = "acReciever3";
    // 设备邮件报警开关 通用开关 0：关闭 1：打开
    public static final String FORMAT_SEND_MAIL = "nMDOutEMail=%d;";
    // 报警时间段字段
    public static final String STR_SET_ALARM_TIME = "alarmTime0";
    // 报警时间段设置
    public static final String FORMAT_SET_ALARM_TIME = "alarmTime0=%s;";
    // 全天报警
    public static final String STR_ALARM_TIME_ALL_DAY = "00:00:00-23:59:59";
    // 报警时间段时间格式化
    public static final String FORMAT_ALARM_TIME = "%s:00-%s:00";
    // 通用开关
    public static final int INT_SWITCH_CLOSE = 0;
    public static final int INT_SWITCH_OPEN = 1;

    /**************** 云视通协议，用户信息字段 ********************/
    //用户id即用户名
    public static final String STR_ID = "ID";
    //用户权限
    public static final String STR_POWER = "POWER";
    //用户描述
    public static final String STR_DESCRIPT = "DESCRIPT";
    //管理员用户名
    public static final String STR_ADMIN = "admin";



    //非IPC添加设备默认用户名
    public static final String STR_ABC = "abc";
    //非IPC添加设备默认密码
    public static final String STR_123 = "123";


    //AP默认ip
    public static final String STR_AP_DEFAULT_IP = "10.10.0.1";

    //AP默认port
    public static final int STR_AP_DEFAULT_PORT = 18320;



    // 设备报警声音开关 通用开关 0：关闭 1：打开
    public static final String FORMAT_SET_ALARM_SOUND = "bAlarmSound=%d;";


    //产品类型
    public static final String STR_PRODUCT_TYPE = "ProductType";
    //产品版本号
    public static final String STR_VERSION = "Version";


    //抽帧录像功能开关
    public static final String STR_BRECCHFRAMEENABLE = "bRecChFrameEnable";
    //抽帧录像时间间隔
    public static final String STR_CHFRAMESEC = "chFrameSec";


    public static final String FORMAT_STORAGE_MODE_OLD = "storageMode=%d;";
    public static final String FORMAT_STORAGE_MODE_NEW = "storageMode=%d;chFrameSec=%d;";


    /* 云视通协议 请求类型 */
    public final static byte JVN_REQ_CHECK = (byte) 0x10;// 请求录像检索
    public final static byte JVN_REQ_DOWNLOAD = (byte) 0x20;// 请求录像下载
    public final static byte JVN_REQ_PLAY = (byte) 0x30;// 请求远程回放
    public final static byte JVN_REQ_CHAT = (byte) 0x40;// 请求语音聊天
    public final static byte JVN_REQ_TEXT = (byte) 0x50;// 请求文本聊天

    /* 云视通协议 请求返回结果类型 */
    public final static byte ARG2_JVN_RSP_DOWNLOADSVDATA = (byte) 0x29;//sv7,nvr下载
    public final static byte JVN_RSP_DLTIMEOUT = (byte) 0x76;// 下载超时
    //    public final static byte JVN_RSP_CHATDATA = (byte) 0x41;// 语音数据
//    public final static byte JVN_RSP_CHATACCEPT = (byte) 0x42;// 同意语音请求
//    public final static byte JVN_RSP_TEXTDATA = (byte) 0x51;// 文本数据
//    public final static byte JVN_RSP_TEXTACCEPT = (byte) 0x52;// 同意文本请求
    public final static byte JVN_REQ_TIMEPOINT_PLAY = (byte) 0x3C;//根据时间点请求远程回放2017.12.14 陈勇新增
    public final static byte SRC_EX_RP_REQ_TIMEPLAY = (byte) 0x0A;//时间轴回放2017.03.09 张羽新增
    public final static byte JVN_CMD_PLAYSEEK = (byte) 0x44;// 播放定位 按帧定位 需要参数：帧数(1~最大帧)

    /* 云视通协议 命令类型 Play 开头都是远程回放 */
    public final static byte JVN_CMD_DOWNLOADSTOP = (byte) 0x24;// 停止下载数据
    public final static byte JVN_CMD_PLAYSTOP = (byte) 0x36;// 停止播放
    public final static byte JVN_CMD_PLAYPAUSE = (byte) 0x37;// 暂停播放
    public final static byte JVN_CMD_PLAYGOON = (byte) 0x38;// 继续播放
    //    public final static byte JVN_CMD_CHATSTOP = (byte) 0x43;// 停止语音聊天
    public final static byte JVN_CMD_TEXTSTOP = (byte) 0x53;// 停止文本聊天
    public final static byte JVN_CMD_YTCTRL = (byte) 0x60;// 云台控制
    public final static byte JVN_CMD_VIDEO = (byte) 0x70;// 实时监控
    public final static byte JVN_CMD_VIDEOPAUSE = (byte) 0x75;// 暂停实时监控




    /* 云视通协议 视频连接方式参数 */
    public final static byte JVN_ALLSERVER = 0;// 所有服务
    public final static byte JVN_ONLYNET = 1;// 只局域网服务
    public final static byte JVN_NOTURN = 0;// 云视通方式时禁用转发
    public final static byte JVN_TRYTURN = 1;// 云视通方式时启用转发
    public final static byte JVN_ONLYTURN = 2;// 云视通方式时仅用转发

    /* 云视通协议 视频连接身份参数 */
    public final static byte TYPE_PC_UDP = 1;// 连接类型 UDP 支持UDP收发完整数据
    public final static byte TYPE_PC_TCP = 2;// 连接类型 TCP 支持TCP收发完整数据
    public final static byte TYPE_MO_TCP = 3;// 连接类型 TCP 支持TCP收发简单数据,普通视频帧等不再发送，只能采用专用接口收发数据(适用于手机监控)
    public final static byte TYPE_MO_UDP = 4;// 连接类型 TCP 支持TCP收发简单数据,普通视频帧等不再发送，只能采用专用接口收发数据(适用于手机监控)
    public final static byte TYPE_3GMO_UDP = 5;// 手机身份连接，手机使用此身份
    public final static byte TYPE_3GMOHOME_UDP = 6;// 主控cv身份连接第一码流


    /* 云视通协议 云台控制类型 */
    public final static byte JVN_YTCTRL_U = 1;// 上
    public final static byte JVN_YTCTRL_D = 2;// 下
    public final static byte JVN_YTCTRL_L = 3;// 左
    public final static byte JVN_YTCTRL_R = 4;// 右
    public final static byte JVN_YTCTRL_A = 5;// 自动
    public final static byte JVN_YTCTRL_GQD = 6;// 光圈大
    public final static byte JVN_YTCTRL_GQX = 7;// 光圈小
    public final static byte JVN_YTCTRL_BJD = 8;// 变焦大
    public final static byte JVN_YTCTRL_BJX = 9;// 变焦小
    public final static byte JVN_YTCTRL_BBD = 10;// 变倍大
    public final static byte JVN_YTCTRL_BBX = 11;// 变倍小
    public final static byte JVN_YTCTRL_UT = 21;// 上停止
    public final static byte JVN_YTCTRL_DT = 22;// 下停止
    public final static byte JVN_YTCTRL_LT = 23;// 左停止
    public final static byte JVN_YTCTRL_RT = 24;// 右停止
    public final static byte JVN_YTCTRL_AT = 25;// 自动停止
    public final static byte JVN_YTCTRL_GQDT = 26;// 光圈大停止
    public final static byte JVN_YTCTRL_GQXT = 27;// 光圈小停止
    public final static byte JVN_YTCTRL_BJDT = 28;// 变焦大停止
    public final static byte JVN_YTCTRL_BJXT = 29;// 变焦小停止
    public final static byte JVN_YTCTRL_BBDT = 30;// 变倍大停止
    public final static byte JVN_YTCTRL_BBXT = 31;// 变倍小停止
    public final static byte SRC_PTZ_ZOOM_ZONE = 0x1E;//云台 3D定位


    public final static byte JVN_CMD_PLAYUP = (byte) 0x33;// 快进
    public final static byte JVN_CMD_PLAYDOWN = (byte) 0x34;// 慢放
    public final static byte JVN_CMD_PLAYDEF = (byte) 0x35;// 原速播放
    public final static byte JVN_CMD_PLAY_SET_SPEED = 0x45;//设置播放速度 2018.10.15 jy

    // 邮件报警回调
    public final static byte EX_ALARM_TEST = (byte) 0x01;

    public final static byte JVN_CMD_TIMEPOINT_PLAYSTOP = (byte) 0x3d;//停止时间点远程回放2016.6.13陈勇增加

    /*********************************
     * 　以下修改设备用户名密码需要的宏定义
     ***************************************/
    public static final int SECRET_KEY = 0x1053564A;
    public static final int MAX_ACCOUNT = 13;
    public static final int SIZE_ID = 20;
    public static final int SIZE_PW = 20;
    public static final int SIZE_DESCRIPT = 32;
    // 用户组定义
    public static final int POWER_GUEST = 0x0001;
    public static final int POWER_USER = 0x0002;
    public static final int POWER_ADMIN = 0x0004;
    public static final int POWER_FIXED = 0x0010;


    //存储管理-修改录像模式
    public static final int TYPE_EX_STORAGE_REC = 0x02;
    public static final int COUNT_EX_STORAGE = 0x03;
    public static final int TYPE_EX_STORAGE_SWITCH = 0x07;




    public static final int DEVICE_TYPE_UNKOWN = -1;
    public static final int DEVICE_TYPE_DVR = 0x01;
    public static final int DEVICE_TYPE_950 = 0x02;
    public static final int DEVICE_TYPE_951 = 0x03;
    public static final int DEVICE_TYPE_IPC = 0x04;
    public static final int DEVICE_TYPE_NVR = 0x05;
    public static final int JAE_ENCODER_SAMR = 0x00;
    public static final int JAE_ENCODER_ALAW = 0x01;
    public static final int JAE_ENCODER_ULAW = 0x02;
    public static final int TEXT_REMOTE_CONFIG = 0x01;
    public static final int TEXT_AP = 0x02;
    public static final int TEXT_GET_STREAM = 0x03;
    public static final int FLAG_WIFI_CONFIG = 0x01;
    public static final int FLAG_WIFI_AP = 0x02;
    public static final int FLAG_BPS_CONFIG = 0x03;
    public static final int FLAG_CONFIG_SCCUESS = 0x04;
    public static final int FLAG_CONFIG_FAILED = 0x05;
    public static final int FLAG_CONFIG_ING = 0x06;
    public static final int FLAG_SET_PARAM = 0x07;
    public static final int FLAG_GPIN_ADD = 0x10;
    public static final int FLAG_GPIN_SET = 0x11;
    public static final int FLAG_GPIN_SELECT = 0x12;
    public static final int FLAG_GPIN_DEL = 0x13;
    public static final int EX_WIFI_CONFIG = 0x0A;
    public static final int ARG1_PLAY_BAD = 0x01;
    public static final int DOWNLOAD_REQUEST = 0x20;
    public static final int DOWNLOAD_START = 0x21;
    public static final int DOWNLOAD_FINISHED = 0x22;
    public static final int DOWNLOAD_ERROR = 0x23;
    public static final int DOWNLOAD_STOP = 0x24;
    public static final int DOWNLOAD_TIMEOUT = 0x76;
    public static final int BAD_STATUS_NOOP = 0x00;
    public static final int BAD_STATUS_OMX = 0x01;
    public static final int BAD_STATUS_FFMPEG = 0x02;
    public static final int BAD_STATUS_OPENGL = 0x03;
    public static final int BAD_STATUS_AUDIO = 0x04;
    public static final int BAD_STATUS_DECODE = 0x05;
    public static final int PLAYBACK_DONE = 0x06;
    public static final int HDEC_BUFFERING = 0x07;
    public static final int BAD_SCREENSHOT_NOOP = 0x00;
    public static final int BAD_SCREENSHOT_INIT = 0x01;
    public static final int BAD_SCREENSHOT_CONV = 0x02;
    public static final int BAD_SCREENSHOT_OPEN = 0x03;





    public static final String FORMATTER_AP_WIFI_SET = "wifi_ssid=%s;wifi_pwd=%s;";


    /* 云视通协议 设置命令 */
    public final static byte RC_GETPARAM = (byte) 0x02;
    public final static byte RC_SETPARAM = (byte) 0x03;
    public final static byte RC_SETSYSTEMTIME = (byte) 0x0A;
    public final static byte EX_STA_GET_APINFO = (byte) 0x0F;
    public final static byte EX_WIFI_AP_CONFIG = (byte) 0x0B; // 针对新AP配置方式，获取到手机端配置的AP信息，便立即返回
    public final static byte RC_EX_FlashJpeg = (byte) 0x0a;
    public final static byte EX_MD_REFRESH = (byte) 0x01;
    public final static byte EX_MD_SUBMIT = (byte) 0x02;
    public final static byte EX_MD_UPDATE = (byte) 0x03;
    public final static byte EX_STORAGE_REC = (byte) 0x02;
    public final static byte RC_EX_SNAPSHOT = (byte) 0x18;
    public final static byte RC_EX_CHECK_FILE = (byte) 0x19;
    public final static byte EX_SNAPSHOT_SET = (byte) 0x01;
    public final static byte EX_DQP_CHECK_FILE = (byte) 0x01;
    public final static byte RC_EX_MD = (byte) 0x06;
    public final static byte RC_EXTEND = (byte) 0x06;
    public final static byte EX_STORAGE_REFRESH = (byte) 0x01;
    public final static byte EX_STORAGE_REC_ON = (byte) 0x02;
    public final static byte EX_STORAGE_REC_OFF = (byte) 0x03;
    public final static byte EX_STORAGE_OK = (byte) 0x04;
    public final static byte EX_STORAGE_ERR = (byte) 0x05;
    public final static byte EX_STORAGE_FORMAT = (byte) 0x06;
    public final static byte EX_FILE_IN_SDCARD = (byte) 0x07;
    public final static byte EX_STORAGE_ACCESS = (byte) 0x09;
    public final static byte RC_EX_COMTRANS = 0x12;
    public final static byte EX_COMTRANS_SET = 0x2A;
    public final static byte EX_COMTRANS_GET = 0x2B;
    public final static int EX_MDRGN_REFRESH = 0X01;
    public final static int EX_MDRGN_UPDATE = 0X03;
    public final static int EX_SENSOR_SUBMIT = 0x02;//设置视频翻转角度
    public final static int EX_SENSOR_SAVE = 0x04;//保存视频翻转角度
    public final static int EX_SENSOR_GETPARAM = 0x05;//获取视频翻转角度
    public final static int EX_STORAGE_GETRECMODE = 0x08;//获取录像模式
    public final static byte EX_ALARM_SUBMIT = (byte) 0x02;

    public final static int RC_EX_REQ_IDR = 0x21;//请求虚拟I帧

    // 远程回放查询播放列表时用的时间格式
    public static final String FORMATTER_REMOTE_CHECK_DATE =
            "%04d%02d%02d000000%04d%02d%02d000000";


    //4 (带时间轴）远程回放查询播有录像的日期
    public static final String FORMATTER_REMOTE_TIMESTAMP_FILE_DATE = "{\"method\":\"remoteRecordDate\"," +
            "\"year\":" + "%d" + ",\"month\":" + "%d" + "}";


    //1 (带时间轴）远程检索命令
    public static final String FORMATTER_REMOTE_TIMESTAMP_CHECK_DATE = "{\"method\": \"remoteSearchRecord\"," +
            " \"year\" : " + "%d" + ",\"month\" : " + "%d" + ",  " +
            "\"day\" : " + "%d" + ",\"type\" : 0}";


    //2 (带时间轴）远程回放播放某时间点的视频
    public static final String FORMATTER_REMOTE_TIMESTAMP_PLAY_AT_TIME = "{\"method\":\"remotePlay\"," +
            "\"chn\":" + "%d" + "," +
            "\"year\":" + "%d" + "," +
            "\"month\":" + "%d" + ",\"day\":"
            + "%d" + ",\"hour\":" + "%d" + ",\"minute\":" + "%d" + ",\"second\":" + "%d" + "}";



    //3 (带时间轴）远程回放移动到有录像的时间点
    public static final String FORMATTER_REMOTE_TIMESTAMP_SEEK_TO_TIME = "{\"method\":\"remoteSeek\"," +
            "\"year\":" + "%d" + "," +
            "\"month\":" + "%d" +
            ",\"day\":" + "%d" +
            ",\"hour\":" + "%d" +
            ",\"minute\":" + "%d" +
            ",\"second\":" + "%d" + "}";


    public final static byte JVN_REQ_TIMEJSON_PLAY = (byte) 0x3c;// 2017.3.1
    // 带时间戳的，远程回放请求，云视通库透传应用层协议数据

    public final static byte JVN_CMD_TIMEJSON_PLAYSTOP = (byte) 0x3d;// 2017.3.1
    // 带时间戳的，停止远程回放

    public final static byte JVN_REQ_CHECK_TAL = (byte) 0x3f;//2017.3.1
    // 带时间戳的，远程检索（检索当天录像文件，以及有录像的日期），云视通库透传应用层协议

    public final static byte JVN_CMD_PLAYSEEK_TIME = (byte) 0x3e;// 2017.3.1
    // 带时间戳的，seek（进度调节），云视通库透传应用层协议





    //码流信息
    //packet.nPacketCount
    public final static int RC_EX_STREAM = 0x17;//
    //extend->nType
    public final static int EX_STREAM_REFRESH = 0x01;//
    public final static int EX_STREAM_SUBMIT = 0x02;//设置码流





    //云视通协议猫眼相关
    //packet.nPacketCount
    public final static int RC_EX_DISPLAY = 0x30;//获取显示设置信息
    //extend->nType
    public final static int EX_DISPLAY_REFRESH = 0x01;//获取显示设置信息
    public final static int EX_DISPLAY_BELLLIGHT = 0x02;//门铃按键灯常闭开关：0（打开），1（常闭）
    public final static int EX_DISPLAY_SUSPENDTIME = 0x03;//休眠时间：15（秒）、60（秒）、120（秒）、180（秒）、-1（秒，一直待机）
    public final static int EX_DISPLAY_STARTGUIDE = 0x04;//开机向导：0（关），1（开）
    public final static int EX_DISPLAY_RINGANDLCD = 0x05;//猫眼门铃是否点亮屏幕：0（不亮），1（亮）

    //packet.nPacketCount
    public final static int RC_EX_INTELLIGENCE = 0x31;//获取智能设置信息
    //extend->nType
    public final static int EX_INTELLIGENCE_ALARMTYPE = 0x02;//报警文件类型：0（图片），1（视频）
    public final static int EX_INTELLIGENCE_PIR = 0x03;//红外感应开关：0（关），1（开）
    public final static int EX_INTELLIGENCE_GSENSOR = 0x04;//重力感应开关：0（关），1（开）
    public final static int EX_INTELLIGENCE_MDETECT = 0x05;//移动侦测开关：0（关），1（开）
    public final static int EX_INTELLIGENCE_SCENEMODE = 0x06;//设备模式：0：高性能   1：普通   2：省电
    public final static int EX_INTELLIGENCE_REFRESH = 0x01;

    //packet.nPacketCount
    public final static int RC_EX_ABOUTEYE = 0x32;//关于猫眼
    //extend->nType
    public final static int EX_ABOUT_REBOOT = 0x02;//重启设备
    public final static int EX_ABOUT_FORMAT = 0x03;//恢复出厂
    public final static int EX_ABOUT_SHUTDOWN = 0x04;//关机
    public final static int EX_ABOUT_REFRESH = 0x01;//获取猫眼信息

    //packet.nPacketCount
    public final static int RC_EX_ALARMOUT = 0x14;//报警信息
    //extend->nType
    public final static int EX_STORAGE_RESOLUTION = 0x10;//nStorageResolution	存储分辨率	0：高清（1280x720） 1：标清（960x540） 2：普通（512x288）
    public final static int EX_STORAGE_RECORDTIME = 0x11;//nRecordTime	录像时长	3秒、6秒、9秒、12秒
    public final static int EX_STORAGE_AUTOSWITCH = 0x12;//bAutoSwitch	自动覆盖开关	0：关 1：开


    //extend->nType
    public final static int EX_ALARMOUT_ALARM_AUDIO = 0x10;//猫眼视频播放界面右上角,主动发报警声音功能
    public final static int EX_ALARMOUT_ALARM_AUDIO_STOP = 0x11;//猫眼视频播放界面右上角,停止发报警声音功能




    //老设备，手机连接主码流，切换码流实现分辨率切换
    public static final String FORMATTER_SET_BPS_FPS = "[CH%d];width=%d;" +
            "height=%d;nMBPH=%d;framerate=%d;rcMode=%d;";


    public final static byte JVN_STREAM_INFO = 3;// 码流配置请求
    public final static byte JVN_PTZ_INFO = 4;// 获取PTZ信息



    /* 请求返回结果类型 */
    public final static byte JVN_RSP_CHECKDATA = (byte) 0x11;// 检索结果
    public final static byte JVN_PTZ_CALLBACK = 0;// PTZ回调


    //extend->nType
    public final static int JVN_STREAM_INFO_INT = 3;//获取到码流数据
    public final static int JVN_SD_FORMAT_SUCCESS = 6;//SD卡格式化成功
    public final static int JVN_SD_STORAGE = 7;//SD卡容量数据
    public final static int JVN_GET_SENSITIVE = 17;//获取到移动侦测灵敏度
    public final static int JVN_SET_SENSITIVE_SUCCESS = 18;//移动灵敏度设置成功
    //    public final static int JVN_GET_USERINFO = 20;//获取设备用户名和密码
    public final static int JVN_GET_ZONETIME = 80;//获取时间相关
    public final static int JVN_GET_REC_MODE = 100;//获取录像模式成功




    /**
     * 设备设置相关
     */

    //设备是否有SD卡，1有SD卡，0没有SD卡
    public static final String STATE_STORAGE_EXIST = "nStorage";
    public static final String STATE_STORAGE_TOTALSIZE = "nTotalSize";//SD卡总容量
    public static final String STATE_STORAGE_USEDSIZE = "nUsedSize";//SD卡已使用容量
    public static final String STATE_STORAGE_MODE = "storageMode";
    //录像模式，0停止录像，1手动录像，2报警录像
    public static final String STATE_STORAGE_STATUS = "nStatus";
    //SD卡状态，0未发现SD卡，2存储卡已满， 3 录像中，4准备就绪
    public static final String STATE_STORAGE_REC = "bRecEnable";
    //手动录像是否启用，1启用，0未启用
    public static final String STATE_STORAGE_REC_ALARM = "bRecAlarmEnable";
    //报警录像是否启用，1启用，0未启用


    //录像天数
    public static final String FORMATTER_RECORD_DAYS = "record_days=%d;";
    //是否启用录像天数
    public static final String FORMATTER_RECORD_DAYS_ENABLE = "RecDays_Enable=%d;";

    //录像保存天数
    public static final String STATE_STORAGE_RECORD_SAVE_DAYS = "record_days";
    //自动删除录像开关
    public static final String STATE_STORAGE_RECORD_DAYS_ENABLE = "RecDays_Enable";
    //最大录像天数
    public static final String STATE_STORAGE_RECORD_MAX_DAYS = "record_maxdays";


    // 报警时间段时间格式化
    public static final String FORMATTER_ALARM_TIME = "%s-%s";

    /**
     * 日期formater
     **/
    public static final String FORMATTER_DATE_AND_TIME0 = "MM/dd/yyyy HH:mm:ss";
    public static final String FORMATTER_DATE_AND_TIME1 = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMATTER_DATE_AND_TIME2 = "dd/MM/yyyy HH:mm:ss";
    public static final String FORMATTER_DATE_AND_TIME = "yyyy-MM-dd HH:mm:ss";


    public static final String FORMATTER_DATE0 = "MM/dd/yyyy";
    public static final String FORMATTER_DATE1 = "yyyy-MM-dd";
    public static final String FORMATTER_DATE2 = "dd/MM/yyyy";

    /********************************** 云视通1.0协议-end *******************************************/
}
