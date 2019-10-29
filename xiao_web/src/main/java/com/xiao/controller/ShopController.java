package com.xiao.controller;

import com.github.pagehelper.PageInfo;
import com.xiao.domain.Member;
import com.xiao.domain.Shop;
import com.xiao.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private IShopService shopService;

    @RequestMapping("/save.do")
    public String save(Shop shop)throws Exception{
        shopService.save(shop);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,
        defaultValue = "1")Integer page,@RequestParam(name = "size",required = true,
        defaultValue = "4")Integer size)throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Shop> shops = shopService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(shops);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("shop-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)Integer id)throws Exception{
        System.out.println(id);
        ModelAndView mv = new ModelAndView();
        Shop shop = shopService.findById(id);
        mv.addObject("shop",shop);
        mv.setViewName("shop-show");
        return mv;
    }

    @RequestMapping("/updatePage.do")
    public ModelAndView updateById(@RequestParam(name = "id",required = true)Integer id)throws Exception{
        ModelAndView mv = new ModelAndView();
        Shop shop = shopService.findById(id);
        mv.addObject("shop",shop);
        mv.setViewName("shop-update");
        return mv;
    }

    @RequestMapping("/update.do")
    public ModelAndView update(Shop shop)throws Exception{
        ModelAndView mv = new ModelAndView();
        shopService.update(shop);
        Shop shop1 = shopService.findById(shop.getShop_id());
        mv.addObject("shop",shop1);
        mv.setViewName("shop-update");
        return mv;
    }

    @RequestMapping("/query.do")
    public ModelAndView query(@RequestParam(name = "queryId",required = true)Integer id,
                              @RequestParam(name = "queryValue",required = true)String value){
        ModelAndView mv = new ModelAndView();
        List<Shop> shops = shopService.query(id,value);
        mv.addObject("shops",shops);
        mv.setViewName("shop-query-show");
        return mv;
    }
}
