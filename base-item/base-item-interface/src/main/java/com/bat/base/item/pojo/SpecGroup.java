package com.bat.base.item.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name ="tb_spec_group")
@Data
public class SpecGroup implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cid;
    private String name;

    @Transient
    private List<SpecParam> params;

}
