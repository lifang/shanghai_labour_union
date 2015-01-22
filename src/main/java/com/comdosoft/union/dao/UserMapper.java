package com.comdosoft.union.dao;

import com.comdosoft.union.bean.app.User;

public interface UserMapper {
    public int insert(User user);

    User selectUserByPhone(User user);

    User selectUserByName(User user);
}
