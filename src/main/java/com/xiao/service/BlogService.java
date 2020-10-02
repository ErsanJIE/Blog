package com.xiao.service;

import com.xiao.po.Blog;
import com.xiao.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {

    Blog getBlog(Long id);
    //分页查询管理博客
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);
    //分页查询主页博客
    Page<Blog> listBlog(Pageable pageable);
    //分页查询主页博客查询
    Page<Blog> listBlog(String query,Pageable pageable);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);

    List<Blog> listRecommendBlogTop(Integer size);

    //前端展示
    Blog getAndConvert(Long id);

    //前端展示tag标签中的分页查询
    Page<Blog> listBlog(Long TagId,Pageable pageable);
    //归档接口,String对应年份，List里面对应着属性列表
    Map<String,List<Blog>> archiveBlog();
    Long countBlog();
}
