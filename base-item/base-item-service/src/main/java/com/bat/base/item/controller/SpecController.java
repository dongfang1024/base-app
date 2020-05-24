package com.bat.base.item.controller;

import com.bat.base.item.pojo.SpecGroup;
import com.bat.base.item.pojo.SpecParam;
import com.bat.base.item.service.SpecService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("spec")
@Slf4j
public class SpecController {

    @Autowired
    private SpecService specService;

    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroups(@PathVariable("cid") Long cid){
        log.info("queryGroups 入参：{}",cid);
        List<SpecGroup> specGroups = this.specService.queryGroups(cid);
        if(CollectionUtils.isEmpty(specGroups)){
            log.info("queryGroups query result is empty");
            return ResponseEntity.notFound().build();
        }
        log.info("queryGroups method end");
        return ResponseEntity.ok(specGroups);
    }

    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> querySpecParamsByGroupId(@RequestParam("gid")Long gid){
        log.info("spec/params start, params: {}", gid);
        List<SpecParam> specParams = this.specService.querySpecParamsByGroupId(gid);
        if(CollectionUtils.isEmpty(specParams)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(specParams);
    }
}
