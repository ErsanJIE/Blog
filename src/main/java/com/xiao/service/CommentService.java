package com.xiao.service;

import com.xiao.po.Comment;

import java.util.List;

public interface CommentService {
    //获取评论列表
    List<Comment> listCommentByBlogId(Long BlogId);

    Comment saveComment(Comment comment);
}
