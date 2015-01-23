package com.comdosoft.union.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comdosoft.union.bean.app.ProtectRight;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.service.ProtectRightService;

@RestController
@RequestMapping("api/protect")
public class ProtectRightController {
	
	@Autowired
	private ProtectRightService protectRightService;
	
	/**
	 * 登记维权
	 * @return
	 */
	@RequestMapping(value="regist",method=RequestMethod.POST)
	public SysResponse registProtectRight(ProtectRight protectRight){
		if(!StringUtils.hasLength(protectRight.getUsername())) {
			return SysResponse.buildExceptionResponse("姓名不能为空");
		}
		if(!StringUtils.hasLength(protectRight.getMobile())) {
			return SysResponse.buildExceptionResponse("联系电话不能为空");
		}
		if(!StringUtils.hasLength(protectRight.getTitle())) {
		    return SysResponse.buildExceptionResponse("标题不能为空");
		}
		if(!StringUtils.hasLength(protectRight.getContent())) {
		    return SysResponse.buildExceptionResponse("内容不能为空");
		}
		protectRightService.registProtectRight(protectRight);
		return SysResponse.buildSuccessResponse(null);
	}

}
