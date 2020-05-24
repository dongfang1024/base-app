package com.bat.base.item.service;

import com.bat.base.item.pojo.Brand;
import com.bat.common.pojo.PageResult;

import java.util.List;

public interface BrandService {

    Brand queryBrandById(Long id);

    List<Brand> queryBrands();

    PageResult<Brand> pageQueryBrands(String key, Integer page, Integer rows, String orderBy, Boolean desc);

    void addBrand(Brand brand, List<Long> cid);
}
