package com.abw.blog.mapper;


import com.abw.blog.model.AbwContent;

import java.util.List;

public interface AbwContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AbwContent record);

    int insertSelective(AbwContent record);

    AbwContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AbwContent record);

    int updateByPrimaryKeyWithBLOBs(AbwContent record);

    int updateByPrimaryKey(AbwContent record);

    List<AbwContent> searchContentList(AbwContent record);
}