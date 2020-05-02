package com.imooc.service;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;

public interface UserService {

    boolean usernameExists(String username);

    Users createUser(UserBO userBO);

    Users queryUserForLogin(String username, String password);
}
