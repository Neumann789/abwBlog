package com.abw.blog.mapper;

import com.abw.blog.model.AbwUser;

public interface AbwUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AbwUser record);

    int insertSelective(AbwUser record);

    AbwUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AbwUser record);

    int updateByPrimaryKey(AbwUser record);

    AbwUser getUserByUserNameOrNickName(String name);
}