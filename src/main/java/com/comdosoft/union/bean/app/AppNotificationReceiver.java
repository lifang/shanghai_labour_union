package com.comdosoft.union.bean.app;

import java.io.Serializable;
import java.util.Date;

/**
 * <br>
 * <The persistent class for the t_app_notification_receiver database table.>
 *
 * @author zengguang 2014年12月5日
 *
 */
public class AppNotificationReceiver implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private Date createTime;

    private String createUser;

    private int notificationId;

    /**
     * 是否已读(1未读2已读)
     */
    private int notificationIsRead;

    private int studentId;

    private Date updateTime;

    private String updateUser;

    private int version;

    public AppNotificationReceiver() {
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

    public int getNotificationId() {
        return this.notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getNotificationIsRead() {
        return this.notificationIsRead;
    }

    public void setNotificationIsRead(int notificationIsRead) {
        this.notificationIsRead = notificationIsRead;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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