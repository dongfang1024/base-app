package com.bat.base.item.controller;

import com.bat.base.item.pojo.Category;
import com.bat.base.item.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(@RequestParam(value="pid", defaultValue = "0")Long pid){
        logger.info("queryCategoriesByPid 开始");
        //1、校验
        if(pid ==null || pid.longValue()<0){
            return ResponseEntity.badRequest().build();
        }
        List<Category> categoryList = this.categoryService.queryCategoriesByPid(pid);
        logger.info("从数据库查询：{}",categoryList);
        if(CollectionUtils.isEmpty(categoryList)){
            return ResponseEntity.notFound().build();
        }
        logger.info("queryCategoriesByPid 结束");
        return ResponseEntity.ok(categoryList);
    }


}
