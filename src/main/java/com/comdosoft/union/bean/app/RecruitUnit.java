package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * <br>
 * <功能描述>招聘单位
 *
 * @author gch 2015年1月14日
 *
 */
public class RecruitUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 单位名称
     */
    private String dwmc;
    /**
     * 单位介绍
     */
    private String dwjs;
    /**
     * 联系方式
     */
    private String lxfs;
    private String bz;//暂时未使用
    private String gwjs;//暂时未使用
    /**
     * 所属行业
     */
    private RecruitIndustry sshy;
    private byte[] logo;//暂时未使用
    /**
     * 区域
     */
    private String locate;
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
     * 获取 单位名称  
     * @return dwmc 
     */
    public String getDwmc() {
        return dwmc;
    }
    /**  
     * 设置 单位名称  
     * @param dwmc 
     */
    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }
    /**  
     * 获取 单位介绍  
     * @return dwjs 
     */
    public String getDwjs() {
        return dwjs;
    }
    /**  
     * 设置 单位介绍  
     * @param dwjs 
     */
    public void setDwjs(String dwjs) {
        this.dwjs = dwjs;
    }
    /**  
     * 获取 联系方式  
     * @return lxfs 
     */
    public String getLxfs() {
        return lxfs;
    }
    /**  
     * 设置 联系方式  
     * @param lxfs 
     */
    public void setLxfs(String lxfs) {
        this.lxfs = lxfs;
    }
    /**  
     * 获取 bz  
     * @return bz 
     */
    public String getBz() {
        return bz;
    }
    /**  
     * 设置 bz  
     * @param bz 
     */
    public void setBz(String bz) {
        this.bz = bz;
    }
    /**  
     * 获取 gwjs  
     * @return gwjs 
     */
    public String getGwjs() {
        return gwjs;
    }
    /**  
     * 设置 gwjs  
     * @param gwjs 
     */
    public void setGwjs(String gwjs) {
        this.gwjs = gwjs;
    }
    /**  
     * 获取 所属行业  
     * @return sshy 
     */
    public RecruitIndustry getSshy() {
        return sshy;
    }
    /**  
     * 设置 所属行业  
     * @param sshy 
     */
    public void setSshy(RecruitIndustry sshy) {
        this.sshy = sshy;
    }
    /**  
     * 获取 logo  
     * @return logo 
     */
    public byte[] getLogo() {
        return logo;
    }
    /**  
     * 设置 logo  
     * @param logo 
     */
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    /**  
     * 获取 区域  
     * @return locate 
     */
    public String getLocate() {
        return locate;
    }
    /**  
     * 设置 区域  
     * @param locate 
     */
    public void setLocate(String locate) {
        this.locate = locate;
    }
    public RecruitUnit() {
        super();
    }
    

}
