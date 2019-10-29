package com.xiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.xiao.dao.IMemberDao;
import com.xiao.domain.Member;
import com.xiao.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.channels.MembershipKey;
import java.util.Date;
import java.util.List;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private IMemberDao memberDao;

    @Override
    public void save(Member member) throws Exception {
        Date time = new Date();
        member.setM_date(time);
        memberDao.save(member);
        System.out.println(member);
    }

    @Override
    public List<Member> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return memberDao.findAll();
    }

    @Override
    public List<Member> findAll() throws Exception {
        return memberDao.findAll();
    }

    @Override
    public Member findById(Integer id) {
        return memberDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        memberDao.deleteById(id);
    }

    @Override
    public void update(Member member) {
        memberDao.update(member);
    }

    @Override
    public List<Member> query(Integer id, String value) {
        /*<option value="0">名字</option>
        <option value="1">性别</option>
        <option value="2">学号</option>
        <option value="3">班级</option>
        <option value="4">系别</option>
        <option value="5">描述</option>
        <option value="6">电话</option>*/
        List<Member> members = null;
        if(id == 0){
            members = memberDao.queryByName("%"+value+"%");
        }else if(id == 1){
            int IntValue = 0;
            if(value.equals("女")){
                IntValue = 1;
                System.out.println(IntValue);
                members = memberDao.queryBySex(IntValue);
            }
            System.out.println(IntValue);
            members = memberDao.queryBySex(IntValue);
        }else if(id == 2){
            members = memberDao.queryByIdCard("%"+value+"%");
        }else if(id == 3){
            members = memberDao.queryByClass("%"+value+"%");
        }else if(id == 4){
            members = memberDao.queryByDept("%"+value+"%");
        }else if(id == 5){
            members = memberDao.queryByDesc("%"+value+"%");
        }else if(id == 6){
            members = memberDao.queryByTel("%"+value+"%");
        }else if(id == 7){
            members = memberDao.queryByVague("%"+value+"%");
        }
        return members;
    }

    @Override
    public List<Member> findByTel(String word) {
        return memberDao.queryByTel(word + "%");
    }
}
