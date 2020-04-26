package com.imooc.mapper.core;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface CoreMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
