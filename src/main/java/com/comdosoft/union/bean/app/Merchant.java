package com.comdosoft.union.bean.app;

import java.io.Serializable;

/**
 * 
 * <br>
 * <功能描述>商户资料
 *
 * @author gch 2015年1月14日
 *
 */
public class Merchant implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 商户名称
     */
    private String dwmc;
    /**
     * 商户介绍
     */
    private String dwjs;
    /**
     * 商户分类
     */
    private MerchantType sshy; 
    /**
     * logo 暂时未用
     */
    private byte[] logo;
    /**
     * 文件下载（商户地址列表）
     */
    private String jlfilename;
    /**
     * 下载文件名
     */
    private String jlfile;
    /**
     * 优惠活动
     */
    private String yhhd;
    private String yhhd1;
    /**
     * 联系方式
     */
    private String lxfs;
    /**
     * 使用方式
     */
    private String syfs;
    /**
     * 可使用门店
     */
    private String symd;
    /**
     * 用户名
     */
    private String yhm;
    /**
     * 密码
     */
    private String pwd;
    private String username;//暂时不用
    private String password;//暂时不用
    private String site;//暂时不用
    /**
     * 联系电话
     */
    private String tel;//代替 lxfs
    private String logoPath;//logo图片地址
    
    /**  
     * 获取 logoPath  
     * @return logoPath
     */
    public String getLogoPath() {
        return logoPath;
    }
    /**  
     * 设置 logoPath  
     * @param logoPath
     */
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }
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
     * 获取 商户名称  
     * @return dwmc 商户名称  
     */
    public String getDwmc() {
        return dwmc;
    }
    /**  
     * 设置 商户名称  
     * @param dwmc 商户名称  
     */
    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }
    /**  
     * 获取 商户介绍  
     * @return dwjs 商户介绍  
     */
    public String getDwjs() {
        return dwjs;
    }
    /**  
     * 设置 商户介绍  
     * @param dwjs 商户介绍  
     */
    public void setDwjs(String dwjs) {
        this.dwjs = dwjs;
    }
   
    /**  
     * 获取 商户分类  
     * @return sshy 商户分类  
     */
    public MerchantType getSshy() {
        return sshy;
    }
    /**  
     * 设置 商户分类  
     * @param sshy 商户分类  
     */
    public void setSshy(MerchantType sshy) {
        this.sshy = sshy;
    }
    /**  
     * 获取 logo暂时未用  
     * @return logo logo暂时未用  
     */
    public byte[] getLogo() {
        return logo;
    }
    /**  
     * 设置 logo暂时未用  
     * @param logo logo暂时未用  
     */
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    /**  
     * 获取 文件下载（商户地址列表）  
     * @return jlfilename 文件下载（商户地址列表）  
     */
    public String getJlfilename() {
        return jlfilename;
    }
    /**  
     * 设置 文件下载（商户地址列表）  
     * @param jlfilename 文件下载（商户地址列表）  
     */
    public void setJlfilename(String jlfilename) {
        this.jlfilename = jlfilename;
    }
    /**  
     * 获取 下载文件名  
     * @return jlfile 下载文件名  
     */
    public String getJlfile() {
        return jlfile;
    }
    /**  
     * 设置 下载文件名  
     * @param jlfile 下载文件名  
     */
    public void setJlfile(String jlfile) {
        this.jlfile = jlfile;
    }
    /**  
     * 获取 yhhd1  
     * @return yhhd1 
     */
    public String getYhhd1() {
        return yhhd1;
    }
    /**  
     * 设置 yhhd1  
     * @param yhhd1 
     */
    public void setYhhd1(String yhhd1) {
        this.yhhd1 = yhhd1;
    }
    /**  
     * 获取 优惠活动  
     * @return yhhd 优惠活动  
     */
    public String getYhhd() {
        return yhhd;
    }
    /**  
     * 设置 优惠活动  
     * @param yhhd 优惠活动  
     */
    public void setYhhd(String yhhd) {
        this.yhhd = yhhd;
    }
    /**  
     * 获取 联系方式  
     * @return lxfs 联系方式  
     */
    public String getLxfs() {
        return lxfs;
    }
    /**  
     * 设置 联系方式  
     * @param lxfs 联系方式  
     */
    public void setLxfs(String lxfs) {
        this.lxfs = lxfs;
    }
    /**  
     * 获取 使用方式  
     * @return syfs 使用方式  
     */
    public String getSyfs() {
        return syfs;
    }
    /**  
     * 设置 使用方式  
     * @param syfs 使用方式  
     */
    public void setSyfs(String syfs) {
        this.syfs = syfs;
    }
    /**  
     * 获取 可使用门店  
     * @return symd 可使用门店  
     */
    public String getSymd() {
        return symd;
    }
    /**  
     * 设置 可使用门店  
     * @param symd 可使用门店  
     */
    public void setSymd(String symd) {
        this.symd = symd;
    }
    /**  
     * 获取 用户名  
     * @return yhm 用户名  
     */
    public String getYhm() {
        return yhm;
    }
    /**  
     * 设置 用户名  
     * @param yhm 用户名  
     */
    public void setYhm(String yhm) {
        this.yhm = yhm;
    }
    /**  
     * 获取 密码  
     * @return pwd 密码  
     */
    public String getPwd() {
        return pwd;
    }
    /**  
     * 设置 密码  
     * @param pwd 密码  
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    /**  
     * 获取 username  
     * @return username username  
     */
    public String getUsername() {
        return username;
    }
    /**  
     * 设置 username  
     * @param username username  
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**  
     * 获取 password  
     * @return password password  
     */
    public String getPassword() {
        return password;
    }
    /**  
     * 设置 password  
     * @param password password  
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**  
     * 获取 site  
     * @return site site  
     */
    public String getSite() {
        return site;
    }
    /**  
     * 设置 site  
     * @param site site  
     */
    public void setSite(String site) {
        this.site = site;
    }
    public Merchant() {
        super();
    }
    /**  
     * 获取 联系电话  
     * @return tel
     */
    public String getTel() {
        return tel;
    }
    /**  
     * 设置 联系电话  
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
}
