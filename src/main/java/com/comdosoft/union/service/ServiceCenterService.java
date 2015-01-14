package com.comdosoft.union.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.Page;
import com.comdosoft.union.bean.PageRequest;
import com.comdosoft.union.bean.app.ServiceCenter;
import com.comdosoft.union.common.SysConstant;
import com.comdosoft.union.dao.ServiceCenterMapper;

/**
 * 服务中心
 * @author wu
 *
 */
@Service
public class ServiceCenterService {
	
	@Autowired
	private ServiceCenterMapper serviceCenterMapper;
	
	private int pageSize = SysConstant.ROWS;
	
	/**
	 * 查找职工援助服务中心分页
	 * @param page
	 * @return
	 */
	public Page<ServiceCenter> findWorkerPage(int page) {
		return findCenterPage(page,ServiceCenterMapper.WORKS);
	}
	
	/**
	 * 查找法律援助服务中心分页
	 * @param page
	 * @return
	 */
	public Page<ServiceCenter> findLawPage(int page) {
		return findCenterPage(page,ServiceCenterMapper.LAW);
	}
	
	public ServiceCenter info(Integer id) {
		return serviceCenterMapper.find(id);
	}

	private Page<ServiceCenter> findCenterPage(int page,byte bs) {
		PageRequest request = new PageRequest(page, pageSize);
		long count = serviceCenterMapper.countByBs(ServiceCenterMapper.WORKS);
		List<ServiceCenter> centers = serviceCenterMapper.pageByBs(bs, request);
		return new Page<ServiceCenter>(request, centers, count);
	}
}
