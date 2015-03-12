package com.comdosoft.union.api;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comdosoft.union.bean.app.User;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.common.SysToken;
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
     * 更换手机
     * 根据手机号 发送验证码
     * @return 验证码
     */
    @RequestMapping(value = "getPhoneCode" , method = RequestMethod.POST)
    public SysResponse getPhoneCode(String phone){
        SysResponse sysResponse = userService.sendCode(phone,"【上海市总工会】您正在进行更换手机号码操作，验证码为");
        return sysResponse;
    }
    
    /**
     * 找回密码
     * 根据手机号 发送验证码
     * @return 验证码
     */
    @RequestMapping(value = "getPwdCode" , method = RequestMethod.POST)
    public SysResponse getPwdCode(String phone){
        SysResponse sysResponse = userService.sendCode(phone,"【上海市总工会】您正在进行找回密码操作，验证码为");
        return sysResponse;
    }
    
    /**
     * 更换手机保存
     * 根据用户id  新的手机号  用户验证码
     * @return
     */
    @RequestMapping(value = "changePhone" , method = RequestMethod.POST)
    public SysResponse changePhone(User user,String verify_code,String token,HttpSession session){
        SysResponse sysResponse = null;
        if(SysToken.isTokenValid(token, user.getId(), session)){
            sysResponse = userService.changePhone(user,verify_code);
        }else{
            sysResponse = SysResponse.buildFailResponse("连接超时,请重新登录");
        }
        return sysResponse;
    }
    
    /**
     * 注册获取验证码
     * @return
     */
    @RequestMapping(value = "registfcode" , method = RequestMethod.POST)
    public SysResponse registfcode(String phone){
        Boolean i = isExist(phone);
        if(i){
           return  SysResponse.buildFailResponse("此手机号已经存在"); 
        }
        if(SysUtils.isMobileNO(phone)){
            String code = SysUtils.sendPhoneCode(phone,"【上海市总工会】欢迎您的注册，验证码为");
            logger.debug(phone+ "==>>注册获取验证码===>>"+code);
            SysResponse sysResponse =  userService.registfcode(phone,code);
            return sysResponse;
        }else{
            return  SysResponse.buildFailResponse("请输入正确的手机号"); 
        }
    }
    
    /**
     * 此手机是否存在  true 存在    false 不存在
     * @param phone
     * @return
     */
    private Boolean isExist(String phone) {
        try {
            User u = userService.findByPhone(phone);
            if(null != u){
                String name = u.getUsername();
                if(null != name){
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * 用户注册
     * @param user
     * @param verify_code 用户输入的验证码
     * @return
     */
    @RequestMapping(value = "regist" , method = RequestMethod.POST)
    public SysResponse regist(User user,String verify_code,HttpSession session){
        SysResponse sysResponse = userService.saveRegist(user,verify_code,session);
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
    public SysResponse changePwd(User user,String newpwd,String token,HttpSession session){
        SysResponse sysResponse = null;
        if(SysToken.isTokenValid(token, user.getId(), session)){
            sysResponse = userService.changePwd(user,newpwd);
        }else{
            sysResponse = SysResponse.buildFailResponse("连接超时,请重新登录");
        }
        return sysResponse;
    }
    
    /**
     * 根据传入id 及其要更新的参数   更新注册用户
     * @param user
     * @return
     */
    @RequestMapping(value = "update" , method = RequestMethod.POST)
    public SysResponse updateUser(User user,String token,HttpSession session){
        logger.debug("更新注册用户==>>"+user);
        SysResponse sysResponse = null;
        if(SysToken.isTokenValid(token, user.getId(), session)){
            sysResponse = userService.update(user);
        }else{
            sysResponse = SysResponse.buildFailResponse("连接超时,请重新登录");
        }
        return sysResponse;
    }
    /**
     * 根据id查询用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "findById" , method = RequestMethod.POST)
    public SysResponse findById(User user,String token,HttpSession session){
        SysResponse sysResponse = null;
        if(SysToken.isTokenValid(token, user.getId(), session)){
            user = userService.findEntityById(user.getId());
            if(null != user){
                user.setPassword(null);
                user.setPhoneCode(null);
                sysResponse = SysResponse.buildSuccessResponse(user);
            }else{
                sysResponse = SysResponse.buildFailResponse("没有找到该用户");
            }
        }else{
            sysResponse = SysResponse.buildFailResponse("连接超时,请重新登录");
        }
        return sysResponse;
    }
    /**
     * 根据用户帐号密码登录 成功返回用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "login" , method = RequestMethod.POST)
    public SysResponse login(User user,HttpServletRequest request){
        SysResponse sysResponse = userService.login(user,request);
        return sysResponse;
    }
    
    @RequestMapping(value = "loginOut" , method = RequestMethod.POST)
    public SysResponse loginOut(String token, HttpSession session){
        SysResponse sysResponse = new SysResponse();
        try {
            SysToken.removeToken(token, session);
            sysResponse.setMessage("退成成功");
            sysResponse.setCode(SysResponse.SUCCESS);
        } catch (Exception e) {
            logger.error("用户退出失败", e);
            sysResponse.setCode(SysResponse.EXCEPTION);
            sysResponse.setMessage("用户退出失败:系统异常");
        }
        return sysResponse;
    }
}
