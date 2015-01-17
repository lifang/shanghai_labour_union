package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * 活动图片<br>
 * <功能描述>
 *
 * @author gch 2015年1月17日
 *
 */
public class ActivityPics implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String smallImg;
    private String bigImg;
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
     * 获取 smallImg  
     * @return smallImg 
     */
    public String getSmallImg() {
        return smallImg;
    }
    /**  
     * 设置 smallImg  
     * @param smallImg 
     */
    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }
    /**  
     * 获取 bigImg  
     * @return bigImg 
     */
    public String getBigImg() {
        return bigImg;
    }
    /**  
     * 设置 bigImg  
     * @param bigImg 
     */
    public void setBigImg(String bigImg) {
        this.bigImg = bigImg;
    }
    public ActivityPics() {
        super();
    }

}
