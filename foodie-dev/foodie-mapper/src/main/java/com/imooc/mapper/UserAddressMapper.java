package com.imooc.mapper;

import com.imooc.mapper.core.CoreMapper;
import com.imooc.pojo.UserAddress;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAddressMapper extends CoreMapper<UserAddress> {
}