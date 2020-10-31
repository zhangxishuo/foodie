package com.imooc.service;

import com.imooc.pojo.UserAddress;

import java.util.List;

public interface AddressService {

    List<UserAddress> queryAll(String userId);
}
