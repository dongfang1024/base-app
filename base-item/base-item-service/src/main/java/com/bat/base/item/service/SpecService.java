package com.bat.base.item.service;

import com.bat.base.item.pojo.SpecGroup;
import com.bat.base.item.pojo.SpecParam;

import java.util.List;

public interface SpecService {

    List<SpecGroup> queryGroups(Long cid);

    List<SpecParam> querySpecParamsByGroupId(Long groupId);
}
