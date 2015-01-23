package com.comdosoft.union.dao;

import com.comdosoft.union.bean.app.User;

public interface UserMapper {
    public int update(User user);
    
    public User findByName(String username);
    
    public User findByPhone(String phone);
    
    public User findById(int id);

    public User login(String username, String password);

    public int insertCode(User user);

    public void updateCode(User u);
}
