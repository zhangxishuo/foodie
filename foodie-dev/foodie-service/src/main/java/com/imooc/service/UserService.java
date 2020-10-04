package com.imooc.service;

import com.imooc.bo.UserBO;
import com.imooc.pojo.Users;

public interface UserService {

    boolean queryUsernameIsExist(String username);

    Users createUser(UserBO userBO);
}
