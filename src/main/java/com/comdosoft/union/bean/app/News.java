package com.comdosoft.union.bean.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 
 * <br>
 * <功能描述>新闻公告
 *
 * @author gch 2015年1月14日
 *
 */
public class News implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 一级分类
     */
    private String lm;
    /**
     * 二级分类
     */
    private String lm2;
    /**
     * 三级分类
     */
    private String lm3;
    /**
     * 标题
     */
    private String title;
    private String title2;//暂时未使用
    /**
     * 内容
     */
    private String content;
    /**
     * 发布时间
     */
    private Date time;
    private Integer hit;//暂时未使用
    /**
     * 添加者
     */
    private String adduser;
    /**
     * 一级审核
     */
    private Integer sh;
    /**
     * 暂时未使用
     */
    private String tj;
    /**
     * 二级审核
     */
    private Integer sh2;
    /**
     * 二级审核者
     */
    private String sh2user;
    /**
     * 二级审核时间
     */
    private Date sh2time;
    /**
     * 三级审核
     */
    private Integer sh3;
    /**
     * 三级审核者
     */
    private String sh3user;
    /**
     * 三级审核时间
     */
    private Date sh3time;
    private Integer img;//暂时未使用
    private String imgPath;//图片路径
    
    /**  
     * 获取 imgPath  
     * @return imgPath
     */
    public String getImgPath() {
        return imgPath;
    }
    /**  
     * 设置 imgPath  
     * @param imgPath
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    private List<NewsPics> newPicsList=new ArrayList<NewsPics>(0);//关联图片
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
     * 获取 一级分类  
     * @return lm 
     */
    public String getLm() {
        return lm;
    }
    /**  
     * 设置 一级分类  
     * @param lm 
     */
    public void setLm(String lm) {
        this.lm = lm;
    }
    /**  
     * 获取 二级分类  
     * @return lm2 
     */
    public String getLm2() {
        return lm2;
    }
    /**  
     * 设置 二级分类  
     * @param lm2 
     */
    public void setLm2(String lm2) {
        this.lm2 = lm2;
    }
    /**  
     * 获取 三级分类  
     * @return lm3 
     */
    public String getLm3() {
        return lm3;
    }
    /**  
     * 设置 三级分类  
     * @param lm3 
     */
    public void setLm3(String lm3) {
        this.lm3 = lm3;
    }
    /**  
     * 获取 标题  
     * @return title 
     */
    public String getTitle() {
        return title;
    }
    /**  
     * 设置 标题  
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**  
     * 获取 title2  
     * @return title2 
     */
    public String getTitle2() {
        return title2;
    }
    /**  
     * 设置 title2  
     * @param title2 
     */
    public void setTitle2(String title2) {
        this.title2 = title2;
    }
    /**  
     * 获取 内容  
     * @return content 
     */
    public String getContent() {
        return content;
    }
    /**  
     * 设置 内容  
     * @param content 
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**  
     * 获取 发布时间  
     * @return time 
     */
    public Date getTime() {
        return time;
    }
    /**  
     * 设置 发布时间  
     * @param time 
     */
    public void setTime(Date time) {
        this.time = time;
    }
    /**  
     * 获取 hit  
     * @return hit 
     */
    public Integer getHit() {
        return hit;
    }
    /**  
     * 设置 hit  
     * @param hit 
     */
    public void setHit(Integer hit) {
        this.hit = hit;
    }
    /**  
     * 获取 添加者  
     * @return adduser 
     */
    public String getAdduser() {
        return adduser;
    }
    /**  
     * 设置 添加者  
     * @param adduser 
     */
    public void setAdduser(String adduser) {
        this.adduser = adduser;
    }
    /**  
     * 获取 一级审核  
     * @return sh 
     */
    public Integer getSh() {
        return sh;
    }
    /**  
     * 设置 一级审核  
     * @param sh 
     */
    public void setSh(Integer sh) {
        this.sh = sh;
    }
    /**  
     * 获取 暂时未使用  
     * @return tj 
     */
    public String getTj() {
        return tj;
    }
    /**  
     * 设置 暂时未使用  
     * @param tj 
     */
    public void setTj(String tj) {
        this.tj = tj;
    }
    /**  
     * 获取 二级审核  
     * @return sh2 
     */
    public Integer getSh2() {
        return sh2;
    }
    /**  
     * 设置 二级审核  
     * @param sh2 
     */
    public void setSh2(Integer sh2) {
        this.sh2 = sh2;
    }
    /**  
     * 获取 二级审核者  
     * @return sh2user 
     */
    public String getSh2user() {
        return sh2user;
    }
    /**  
     * 设置 二级审核者  
     * @param sh2user 
     */
    public void setSh2user(String sh2user) {
        this.sh2user = sh2user;
    }
    /**  
     * 获取 二级审核时间  
     * @return sh2time 
     */
    public Date getSh2time() {
        return sh2time;
    }
    /**  
     * 设置 二级审核时间  
     * @param sh2time 
     */
    public void setSh2time(Date sh2time) {
        this.sh2time = sh2time;
    }
    /**  
     * 获取 三级审核  
     * @return sh3 
     */
    public Integer getSh3() {
        return sh3;
    }
    /**  
     * 设置 三级审核  
     * @param sh3 
     */
    public void setSh3(Integer sh3) {
        this.sh3 = sh3;
    }
    /**  
     * 获取 三级审核者  
     * @return sh3user 
     */
    public String getSh3user() {
        return sh3user;
    }
    /**  
     * 设置 三级审核者  
     * @param sh3user 
     */
    public void setSh3user(String sh3user) {
        this.sh3user = sh3user;
    }
    /**  
     * 获取 三级审核时间  
     * @return sh3time 
     */
    public Date getSh3time() {
        return sh3time;
    }
    /**  
     * 设置 三级审核时间  
     * @param sh3time 
     */
    public void setSh3time(Date sh3time) {
        this.sh3time = sh3time;
    }
    /**  
     * 获取 img  
     * @return img 
     */
    public Integer getImg() {
        return img;
    }
    /**  
     * 设置 img  
     * @param img 
     */
    public void setImg(Integer img) {
        this.img = img;
    }
    public News() {
        super();
    }
    /**  
     * 获取 newPicsList  
     * @return newPicsList 
     */
    public List<NewsPics> getNewPicsList() {
        return newPicsList;
    }
    /**  
     * 设置 newPicsList  
     * @param newPicsList 
     */
    public void setNewPicsList(List<NewsPics> newPicsList) {
        this.newPicsList = newPicsList;
    }

}
