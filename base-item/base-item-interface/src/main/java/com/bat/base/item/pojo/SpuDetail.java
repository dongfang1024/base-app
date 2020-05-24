package com.bat.base.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "tb_spu_detail")
@Data
public class SpuDetail implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    private Long spuId;
    private String description;
    private String specialSpec;
    private String genericSpec;
    private String packingList;
    private String afterService;

}
