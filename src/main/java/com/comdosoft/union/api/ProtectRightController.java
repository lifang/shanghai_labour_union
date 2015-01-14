package com.comdosoft.union.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comdosoft.union.bean.app.ProtectRight;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.service.ProtectRightService;

@RestController
@RequestMapping("api/protect/right")
public class ProtectRightController {
	
	@Autowired
	private ProtectRightService protectRightService;
	
	/**
	 * 登记维权
	 * @return
	 */
	public SysResponse registProtectRight(ProtectRight protectRight){
		if(!StringUtils.hasLength(protectRight.getUsername())) {
			return SysResponse.buildExceptionResponse("姓名不能为空");
		}
		if(!StringUtils.hasLength(protectRight.getMobile())) {
			return SysResponse.buildExceptionResponse("联系电话不能为空");
		}
		protectRightService.registProtectRight(protectRight);
		return SysResponse.buildSuccessResponse(null);
	}

}
