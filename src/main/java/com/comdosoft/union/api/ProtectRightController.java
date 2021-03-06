package com.comdosoft.union.api;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comdosoft.union.bean.app.ProtectRight;
import com.comdosoft.union.bean.app.lmEnum;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.service.ProtectRightService;

@RestController
@RequestMapping("api/protect")
public class ProtectRightController {
    private static final Logger logger = LoggerFactory.getLogger(ProtectRightController.class);
    @Autowired
    private ProtectRightService protectRightService;

    /**
     * 登记维权
     * 
     * @return
     */
    @RequestMapping(value = "regist", method = RequestMethod.POST)
    public SysResponse registProtectRight(ProtectRight protectRight) {
        logger.debug("维权登记》》》ProtectRight==>>" + protectRight);
        if (!StringUtils.hasLength(protectRight.getUsername())) {
            return SysResponse.buildExceptionResponse("姓名不能为空");
        }
        if (!StringUtils.hasLength(protectRight.getMobile())) {
            return SysResponse.buildExceptionResponse("联系电话不能为空");
        }
        if (!StringUtils.hasLength(protectRight.getTitle())) {
            return SysResponse.buildExceptionResponse("标题不能为空");
        }
        if (!StringUtils.hasLength(protectRight.getContent())) {
            return SysResponse.buildExceptionResponse("内容不能为空");
        }
        SysResponse sysResponse = null;
        try {
            protectRightService.registProtectRight(protectRight);
            sysResponse = SysResponse.buildSuccessResponse("登记成功");
        } catch (Exception e) {
        	logger.debug("出错了》》》》》"+ e);
            sysResponse = SysResponse.buildFailResponse("登记失败,请重新再试");
        }
        return sysResponse;
    }

    @RequestMapping(value = "getType", method = RequestMethod.POST)
    public SysResponse getType() {
        SysResponse sysResponse = new SysResponse();
        List<Object> list = new LinkedList<Object>();
        Map<String, String> map = null;
        for (lmEnum s : lmEnum.values()){ 
            map = new HashMap<String,String>();
            map.put("code", s.getCode().toString());
            map.put("name", s.getName());
            list.add(map);
        } 
        sysResponse.setResult(list);
        sysResponse.setCode(SysResponse.SUCCESS);
        return sysResponse;
    }

}
