package com.comdosoft.union.bean.app;

import java.io.Serializable;
import java.util.Date;

/**
 * <br>
 * <The persistent class for the t_app_picture database table.>
 *
 * @author zengguang 2014年12月5日
 *
 */
public class AppPicture implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;

    private Date createTime;

    private String createUser;

    private int foreignId;

    private int foreignType;

    private String pictureLargeFilePath;

    private String pictureSmallFilePath;

    private Date updateTime;

    private String updateUser;

    private int version;

    public AppPicture() {
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

    public int getForeignId() {
        return this.foreignId;
    }

    public void setForeignId(int foreignId) {
        this.foreignId = foreignId;
    }

    public int getForeignType() {
        return this.foreignType;
    }

    public void setForeignType(int foreignType) {
        this.foreignType = foreignType;
    }

    public String getPictureLargeFilePath() {
        return this.pictureLargeFilePath;
    }

    public void setPictureLargeFilePath(String pictureLargeFilePath) {
        this.pictureLargeFilePath = pictureLargeFilePath;
    }

    public String getPictureSmallFilePath() {
        return this.pictureSmallFilePath;
    }

    public void setPictureSmallFilePath(String pictureSmallFilePath) {
        this.pictureSmallFilePath = pictureSmallFilePath;
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