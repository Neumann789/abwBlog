package com.abw.blog.service.impl;

import com.abw.blog.common.BaseRsp;
import com.abw.blog.mapper.AbwContentMapper;
import com.abw.blog.model.AbwContent;
import com.abw.blog.service.ContentService;
import com.abw.blog.service.req.ContentInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanghuabao on 2018/4/25 0025.
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private AbwContentMapper abwContentMapper;

    @Override
    public BaseRsp registContent(ContentInfo contentInfo) {
        saveContent(contentInfo);
        return BaseRsp.returnSuccss();
    }

    @Override
    public BaseRsp searchContentList(ContentInfo contentInfo) {
        AbwContent record = new AbwContent();
        BeanUtils.copyProperties(contentInfo, record);
        List<AbwContent> contentList = abwContentMapper.searchContentList(record);
        return BaseRsp.returnSuccss(contentList);
    }

    private void saveContent(ContentInfo contentInfo){

        AbwContent record = new AbwContent();
        BeanUtils.copyProperties(contentInfo,record);
        abwContentMapper.insert(record);

    }
}
