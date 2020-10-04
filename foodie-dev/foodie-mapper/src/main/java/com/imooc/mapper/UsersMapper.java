package com.imooc.mapper;

import com.imooc.mapper.core.CoreMapper;
import com.imooc.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper extends CoreMapper<Users> {
}