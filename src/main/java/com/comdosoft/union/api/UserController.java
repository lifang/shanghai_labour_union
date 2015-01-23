package com.comdosoft.union.api;

import java.io.UnsupportedEncodingException;

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
    @RequestMapping(value = "getCode" , method = RequestMethod.POST)
    public SysResponse getCode(String phone){
        logger.debug(phone+ " 注册获取验证码");
        SysResponse sysResponse = null;
        try {
            sysResponse = userService.getCode(phone);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            sysResponse= SysResponse.buildExceptionResponse("发送失败,请重新发送");
        }
        
        return sysResponse;
    }
    
    @RequestMapping(value = "regist" , method = RequestMethod.POST)
    public SysResponse regist(User user){
        SysResponse sysResponse = userService.regist(user);
        return sysResponse;
    }
    /**
     * 找回密码（更新密码）
     * @param user
     * @param newpwd    新的密码
     * @param phoneCode  手机接收到的验证码
     * @param inputCode  输入的验证码
     * @return
     */
    @RequestMapping(value = "changePwd" , method = RequestMethod.POST)
    public SysResponse changePwd(User user,String newpwd,String phoneCode,String inputCode){
        SysResponse sysResponse = null;
        if(null != inputCode && ! phoneCode.equals(inputCode)){
            sysResponse = SysResponse.buildFailResponse("验证码不正确");
        }
        String oldpwd = user.getPassword();
        user = userService.findEntityById(user.getId());
        if(null !=newpwd && user.getPassword().equals(oldpwd)){
            user.setPassword(newpwd);
            userService.update(user);
        }else{
            sysResponse = SysResponse.buildFailResponse("密码不正确");
        }
        return sysResponse;
    }
    /**
     * 根据传入id 及其要更新的参数   更新注册用户
     * @param user
     * @return
     */
    @RequestMapping(value = "update" , method = RequestMethod.POST)
    public SysResponse updateUser(User user){
        SysResponse sysResponse = userService.update(user);
        return sysResponse;
    }
    /**
     * 根据id查询用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "findById" , method = RequestMethod.POST)
    public SysResponse findById(User user){
        SysResponse sysResponse = userService.findById(user.getId());
        return sysResponse;
    }
    /**
     * 根据用户帐号密码登录 成功返回用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "login" , method = RequestMethod.POST)
    public SysResponse login(User user){
        SysResponse sysResponse = userService.login(user);
        return sysResponse;
    }
}
