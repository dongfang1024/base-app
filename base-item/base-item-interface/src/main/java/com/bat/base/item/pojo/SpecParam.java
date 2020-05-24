package com.bat.base.item.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name="tb_spec_param")
public class SpecParam implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cid;
    private Long groupId;
    private String name;
    @Column(name="`numeric`")
    private Boolean numeric;
    private String unit;
    private Boolean generic;
    private Boolean searching;
    private String segments;
}
