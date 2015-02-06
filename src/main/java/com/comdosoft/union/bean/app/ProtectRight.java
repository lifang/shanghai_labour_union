package com.comdosoft.union.bean.app;

import java.util.Date;

public class ProtectRight {
	
	private String username;
	private String title;
	private String address;
	private String email;
	private String mobile;
	private String content;
	private Date addtime; 
	private String userip;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public String getUserip() {
		return userip;
	}
	public void setUserip(String userip) {
		this.userip = userip;
	}
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ProtectRight [username=" + username + ", title=" + title + ", address=" + address + ", email=" + email + ", mobile=" + mobile + ", content=" + content + ", addtime=" + addtime + ", userip=" + userip + "]";
    }
	
}
