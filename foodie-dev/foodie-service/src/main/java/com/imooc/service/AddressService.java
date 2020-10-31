package com.imooc.service;

import com.imooc.bo.AddressBO;
import com.imooc.pojo.UserAddress;

import java.util.List;

public interface AddressService {

    List<UserAddress> queryAll(String userId);

    void addNewUserAddress(AddressBO addressBO);

    void updateUserAddress(AddressBO addressBO);
}
