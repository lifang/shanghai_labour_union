package com.comdosoft.union.bean.app;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <br>
 * <The persistent class for the t_app_notification database table.>
 *
 * @author zengguang 2014年12月5日
 *
 */
public class AppNotification implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private Date createTime;

    private String createUser;

    private Integer eventsId;

    private String notificationContent;

    private String notificationShortContent;

    private String notificationTitle;

    /**
     * 通知类型（1普通2活动）
     */
    private int notificationType;

    private List<AppPicture> pictures;

    private Date updateTime;

    private String updateUser;

    private int version;

    public AppNotification() {
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Integer getEventsId() {
        return this.eventsId;
    }

    public void setEventsId(Integer eventsId) {
        this.eventsId = eventsId;
    }

    public String getNotificationContent() {
        return this.notificationContent;
    }

    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent;
    }

    public String getNotificationShortContent() {
        return this.notificationShortContent;
    }

    public void setNotificationShortContent(String notificationShortContent) {
        this.notificationShortContent = notificationShortContent;
    }

    public String getNotificationTitle() {
        return this.notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public int getNotificationType() {
        return this.notificationType;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }

    /**
     * @return the pictures
     */
    public List<AppPicture> getPictures() {
        return pictures;
    }

    /**
     * @param pictures
     *            the pictures to set
     */
    public void setPictures(List<AppPicture> pictures) {
        this.pictures = pictures;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}