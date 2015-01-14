package com.comdosoft.union.common;

/**
 * 系统公共常量类
 * 
 * @author zengguang
 * 
 */
public interface SysConstant {

    // //////////////////////////////////////////////////用户相关////////////////////////////////////////////////////

    /**
     * 待激活
     */
    int USER_STATUS_1 = 1;
    String USER_STATUS_STR_1 = "待激活";

    /**
     * 正常
     */
    int USER_STATUS_2 = 2;
    String USER_STATUS_STR_2 = "正常";

    /**
     * 过期
     */
    int USER_STATUS_3 = 3;
    String USER_STATUS_STR_3 = "过期";

    /**
     * 初始密码
     */
    String USER_INIT_PWD = "123456";

    // ////////////////////////////////////////////////// 管理员相关////////////////////////////////////////////////////

    /**
     * 系统管理员
     */
    int ADMIN_TYPE_1 = 1;

    /**
     * 普通管理员
     */
    int ADMIN_TYPE_2 = 2;

    /**
     * 待激活
     */
    int ADMIN_STATUS_1 = 1;

    /**
     * 正常
     */
    int ADMIN_STATUS_2 = 2;

    /**
     * 停用
     */
    int ADMIN_STATUS_3 = 3;

    /**
     * 当前session中的系统管理员
     */
    String LOGIN_ADMIN = "admin";

    // //////////////////////////////////////////////////图片相关////////////////////////////////////////////////////

    /**
     * 1通知
     */
    int PICTURE_FOREIGNTYPE_1 = 1;

    /**
     * 2内容
     */
    int PICTURE_FOREIGNTYPE_2 = 2;

    /**
     * 3店铺
     */
    int PICTURE_FOREIGNTYPE_3 = 3;

    /**
     * 4活动
     */
    int PICTURE_FOREIGNTYPE_4 = 4;

    // //////////////////////////////////////////////////店铺相关////////////////////////////////////////////////////

    /**
     * 店铺状态 ：待审核
     */
    int AROUND_STATUS_PENDING = 1;

    /**
     * 店铺状态 ：已审核
     */
    int AROUND_STATUS_PASS = 2;

    /**
     * 店铺状态 ：审核未通过
     */
    int AROUND_STATUS_NOT_PASS = 3;

    // //////////////////////////////////////////////////活动相关////////////////////////////////////////////////////

    /**
     * 活动状态 ：待审核
     */
    int EVENT_STATUS_PENDING = 1;
    String EVENT_STATUS_PENDING_STR = "待审核";

    /**
     * 活动状态 ：已审核
     */
    int EVENT_STATUS_PASS = 2;
    String EVENT_STATUS_PASS_STR = "已审核";

    /**
     * 活动状态 ：审核未通过
     */
    int EVENT_STATUS_NOT_PASS = 3;
    String EVENT_STATUS_NOT_PASS_STR = "审核未通过";

    /**
     * 活动已读状态：未读
     */
    int EVENT_IS_READ_1 = 1;

    /**
     * 活动已读状态：已读
     */
    int EVENT_IS_READ_2 = 2;

    /**
     * 活动参加状态：未参加
     */
    int EVENT_IS_JOIN_1 = 1;

    /**
     * 活动参加状态：已参加
     */
    int EVENT_IS_JOIN_2 = 2;

    // //////////////////////////////////////////////////通知相关////////////////////////////////////////////////////

    /**
     * 1未读
     */
    int NOTIFICATION_ISREAD_1 = 1;

    /**
     * 2已读
     */
    int NOTIFICATION_ISREAD_2 = 2;

    /**
     * 摘要截取长度
     */
    int NOTIFICATION_CONTENT_SHORT_LIMIT = 60;

    /**
     * 1普通
     */
    int NOTIFICATION_TYPE_1 = 1;

    /**
     * 2活动
     */
    int NOTIFICATION_TYPE_2 = 2;

    // //////////////////////////////////////////////////内容相关////////////////////////////////////////////////////

    int DIRECTORY_TYPE_PIR_ARRIVAL = 1;

    int DIRECTORY_TYPE_ARIVAL = 2;

    int DIRECTORY_TYPE_CAMPUS = 3;

    // //////////////////////////////////////////////////分页数量////////////////////////////////////////////////////

    int ROWS = 10;
}
