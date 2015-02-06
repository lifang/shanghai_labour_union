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
     * 单位
     */
    private RecruitUnit dwid;
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
    private String q;//搜索条件 :职位 或者 公司 或者 地点
    private String job_type;//行业类型id
    private String job_locate1;//主区域
    private String job_locate2;//次选区域
  
	public String getJob_locate1() {
		return job_locate1;
	}
	public void setJob_locate1(String job_locate1) {
		this.job_locate1 = job_locate1;
	}
	public String getJob_locate2() {
		return job_locate2;
	}
	public void setJob_locate2(String job_locate2) {
		this.job_locate2 = job_locate2;
	}
	public String getJob_type() {
		return job_type;
	}
	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}
	/**  
     * 获取 q  
     * @return q 
     */
    public String getQ() {
        return q;
    }
    /**  
     * 设置 q  
     * @param q 
     */
    public void setQ(String q) {
        this.q = q;
    }
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
     * 获取 单位  
     * @return dwid 
     */
    public RecruitUnit getDwid() {
        return dwid;
    }
    /**  
     * 设置 单位  
     * @param dwid 
     */
    public void setDwid(RecruitUnit dwid) {
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
