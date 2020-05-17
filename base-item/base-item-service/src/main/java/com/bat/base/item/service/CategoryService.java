package com.bat.base.item.service;

import com.bat.base.item.pojo.Category;

import java.util.List;

public interface CategoryService {

    List<Category> queryCategoriesByPid(Long pid);
}
