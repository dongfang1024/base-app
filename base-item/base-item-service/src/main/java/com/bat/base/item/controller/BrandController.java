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

    public void bubbleSort(int[] arr){
        System.out.println("冒泡排序");
        for(int i=0; i<arr.length-1; i++){
            for(int j=i; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    arr[j]+=arr[j+1];
                    arr[j+1] = arr[j]-arr[j+1];
                    arr[j]-=arr[j+1];
                }
            }
        }
    }

    /**
     * 终极版冒泡排序
     * 加入一个布尔变量,如果内循环没有交换值,说明已经排序完成,提前终止
     * @param arr
     */
    public static void sortPlus(int[] arr){
        if(arr != null && arr.length > 1){
            for(int i = 0; i < arr.length - 1; i++){
                // 初始化一个布尔值
                boolean flag = true;
                for(int j = 0; j < arr.length - i - 1 ; j++){
                    if(arr[j] > arr[j+1]){
                        // 调换
                        int temp;
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        // 改变flag
                        flag = false;
                    }
                }
                if(flag){
                    break;
                }
            }
        }
    }

    public void doNothing(){
        System.out.println("Monday");
        System.out.println("周二");
        System.out.println("周三");
        System.out.println("Thursday");
        System.out.println("Firday");
    }


}
