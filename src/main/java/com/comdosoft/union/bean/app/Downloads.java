package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * 先关下载<br>
 * <功能描述>
 *
 * @author gch 2015年1月22日
 *
 */
public class Downloads implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 图标文件路径
     */
    private String logoFilePath;
    /**
     * 名称
     */
    private String name;
    /**
     * 应用大小
     */
    private Float appSize;
    /**
     * 得分
     */
    private Integer score;
    /**
     * 详细描述
     */
    private String description;
    /**
     * 安卓下载地址
     */
    private String androidDownloadPath;
    /**
     * 苹果应用id号
     */
    private String iosAppId;
    /**  
     * 获取 id  
     * @return id
     */
    public Integer getId() {
        return id;
    }
    /**  
     * 设置 id  
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**  
     * 获取 图标文件路径  
     * @return logoFilePath
     */
    public String getLogoFilePath() {
        return logoFilePath;
    }
    /**  
     * 设置 图标文件路径  
     * @param logoFilePath
     */
    public void setLogoFilePath(String logoFilePath) {
        this.logoFilePath = logoFilePath;
    }
    /**  
     * 获取 名称  
     * @return name
     */
    public String getName() {
        return name;
    }
    /**  
     * 设置 名称  
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**  
     * 获取 应用大小  
     * @return appSize
     */
    public Float getAppSize() {
        return appSize;
    }
    /**  
     * 设置 应用大小  
     * @param appSize
     */
    public void setAppSize(Float appSize) {
        this.appSize = appSize;
    }
    /**  
     * 获取 得分  
     * @return score
     */
    public Integer getScore() {
        return score;
    }
    /**  
     * 设置 得分  
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }
    /**  
     * 获取 详细描述  
     * @return description
     */
    public String getDescription() {
        return description;
    }
    /**  
     * 设置 详细描述  
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**  
     * 获取 安卓下载地址  
     * @return androidDownloadPath
     */
    public String getAndroidDownloadPath() {
        return androidDownloadPath;
    }
    /**  
     * 设置 安卓下载地址  
     * @param androidDownloadPath
     */
    public void setAndroidDownloadPath(String androidDownloadPath) {
        this.androidDownloadPath = androidDownloadPath;
    }
    /**  
     * 获取 苹果应用id号  
     * @return iosAppId
     */
    public String getIosAppId() {
        return iosAppId;
    }
    /**  
     * 设置 苹果应用id号  
     * @param iosAppId
     */
    public void setIosAppId(String iosAppId) {
        this.iosAppId = iosAppId;
    }
    public Downloads() {
        super();
    }
    

}
