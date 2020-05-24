package com.bat.base.item.service.impl;

import com.bat.base.item.bo.SpuBo;
import com.bat.base.item.mapper.SpuMapper;
import com.bat.base.item.pojo.Brand;
import com.bat.base.item.pojo.Category;
import com.bat.base.item.pojo.Spu;
import com.bat.base.item.service.BrandService;
import com.bat.base.item.service.CategoryService;
import com.bat.base.item.service.GoodsService;
import com.bat.common.pojo.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    //@Override
    public PageResult<SpuBo> pageQuerySpuBo01(String key, Boolean saleable, Integer page, Integer rows){
        // 分页条件
        PageHelper.startPage(page, rows);
        // 执行查询
        //List<Spu> spuList = this.spuMapper.selectByExample(example);
        List<Spu> spuList = this.spuMapper.pageQuerySpuBo(key,saleable);
        PageInfo<Spu> pageInfo = new PageInfo<>(spuList);

        List<SpuBo> spuBoList = spuList.stream().map(item ->{
            SpuBo spuBo = new SpuBo();
            BeanUtils.copyProperties(item, spuBo);
            //1.查cname
            List<Long> cids = Arrays.asList(item.getCid1(), item.getCid2(), item.getCid3());
            List<Category> categoryList = this.categoryService.queryCategoriesByIds(cids);
            String categoryNames="";
            if(!CollectionUtils.isEmpty(categoryList)){
                for (Category category : categoryList) {
                    categoryNames+=category.getName()+"/";
                }
            }
            if(StringUtils.isNotBlank(categoryNames)){
                categoryNames = categoryNames.substring(0,categoryNames.length() -1);
            }
            spuBo.setCname(categoryNames);
            //2.查bname
            Brand brand  = this.brandService.queryBrandById(item.getBrandId());
            if(brand!=null){
                spuBo.setBname(brand.getName());
            }
            return spuBo;
        }).collect(Collectors.toList());
        return new PageResult<>(spuBoList, pageInfo.getTotal());
    }

    @Override
    public PageResult<SpuBo> pageQuerySpuBo(String key, Boolean saleable, Integer page, Integer rows) {
        Example example = new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(key)){
            log.info("pageQuerySpuBo查询的key为: {}", key);
            criteria.andLike("title", "%"+key+"%");
        }
        if(saleable!=null){
            log.info("pageQuerySpuBo查询的saleable为: {}", saleable);
            criteria.andEqualTo("saleable", saleable);
        }
        PageHelper.startPage(page, rows);
        List<Spu> spuList = this.spuMapper.selectByExample(example);
        PageInfo<Spu> pageInfo = new PageInfo<>(spuList);

        //转为List<SpuBo>


        List<SpuBo> spuBoList = spuList.stream().map(item ->{
            SpuBo spuBo = new SpuBo();
            BeanUtils.copyProperties(item, spuBo);
            //1.查cname
            List<Long> cids = Arrays.asList(item.getCid1(), item.getCid2(), item.getCid3());
            List<Category> categoryList = this.categoryService.queryCategoriesByIds(cids);
            String categoryNames="";
            for (Category category : categoryList) {
                categoryNames+=category.getName()+"/";
            }
            if(StringUtils.isNotBlank(categoryNames)){
                categoryNames = categoryNames.substring(0,categoryNames.length() -1);
            }
            spuBo.setCname(categoryNames);
            //2.查bname
            Brand brand  = this.brandService.queryBrandById(item.getBrandId());
            if(brand!=null){
                spuBo.setBname(brand.getName());
            }
            return spuBo;
        }).collect(Collectors.toList());
        return new PageResult<>(spuBoList, pageInfo.getTotal());
    }


}
