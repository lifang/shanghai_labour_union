package com.comdosoft.union.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.User;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.dao.UserMapper;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Resource
    private UserMapper userMapper;
    
    /**
     * 根据手机号发送验证码
     * @param phone
     * @return
     */
    public Boolean getCode(String phone) {
        // TODO Auto-generated method stub
        return true;
    }

    /**
     * 注册
     * @param user
     * @return
     */
    public SysResponse regist(User user) {
        SysResponse sysResponse = null;
        if(null == user.getUsername()){
            sysResponse = SysResponse.buildFailResponse("缺失参数");
            return sysResponse;
        }
        User u = new User();
        u = userMapper.findByName(user.getUsername());
        if(null != u ){
            sysResponse = SysResponse.buildFailResponse("用户名已存在");
        }else{
            u = userMapper.findByPhone(user.getPhone());
            if(null != u ){
                sysResponse = SysResponse.buildFailResponse("手机号已存在");
            }else{
                if(null == user.getPassword() || null == user.getPhone()){
                    sysResponse = SysResponse.buildFailResponse("缺少参数");
                    return sysResponse;
                }
                try{
                    userMapper.insert(user);
                    sysResponse = SysResponse.buildSuccessResponse("注册成功");
                }catch(Exception e){
                    sysResponse = SysResponse.buildExceptionResponse("用户注册失败");
                }
            }
        }
        return sysResponse;
    }

    public SysResponse update(User user) {
        SysResponse sysResponse = null;
        try{
            //根据id更新
            String email = user.getEmail();
            String code = user.getLabourUnionCode();
            String username = user.getUsername();
            String phone = user.getPhone();
            String password = user.getPassword();
            user = userMapper.findById(user.getId());
            if(null != email){
                user.setEmail(email);
            }
            if(null != code){
                user.setLabourUnionCode(code);
            }
            if(null != username){
                user.setUsername(username);
            }
            if(null != phone){
                user.setPhone(phone);
            }
            if(null != password){
                user.setPassword(password);
            }
            userMapper.update(user);
            sysResponse = SysResponse.buildSuccessResponse("更新成功");
        }catch(Exception e){
            logger.debug("更新用户出错:"+e);
            sysResponse = SysResponse.buildExceptionResponse("用户更新失败");
        }
        return sysResponse;
    }

    public SysResponse findById(Integer id) {
        User user = userMapper.findById(id);
        SysResponse sysResponse = SysResponse.buildSuccessResponse(user);
        return sysResponse;
    }

}
