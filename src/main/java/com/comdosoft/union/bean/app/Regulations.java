package com.comdosoft.union.bean.app;

import java.io.Serializable;
import java.util.Date;

/**
 * 法规
 * @author wu
 *
 */
public class Regulations implements Serializable {
	
	private static final long serialVersionUID = 2282270817273486197L;

	private Integer id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	private Date addtime;
	
	public Integer getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
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
	
}
