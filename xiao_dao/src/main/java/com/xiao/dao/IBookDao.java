package com.xiao.dao;

import com.xiao.domain.Book;
import com.xiao.domain.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IBookDao {

    @Select("select * from category")
    List<Category> findCategory();

    @Insert("insert into book(book_isbn,book_name,book_price,book_public,book_author,book_year,book_count,book_date,c_id)values(#{book_isbn},#{book_name},#{book_price},#{book_public},#{book_author},#{book_year},#{book_count},#{book_date},#{c_id})")
    void save(Book book);

    @Select("select * from book")
    @Results({
            @Result(id=true,column = "book_id",property = "book_id"),
            @Result(column = "book_name",property = "book_name"),
            @Result(column = "book_price",property = "book_price"),
            @Result(column = "book_public",property = "book_public"),
            @Result(column = "book_author",property = "book_author"),
            @Result(column = "book_year",property = "book_year"),
            @Result(column = "book_count",property = "book_count"),
            @Result(column = "book_date",property = "book_date"),
            @Result(column = "book_borrow",property = "book_borrow"),
            @Result(column = "c_id",property = "category",
                one = @One(select = "com.xiao.dao.ICategoryDao.findById"))
    })
    List<Book> findAll();

    @Select("select * from book where book_isbn=#{id}")
    @Results({
            @Result(id=true,column = "book_isbn",property = "book_isbn"),
            @Result(column = "book_name",property = "book_name"),
            @Result(column = "book_price",property = "book_price"),
            @Result(column = "book_public",property = "book_public"),
            @Result(column = "book_author",property = "book_author"),
            @Result(column = "book_year",property = "book_year"),
            @Result(column = "book_count",property = "book_count"),
            @Result(column = "book_date",property = "book_date"),
            @Result(column = "book_borrow",property = "book_borrow"),
            @Result(column = "c_id",property = "category",
                    one = @One(select = "com.xiao.dao.ICategoryDao.findById")),
            @Result(column = "book_isbn",property = "borrows",
                    many = @Many(select = "com.xiao.dao.IBorrowDao.findByBookIsbn"))
    })
    Book findById(String id);

    @Update("update book set book_name=#{book_name},book_price=#{book_price},book_public=#{book_public},book_author=#{book_author},book_year=#{book_year},book_count=#{book_count},c_id=#{c_id} where book_isbn=#{book_isbn}")
    void update(Book book);

    /*<option value="0">年份</option>
        <option value="1">出版社</option>
        <option value="2">作者</option>
        <option value="3">书名</option>
        <option value="4">模糊</option>
        <option value="5">类别</option>*/

    @Select("select * from book where book_year like #{value}")
    List<Book> queryByYear(String value);
    @Select("select * from book where book_public like #{value}")
    List<Book> queryByPublic(String value);
    @Select("select * from book where book_author like #{value}")
    List<Book> queryByAuthor(String value);
    @Select("select * from book where book_name like #{value}")
    List<Book> queryByName(String value);

    @Select("select * from book where book_year like #{value} or book_public like #{value} or book_author like #{value} or book_name like #{value}")
    List<Book> queryByVague(String value);
    @Select("select * from book where c_id in (select c_id from category where c_name=#{value})")
    List<Book> queryByCategory(String value);

    @Select("select * from book where book_name=#{book} or book_isbn=#{book}")
    List<Book> queryBookByNameAndIsbn(String book);

    @Update("update book set book_borrow=book_borrow+1 where book_isbn=#{book_isbn}")
    void updateBorrow(String book_isbn);

    @Update("update book set book_borrow=book_borrow-1 where book_isbn=#{book_isbn}")
    void updateBack(String book_isbn);
}