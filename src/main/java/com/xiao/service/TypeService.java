package com.xiao.service;

import com.xiao.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    //删除返回空用void
    void deleteType(Long id);

    Type getTypeByName(String name);

    Type updateType(Long id,Type type);

}
