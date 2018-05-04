package com.abw.blog.service;

import com.abw.blog.common.BaseRsp;
import com.abw.blog.service.req.CommentInfo;
import com.abw.blog.service.req.ContentInfo;

/**
 * Created by fanghuabao on 2018/5/3 0003.
 */
public interface CommentService {

    public BaseRsp addComment(CommentInfo req);

    public BaseRsp queryCommentListByContent(ContentInfo req);

    public BaseRsp queryChildCommentsByRoot(CommentInfo req);
}
