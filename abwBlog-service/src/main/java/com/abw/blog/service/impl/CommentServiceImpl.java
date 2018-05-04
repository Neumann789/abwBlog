package com.abw.blog.service.impl;

import com.abw.blog.common.BaseRsp;
import com.abw.blog.constant.Constants;
import com.abw.blog.mapper.AbwCommentMapper;
import com.abw.blog.mapper.AbwContentMapper;
import com.abw.blog.model.AbwComment;
import com.abw.blog.model.AbwContent;
import com.abw.blog.service.CommentService;
import com.abw.blog.service.req.CommentInfo;
import com.abw.blog.service.req.ContentInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanghuabao on 2018/5/3 0003.
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private AbwCommentMapper abwCommentMapper;

    @Autowired
    private AbwContentMapper abwContentMapper;

    public BaseRsp addComment(CommentInfo req){

        //获取文章信息
        AbwContent abwContent = abwContentMapper.selectByPrimaryKey(req.getContentId());
        Long currFloorNum = abwContent.getCurrFloorNum();//获取当前楼数
        AbwComment abwComment = new AbwComment();
        BeanUtils.copyProperties(req, abwComment);
        if(Constants.COMMENT_CLASS_R.equals(req.getCommentClass())){
            abwComment.setFloorNum(currFloorNum + 1);//对于根评论楼层加一
            abwComment.setCommentClass(Constants.COMMENT_CLASS_R);
            abwCommentMapper.insert(abwComment);
            abwContentMapper.incrCurrFloorNum(abwContent.getId());
        }else if(Constants.COMMENT_CLASS_C.equals(req.getCommentClass())){
            abwComment.setFloorNum(currFloorNum);//对于子评论楼层不变
            abwComment.setCommentClass(Constants.COMMENT_CLASS_C);
            abwCommentMapper.insert(abwComment);
        }

        //更新评论数
        abwContentMapper.incrCommentNum(abwContent.getId());


        return BaseRsp.returnSuccss(req);
    }

    @Override
    public BaseRsp queryCommentListByContent(ContentInfo req) {

        List<AbwComment> abwCommentList = abwCommentMapper.selectCommentsByContentId(req.getId());

        abwCommentList.forEach(abc -> {
            AbwComment abwComment = new AbwComment();
            abwComment.setContentId(abc.getContentId());
            abwComment.setToCommentId(abc.getId());
            List<AbwComment> childCommentList= abwCommentMapper.selectChildCommentsByRoot(abwComment);
            abc.setChildCommentList(childCommentList);
        });

        return BaseRsp.returnSuccss(abwCommentList);
    }

    /**
     * 获取根评论下所有的子评论，并按时间的降序排列
     * @param req
     * @return
     */
    @Override
    public BaseRsp queryChildCommentsByRoot(CommentInfo req) {
        AbwComment abwComment = new AbwComment();
        abwComment.setContentId(req.getContentId());
        abwComment.setToCommentId(req.getId());
        List<AbwComment> abwCommentList = abwCommentMapper.selectChildCommentsByRoot(abwComment);
        return BaseRsp.returnSuccss(abwCommentList);
    }
}
