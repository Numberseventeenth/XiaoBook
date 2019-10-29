package com.xiao.dao;

import com.xiao.domain.Shop;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IShopDao {

    @Insert("insert into shop(shop_name,shop_tel,shop_discounts,shop_number)values(#{shop_name},#{shop_tel},#{shop_discounts},#{shop_number})")
    void save(Shop shop);

    @Select("select * from shop")
    List<Shop> findAll();

    @Select("select * from shop where shop_id=#{id}")
    List<Shop> findById(int id);

    @Select("select * from shop where shop_id=#{id}")
    @Results({
            @Result(id = true,column = "shop_id",property = "shop_id"),
            @Result(column = "shop_name",property = "shop_name"),
            @Result(column = "shop_tel",property = "shop_tel"),
            @Result(column = "shop_discounts",property = "shop_discounts"),
            @Result(column = "shop_number",property = "shop_number"),
            @Result(column = "shop_id",property = "records",javaType = List.class,
                many = @Many(select = "com.xiao.dao.IRecordDao.findByNumber"))
    })
    Shop findByIdWithMember(Integer id);

    @Update("update shop set shop_name=#{shop_name},shop_tel=#{shop_tel},shop_discounts=#{shop_discounts},shop_number=#{shop_number} where shop_id=#{shop_id}")
    void update(Shop shop);

    @Select("select * from shop where shop_name like #{value}")
    List<Shop> findByName(String value);

    @Select("select * from shop where shop_tel like #{value}")
    List<Shop> findByTel(String value);

    @Select("select * from shop where shop_discounts like #{value}")
    List<Shop> findByDiscounts(String value);

    @Select("select * from shop where shop_number like #{value}")
    List<Shop> findByNumber(String value);
}
