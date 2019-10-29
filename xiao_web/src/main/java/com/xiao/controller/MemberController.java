package com.xiao.controller;

import com.github.pagehelper.PageInfo;
import com.xiao.domain.Member;
import com.xiao.domain.Shop;
import com.xiao.service.IShopService;
import com.xiao.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private IShopService shopService;

    @RequestMapping("/save.do")
    public String save(Member member)throws Exception{
        memberService.save(member);
        System.out.println(member);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,
        defaultValue = "1") Integer page,@RequestParam(value = "size",required = true,
        defaultValue = "4")Integer size)throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Member> memberList = memberService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(memberList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("member-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)Integer id)throws Exception{
        ModelAndView mv = new ModelAndView();
        System.out.println(id);
        Member member = memberService.findById(id);
        Date oldDate = member.getM_date();
        Date nowDate = new Date();
        long diff = nowDate.getTime() - oldDate.getTime();
        long days = diff / (1000 * 60 * 60 * 24);
        mv.addObject("days",days);
        mv.addObject("member",member);
        mv.setViewName("member-show");
        return mv;
    }

    @RequestMapping("/deleteById.do")
    public String deleteById(@RequestParam(name = "id",required = true)Integer id)throws Exception{
        System.out.println(id);
        memberService.deleteById(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/updateById.do")
    public ModelAndView updateById(@RequestParam(name = "id",required = true)Integer id)throws Exception{
        ModelAndView mv = new ModelAndView();
        Member member = memberService.findById(id);
        mv.addObject("member",member);
        mv.setViewName("member-update");
        return mv;
    }

    @RequestMapping("/update.do")
    public ModelAndView update(Member member)throws Exception{
        ModelAndView mv = new ModelAndView();
        memberService.update(member);
        Member newMember = memberService.findById(member.getM_id());
        mv.addObject("member",newMember);
        mv.setViewName("member-update");
        return mv;
    }

    @RequestMapping("/query.do")
    public ModelAndView query(@RequestParam(name = "queryId",required = true)Integer id,
                              @RequestParam(name = "queryValue",required = true)String value){
        ModelAndView mv = new ModelAndView();
        List<Member> members = memberService.query(id,value);
        mv.addObject("members",members);
        mv.setViewName("member-query-show");
        return mv;
    }

    @RequestMapping("/findByTel.do")
    public ModelAndView findByTel(String word){
        ModelAndView mv = new ModelAndView();
        System.out.println(word);
        List<Member> members = memberService.findByTel(word);
        List<Shop> shops = shopService.findAll();
        mv.addObject("members",members);
        mv.addObject("shops",shops);
        mv.setViewName("member-query-list");
        return mv;
    }

    @RequestMapping("/findByTel2.do")
    public ModelAndView findByTel2(String word){
        ModelAndView mv = new ModelAndView();
        List<Member> members = memberService.findByTel(word);
        List<Shop> shops = shopService.findAll();
        mv.addObject("members",members);
        mv.addObject("shops",shops);
        mv.setViewName("member-query-list2");
        return mv;
    }
}
