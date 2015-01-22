package com.comdosoft.union.api;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comdosoft.union.bean.app.User;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.service.UserService;
/**
 * 
 * 用户管理<br>
 * <功能描述>
 *
 * @author gch 2015年1月22日
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Resource
    private UserService userService;
    
    /**
     * 获取验证码
     * @return
     */
    public SysResponse getCode(String phone){
        logger.debug(phone+ " 注册获取验证码");
        Boolean isSuccess = userService.getCode(phone);
        SysResponse sysResponse = null;
        if(isSuccess){
            sysResponse = SysResponse.buildSuccessResponse("发送成功");
        }else{
            sysResponse = SysResponse.buildExceptionResponse("系统忙");
        }
        return sysResponse;
    }
    
    @RequestMapping(value = "regist" , method = RequestMethod.POST)
    public SysResponse regist(User user){
        SysResponse sysResponse = userService.regist(user);
        return sysResponse;
    }
    /**
     * 根据传入id 及其要更新的参数   更新注册用户
     * @param user
     * @return
     */
    @RequestMapping(value = "updateUser" , method = RequestMethod.POST)
    public SysResponse updateUser(User user){
        SysResponse sysResponse = userService.update(user);
        return sysResponse;
    }
    
    @RequestMapping(value = "findById" , method = RequestMethod.POST)
    public SysResponse findById(User user){
        SysResponse sysResponse = userService.findById(user.getId());
        return sysResponse;
    }
}
