package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * <br>
 * <功能描述>招聘职位
 *
 * @author gch 2015年1月14日
 *
 */
public class RecruitPosition implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 单位id
     */
    private Integer dwid;
    /**
     * 职位名称
     */
    private String zwmc;
    /**
     * 职位描述
     */
    private String zwms;
    /**
     * 人数
     */
    private Integer rs;
    /**
     * 审核
     */
    private Integer sh;
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
     * 获取 单位id  
     * @return dwid 
     */
    public Integer getDwid() {
        return dwid;
    }
    /**  
     * 设置 单位id  
     * @param dwid 
     */
    public void setDwid(Integer dwid) {
        this.dwid = dwid;
    }
    /**  
     * 获取 职位名称  
     * @return zwmc 
     */
    public String getZwmc() {
        return zwmc;
    }
    /**  
     * 设置 职位名称  
     * @param zwmc 
     */
    public void setZwmc(String zwmc) {
        this.zwmc = zwmc;
    }
    /**  
     * 获取 职位描述  
     * @return zwms 
     */
    public String getZwms() {
        return zwms;
    }
    /**  
     * 设置 职位描述  
     * @param zwms 
     */
    public void setZwms(String zwms) {
        this.zwms = zwms;
    }
    /**  
     * 获取 人数  
     * @return rs 
     */
    public Integer getRs() {
        return rs;
    }
    /**  
     * 设置 人数  
     * @param rs 
     */
    public void setRs(Integer rs) {
        this.rs = rs;
    }
    /**  
     * 获取 审核  
     * @return sh 
     */
    public Integer getSh() {
        return sh;
    }
    /**  
     * 设置 审核  
     * @param sh 
     */
    public void setSh(Integer sh) {
        this.sh = sh;
    }
    public RecruitPosition() {
        super();
    }

}
