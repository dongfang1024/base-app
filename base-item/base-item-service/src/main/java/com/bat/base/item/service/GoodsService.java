package com.bat.base.item.service;

import com.bat.base.item.bo.SpuBo;
import com.bat.common.pojo.PageResult;

public interface GoodsService {
    PageResult<SpuBo> pageQuerySpuBo(String key, Boolean saleable, Integer page, Integer rows);
}
