package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * 险种类型<br>
 * <功能描述>
 *
 * @author gch 2015年1月16日
 *
 */
public class XzType implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 图片
     */
    private String img;
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
     * 获取 图片  
     * @return img 
     */
    public String getImg() {
        return img;
    }
    /**  
     * 设置 图片  
     * @param img 
     */
    public void setImg(String img) {
        this.img = img;
    }
    public XzType() {
        super();
    }
    
}
