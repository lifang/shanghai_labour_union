package com.comdosoft.union.dao.news;

import java.util.List;
import java.util.Map;

import com.comdosoft.union.bean.APIRequestParameter;
import com.comdosoft.union.bean.app.AppNotification;
import com.comdosoft.union.bean.app.AppNotificationReceiver;

/**
 * 通知Dao层接口
 * 
 * @author zengguang
 * 
 */
public interface NotificationMapper {

    /**
     * 新增
     * 
     * @param bean
     */
    void insert(AppNotification bean);

    /**
     * 新增（批量）
     * 
     * @param bean
     */
    void insertBatch(List<AppNotificationReceiver> list);

    /**
     * 已读(单条)
     * 
     * @param bean
     */
    void readNotification(Map<Object, Object> param);

    /**
     * 已读（全部）
     * 
     * @param param
     */
    void readAllNotification(Map<Object, Object> param);

    /**
     * 查询
     * 
     * @param query
     * @return
     */
    List<Map<Object, Object>> getList(APIRequestParameter query);

    /**
     * 查询
     * 
     * @param id
     * @return
     */
    AppNotification getOneById(int id);

    /**
     * 获取推送消息未读数量
     * 
     * @param query
     * @return
     */
    int getNotificationUnReadCount(APIRequestParameter query);

    /**
     * 查询
     * 
     * @param param
     * @return
     */
    Map<Object, Object> getOneByConditions(Map<Object, Object> param);

}