package com.comdosoft.union.bean.app;

import java.io.Serializable;
/**
 * 
 * 用户<br>
 * <功能描述>
 *
 * @author gch 2015年1月22日
 *
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 工会会员号
     */
    private String labourUnionCode;
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
     * 获取 用户名  
     * @return username
     */
    public String getUsername() {
        return username;
    }
    /**  
     * 设置 用户名  
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**  
     * 获取 密码  
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**  
     * 设置 密码  
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**  
     * 获取 手机号  
     * @return phone
     */
    public String getPhone() {
        return phone;
    }
    /**  
     * 设置 手机号  
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**  
     * 获取 电子邮件  
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**  
     * 设置 电子邮件  
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**  
     * 获取 工会会员号  
     * @return labourUnionCode
     */
    public String getLabourUnionCode() {
        return labourUnionCode;
    }
    /**  
     * 设置 工会会员号  
     * @param labourUnionCode
     */
    public void setLabourUnionCode(String labourUnionCode) {
        this.labourUnionCode = labourUnionCode;
    }
    public User() {
        super();
    }

}
