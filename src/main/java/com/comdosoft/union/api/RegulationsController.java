package com.comdosoft.union.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comdosoft.union.bean.Page;
import com.comdosoft.union.bean.app.Regulations;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.service.RegulationsService;

@RestController
@RequestMapping("api/regulations")
public class RegulationsController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegulationsController.class);
	
	@Autowired
	private RegulationsService regulationsService;
	
    @RequestMapping(value = "page", method = RequestMethod.POST)
    public SysResponse page(String title,Integer page) {
    	logger.info("法规分页查询,title:{},page:{}",title,page);
    	Page<Regulations> regulations = regulationsService.getPage(page, title);
        return SysResponse.buildSuccessResponse(regulations);
    }
    
    @RequestMapping(value = "info", method = RequestMethod.POST)
    public SysResponse info(Long id) {
    	logger.info("法规详情,id:{}",id);
    	Regulations regulations = regulationsService.getInfo(id);
        return SysResponse.buildSuccessResponse(regulations);
    }

}
