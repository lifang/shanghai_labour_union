package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * 数据字典<br>
 * <功能描述>
 *
 * @author gch 2015年1月19日
 *
 */
public class SysCode implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * code值范围
     */
    private String value;
    /**
     * code值
     */
    private String code;
    /**
     * 是否删除 1删除 0不删除
     */
    private Integer isDelete;
    /**
     * 名字
     */
    private String name;
    /**
     * 父类值范围
     */
    private String parent;
    /**
     * 类型
     */
    private String type;
    /**
     * 排序号
     */
    private Integer orderNo;
    /**  
     * 获取 code值范围  
     * @return value 
     */
    public String getValue() {
        return value;
    }
    /**  
     * 设置 code值范围  
     * @param value 
     */
    public void setValue(String value) {
        this.value = value;
    }
    /**  
     * 获取 code值  
     * @return code值 
     */
    public String getCode() {
        return code;
    }
    /**  
     * 设置 code值  
     * @param code值 
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**  
     * 获取 是否删除1删除0不删除  
     * @return isDelete 
     */
    public Integer getIsDelete() {
        return isDelete;
    }
    /**  
     * 设置 是否删除1删除0不删除  
     * @param isDelete 
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    /**  
     * 获取 名字  
     * @return name 
     */
    public String getName() {
        return name;
    }
    /**  
     * 设置 名字  
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**  
     * 获取 父类值范围  
     * @return parent 
     */
    public String getParent() {
        return parent;
    }
    /**  
     * 设置 父类值范围  
     * @param parent 
     */
    public void setParent(String parent) {
        this.parent = parent;
    }
    /**  
     * 获取 类型  
     * @return type 
     */
    public String getType() {
        return type;
    }
    /**  
     * 设置 类型  
     * @param type 
     */
    public void setType(String type) {
        this.type = type;
    }
    /**  
     * 获取 排序号  
     * @return orderNo 
     */
    public Integer getOrderNo() {
        return orderNo;
    }
    /**  
     * 设置 排序号  
     * @param orderNo 
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
    /**  
     * 获取 serialVersionUID  
     * @return serialVersionUID 
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public SysCode() {
        super();
    }

}
