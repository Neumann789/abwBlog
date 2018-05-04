package com.abw.blog.controller;

import com.abw.blog.common.BaseRsp;
import com.abw.blog.service.CommentService;
import com.abw.blog.service.req.CommentInfo;
import com.abw.blog.service.req.ContentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fanghuabao on 2018/5/4 0004.
 */
@RestController
@RequestMapping("/abwBlog")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/addComment")
    public BaseRsp addComment(@RequestBody CommentInfo req){
        return commentService.addComment(req);
    }

    @RequestMapping(value = "/getCommentListByContent")
    public BaseRsp getCommentListByContent(@RequestBody ContentInfo req){
        return commentService.queryCommentListByContent(req);
    }

    @RequestMapping(value = "/queryChildCommentsByRoot")
    public BaseRsp queryChildCommentsByRoot(@RequestBody CommentInfo req){
        return commentService.queryChildCommentsByRoot(req);
    }

}
