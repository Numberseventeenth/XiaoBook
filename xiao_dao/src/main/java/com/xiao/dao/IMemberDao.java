package com.xiao.dao;

import com.xiao.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IMemberDao {

    @Insert("insert into member(m_name,m_sex,m_idcard,m_class,m_tel,m_dept,m_desc,m_date)values(#{m_name},#{m_sex},#{m_idcard},#{m_class},#{m_tel},#{m_dept},#{m_desc},#{m_date})")
    void save(Member member)throws Exception;

    @Select("select * from member")
    List<Member> findAll()throws Exception;

    @Select("select * from member where m_id=#{id}")
    @Results({
            @Result(id = true,column = "m_id",property = "m_id"),
            @Result(column = "m_name",property = "m_name"),
            @Result(column = "m_sex",property = "m_sex"),
            @Result(column = "m_idcard",property = "m_idcard"),
            @Result(column = "m_class",property = "m_class"),
            @Result(column = "m_dept",property = "m_dept"),
            @Result(column = "m_desc",property = "m_desc"),
            @Result(column = "m_tel",property = "m_tel"),
            @Result(column = "m_date" ,property = "m_date"),
            @Result(column = "m_status",property = "m_status"),
            @Result(column = "m_grade",property = "m_grade"),
            @Result(column = "m_integral",property = "m_integral"),
            @Result(column = "m_id",property = "records",javaType = List.class,
                many = @Many(select = "com.xiao.dao.IRecordDao.findById"))
    })
    Member findById(Integer id);



    @Delete("delete from member where m_id=#{id}")
    void deleteById(Integer id);

    @Update("update member set m_name=#{m_name},m_sex=#{m_sex},m_idcard=#{m_idcard},m_class=#{m_class},m_tel=#{m_tel},m_dept=#{m_dept},m_desc=#{m_desc},m_status=#{m_status} where m_id=#{m_id}")
    void update(Member member);

    @Select("select * from member where m_name like #{value}")
    List<Member> queryByName(String value);

    @Select("select * from member where m_sex=#{value}")
    List<Member> queryBySex(int value);

    @Select("select * from member where m_idcard like #{value}")
    List<Member> queryByIdCard(String value);

    @Select("select * from member where m_class like #{value}")
    List<Member> queryByClass(String value);

    @Select("select * from member where m_dept like #{value}")
    List<Member> queryByDept(String value);

    @Select("select * from member where m_desc like #{value}")
    List<Member> queryByDesc(String value);

    @Select("select * from member where m_tel like #{value}")
    List<Member> queryByTel(String value);


    @Select("select * from member where m_id=#{id}")
    List<Member> findByMember(int id);

    @Select("select * from member where m_name like #{value} or m_idcard like #{value} or m_class like #{value} or m_dept like #{value} or m_desc like #{value} or m_tel like #{value}")
    List<Member> queryByVague(String s);
}
