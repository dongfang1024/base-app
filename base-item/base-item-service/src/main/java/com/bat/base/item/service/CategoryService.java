package com.bat.base.item.service;

import com.bat.base.item.pojo.Category;

import java.util.List;

public interface CategoryService {

    List<Category> queryCategoriesByPid(Long pid);

    //根据id的list查出名称的list
    List<Category> queryCategoriesByIds(List<Long> ids);
}
