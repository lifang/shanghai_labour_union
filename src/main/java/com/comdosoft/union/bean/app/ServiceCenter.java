package com.comdosoft.union.bean.app;

/**
 * 服务中心
 * @author wu
 *
 */
public class ServiceCenter {

	private Integer id;
	private String name;
	private String addr;
	private String tel;
	private String worktime;
	
	/**  
     * 获取 worktime  
     * @return worktime
     */
    public String getWorktime() {
        return worktime;
    }
    /**  
     * 设置 worktime  
     * @param worktime
     */
    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

}
