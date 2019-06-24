package com.dao;

import com.entity.User;

public interface UserDao {

    //注册
    boolean addUser(User user) throws Exception;

    //登录
    User login(String username, String password) throws Exception;

    //检验用户名唯一性
    boolean findUserByName(String username);

    //修改资料
    boolean updateUser(User user, String username);

    //获得用户信息
    User getUser(String username);
}