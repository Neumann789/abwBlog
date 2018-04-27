package com.abw.blog.mapper;


import com.abw.blog.model.AbwConfig;

import java.util.List;

public interface AbwConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AbwConfig record);

    int insertSelective(AbwConfig record);

    AbwConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AbwConfig record);

    int updateByPrimaryKey(AbwConfig record);

    List<AbwConfig> selectAll();
}