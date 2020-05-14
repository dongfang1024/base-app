package com.bat.base.item.controller;

import com.bat.base.item.pojo.Brand;
import com.bat.base.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("selectAll")
    public ResponseEntity<List<Brand>> selectAll(){
        List<Brand> brandList = this.brandService.queryBrands();
        if(CollectionUtils.isEmpty(brandList)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(brandList);
    }
}
