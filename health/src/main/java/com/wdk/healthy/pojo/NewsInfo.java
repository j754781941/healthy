package com.wdk.healthy.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class NewsInfo implements Serializable {
    private static final long serialVersionUID = -7209866987944033586L;
    private Long id;
    @JSONField(name = "from_id")
    private String fromId;
    private String title;
    private String summary;
    @JSONField(name = "column_id")
    private String columnId;
    @JSONField(name = "column_name")
    private String columnName;
    @JSONField(name = "author_email")
    private String authorEmail;
    @JSONField(name = "author_avatar")
    private String authorAvatar;
    @JSONField(name = "post_id")
    private String postId;
    private String cover;
    private String content;
    @JSONField(name = "views_count")
    private Long viewsCount;
    @JSONField(name = "comments_count")
    private Long commentsCount;
    @JSONField(name = "published_at")
    private Date publishedAt;
    @JSONField(name = "store_at")
    private Date storeAt;
    private String type;
    @JSONField(name = "created_at")
    private Date createdAt;
    @JSONField(name = "updated_at")
    private Date updatedAt;

    public NewsInfo(Long id, String fromId, String title, String summary, String columnId, String columnName, String authorEmail, String authorAvatar, String postId, String cover, String content, Long viewsCount, Long commentsCount, Date publishedAt, Date storeAt, String type, Date createdAt, Date updatedAt) {
        this.id = id;
        this.fromId = fromId;
        this.title = title;
        this.summary = summary;
        this.columnId = columnId;
        this.columnName = columnName;
        this.authorEmail = authorEmail;
        this.authorAvatar = authorAvatar;
        this.postId = postId;
        this.cover = cover;
        this.content = content;
        this.viewsCount = viewsCount;
        this.commentsCount = commentsCount;
        this.publishedAt = publishedAt;
        this.storeAt = storeAt;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public NewsInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthorAvatar() {
        return authorAvatar;
    }

    public void setAuthorAvatar(String authorAvatar) {
        this.authorAvatar = authorAvatar;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Long viewsCount) {
        this.viewsCount = viewsCount;
    }

    public Long getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Long commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Date getStoreAt() {
        return storeAt;
    }

    public void setStoreAt(Date storeAt) {
        this.storeAt = storeAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
