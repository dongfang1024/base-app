package com.bat.base.item.service.impl;

import com.bat.base.item.mapper.SpecGroupMapper;
import com.bat.base.item.mapper.SpecParamMapper;
import com.bat.base.item.pojo.SpecGroup;
import com.bat.base.item.pojo.SpecParam;
import com.bat.base.item.service.SpecService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecServiceImpl implements SpecService {


    @Resource
    private SpecGroupMapper specGroupMapper;

    @Resource
    private SpecParamMapper specParamMapper;

    @Override
    public List<SpecGroup> queryGroups(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        return this.specGroupMapper.select(specGroup);
    }

    @Override
    public List<SpecParam> querySpecParamsByGroupId(Long groupId) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(groupId);
        return this.specParamMapper.select(specParam);
    }
}
