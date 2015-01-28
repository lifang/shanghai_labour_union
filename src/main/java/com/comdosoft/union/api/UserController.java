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
     * 更换手机发送验证码
     * @return
     */
    @RequestMapping(value = "getPhoneCode" , method = RequestMethod.POST)
    public SysResponse getPhoneCode(String phone){
        SysResponse sysResponse = null;
        try {
            User u = userService.findByPhone(phone);
            if(null != u){
                String code = userService.getCode(phone);
                u.setPhoneCode(code);
                userService.updateCode(u);
                sysResponse =SysResponse.buildSuccessResponse(code);
            }else{
                sysResponse =SysResponse.buildFailResponse("此手机还未注册帐号");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.debug("验证码发送失败"+e);
            sysResponse= SysResponse.buildExceptionResponse("发送失败,请重新发送");
        }
        
        return sysResponse;
    }
    
    /**
     * 更换手机保存
     * @return
     */
    @RequestMapping(value = "changePhone" , method = RequestMethod.POST)
    public SysResponse changePhone(User user,String verify_code){
        SysResponse sysResponse = null;
        if(null != verify_code){
            if(null != user.getPhoneCode() && user.getPhoneCode().equals(verify_code)){
                sysResponse = userService.updatePhone(user);
            }else{
                sysResponse = SysResponse.buildFailResponse("验证码错误");
            }
        }else{
            sysResponse = SysResponse.buildFailResponse("验证码错误");
        }
        return sysResponse;
    }
    
    /**
     * 注册获取验证码
     * @return
     */
    @RequestMapping(value = "registfcode" , method = RequestMethod.POST)
    public SysResponse registfcode(String phone){
        logger.debug(phone+ " 注册获取验证码");
        SysResponse sysResponse = null;
        try {
            String code = userService.getCode(phone);
            User u = userService.findByPhone(phone);
            if(null == u){
                User user = new User();
                user.setPhone(phone);
                user.setPhoneCode(code);
                userService.insertCode(user);
            }else{
                u.setPhoneCode(code);
                userService.updateCode(u);
                // sysResponse =SysResponse.buildFailResponse("手机号已存在");
            }
            sysResponse =SysResponse.buildSuccessResponse(code);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.debug("验证码发送失败"+e);
            sysResponse= SysResponse.buildExceptionResponse("发送失败,请重新发送");
        }
        
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
        SysResponse sysResponse = null;
        if(null != verify_code){
            
            if(null != user.getPhone()){
                User u = userService.findByPhone(user.getPhone());
                if(null != u.getUsername()){
                    sysResponse = SysResponse.buildFailResponse("该手机已注册");
                    return sysResponse;
                }else{
                    String c = u.getPhoneCode();
                    if(c.equals(verify_code)){
                        sysResponse = userService.regist(user);
                    }else{
                        sysResponse = SysResponse.buildFailResponse("验证码错误");
                    }
                }
            }else{
                sysResponse = SysResponse.buildFailResponse("手机号不能为空");
            }
        }else{
            sysResponse = SysResponse.buildFailResponse("验证码不能为空");
        }
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
     * 修改密码
     * @param user
     * @param newpwd    新的密码
     * @return
     */
    @RequestMapping(value = "changePassword" , method = RequestMethod.POST)
    public SysResponse changepassword(User user,String newpwd){
        SysResponse sysResponse = null;
        String oldpwd = user.getPassword();
        user = userService.findEntityById(user.getId());
        if(null !=newpwd && user.getPassword().equals(oldpwd)){
            user.setPassword(newpwd);
            userService.update(user);
            sysResponse = SysResponse.buildSuccessResponse(user);
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
