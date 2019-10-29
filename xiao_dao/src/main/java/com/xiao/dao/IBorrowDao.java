package com.xiao.dao;

import com.xiao.domain.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IBorrowDao {

    @Insert("insert into borrow(m_id,b_start,b_end,book_isbn)values(#{m_id},#{b_start},#{b_end},#{book_isbn})")
    void borrow(Borrow borrow);

    @Update("UPDATE borrow SET b_status=0,b_back=NOW() WHERE m_id=#{m_id} AND book_isbn=#{book_isbn}")
    void back(@Param("m_id") Integer m_id, @Param("book_isbn") String book_isbn);

    @Select("select * from borrow where book_isbn=#{book_isbn}")
    @Results({
            @Result(column = "m_id",property = "m_id"),
            @Result(column = "b_start",property = "b_start"),
            @Result(column = "b_day",property = "b_day"),
            @Result(column = "b_end",property = "b_end"),
            @Result(column = "b_status",property = "b_status"),
            @Result(column = "book_isbn",property = "book_isbn"),
            @Result(column = "b_back",property = "b_back"),
            @Result(column = "m_id",property = "members",
                    javaType = List.class,
                    many = @Many(select = "com.xiao.dao.IMemberDao.findById"))
    })
    List<Borrow> findByBookIsbn(String book_isbn);

    @Select("select * from borrow")
    @Results({
            @Result(column = "m_id",property = "m_id"),
            @Result(column = "b_start",property = "b_start"),
            @Result(column = "b_day",property = "b_day"),
            @Result(column = "b_end",property = "b_end"),
            @Result(column = "b_status",property = "b_status"),
            @Result(column = "book_isbn",property = "book_isbn"),
            @Result(column = "b_back",property = "b_back"),
            @Result(column = "m_id",property = "member",
                    one = @One(select = "com.xiao.dao.IMemberDao.findById")),
            @Result(column = "book_isbn",property = "book",
                    one = @One(select = "com.xiao.dao.IBookDao.findById")),
    })
    List<Borrow> findAll();
}
