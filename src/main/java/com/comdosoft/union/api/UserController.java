package com.comdosoft.union.api;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comdosoft.union.bean.app.User;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.common.SysUtils;
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
     * 更换手机发送验证码
     * @return
     */
    @RequestMapping(value = "getPhoneCode" , method = RequestMethod.POST)
    public SysResponse getPhoneCode(String phone){
        SysResponse sysResponse = userService.sendCode(phone);
        return sysResponse;
    }
    
    /**
     * 更换手机保存
     * 根据用户id  新的手机号  用户验证码
     * @return
     */
    @RequestMapping(value = "changePhone" , method = RequestMethod.POST)
    public SysResponse changePhone(User user,String verify_code){
        SysResponse sysResponse = userService.changePhone(user,verify_code);
        return sysResponse;
    }
    
    /**
     * 注册获取验证码
     * @return
     */
    @RequestMapping(value = "registfcode" , method = RequestMethod.POST)
    public SysResponse registfcode(String phone){
        String code = SysUtils.sendPhoneCode(phone);
        logger.debug(phone+ " 注册获取验证码===>>"+code);
        SysResponse sysResponse =  userService.registfcode(phone,code);
        return sysResponse;
    }
    
    /**
     * 用户注册
     * @param user
     * @param verify_code 用户输入的验证码
     * @return
     */
    @RequestMapping(value = "regist" , method = RequestMethod.POST)
    public SysResponse regist(User user,String verify_code){
        SysResponse sysResponse = userService.saveRegist(user,verify_code);
        return sysResponse;
    }
    
  
    /**
     * 找回密码 
     * @param user
     * @param newpwd    新的密码
     * @param inputCode  输入的验证码
     * @return
     */
    @RequestMapping(value = "findPwd" , method = RequestMethod.POST)
    public SysResponse findPwd(User user,String inputCode){
        SysResponse sysResponse =  userService.findPwd(user,inputCode);
        return sysResponse;
    }
    
    /**
     * 修改密码  
     * @param user
     * @param newpwd    新的密码
     * @return
     */
    @RequestMapping(value = "changePassword" , method = RequestMethod.POST)
    public SysResponse changePwd(User user,String newpwd){
        SysResponse sysResponse  = userService.changePwd(user,newpwd);
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
        user = userService.findEntityById(user.getId());
        SysResponse sysResponse = SysResponse.buildSuccessResponse(user);
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
