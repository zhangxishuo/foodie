package com.imooc.mapper;

import com.imooc.mapper.core.CoreMapper;
import com.imooc.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper extends CoreMapper<Orders> {
}