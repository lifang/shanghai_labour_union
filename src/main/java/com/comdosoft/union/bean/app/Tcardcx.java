package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * 在职险种人员信息<br>
 * <功能描述>
 *
 * @author gch 2015年1月16日
 *
 */
public class Tcardcx implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 姓名
     */
    private String cxm;
    /**
     * 身份证号
     */
    private String csfzh;
    /**
     * 日期
     */
    private String dqbrq;
    /**
     * 险种
     */
    private String xz;
    /**
     * 险种类型
     */
    private XzType xzId;
    /**  
     * 获取 姓名  
     * @return cxm 
     */
    public String getCxm() {
        return cxm;
    }
    /**  
     * 设置 姓名  
     * @param cxm 
     */
    public void setCxm(String cxm) {
        this.cxm = cxm;
    }
    /**  
     * 获取 身份证号  
     * @return csfzh 
     */
    public String getCsfzh() {
        return csfzh;
    }
    /**  
     * 设置 身份证号  
     * @param csfzh 
     */
    public void setCsfzh(String csfzh) {
        this.csfzh = csfzh;
    }
  
    /**  
     * 获取 日期  
     * @return dqbrq 
     */
    public String getDqbrq() {
        return dqbrq;
    }
    /**  
     * 设置 日期  
     * @param dqbrq 
     */
    public void setDqbrq(String dqbrq) {
        this.dqbrq = dqbrq;
    }
    /**  
     * 获取 险种  
     * @return xz 
     */
    public String getXz() {
        return xz;
    }
    /**  
     * 设置 险种  
     * @param xz 
     */
    public void setXz(String xz) {
        this.xz = xz;
    }
    /**  
     * 获取 险种类型  
     * @return xzId 
     */
    public XzType getXzId() {
        return xzId;
    }
    /**  
     * 设置 险种类型  
     * @param xzId 
     */
    public void setXzId(XzType xzId) {
        this.xzId = xzId;
    }
    public Tcardcx() {
        super();
    }
    
}
