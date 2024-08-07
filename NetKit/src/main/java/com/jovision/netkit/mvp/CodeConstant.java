package com.jovision.netkit.mvp;

/**
 * 常量类
 *
 * @author liteng
 * @date 2020/10/31
 */
public class CodeConstant {

    /**
     * 登录:登录类型-手机号和密码
     */
    public static final int LOGIN_LOGIN_TYPE_PHONE_PWD = 0;
    /**
     * 登录:登录类型-手机号和验证码
     */
    public static final int LOGIN_LOGIN_TYPE_PHONE_VERIFY_CODE = 1;

    /**
     * 登录:登录类型-微信第三方登录
     */
    public static final int LOGIN_LOGIN_TYPE_OPEN_ID = 2;

    /**
     * 登录:app类型-Android
     */
    public static final String LOGIN_APP_TYPE_ANDROID = "ANDROID";
    /**
     * 登录:app类型-iOS
     */
    public static final int LOGIN_APP_TYPE_IOS = 1;
    /**
     * 语言-中文
     */
    public static final String CODE_LANGUAGE_CN = "zh-CN";
    /**
     * 语言-英文
     */
    public static final String SEND_VERIFY_CODE_LANGUAGE_EN = "en";

    /**
     * 发送验证码:发送方-邮箱
     */
    public static final int SEND_VERIFY_CODE_SEND_BY_EMAIL = 1;
    /**
     * 发送验证码:发送方-手机
     */
    public static final int SEND_VERIFY_CODE_SEND_BY_PHONE = 2;

    /**
     * 发送验证码:验证码类型-注册/登录
     */
    public static final int SEND_VERIFY_CODE_TYPE_LOGIN_REGISTER = 1;

    /**
     * 发送验证码:验证码类型-重置密码
     */
    public static final int SEND_VERIFY_CODE_TYPE_RESET_PWD = 2;

    /**
     * 发送验证码:验证码类型-注销账号
     */
    public static final int SEND_VERIFY_CODE_TYPE_CANCEL = 3;

    /**
     * 发送验证码:验证码类型-修改手机号
     */
    public static final int SEND_VERIFY_CODE_TYPE_MODIFY_PHONE = 4;

    /**
     * 发送验证码:验证码类型-设备转移
     */
    public static final int SEND_VERIFY_CODE_TYPE_TRANSFER_DEVICE = 5;

    /**
     * 未读标识: 无未读
     */
    public static final int UNREAD_STATUS_NO = 0;
    /**
     * 未读标识: 有未读
     */
    public static final int UNREAD_STATUS_YES = 1;

    /**
     * 已读标识: 未读
     */
    public static final int READ_STATUS_NOT = 0;
    /**
     * 已读标识: 已读
     */
    public static final int READ_STATUS_YES = 1;

    /**
     * 串货举报-审核状态: 通过
     */
    public static final int CROSS_SHIPMENT_REPORT_STATUS_APPROVE = 1;
    /**
     * 串货举报-审核状态: 审核中
     */
    public static final int CROSS_SHIPMENT_REPORT_STATUS_IN_PROGRESS = 2;
    /**
     * 串货举报-审核状态: 驳回
     */
    public static final int CROSS_SHIPMENT_REPORT_STATUS_REJECT = 3;
}
