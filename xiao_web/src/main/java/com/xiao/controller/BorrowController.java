package com.xiao.controller;

import com.github.pagehelper.PageInfo;
import com.xiao.domain.Book;
import com.xiao.domain.Borrow;
import com.xiao.service.BookService;
import com.xiao.service.IBorrowService;
import com.xiao.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/borrow")
@Transactional
public class BorrowController {

    @Autowired
    private IBorrowService borrowService;
    @Autowired
    private BookService bookService;


    @RequestMapping("/borrow.do")
    public String borrow(@RequestParam(name = "m_id",required = true)Integer m_id,
                         @RequestParam(name = "book_isbn",required = true)String book_isbn,
                         @RequestParam(name = "submitStatus",required = true)Integer status){

        if(status == 1){
            //借阅
            Borrow borrow = new Borrow();
            borrow.setM_id(m_id);
            borrow.setBook_isbn(book_isbn);
            Date StartDate = new Date();
            borrow.setB_start(StartDate);

            //end = start + 30天
            String startDateStr = DateUtils.date2String(StartDate,"yyyy-MM-dd HH:mm:ss");
            System.out.println("现在的日期是:" + startDateStr);
            Calendar ca = Calendar.getInstance();
            ca.add(Calendar.DATE,30);
            Date endDate = ca.getTime();
            String endDateStr = DateUtils.date2String(endDate,"yyyy-MM-dd HH:mm:ss");
            System.out.println("增加天数以后的日期：" + endDateStr);

            borrow.setB_end(endDate);

            borrowService.borrow(borrow);

            //借阅之后库存不变
            //book_borrow-1  数借出数-1
            //和修改图书信息冲突
            /*Book book = bookService.findById(book_isbn);
            book.setBook_borrow(book.getBook_borrow()+1);
            bookService.update(book);*/
            bookService.updateBorrow(book_isbn);
            System.out.println("借出一本");
        }
        if(status == 0){
            System.out.println(m_id);
            System.out.println(book_isbn);
            System.out.println(status);
            //归还
            //2.修改图书状态码
            borrowService.back(m_id,book_isbn);

            //归还之后book_borrow-1
            //和修改图书信息冲突
            /*Book book = bookService.findById(book_isbn);
            book.setBook_borrow(book.getBook_borrow()-1);
            bookService.update(book);*/
            bookService.updateBack(book_isbn);

            System.out.println("已归还");
        }
        return null;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,
            defaultValue = "1") Integer page,@RequestParam(value = "size",required = true,
            defaultValue = "4")Integer size){
        ModelAndView mv = new ModelAndView();
        List<Borrow> borrows = borrowService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(borrows);
        System.out.println(borrows);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("borrow-page-list");
        return mv;
    }

}
