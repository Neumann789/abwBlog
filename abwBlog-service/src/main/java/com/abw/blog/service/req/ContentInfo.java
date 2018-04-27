package com.abw.blog.service.req;

import java.util.Date;

/**
 * Created by fanghuabao on 2018/4/25 0025.
 */
public class ContentInfo {

    private Long id;

    private String source;

    private String category;

    private String title;

    private String themeImage;

    private String themeVideo;

    private String tags;

    private Long userId;

    private String content;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThemeImage() {
        return themeImage;
    }

    public void setThemeImage(String themeImage) {
        this.themeImage = themeImage;
    }

    public String getThemeVideo() {
        return themeVideo;
    }

    public void setThemeVideo(String themeVideo) {
        this.themeVideo = themeVideo;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
