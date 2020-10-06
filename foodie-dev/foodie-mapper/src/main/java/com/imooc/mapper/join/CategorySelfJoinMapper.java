package com.imooc.mapper.join;

import com.imooc.vo.CategoryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategorySelfJoinMapper {

    List<CategoryVO> getSubCatList(Integer rootCatId);
}
