package com.abw.blog.service;

import com.abw.blog.common.BaseRsp;
import com.abw.blog.service.req.ContentInfo;

/**
 * Created by fanghuabao on 2018/4/25 0025.
 * 提供内容相关服务
 */
public interface ContentService {

    /**
     * 保存内容
     * @return
     */
    public BaseRsp registContent(ContentInfo contentInfo);

    /**
     * 获取内容集合
     * @param contentInfo
     * @return
     */
    public BaseRsp searchContentList(ContentInfo contentInfo);


    /**
     * 获取单笔内容
     * @param contentInfo
     * @return
     */
    public BaseRsp searchSingleContent(ContentInfo contentInfo);

}
