package com.bat.base.item.mapper;

import com.bat.base.item.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<Category> {

    @Select({
            "<script>",
                "select *",
                "from tb_category",
                "where id in",
                "<foreach collection='ids' item='id' open='(' separator=',' close=')'>",
                    "#{id}",
                "</foreach>",
            "</script>"
    })
    List<Category> queryCategoriesByIds(@Param("ids")List<Long> ids);
}
