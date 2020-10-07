package com.imooc.mapper.join;

import com.imooc.vo.ItemCommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemsCommentsLeftJoinMapper {

    List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);
}
