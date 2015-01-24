package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * 区域<br>
 * <功能描述>
 *
 * @author gch 2015年1月24日
 *
 */
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Integer orderNo;
    private Integer parentId;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 经度
     */
    private Double longitude;
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
     * 获取 name  
     * @return name
     */
    public String getName() {
        return name;
    }
    /**  
     * 设置 name  
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**  
     * 获取 orderNo  
     * @return orderNo
     */
    public Integer getOrderNo() {
        return orderNo;
    }
    /**  
     * 设置 orderNo  
     * @param orderNo
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
    /**  
     * 获取 parentId  
     * @return parentId
     */
    public Integer getParentId() {
        return parentId;
    }
    /**  
     * 设置 parentId  
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    /**  
     * 获取 纬度  
     * @return latitude
     */
    public Double getLatitude() {
        return latitude;
    }
    /**  
     * 设置 纬度  
     * @param latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    /**  
     * 获取 经度  
     * @return longitude
     */
    public Double getLongitude() {
        return longitude;
    }
    /**  
     * 设置 经度  
     * @param longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public Area() {
        super();
    }
    
}
