package com.comdosoft.union.dao;

import com.comdosoft.union.bean.app.User;

public interface UserMapper {
    public int insert(User user);

    public int update(User user);
    
    User findByName(String username);
    User findByPhone(String phone);
    User findById(int id);
}
