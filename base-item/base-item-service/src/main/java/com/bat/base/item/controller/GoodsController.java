package com.bat.base.item.controller;

import com.bat.base.item.bo.SpuBo;
import com.bat.base.item.service.GoodsService;
import com.bat.common.pojo.PageResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("spu/page")
    public ResponseEntity<PageResult<SpuBo>> pageQuerySpuBo(
            @RequestParam(value = "key", required = false)String key,
            @RequestParam(value = "saleable", required = false)Boolean saleable,
            @RequestParam(value = "page", defaultValue = "1")Integer page,
            @RequestParam(value = "rows", defaultValue = "10")Integer rows
    ){
        try {
            log.info("spu/page, params: key = {}, saleable = {}, page = {},rows = {}", key, saleable, page, rows);
            PageResult<SpuBo>  spuBoPageResult=this.goodsService.pageQuerySpuBo(key, saleable, page, rows);
            if(CollectionUtils.isEmpty(spuBoPageResult.getItems())){
                log.info("spu/page, the result of query is nothing.");
                return ResponseEntity.notFound().build();
            }
            log.info("spu/page result: {}", this.objectMapper.writeValueAsString(spuBoPageResult));
            return ResponseEntity.ok(spuBoPageResult);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
