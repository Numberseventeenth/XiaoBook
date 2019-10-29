package com.xiao.dao;

import com.xiao.domain.Member;
import com.xiao.domain.Record;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRecordDao {

    @Insert("insert into record(m_id,r_date,shop_id)values(#{m_id},#{r_date},#{shop_id})")
    void save(Record record);

    @Select("select * from record where m_id=#{id}")
    List<Record> findByMemberId(int id);

    @Select("select m_id,shop_id,max(r_date) as r_date,count(shop_id) as sum from record where m_id=#{id} group by shop_id")
    @Results({
            @Result(column = "m_id",property = "m_id"),
            @Result(column = "r_date",property = "r_date"),
            @Result(column = "shop_id",property = "shop_id"),
            @Result(column = "sum",property = "sum"),
            @Result(column = "shop_id",property = "shops",javaType = List.class,
                many = @Many(select = "com.xiao.dao.IShopDao.findById"))
    })
    List<Record> findById(Integer id);

    @Select("select m_id,shop_id,max(r_date) as r_date,count(m_id) as sum from record where shop_id=#{id} group by m_id")
    @Results({
            @Result(column = "m_id",property = "m_id"),
            @Result(column = "r_date",property = "r_date"),
            @Result(column = "shop_id",property = "shop_id"),
            @Result(column = "m_id",property = "members",javaType = List.class,
                    many = @Many(select = "com.xiao.dao.IMemberDao.findByMember"))
    })
    List<Record> findByNumber(int id);
}
