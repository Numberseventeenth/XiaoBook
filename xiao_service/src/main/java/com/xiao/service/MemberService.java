package com.xiao.service;

import com.xiao.domain.Member;

import java.util.List;

public interface MemberService {


    void save(Member member)throws Exception;

    List<Member> findAll(Integer page, Integer size)throws Exception;

    List<Member> findAll() throws Exception;

    Member findById(Integer id);

    void deleteById(Integer id);

    void update(Member member);

    List<Member> query(Integer id, String value);

    List<Member> findByTel(String word);
}
