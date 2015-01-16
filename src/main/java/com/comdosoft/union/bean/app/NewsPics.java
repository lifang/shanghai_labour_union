package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * 新闻图片<br>
 * <功能描述>
 *
 * @author gch 2015年1月16日
 *
 */
public class NewsPics implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 图片地址
     */
    private String pic;
    /**
     * 关联新闻id
     */
    private Integer newsId;
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
     * 获取 图片地址  
     * @return pic 
     */
    public String getPic() {
        return pic;
    }
    /**  
     * 设置 图片地址  
     * @param pic 
     */
    public void setPic(String pic) {
        this.pic = pic;
    }
    /**  
     * 获取 关联新闻id  
     * @return newsId 
     */
    public Integer getNewsId() {
        return newsId;
    }
    /**  
     * 设置 关联新闻id  
     * @param newsId 
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }
    public NewsPics() {
        super();
    }
    

}
