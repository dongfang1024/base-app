package com.bat.base.item.service.impl;

import com.bat.base.item.mapper.BrandMapper;
import com.bat.base.item.pojo.Brand;
import com.bat.base.item.service.BrandService;
import com.bat.common.pojo.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Override
    public List<Brand> queryBrands() {
        return this.brandMapper.selectAll();
    }

    /**
     * 根据查询条件，分页、排序查询品牌
     * @param key
     * @param page
     * @param rows
     * @param orderBy
     * @param desc
     * @return
     */
    @Override
    public PageResult<Brand> pageQueryBrands(String key, Integer page, Integer rows, String orderBy, Boolean desc) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        //1.条件
        if(StringUtils.isNotBlank(key)){
            criteria.andLike("name","%"+key+"%").orEqualTo("letter", key);
        }
        //2.分页
        PageHelper.startPage(page ,rows);
        //2.1.排序
        if(StringUtils.isNotBlank(orderBy)){
            example.setOrderByClause(orderBy+" "+ (desc?"asc":"desc"));
        }
        List<Brand> brandList = this.brandMapper.selectByExample(example);
        PageInfo<Brand> pageInfo = new PageInfo<>(brandList);
        //3.包装结果
        //PageResult<Brand> result
        return new PageResult<>(brandList, pageInfo.getTotal(), pageInfo.getPages());
    }
}
