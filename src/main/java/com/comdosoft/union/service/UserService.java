package com.comdosoft.union.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.User;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.common.SysUtils;
import com.comdosoft.union.dao.news.UserMapper;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Resource
    private UserMapper userMapper;


    /**
     * 注册
     * @param user
     * @return
     */
    public SysResponse regist(User user) {
        SysResponse sysResponse = null;
        if(null == user.getUsername()){
            sysResponse = SysResponse.buildFailResponse("请填写用户名");
            return sysResponse;
        }
        User u = new User();
        u = userMapper.findByName(user.getUsername());
        if(null != u ){
            sysResponse = SysResponse.buildFailResponse("用户名已存在");
        }else{
            if(null == user.getPassword()){
                sysResponse = SysResponse.buildFailResponse("请填写密码");
                return sysResponse;
            }
            if(null == user.getPhone()){
                sysResponse = SysResponse.buildFailResponse("请填写手机号");
                return sysResponse;
            }
            try{
                User uu = userMapper.findByPhone(user.getPhone());
                uu.setUsername(user.getUsername());
                uu.setPassword(user.getPassword());
                userMapper.update(uu);
                sysResponse = SysResponse.buildSuccessResponse(uu);
            }catch(Exception e){
                logger.debug("注册失败"+e);
                sysResponse = SysResponse.buildExceptionResponse("注册失败");
            }
        }
        return sysResponse;
    }

    public SysResponse update(User user) {
        SysResponse sysResponse = null;
        try{
            //根据id更新
            String email = user.getEmail() == null ? "" : user.getEmail();
            String nickName = user.getNickName() == null ? "" : user.getNickName();
            String code = user.getLabourUnionCode() == null ? "" : user.getLabourUnionCode();
//            String password = user.getPassword() == null ? "" : user.getPassword();
            String id = user.getId()==null ?"":user.getId().toString();
            if("" == id){
                logger.debug("更新用户时丢失id,更新失败");
                sysResponse = SysResponse.buildExceptionResponse("更新失败");
                return sysResponse;
            }
            user = userMapper.findById(Integer.parseInt(id));
            if(user != null){
                String u_email = user.getEmail();
                if("" != email && !email.equals(u_email)){
                    User uu = userMapper.findByEmail(email);
                    if(uu !=null){
                        sysResponse = SysResponse.buildExceptionResponse("该邮箱已经存在");
                        return sysResponse;
                    }
                    user.setEmail(email);
                }
                if(""!=nickName){ //设置匿名
                    user.setNickName(nickName);
                }
                if("" != code){//设置工会号  暂时这么叫
                    user.setLabourUnionCode(code);
                }
            }
            userMapper.update(user);
            sysResponse = SysResponse.buildSuccessResponse(user);
        }catch(Exception e){
            logger.debug("更新用户出错:"+e);
            sysResponse = SysResponse.buildExceptionResponse("用户更新失败");
        }
        return sysResponse;
    }

    public User findEntityById(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }

    public SysResponse login(User user) {
        User u = userMapper.login(user);
        SysResponse sysResponse =null;
        if(null !=u){
            sysResponse = SysResponse.buildSuccessResponse(u);
        }else{
            sysResponse = SysResponse.buildFailResponse("用户名或密码错误");
        }
        return sysResponse;
    }

    public User findByPhone(String phone) {
        User u = userMapper.findByPhone(phone);
        return u;
    }


    public int insertCode(User user) {
        return userMapper.insertCode(user);
    }


    public void updateCode(User u) {
        userMapper.updateCode(u);
    }


    /**
     * 找回密码
     * @param user
     * @param inputCode
     * @return
     */
    public SysResponse findPwd(User user, String inputCode) {
        SysResponse sysResponse = null;
        String newpwd = user.getPassword();
        if(null == newpwd){
            sysResponse = SysResponse.buildFailResponse("请设置新密码");
            return sysResponse;
        }else{
            user = userMapper.findByPhone(user.getPhone());
            if(null !=user){
                String phoneCode = user.getPhoneCode();
                if(null != inputCode && ! phoneCode.equals(inputCode)){
                    sysResponse = SysResponse.buildFailResponse("验证码不正确");
                    return sysResponse;
                }
                user.setPassword(newpwd);
                userMapper.update(user);
                sysResponse = SysResponse.buildSuccessResponse(user);
            }else{
                sysResponse = SysResponse.buildFailResponse("该手机还未注册");
            }
        }
        return sysResponse;
    }

    /**
     * 修改密码
     * @param user
     * @param newpwd 新密码
     * @return
     */
    public SysResponse changePwd(User user,String newpwd) {
        SysResponse sysResponse = null;
        user = userMapper.findById(user.getId());
        if(user !=null){
            String oldpwd = user.getPassword();
            if(null !=newpwd && user.getPassword().equals(oldpwd)){
                user.setPassword(newpwd);
                userMapper.update(user);
                sysResponse = SysResponse.buildSuccessResponse(user);
            }else{
                sysResponse = SysResponse.buildFailResponse("密码不正确");
            }
        }
        return sysResponse;
    }

    /**
     * 更换手机发送验证码
     * @param phone
     * @return
     */
    public SysResponse sendCode(String phone) {
        SysResponse sysResponse = null;
        try {
            User u = userMapper.findByPhone(phone);
            if(null != u){
                String code = SysUtils.sendPhoneCode(phone);
                u.setPhoneCode(code);
                userMapper.updateCode(u);
                sysResponse =SysResponse.buildSuccessResponse(code);
            }else{
                sysResponse =SysResponse.buildFailResponse("此手机还未注册帐号");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("验证码发送失败"+e);
            sysResponse= SysResponse.buildExceptionResponse("发送失败,请重新发送");
        }
        return sysResponse;
    }

    /**
     * 更换手机
     * @param user
     * @param verify_code
     * @return
     */
    public SysResponse changePhone(User user, String verify_code) {
        SysResponse sysResponse = null;
        User u = userMapper.findById(user.getId());
        if(u.getPhoneCode().equals(verify_code)){
            u.setPhone(user.getPhone());
            userMapper.update(u);
            sysResponse = SysResponse.buildSuccessResponse(u);
        }else{
            sysResponse = SysResponse.buildFailResponse("验证码错误");
        }
        return sysResponse;
    }

    /**
     * 注册发送验证码
     * @param phone
     * @param code
     * @return
     */
    public SysResponse registfcode(String phone,String code) {
        SysResponse sysResponse = null;
        try {
            User u = userMapper.findByPhone(phone);
            if(null == u){
                User user = new User();
                user.setPhone(phone);
                user.setPhoneCode(code);
                userMapper.insertCode(user);
                sysResponse =SysResponse.buildSuccessResponse(code);
            }else{
                u.setPhoneCode(code);
                userMapper.updateCode(u);
                sysResponse =SysResponse.buildFailResponse("手机号已存在,可以按手机号找回密码");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("验证码发送失败"+e);
            sysResponse= SysResponse.buildExceptionResponse("发送失败,请重新发送");
        }
        return sysResponse;
    }

    /**
     * 保存注册
     * 
     * @param user
     * @param verify_code
     * @return
     */
    public SysResponse saveRegist(User user, String verify_code) {
        SysResponse sysResponse = null;
        String username = user.getUsername();
        String password = user.getPassword();
        String phone = user.getPhone();

        if (null != verify_code) {
            if (null != user.getPhone() || !"".equals(phone)) {
                User u = userMapper.findByPhone(phone);
                if (null != u) {
                    if (null != u.getUsername()) {
                        sysResponse = SysResponse.buildFailResponse("该手机已注册");
                        return sysResponse;
                    } else {
                        String c = u.getPhoneCode();
                        if (c.equals(verify_code)) {
                            if (null == username || username.equals("")) {
                                sysResponse = SysResponse.buildFailResponse("请填写用户名");
                                return sysResponse;
                            }
                            User uu = new User();
                            uu = userMapper.findByName(username);
                            if (null != uu) {
                                sysResponse = SysResponse.buildFailResponse("用户名已存在");
                            } else {
                                if (null == password || password.equals("")) {
                                    sysResponse = SysResponse.buildFailResponse("请填写密码");
                                    return sysResponse;
                                }
                                try {
                                    userMapper.update(user);
                                    sysResponse = SysResponse.buildSuccessResponse(user);
                                } catch (Exception e) {
                                    logger.debug("注册失败" + e);
                                    sysResponse = SysResponse.buildExceptionResponse("注册失败");
                                }
                            }
                        } else {
                            sysResponse = SysResponse.buildFailResponse("验证码错误");
                        }
                    }
                }
            } else {
                sysResponse = SysResponse.buildFailResponse("手机号不能为空");
            }
        } else {
            sysResponse = SysResponse.buildFailResponse("验证码不能为空");
        }
        return sysResponse;
    }
}
