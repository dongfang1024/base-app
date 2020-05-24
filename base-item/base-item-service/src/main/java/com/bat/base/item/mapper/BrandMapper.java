package com.bat.base.item.mapper;

import com.bat.base.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface BrandMapper extends Mapper<Brand> {

    @Insert("Insert into tb_category_brand(category_id, brand_id) values(#{categoryId}, #{brandId});")
    int insertCategoryBrand(@Param("categoryId")Long categoryId,@Param("brandId")Long brandId);
}
