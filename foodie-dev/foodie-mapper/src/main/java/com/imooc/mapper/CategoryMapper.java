package com.imooc.mapper;

import com.imooc.mapper.core.CoreMapper;
import com.imooc.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends CoreMapper<Category> {
}