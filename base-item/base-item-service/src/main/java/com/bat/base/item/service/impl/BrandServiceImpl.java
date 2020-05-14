package com.bat.base.item.service.impl;

import com.bat.base.item.mapper.BrandMapper;
import com.bat.base.item.pojo.Brand;
import com.bat.base.item.service.BrandService;
import org.springframework.stereotype.Service;

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
}
