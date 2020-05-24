package com.bat.base.item.mapper;

import com.bat.base.item.pojo.Spu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpuMapper extends Mapper<Spu> {

    @Select({"<script>",
                "select *",
                "from tb_spu",
                "where 1=1",
                "<when test='key!=null and key!=\"\"'>",
                    "and title like '%'+#{key}+'%'",
                "</when>",
                "<when test='saleable!=null'>",
                    "and saleable = #{saleable}",
                "</when>",
            "</script>"
    })
    List<Spu> pageQuerySpuBo(@Param("key")String key, @Param("saleable")Boolean saleable );
}
