package com.xiao.dao;

import com.xiao.domain.Category;
import org.apache.ibatis.annotations.Select;

public interface ICategoryDao {

    @Select("select * from category where c_id=#{id}")
    Category findById(int id);
}
