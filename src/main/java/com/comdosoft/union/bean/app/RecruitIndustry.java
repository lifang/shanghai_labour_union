package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * <br>
 * <功能描述>招聘行业
 *
 * @author gch 2015年1月14日
 *
 */
public class RecruitIndustry implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 行业
     */
    private String hymc;
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
     * 获取 行业  
     * @return hymc 
     */
    public String getHymc() {
        return hymc;
    }
    /**  
     * 设置 行业  
     * @param hymc 
     */
    public void setHymc(String hymc) {
        this.hymc = hymc;
    }
    public RecruitIndustry() {
        super();
    }
    

}
