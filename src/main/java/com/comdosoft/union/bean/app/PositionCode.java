package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * <br>
 * <功能描述>职位描述
 *
 * @author gch 2015年1月14日
 *
 */
public class PositionCode implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 职位名称
     */
    private String cname;
    /**
     * 分类代码
     */
    private String ctype;
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
     * 获取 职位名称  
     * @return cname 
     */
    public String getCname() {
        return cname;
    }
    /**  
     * 设置 职位名称  
     * @param cname 
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    /**  
     * 获取 分类代码  
     * @return ctype 
     */
    public String getCtype() {
        return ctype;
    }
    /**  
     * 设置 分类代码  
     * @param ctype 
     */
    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
    public PositionCode() {
        super();
    }

}
