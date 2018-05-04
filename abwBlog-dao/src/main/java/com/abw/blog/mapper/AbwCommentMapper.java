package com.abw.blog.mapper;


import com.abw.blog.model.AbwComment;

import java.util.List;

public interface AbwCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AbwComment record);

    int insertSelective(AbwComment record);

    AbwComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AbwComment record);

    int updateByPrimaryKeyWithBLOBs(AbwComment record);

    int updateByPrimaryKey(AbwComment record);

    List<AbwComment> selectCommentsByContentId(Long contentId);

    /**
     * 根据根评论信息查询子评论集合
     * @param record
     * @return
     */
    List<AbwComment> selectChildCommentsByRoot(AbwComment record);
}