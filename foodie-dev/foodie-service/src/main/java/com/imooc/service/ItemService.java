package com.imooc.service;

import com.imooc.common.IMOOCPagedGridResult;
import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import com.imooc.vo.CommentLevelCountsVO;
import com.imooc.vo.ItemCommentVO;
import com.imooc.vo.SearchItemsVO;
import com.imooc.vo.ShopCartVO;

import java.util.List;

public interface ItemService {

    Items queryItemById(String itemId);

    List<ItemsImg> queryItemImgList(String itemId);

    List<ItemsSpec> queryItemSpecList(String itemId);

    ItemsParam queryItemParam(String itemId);

    CommentLevelCountsVO queryCommentCounts(String itemId);

    IMOOCPagedGridResult<ItemCommentVO> queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);

    IMOOCPagedGridResult<SearchItemsVO> searchItems(String keywords, String sort, Integer page, Integer pageSize);

    IMOOCPagedGridResult<SearchItemsVO> searchItems(Integer catId, String sort, Integer page, Integer pageSize);

    List<ShopCartVO> queryItemsBySpecIds(String specIds);

    ItemsSpec queryItemSpecById(String itemSpecId);

    String queryItemMainImgById(String itemId);
}
