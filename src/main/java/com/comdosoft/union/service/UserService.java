package com.comdosoft.union.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.User;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.dao.UserMapper;

@Service
public class UserService {
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
        User u = userMapper.selectUserByName(user);
        SysResponse sysResponse = null;
        if(null !=u){
            sysResponse = SysResponse.buildFailResponse("用户名已存在");
        }else{
            u = userMapper.selectUserByPhone(user);
            if(null !=u){
                sysResponse = SysResponse.buildFailResponse("手机号已存在");
            }else{
                userMapper.insert(user);
                sysResponse = SysResponse.buildSuccessResponse("注册成功");
            }
        }
        return sysResponse;
    }

}
