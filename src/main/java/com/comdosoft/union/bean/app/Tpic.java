package com.comdosoft.union.bean.app;
/**
 * 商户图片表
 *
 */
public class Tpic {
	private Integer id;
	private String pic;//图片地址
	private Integer pid;//关联机构id
	
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "Tpic [id=" + id + ", pic=" + pic + ", pid=" + pid + "]";
	}
	public Tpic() {
		super();
	}
	
}
