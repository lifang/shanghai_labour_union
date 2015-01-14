package com.comdosoft.union.bean.app;

import java.io.Serializable;

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
	
	public Integer getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	
	
}
