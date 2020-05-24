package com.bat.base.item.bo;

import com.bat.base.item.pojo.Spu;
import lombok.Data;

import java.io.Serializable;

@Data
public class SpuBo extends Spu {

    private static final Long serialVersionUID = 1L;

    private String cname;
    private String bname;
}
