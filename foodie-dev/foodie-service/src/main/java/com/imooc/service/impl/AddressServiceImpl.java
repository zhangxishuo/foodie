package com.imooc.service.impl;

import com.imooc.mapper.UserAddressMapper;
import com.imooc.pojo.UserAddress;
import com.imooc.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final UserAddressMapper userAddressMapper;

    public AddressServiceImpl(UserAddressMapper userAddressMapper) {
        this.userAddressMapper = userAddressMapper;
    }

    @Override
    public List<UserAddress> queryAll(String userId) {
        UserAddress address = new UserAddress();
        address.setUserId(userId);
        return userAddressMapper.select(address);
    }
}
