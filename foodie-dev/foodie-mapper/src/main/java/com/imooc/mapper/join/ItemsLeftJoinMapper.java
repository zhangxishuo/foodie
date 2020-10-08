package com.imooc.mapper.join;

import com.imooc.vo.SearchItemsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemsLeftJoinMapper {

    List<SearchItemsVO> searchItems(@Param("paramsMap") Map<String, Object> map);
}
