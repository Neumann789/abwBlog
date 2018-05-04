package com.abw.blog.service.req;

import java.util.Date;

/**
 * Created by fanghuabao on 2018/5/3 0003.
 */
public class CommentInfo {

    private Long id;

    private Long commentUserId;

    private String commentUserName;

    private Long toUserId;

    private String toUserName;

    private Long toCommentId;

    private Long contentId;

    private Long floorNum;

    private String forbidFlag;

    private String commentContent;

    private String commentClass;

    public Long getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Long commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public Long getToCommentId() {
        return toCommentId;
    }

    public void setToCommentId(Long toCommentId) {
        this.toCommentId = toCommentId;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Long getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Long floorNum) {
        this.floorNum = floorNum;
    }

    public String getForbidFlag() {
        return forbidFlag;
    }

    public void setForbidFlag(String forbidFlag) {
        this.forbidFlag = forbidFlag;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentClass() {
        return commentClass;
    }

    public void setCommentClass(String commentClass) {
        this.commentClass = commentClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
