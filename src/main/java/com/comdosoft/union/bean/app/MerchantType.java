package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * <br>
 * <功能描述>商户分类
 *
 * @author gch 2015年1月14日
 *
 */
public class MerchantType implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 商户类型
     */
    private String hymc;
    /**  
     * 获取 id  
     * @return id id  
     */
    public Integer getId() {
        return id;
    }
    /**  
     * 设置 id  
     * @param id id  
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**  
     * 获取 商户类型  
     * @return hymc 商户类型  
     */
    public String getHymc() {
        return hymc;
    }
    /**  
     * 设置 商户类型  
     * @param hymc 商户类型  
     */
    public void setHymc(String hymc) {
        this.hymc = hymc;
    }
    public MerchantType() {
        super();
    }
    
}
