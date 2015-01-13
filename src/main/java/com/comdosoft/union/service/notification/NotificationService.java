package com.comdosoft.union.service.notification;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.comdosoft.union.bean.APIRequestParameter;
import com.comdosoft.union.bean.app.AppNotification;
import com.comdosoft.union.bean.app.AppPicture;
import com.comdosoft.union.common.SysConstant;
import com.comdosoft.union.dao.CommonMapper;
import com.comdosoft.union.dao.notification.NotificationMapper;

/**
 * 通知业务层实现类<br>
 * <功能描述>
 *
 * @author zengguang 2014年12月9日
 *
 */
@Service
public class NotificationService {

    @Resource
    private NotificationMapper notificationMapper;

    @Resource
    private CommonMapper commonMapper;

    /**
     * 已读(单条)
     * 
     * @param param
     */
    public void readNotification(Map<Object, Object> param) {
        param.put("notificationIsRead", SysConstant.NOTIFICATION_ISREAD_2);// 1未读2已读
        param.put("updateTime", new Date());
        notificationMapper.readNotification(param);
    }

    /**
     * 已读（全部）
     * 
     * @param param
     */
    public void readAllNotification(Map<Object, Object> param) {
        param.put("notificationIsRead", SysConstant.NOTIFICATION_ISREAD_2);
        Date now = new Date();
        param.put("updateTime", now);
        notificationMapper.readAllNotification(param);
    }

    /**
     * 查询
     * 
     * @param query
     * @return
     */
    public int getNotificationUnReadCount(APIRequestParameter query) {
        query.setStatus(SysConstant.NOTIFICATION_ISREAD_1);
        return notificationMapper.getNotificationUnReadCount(query);
    }

    /**
     * 查询 <带分页>
     * 
     * @param query
     * @return
     */
    public List<Map<Object, Object>> getList(APIRequestParameter query) {
        List<Map<Object, Object>> list = notificationMapper.getList(query);
        Map<Object, Object> queryParam = new HashMap<Object, Object>();
        queryParam.put("foreignType", SysConstant.PICTURE_FOREIGNTYPE_1);// 类型(1通知、2内容、3店铺、4活动)
        String pictureSmallFilePath = null;
        List<AppPicture> pictures = null;
        for (Map<Object, Object> map : list) {
            queryParam.put("foreignId", map.get("notificationId"));
            pictures = commonMapper.getPictures(queryParam);
            if (CollectionUtils.isEmpty(pictures)) {
                pictureSmallFilePath = null;
            } else {
                pictureSmallFilePath = pictures.get(0).getPictureSmallFilePath();
            }
            map.put("pictureSmallFilePath", pictureSmallFilePath);
        }
        return list;
    }

    /**
     * 查询
     * 
     * @param id
     * @return
     */
    public AppNotification getOneById(int id) {
        AppNotification one = notificationMapper.getOneById(id);
        if (one != null) {
            Map<Object, Object> query = new HashMap<Object, Object>();
            query.put("foreignId", id);
            query.put("foreignType", SysConstant.PICTURE_FOREIGNTYPE_1);// 类型(1通知、2内容、3店铺、4活动)
            one.setPictures(commonMapper.getPictures(query));
        }
        return one;
    }

    /**
     * 查询
     * 
     * @param param
     * @return
     */
    public Object getOneByConditions(Map<Object, Object> param) {
        Map<Object, Object> one = notificationMapper.getOneByConditions(param);
        if (one != null) {
            Map<Object, Object> query = new HashMap<Object, Object>();
            query.put("foreignId", param.get("id"));
            query.put("foreignType", SysConstant.PICTURE_FOREIGNTYPE_1);// 类型(1通知、2内容、3店铺、4活动)
            one.put("pictures", commonMapper.getPictures(query));
        }
        return one;
    }

}