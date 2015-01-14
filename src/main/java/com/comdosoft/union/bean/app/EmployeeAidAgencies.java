package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * <br>
 * <功能描述>职工援助机构
 *
 * @author gch 2015年1月14日
 *
 */
public class EmployeeAidAgencies implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 机构名称
     */
    private String name;
    /**
     * 机构地址
     */
    private String addr;
    /**
     * 电话
     */
    private String tel;
    /**
     * 0代表职工援助服务中心   1代表法律援助服务中心
     */
    private Integer bs;
    /**
     * 接待时间
     */
    private String worktime;
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
     * 获取 机构名称  
     * @return name 
     */
    public String getName() {
        return name;
    }
    /**  
     * 设置 机构名称  
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**  
     * 获取 机构地址  
     * @return addr 
     */
    public String getAddr() {
        return addr;
    }
    /**  
     * 设置 机构地址  
     * @param addr 
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }
    /**  
     * 获取 电话  
     * @return tel 
     */
    public String getTel() {
        return tel;
    }
    /**  
     * 设置 电话  
     * @param tel 
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
    /**  
     * 获取 0代表职工援助服务中心1代表法律援助服务中心  
     * @return bs 
     */
    public Integer getBs() {
        return bs;
    }
    /**  
     * 设置 0代表职工援助服务中心1代表法律援助服务中心  
     * @param bs 
     */
    public void setBs(Integer bs) {
        this.bs = bs;
    }
    /**  
     * 获取 接待时间  
     * @return worktime 
     */
    public String getWorktime() {
        return worktime;
    }
    /**  
     * 设置 接待时间  
     * @param worktime 
     */
    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }
    public EmployeeAidAgencies() {
        super();
    }

}
