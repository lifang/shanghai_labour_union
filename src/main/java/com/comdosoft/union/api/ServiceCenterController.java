package com.comdosoft.union.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comdosoft.union.bean.Page;
import com.comdosoft.union.bean.app.ServiceCenter;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.service.ServiceCenterService;

@RestController
@RequestMapping("api/service/center")
public class ServiceCenterController {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceCenterController.class);
	
	@Autowired
	private ServiceCenterService serviceCenterService;
	
	@RequestMapping(value="worker/page",method=RequestMethod.POST)
	public SysResponse workPage(Integer page){
		logger.info("分页查找职工援助服务中心,page:{}",page);
		Page<ServiceCenter> centers = serviceCenterService.findWorkerPage(page);
		return SysResponse.buildSuccessResponse(centers);
	}

	@RequestMapping(value="law/page",method=RequestMethod.POST)
	public SysResponse lawPage(Integer page){
		logger.info("分页查找法律援助服务中心,page:{}",page);
		Page<ServiceCenter> centers = serviceCenterService.findLawPage(page);
		return SysResponse.buildSuccessResponse(centers);
	}
	
	@RequestMapping(value="info",method=RequestMethod.POST)
	public SysResponse info(Integer id){
		logger.info("查找服务中心,id:{}",id);
		ServiceCenter center = serviceCenterService.info(id);
		return SysResponse.buildSuccessResponse(center);
	}
}
