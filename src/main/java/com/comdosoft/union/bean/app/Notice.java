package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * <br>
 * <功能描述>公告分类
 *
 * @author gch 2015年1月14日
 *
 */
public class Notice implements Serializable {
    
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
     * 上级分类
     */
    private Integer lmid;
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
     * 获取 上级分类  
     * @return lmid 
     */
    public Integer getLmid() {
        return lmid;
    }
    /**  
     * 设置 上级分类  
     * @param lmid 
     */
    public void setLmid(Integer lmid) {
        this.lmid = lmid;
    }
    public Notice() {
        super();
    }
    
}
