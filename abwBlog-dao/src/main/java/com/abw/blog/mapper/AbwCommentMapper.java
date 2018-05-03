package com.abw.blog.mapper;


import com.abw.blog.model.AbwComment;

public interface AbwCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AbwComment record);

    int insertSelective(AbwComment record);

    AbwComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AbwComment record);

    int updateByPrimaryKeyWithBLOBs(AbwComment record);

    int updateByPrimaryKey(AbwComment record);
}