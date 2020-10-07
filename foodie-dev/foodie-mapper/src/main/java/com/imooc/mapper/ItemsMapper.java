package com.imooc.mapper;

import com.imooc.mapper.core.CoreMapper;
import com.imooc.pojo.Items;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemsMapper extends CoreMapper<Items> {
}