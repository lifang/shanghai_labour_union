package com.comdosoft.union.bean;

import java.io.Serializable;

public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private Integer area_id;
    private Integer area_sub_id;
    private String area_name;
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
     * 获取 area_id  
     * @return area_id
     */
    public Integer getArea_id() {
        return area_id;
    }
    /**  
     * 设置 area_id  
     * @param area_id
     */
    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }
    /**  
     * 获取 area_sub_id  
     * @return area_sub_id
     */
    public Integer getArea_sub_id() {
        return area_sub_id;
    }
    /**  
     * 设置 area_sub_id  
     * @param area_sub_id
     */
    public void setArea_sub_id(Integer area_sub_id) {
        this.area_sub_id = area_sub_id;
    }
    /**  
     * 获取 area_name  
     * @return area_name
     */
    public String getArea_name() {
        return area_name;
    }
    /**  
     * 设置 area_name  
     * @param area_name
     */
    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }
    public City() {
        super();
    }

}
