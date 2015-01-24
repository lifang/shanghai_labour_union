package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * 分店<br>
 * <功能描述>
 *
 * @author gch 2015年1月24日
 *
 */
public class Branch implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 店名
     */
    private String name;
    /**
     * 所在区域
     */
    private String locate;
    /**
     * 具体地址
     */
    private String addr;
    /**
     * 所属商户
     */
    private Merchant merId;
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
     * 获取 店名  
     * @return name
     */
    public String getName() {
        return name;
    }
    /**  
     * 设置 店名  
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**  
     * 获取 所在区域  
     * @return locate
     */
    public String getLocate() {
        return locate;
    }
    /**  
     * 设置 所在区域  
     * @param locate
     */
    public void setLocate(String locate) {
        this.locate = locate;
    }
    /**  
     * 获取 具体地址  
     * @return addr
     */
    public String getAddr() {
        return addr;
    }
    /**  
     * 设置 具体地址  
     * @param addr
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }
    /**  
     * 获取 所属商户  
     * @return merId
     */
    public Merchant getMerId() {
        return merId;
    }
    /**  
     * 设置 所属商户  
     * @param merId
     */
    public void setMerId(Merchant merId) {
        this.merId = merId;
    }
    public Branch() {
        super();
    }
    

}
