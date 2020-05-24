package com.bat.base.item.service.impl;

import com.bat.base.item.mapper.CategoryMapper;
import com.bat.base.item.pojo.Category;
import com.bat.base.item.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 根据父节点查询子节点
     * @param pid
     * @return
     */
    @Override
    public List<Category> queryCategoriesByPid(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        return this.categoryMapper.select(category);
    }

    @Override
    public List<Category> queryCategoriesByIds(List<Long> ids) {
        return this.categoryMapper.queryCategoriesByIds(ids);
    }
}
