package com.xiao.service;

import com.xiao.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface TagService {

    Tag saveTag(Tag type);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    Tag updateTag(Long id, Tag type);

    void deleteTag(Long id);

    List<Tag> listTag();

    //新增博客获取id
    List<Tag>listTag(String ids);

    List<Tag>listTagTop(Integer size);

}
